import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JFrame;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;

public class BorderActionListener implements ActionListener {
	public static final int[] sizes = {5,10,20};
	public static final Color[] colors = {Color.black, Color.red, Color.blue};

	private JComponent _frame;
	private JLabel _label;

	public  BorderActionListener(JComponent frame) {
		this(frame, null);
	}
	public  BorderActionListener(JComponent frame, JLabel label) {
		_frame = frame;
		_label = label;
	}

	public void actionPerformed(ActionEvent e) {
		String[] command = e.getActionCommand().split(":");
		boolean isLineBorder = ((command[0].equals(MenuBar.main_menu_strings.get(0)) || (command[0].equals(MenuBar.main_menu_strings.get(1))))?false:true);
		int size = -1;
		Color color = null;
		String border = null;
		boolean typeIsRaised = false;
		String text = "";

		if (isLineBorder) {
			String commmandSize = command[0];
			String commandColor = command[1];
			size = sizes[MenuBar.line_border_options.indexOf(commmandSize)];
			color = colors[MenuBar.line_border_options_submenu.indexOf(commandColor)];
			border = MenuBar.main_menu_strings.get(2);
			text = String.format("%s %s", commmandSize, commandColor);
		} else {
			border = command[0];
			typeIsRaised = ((MenuBar.edge_border_options.indexOf(command[1]) == 0)?true:false);
			text = String.format("%s %s",command[1], border);
		}

		Border frameBorder = null;

		if (isLineBorder) {
			frameBorder = BorderFactory.createLineBorder(color, size);
		} else {
			if (border.equals(MenuBar.main_menu_strings.get(0))) {
				frameBorder = BorderFactory.createBevelBorder(((typeIsRaised)?BevelBorder.RAISED:BevelBorder.LOWERED));
			} else {
				frameBorder = BorderFactory.createEtchedBorder(((typeIsRaised)?EtchedBorder.RAISED:EtchedBorder.LOWERED));
			}
		}
		if (_label != null)
			_label.setText(text + " Border");
		_frame.setBorder(frameBorder);
	}
}