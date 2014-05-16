import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class OperandPane  extends JPanel { 
	public ArrayList<JButton> _operandButtons;
	public static final String[] operandStrings = {"1","2","3","4","5","6","7","8","9","0", "Clear", "Reset", "."};
	private ActionListener _delegate;
	public OperandPane(ActionListener delegate) {
		super();
		setLayout(new GridLayout(4,4));
		_delegate = delegate;
		buildPanel();
	}
	private void buildPanel() {
		int arraySize = operandStrings.length;
		_operandButtons = new ArrayList<JButton>(arraySize);
		for (int x = 0;x < arraySize;x++) {
			JButton button = new JButton(operandStrings[x]);
			button.addActionListener(_delegate);
			button.setActionCommand(operandStrings[x]);
			_operandButtons.add(button);
			add(button);
		}
	}
}

