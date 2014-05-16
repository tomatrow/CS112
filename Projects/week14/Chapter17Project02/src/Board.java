import java.util.Arrays;

public class Board {
	public static enum SquareState {
		X, O, CLEAR;
		public Game.GameResult resultForSymbol() {
			if (this == X)
				return Game.GameResult.X;
			else if (this == O)
				return Game.GameResult.O;
			else 
				return Game.GameResult.NONE;
		}
	};
	public static final int EDGE_LENGTH = 3;

	private SquareState[] _internalBoard;
	private BoardDelegate _delegate;
	Board() {
		this(null);
	}
	Board(BoardDelegate delegate) {
		_internalBoard = createBoard();
		_delegate = delegate;
	}

	public void reset() {	
		_internalBoard = createBoard();
	}

	// Setters and Getters
	public SquareState get(int index) {
		if (!isInRange(index)) 
			throw new IllegalArgumentException("Out of bounds");
		return _internalBoard[index];
	}
	public SquareState get(int x, int y) {
		if (!isInRange(x,y)) 
			throw new IllegalArgumentException("Out of bounds");
		return _internalBoard[EDGE_LENGTH * y + x];
	}
	private void set(int index, SquareState state) {
		if (!isInRange(index)) 
			throw new IllegalArgumentException("Out of bounds");
		if (state != SquareState.CLEAR)// a player can't be clear.
			_internalBoard[index] = state;
	}
	public void set(int x, int y, SquareState state) {
		int index = (EDGE_LENGTH * y + x);
		set(index, state);
		if (_delegate != null)
			_delegate.boardUpdated(this, x, y);
	}
	public boolean isFull() {
		int usedSpace = 0;
		for (SquareState space : _internalBoard) {
			if (space != SquareState.CLEAR)
				usedSpace++;
		}
		return (usedSpace == _internalBoard.length)?true:false;
	}

	public SquareState[][] possibleWinPaths() {
		int edgeLength = EDGE_LENGTH;
		// Each row, coloumn, and diagonal is used.
		int possibleWinPathsSize = edgeLength * edgeLength + 2;
		SquareState[][] possibleWinPaths = new SquareState[possibleWinPathsSize][edgeLength];

		int index = 0;
		
		for (int i = 0;i < edgeLength;i++,index++)
			possibleWinPaths[index] = getRow(i);
		for (int i = 0;i < edgeLength;i++,index++)
			possibleWinPaths[index] = getColumn(i);
		possibleWinPaths[index] = getDiagonal(true);
		index++;
		possibleWinPaths[index] = getDiagonal(false);
		// dont need to ingrement the index 

		return possibleWinPaths;
	}

	// Private helper methods
	private SquareState[] getRow(int heightIndex) {
		int y = heightIndex;
		SquareState[] row = new SquareState[EDGE_LENGTH];
		for (int x = 0; x < EDGE_LENGTH;x++ ) {
			row[x] = get(x,y);
		} 
		// System.out.println("At height " + heightIndex + " " + Arrays.toString(row));
		return row;
	}
	private SquareState[] getColumn(int widthIndex) {
		int x = widthIndex;
		SquareState[] column = new SquareState[EDGE_LENGTH];
		for (int y = 0; y < EDGE_LENGTH;y++ ) {
			column[y] = get(x,y);
		}
		// System.out.println("At width " + widthIndex + " " + Arrays.toString(column));
		return column;
	}
	private SquareState[] getDiagonal(boolean isLeftCorner) {
		SquareState[] diagonal = new SquareState[EDGE_LENGTH];
		if (isLeftCorner) {
			for (int x = 0,y = 0;x < EDGE_LENGTH;x++,y++) 
				diagonal[x] = get(x,y);
		} else  {
			for (int x = EDGE_LENGTH - 1 ,y = 0;y < EDGE_LENGTH;x--,y++) 
				diagonal[y] = get(x,y);
		}
		System.out.println("At " + isLeftCorner + " " + " " + Arrays.toString(diagonal));
		return diagonal;
	}

	
	private static SquareState[] createBoard() {
		SquareState[] board = new SquareState[EDGE_LENGTH * EDGE_LENGTH];

		for (int x = 0;x < board.length;x++) 
			board[x] = SquareState.CLEAR;

		return board;
	}
	private boolean isInRange(int index) {
		int maxIndex = _internalBoard.length;
		boolean valid = (index <= maxIndex && index >= 0);
		return valid;
	}
	private boolean isInRange(int x, int y) {
		int maxIndex = _internalBoard.length;
		boolean valid = (x >= 0 && y >= 0 && x <= maxIndex && y <= maxIndex);
		return valid;
	}

	// Object 
	@Override
	public String toString() {
		return Arrays.toString(_internalBoard);
	}
}