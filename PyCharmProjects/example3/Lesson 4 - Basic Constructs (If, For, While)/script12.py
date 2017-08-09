###########################################################################################
#
# David Canino, August 2016
#
# Basic management of the 'for' and the 'while' constructs in the Python Language
#
# scritp12.py script
###########################################################################################

# Loop with the classical increment '+1'
print("\n\tTraversing all consecutive indices in the range [1,10] by using the 'for' loop\n")
for i in range(1,11):
	print("\t\t",i)
	
# Loop with the classical increment '+1' in reverse order
print("\n\tTraversing all consecutive indices in the range [1,10] by using the 'for' loop (reverse traversal) \n")
for i in reversed(range(1,11)):
	print("\t\t",i)

# Loop with the increment '+2'
print("\n\tTraversing all odd indices in the range [1,10] by using the 'for' loop\n")
for i in range(1,11,2):
	print("\t\t",i)
	
# Loop with the increment '+2' (in reverse order)
print("\n\tTraversing all odd indices in the range [1,10] by using the 'for' loop\n")
for i in reversed(range(1,11,2)):
	print("\t\t",i)
	
# Traversing elements of a list by using the 'for' loop on the elements
l=["Traversing","a","list","containing","several","int","values"]
print("\n\tThe content of the list 'l'=",l,"of type",type(l),", traversed by using the 'for' loop on the elements:\n")
for w in l:
	print("\t\tElement of type",type(w),"in the list 'l':",w)

print("\n\tThe content of the list 'l'=",l,"of type",type(l),", traversed by using the 'for' loop on the locations indices:\n")
for i in range(0,len(l)):
	print("\t\tElement of type",type(w),"in the list 'l':",l[i])
	
# Please, insert the maximum number n of 'int' values.
print("\n\tThe analysis of the first 'n' squared numbers ============================================================================ \n")
n=input("\tPlease, insert the maximum number 'n' (positive and not null integer): ")
n=int(n)
if (n>0):
	print("\tWe are going to analyze the first",n,"squared numbers by using the 'while' loop:\n")
	i=0
	while(i<n):
		print("\t\tThe squared value of the number",i,"is",(i**2))
		i=i+1
	else:
		print()
else:
	print("\tThe number 'n' must be positive and not null. This program is going to finishing.")
	exit()