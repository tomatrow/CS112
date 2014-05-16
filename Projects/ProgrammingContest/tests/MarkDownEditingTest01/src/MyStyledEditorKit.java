import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.logging.*;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;


public class MyStyledEditorKit extends StyledEditorKit {
    private MyFactory factory;

    public ViewFactory getViewFactory() {
        if (factory == null) {
            factory = new MyFactory();
        }
        return factory;
    }
}