/*





- - - - - - - - 

# Personal Plan
Key
	'@' == class
	'*' == property
	'+' == class method
	'-' == instance method
	'#' == comment
	'[' == start message
	']' == end message

RoadMap Start
	Model
	Input
	Output
	Persistance 
RoadMap End

Final Flow Plan Start 
	[PetRecordManager unarchive]
	
	# ask "Read or Write"?

	if (read)
		[PetRecordCommunicator writeRecords] #Using what was deserialized
	else 
		[PetRecordCommunicator readRecords]
	
	[PetRecordManager archive]
Final Flow Plan End

ClassPlan Start
	@ProjectHandout02Project02 # Main Class
	@PetRecord # our model
	@PetRecordManager #IO and info about our petrecords
		*petRecords #array of pets
		-getPetRecords #array of pets
		-setPetRecords #array of pets
		-smallestPets #array of pet
		-largestPets #array of pets
		-youngestPets #array of pets
		-oldestPets #array of pets
		-archive #serialization
		-unarchive #deserialization
	@PetRecordCommunicator #communicates with the user 
		+readRecord 
		+writeRecord
		+readRecords
		+writeRecords
ClassPlan End
*/
import java.util.Arrays;
import java.util.Scanner;

public class ProjectHandout02Project02 {
	public static final String[] VALID_CHOICES = {"y","n"};
	public static final PetRecord[] TEST_RECORDS = {new PetRecord("Jack",10,14.3), new PetRecord("A",123456,2)};

	public static void main(String[] args) {
		PetRecordManager manager = new PetRecordManager();
		manager.unarchive();

		if (getFlowChoice("Would you like to read the data?")) {
			String output = "All Pets:\n";
			output = output.concat(PetRecordCommunicator.writeRecords(manager.getRecords()));
			output = output.concat(PetRecordCommunicator.writeRecordInfo(manager.getRecords()));
			String[] lines = output.split("\n");
			// Make sure the output doesn't overwhelm the user 
			for (int x = 0;x < lines.length;x++) {
				try {
					System.out.println(lines[x]);
				    Thread.sleep(1000);
				} 
				catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
			}

		} 
		else if (getFlowChoice("Would you like to write to the data?"))  {
			PetRecord[] inputRecords = PetRecordCommunicator.readRecords(getCount("How many records?"));
			manager.addRecords(inputRecords);
		}

		manager.archive();
	}
	public static int getCount(String question) {
		Scanner keyboard = new Scanner(System.in);
		int choice;

		System.out.println(question);
		do { 
			while (!keyboard.hasNextInt()) {
				System.out.println("Enter an integer");
				keyboard.next();
			}
			choice = keyboard.nextInt();
			if (choice < 0) {
				System.out.println("Enter a positve integer");
			}
		} while (choice < 0);
		return choice;
	}

	public static boolean getFlowChoice(String question) {
		Scanner keyboard = new Scanner(System.in);
		String choice;
		System.out.println(question);
		do {
			choice = keyboard.nextLine();
			if (!contains(VALID_CHOICES, choice.toLowerCase())) {
				System.out.println("You need to enter y or n");
			}
		} while (!contains(VALID_CHOICES, choice.toLowerCase()));
		return (choice.toLowerCase().equals("y"))?true:false;
	}
	public static <T> boolean contains(T[] array, T object) {
		boolean result = false;
		for (T o : array) {
			if (o.equals(object))
				result = true;
		}
		return result;
	}
}