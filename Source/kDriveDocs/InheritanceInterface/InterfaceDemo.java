// This program demonstrates invoking methods specified in the Relatable
// Interface. The FinalExam class is used as an example which inherits from 
// the GradedActivity class and implements the Relatable interface by 
// overriding all the methods listed in the interface.

public class InterfaceDemo
{
	public static void main(String[] args)
	{
		// Exam #1 had 100 questions and the student missed 20 questions
		FinalExam exam1 = new FinalExam(100, 20);
		
		// Exam #2 had 100 questions and the student missed 30 questions
		FinalExam exam2 = new FinalExam(100, 30);
		
		// Display the exam scores
		System.out.println("Exam 1: " + exam1.getScore());
		System.out.println("Exam 2: " + exam2.getScore());
		
		// Compare the exam scores
		if (exam1.equals (exam2))
		   System.out.println("The exam scores are equal.");
		   
		if (exam1.isGreater(exam2))
		   System.out.println("Exam score 1 is the highest.");
		   
		if (exam1.isLess(exam2))
		   System.out.println("Exam score 1 is the lowest.");
		   
	}
}

