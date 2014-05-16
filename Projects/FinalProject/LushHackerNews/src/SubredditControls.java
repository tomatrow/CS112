import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubredditControls extends JPanel {
	public JTextField _field;
	public JButton _button;
	public SubredditControlsDelegate _delegate;

	public SubredditControls() {
		super();
		_field = new JTextField("subreddit", 20);
		_button = new JButton("load");
		add(_field);
		add(_button);
	}
	public void setDelegate(SubredditControlsDelegate delegate) {
		_delegate = delegate;
		_button.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (_delegate != null)
							_delegate.buttonClickedWithText(_field.getDocument().getText(0,_field.getDocument().getLength()));
					}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		);
	}
}