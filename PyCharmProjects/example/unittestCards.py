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

# python3 -m unittest unittestCards -v

import random
import unittest
from cards import DeckOfCards

class TestDeckOfCardsFunctions(unittest.TestCase):

	

	def setUp(self):
		""" the text fixture, necessary setup for the tests to run
		"""
		self.theDeck = DeckOfCards()

		
	def tearDown(self):
		""" nothing to tear down here
		
		If your test created a database or built a network connection
		you might delete the database or close the network connection
		here.  You might also close files you opened, close your
		TK windows if this is GUI program, or kill threads if this is
		a multithreaded application
		"""
		pass # nothing to do


	def test_shuffle(self):
		""" make sure shuffle moves the first card
		"""
		
		card = self.theDeck.top()
		self.theDeck.shuffle()
		newCard = self.theDeck.top()
		
		self.assertTrue(card[0]!=newCard[0] or card[1] != newCard[1])
		
		
		

	def test_addjokers(self):
		""" make sure exactly two jokers are added to the top
		"""
		self.theDeck.initializeDeck()
		
		self.theDeck.addJokers()
		
		card = self.theDeck.draw()
		self.assertTrue( self.theDeck.getName(card) == 'joker' )

		card = self.theDeck.draw()
		self.assertTrue( self.theDeck.getName(card) == 'joker' )

		card = self.theDeck.draw()
		self.assertFalse( self.theDeck.getName(card) == 'joker' )
		


	def test_isEmpty(self):
		"""make sure after we draw 52 cards, the deck is empty
		"""
		self.theDeck.initializeDeck()
		
		for x in range(52):
			self.assertFalse(self.theDeck.isEmpty())
			self.theDeck.draw()
			
		self.assertTrue(self.theDeck.isEmpty())
			
		
	def test_higherCard(self):
		"""show you what a failed test looks like
		"""
		self.theDeck.initializeDeck()

		card = self.theDeck.draw()
		
		with self.assertRaisesRegex(ValueError, "Duplicate cards!"):
			self.theDeck.higherCard(card,card)
