# -*- coding: utf-8 -*-
"""
Created on Thu Jul  1 21:05:20 2021

@author: danny
"""

import random
import time
import math

coordinatesList = []
start = time.time()

def calculateMouseSpeed(start, end, coordinatesList):
    distance = 0
    for i in range(9):
        distance += math.sqrt((pow((coordinatesList[i + 1][0] - coordinatesList[i][0]), 2)) 
                              + (pow((coordinatesList[i + 1][1] - coordinatesList[i][1]), 2)))
    
    duration = end - start
    
    return distance / duration

for i in range(10):
    
    point = ([random.randrange(0, 1280), random.randrange(0, 800)])
    
    coordinatesList.append(point)
    
    print(i+1)
    time.sleep(1)
    
    end = time.time()
     
print("\nAverage speed: ", calculateMouseSpeed(start, end, coordinatesList))