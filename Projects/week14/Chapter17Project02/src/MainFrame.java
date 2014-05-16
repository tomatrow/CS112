import javax.swing.JFrame;
import javax.swing.Action;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {
	public GameBoardPanel _gameBoard;
	public WinnerLabel _winnerLabel;

	private ActionListener _delegate;
	public static Dimension frameSize = new Dimension(300, 300);

	public MainFrame(ActionListener delegate) {
		super();
		_delegate = delegate;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameSize);
		setMinimumSize(frameSize);

		buildInterface();

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	private void buildInterface() {
		_gameBoard = new GameBoardPanel(3, _delegate);
		_winnerLabel = new WinnerLabel(" ");

		BorderLayout layout = new BorderLayout();	
		// layout.addLayoutComponent(_winnerLabel, BorderLayout.NORTH);
		// layout.addLayoutComponent(_gameBoard, BorderLayout.CENTER);
		setLayout(layout);

		add(_winnerLabel,BorderLayout.NORTH);
		add(_gameBoard,BorderLayout.CENTER);
	}
}