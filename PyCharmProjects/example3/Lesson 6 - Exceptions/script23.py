#################################################################################################
#
# David Canino, September 2016
#
# Basic Management of the Exceptions in the Python language
#
# script23.py
#################################################################################################

import sys

#First, we understand the number of the standard parameters. They must be 3 (the program + auxiliary)
n=len(sys.argv)
if(n!=3):
    print()
    print("\tThis program requires 2 auxiliary parameters 'a' and 'b' (integer values)")
    print("\tThis program is aborting\n")
    exit()
else:
    #Now, we parse auxiliary parameters. They must be 'interger values'.
    a=float(sys.argv[1])
    print()
    print("\tThe first value is 'a'=",a,"with type",type(a))
    b=float(sys.argv[2])
    print("\tThe second value is 'b'=",b,"with type",type(b))

# Now, we test the try-catch construct!
try:
    q=a/b
except ZeroDivisionError:
    print()
    print("\tThe 'except' clause - the division 'a/b' is not possible, since the second value 'b'=",b)
else:
    print()
    print("\tThe 'else' clause - the result of the division 'a/b' is:",q,"with type",type(q))
finally:
    print()
    print("\tThe 'finally' clause - this program is closing correctly.\n")
    
