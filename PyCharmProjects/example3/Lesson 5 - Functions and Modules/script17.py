###########################################################################################
#
# David Canino, August 2016
#
# First use of the custom modules in the Python language
#
# scritp17.py script (the same as the script13.py but it exploits the custom module)
###########################################################################################

from custom_module import squared_number

# The main part of the script, which takes a parameter as input ('float') and invoke the 'squared_number' function from the custom module
print()
x=input("\tPlease, insert a number in 'floating point' precision: ")
x=float(x)
val=squared_number(x)
print("\tThe squared value of",x,"with type",type(x),"is:",val,"with type",type(val),"\n")

# The main part of the script, which takes a parameter as input ('int') and invoke the 'squared_number' function from the custom module
x=input("\tPlease, insert an integer value: ")
x=int(x)
val=squared_number(x)
print("\tThe squared value of",x,"with type",type(x),"is:",val,"with type",type(val),"\n")