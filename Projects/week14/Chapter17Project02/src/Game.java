public class Game implements BoardDelegate {
	public static enum GameResult {
		X, O, NONE;

	};
	public final Board _board;
	private GameDelegate _delegate;
	private Player _playerOne;
	private Player _playerTwo;
	

	public Game(GameDelegate delegate, Player playerOne, Player playerTwo) {
		_delegate = delegate;
		_board = new Board(this);
		_playerOne = playerOne;
		_playerTwo = playerTwo;
	}
	// Board Delegate 
	public void boardUpdated(Board board, int x, int y) {
		boolean safeDelegate = (_delegate != null);
		Player winningPlayer = checkForWin();
		if (winningPlayer == null &&_board.isFull()) {
			if (safeDelegate)
				_delegate.gameOverWithResult(this,GameResult.NONE);
		} else {
			if (winningPlayer != null)
				_delegate.gameOverWithResult(this,winningPlayer.getSymbol().resultForSymbol());
		}
	}
	private Player checkForWin() {
		Board.SquareState[][] possibleWinPaths = _board.possibleWinPaths();
		if (playerDidWin(_playerOne, possibleWinPaths)) {
			_playerOne.setWins(_playerOne.getWins() + 1);
			return _playerOne;
		}
		else if (playerDidWin(_playerTwo, possibleWinPaths)) {
			_playerTwo.setWins(_playerTwo.getWins() + 1);
			return _playerTwo;
		}
		else 
			return null;
	}

	private boolean playerDidWin(Player player, Board.SquareState[][] possibleWinPaths) {
		Board.SquareState symbol = player.getSymbol();
		
		for (Board.SquareState[] path: possibleWinPaths) {
			if (onlyHasSameSymbol(path,symbol)) {
				return true;
			}
		}

		return false;
	}
	private boolean onlyHasSameSymbol(Board.SquareState[] path, Board.SquareState symbol) {
		for (Board.SquareState state : path) 
			if (state != symbol) 
				return false;
		return true;// We reached the end with the same symbol
	}
	public Board getBoard() {
		return _board;
	}
	public String scoreBoard() {
		return String.format("%s:%d    %s:%d", _playerOne.getName(),_playerOne.getWins(), _playerTwo.getName(),_playerTwo.getWins());
	}
}