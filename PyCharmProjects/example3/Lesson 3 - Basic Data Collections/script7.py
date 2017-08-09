###########################################################################################
#
# David Canino, August 2016
#
# Basic management of the tuples in the Python Language
#
# scritp7.py script
###########################################################################################
tpl=()
print("\n\tThe empty tuple 'tpl':",tpl,"with type",type(tpl))
print("\tThe number of the elements in the tuple 'tpl':",len(tpl),"\n")
tpl=(1.0,)
print("\tThe new tuple 'tpl':",tpl,"with type",type(tpl))
print("\tThe number of the elements in the tuple 'tpl':",len(tpl))
print("\tThe unique element in the tuple 'tpl':",tpl[0],"with type",type(tpl[0]),"\n")
tpl1=(2,"hello world")
print("\tThe new tuple 'tpl1':",tpl1,"with type",type(tpl1))
print("\tThe number of the elements in the tuple 'tpl1':",len(tpl1))
print("\tThe first element in the tuple 'tpl1':",tpl1[0],"with type",type(tpl1[0]))
print("\tThe last element in the tuple 'tpl1':",tpl1[-1],"with type",type(tpl1[-1]),"\n")
tpl2=tpl+tpl1
print("\tThe new tuple 'tpl2'='tpl+tpl1':",tpl2,"with type",type(tpl2))
print("\tThe element 'tpl2[0]':",tpl2[0],"with type",type(tpl2[0]))
print("\tThe element 'tpl2[1]':",tpl2[1],"with type",type(tpl2[1]))
print("\tThe element 'tpl2[2]':",tpl2[2],"with type",type(tpl2[2]))
print("\tThe elements 'tpl2[0::2]':",tpl2[0::2])
print("\tThe elements 'tpl2[0:1]':",tpl2[0:2],"\n")
b=4 in tpl2
print("\tThe value 4 belongs to 'tpl2':",b,"with type",type(b))
b=2.0 in tpl2
print("\tThe value 2.0 belongs to 'tpl2':",b,"with type",type(b))
b="hello world" in tpl2
print("\tThe value 'hello world' belongs to 'tpl2':",b,"with type",type(b),"\n")
lst=list(tpl2)
print("\tThe list 'lst', corresponding to the tuple 'tpl2':",lst,"with type",type(lst))
lst[1]=2.78
lst.reverse()
print("\tThe new list 'lst':",lst)
tpl3=tuple(lst)
print("\tThe tuple, corresponding to the new list 'lst':",tpl3,"with type",type(tpl3),"\n")