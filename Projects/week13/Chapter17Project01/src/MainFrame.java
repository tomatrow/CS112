import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;


public class MainFrame extends JFrame {
	public static final String TRANSLATE = "translate";

	JTextArea _editorpane; 
	JTextArea _previewPane;
	JButton _translateButton;

	public MainFrame() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Center window
		setLayout(new FlowLayout(FlowLayout.RIGHT));

		buildInterface();


		pack();
		setVisible(true);
	}
	private void buildInterface() {
		_translateButton = createButton("translate", TRANSLATE, "Translate some text", "Translate");
		_editorpane = new JTextArea(20,20);
		_previewPane = new JTextArea(20,20);
		_editorpane.setLineWrap(true);
		_previewPane.setLineWrap(true);

		_translateButton.addActionListener(buttonClickListener());

		add(_translateButton);
		add(_editorpane);
		add(_previewPane);
	}
    private JButton createButton(String imageName, String command, String toolTipText, String alteritiveText) {
       
		JButton button = new JButton();
        button.setActionCommand(command);
        button.setToolTipText(toolTipText);
        button.addActionListener(buttonClickListener());
        button.setText(alteritiveText);

        return button;
    }
	private ActionListener buttonClickListener() {
		ActionListener listener = new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();

		        if (TRANSLATE.equals(command)) {
		        	updatePreview();	
				}
			}
		};

		return listener;
	}
	private void updatePreview() {
		try {
			String text = _editorpane.getDocument().getText(0,_editorpane.getDocument().getLength());
			PigLatinConverter converter = new PigLatinConverter(text);
			_previewPane.setText(converter.convertText());
		}
		catch (Exception ex) {
			// ex.pr
		}
	}
}