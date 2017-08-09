#!/usr/bin/python3

################################
# File Name:	generatorExample.py
# Author:		Chadd Williams
# Date:			10/17/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		Demonstrate yeild/generate
################################


# Iterator Types
# https://docs.python.org/3/library/stdtypes.html#iterator-types
#
# Any object that implements the iterator interface can be used
# in a for loop or the in statement.  For example, a List implements 
# the iterator interface as demonstrated below. 

# See an example of the methods involved in the iterator interface
# at the link above.  

# An iterator is design pattern.  A design pattern is a common idiom 
# that often appears in object oriented code regardless of language.
# You can read more here: http://en.wikipedia.org/wiki/Iterator_pattern


theList = [1, 2, 3, 4]

for value in theList:
	print(value)

print("------------------")

# A Generator is a simple way to create an iterator.

def squared(data):
	""" 
	this function will walk through the list data squaring and 
	returning one item at a time.
	"""
	
	for value in data:
		# yeild is like return, but the next time this function is 
		# called in a place were an iterator would be accepted
		# rather than restart from the beginning, the function
		# restarts after the last value that was returned.
		yield value**2
		
		
numbers = [ x for x in range(10) ]

# use squared in an iterator situation
for value in squared(numbers):
	print(value)
print("------------------")

# use squared in an iterator situation
squares = [ x for x in squared(numbers) ]
print(squares)

# Generator Expression
# https://docs.python.org/3/glossary.html#term-generator

# Hi! You may remember Generator Expressions from such lecture slides as
# "More on Lists, slide # 20"
#
# the code  i*i for i in range(3)
# is called a Generator Expression
print(sum(i*i for i in range(3)))
