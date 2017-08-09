#!/usr/bin/python3

################################
# File Name:	classExample.py
# Author:		Chadd Williams
# Date:			10/17/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		Demonstrate classes
################################

class CSCourse : 
	"""Represent a single CS Course"""
	
	# any statements inside a class but outside a method
	# declaration run once when the class is first read
	
	kind = 'CS' # class variable shared by all CSCourses

	def __init__(self, name, number) :
		self.name = name			# instance variable
		self.number = number

	def display(self):
		print("CS Course: " , self.name, self.number, sep=" ")

	def __str__(self):
		return self.kind + self.name + str(self.number)

cs360=CSCourse("Special Topics", 360)

cs360.display()

print(str(cs360))


"""
the first parameter to a class function is always the object the 
function is called on.  it is named self by convention

__init__ constructor

__str__ called via str() --> produce a readable string

__repr__ called via repr() : printable string. -> unambiguous
	often this string will create an object of the same value when 
	passed to eval()

>>> x ="Hello"
>>> print (x)
Hello
>>> repr(x)
"'Hello'"
>>> eval(repr(x))
'Hello'

"""
