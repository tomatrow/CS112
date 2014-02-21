

/**
 Class for a person with a name and dates for birth and death.
 Class invariant: A Person always has a date of birth, and if the Person 
 has a date of death, then the date of death is equal to or later than the
 date of birth.
*/
public class Person
{
    private String name;
    private Date birthDate;
    private Date deathDate;//null indicates still alive.

    public Person(String initialName, Date birthDate, Date deathDate)
    {
        if (consistent(birthDate, deathDate))
        {
            name = initialName;
            birthDate = new Date(birthDate);
            if (deathDate == null)
                deathDate = null;
            else
                deathDate = new Date(deathDate);
         }
         else
         {
             System.out.println("Inconsistent dates. Aborting.");
             System.exit(0);
         }
    }

    public Person(Person original)
    {
        if (original == null)
        {
            System.out.println("Fatal error.");
            System.exit(0);
        }

        name = original.name;
        birthDate = new Date(original.birthDate);

        if (original.deathDate == null)
            deathDate = null;
        else
            deathDate = new Date(original.deathDate);
    }

    public void set(String newName, Date birthDate, Date deathDate)
    {
        if (consistent(birthDate, deathDate))
        {
                name = newName;
                birthDate = new Date(birthDate);
                if (deathDate == null)
                    deathDate = null;
                else
                    deathDate = new Date(deathDate);
         }
         else
         {
             System.out.println("Inconsistent dates. Aborting.");
             System.exit(0);
         }
}

    public String toString( )
    {
        String deathDateString;
        if (deathDate == null)
            deathDateString = ""; //Empty string
        else
            deathDateString = deathDate.toString( );

        return (name + ", " + birthDate + "-" + deathDateString);
    }

    public boolean equals(Person otherPerson)
    {
        if (otherPerson == null) 
            return false;
        else
            return (name.equals(otherPerson.name)
                    && birthDate.equals(otherPerson.birthDate)
                    && datesMatch(deathDate, otherPerson.deathDate) );
    }

    /**
     To match date1 and date2 must either be the same date or both be null.
    */
    private static boolean datesMatch(Date date1, Date date2)
    {
        if (date1 == null) 
            return (date2 == null);
        else if (date2 == null) //&& date1 != null
            return false;
        else // both dates are not null.
            return(date1.equals(date2));
    }

    /**
     Precondition: newDate is a consistent date of birth.
     Postcondition: Date of birth of the calling object is newDate.
    */
    public void setBirthDate(Date newDate)
    {
        if (consistent(newDate, deathDate))
            birthDate = new Date(newDate);
        else
        {
             System.out.println("Inconsistent dates. Aborting.");
             System.exit(0);
        }
    }

    /**
     Precondition: newDate is a consistent date of death.
     Postcondition: Date of death of the calling object is newDate.
    */
    public void setDeathDate(Date newDate)
    {
    
        if (!consistent(birthDate, newDate))
        {
            System.out.println("Inconsistent dates. Aborting.");
            System.exit(0);
        }

        if (newDate == null)
            deathDate = null;
        else
            deathDate = new Date(newDate);
    }

    public void setName(String newName)
    {
        name = newName;
    }

     /**
     Precondition: The date of birth has been set, and changing the year
     part of the date of birth will give a consistent date of birth.
     Postcondition: The year of birth is (changed to) newYear.
    */
    public void setBirthYear(int newYear)
    {
        if (birthDate == null) //Precondition is violated
        {
             System.out.println("Fata; Error. Aborting.");
             System.exit(0);
        }
        birthDate.setYear(newYear);
        if (!consistent(birthDate, deathDate))
        {
             System.out.println("Inconsistent dates. Aborting.");
             System.exit(0);
        }
    }
 
    /**
     Precondition: The date of death has been set, and changing the year
     part of the date of death will give a consistent date of death.
     Postcondition: The year of death is (changed to) newYear.
    */
    public void setDeathYear(int newYear)
    {
        if (deathDate == null) //Precondition is violated
        {
             System.out.println("Fata; Error. Aborting.");
             System.exit(0);
        }
        deathDate.setYear(newYear);
        if (!consistent(birthDate, deathDate))
        {
             System.out.println("Inconsistent dates. Aborting.");
             System.exit(0);
        }
    }

    public String getName()
    {
        return name;
    }

    public Date getBirthDate()
    {
        return new Date(birthDate);
    }

    public Date getDeathDate()
    {
        if (deathDate == null)
            return null;
        else
            return new Date(deathDate);
     }

    /**
     To be consistent, birthDate must not be null. If there is no date of
     death (deathDate == null), that is consistent with any birthDate.
     Otherwise, the birthDate must come before or be equal to the deathDate.
    */

    // Helper methods
    private static boolean consistent(Date birthDate, Date deathDate)
    {
        if (birthDate == null)
            return false;
        else if (deathDate == null)
            return true;
        else 
            return (birthDate.precedes(deathDate )
                      || birthDate.equals(deathDate ));
    }
}