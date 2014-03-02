// The Student class is an abstract class that holds general data
// about a student. Classes representing specific types of students
// should inherit from this class.

public abstract class Student
{
	private String name;
	private String idNumber;
	private int yearAdmitted;
	
	// The Constructor accepts as arguments the student's name,
	// ID number, and the year admitted to the school.
	public Student(String n, String id, int year)
	{
		name = n;
		idNumber = id;
		yearAdmitted = year;
	}
	
	// toString method
	public String toString()
	{
		String str;
		
		str = "Name: " + name +
		      "\nID Number: " + idNumber +
		      "\nYear Admitted: " + yearAdmitted;
		      
		return str;
	}
	
	// The getRemainingHours method is abstract. It must be overridden
	// in a subclass. The method is intended to return the number of 
	// hours left to take in the student's major. It is abstract since it
	// is intended to be used in classes designed for specific majors.
	public abstract int getRemainingHours();
}