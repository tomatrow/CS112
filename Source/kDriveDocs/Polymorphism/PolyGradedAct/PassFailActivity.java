// This class stores a numeric score and determines whether the score
// is passing or failing. It uses the super class GradedActivity.

public class PassFailActivity extends GradedActivity
{
	private double minPassingScore;      // Minimum passing score
	
	// The constructor accepts the numeric score and the minimum
	// passing score as its arguments.
	public PassFailActivity(double s, double mps)
	{
		super.setScore(s);
		minPassingScore = mps;
	}
	
	// Call the superclass's setScore method to set the numeric score
	//	setScore(numericScore);

	// The getGrade method returns a letter grade determined from the 
	// score field. This method overrides the superclass method.
	public char getGrade()
	{
		char letterGrade;      // To hold the letter grade
		
		if (super.getScore() >= minPassingScore)
		   letterGrade = 'P';
		else
		   letterGrade = 'F';
		   
	    return letterGrade;
	}
}