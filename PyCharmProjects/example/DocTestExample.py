#!/usr/bin/python3

################################
# File Name:	DocTestExample.py
# Author:		Chadd Williams
# Date:			10/17/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		Demonstrate PyTest
################################



# Run these test cases via:
# chadd@bart:~> python3 -m doctest -v DocTestExample.py


# Simple int example
def testIntAddition(left: int, right: int)->"sum of left and right":
	"""Test the + operator for ints
	
	
	Test a simple two in example
	>>> testIntAddition(1,2)
	3
	
	
	Use the same int twice, no problem
	>>> testIntAddition(2,2)
	4
	
	
	Try to add a list to a set! TypeError!
	Only show the first and last lines for the error message
	The ... is a wild card
	The ... is tabbed in TWICE
	>>> testIntAddition([2], {3})
	Traceback (most recent call last):
		...
	TypeError: can only concatenate list (not "set") to list
	
	"""
	
	return left + right
	
# Simple List example
def printFirstItemInList(theList: "list of items"):
	""" Retrieve the first item from the list and print it
	
	Test a list of ints
	>>> printFirstItemInList( [ 0, 1, 2] )
	0
	
	Test a list of strings
	>>> printFirstItemInList( ["CS 360", "CS 150", "CS 300" ] )
	CS 360
	
	Generate a list comphrension
	>>> printFirstItemInList( [ x+1 for x in range(10) ] )
	1
	
	
	Work with a list of tuples
	>>> printFirstItemInList( [ (x,x+1, x-1) for x in range(10) ] )
	(0, 1, -1)
	
	"""
	
	item = theList[0]
	print(item)
	
	
# Test Output of print and return value
# that \ at the end of the line allows you to continue
# the same statement on the next line!
def printAndReturnSum(*args: "variadic param")\
->"return sum of ints provided as parameters":
		
	""" Print and return the sum of the args that are ints
	
	>>> printAndReturnSum(1,2,3)
	6
	6
	
	>>> printAndReturnSum("bob", 1)
	1
	1
	
	"""
	
	total = 0
	
	for x in args:
		# type check at run time!
		if type(x) is int :
			total += x
		
	print(total)
	return total
	
