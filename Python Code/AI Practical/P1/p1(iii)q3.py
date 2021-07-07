# -*- coding: utf-8 -*-
"""
Created on Thu Jul  1 11:27:27 2021

@author: danny
"""

txt = open("pg2554.txt", "r").read().lower()
txt = txt[2:1000]
while True:
    keyword = input("Enter Keyword or Keyphrase: ")
    
    if (keyword == "quit"):
        break
    
    index = txt.find(keyword)
    
    if (index != -1):
        keyCount = txt.count(keyword)
        print(keyCount)
        print("%s found at index %d" %(keyword, index))
        print("%s appears %d time(s)" %(keyword, keyCount))
    else:
        print("%s not found" %keyword)
    
print("program terminated")