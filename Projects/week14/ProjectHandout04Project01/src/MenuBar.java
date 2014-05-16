import javax.swing.JMenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuBar extends JMenuBar {
	public static final ArrayList<String> main_menu_strings =  new ArrayList<String>(Arrays.asList("Beveled", "Etched", "Line"));
	public static final ArrayList<String> edge_border_options =  new ArrayList<String>(Arrays.asList("Raised", "Lowered"));
	public static final ArrayList<String> line_border_options =  new ArrayList<String>(Arrays.asList("Small", "Medium", "Large"));
	public static final ArrayList<String> line_border_options_submenu =  new ArrayList<String>(Arrays.asList("Black", "Red", "Blue"));

	private ActionListener _listener;
	
	public MenuBar(ActionListener listener) {
		super();
		_listener = listener;
		add(createBordersMenu());
	}
	private JMenu createBordersMenu() {
		ArrayList[] subMenuStrings = {edge_border_options,edge_border_options,line_border_options};
		ArrayList<JMenu> menus = new ArrayList<JMenu>();

		for (int y = 0;y < 3;y++) {
			if (y == 2) {
				ArrayList<JMenu>lineMenu = new ArrayList<JMenu>();
				for (int x = 0;x <  line_border_options.size();x++) 
					lineMenu.add(createMenu(line_border_options.get(x), line_border_options_submenu));
				menus.add(createSubMenu(main_menu_strings.get(y), lineMenu));
			} else {
				menus.add(createMenu(main_menu_strings.get(y), subMenuStrings[y]));			
			}
		}

		return createSubMenu("Borders", menus);
	}
	private JMenu createSubMenu(String name, ArrayList<JMenu> menus) {
		JMenu subMenu = new JMenu(name);
		for (JMenu menu : menus) {
			subMenu.add(menu);
		}

		return subMenu;
	}
	private JMenu createMenu(String name, ArrayList<String> itemNames) {
		JMenu menu = new JMenu(name);
		for (String itemName : itemNames) {
			JMenuItem item = new JMenuItem(itemName);
			item.setActionCommand(name + ":" + itemName);
			item.addActionListener(_listener);

			menu.add(item);
		}
		return menu;
	}
}