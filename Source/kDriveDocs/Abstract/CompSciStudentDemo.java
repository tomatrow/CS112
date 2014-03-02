// This program demonstrates the CompSciStudent class.

public class CompSciStudentDemo
{
	public static void main(String[] args)
	{
		// Create a CompSciStudent object
		CompSciStudent csStudent = new CompSciStudent("Jane Doe", "5897", 2010);
		
		// Store values for math, CS, and General Ed hours.
		csStudent.setMathHours(12);
        csStudent.setCompSciHours(20);
        csStudent.setGenEdHours(40);
        
        
        // Display the student's data.
        System.out.println(csStudent);
        
        // Display the number of remaining hours.
        System.out.println("Hours remaining: " +
                           csStudent.getRemainingHours());
     }
}
