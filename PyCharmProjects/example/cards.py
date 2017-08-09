#!/usr/bin/python3

################################
# File Name:	cardsExample.py
# Author:		Chadd Williams
# Date:			10/20/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		a deck of cards to demonstrate unittests
################################

import random

class DeckOfCards:
	
	suits= ['hearts', 'clubs','diamonds','spades', 'none']
	namedCards = ['jack','queen','king','ace', 'joker']
	
	def __init__(self):
		""" constructor. initialize the deck
		"""
		
		self.initializeDeck()
		

	def getName(self, card):
		""" return the string value for the value of the card
		
		this value could be 2-10 or any string in namedCards
		"""
		
		if card[0] > 10 :
			name = self.namedCards[card[0]-11]
		else:
			name = str(card[0])
		
		return name

	def initializeDeck(self):
		""" reset deck to unshuffled state. No jokers
		"""
		# add the numbers
		# 11-14 is jack, queen, king, ace
		# 16 is joker
		self._cards = [ (number,suit) for suit in self.suits[0:4] for number in range(2,15)]
		

	def addJokers(self):
		""" add two jokers to the end of the deck
		
		"""
		self._cards.append( (15, 'none')) 
		self._cards.append( (15, 'none')) 

	def displayCard(self, card):
		""" display a card in a nice way
		"""
		name = self.getName(card)
		
		print(name, "of", card[1])
			
	def display(self):
		""" display the entire deck
		"""
		for card in self._cards:
			self.displayCard(card)


	def shuffle(self):
		""" shuffle the deck
		"""
		random.shuffle(self._cards)
		

	def draw(self):
		""" draw the top card off the end and return that card
		"""
		return self._cards.pop()

	def top(self):
		""" look at the top card on the deck but don't remove the card
		"""
		return self._cards[len(self._cards)-1]

	def isEmpty(self):
		""" is the deck empty ?
		"""
		return len(self._cards) == 0
		
	def higherCard(self, left, right):
		""" Which card is higher?
		 
		return 0 if left is higher
		return 1 if right is higher
		return -1 on a tie
		
		raise ValueError if duplicate cards are given other than jokers
		"""
		if left[0] > right[0] :
			return 0
		elif left[0] < right[0] :
			return 1
		elif self.suits.index(left[1]) >  self.suits.index(right[1]) :
			return 0
		elif self.suits.index(left[1]) <  self.suits.index(right[1]) :
			return 1
		elif 'joker' != self.getName(left) :
			raise ValueError("Duplicate cards!")
		else:
			return -1
	
"""		
deck = DeckOfCards()

deck.display()

deck.addJokers()

deck.shuffle()
print("-------------")
deck.display()

print(deck.draw())

print(deck.isEmpty())

print(deck.draw())

print(deck.isEmpty())


cardLeft = deck.draw()
cardRight = deck.draw()

print("-------------")

deck.displayCard(cardLeft)
deck.displayCard(cardRight)

print("The higher card is:")
higher = deck.higherCard(cardLeft, cardRight)  
if 0 == higher:
	deck.displayCard(cardLeft)
elif 1 == higher:
	deck.displayCard(cardRight)
	

cardLeft = (15, 'none') # joker
deck.displayCard(cardLeft)
deck.displayCard(cardRight)

print("The higher card is:")
higher = deck.higherCard(cardLeft, cardRight)  
if 0 == higher:
	deck.displayCard(cardLeft)
elif 1 == higher:
	deck.displayCard(cardRight)
	
"""
