// Compact Disc class

public class CompactDisc implements InterfaceRetailItem {
	private String title;
	private String artist;
	private double retailPrice;
	
	// Constructor
	public CompactDisc(String cdTitle, String cdArtist, double cdPrice) {
		title = cdTitle;
		artist = cdArtist;
		retailPrice = cdPrice;
	}
	
	// getTitle method
	public String getTitle() {
		return title;
	}
	
	// getArtist method
	public String getArtist() {
		return artist;
	}
	
	// getRetailPrice method (Required by the InterfaceRetailItem interface
	public double getRetailPrice() {
		return retailPrice;
	}
}