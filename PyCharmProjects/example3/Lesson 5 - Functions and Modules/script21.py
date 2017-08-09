###########################################################################################
#
# David Canino, August 2016
#
# Basic Management of the custom modules in the Python language
#
# script21.py
###########################################################################################

from custom_module import *

print()
print("\t The 'greek_pi' value in the 'custom_module':",greek_pi)
print("\t The 'double_greek_pi' value in the 'custom_module':",double_greek_pi,"\n")

l=range(1,20)
dl=double_values(l)
print("\t The initial list 'l'=",l)
print("\t The new ist 'dl', containing the double values of the values in 'l', such that 'dl'=",dl,"\n")

n=input("\t Please, insert the order (a positive integer) for the identity matrix of interest: ")
n=int(n)
if n<=0:
    print("\t The order n must be a positive integer value. This program is finishing.\n")
    exit()
else:
    print("\t The identity matrix of order",n,"is:\n")
    mat=identity_matrix(n)
    for r in mat:
        print("\t",r)
print()