public class MountainBike extends Bicycle
{        
    // the MountainBike subclass has one field
    public  String suspension;
    
    // the MountainBike subclass has one constuctor
    public MountainBike(int startCadence, int startSpeed, int startGear,
                        String suspensionType)
    {    
        super(startCadence, startSpeed, startGear);
        this.setSuspension(suspensionType);        
    }   
        
    // the MountainBike subclass has two methods
    public String getSuspension()
    {
        return this.suspension;
    }
    
    public void setSuspension(String suspensionType)
    {
    	this.suspension = suspensionType;
    }
        
    public void printDescription()
    {
    	super.printDescription();
    	System.out.println("The MountainBike has a " + getSuspension() + 
    	                   " suspension.");
    }      

}
