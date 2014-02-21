// A superclass that stores a grade for a graded activity in a course

public class GradedActivity
{
	private double score;
	
	// pragma mark - accessors
	public void setScore(double s) {
		score = s;
	}
	public double getScore() {
		return score;
	}
	
	public char getGrade()
	{
		char letterGrade;      // To hold the grade
		
		if (score >= 90)
		   letterGrade = 'A';
		else if (score >= 80)
		   letterGrade = 'B';
		else if (score >= 70)
		   letterGrade = 'C';
		else if (score >= 60)
		   letterGrade = 'D';
		else
		   letterGrade = 'F';
		   
	    return letterGrade;
	}
}