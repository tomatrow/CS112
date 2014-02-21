public class Employee extends Person {
	private double  _salary;
	private int _ssn;

	Employee(String name, Date birthDate, Date deathDate, double salary, int ssn) {
		super(name,birthDate,deathDate);
		setSalary(salary);
		setSsn(ssn);
	}

	// Boiler
	public void setSalary(double salary) {
		if (salary < 0)
			throw new IllegalArgumentException("Salary must be greater than zero.");
		_salary = salary;
	}
	public void setSsn(int ssn) {
		int length = new String(ssn+"").length();
		if (length != 9) 
			throw new SSNLengthException(length + "");
		_ssn = ssn;
	}
	public int getSsn() {
		return _ssn;
	}
	public double getSalary() {
		return _salary;
	}
	public String toString() {
		// I get "Fatal Error." if I include the dates...
		// return String.format("Name:%s, Birth:%s, Death:%s, Salary:%f, SSN:%d", getName(),getBirthDate(),getDeathDate(),getSalary(),getSsn());
		return String.format("Name:%-8s, Salary:%05f, SSN:%d", getName(),getSalary(),getSsn());
	}
}