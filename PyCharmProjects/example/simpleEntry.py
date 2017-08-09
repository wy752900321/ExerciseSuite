#!/usr/bin/python3

########################################################################
# File Name:  	simpleEntry.py
# Author:		chadd williams
# Date:			Oct 30, 2014
# Class:		CS 360
# Assignment:	Example TK Widgets
# Purpose:		Display text box and handle text box updates
########################################################################

# import X only adds module name X to the symbol table.
# you would need to access each item in X like X.item

# import all names inside tkinter
from tkinter import *


# import all names in tkinter.ttk 
# ttk contains the new themed widgets
# which override the same widgets present in tkinter
# this from/import line MUST follow the 
# from tkinter import * line to properly give access
# to the ttk widgets.
#
# Check out the docs: 
# https://docs.python.org/3/library/tkinter.ttk.html
# https://docs.python.org/3/library/tkinter.html
#
from tkinter.ttk import *


def pressReturn(eventObject):
	""" function to call when Return is pressed in the Entry
	
	The Event Object is provided by TK.  The event object contains
	the widget, mouse information, and other event specific data.
	
	http://effbot.org/tkinterbook/tkinter-events-and-bindings.htm#events
	"""
	print("RETURN IS PRESSED")
	
	# show the type of the widget
	# should be Entry
	print(type(eventObject.widget))
	
	# the .get() method on an Entry returns the 
	# text in the Entry
	print(eventObject.widget.get())
	
	
def main():
	""" Main method
	
	This method will build a root window, content frame, and place
	a Entry box on the content frame.
	The UI mainloop is also invoked
	"""

	# build the root
	root = Tk()

	# get a frame
	cF = Frame(root)

	# turn on the grid layout
	cF.grid(column=0,row=0)
	
	# create a StringVar that will hook up to the text in the text box
	entryData = StringVar()
	# set the default data in the text box
	entryData.set('Entry')
	
	# entryData could be used to interact with the text in the
	# Entry box.  You can also call .get() and .set() to 
	# get and set the text in the Entry.
	#
	# A stringVar would be useful if it was a class instance variable
	# for a class the periodically get/set data in Entry.  This 
	# variable can be passed around so that functions/methods/classes
	# that don't have access to the Entry box directly can access
	# the Entry box's data.
	#
	# You are not required to create a StringVar()
	
	# create the text box, called an Entry.
	textInput =  Entry(cF, textvariable=entryData, width=6)

	# place the box on the grid
	# stick='news' means to expand the text box to fill the grid space
	# in the north, east, west, south directions (you can use any
	# subset of news to only partially fill the grid
	textInput.grid(column=0, row=1, sticky='news')
	
	# event binding
	# bind a function call to a GUI event
	# When the ENTER or RETURN key is pressed with the cursor
	# in the Entry, pressReturn() is invoked.
	#
	# NOTE: this seems to only work with the standard ENTER/RETURN
	# key, not the ENTER/RETURN that is on the number pad!
	#
	# http://effbot.org/tkinterbook/tkinter-events-and-bindings.htm
	textInput.bind("<Return>", pressReturn)

	# run the UI loop
	root.mainloop()
	

if __name__ == "__main__":
	main()
