/*
	From: 
	http://stackoverflow.com/questions/14293879/problems-rendering-markdown-formatting-in-jtextpane
*/
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.logging.*;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;


public class MarkDownEditingTest01 {
	private JFrame frame = new JFrame();
    private JTextPane jtp;
    private StyledDocument doc;

    // NEW LINES
    private Timer T;
    private boolean update = true;
    MarkdownRenderer m;
    // END OF NEW LINES

    public MarkDownEditingTest01() {
        jtp = new JTextPane();
        jtp.setEditorKit(new MyStyledEditorKit());
        jtp.setText("\ntype some text in the above empty line and check the wrapping behavior");
        doc = jtp.getStyledDocument();
        
        // NEW LINES
        m = new MarkdownRenderer(jtp);
        Timer T = new Timer(2000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (update) {
                    update = false;
                    m.render();
                }
            }
        });
        T.start();
        // END OF NEW LINES

        doc.addDocumentListener(new DocumentListener() {

            private boolean doUpdate = true;
            public void insertUpdate(DocumentEvent e) {
                insert();
            }

            public void removeUpdate(DocumentEvent e) {
                insert();
            }

            public void changedUpdate(DocumentEvent e) {
//                triggers every time formatting is changed
//                 insert();
            }

            public void insert() {
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        Style defaultStyle = jtp.getStyle(StyleContext.DEFAULT_STYLE);
                        doc.setCharacterAttributes(0, doc.getLength(), defaultStyle, false);
                        update = true;
                    }
                });
            }
        });
        JScrollPane scroll = new JScrollPane(jtp);
        scroll.setPreferredSize(new Dimension(200, 200));
        frame.add(scroll);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MarkDownEditingTest01 bugWrapJava7 = new MarkDownEditingTest01();
            }
        });
	}
}