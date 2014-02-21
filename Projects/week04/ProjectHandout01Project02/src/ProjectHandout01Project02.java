import java.util.Arrays;
import java.util.Scanner;

public class ProjectHandout01Project02 {
	public static void main(String[] args) {
		Scanner _keyboard = new Scanner(System.in);
	 	// Employee emp = new Employee("bob",new Date("January",12,1900),new Date("March",12,1943),9.7,123456789);
		int employeeCount;
		System.out.println("How many employees?");
		while (!_keyboard.hasNextInt()) {
			System.out.println("How many employees?");
			_keyboard.next();
		}
		employeeCount = _keyboard.nextInt();
		_keyboard.nextLine();

		Employee[] employees = new Employee[employeeCount];
	 	for (int x = 0;x < employees.length;x++) {
	 		employees[x] = readEmployee(_keyboard);
	 	}

		// Print out all records
		// System.out.println(employees[0]);
		double averageSalary = salaryAverage(employees);
		for(int x = 0;x < employees.length;x++) {
			boolean isAboveAvg = (employees[x].getSalary() > averageSalary)?true:false;
			System.out.print(String.format("%03d %s %s Average\n",x+1, employees[x],(isAboveAvg)?"Above":"Below"));
		}

		_keyboard.close();
	}	
	public static double salaryAverage(Employee[] employees) {
		double sum = 0;
		double average = 0;

		for (int x = 0;x < employees.length;x++) {
			sum += employees[x].getSalary();
		}
		average = sum / employees.length;
		return average;
	}
	public static Employee readEmployee(Scanner _keyboard) {
		
		
		String _name = "";
		Date _birthDate = new Date();
		Date _deathDate = new Date();
		double _salary = -1; 
		int _ssn = 0;

		String choice;
		boolean validChoice;

		// String[] types = {"Name", "Birth Date", "Death Date", "Salary", "SSN"};

		// Name 
		System.out.println("Enter the name");
		_name = _keyboard.nextLine();

		// Birthday
		System.out.println("Enter the Birth Day");
		_birthDate.readInput(_keyboard);
		_keyboard.nextLine();
		
		// Death Day
		do {
			System.out.println("Is the employee dead?(y/n)");
			choice = _keyboard.nextLine();
			validChoice = choice.matches("[yYnN]");
		} while(!validChoice);

		if (choice.toLowerCase().equals("y")) {
			System.out.println("Enter the death day");
			_deathDate.readInput(_keyboard);
		} else {
			_deathDate = null;
		}

		// salary 
		System.out.println("What is the salary?");
		do {
			while (!_keyboard.hasNextDouble()) {
				System.out.println("What is the salary?");
				_keyboard.next();
			}
			_salary = _keyboard.nextDouble();
		} while (_salary < 0);



		while (new String(_ssn+"").length() != 9) {
			System.out.println("What is the SSN?");
			try {
				if (!_keyboard.hasNextInt()) {
					throw new SSNCharacterException(_keyboard.next());
				}
			} catch (SSNCharacterException e) {
				System.out.println("\"" + e.getMessage() + "\" contains non-alpha characters.");
				continue;
			}
			_ssn = _keyboard.nextInt();
			int ssnLength;
			try  {
				ssnLength = new String(_ssn+"").length();
				if (ssnLength != 9)
					throw new SSNLengthException(_ssn+"");
			} catch (SSNLengthException e) {
				System.out.println("\"" + e.getMessage() + "\" is not 9 digits.");
				continue;
			}
		}
		_keyboard.nextLine();

		return new Employee(_name,_birthDate,_deathDate,_salary,_ssn);
	}
}