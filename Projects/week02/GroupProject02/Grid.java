public class Grid {
	Organism[][] _gameBoard;
	public static int X_MIN = 0;
	public static int Y_MIN = 0;
	public static int X_MAX = 19;
	public static int Y_MAX = 19;

	Grid () {
		_gameBoard = new Organism[20][20];
		// Add 100 ants and 5 doodlebug
	}

	public Organism objectAtLocation(Point point) {
		if (point == null)
			throw new IllegalArgumentException("Impossible");
		return gameBoard()[point.getX()][point.getY()];
	}
	public Point[] surroundingPoints(Point point) {
		if (point == null)
			throw new IllegalArgumentException("Impossible");
		Point[] surroundingPoints = {point.right(),point.up(),point.left(),point.down()};
		return surroundingPoints;// returns nulls if they are out of bounds
	}

	// Board logic 
	public void kill(Point point) {
		this.gameBoard()[point.getX()][point.getY()] = null;
	}
	public void transfer(Point from, Point to) {
		gameBoard()[from.getX()][from.getY()] = gameBoard()[to.getX()][to.getY()];
		gameBoard()[from.getX()][from.getY()] = null;
	}
	public void randomizeGrid() {
		// Someday
	}
	// getters and setters
	public Organism[][] gameBoard() {
		return _gameBoard;
	}


}