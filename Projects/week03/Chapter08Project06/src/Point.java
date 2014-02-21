public class Point {
	int _x;
	int _y;
	Point(Point point) {
		this(point.getX(), point.getY());
	}
	Point(int x, int y) {
		setX(x);
		setY(y);
	}

	// getters
	public int getX() {
		return _x;
	}
	public int getY() {
		return _y;
	}

	// setters
	public void setX(int x) {
		if (x < 0)
			throw new IllegalArgumentException("Negative " + x + " x.");
		_x = x;
	}
	public void setY(int y) {
		if (y < 0)
			throw new IllegalArgumentException("Negative " + y + " y.");
		_y = y;
	}
	// Object
	@Override
	public String toString() {
		return "(" + this.getX() + "," + this.getY() + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		else if (o.getClass() != this.getClass()) {
			return false;
		}
		else  {
			Point p = (Point)o;
			boolean xIsEqual = this.getX() == p.getX();
			boolean yIsEqual = this.getY() == p.getY();
			return xIsEqual && yIsEqual;
		}
	}
	public Point copy() {
		return new Point(this);
	}
}