###########################################################################################
#
# David Canino, August 2016
#
# Basic management of the functions in the Python Language
#
# scritp15.py script
###########################################################################################

# A trivial example of function - it computes the Arithmetic mean and the geometric mean.
# It returns a tuple (cm,gm), containing the Arithmetic mean 'mc' and the geometric mean 'gm'
def compute_means(a,b):
	
	# We compute the Arithmetic mean
	cm=(a+b)/2.0
	
	# We compute the geometric mean
	from math import sqrt
	gm=sqrt(a*b)
	
	# We return (cm,gm)
	return (cm,gm)

# The main part of the script, whick takes two parameters as input ('float') and invoke the 'compute_means()' function.
print()
a=input("\tPlease, insert the first number 'a' in 'floating point' precision: ")
a=float(a)
b=input("\tPlease, insert the second number 'b' in 'floating point' precision: ")
b=float(b)
print("\n\tThe first number 'a' in 'floating point' precision:",a,"of type",type(a))
print("\tThe second number 'b' in 'floating point' precision:",b,"of type",type(b))
tt=compute_means(a,b)
print("\tResult",tt,"of the 'compute_means()' function with type",type(tt),"\n")
print("\tArithmetic mean:",tt[0])
print("\tGeometric meain:",tt[1],"\n")