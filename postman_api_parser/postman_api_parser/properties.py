#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Sep  2 11:41:03 2020

@author: seanlucas
"""

#import json
#from jsonschema import validate

class Properties:
    def __init__(self, properties):
        self.custodian_level = 0
        self.coverage_level = 0
        self.provenance_level = 0
        self.profile_level = 0
        self.resources_level = 0
        self.properties = properties
        
    def get_properties(self):
        #with open("./resources/schema.json") as schema_file:
            #schema = json.load(schema_file)
        #TODO wait until schema is more complete
        #validate(instance=self.properties, schema=schema)
        return self.properties
