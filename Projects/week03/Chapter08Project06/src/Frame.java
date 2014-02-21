public class Frame {
	private int _width;
	private int _height;
	private Point _origin;
	
	Frame() {
		this(0,0);
	}
	Frame(int width, int height) {
		this(width,height,new Point(0,0));
	}
	Frame(int width, int height, Point origin) {
		setWidth(width);
		setHeight(height);
		setOrigin(origin);
	}
	Frame(Frame frame) {
		setWidth(frame.getWidth());
		setHeight(frame.getHeight());
		setOrigin(frame.getOrigin());
	}

	public boolean inBounds(Point point) {
		boolean xInBounds = (point.getX() < getOrigin().getX() + getWidth());
		boolean yInBounds = (point.getY() < getOrigin().getY() + getHeight());
		return xInBounds && yInBounds;
	}

	// Boiler
	public int getWidth() {
		return _width;
	}
	public int getHeight() {
		return _height;
	}
	public Point getOrigin() {
		return _origin.copy();
	}
	public void setWidth(int width) {
		if (width < 0)
			throw new IllegalArgumentException("Negative " + width + "width.");
		_width = width;
	}
	public void setHeight(int height) {
		if (height < 0)
			throw new IllegalArgumentException("Negative " + height + "height.");
		_height = height;
	}
	public void setOrigin(Point origin) {
		_origin = origin;
	}
	public Frame copy() {
		return new Frame(getWidth(),getHeight(),getOrigin());
	}
	@Override
	public String toString() {
		return "<" + getWidth() + "," + getHeight() + "," + getOrigin() + ">";
	}

}