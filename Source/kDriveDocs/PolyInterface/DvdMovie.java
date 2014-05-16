// DvdMovie class

public class DvdMovie implements InterfaceRetailItem {
	private String title;
	private int runningTime;
	private double retailPrice;
	
	// Constructor
	public DvdMovie(String dvdTitle, int runTime, double dvdPrice) {
		title = dvdTitle;
		runningTime = runTime;
		retailPrice = dvdPrice;
	}
	
	// getTitle method
	public String getTitle() {
		return title;
	}
	
	// getRunningTime method
	public int getRunningTime() {
		return runningTime;
	}
	
	// getRetailPrice method (Required by the InterfaceRetailItem interface
	public double getRetailPrice() {
		return retailPrice;
	}
}