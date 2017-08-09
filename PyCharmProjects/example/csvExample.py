#!/usr/bin/python3

########################################################################
# File Name:  	csvExample.py
# Author:		chadd williams
# Date:			Oct 30, 2014
# Class:		CS 360
# Assignment:	Example CSV reader
# Purpose:		Show examples of using csv reader
########################################################################


import csv

# https://docs.python.org/3/library/csv.html


# with/as statement
#
# http://effbot.org/zone/python-with-statement.htm
# https://docs.python.org/3/reference/compound_stmts.html#the-with-statement
# see also:
# https://docs.python.org/3/reference/datamodel.html#context-managers

with open('csvExample.csv') as dataFile :
	
	# open the csv reader with the file
	reader = csv.reader(dataFile)
	
	# read each line out of the file
	for dataRow in reader :
		
		# data row is a list of strings
		print(dataRow)
		
		# check out help(str) and look for the join method.
		print(', '.join(dataRow))
		

	# reset the reader to the top of the file
	# note you are operating on the file not the reader
	dataFile.seek(0)

	with open('csvExampleWritten.csv', mode='w') as dataWriteFile:

		# create the csv writer
		writer = csv.writer(dataWriteFile)

		# write a run of text with the header info
		# writerow takes a list of strings
		writer.writerow( ['office','lastname','firstname'])

		# read each line out of the file
		for dataRow in reader :
			
			# we are writing each row in reverse!
			writer.writerow( [x for x in reversed(dataRow) ] )
		

# with/as automatically calls close() on the file!
