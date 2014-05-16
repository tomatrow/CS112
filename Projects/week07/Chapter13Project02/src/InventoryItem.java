public class InventoryItem implements Comparable<InventoryItem> {
	private String _name;
	private int _uniqueItemID;

	InventoryItem() {
		this("",0);
	}
	InventoryItem(String name, int uniqueItemID) {
		setName(name);
		setUniqueItemID(uniqueItemID);
	}

	// setters
	public void setName(String name) {
		_name = name;
	}
	public void setUniqueItemID(int uniqueItemID) {
		_uniqueItemID = uniqueItemID;
	}

	// getters 
	public String getName() {
		return _name;
	}
	public int getUniqueItemID() {
		return _uniqueItemID;
	}

	// Comparable 
	@Override
	public int compareTo(InventoryItem otherItem) {
		if (otherItem.getUniqueItemID() > this.getUniqueItemID())
			return -1;
		else if (otherItem.getUniqueItemID() == this.getUniqueItemID()) 
			return 0;
		else 
			return 1;
	}

	// Object
	@Override 
	public String toString() {
		return String.format("Name:%s|ID:%s",getName(),getUniqueItemID());
	}
}