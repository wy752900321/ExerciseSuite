###########################################################################################
#
# David Canino, August 2016
#
# Basic management of the custom modules functions in the Python Language
#
# scritp18.py script (the same as 'script14.py' script, but it exploits the custom module)
###########################################################################################

from custom_module import *

# The main component - it receives a positive integer value and computes its factorial by using the 'factorial' function from the custom module
print()
n=input("\tPlease, insert a positive integer value: ")
n=int(n)
if(n>=0):
	val=factorial(n)
	print("\tThe factorial of",n,"(of type",type(n),") is:",val,"(of type",type(val),")\n")
else:
	print("\tA positive integer value is required. This program is terminating.\n")