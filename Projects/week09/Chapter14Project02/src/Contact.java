public class Contact {
	public static String MAIL_REGEX = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";

	/* first and last name, phone number, and email address */
	protected String _firstName;
	protected String _lastName;
	protected String _mailAddress;


	// Constructors 
	public Contact() {
		this("","","");
	}
	public Contact(String firstName, String lastName, String mailAddress) {
		setFirstName(firstName);
		setLastName(lastName);
		setMailAddress(mailAddress);
	}

	// Derived Data
	public String searchString() {
		return String.format("%s %s %s", getFirstName(), getLastName(), getMailAddress()).toLowerCase();
	}


	// Setters 
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}
	public void setLastName(String lastName) {
		_lastName = lastName;
	}
	public void setMailAddress(String mailAddress) {
		if (!mailAddress.matches(MAIL_REGEX) && !mailAddress.equals("")) {
			throw new IllegalArgumentException(mailAddress + " does not match regex.");
		}
		_mailAddress = mailAddress;
	}

	// Getters
	public String getFirstName() {
		return _firstName;
	}
	public String getLastName() {
		return _lastName;
	}
	public String getMailAddress() {
		return _mailAddress;
	}

	// Object 
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else if (!o.getClass().equals(this.getClass())) {
			return false;
		} else {
			Contact otherContact = (Contact)o;

			boolean sameFirstName = this.getFirstName().equals(otherContact.getFirstName());
			boolean sameLastName = this.getLastName().equals(otherContact.getLastName());
			boolean sameMailAddress = this.getMailAddress().equals(otherContact.getMailAddress());

			return sameFirstName && sameLastName && sameMailAddress;
		}
	}

	@Override
	public String toString() {
		return String.format("<%s,%s,%s>", getFirstName(), getLastName(), getMailAddress());
	}
}