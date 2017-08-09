###########################################################################################
#
# David Canino, August 2016
#
# Basic management of the 'if-then-else' construct in the Python Language
#
# scritp11.py script
###########################################################################################

from math import sqrt

# We write the header, then we ask for the coefficients 'a' - 'b' - 'c'
print("\n\tSolving a second degree equation in the form 'a * x^2 + b * x + c = 0'\n")
print("\tPlease, insert all coefficients as floating point values (numeric):\n")
a = input("\t\tPlease, insert the coefficient 'a': ")
a = float(a)
if a!=0:
	b = input("\t\tPlease, insert the coefficient 'b': ")
	b = float(b)
	c = input("\t\tPlease, insert the coefficient 'c': ")
	c = float(c)
else:
	print("\n\tThe coefficient 'a' must not null (positive or negative). This program is finishing.\n")
	exit()

# If we arrive here, the coefficients are all valid.
print("\n\tThe coefficient 'a'=",a,"with type",type(a))
print("\tThe coefficient 'b'=",b,"with type",type(b))
print("\tThe coefficient 'c'=",c,"with type",type(c),"\n")
if (b<0):
	
	if(c==0):
		print("\tWe are going to solve the equation",a,"* x^2",b,"* x = 0\n")
	elif(c>0):
		print("\tWe are going to solve the equation",a,"* x^2",b,"* x +",c,"= 0\n")
	else:
		print("\tWe are going to solve the equation",a,"* x^2",b,"* x -",(-c),"= 0\n")

elif(b==0):

	if(c==0):
		print("\tWe are going to solve the equation",a,"* x^2 = 0\n")
	elif(c>0):
		print("\tWe are going to solve the equation",a,"* x^2 +",c,"= 0\n")
	else:
		print("\tWe are going to solve the equation",a,"* x^2 -",(-c),"= 0\n")
	
else:
	
	if(c==0):
		print("\tWe are going to solve the equation",a,"* x^2 +",b," * x = 0\n")
	elif(c>0):
		print("\tWe are going to solve the equation",a,"* x^2 +",b," * x +",c,"= 0\n")
	else:
		print("\tWe are going to solve the equation",a,"* x^2 +",b," * x -",(-c),"= 0\n")
		
# We compute the discriminant d=b^2-4ac, then we decide the type of the solutions, and how computing them!
delta=b**2-4.0*a*c
if (delta>0):

	# We have two distinct solutions (float)
	print("\tThe discriminant of this equation is:",delta,"thus, there are two distinct solutions (real).\n")
	x1=(-b+sqrt(delta))/(2.0*a)
	x2=(-b-sqrt(delta))/(2.0*a)
	
elif (delta==0):

	# We have two coincident solutions (float)
	print("\tThe discriminant of this equation is:",delta,"thus, there are two coincident solutions (real).\n")
	x1=(-b)/(2.0*a)
	x2=x1

else:

	# We have two conjugate solutions (complex)
	print("\tThe discriminant of this equation is:",delta,"thus, there are two conjugate solutions (complex).\n")
	x1=complex(-b,sqrt(-delta))/(2.0*a)
	x2=x1.conjugate()

# Finally, we print the solutions 'x1' and 'x2'	
print("\tSolution 'x1'=",x1,"with type",type(x1))
print("\tSolution 'x2'=",x2,"with type",type(x2),"\n")
