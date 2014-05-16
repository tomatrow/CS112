// A comment to see if I can get the syntax highlighter to work right. 


/*
	File Name:          Chapter17Project02.java
	Programmer:         Andrew Caldwell
	Date Last Modified: May. 9, 2014
	Problem Statement:
		Create a Tic-Tac-Toe game using swing. 

	Overall Plan:
		Model 
			Game 
				GameDelegate 
			Board 
				BoardDelegate 
			Player 
		View 
			WinnerLabel 
			MainFrame
			GameBoardPanel
		Controller
			TicTacToeController
	

	Classes needed and Purpose:
	main class - Chapter17Project02
	Game 					- Game logic, 
	GameDelegate 			- Informs of end game 
	Board 					- Anything and everything using the board 
	BoardDelegate 			- Informs of board updates 
	Player 					- Holds player info 
	WinnerLabel 			- Displays the score board 
	MainFrame				- main window 
	GameBoardPanel			- holds the game panel 
	TicTacToeController		- glues everything together 
*/

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Chapter17Project02 {
	public static void main(String[] args) {
		TicTacToeController glue = new TicTacToeController();
	}	
	public static class TicTacToeController implements ActionListener,GameDelegate {
		Player[] _players = {new Player("Player1", Board.SquareState.X), new Player("Player2", Board.SquareState.O)};
		Game _game;
		MainFrame _frame;
		Player _currentPlayer;

		public TicTacToeController() {
			_game = new Game(this, _players[0], _players[1]);
			_frame = new MainFrame(this);
			_currentPlayer = _players[0];
		}
		public void gameOverWithResult(Game game, Game.GameResult result) {
			System.out.println("" + game.getBoard() + result);
			_frame._winnerLabel.setText(game.scoreBoard());
			game.getBoard().reset();
			_frame._gameBoard.reset();
		}
		public void actionPerformed(ActionEvent e) {
			String[] command = e.getActionCommand().split(":");
			int x = Integer.valueOf(command[0]);
			int y = Integer.valueOf(command[1]);
			Board.SquareState symbol = _currentPlayer.getSymbol();
			
			_game._board.set(x,y,symbol);
			_frame._gameBoard._gameButtons.get(3 * y + x).setText(buttonTextForSymbol(_game._board.get(x,y)));

			// swap players 
			_currentPlayer = (_currentPlayer.equals(_players[0]))?_players[1]:_players[0];
		}
		private String buttonTextForSymbol(Board.SquareState symbol) {
			if (symbol == Board.SquareState.X)
				return GameBoardPanel.X;
			else if (symbol == Board.SquareState.O)
				return GameBoardPanel.O;
			else 
				return GameBoardPanel.SPACE;
		}
	}
}