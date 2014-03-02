import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

import java.util.Arrays;
import java.util.List;
import java.lang.IllegalArgumentException;

public class PersonManager {
	public static final String RECORD_FILE_NAME = "Persons.dat";
	public static final File RECORD_FILE = new File(System.getenv("PWD") + "/bld/" + RECORD_FILE_NAME);

	private Person[] _persons; 


	PersonManager() {
		if (!RECORD_FILE.exists()) {
			archive();
		}
	}


	// serialization
	public void archive() {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(RECORD_FILE));
			outputStream.writeObject(_persons);
			outputStream.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	public void unarchive() {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(RECORD_FILE));
			setPersons((Person[])inputStream.readObject());
			inputStream.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	// search 
	public Person search(String name) {
		int index = -1;
		for (int x = 0;x < _persons.length;x++) {
			if (_persons[x].getName().equals(name))
				index = x;
		}
		return (index == -1)?null:_persons[index];
	}
	public Person[] withAgeRange(int start, int end, Date currentDate) {
		Person[] persons = new Person[0];
		if (_persons.length > 0) {
			for (Person p : _persons) {
				if (p.getAge(currentDate) <= end && p.getAge(currentDate) >= start) {
					PersonManager.append(persons,p);
				}
			}
		}

		return persons;
	}


	// Mutators
	public void add(Person person) {
		if (person == null)
			throw new IllegalArgumentException("People can't be null");
		else  {
			_persons = PersonManager.append(_persons, person);
		}
	}
	public void remove(Person person) {
		int index = -1;
		for (int x = 0;x < _persons.length;x++) {
			if (_persons[x].equals(person))
				index = x;
		}
		if (index == -1)
			throw new IllegalArgumentException("Record not found");

		Person[] firstPart = Arrays.copyOf(_persons,index - 1,Person[].class);
		Person[] secondPart = Arrays.copyOfRange(_persons,index + 1,_persons.length,Person[].class);

		setPersons(PersonManager.concat(firstPart,secondPart));
	}


	// Boiler
	private void setPersons(Person[] persons) {
		if (persons == null)
			throw new IllegalArgumentException("The manager needs *some* records");
		_persons = persons;
	}
	public Person[] getPersons() {
		return Arrays.copyOf(_persons,_persons.length);
	}

	// Helper methods 
	public static String[] getPersonNames(Person[] persons) {
		String[] personNames = new String[persons.length];
		for (int x = 0;x < persons.length;x++) {
			personNames[x] = persons[x].getName();
		}
		return personNames;
	}
	public static <T> T[] concat(T[] first, T[] second) {
	  T[] result = Arrays.copyOf(first, first.length + second.length);
	  System.arraycopy(second, 0, result, first.length, second.length);
	  return result;
	}
	public static <T> T[] append(T[] array, T object) {
		T[] result = Arrays.copyOf(array,array.length+1);
		result[result.length-1] = object;
		return result;
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