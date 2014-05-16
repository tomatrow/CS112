import java.util.LinkedList;
import java.util.Iterator;
import java.util.ArrayList;

public class GroupProject09 {
	public static final int CONSOLE_WIDTH = 80;
	public static void main(String[] args) {
		LinkedList<Employee>list = new LinkedList<Employee>();
		Employee temp = new Employee();
		Employee temp1 = new Employee();
		list.push(temp);
		list.push(temp1);

		String output = screen(list);
		// System.out.println(screen(list));
	}

	public static String screen(LinkedList<Employee>list) {
		String output = "";

		Iterator decendingIterator = list.descendingIterator();
		
		while (decendingIterator.hasNext()) {
			Employee e = (Employee) decendingIterator.next();
			// output = output + line(); // box top
			// output = output + e;
			// output = output + line(); // box bottom
			// output = output + arrow();

			System.out.print(line());
			System.out.print(e);
			System.out.print(line());
			System.out.print(arrow());
		}

		return output;
	}
	public static String line() {
		String output = "";
		for (int x = 0;x < CONSOLE_WIDTH;x++) {
			output = output + "*";
		}
		return output + "\n";
	}
	public static String arrow() {
		String output = "";
		for (int y = 0;y<= 5;y++) {
			for (int x = 1;x <= 80; x++) {
				String character = " ";

				if (x == 40 || Math.abs(x - 40) == (5 - y) && y > 1) {
					character = "*";	
				}

				// output = output + ((x == 40 || (y == 3 && x == 38))?"*":" ");
				output = output + character;

			}
			output = output + "\n";
		}

		return output;
	}
}