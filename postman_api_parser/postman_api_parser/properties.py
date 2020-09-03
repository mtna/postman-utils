#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Sep  2 11:41:03 2020

@author: seanlucas
"""

from functools import reduce
#import json
#from jsonschema import validate

class Properties:
    def __init__(self, properties):
        self.properties = _merge_properties(properties)
        self._set_levels()
        
    def get_properties(self):
        #with open("./resources/schema.json") as schema_file:
            #schema = json.load(schema_file)
        #TODO wait until schema is more complete
        #validate(instance=self.properties, schema=schema)
        return self.properties
    
    def get_report(self):
        def _set_level(prop, level):
            report[prop] = {}
            report[prop]["completeness"] = level
            
        report = {}
        _set_level("custodian", self.custodian_level)
        _set_level("coverage", self.coverage_level)
        _set_level("provenance", self.provenance_level)
        _set_level("profile", self.profile_level)
        _set_level("resources", self.resources_level)
        
        report["provenance"]["source_count"] = self._get_count(self.provenance_level, ["provenance", "sources"])
        report["resources"]["resource_count"] = self._get_count(self.resources_level, ["resources"])
        self._get_topic_counts()
        report["coverage"]["topic_count"] = self.topic_cnt
        report["coverage"]["subtopic_count"] = self.sub_topic_cnt
        
        return report
        
    def _get_count(self, completeness, keys):
        if completeness < 2:
            return 0
        
        prop_dict = self.properties
        for key in keys:
            if prop_dict.get(key) is not None:
                prop_dict = prop_dict[key]
            else:
                return 0
        return len(prop_dict)
    
    def _get_topic_counts(self):
        self.topic_cnt = 0;
        self.sub_topic_cnt = 0
        if self.coverage_level == 2:
            coverage = self.properties.get("coverage")
            if coverage.get("topics") is not None:
                topics = coverage.get("topics")
                if isinstance(topics, str):
                    return
                for k,vs in topics.items():
                    if k.startswith("#"):
                        self.topic_cnt += 1
                        for v in vs:
                            self.sub_topic_cnt += 1
    
    def _set_levels(self):
        def _get_level(prop):
            if self.properties.get(prop) is not None:
                if isinstance(self.properties[prop], dict):
                    return 2
                return 1
            return 0
        
        self.custodian_level = _get_level("custodian")
        self.coverage_level = _get_level("coverage")
        self.provenance_level = _get_level("provenance")
        self.profile_level = _get_level("profile")
        self.resources_level = _get_level("resources")
        
def _merge_properties(props):
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
    
    return reduce(_merge, props);
