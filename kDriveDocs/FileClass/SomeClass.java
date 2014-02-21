// SomeClass.java

import java.io.Serializable;

public class SomeClass implements Serializable
{
    private int number;
    private short digit;
    private char letter;
    private String name;

    public SomeClass( )
    {
        number = 0;
        digit = 10;
        letter = 'A';
        name = "June";
    }

    public SomeClass(int theNumber, short theShort, char theLetter, String theString)
    {
        number = theNumber;
        digit = theShort;
        letter = theLetter;
        name = theString;
    }

    public String toString( )
    {
        return "Number = " + number + ", "
        	               + " Digit = " + digit + ", " 
                           + " Letter = " + letter + ", "
                           + " String = " + name;
    }

}
