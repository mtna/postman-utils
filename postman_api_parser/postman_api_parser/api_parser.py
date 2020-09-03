#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 11 10:55:06 2020

@author: seanlucas
"""

from functools import reduce
from pathlib import Path
import argparse
import json
import os
import re

from properties import Properties
from tag import Tag

#index of the current description being parsed for properties
desc_i = 0
comment_count = 0

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument('infile', help="Postman API JSON file")
    parser.add_argument('-o', '--out', help="Output directory, defaults to current working directory.", default=os.getcwd())

    args = parser.parse_args()
    _parse(args.infile, args.out)
    
def _parse(infile, out):
    print("Parsing API JSON file [" + os.path.basename(infile) + "].")
    with open(infile) as collection_file:
        collection_json = json.load(collection_file)
    tagword_to_object = {}
    all_properties = []
    _parse_collection(all_properties, tagword_to_object, collection_json)
    
    tag_dict = {}
    if len(tagword_to_object.items()) > 0:
        tag_dict["coverage"] = {}
        tag_dict["coverage"]["topics"] = {}
    for tag_word in tagword_to_object.keys():
        topics = tag_dict["coverage"]["topics"]
        tag_subjects = tag_word.split(':')
        
        sub_topics = []
        if topics.get(tag_subjects[0]) is not None:
            sub_topics = topics[tag_subjects[0]]
            
        for i, tag_subject in enumerate(tag_subjects):
            if i > 0:
                sub_topics.append(tag_subject)
        topics[tag_subjects[0]] = sub_topics
    
    all_properties.append(tag_dict)
    properties = _merge_properties(all_properties)
    prop = Properties(properties)
        
    parsed_dict = {}
    parsed_dict["properties"] = prop.get_properties()
    
    tag_file = open(out + "/" + Path(infile).stem + "_parsed.json", 'w')
    tag_file.write(json.dumps(parsed_dict, indent=4))

def _parse_collection(all_properties, tagword_to_object, collection_json):
    if collection_json.get("info") is not None:
        collection_info = collection_json["info"]
        if collection_info.get("description") is not None:
            _parse_description(all_properties, tagword_to_object, collection_info, "Collection")
        if collection_json.get("item") is not None:
            for item in collection_json["item"]:
                _parse_item(all_properties, tagword_to_object, item)
    
def _parse_item(all_properties, tagword_to_object, item):
    if item.get("item") is not None:
        if item.get("description") is not None:
            _parse_description(all_properties, tagword_to_object, item, "Folder")
        for sub_item in item["item"]:
            _parse_item(all_properties, tagword_to_object, sub_item)
    elif item.get("request") is not None:
        request = item["request"]
        if request.get("description") is not None:
            _parse_description(all_properties, tagword_to_object, request, "Request", name=item["name"], is_request=True)

def _parse_description(all_properties, tagword_to_object, item, item_type, name=None, is_request=False):
    global desc_i
    desc_i = 0
    
    words = item["description"].split()
    word_count = len(words)
    while desc_i < word_count:
        word = words[desc_i].strip('\"')
            
        if word.startswith("<!--"):
             _build_comment(all_properties, words)
        elif word.startswith('#') and not word.startswith('##'):
            _build_tag(tagword_to_object, item, is_request, name, item_type, word)
           
        desc_i += 1

def _build_tag(tagword_to_object, item, is_request, name, item_type, tag_word):
    print("Tag [" + tag_word + "] found, parsing.")
    resource = {}
    resource["name"] = name if name != None else item["name"]
    resource["resourceType"] = item_type
    
    if is_request:
        resource["requestMethod"] = item["method"]
        
    if tagword_to_object.get(tag_word) is None:
        tagword_to_object[tag_word] = Tag(tag_word)
    tag = tagword_to_object[tag_word];
    
    tag.add_resource(resource)
        
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
        print("Postman comment [" + str(comment_count) + "] found, parsing.")
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

def _merge_properties(all_properties):
    def _merge(props_a, props_b, path=None):
        if path is None: 
            path = []
        for key in props_b:
            if key in props_a:
                if isinstance(props_a[key], dict) and isinstance(props_b[key], dict):
                    _merge(props_a[key], props_b[key], path + [str(key)])
                elif props_a[key] == props_b[key]:
                    pass
                else:
                    props_a[key] = [props_a[key], props_b[key]]
                    print('WARNING: conflict at property [%s' % '.'.join(path + [str(key)]) + "], creating list of values.")
            else:
                props_a[key] = props_b[key]
        return props_a
    
    merged_properties = reduce(_merge, all_properties);
    
    return merged_properties
        
if __name__ == '__main__':
    main()