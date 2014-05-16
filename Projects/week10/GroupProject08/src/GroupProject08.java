import java.util.ArrayList;
import java.util.Scanner;

public class GroupProject08 {
	public static final String phoneRegex = "[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]";
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		while (!keyboard.hasNext(phoneRegex)) {
			System.out.println("NO");
			keyboard.next();
		}
		String output = keyboard.next();
		System.out.println(output);
	}
}