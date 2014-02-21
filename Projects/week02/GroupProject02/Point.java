public class Point {
	int _x;
	int _y;
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
		if (!(x > 19 || x < 0))
			_x = x;
	}
	public void setY(int y) {
		if (!(y > 19 || y < 0))
			_y = y;
	}

	// Badass
	public Point up() {
		if (this.getY() == 0) 
			return null;
		return new Point(this.getX()+1,this.getY());
	}
	public Point down() {
		if (this.getY() == 19) 
			return null;
		return new Point(this.getX()-1,this.getY());
	}
	public Point left() {
		if (this.getY() == 0) 
			return null;
		return new Point(this.getX(),this.getY()-1);
	}
	public Point right() {
		if (this.getY() == 19) 
			return null;
		return new Point(this.getX(),this.getY()+1);
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
}