public class GroupProject02 {
	public static void main(String[] args) {
		Grid grid = initGrid();
		displayGrid(grid);

		grid.objectAtLocation(new Point(0,0)).move();


	}
	public static void displayGrid(Grid grid) {
		for (int x = 0;x <= 19;x++) {
			for (int y = 0;y <= 19;y++) {
				System.out.print(organismToChar(grid.objectAtLocation(new Point(x,y))));
			}
			System.out.print("\n");
		}
	}

	public static String organismToChar(Organism o) {
		if (o == null)
			return " ";
		else 
			return o.toString();
	}
	public static Grid initGrid() {
		Grid grid = new Grid();

		for (int x = 0; x < grid.X_MAX;x++) {
			for (int y = 0;y < grid.Y_MAX;y++) {
				if (x < 5) {
					grid.gameBoard()[x][y]= new Ant(grid,new Point(x,y),0);
				} else if (x == 5 && y < 5) {
					grid.gameBoard()[x][y]= new Doodlebug(grid,new Point(x,y),0);
				}
			}
		}
		return grid;
	}
}