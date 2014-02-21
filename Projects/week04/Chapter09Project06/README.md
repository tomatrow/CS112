Write a program that can serve as a simple calculator. This calculator keeps track of a single number (of type `double`) that is called `result` and that starts out as 0.0. Each cycle allows the user to repeatedly add, subtract, multiply, or divide by a second number. The result of one of these operations becomes the new value of `result`. The calculation ends when the user enters the letter R for "result" (either in upper or lowercase). The user is allowed to do another calculation from the beginning as often as desired.

The input format is shown in the following sample dialogue. If the user enters any operator symbol other than +, −, *, or /, then an `UnknownOperatorException` is thrown and the user is asked to reenter that line of input. Defining the class `UnknownOperatorException` is part of this project.

Calculator is on. 
result = 0.0  
__+5__  
result + 5.0 = 5.0  
new result = 5.0  
__* 2.2__  
result * 2.2 = 11.0  
updated result = 11.0  
__% 10__  
% is an unknown operation.   
Reenter, your last line:  
__* 0.1__  
result * 0.1 = 1.1  
updated result = 1.1  
__r__  
Final result = 1.1  
Again? (y/n)  
__yes__  
result = 0.0  
__+10__  
result + 10.0 = 10.0  
new result = 10.0  
__/2__  
result / 2.0 = 5.0  
updated result = 5.0  
__r__  
Final result = 5.0   
Again? (y/n)  
__N__  
End of Program  
