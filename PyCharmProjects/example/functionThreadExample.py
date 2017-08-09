#!/usr/bin/python3

################################
# File Name:	functionThreadExample.py
# Author:		Chadd Williams
# Date:			10/20/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		Demonstrate threads via functions
################################

import time
import threading
import random

# http://www.tutorialspoint.com/python/python_multithreading.htm

# http://en.wikibooks.org/wiki/Python_Programming/Threading

			
def threadFunction (threadNumber) :
	""" This function will print a message to the screen then pause
	"""
	for i in range(10):
		print('\t',threading.get_ident(), (threadNumber%10)*'\t', i)
		time.sleep(random.uniform(.1,.6))
		
def namedThreadFunction (name) :
	""" This function will print a message to the screen then pause
	
	This function takes one parameter, a string that is part of 
	the message printed to the screen
	"""

	for i in range(10):
		print(name, i)
		time.sleep(random.uniform(.1,.6))

def namedThreadFunctionWithLock (name, theLock) :
	""" This function will print a message to the screen then pause
	
	This function takes one parameter, a string that is part of 
	the message printed to the screen
	"""

	for i in range(10):
		theLock.acquire()
		print('\t',name, i)
		theLock.release()
		time.sleep(random.uniform(.1,.6))
		

threads = []	
# launch three threadFunction threads
for x in range(3):
	threads.append (threading.Thread(target=threadFunction, args=(x,)))
	threads[x].start()


# wait for the threads to finish before continuing
for x in range(3):
	threads[x].join()

print("First set of threads DONE")
time.sleep(3)

# launch three namedThreadFunction threads

# args must be a tuple! So you MUST have a comma in the
# tuple, even if you only send one argument

names = ["doug", "shereen", "chadd"]
colors = ["red", "blue", "yellow"]

threads.clear()

for x in range(len(names)):
	threads.append(threading.Thread(target=namedThreadFunction, 
		args=(names[x],)))
	threads[x].start()
	

# build the lock
theLock = threading.Lock()

# launch three namedThreadFunctionWithLock threads

# args must be a tuple! So you MUST have a comma in the
# tuple, even if you only send one argument

# Here, we send two arguments, the color name and the lock
for x in range(len(colors)):
	threads.append (threading.Thread(target=namedThreadFunctionWithLock,
	 args=(colors[x],theLock)))
	threads[x+len(names)].start()


for x in range(len(names)+len(colors)):
	threads[x].join()
	
print("all threads DONE")
