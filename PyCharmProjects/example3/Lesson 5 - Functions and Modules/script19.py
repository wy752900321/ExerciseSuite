###########################################################################################
#
# David Canino, August 2016
#
# Basic management of the functions in the Python Language
#
# scritp19.py script (the same as the 'script15' but it exploits the custom module)
###########################################################################################

import custom_module

# The main part of the script, whick takes two parameters as input ('float') and invoke the 'compute_means()' function from the 'custom' module
print()
a=input("\tPlease, insert the first number 'a' in 'floating point' precision: ")
a=float(a)
b=input("\tPlease, insert the second number 'b' in 'floating point' precision: ")
b=float(b)
print("\n\tThe first number 'a' in 'floating point' precision:",a,"of type",type(a))
print("\tThe second number 'b' in 'floating point' precision:",b,"of type",type(b))
tt=custom_module.compute_means(a,b)
print("\tResult",tt,"of the 'compute_means()' function with type",type(tt),"\n")
print("\tArithmetic mean:",tt[0])
print("\tGeometric meain:",tt[1],"\n")