#!/usr/bin/python3

########################################################################
# File Name:  	datetimeExample.py
# Author:		chadd williams
# Date:			Oct 30, 2014
# Class:		CS 360
# Assignment:	Example datetime
# Purpose:		Show examples of using datetime
########################################################################


import time
from datetime import *

# https://docs.python.org/3/library/datetime.html



today = date.today()
print('Today:', today)

holiday = date(2014, 10, 31)

print('Halloween', holiday)

print('timetuple', holiday.timetuple())

if today == holiday :
	print('Today is a holiday!')
else:
	print('Today is not a holiday!')
	
	# create a timedelta
	theTimeDelta = (holiday-today);
	print('The holiday is', theTimeDelta.days ,'days away!')
	

# let's make today a holiday
holiday = date(today.year, today.month, today.day)

if today == holiday :
	print('Today is a holiday! Wow!')
else:
	print('Today is not a holiday! Something is wrong!')

		
# create a date from a string
# formatting strings:
# http://strftime.org/
# http://strftime.net/
stringDate = 'Sun November 2 2014'
newDate = datetime.strptime(stringDate, '%a %B %d %Y').date()

print(newDate)
