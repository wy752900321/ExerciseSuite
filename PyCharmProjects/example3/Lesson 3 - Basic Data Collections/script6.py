###########################################################################################
#
# David Canino, August 2016
#
# Basic management of the lists in the Python Language
#
# scritp6.py script
###########################################################################################
lst=[]
print("\n\tThe list 'lst':",lst)
print("\tThe type of the list 'lst':",type(lst))
n=len(lst)
print("\tThe number 'n' of the elements in the list 'lst':",n,"of type ",type(n),"\n")
lst=[1,2,3,4]
print("\tThe new list 'lst':",lst)
print("\tThe type of the list 'lst':",type(lst))
n=len(lst)
print("\tThe number 'n' of the elements in the list 'lst':",n,"of type ",type(n),"\n")
print("\tThe element in position 0, belonging to the list 'lst':",lst[0])
print("\tThe type of the element in position 0, belonging to the list 'lst':",type(lst[0]),"\n")
print("\tThe element in position 1, belonging to the list 'lst':",lst[1])
print("\tThe type of the element in position 1, belonging to the list 'lst':",type(lst[1]),"\n")
print("\tThe element in the position 2, belonging to the list 'lst':",lst[2])
print("\tThe type of the element in position 2, belonging to the list 'lst':",type(lst[2]),"\n")
print("\tThe element in the position 3, belonging to the list 'lst':",lst[3])
print("\tThe type of the element in position 3, belonging to the list 'lst':",type(lst[3]),"\n")
print("\tThe first element in the list 'lst':",lst[0])
print("\tThe last element in the list 'lst':",lst[-1],"\n")
lst1=range(6,20)
print("\tThe new list 'lst1':",lst1,"with",len(lst1),"elements")
print("\tThe type of the list 'lst1':",type(lst1))
lst2=lst1[0:5]
print("\tThe sublist 'lst1[0:5]':",lst2,"contains",len(lst2),"elements")
lst3=lst1[0::2]
print("\tThe sublist 'lst1[0::2]':",lst3,"contains",len(lst3),"elements\n")
lst.append(lst1)
print("\tAfter appending the list 'lst1'=",lst1,"to the bottom of the list 'lst', the result is:",lst)
print("\tThe new list 'lst' contains",len(lst),"elements")
print("\tAdded the new value 5.0 to the 'lst' list")
lst.append(5.0)
print("\tThe new list 'lst'=",lst,"contains",len(lst),"elements\n")
print("\tThe element in position 0, belonging to the list 'lst':",lst[0])
print("\tThe type of the element in position 0, belonging to the list 'lst':",type(lst[0]),"\n")
print("\tThe element in position 1, belonging to the list 'lst':",lst[1])
print("\tThe type of the element in position 1, belonging to the list 'lst':",type(lst[1]),"\n")
print("\tThe element in the position 2, belonging to the list 'lst':",lst[2])
print("\tThe type of the element in position 2, belonging to the list 'lst':",type(lst[2]),"\n")
print("\tThe element in the position 3, belonging to the list 'lst':",lst[3])
print("\tThe type of the element in position 3, belonging to the list 'lst':",type(lst[3]),"\n")
print("\tThe element in the position 4, belonging to the list 'lst':",lst[4])
print("\tThe type of the element in position 4, belonging to the list 'lst':",type(lst[4]),"\n")
print("\tThe element in the position 5, belonging to the list 'lst':",lst[5])
print("\tThe type of the element in position 5, belonging to the list 'lst':",type(lst[5]),"\n")
lst=['a','b','c']
print("\tThe new list 'lst'=",lst,"contains",len(lst),"elements")
lst1=['z','g','f','c']
print("\tThe new list 'lst1'=",lst1,"contains",len(lst1),"elements\n")
lst2=lst+lst1
print("\tConcatenation of the 'lst' and the 'lst1' lists:",lst2,", containing",len(lst2),"elements")
lst2.sort()
print("\tSorted concatenation of the 'lst' and the 'lst1' lists:",lst2,", containing",len(lst2),"elements")
lst2.reverse()
print("\tReversed concatenation of the 'lst' and the 'lst1' lists:",lst2,", containing",len(lst2),"elements")
print("\tThe number of the occurrences for the 'c' character:",lst2.count('c'))
i=lst2.index('c')
print("\tAn occurrence of the 'c' character is saved in position",i)
lst2.pop(i)
print("\tRemoved location in position",i,", the resulting list is:",lst2,", containing",len(lst2),"elements")
lst2.pop(0)
print("\tRemoved location in position 0, the resulting list is:",lst2,", containing",len(lst2),"elements")
print("\tThe number of the occurrences for the 'c' character:",lst2.count('c'))
i=lst2.index('c')
print("\tAn occurrence of the 'c' character is saved in position",i)
del lst2[i]
print("\tRemoved location in position",i,", the resulting list is:",lst2,", containing",len(lst2),"elements")
print("\tThe number of the occurrences for the 'c' character:",lst2.count('c'))
lst2.insert(1,2.0)
print("\tThe resulting list, after inserting 2.0 in position 1:",lst2,", containing",len(lst2),"elements")
lst2.pop()
print("\tRemoved the last location, the resulting list is:",lst2,", containing",len(lst2),"elements\n")
print("\tThe list 'lst':",lst,", containing",len(lst),"elements")
print("\tThe list 'lst3':",lst3,", containing",len(lst3),"elements")
lst.extend(lst3)
print("\tThe extension of the list 'lst' with the list 'lst3':",lst,", containing",len(lst),"elements")
b=5 in lst
print("\tThe value 5 belongs to the list 'lst':",b,type(b))
b='a' in lst
print("\tThe value 'a' belongs to the list 'lst':",b,type(b))
b=8 in lst
print("\tThe value 8 belongs to the list 'lst':",b,type(b))
lst.remove(8)
print("\tRemoved the value 8 from the list 'lst' - the resulting list is:",lst,", containing",len(lst),"elements")
b=8 in lst
print("\tThe value 8 belongs to the list 'lst':",b,type(b),"\n")