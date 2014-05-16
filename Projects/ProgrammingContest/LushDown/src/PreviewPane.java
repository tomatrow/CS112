import javax.swing.JEditorPane;
import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;
import javax.swing.text.BadLocationException;
import javax.swing.JScrollPane;

public class PreviewPane extends JScrollPane {
	private JEditorPane _editorPane;
	private String _viewType;

	public static final String HTML_TYPE = "text/html";
	public static final String PLAIN_TYPE = "text/plain";
	public static final String DEFAULT_TYPE = HTML_TYPE;

	public PreviewPane() {
		_editorPane = new JEditorPane(DEFAULT_TYPE,"");
		_editorPane.setEditable(false);
		_viewType = DEFAULT_TYPE;

		getViewport().add(_editorPane);
	}

	public void toggleViewType() {
		String currentText = _editorPane.getText();// setting content type resets text
		if (_viewType.equals(HTML_TYPE))  {
			_editorPane.setContentType(PLAIN_TYPE);
			_viewType = PLAIN_TYPE;
		} else {
			_editorPane.setContentType(HTML_TYPE);
			_viewType = HTML_TYPE;
		}
		_editorPane.setText(currentText);
	}

	public void updateHtml(DocumentEvent e) {
		Document doc = e.getDocument();
    	try {
    		String convertedMarkdown = MarkdownParse.parse(doc.getText(0, doc.getLength()));
			String html = "<html>\n<body>\n" + convertedMarkdown + "\n</body>\n</html>";
			_editorPane.setText(html);
    	} catch (BadLocationException exception) {
    		System.err.println("Requested bad offset: " + exception.offsetRequested());
    		exception.printStackTrace();
    		System.exit(1);// Theres no point continuing if the main feature doesn't work. 
    	}
	} 
}