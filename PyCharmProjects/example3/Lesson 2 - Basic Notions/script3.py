#################################################################################
# David Canino, July 2016
#
# Examples about the expressions and the basic operators in the Python Language
#
# script3.py script
#################################################################################
a=1
b=2
c=-3
d=4.0
print()
print("\tVariable 'a':",a)
print("\tType of the variable 'a':",type(a),"\n")
print("\tVariable 'b':",b)
print("\tType of the variable 'b':",type(b),"\n")
print("\tVariable 'c':",c)
print("\tType of the variable 'c':",type(c),"\n")
print("\tVariable 'd':",d)
print("\tType of the variable 'd':",type(d),"\n")
ris_ab=a+b;
print("\tOperation a+b:",ris_ab,"with type",type(ris_ab))
ris_ab=a-b;
print("\tOperation a-b:",ris_ab,"with type",type(ris_ab))
ris_cd=c*d
print("\tOperation c*d:",ris_cd,"with type",type(ris_cd))
ris_cb=c/b
print("\tOperation c/b:",ris_cb,"with type",type(ris_cb))
ris_cb=int(c//b)
print("\tOperation c//b:",ris_cb,"with type",type(ris_cb))
ris_db=d/b
print("\tOperation d/b:",ris_db,"with type",type(ris_db))
mod_db=d%b
print("\tOperation d%b:",mod_db,"with type",type(mod_db),"\n")
mod_dpb=d**b
print("\tOperation d**b:",mod_dpb,"with type",type(mod_dpb))
mod_dpc=d**c
print("\tOperation d**c:",mod_dpc,"with type",type(mod_dpc),"\n")
ris_ab=(a==b)
print("\tOperation '(a==b)':",ris_ab,"with type",type(ris_ab))
ris_ab=(a!=b)
print("\tOperation '(a!=b)':",ris_ab,"with type",type(ris_ab))
ris_ab=(a<b)
print("\tOperation '(a<b)':",ris_ab,"with type",type(ris_ab))
ris_ab=(a<=b)
print("\tOperation '(a<=b)':",ris_ab,"with type",type(ris_ab))
ris_ab=(a>b)
print("\tOperation '(a>b)':",ris_ab,"with type",type(ris_ab))
ris_ab=(a>=b)
print("\tOperation '(a>=b)':",ris_ab,"with type",type(ris_ab),"\n")
ris_ab=not (a==b)
print("\tOperation 'not(a==b)':",ris_ab,"with type",type(ris_ab))
ris_ab=(a<b) and (a==b)
print("\tOperation '(a<b) and (a==b)':",ris_ab,"with type",type(ris_ab))
ris_ab=(a>b) or (b<a)
print("\tOperation '(a>b) or (b<a)':",ris_ab,"with type",type(ris_ab))
ris_ab=(a==b) ^ (a!=b)
print("\tOperation '(a==b) ^ (a!=b)':",ris_ab,"with type",type(ris_ab),"\n")
