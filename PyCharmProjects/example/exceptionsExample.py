#!/usr/bin/python3

################################
# File Name:	exceptionsExample.py
# Author:		Chadd Williams
# Date:			10/17/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		Demonstrate exceptions
################################


# Handle an error programmatically rather than having the Python
# interpreter crash.

# a list of things
theList = [1, 'bob', 0, [0], ('data','base')]

# a running total
total = 0

try:
	for x in theList:
		print("ADDING:", x,"to", total)
		# add x to the running total
		total += x

except TypeError as err:
	print ("We cannot add this item!")
	print(err)
else:
	print("Yay! No exceptions")
	print(total)
finally:
	print("We got through without crashing!")
	print(total)
	
print("+++++++++++++++++++++++")

theList = [x for x in range(3)]

# a running total
total = 0

try:
	for x in theList:
		print("ADDING:",x, "to",total)
		# add x to the running total
		total += x

except TypeError as err:
	print ("We cannot add this item!")
	print(err)
else:
	print("Yay! No exceptions")
	print(total)
finally:
	print("We got through without crashing!")
	print(total)
	
print("+++++++++++++++++++++++")

theList = [x for x in range(5)]

# a running total
total = 0

try:
	for x in theList:
		print("ADDING:",x, "to",total)
		# add x to the running total
		total += x
		
		# we can raise our own Exception!
		# can also subclass the class Exception to 
		# create new Exception types
		if 4 == x :
			raise TypeError('Hey! Never add a 4 to a running total!')

except TypeError as err:
	print ("We cannot add this item!")
	print(err)
else:
	print("Yay! No exceptions")
	print(total)
finally:
	print("We got through without crashing!")
	print(total)
	



