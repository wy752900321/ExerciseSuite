###########################################################################################
#
# David Canino, August 2016
#
# Basic management of the functions in the Python Language (custom modules)
#
# scritp20.py script (basically the same as the 'script16.py', but with the custom module)
###########################################################################################

import custom_module

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
c=custom_module.compute_hyphotenuse(a,b)
print("\tThe hyphotenuse 'c'=",c,"in the right-angled triangle of interest\n")