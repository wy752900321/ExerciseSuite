#!/usr/bin/python3

################################
# File Name:	lambdaExample.py
# Author:		Chadd Williams
# Date:			10/17/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		Demonstrate lambda
################################

def make_incr(n: int):
	""" take an int, n and produce a lambda function
	"""
	return lambda x: x +n


def takeAFunction(value: int, function: "function"):
	""" take and int and a function
	
	pass the int to the function return the result
	"""
	return function(value)
	
	
f = make_incr(42)
print(f(0))
#42
print(f(1))
#43
print(f(1))
#43

g = make_incr(0)

print(type(g) )

print(g(0))
#0
print(g(1))
#1

if id(f) == id(g):  # are different!
	print("f and g are the same!", id(f))
else:
	print("f and g are different!", id(f), id(g))
	
print(takeAFunction(9,f))
print(takeAFunction(9,g))

pairs = [(1, 'one'), (2, 'two'), (3, 'three'), (4, 'four')]
 
# key is function used to access the key of the item in the list
# each item (a tuple in this case) in the list is passed as the 
# parameter pair to the lambda function.  pair[1] pulls out the 
# second item in the tuple stored in the list.
pairs.sort(key=lambda pair: pair[1])

# the list is now sorted by the second element in each tuple
print(pairs)
