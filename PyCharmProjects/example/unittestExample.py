#!/usr/bin/python3

################################
# File Name:	unittestExample.py
# Author:		Chadd Williams
# Date:			10/20/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		Demonstrate unit tests
################################

# adapted from https://docs.python.org/3/library/unittest.html

# python3 -m unittest unittestExample -v

import random
import unittest

class TestListFunctions(unittest.TestCase):

	listSize = 10

	def setUp(self):
		""" the text fixture, necessary setup for the tests to run
		"""
		self.theList = list(range(self.listSize))

		# shuffle the list
		random.shuffle(self.theList)
		
	def tearDown(self):
		""" nothing to tear down here
		
		If your test created a database or built a network connection
		you might delete the database or close the network connection
		here.  You might also close files you opened, close your
		TK windows if this is GUI program, or kill threads if this is
		a multithreaded application
		"""
		pass # nothing to do

	def test_sort(self):
		""" make sure sort works correctly
		"""
		self.theList.sort()
		self.assertEqual(self.theList, list(range(self.listSize)))

	def test_append(self):
		""" make sure append works correctly
		"""
		self.theList.append(self.listSize+1)
		self.assertEqual(self.theList[-1], self.listSize+1)


	def test_exceptions(self):
		"""test some exceptions
		"""
		
		# theList does not contain -1. Make sure remove
		# raised the correct exception
		
		self.assertRaises(ValueError, self.theList.remove, -1)

	def test_thistestwillfail(self):
		"""show you what a failed test looks like
		"""
		
		# theList DOES contain 1. 
		# remove will not raise the expected exception
		
		self.assertRaises(ValueError, self.theList.remove, 0)
