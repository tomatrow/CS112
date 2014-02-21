public class Doodlebug extends Organism {
	Doodlebug(Grid grid, Point point, int stepCount) {
		super(grid, point,stepCount);
	}
	@Override
	public void move() {
		Point[] surroundingPoints = this.getGrid().surroundingPoints(this.getPoint());
	}
	@Override
	public boolean isEdible() {
		return false;
	}
	@Override 
	public void breed() {

	}
	@Override
	public String toString() {
		return "X";
	}
}