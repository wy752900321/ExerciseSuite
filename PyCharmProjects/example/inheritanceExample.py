#!/usr/bin/python3

################################
# File Name:	inheritanceExample.py
# Author:		Chadd Williams
# Date:			10/17/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		Demonstrate inheritance
################################


class Course :
	"""Represent a single Course"""
	kind = 'Gen Ed'

	def __init__(self, name, number, credits=4) :
		# _name is a 'private' instance variable
		self._name = name 
		self._number = number
		self._credits = credits
		self.__display()

	def display(self):
		print(self.kind,"Course:" , self._name, self._number, self._credits, sep=" ")
		
	
	def setCredits(self, credits):
		""" set the credits member variable. 
		
		Raise a TypeError if a non-integer is provided.
		"""
		if not type(credits) is int :
			raise TypeError("Credits must be an integer!")
		self._credits = credits
			
		
	# create a private copy named _Course__display
	__display = display


# CSCourse inherits from Course
class CSCourse(Course) : 
	"""Represent a single CS Course"""
	
	kind = 'CS' # class variable shared by all CSCourses

	def __init__(self, name, number, language, numberOfPrograms) :
		Course.__init__(self, name,  number)
		self._language = language
		self._numberOfPrograms = numberOfPrograms

	def display(self):
		Course.display(self)
		print('Language', self._language, 
 		  'Number Of programs:', self._numberOfPrograms, sep = ' ')



cs360=CSCourse("Special Topics", 360, 'python', 3)

print("+++++++++++++++++++++")

cs360.display()

print("+++++++++++++++++++++")

# call display in the base class
cs360._Course__display()

print("+++++++++++++++++++++")


# Try to set the number of credits.
# catch the possible exception in case
# we give a non-integer value.
try:
	cs360.setCredits(5)
except TypeError as err:
	print (err)

try:
	cs360.setCredits('a')
except TypeError as err:
	print (err)
	
		

"""
_name : private by convention
__name: double underscore! mangled to  _classname__name


What happens if kind is __kind in both classes?
Why?

__kind is replaces with _Course__kind in display()
(name mangling).  This FORCES display() to look at 
the __kind in Course rather than CSCourse!


print(cs360.__language) # error
print(cs360._CSCourse__language) #correct

multiple inheritance
class derived(base1, base2,...)
"""
