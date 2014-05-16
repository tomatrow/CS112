import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class ToolBarPane extends JToolBar  {
    public static final String TOGGLE_HTML = "toggleHtml";
    public static final String OPEN_FILE = "openFile";
    public static final String UPLOAD_MARKDOWN = "uploadMarkdown";
    public static final String SAVE_FILE = "saveFile";

    private ActionListener _delegate;

    private JButton _openButton;
    private JButton _saveButton;
    private JButton _uploadButton;
    private JButton _toggleButton;


	public ToolBarPane(ActionListener delegate) {
		super();
		setFloatable(false);
		_delegate = delegate;

		initializeButtons();
		addButtons();
	}
		
	private void initializeButtons() {
        _openButton = createButton("open", OPEN_FILE, "Open a file", "Open");
        _saveButton = createButton("save", SAVE_FILE, "Save to disk", "Save");
        _uploadButton = createButton("upload", UPLOAD_MARKDOWN, "Upload to PasteBin", "Upload");
        _toggleButton = createButton("html", TOGGLE_HTML, "Toggle HTML", "HTML");
	}

	private void addButtons() {
		add(_openButton);
		add(_uploadButton);
		add(_saveButton);
		add(_toggleButton);
    }

    private JButton createButton(String imageName, String command, String toolTipText, String alteritiveText) {
        String imageLocation = System.getProperty("user.dir") + "/src/resources/" + imageName + ".png";
       
		JButton button = new JButton();
        button.setActionCommand(command);
        button.setToolTipText(toolTipText);
        button.addActionListener(_delegate);

        button.setIcon(new ImageIcon(imageLocation, alteritiveText));

        return button;
    }
}