import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentListener;

public class EditorPane extends JScrollPane {
	private JTextPane _textPane;
	public EditorPane(DocumentListener listener) {
		super();
		_textPane = new JTextPane();
		_textPane.getDocument().addDocumentListener(listener);
		getViewport().add(_textPane);
	}
	public void setMarkdown(String markdown) {
		_textPane.setText(markdown);
	}
	public String getMarkdown() {
		return _textPane.getText();
	}
}