# -*- coding: utf-8 -*-
"""
Created on Thu Jul  1 21:05:20 2021

@author: danny
"""

import random
import time
import math

start = time.time()
point1 = ([random.randrange(0, 1280), random.randrange(0, 800)])
point2 = ([random.randrange(0, 1280), random.randrange(0, 800)])
# input("Press enter: ")
end = time.time() + 1

def calculateMouseSpeed(start, end, point1, point2):
    distance = math.sqrt((pow((point2[0] - point1[0]), 2)) + (pow((point2[1] - point1[1]), 2)))
    duration = end - start
    
    speed = distance / duration
    
    print("\nSpeed: ", speed)
    
calculateMouseSpeed(start, end, point1, point2)

