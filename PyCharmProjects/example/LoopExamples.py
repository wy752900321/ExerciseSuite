#!/usr/bin/python3

################################
# File Name:	LoopExamples.py
# Author:		Chadd Williams
# Date:			10/17/2014
# Class:		CS 360
# Assignment:	Lecture Examples
# Purpose:		Demonstrate Loops, sets, lists
################################




def loopOnList():
	""" loop on a list
	
	"""
	
	# note that repeats are allowed!
	names = ["Doug", "Shereen", "Chadd", "Mike", "Chris", 
		"Nancy", "Chris", "Ian", "Bill" ]
		
		
	for name in names:
		print(name)
		
	print("----------------")	
	
	for name in sorted(names):
		print(name)
		
	print("----------------")	
		

def loopOnSet():
	"""
	"""
	# Somebody needs to write this!
	
	# pass is like no op, or just typing a single ; on a
	# blank line in C/C++.
	
	pass
	

def loopOnDict():
	"""loop on a dictionary
	
	"""
	
	classes = { 150:"Introduction to Computer Science I",
				250:"Introduction to Computer Science II",
				300:"Data Structures",
				310:"Theoretical Computer Science",
				360:"Special Topics: Open Source Software Development",
				380:"Algorithms Analysis and Design",					
				430:"Computer Architecture",
				445:"Introduction to Database Systems",
				460:"Operating Systems",
				480:"Compilers",
				493:"Software Engineering I",
				494:"Software Engineering II" }
	print("----------------")
	
	for key, value in classes.items():
		print(key,"->", value)
		
	print("----------------")
	
	for key in sorted(classes.keys()):
		print(key,"->", classes[key])
		
	print("----------------")
	
	
	for value in sorted(classes.values()):
		print(value)
		
	print("----------------")


	for value in classes.values():
		if value[-1] == 'I' :
			print(value)
		
	print("----------------")

	for value in classes.values():
		if value[-1] == value[0] :
			print(value)
		
	print("----------------")

	courseNumber = 150
	if courseNumber in classes.keys() :
		print("Yes! We teach ", courseNumber)

	courseNumber = 151
	if courseNumber in classes.keys() :
		print("Yes! We teach ", courseNumber)
	else:
		print("No! We don't teach ", courseNumber)
		
	courseName = "Compilers"
	if courseName in classes.values() :
		print("Yes! We teach ", courseName)
	else:
		print("No! We don't teach ", courseName)
		

	print("We teach", len(classes), "courses")
	
def main():
	""" invoke each function
	
	"""
	
	loopOnList()
	loopOnSet()
	loopOnDict()
	

# invoke main()
if __name__ == "__main__":
	main()



