###########################################################################################
# David Canino, July 2016
#
# Conversions between 'int' and 'float' expressions in the Python Language
#
# script4.py
###########################################################################################
print()
x='10'
print("\tThe variable 'x':",x)
print("\tThe type of the variable 'x':",type(x))
fx=float(x)
print("\tThe converted variable 'fx=float(x)':",fx)
print("\tThe type of the variable 'fx':",type(fx))
sfx=str(fx);
print("\tThe reverse conversion 'sfx=str(fx)':",sfx)
print("\tThe type of the variable 'sfx':",type(sfx),"\n")
ix=int(x)
print("\tThe converted variable 'ix=int(x)':",ix)
print("\tThe type of the variable 'ix':",type(ix))
six=str(ix)
print("\tThe reverse conversion 'six=str(ix)':",six)
print("\tThe type of the variable 'six':",type(six),"\n")
