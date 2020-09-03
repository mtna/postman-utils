#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Sep  2 11:40:49 2020

@author: seanlucas
"""
class Tag:
    def __init__(self, tagId):
        self.tagId = tagId
        self.resources = []
        
    def add_resource(self, resource):
        self.resources.append(resource)