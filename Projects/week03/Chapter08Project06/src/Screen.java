import java.util.Arrays;
public class Screen {
	private boolean[][] _grid; 
	private Frame _frame;

	Screen(Frame frame) {
		setFrame(frame);
	}
	
	private void plot(int x,int y) {
		_grid[x][y] = true;
	}
	private void free(int x,int y) {
		_grid[x][y] = false;
	}
	public void print() {
		for (int y = 0;y < getFrame().getHeight();y++) { 
			for (int x = 0;x < getFrame().getWidth();x++) {
				boolean isFilled = _grid[x][y];
				String s = (isFilled)?"*":" ";
				System.out.print(s);
			}
			System.out.println();
		}
	}
	public void addLine(Point pointA, Point pointB) {
		if (!(getFrame().inBounds(pointA) || getFrame().inBounds(pointB))) {
			throw new IllegalArgumentException("Line out of bounds");
		}

		int x0 = pointA.getX();
		int y0 = pointA.getY();
		int x1 = pointB.getX();
		int y1 = pointB.getY();

		// Bresenham's line algorithm
		int deltaX = Math.abs(x0 - x1);
		int deltaY = Math.abs(y0 - y1);
		int stepX = x0<x1 ? 1 : -1;
		int stepY = y0<y1 ? 1 : -1;
		int error = ((deltaX>deltaY)?deltaX:-deltaY)/2; 
		int deltaError;

		for (;;) {
			plot(x0,y0);
			if (x0 == x1 && y0 == y1) 
				break;
			deltaError = error;
			if (deltaError > -deltaX) {
				error -= deltaY;
				x0 += stepX;
			}
			if (deltaError < deltaY) {
				error += deltaX;
				y0 += stepY;
			}
		}
	}
	public void removeLine(Point pointA, Point pointB) {
		if (!(getFrame().inBounds(pointA) || getFrame().inBounds(pointB))) {
			throw new IllegalArgumentException("Line out of bounds");
		}

		int x0 = pointA.getX();
		int y0 = pointA.getY();
		int x1 = pointB.getX();
		int y1 = pointB.getY();

		// Bresenham's line algorithm
		int deltaX = Math.abs(x0 - x1);
		int deltaY = Math.abs(y0 - y1);
		int stepX = x0<x1 ? 1 : -1;
		int stepY = y0<y1 ? 1 : -1;
		int error = ((deltaX>deltaY)?deltaX:-deltaY)/2; 
		int deltaError;

		for (;;) {
			free(x0,y0);
			if (x0 == x1 && y0 == y1) 
				break;
			deltaError = error;
			if (deltaError > -deltaX) {
				error -= deltaY;
				x0 += stepX;
			}
			if (deltaError < deltaY) {
				error += deltaX;
				y0 += stepY;
			}
		}
	}
	// boiler
	public boolean[][] getGrid() {
		boolean[][] publicGrid = new boolean[_grid.length][_grid[0].length];
		for (int x = 0;x < _grid.length; x++) {
			for (int y = 0;y < _grid[0].length; y++) { 
				publicGrid[x][y] = _grid[x][y];
			}
		}

		return publicGrid;
	}
	public Frame getFrame() {
		return _frame;
	}
	public void setFrame(Frame frame) {
		_frame = frame;
		if (_grid != null) {
			boolean[][] newGrid = new boolean[frame.getWidth()][frame.getHeight()];
			for (int x = 0;x < newGrid.length;x++) {
				for (int y = 0;y < newGrid[x].length;y++) {
					newGrid[x][y] = _grid[x][y];
				}
			}
			_grid = newGrid;
		} else {
			_grid = new boolean[frame.getWidth()][frame.getHeight()];
		}
	}

}