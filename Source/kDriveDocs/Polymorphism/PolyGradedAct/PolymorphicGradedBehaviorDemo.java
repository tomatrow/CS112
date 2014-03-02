// This program demonstrates polymorphic beharvior using the GradedActivity,
// FinalExam and PassFailActivity classes. Graded Activity is the Superclass.
// FinalExam and PassFailActivity are subclasses of GradedActivity.

public class PolymorphicGradedBehaviorDemo
{
	public static void main(String[] args)
	{
		// Create an array of GradedActivity references.
		GradedActivity[] tests = new GradedActivity[3];
		
		// The first test is a regular exam with a numeric score of 95.
		tests[0] = new GradedActivity();
		tests[0].setScore(95);
		
		// The second test is a pass/fail test. The student missed
		// 5 out of 20 question, and the minimum passing grade is 60.
		tests[1] = new PassFailActivity(78,60);
		tests[1].setScore(78);
		
		// The third test is the final exam. There were 50 questions
		// and the student missed 7.
		tests[2] = new FinalExam(50,7);
		
		// Display the grades.
		for (int index = 0; index < tests.length; index++)
		{
			System.out.println("Test " + (index + 1) + "; " +
			       "score " + tests[index].getScore() + ", grade " +
			        tests [index].getGrade());
		}
		
		// The following code passes objects of the FinalExam and the 
		// PassFailActivity classes to the displayGrades method.
		GradedActivity exam1 = new FinalExam(100, 4);
		GradedActivity exam2 = new FinalExam(100, 21);
		GradedActivity exam3 = new PassFailActivity(84,60);
		GradedActivity exam4 = new PassFailActivity(59,60);
		displayGrades(exam1);    // Pass a FinalExam object;
		displayGrades(exam2);    // Pass a FinalExam object;
		displayGrades(exam3);    // Pass a PassFailActivity object;
		displayGrades(exam4);    // Pass a PassFailActivity object;
		
		// Use the instanceof Operator to see if an object is an instance
		// of a particular class
		if (tests[0] instanceof GradedActivity)
			System.out.println("Yes,tests[0] is a GradedActivity.");
		else
			System.out.println("No,tests[0] is not a GradedActivity.");
			
		if (tests[1] instanceof GradedActivity)
			System.out.println("Yes,tests[1] is a GradedActivity.");
		else
			System.out.println("No,tests[1] is not a GradedActivity.");
		if (tests[2] instanceof GradedActivity)
			System.out.println("Yes,tests[2] is a GradedActivity.");
		else
			System.out.println("No,tests[2] is not a GradedActivity.");
			
		// Check to see if a GradedActivity object has an Is-A relationship 
		// with the FinalExam  and/or the PassFailActivity class.	
		if (tests[0] instanceof FinalExam)
			System.out.println("Yes, tests[0] is a FinalExam.");
		else
			System.out.println("No, tests[0] is not a FinalExam.");
		if (tests[0] instanceof PassFailActivity)
			System.out.println("Yes, tests[0] is a PassFailActivity.");
		else
			System.out.println("No, tests[0] is not a PassFailActivity.");
	}
	
	// Use parameters to polymorphically accept arguments to methods
	// The parameter g in this method is a GradedActivity variable but
	// it can be used to accept arguments of any type that inherits
	// from GradedActivity.
	public static void displayGrades(GradedActivity g)
	{
		System.out.println("Score " + g.getScore() +
		                   ", grade " + g.getGrade());
	}	
		
}	