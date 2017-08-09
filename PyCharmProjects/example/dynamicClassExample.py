#!/usr/bin/python3

################################
# File Name:	dynamicClassExample.py
# Author:		Chadd Williams
# Date:			10/17/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		Demonstrate dynamic class
################################


# create an empty class calle numbers
class Numbers:
	pass
	
	
def printV(value):
	"""Print the integer attribute in the object value"""
	print(value.integer)


# create an object
data = Numbers()

# dynamically add an attribute!
data.integer = 1

printV(data)

# add a second attribute
data.floatValue = 1.0

print(data.floatValue)

# add an attribute that points to printV
data.p = printV

# call printV!
data.p(data)
