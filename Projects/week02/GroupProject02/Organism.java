public abstract class Organism {
	private Point _point;
	private Grid _grid;
	private int _stepCount;

	Organism() {
		this(null,null,0);
	}

	Organism(Grid grid, Point point, int stepCount) {
		setPoint(point);
		setGrid(grid);
		setStepCount(stepCount);
	}
	// Abstract methods
	abstract public void move();
	abstract public void breed();
	abstract public boolean isEdible();
	
	// setters
	public void setPoint(Point point) {
		if (point == null)
			throw new IllegalArgumentException("Can't do that");
		_point = point;
	}
	public void setStepCount(int stepCount) {
		if (stepCount > 4 || stepCount < 0)

		_stepCount = stepCount;
	}
	public void setGrid(Grid grid) {
		if (grid == null)
			throw new IllegalArgumentException("Nope");
		_grid = grid;
	}
	
	// getters
	public int getStepCount() {
		return _stepCount;
	}
	public Point getPoint() {
		return _point;
	}
	public Grid getGrid() {
		return _grid;
	}

}