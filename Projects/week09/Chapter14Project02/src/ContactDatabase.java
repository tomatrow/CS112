import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class ContactDatabase {
	private ArrayList<Contact> _contacts;

	public ContactDatabase() {

	}
	public ContactDatabase(Collection<? extends Contact> c) {
		_contacts = new ArrayList<Contact>(c);
	}

	// Derived Data
	public ArrayList<Contact> matches(String searchTerm) {
		ArrayList<Contact> matchingContacts = new ArrayList<Contact>();
		for (Contact c : getContacts()) {
			if (c.searchString().indexOf(searchTerm) != -1) {
				matchingContacts.add(c);
			}
		}
		return matchingContacts;
	}
	public void add(Contact contact) {
		if (contact == null)
			throw new IllegalArgumentException("null contact");
		getContacts().add(contact);
	}
	public void remove(Contact contact) {
		getContacts().remove(contact);
	}


	// Setters 
	private void setContacts(ArrayList<Contact> contacts) { 

	}
	// Getters 
	private ArrayList<Contact> getContacts() {
		if (_contacts == null) {
			_contacts = new ArrayList<Contact>();
		}
		return _contacts;
	}

	// Object 
	@Override
	public String toString() {
		return getContacts().toString();
	}

}