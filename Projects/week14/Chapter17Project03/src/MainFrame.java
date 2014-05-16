import java.awt.GridLayout;
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
import java.util.ArrayList;

public class MainFrame extends JFrame {
	private ActionListener _delegate;
	public static Dimension frameSize = new Dimension(300, 200);
	public JLabel _resultLabel;
	public JLabel _operandLabel;
	public OperandPane _operandPane;
	public OperatorPane _operatorPane;


	public MainFrame(ActionListener delegate) {
		super();
		_delegate = delegate;
		setLayout(new GridLayout(2,2));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameSize);
		setMinimumSize(frameSize);

		buildInterface();

		// pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	private void buildInterface() {
		_resultLabel = new JLabel("Result: ");
		_operandLabel = new JLabel("Operand: ");
		_operandPane = new OperandPane(_delegate);
		_operatorPane = new OperatorPane(_delegate);

		add(_resultLabel);
		add(_operandLabel);
		add(_operandPane);
		add(_operatorPane);
	}
}