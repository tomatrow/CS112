import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.logging.*;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class MarkdownRenderer {    
    private static final MutableAttributeSet PLAIN = new SimpleAttributeSet();
    private static final MutableAttributeSet BOLD = new SimpleAttributeSet();
    private static final MutableAttributeSet ITALIC = new SimpleAttributeSet();
    private static final MutableAttributeSet UNDERLINE = new SimpleAttributeSet();

    private StyledDocument Document = null;

    public MarkdownRenderer(JTextPane editor) {
        Document = (StyledDocument) editor.getDocument();

        StyleConstants.setBold(BOLD, true);
        StyleConstants.setItalic(ITALIC, true);
        StyleConstants.setUnderline(UNDERLINE, true);
    }

    void render() {
        // Get the Document's text. 
        String s = "";
        try {
            s = Document.getText(0, Document.getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(MarkdownRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Document.setCharacterAttributes(0, Document.getLength(), PLAIN, true);
        /*
        Regex: 
            \*\*([^\n*]+)\*\*
        Purpose: 
            Replaces pairs of ** if they are on the same line.  
        Example: 
            This: 
                **He
                llo****World**
            Turns into This:
                **He
                llo**|`World`|
        */
        String temp = s.replaceAll("\\*\\*([^\\n*]+)\\*\\*", "|`$1`|"); // can also use lazy quantifier: (.+?)

        Matcher m = Pattern.compile("\\|`.+?`\\|").matcher(temp);
        while (m.find()) {
            Document.setCharacterAttributes(m.start(), m.group().length(), BOLD, false);
        }
        m = Pattern.compile("\\*([^\\n*]+)\\*").matcher(temp);
        while (m.find()) {
            Document.setCharacterAttributes(m.start(), m.group().length(), ITALIC, false);
        }
        m = Pattern.compile("_+([^\\n*]+)_+").matcher(temp);
        while (m.find()) {
            Document.setCharacterAttributes(m.start(), m.group().length(), UNDERLINE, false);
        }
    }
}