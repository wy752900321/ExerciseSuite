###########################################################################################
#
# David Canino, August 2016
#
# Basic management of the functions in the Python Language
#
# scritp13.py script
###########################################################################################

# A trivial example of function - computes the squared value of the 'x' value.
def squared_number(x):
	return (x*x)
	
# The main part of the script, which takes a parameter as input ('float') and invoke the 'squared_number' function.
print()
x=input("\tPlease, insert a number in 'floating point' precision: ")
x=float(x)
val=squared_number(x)
print("\tThe squared value of",x,"with type",type(x),"is:",val,"with type",type(val),"\n")

# The main part of the script, which takes a parameter as input ('int') and invoke the 'squared_number' function.
x=input("\tPlease, insert an integer value: ")
x=int(x)
val=squared_number(x)
print("\tThe squared value of",x,"with type",type(x),"is:",val,"with type",type(val),"\n")