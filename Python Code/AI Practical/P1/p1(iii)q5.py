# -*- coding: utf-8 -*-
"""
Created on Thu Jul  1 13:42:57 2021

@author: danny
"""
import re

password = input("Please enter your password: ")

def password_check(password):
    reg = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$"
    
    if re.match(reg, password):
        print("Good password")
    else:
        print("Bad password")
        
password_check(password)