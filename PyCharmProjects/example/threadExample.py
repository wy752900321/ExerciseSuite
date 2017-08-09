#!/usr/bin/python3

################################
# File Name:	threadExample.py
# Author:		Chadd Williams
# Date:			10/20/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		Demonstrate threads
################################

import time
import threading
import random

# http://www.tutorialspoint.com/python/python_multithreading.htm

class PingPong (threading.Thread):
	""" this class will print either Ping or Pong to the screen
	"""
	def __init__(self, message,  theLock):
		""" contstructor
		"""
		
		# call the default constructor
		threading.Thread.__init__(self)
		
		self._message = message
		self._lock = theLock
		
		self._counter = 50
		print("STARTED: ", message)
		

	def run(self):
		""" run the thread
		
		loop self._counter times
		acquire the lock, print the message, release
		lock and then sleep for a random amount of time
		to allow the other thread to operate
		"""
				
		for x in range(self._counter):
			self._lock.acquire(True)
					
			print(x, self._message)
			
			self._lock.release()
			time.sleep(random.uniform(.1,3))
			
			

# build the lock
theLock = threading.Lock()

# build each thread, pass the message and the shared lock
ping = PingPong("Ping", theLock)
pong = PingPong("Pong", theLock)

# start each thread
ping.start()
pong.start()

