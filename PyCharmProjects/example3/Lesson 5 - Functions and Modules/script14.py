###########################################################################################
#
# David Canino, August 2016
#
# Basic management of the functions in the Python Language
#
# scritp14.py script
###########################################################################################

# An example of a recursive function - it computes the factorial of a given integer value.
def factorial(x):
	if (x<=1):
		return 1
	else:
		return x*factorial(x-1)

# The main component - it receives a positive integer value and computes its factorial!
print()
n=input("\tPlease, insert a positive integer value: ")
n=int(n)
if(n>=0):
	val=factorial(n)
	print("\tThe factorial of",n,"(of type",type(n),") is:",val,"(of type",type(val),")\n")
else:
	print("\tA positive integer value is required. This program is terminating.\n")