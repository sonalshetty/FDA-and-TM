The project contains three java classes and 4 text files which has the transtion table.
Java classes:
1. FiniteAutomation.java
2. DFA.java
3. TM.Java

Text files
DFA:
	1.Divide_by_3.txt
	2.Substring_0100_checking.txt
TM:
	1. Accept_a.txt
	2. Accept_zero_power_2^n.txt
	


Please import the files into eclipse and run it.




The output received.
------------------------------------------------------------------------------
Choose a machine: 
 1.Deterministic Finite Automation 
 2.Turing Machine
1

You chose : 1

Available Deterministic Finite Automation and Languages:
Machine		Language
--------	--------
M1		L={w/w divisble by 3}
M2		L={w/w string should contains substring '0100'}

Select a Deterministic Finite Automation
m1

M1 Loading..
M1 Loaded.

Enter a String:
011

q0 , 0 -> q0
q0 , 1 -> q1
q1 , 1 -> q0


String 011 is ACCEPTED

Try again ?
y
----------------------------------------------------------------------------
Choose a machine: 
 1.Deterministic Finite Automation 
 2.Turing Machine
1

You chose : 1

Available Deterministic Finite Automation and Languages:
Machine		Language
--------	--------
M1		L={w/w divisble by 3}
M2		L={w/w string should contains substring '0100'}

Select a Deterministic Finite Automation
m2

M2 Loading..
M2 Loaded.

Enter a String:
0100

q0 , 0 -> q1
q1 , 1 -> q2
q2 , 0 -> q3
q3 , 0 -> q4


String 0100 is ACCEPTED

Try again ?
y
----------------------------------------------------------------------------
Choose a machine: 
 1.Deterministic Finite Automation 
 2.Turing Machine
2

You chose : 2

Available Turing Machines and Languages:
Machine		Language
--------	--------
M1		L={w/w accept single a}
M2		L={w/w accept 0^2^n 0's|n>=0}

Select a Turing Machine
m1

M1 Loading..
M1 Loaded.

Enter a String:
a

q0 , a -> ; a -> 0,r
q1 , $ -> q1; $ -> $,r

String a is ACCEPTED

Try again ?
y
----------------------------------------------------------------------------
Choose a machine: 
 1.Deterministic Finite Automation 
 2.Turing Machine
2

You chose : 2

Available Turing Machines and Languages:
Machine		Language
--------	--------
M1		L={w/w accept single a}
M2		L={w/w accept 0^2^n 0's|n>=0}

Select a Turing Machine
00

Input not recognized
Try again ?
y
----------------------------------------------------------------------------
Choose a machine: 
 1.Deterministic Finite Automation 
 2.Turing Machine
2

You chose : 2

Available Turing Machines and Languages:
Machine		Language
--------	--------
M1		L={w/w accept single a}
M2		L={w/w accept 0^2^n 0's|n>=0}

Select a Turing Machine
m2

M2 Loading..
M2 Loaded.

Enter a String:
00

q1 , 0 -> ; 0 -> $,r
q2 , 0 -> q2; 0 -> x,r
q3 , $ -> q3; $ -> ,l
q5 , x -> q5; x -> ,l
q5 , $ -> q5; $ -> ,r
q2 , x -> q2; x -> ,r
q2 , $ -> q2; $ -> ,r

String 00 is ACCEPTED

Try again ?
n
Thank you!
----------------------------------------------------------------------------