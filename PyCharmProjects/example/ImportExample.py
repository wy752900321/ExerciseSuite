#!/usr/bin/python3

################################
# File Name:	ImportExample.py
# Author:		Chadd Williams
# Date:			10/17/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		Demonstrate import
################################


from DocTestExample import testIntAddition

def foo():
	""" import a method only for this function
	
	"""
	
	from DocTestExample import printAndReturnSum
	
	totalValue = printAndReturnSum(1,2,3,3,2,1)
	
	print("print it again", totalValue, sep='\t', end=' <<\n')
	
	
	
def main():
	""" call and imported method and call a method not imported
	
	"""
	
	# call the imported method
	value = testIntAddition(2,3)
	
	print (value , "equals", (2+3), "!")
	
	foo()
	
	# try to call a method that has not bee imported for 
	# this function
	#
	# try/except will attempt an operation and catch the exception
	# or error that Python produces, in this case a NameError
	# since the function is not listed in set of names in scope
	# print some information rather than crashing the program
	#
	# https://docs.python.org/3/tutorial/errors.html
	try:
		totalValue = printAndReturnSum(1,2,3,3,2,1)
	
		print("print it again","again", totalValue, 
		sep='\t', end=' <<\n')
	except NameError as err:
		print(">>\tprintAndReturnSum not found!")
		print(">>\t", format(err))
		

	
	
# invoke main()
if __name__ == "__main__":
	main()
