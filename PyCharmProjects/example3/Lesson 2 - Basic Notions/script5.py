###########################################################################################
#
# David Canino, July 2016
#
# Basic management of the strings in the Python Language
#
# scritp5.py script
###########################################################################################
wrd="Hello World"
print("\n\tReference string 'wrd':",wrd,'\n')
n=len(wrd)
print("\tLength 'n' of the string 'wrd':",n)
print("\tType of the length 'n':",type(n),'\n')
print("\tCharacter in position 0:",wrd[0]," with type",type(wrd[0]))
print("\tCharacter in position 1:",wrd[1]," with type",type(wrd[1]))
print("\tCharacter in position 2:",wrd[2]," with type",type(wrd[2]))
print("\tCharacter in position 3:",wrd[3]," with type",type(wrd[3]))
print("\tCharacter in position 4:",wrd[4]," with type",type(wrd[4]))
print("\tCharacter in position 5:",wrd[5]," with type",type(wrd[5]))
print("\tCharacter in position 6:",wrd[6]," with type",type(wrd[6]))
print("\tCharacter in position 7:",wrd[7]," with type",type(wrd[7]))
print("\tCharacter in position 8:",wrd[8]," with type",type(wrd[8]))
print("\tCharacter in position 9:",wrd[9]," with type",type(wrd[9]))
print("\tCharacter in position 10:",wrd[10]," with type",type(wrd[10]),"\n")
sub_wrd=wrd[0:5]
print("\tSubstring 'wrd[0:5]':",sub_wrd," with length",len(sub_wrd),"and type",type(sub_wrd))
sub_wrd1=wrd[6:]
print("\tSubstring 'wrd[6:]':",sub_wrd1," with length",len(sub_wrd1),"and type",type(sub_wrd1))
wrd1=sub_wrd+" "+sub_wrd1
print("\tString wrd1='wrd[0:5]+' '+wrd[6:]:",wrd1,"with length",len(wrd1),"and type",type(wrd1))
b=(wrd==wrd1)
print("\tThe value (wrd==wrd1):",b,"with type",type(b),"\n")

