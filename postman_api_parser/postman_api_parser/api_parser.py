#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 11 10:55:06 2020

@author: seanlucas
"""

from pathlib import Path
import argparse
import json
import os
import re

from properties import Properties

#index of the current description being parsed for properties
desc_i = 0
comment_count = 0

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument('infile', help="Postman API JSON file")
    parser.add_argument('-r', '--report', action="store_true", help="Flag to output a QA report.")
    parser.add_argument('-o', '--out', help="Output directory, defaults to current working directory.", default=os.getcwd())

    args = parser.parse_args()
    _parse(args.infile, args.out, args.report)
    
def _parse(infile, out, report):
    print("Parsing API JSON file [" + os.path.basename(infile) + "].")
    with open(infile) as collection_file:
        collection_json = json.load(collection_file)
        
    tags = []
    property_list = []
    for description in _get_descriptions(collection_json):
        _parse_description(description, property_list, tags)
    
    tag_property = _convert_tags_to_property(tags)
    property_list.append(tag_property)
    properties = Properties(property_list)
        
    parsed_dict = {}
    parsed_dict["properties"] = properties.get_properties()
    
    print("COMPLETE")
    parsed_file = open(out + "/" + Path(infile).stem + "_parsed.json", 'w')
    parsed_file.write(json.dumps(parsed_dict, indent=4))
    print("Properties output as [" + Path(infile).stem + "_parsed.json].")
    if report:
        report = open(out + "/" + Path(infile).stem + "_report.json", 'w')
        report.write(json.dumps(properties.get_report(), indent=4))
        print("QA report output as [" + Path(infile).stem + "_report.json].")
    
def _convert_tags_to_property(tags):
    tag_dict = {}
    if len(tags) > 0:
        tag_dict["coverage"] = {}
        tag_dict["coverage"]["topics"] = {}
        
    for tag in tags:
        topics = tag_dict["coverage"]["topics"]
        tag_subjects = re.split('\.|:', tag)
        
        sub_topics = []
        if topics.get(tag_subjects[0]) is not None:
            sub_topics = topics[tag_subjects[0]]
            
        for i, tag_subject in enumerate(tag_subjects):
            if i > 0:
                sub_topics.append(tag_subject)
        topics[tag_subjects[0]] = sub_topics
    
    return tag_dict
                
def _get_descriptions(json_str, descriptions=[]): 
    for k, v in json_str.items():
        if k == "description":
            descriptions.append(v)
        if isinstance(v, dict): 
            _get_descriptions(v, descriptions)
        elif isinstance(v, list):
            for v1 in v:
                if isinstance(v1, dict): 
                    _get_descriptions(v1, descriptions)
    return descriptions

def _parse_description(description, all_properties, tags):
    global desc_i
    desc_i = 0
    
    words = description.split()
    word_count = len(words)
    while desc_i < word_count:
        word = words[desc_i].strip('\"')
            
        if word.startswith("<!--"):
             _build_comment(all_properties, words)
        elif word.startswith('#') and not word.startswith('##'):
            print("Tag [" + word + "] found.")
            tags.append(word)
           
        desc_i += 1

def _build_comment(all_properties, words):
    global desc_i
    
    def _get_property_dict(content, properties, prop_count, i):
        if prop_count == 1:
            return content
        
        property_json = {}
        next_prop = properties[i]
        if i == prop_count - 1:
            property_json[next_prop] = content
        else:
            i += 1
            property_json[next_prop] = _get_property_dict(content, properties, prop_count, i)
        return property_json
       
    if _will_parse(words):
        global comment_count
        comment_count += 1
        #TODO could print out the path to the comment
        print("Postman comment [" + str(comment_count) + "] found, parsing properties.")
        
        property_tree = words[desc_i]
        properties = re.split('\.|:', property_tree)
        desc_i += 1
        
        content = _get_content(words)
        properties_json = _get_property_dict(content, properties, len(properties), 1)
            
        all_properties.append(properties_json)
        return 1
    return 0
        
def _will_parse(words):
    global desc_i
    
    #checks both "<!--postman" and "<!-- postman"
    if "postman" in words[desc_i]:
        return True
    elif "postman" in words[desc_i + 1]:
        desc_i += 1
        return True
    else:
        return False
        
def _get_content(words):
    global desc_i
    
    prefix = ""
    content = ""
    word = words[desc_i]
    while not word.endswith("-->"):
        content += prefix + word
        prefix = " "
        desc_i += 1
        word = words[desc_i]
    #incase any content is prepended to "-->"
    content += prefix + word[:-3]  
    
    #homoginizes content for simpler parsing
    if not content.startswith('{') and not content.endswith('}'):
        content = "{ " + content + " }"
    
    try:
        return json.loads(content)
    except ValueError:
        #removing {} as this is not an object
        return content[1:-2].strip()

if __name__ == '__main__':
    main()