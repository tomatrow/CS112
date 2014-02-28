import java.io.InputStream;
import java.util.Scanner;

public class PetRecordCommunicator {
	public static String[] FEILD_STRINGS = {"name","age","weight"};
	public static PetRecord readRecord() {
		PetRecord record = new PetRecord();
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter the pet " + FEILD_STRINGS[0]);
		record.setName(keyboard.nextLine());

		int age = -1;
		do {
			System.out.println("Enter " + record.getName() + "'s " + FEILD_STRINGS[1]);
			while (!keyboard.hasNextInt()) {
				System.out.println("Not a pet " + FEILD_STRINGS[1] );
				keyboard.next();
			}
			age = keyboard.nextInt();
			if (age < 0) {
				System.out.println("Pet " + FEILD_STRINGS[1] + " must be greater than zero.");
			}
		} while (age < 0);
		record.setAge(age);

		double weight = -1;
		do {
			System.out.println("Enter " + record.getName() + "'s' " + FEILD_STRINGS[2]);
			while (!keyboard.hasNextDouble()) {
				System.out.println("Not a pet " + FEILD_STRINGS[2] );
				keyboard.next();
			}
			weight = keyboard.nextDouble();
			if (weight < 0) {
				System.out.println("Pet " + FEILD_STRINGS[2] + " must be greater than zero.");
			}
		} while (weight < 0);
		record.setWeight(weight);

		keyboard.close();
		return record; 
	}
}