public abstract class Figure {
	private Screen _screen;
	private Frame _frame;
	void draw() {
		printClassAndCallingMethod();
	}
	void erase() {
		printClassAndCallingMethod();
	}
	void center() {
		erase();

		Point center = new Point(getScreen().getFrame().getWidth()/2,getScreen().getFrame().getHeight()/2);
		int xOffset = getFrame().getWidth()/2;
		int yOffset = getFrame().getHeight()/2;
		Point offsetOrigin = new Point(center.getX() - xOffset, center.getY() - yOffset);
		Frame centeredFrame = new Frame(getFrame().getWidth(),getFrame().getHeight(),offsetOrigin);
		setFrame(centeredFrame);

		draw();
	}
	public void printClassAndCallingMethod() {
		Exception e = new Exception();
		e.fillInStackTrace();
		System.out.println(getClass().getName() + ": " + e.getStackTrace()[1].getMethodName());
	}

	// 
	public Point[] getCorners() {
		Point[] array = {upperLeft(),upperRight(),lowerRight(),lowerLeft()};
		return array;
	}
	public Point upperLeft() {
		return getFrame().getOrigin();	
	}
	public Point upperRight() {
		return new Point(getFrame().getOrigin().getX() + getFrame().getWidth(), getFrame().getOrigin().getY());	
	}
	public Point lowerLeft() {
		return new Point(getFrame().getOrigin().getX(), getFrame().getOrigin().getY() + getFrame().getHeight());	
	}
	public Point lowerRight() {
		return new Point(upperRight().getX(),lowerLeft().getY());	
	}
	

	// boiler
	public void setFrame(Frame frame) {
		_frame = frame;
	}
	public Frame getFrame() {
		return _frame;
	}
	public void setScreen(Screen screen) {
		_screen = screen;
	}
	public Screen getScreen() {
		return _screen;
	}

}