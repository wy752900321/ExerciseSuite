#!/usr/bin/python3

########################################################################
# File Name:  	heapqExample.py
# Author:		chadd williams
# Date:			Oct 30, 2014
# Class:		CS 360
# Assignment:	Example heapq
# Purpose:		Show examples of using heapq
########################################################################


from heapq import *

# https://docs.python.org/3/library/heapq.html

# The heap should contain tuples. The first item in the
# tuple will be used as the sort key and should use normally
# available Python comparison operations

# make up some fake data
data = [ str(x)*x for x in range(1, 9) ]

# create the heap as an empty list
theHeap = []

for x in reversed(range(1, 9)):
	print(x)
	heappush(theHeap, (x, data[x-1]) )

print('--------------')

# The smallest item is at the top of the list
print(theHeap)
print('--------------')


# a heap does not provide an iterator!
# the following is an unusual use of a heap for 
# demonstration purposes only

heapIsEmpty = False

while not heapIsEmpty:

	# pop the smallest item off the top of the heap!
	try:
		x = heappop(theHeap)
		print(x)
	except IndexError:
		# when the heap is empty, heappop() raises IndexError
		# catch the exception and break out of the loop
		heapIsEmpty = True
