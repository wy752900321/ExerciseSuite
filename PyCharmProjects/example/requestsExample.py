#!/usr/bin/python3

################################
# File Name:	requestsExample.py
# Author:		Chadd Williams
# Date:			10/20/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		example with requests and pretty printing
################################

#  pip-3.3 install requests

# python3 requestsExample.py | less

import requests
import json
import pprint


# GitHub API:
# https://api.github.com/
# https://developer.github.com/v3/

# fetch data from the web (this is JSON data)
r = requests.get("https://api.github.com/users/cs360f14")

# build a decoder
d = json.JSONDecoder()

# transform JSON to a dictionary
data = d.decode(r.text)

# build a pretty printer
pp = pprint.PrettyPrinter(indent=2)

# display nicely
pp.pprint(data)


# get the events URL
eventsURL = data['events_url']

# strip off the trailing {/privacy}
eventsURL = eventsURL.replace("{/privacy}","")


print ("\n------EVENTS---------\n")

eventsData = requests.get(eventsURL)


print(eventsData)

# transform JSON to a dictionary
eventsDataDict = d.decode(eventsData.text)

# display nicely
pp.pprint(eventsDataDict)

