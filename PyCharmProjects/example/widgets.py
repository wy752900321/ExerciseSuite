#!/usr/bin/python3

########################################################################
# File Name:  	widgets.py
# Author:		chadd williams
# Date:			july 8, 2014
# Class:		CS 360
# Assignment:	Example TK Widgets
# Purpose:		Display as many TK Widgets as possible.
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
# check out the docs: https://docs.python.org/3/library/tkinter.ttk.html
from tkinter.ttk import *

# get the predefind file dialog boxes
from tkinter import filedialog



class WidgetApp:
	
	def __init__(self):
		""" Contructor, setup the window and widgets"""
		self.setupWidgets()

	def message(self):
		""" Used for UI callbacks """
		print("OK")

	def checkButtonChange(self):
		""" Activated when the checkbutton is toggled"""
		print(self.checkButtonValue.get())

	def radioButtonChange(self):
		""" Activated when the checkbutton is toggled"""
		print(self.language.get())
		

	def comboBoxChange(self, event):
		""" the Combobox selection has changed """
		# http://effbot.org/tkinterbook/tkinter-events-and-bindings.htm
				
		print(self.building.get())
		print('Click', event.x, event.y)	
		
	def scaleUpdate(self, value):
		""" the scale has been moved"""

		print(self.myScale.get())
		self.progressBarData.set(self.myScale.get())
		
	def terminate(self):
		""" Exit """
		sys.exit()

	def showAbout(self):
		""" about dialog"""
		pass
		
	def showHope(self):
		""" hope dialog
		
		Create a pop up window with message, image, and single button
		The button, when pressed, destorys the pop up window.
		"""
		# create a new window
		hopeWindow = Toplevel(self.root)
		
		# add a label with an image!
		label = Label(hopeWindow, image=self.imgobj, text='Are these the droids you are looking for?')
		label.configure(compound= 'right')
		label.grid(column=1,row=0)
		
		# add a button
		# the command for this button is the destroy method for the
		# new window. Note that you must leave the () off of destroy when
		# setting up the command (otherwise you invoke destroy on the next line
		# and the window disapears)
		localButton = Button(master=hopeWindow, text='No', command=hopeWindow.destroy)
		localButton.grid(column=1,row=1)
	 
	def openFile(self):
		"""Use the openfile dialog box to get a file"""

		self.filename = filedialog.askopenfilename()
		
		# If Cancel is pressed, no filename is returned.
		if self.filename is not None :
			print(self.filename)
		
	def point(self, event):
		"""Drop an oval on the canvas when the canvas is clicked"""
		
		self.myCanvas.create_oval(event.x, event.y, event.x+2, event.y+2)
		
	
	def loadImageFromURL(self, URL) :
		"""Load and image from a URL and return that image
		"""
		# adapted from here
		# http://stackoverflow.com/questions/6086262/python-3-how-to-retrieve-an-image-from-the-web-and-display-in-a-gui-using-tkint/6088442#6088442
		
		import urllib.request
		
		connection = urllib.request.urlopen(URL)
		raw_data = connection.read()
		connection.close()
		
		import base64
		b64_data = base64.encodestring(raw_data)
		return PhotoImage(data=b64_data)
		

	def setupWidgets(self):
		"""Create the root window and setup the widgets"""
		
		# create the Root Window
		self.root = Tk()
				
		# make the window resizeable
		# Only the self.contentFrame is placed on the root at position 0,0
		# so we only configure column 0 and row 0
		self.root.columnconfigure(0, weight=1)
		self.root.rowconfigure(0, weight=1)

		## Add an image 
		# This image will not be used until showHope() but the imgobj needs
		# to live beyond the scope of showHope()
		# the note on the following page is vital. Make sure you keep a
		# reference to the image!
		# http://effbot.org/tkinterbook/photoimage.htm
		
		# we are loading an image from a URL because we don't
		# want to place an image we don't own the copyright for
		# in our GitHub repository.
		
		# if we wanted to load the image from a local file do 
		# the following:
		# self.imgobj = PhotoImage(file='Obi.gif')

		try:
			# load image from URL
			self.imgobj = self.loadImageFromURL("http://zeus.cs.pacificu.edu/chadd/Obi.gif")
		except Exception:
			# loading failed. Try the local image file
			self.imgobj = PhotoImage(file='backupImage.gif')
			
		# create the Content Frame
		self.contentFrame = Frame(self.root)

		# place the content frame on the Root Window
		self.contentFrame.grid(column=0,row=0, sticky='news')

		# make the Frame resizeable
		# configure each column and row that contains a widget
		#
		# the 1 for the weight below controls the rate at which
		# the piece expands. If all pieces (columns and rows) have the
		# same weight, they all expand at the same rate.

		for col in range(5):
			self.contentFrame.columnconfigure(col, weight=1)

		for row in range(6):
			self.contentFrame.rowconfigure(row, weight=2)


		# simple button
		self.myButton=Button(master=self.contentFrame, text='Button',command=self.message)
		self.myButton.grid(column=0,row=0)


		# Frame
		self.myFrame = Frame(self.contentFrame, borderwidth=2, relief='sunken')
		self.myFrame.grid(column=1, row=0)


		# Label
		myLabel = Label(self.myFrame, text='Label')
		myLabel.grid(column=0,row=0)


		# Checkbutton
		self.checkButtonValue = StringVar()
		self.myCheckButton = Checkbutton( self.contentFrame, 
			text='Check Button', command=self.checkButtonChange, 
			variable=self.checkButtonValue, onvalue='ON', offvalue='OFF')

		self.myCheckButton.grid(column=2,row=0)



		# LabelFrame for Radio buttons
		self.myRadioBUttonFrame = LabelFrame(self.contentFrame, 
			borderwidth=2, relief='raised', text='Radio Button')
		self.myRadioBUttonFrame.grid(column=0, row=1, sticky='we')


		# Radiobutton
		self.language = StringVar()
		self.radioButton_C = Radiobutton(self.myRadioBUttonFrame, 
			text='C', variable=self.language, value='C')
		self.radioButton_C.grid(column=0, row=0)

		self.radioButton_Python = Radiobutton(self.myRadioBUttonFrame, 
			text='Python', variable=self.language, value='Python')
		self.radioButton_Python.grid(column=1, row=0)

		self.radioButton_Java = Radiobutton(self.myRadioBUttonFrame, 
			text='Java', variable=self.language, value='Java', command=self.radioButtonChange)
		self.radioButton_Java.grid(column=2, row=0)


		# Entry
		self.entryData = StringVar()
		self.entryData.set('Entry')
		self.myEntry = Entry(self.contentFrame, textvariable=self.entryData, width=6)
		self.myEntry.grid(column=1, row=1)

		# Combobox
		self.building = StringVar()
		self.myCombobox = Combobox(self.contentFrame, textvariable=self.building,values=('Combobox', 'Strain','Price','Marsh'))
		self.building.set('Combobox')
		self.myCombobox.grid(column=2, row=1)
		self.myCombobox.bind('<<ComboboxSelected>>', self.comboBoxChange)


		# Listbox
		self.listBoxData = ('ListBox', 'OR', 'WA','HI','CA')
		self.statenames = StringVar(value=self.listBoxData)

		self.myListBox = Listbox(self.contentFrame, height=3, listvariable=self.statenames)
		# use sticky='e' to push the listbox toward the scrollbar
		self.myListBox.grid(column=0,row=2, sticky='e')


		# Scrollbar
		## Add a vertical scrollbar to Listbox
		self.listScrollbar = Scrollbar(self.contentFrame,orient="vertical", command=self.myListBox.yview)
		# use sticky=ns to make the scroll bar fill the spot vertically
		# use sticky=w to push the scrollbar towards the listbox
		self.listScrollbar.grid(column=1, row=2, sticky='wns')
		# when the listbox is scrolled in the y (vertical) direction (say, with
		# the arrow keys) keep the scroll bar in sync
		self.myListBox.configure(yscroll=self.listScrollbar.set)


		# SizeGrip
		# put the grip at position 999,999, all the empty rows and columns will
		# collapse and not be shown.
		# if you ever have 999 columns or rows you probably have a horrible UI
		# or are running on an IMAX screen
		self.mySizegrip = Sizegrip(self.contentFrame).grid(column=999, row=999, sticky='se')

		# Text
		self.myText = Text(self.contentFrame, width=20, height=3, wrap='word')
		self.myText.grid(column=2, row=2)

		# 1.0 is the index of the first character in the Text widget.
		# """ is a multiline string (newlines are preserved in the string)
		self.myText.insert(1.0, """Text\nA long time ago, in a galaxy far, far away....

		It is a period of civil war. Rebel
		spaceships, striking from a hidden
		base, have won their first victory
		against the evil Galactic Empire.

		During the battle, rebel spies managed
		to steal secret plans to the Empire's
		ultimate weapon, the Death Star, an
		armored space station with enough
		power to destroy an entire planet.

		Pursued by the Empire's sinister agents,
		Princess Leia races home aboard her
		starship, custodian of the stolen plans
		that can save her people and restore
		freedom to the galaxy...""")


		# Progressbar
		self.progressBarData = IntVar()
		self.myProgressbar = Progressbar(self.contentFrame, orient=VERTICAL, length=45, mode='determinate', maximum=18, variable=self.progressBarData)
		self.myProgressbar.grid(column=3, row=2)


		# Scale
		# this scale will update the Progresss bar via scaleUpdate
		# the maximum for the Progessbar should match the to in the Scale. 
		self.myScale = Scale(self.contentFrame, orient=VERTICAL, length=45, from_=1.0, to =18.0, command=self.scaleUpdate)
		self.myScale.grid(column=4, row=2)

		# Spinbox
		self.spinValue = StringVar()
		self.mySpinbox = Spinbox( self.contentFrame, textvariable=self.spinValue, values=('Spinbox', 'Monday','Tuesday','Wednesday','Thursday','Friday'), wrap=True)
		self.mySpinbox.grid(column=0, row=3)


		# Canvas
		# put a Canvas inside a frame so it is easily seen.
		self.canvasFrame = LabelFrame(self.contentFrame, borderwidth=2, relief='sunken', text="Canvas")
		self.canvasFrame.grid(column=0, row=4, columnspan=2 )

		self.myCanvas = Canvas(self.canvasFrame)
		self.myCanvas.create_line(0,0,100,100, fill='red')
		self.myCanvas.grid(column=0,row=0)

		# when the Canvas is clicked, invoke the function point()
		self.myCanvas.bind("<Button-1>", self.point)


		# Tree
		## the Tree will have three columns displayed 
		self.myTree = Treeview(self.contentFrame, columns='FirstName LastName Email', height=3)
		self.myTree.config(show = 'headings') # show only the listed column headings
				
		## label each column
		self.myTree.heading( 'FirstName', text = 'First Name')
		self.myTree.heading( 'LastName', text = 'Last Name')
		self.myTree.heading( 'Email', text = 'Email')
				
		## choose columns to display, in this case, display all columns
		self.myTree.config(displaycolumns = "FirstName LastName Email")

		# columnspan will span this widget across multiple grid columns.    
		self.myTree.grid(column=0, row=5, sticky='we', columnspan=4)
				
		# Add a vertical scroll bar to the TreeView
		self.myTreeScrollbar = Scrollbar(self.contentFrame, orient= "vertical", command =self.myTree.yview )
		self.myTree.configure(yscroll=self.myTreeScrollbar.set)
				
		self.myTreeScrollbar.grid(column = 4, row = 5, sticky='wns')

		# fill the Tree with dummy data
		for x in range(10):
			self.myTree.insert('', 'end', values=['tree name'+str(x), 'lname'+str(x),'email'+str(x)])


		# Notebook
		# http://www.tkdocs.com/tutorial/complex.html
		# A Notebook is a tabbed interface.
		self.myNotebook = Notebook(self.contentFrame)
		self.myNotebook.grid(column=2, row=4, columnspan=3, sticky='news')

		# build a Frame for each tab in the Notebook
		self.myNotebookFrame1 = Frame(self.myNotebook)
		self.myNotebookFrame2 = Frame(self.myNotebook)

		# add each Frame with a Text label.
		self.myNotebook.add(self.myNotebookFrame1, text='FrameOne')
		self.myNotebook.add(self.myNotebookFrame2, text='EmpytFrame inside a Notebook')

		# add widgets to the Frames
		self.myFrameButton = Button(self.myNotebookFrame1, text="Frame button!", command=self.message)
		self.myFrameButton.grid(column=1,row=0)

		self.myFrameLabel = Label(self.myNotebookFrame1, text="Frame Label!")
		self.myFrameLabel.grid(column=0,row=1)



		# Menus
		# Menus are not detachable from the window
		#
		# An example of a torn off menu
		# http://oreilly.com/catalog/motifref2/vol6a/Vol6a_html/V6a.15.11.eps.png
		self.root.option_add('*tearOff', False)

		self.myMenubar = Menu(self.root)
		# config allows you to set an option on the object
		self.root.config(menu=self.myMenubar)


		# build the File menu and attach to the menu bar
		self.myMenu_File=Menu(self.myMenubar)
		self.myMenubar.add_cascade(menu=self.myMenu_File, label='File')
		# add items in the File menu
		self.myMenu_File.add_command(label='Open...', command=self.openFile)
		self.myMenu_File.add_command(label='Exit', command=self.terminate)


		# the help menu
		self.myMenu_Help=Menu(self.myMenubar)
		self.myMenubar.add_cascade(menu=self.myMenu_Help, label='Help')
		self.myMenu_Help.add_command(label='About', command=self.showAbout)
		self.myMenu_Help.add_separator()
		self.myMenu_Help.add_command(label='Only Hope', command=self.showHope)

	def run(self):
		""" launch the Tk main loop """
		#main loop
		self.root.mainloop()

if __name__ == '__main__':
	app = WidgetApp()
	app.run()
