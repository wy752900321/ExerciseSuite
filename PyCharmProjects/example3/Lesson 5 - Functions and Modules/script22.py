#################################################################################################
#
# David Canino, August 2016
#
# Basic Management of the custom modules in the Python language (the dictionary comprehension)
#
# script22.py
#################################################################################################

from custom_module import *

print()
d=dict()
d["One"]=1.0
d["Second"]=2.0
d["Third"]=3.0
d["Four"]=4.0
print("\tThe initial dictionary 'd' of type",type(d),"contains the following associations:\n")
for k,v in d.items():
	print("\tThe key\'",k,"\' of type",type(k),"is associated with the value",v,"of type",type(v))
else:
	print()
	
dr=reverse_dictionary(d)
print("\tThe reverse dictionary 'd' of type",type(d),"contains the following associations:\n")
for k,v in dr.items():
	print("\tThe key",k,"of type",type(k),"is associated with the value \'",v,"\' of type",type(v))
else:
	print()