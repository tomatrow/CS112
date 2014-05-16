import com.apple.eawt.Application;
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.swing.text.BadLocationException;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JSplitPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Image;

public class MainPanel extends JFrame {
	public static final File MARKDOWN_FILE = new File(System.getenv("PWD") + "/bld/" + "markdown.md");
	public static final Image MARKDOWN_ICON = new ImageIcon(System.getProperty("user.dir") + "/src/resources/markdown.png").getImage();

	public static final int HEIGHT = 300;
	public static final int WIDTH = 500;

	public static final int NO_WEIGHT = 0;
	public static final int MIN_WEIGHT = 1;
	public static final int MAX_WEIGHT = 100;

	private EditorPane _editor;
	private PreviewPane _preview;
	private JPanel _rootPanel;
	private JSplitPane _editorAndPreviewPane;
	private ToolBarPane _toolBar;

	private GridBagLayout _gridBagLayout;
	private GridBagConstraints _constraints;

	public MainPanel() {
		super();
		setup();
		
		buildRootPanel();
		setContentPane(_rootPanel);

		setVisible(true);
		_editorAndPreviewPane.setDividerLocation(0.5);
		Application.getApplication().setDockIconImage(MARKDOWN_ICON);// Only works on OSX
	}
	// 
	private void setup() {
		setTitle("LushDown");
		setMinimumSize(new Dimension(WIDTH,HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Center window
	}
	private void buildRootPanel() {
		initializePanels();
		layoutRootPanel();
	}
	private void initializePanels() {
		// All the glue code. 
		_preview = new PreviewPane();
		_editor = new EditorPane(textChangeListener());
		_editor.setMarkdown(readMarkdownFromBackup());
		_editorAndPreviewPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, _editor, _preview);
		_editorAndPreviewPane.setForeground(Color.green);
		_editorAndPreviewPane.setBackground(Color.green);
		_toolBar = new ToolBarPane(buttonClickListener());
		_rootPanel = new JPanel();
	}
	private void layoutRootPanel() {
		_gridBagLayout = new GridBagLayout();
		_rootPanel.setLayout(_gridBagLayout);
		
		_constraints = new GridBagConstraints();
		_constraints.fill = GridBagConstraints.BOTH;

		_constraints.gridx = NO_WEIGHT;
		_constraints.gridy = NO_WEIGHT;
		_constraints.weightx = MIN_WEIGHT;
		_constraints.weighty = MIN_WEIGHT;
		_rootPanel.add(_toolBar, _constraints);

		_constraints.gridx = NO_WEIGHT;
		_constraints.gridy = MIN_WEIGHT;
		_constraints.weightx = MIN_WEIGHT;
		_constraints.weighty = MAX_WEIGHT;// We want the editor to take up all the space. 
		_rootPanel.add(_editorAndPreviewPane, _constraints);
	}

	// Listeners ffor the Editor and preview panes
	private DocumentListener textChangeListener() {
		DocumentListener listener = new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		    }
		    public void removeUpdate(DocumentEvent e) {
		    	_preview.updateHtml(e);
		    	backupMarkdown(e);
		    }
		    public void insertUpdate(DocumentEvent e) {
		    	_preview.updateHtml(e);
		    	backupMarkdown(e);
			}
		};

		return listener;
	}
	private ActionListener buttonClickListener() {
		ActionListener listener = new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();

		        if (ToolBarPane.TOGGLE_HTML.equals(command)) {
					toggleHtml();
		        } else if (ToolBarPane.OPEN_FILE.equals(command)) {
					openMarkdown();
		        } else if (ToolBarPane.UPLOAD_MARKDOWN.equals(command)) {
		        	uploadMarkdown();
		        } else if (ToolBarPane.SAVE_FILE.equals(command)) {
		        	saveMarkdown();
		        }
			}
		};

		return listener;
	}

	// Individual button actions
	private void toggleHtml() {
		_preview.toggleViewType();
	}
	private void openMarkdown() {
		File markdownFile = getUserFile(_rootPanel);
		if (markdownFile != null) {
			String markdownText = getFileText(markdownFile);
			_editor.setMarkdown(markdownText);
		}
	}
	private void uploadMarkdown() {
		String markdown = _editor.getMarkdown();
		String firstLine = markdown.split("\\n")[0];
		PasteBinUpload upload = new PasteBinUpload(markdown, firstLine + ".md");

		JTextArea textArea = new JTextArea(10, 10);
		textArea.setText(upload.uploadUrl());
		textArea.setWrapStyleWord(true);
	    textArea.setLineWrap(true);
	    textArea.setCaretPosition(0);
	    textArea.setEditable(false);

	    JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Paste Bin URL", JOptionPane.INFORMATION_MESSAGE);	
	}

	private void saveMarkdown() {
		JFileChooser fileChooser = new JFileChooser();
		String markdown = _editor.getMarkdown();

		int saveResult = fileChooser.showSaveDialog(null);

		if (saveResult == JFileChooser.APPROVE_OPTION) {	
			saveFile(fileChooser.getSelectedFile(),markdown);
	    }
	}

	private void saveFile(File file, String markdown) {
	        try (FileWriter fileWriter = new FileWriter(file)) {
	            fileWriter.write(markdown);
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	// Private helper methods
	private File getUserFile(JPanel parentPanel) {
		JFileChooser fileChooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Markdown documents", "md", "markdown", "txt");
	    fileChooser.setFileFilter(filter);
	    int result = fileChooser.showOpenDialog(parentPanel);
	    if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();	
			return selectedFile;
	    }
	    return null;
	}
	private String getFileText(File file) {
		String output = "";

		try {
			ArrayList<String>lines;
			lines = new ArrayList<String>(Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));	
			for (String line : lines) {
				output += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	

		return output;
	}
	// Persistance 
	private String readMarkdownFromBackup() {
		return getFileText(MARKDOWN_FILE);
	}
	private void backupMarkdown(DocumentEvent e) {
    	try {
	    	Document doc = e.getDocument();
	    	saveFile(MARKDOWN_FILE,doc.getText(0, doc.getLength()));
    	}
    	catch (BadLocationException exception) {
	 		System.err.println("Requested bad offset: " + exception.offsetRequested());
    		exception.printStackTrace();
    	}
	}
}