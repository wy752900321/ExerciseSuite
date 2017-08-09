###########################################################################################
#
# David Canino, August 2016
#
# Basic management of the functions in the Python Language
#
# scritp16.py script
###########################################################################################

# A trivial example of function - computes the squared value of the 'x' value.
def squared_number(x):
	return (x*x)

# Another function - computes the hypotenuse from other two sides
def compute_hyphotenuse(a,b):
	from math import sqrt
	return sqrt(squared_number(a)+squared_number(b))
	
# The main operations - takes as input other two sides and invoke the 'compute_hyphotenuse()' function
print()
a=input("\tPlease, insert the first cathetus 'a' in the right-angled triangle of interest: ")
a=float(a)
if(a<=0):
	print("\n\tThe first cathetus 'a'=",a," must be a not null and positive value. This program is finishing\n")
	exit()

b=input("\tPlease, insert the second cathetus 'b' in the right-angled triangle of interest: ")
b=float(b)
if(b<=0):
	print("\n\tThe second cathetus 'b'=",b," must be a not null and positive value. This program is finishing\n")
	exit()
	
print("\n\tThe first cathetus 'a'=",a,"in the right-angled triangle of interest")
print("\tThe second cathetus 'b'=",b,"in the right-angled triangle of interest")
c=compute_hyphotenuse(a,b)
print("\tThe hyphotenuse 'c'=",c,"in the right-angled triangle of interest\n")