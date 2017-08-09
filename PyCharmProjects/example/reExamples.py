#!/usr/bin/python3

########################################################################
# File Name:  	reExamples.py
# Author:		chadd williams
# Date:			Oct 30, 2014
# Class:		CS 360
# Assignment:	Example Regular Expressions
# Purpose:		Show examples of using regular expressions
########################################################################


import re

# https://docs.python.org/3/library/re.html

# strings and escape sequences
# https://docs.python.org/3/reference/lexical_analysis.html#string-and-bytes-literals

# regular expression how to
# https://docs.python.org/3/howto/regex.html#regex-howto

# some data to work with later.
classes = ['CS150', 'CS250', 'CS300', 'CS360', 'CS 480', 'cs310',' CS260']

# simple regular expression resulting
# search the entire string for the RE

result = re.search("(CS.*)", "CS360")

print(result.group(1))

print('---------------')

# simple regular expression resulting
result = re.search("(CS)(\d*)", classes[2])

# get the entire result
print(result.group(0))

# get the first group of ( )
print(result.group(1))

# get the second group of ( )
print(result.group(2))

# get the first and second group of ( ) as a tuple
print(result.group(1, 2))

print('---------------')


# compile a regular expression into an object that can
# easily be reused
regExObject = re.compile("(CS)(\d*)")

for theClass in classes:
	
	# match() only looks to match the expression at the start of
	# the string.  
	result = regExObject.match(theClass)
	
	print("TEST:", theClass)

	# classes[4] is 'CS 480' which does not match the RE
	# classes[5] is 'cs310'  which does not match the RE
	# classes[6] is ' CS260' which does not match the RE 
	# 						 at the beginning of the string
	
	# so check to make sure match() does not return NoneType
	
	if not result is None:
		# get the second group of ( )
		print("MATCH:",  result.group(2))

	result = regExObject.search(theClass)

	# classes[4] is 'CS 480' which does not match the RE
	# classes[5] is 'cs310'  which does not match the RE
	# classes[6] is ' CS260' which does not match the RE 
	# 						 at the beginning of the string
	
	# so check to make sure match() does not return NoneType
	
	if not result is None:
		# get the second group of ( )
		print("SEARCH:",  result.group(2))

	print('--')


print('-----RAW STRINGS----------')


# if you are searching for an escape sequence, use the r prefix
# on the string to mark the string as a raw string

# https://docs.python.org/3/howto/regex.html#the-backslash-plague

theData='NOT RAW: >>slash n \n slash t \t<<'
print(theData)

theData=r'RAW: >>slash n \n slash t \t<<'
print(theData)

# raw string
found = re.search(r'\\n slash', theData)
if not None is found:
	print("FOUND using raw string")
else:
	print("OH NO! NOT FOUND using raw string")

# not raw string
found = re.search('\\\\n slash', theData)
if not None is found:
	print("FOUND using NON raw string")
else:
	print("OH NO! NOT FOUND using NON raw string")

