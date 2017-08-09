#!/usr/bin/python3

########################################################################
# File Name:  	simpleButton.py
# Author:		chadd williams
# Date:			Oct 30, 2014
# Class:		CS 360
# Assignment:	Example TK Widgets
# Purpose:		Display buttons and handle button clicks
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

def okButtonClick() :
	""" function to handle the click of the OK button
	"""
	
	print("You have pressed the OK button!")

	
def main():
	""" Main method
	
	This method will build a root window, content frame, and place
	a single button on the content frame.
	The UI mainloop is also invoked
	"""

	# build the root
	root = Tk()

	# get a frame
	cF = Frame(root)

	# turn on the grid layout
	cF.grid(column=0,row=0)

	# http://tkinter.unpythonic.net/wiki/Widgets/Button
	# create a button, hooked up the Frame, with the text OK
	# and the button press goes to the function message()
	okButton=Button(master=cF, text="OK",command=okButtonClick)

	# place the button on the grid of the Frame
	okButton.grid(column=0,row=0)

	# run the UI loop
	root.mainloop()
	

if __name__ == "__main__":
	main()
