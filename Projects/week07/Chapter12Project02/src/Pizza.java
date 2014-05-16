public class Pizza {
	public static enum SIZE_TYPE {
		SMALL,MEDIUM,LARGE;

		private int cost;
		static {
			SMALL.cost = 8;
			MEDIUM.cost = 10;
			LARGE.cost = 12;
		}
		public int getCost() {
			return cost;
		}
	}
	
	private boolean _hasPepperoni;
	private boolean _hasSausage;
	private boolean _hasMushrooms;
	private SIZE_TYPE _size;

	Pizza() {
		this(false,false,false,SIZE_TYPE.SMALL);
	}
	Pizza(boolean hasPepperoni,boolean hasSausage, boolean hasMushrooms, SIZE_TYPE size) {
		setPepperoni(hasPepperoni);
		setMushrooms(hasMushrooms);
		setSausage(hasSausage);
		setSize(size);
	}

	// setters 
	public void setSize(SIZE_TYPE size) {
		_size = size;
	}
	public void setPepperoni(boolean hasPepperoni) {
		_hasPepperoni = hasPepperoni;
	}
	public void setMushrooms(boolean hasMushrooms) {
		_hasMushrooms = hasMushrooms;
	}
	public void setSausage(boolean hasSausage) {
		_hasSausage = hasSausage;
	}

	// getters 
	public SIZE_TYPE getSize() {
		return _size;
	}
	public boolean hasPepperoni() {
		return _hasPepperoni;
	}
	public boolean hasMushrooms() {
		return _hasMushrooms;
	}
	public boolean hasSausage() {
		return _hasSausage;
	}


	// Derived data
	public int getCost() {
		int cost = 0;

		// Toppings are one doaller 
		cost += getNumToppings();
		cost += getSize().getCost();

		return cost;
	}
	public int getNumToppings() {
		int count = 0;
		if (hasSausage())
			count++;
		if (hasMushrooms())
			count++;
		if (hasPepperoni())
			count++;
		return count;
	}


	// Object
	@Override 	
	public String toString() {
		return String.format("%s,%s,%s,%s",getSize(),hasSausage(),hasMushrooms(),hasPepperoni());
	}

}