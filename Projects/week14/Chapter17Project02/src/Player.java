public class Player {
	private String _name;
	private int _wins;
	private Board.SquareState _symbol;

	private int _boardEdgeLength;

	public Player() {
		this("Player", Board.SquareState.CLEAR);
	}
	public Player(String name, Board.SquareState symbol) {
		_name = name;
		_symbol = symbol;
		setWins(0);
	}
	public void setWins(int wins) {
		_wins = wins;
	}
	public int getWins() {
		return _wins;
	}
	public String getName() {
		return _name;
	}
	public Board.SquareState getSymbol() {
		return _symbol;
	}

	// Object 
	public boolean equals(Object o) {
		if (o == null)
			return false;
		else if (!o.getClass().equals(this.getClass()))
			return false;
		else {
			Player otherPlayer = (Player)o;
			
			boolean sameName = this._name.equals(otherPlayer._name);
			boolean sameWins = this.getWins() == otherPlayer.getWins();
			boolean sameSymbol = this.getSymbol() == otherPlayer.getSymbol();
			boolean sameLength = this._boardEdgeLength == otherPlayer._boardEdgeLength;

			return sameName && sameWins && sameSymbol && sameLength;
		}

	}
}