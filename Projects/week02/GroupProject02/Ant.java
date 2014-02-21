import java.util.Arrays;

public class Ant extends Organism {
	Ant(Grid grid, Point point, int stepCount) {
		super(grid,  point,stepCount);
	}

	@Override
	public void move() { 
		Point[] surroundingPoints = this.getGrid().surroundingPoints(this.getPoint());
		Point[] possiblePoints = new Point[4];
		for (Point p : surroundingPoints) {
			if (p != null && !p.equals(this.getPoint())) {
				if (this.getGrid().objectAtLocation(p) == null) {

				} 

			}
		}
	}
	@Override
	public void breed() {

	}
	@Override
	public boolean isEdible() {
		return true;
	}
	// Object 
	@Override
	public String toString() {
		return "O";
	}
	private class Points {
		private Point[] _points;
		private int _length;
		Points() {
			_points = new Point[4];
			_length = 0;
		}
		public addPoint(Point point) {
			if (point != null) {
				for (int x = 0;x < 4;x++) {
					if (_points == null) {
						_points = point;
					}
				}

			}
		}
		public Point[] getPoints() {
			return _points;
		}
	}
}