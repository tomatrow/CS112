import java.io.InputStream;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

// import java.beans.Introspector;
// import java.beans.PropertyDescriptor;
// import javax.management.IntrospectionException;

public class PetRecordCommunicator {
	public static final String[] FEILD_STRINGS = {"Name","Age","Weight"};
	public static final String[] QUALITY_STRINGS = {"Smallest","Largest","Youngest","Oldest"};
	public static final String[] METHOD_STRINGS = {"smallestPets", "largestPets", "youngestPets", "oldestPets"};

	// Readers
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
	public static PetRecord[] readRecords(int count) {
		PetRecord[] records = new PetRecord[count];
		for (int x = 0;x < records.length;x++)
			records[x] = PetRecordCommunicator.readRecord();
		return records;
	}

	// Writters
	public static String writeRecords(PetRecord[] records) {
		String output = "";
		int[] fieldWidths = {FEILD_STRINGS[0].length(), FEILD_STRINGS[1].length(), FEILD_STRINGS[2].length()};

		
		// Find out how big each field should be 
		PetRecord record;
		int nameLength;   
		int ageLength;    
		int weightLength; 

		for (int x = 0;x < records.length;x++) {
			record = records[x];
			
			nameLength   =  record.getName().length();
			ageLength    =  Integer.toString(record.getAge()).length();
			weightLength =  Double.toString(record.getWeight()).length();
			
			if (nameLength > fieldWidths[0])
				fieldWidths[0] = nameLength;
			if (ageLength > fieldWidths[1])
				fieldWidths[1] = ageLength;
			if (weightLength > fieldWidths[2])
				fieldWidths[2] = weightLength;
		}

		// Generate output string
		String formatString = "|%-" + fieldWidths[0] + "s" + "|" + "%-" + fieldWidths[1] + "s" + "|" + "%-" + fieldWidths[2] + "s|\n";
		String line;
		
		// output header 
		line = String.format(formatString,FEILD_STRINGS[0],FEILD_STRINGS[1],FEILD_STRINGS[2]);
		output = output.concat(line);

		// output body 
		for (int x = 0;x < records.length;x++) {
			record = records[x];
			line = String.format(formatString,record.getName(),record.getAge(),record.getWeight());
			output = output.concat(line);
		}
		return output;
	}
	public static String writeRecordInfo(PetRecord[] records) {
		String output = "";

		try {
			for (int x = 0;x < QUALITY_STRINGS.length;x++) {
				Method method = PetRecordManager.class.getMethod(METHOD_STRINGS[x], PetRecord[].class);
				PetRecord[] qualityRecords = (PetRecord[]) method.invoke(null,(Object)records);
				String header = QUALITY_STRINGS[x] + " Pet" + ((qualityRecords.length > 1)?"s":"") + ":\n";
				output = output.concat(header + writeRecords(qualityRecords));
			}
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace();
			System.exit(0);
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
			System.exit(0);	
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
			System.exit(0);	
		}

		return output;
	}
}