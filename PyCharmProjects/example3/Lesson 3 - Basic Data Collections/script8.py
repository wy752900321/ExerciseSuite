###########################################################################################
#
# David Canino, August 2016
#
# Basic management of the 'frozensets' in the Python Language
#
# scritp8.py script
###########################################################################################

i1=frozenset('abcd')
print("\n\tThe first frozenset 'i1':",i1,"with type",type(i1))
print("\tThe number of the elements in the frozen set'i1':",len(i1),"\n")
i2=frozenset('defg')
print("\tThe second frozenset 'i2':",i2,"with type",type(i2))
print("\tThe number of the elements in the frozenset 'i2':",len(i2),"\n")
i12=i1|i2
print("\tThe frozenset, corresponding to the union 'i1|i2':",i12,"with type",type(i12))
i12=i1&i2
print("\tThe frozenset, corresponding to the intersection 'i1&i2':",i12,"with type",type(i12))
i12=i1-i2 
print("\tThe frozenset, corresponding to the difference 'i1-i2':",i12,"with type",type(i12))
i12=i2-i1 
print("\tThe frozenset, corresponding to the difference 'i2-i1':",i12,"with type",type(i12))
i12=i1^i2
print("\tThe frozenset, corresponding to the symmetric difference 'i1^i2':",i12,"with type",type(i12))
i12=i2^i1
print("\tThe frozenset, corresponding to the symmetric difference 'i2^i1':",i12,"with type",type(i12),"\n")
b=(i1&i2)>=i1
print("\tIs the intersection 'i1&i2' a superset of the frozenset 'i1'?",b,"with type",type(b))
b=(i1&i2)<=i1
print("\tIs the intersection 'i1&i2' a subset of the frozenset 'i1'?",b,"with type",type(b),"\n")
b='a' in i1
print("\tIs the value 'a' stored in the frozenset 'i1'?",b,"with type",type(b))
b='a' not in i1
print("\tIs the value 'a' not stored in the frozenset 'i1'?",b,"with type",type(b),"\n")
i1c=i1.copy
i2c=i2.copy
print("\tThe new copied frozenset 'i1c':",i1c)
print("\tThe new copied frozenset 'i2c':",i2c,"\n")
