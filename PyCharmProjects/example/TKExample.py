#!/usr/bin/python3

################################
# File Name:	TKExample.py
# Author:		Chadd Williams
# Date:			10/17/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		Demonstrate TK
################################

from tkinter import *
from tkinter.ttk import *


class ButtonHandler:
	""" simple class that will provide methods to handle button clicks
	"""
	
	def __init__(self):
		self._counter = 0				
				
	def printButtonClickCounter(self):
		print("Counter:", self._counter)
		
	def wowButton(self):
		self._counter += 1
		print("You pressed the WOW button")
		self.printButtonClickCounter()

	def pacificButton(self):
		messages = [ "Go Boxers!", 
					"Now you owe $30,000", 
					"Wooo Forest Grove!",
					"Don't look back"]
		self._counter += 1
		print("You pressed the Pacific button")
		print ("\t",messages[self._counter % len(messages)] )
		self.printButtonClickCounter()


# a callback function does not need to be part of a class
def message():
	""" callback function to print OK when the button is pressed """
	print("OK")
	
	# retrieve the data from the text box and display the string
	# note that entryData is a Global Variable.
	# 
	# better to wrap entryData in a class
	print(entryData.get())



handler = ButtonHandler()

# build the root
root = Tk()

root.title("TK-421")
	
# get a frame
cF = Frame(root)

# turn on the grid layout
cF.grid(column=0,row=0)

# create a button, hooked up the Frame, with the text OK
# and the button press goes to the function message()
okButton=Button(master=cF, text="OK",command=message)

# place the button on the grid
okButton.grid(column=0,row=0, sticky='e')


# create a button, hooked up the Frame, with the text Wow
# and the button press goes to the method ButtonHandler.wowButton()
wowButton=Button(master=cF, text="Wow",command=handler.wowButton)

# place the button on the grid
wowButton.grid(column=1,row=0, sticky='w')

# create a button, hooked up the Frame, with the text Pacific
# and the button press goes to the method ButtonHandler.pacificButton()
pacificButton=Button(master=cF, text="Pacific University",
	command=handler.pacificButton)

# place the button on the grid
pacificButton.grid(column=1,row=1)


# create a StringVar that will hook up to the text in the text box
entryData = StringVar()
# set the default data in the text box
entryData.set('Entry')

# create the text box, called an Entry.
textInput =  Entry(cF, textvariable=entryData, width=16)

# place the box on the grid
# stick='news' means to expand the text box to fill the grid space
# in the north, east, west, south directions (you can use any
# subset of news to only partially fill the grid
textInput.grid(column=0, row=1, sticky='news')


# run the UI loop
root.mainloop()
