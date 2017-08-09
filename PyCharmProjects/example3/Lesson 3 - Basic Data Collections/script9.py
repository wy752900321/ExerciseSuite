###########################################################################################
#
# David Canino, August 2016
#
# Basic management of the 'sets' in the Python Language
#
# scritp9.py script
###########################################################################################

i1=set('1234')
print("\n\tThe first set 'i1':",i1,"with type",type(i1))
print("\tThe number of the elements in the set'i1':",len(i1),"\n")
i2=set('4689')
print("\tThe second set 'i2':",i2,"with type",type(i2))
print("\tThe number of the elements in the set 'i2':",len(i2),"\n")
i12=i1.union(i2)
print("\tThe set, corresponding to the union between 'i1' and 'i2':",i12,"with type",type(i12))
i12=i1.intersection(i2)
print("\tThe set, corresponding to the intersection between 'i1' and 'i2':",i12,"with type",type(i12))
i12=i1.difference(i2)
print("\tThe set, corresponding to the difference between 'i1' and 'i2':",i12,"with type",type(i12))
i12=i2.difference(i1) 
print("\tThe set, corresponding to the difference between 'i2' and 'i1':",i12,"with type",type(i12))
i12=i1.symmetric_difference(i2)
print("\tThe set, corresponding to the symmetric difference between 'i1' and 'i2':",i12,"with type",type(i12))
i12=i2.symmetric_difference(i1)
print("\tThe set, corresponding to the symmetric difference between 'i2' and 'i1':",i12,"with type",type(i12),"\n")
b=(i1&i2)>=i1
print("\tIs the intersection 'i1&i2' a superset of the set 'i1'?",b,"with type",type(b))
b=(i1&i2)<=i1
print("\tIs the intersection 'i1&i2' a subset of the set 'i1'?",b,"with type",type(b),"\n")
b='1' in i1
print("\tIs the value '1' stored in the set 'i1'?",b,"with type",type(b))
b='1' not in i1
print("\tIs the value 'a' not stored in the set 'i1'?",b,"with type",type(b),"\n")
i1c=i1.copy
i2c=i2.copy
print("\tThe new copied set 'i1c':",i1c)
print("\tThe new copied set 'i2c':",i2c,"\n")
i1.clear()
print("\tThe new set 'i1' after removing all elements:",i1,"with type",type(i1))
print("\tThe number of the elements in the set 'i1':",len(i1),"\n")
i1.add(1)
i1.add(66)
i1.add(2.78)
i1.add(3.14)
i1.add(3)
print("\tThe new set 'i1' after having been cleared and enriched with",len(i1),"random elements:",i1,"with type",type(i1))
i2.clear()
i2.add(55)
i2.add(-1)
i2.add("string")
print("\tThe new set 'i2' after having been cleared and enriched with",len(i2),"random elements:",i2,"with type",type(i2))
i1.update(i2)
print("\n\tThe new set 'i1' after being been updated as the union with the set 'i2':",i1,"with type",type(i1))
print("\tThe number of the elements in the new set 'i1':",len(i1))
i1.remove("string")
print("\tThe new set 'i1' after removing the element \"string\":",i1,"with type",type(i1),"and",len(i1),"elements")
i1.discard(3)
print("\n\tThe new set 'i1' after removing the element 3:",i1,"with type",type(i1),"and",len(i1),"elements")
e=i1.pop()
print("\tThe new set 'i1' after removing the element",e,":",i1,"with type",type(i1),"and",len(i1),"elements")
e=i1.pop()
print("\tThe new set 'i1' after removing the element",e,":",i1,"with type",type(i1),"and",len(i1),"elements") 
e=i1.pop()
print("\tThe new set 'i1' after removing the element",e,":",i1,"with type",type(i1),"and",len(i1),"elements")
e=i1.pop()
print("\tThe new set 'i1' after removing the element",e,":",i1,"with type",type(i1),"and",len(i1),"elements")
e=i1.pop()
print("\tThe new set 'i1' after removing the element",e,":",i1,"with type",type(i1),"and",len(i1),"elements")
e=i1.pop()
print("\tThe new set 'i1' after removing the element",e,":",i1,"with type",type(i1),"and",len(i1),"elements\n")