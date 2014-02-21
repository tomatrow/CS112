public class RoadBike extends Bicycle
{        
    // The RoadBike has one field
    // In millimeters (mm)    
    private int tireWidth;

    // the RoadBike subclass has
    // one constructor
    public RoadBike(int startCadence, int startSpeed, int startGear, 
                    int newTireWidth)
    {    
        super(startCadence, startSpeed, startGear);
        this.setTireWidth(newTireWidth);
    }   
        
    // the RoadBike subclass has two methods
    
    public int getTireWidth()
    {
        return this.tireWidth;
    }
    
    public void setTireWidth(int newTireWidth)
    {
    	this.tireWidth = newTireWidth;
    }
    
    public void printDescription()
    {
    	super.printDescription();
    	System.out.println("The RoadBike has " + getTireWidth() + " MM tires.\n");
    }   

}
