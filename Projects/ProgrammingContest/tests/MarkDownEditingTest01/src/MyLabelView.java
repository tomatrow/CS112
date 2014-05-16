import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.logging.*;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class MyLabelView extends LabelView {
    public MyLabelView(Element elem) {
        super(elem);
    }
    public View breakView(int axis, int p0, float pos, float len) {
        if (axis == View.X_AXIS) {
            resetBreakSpots();
        }
        return super.breakView(axis, p0, pos, len);
    }

    private void resetBreakSpots() {
        try {
            // HACK the breakSpots private fields
            Field f=GlyphView.class.getDeclaredField("breakSpots");
            f.setAccessible(true);
            f.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}