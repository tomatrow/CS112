import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

import java.util.Arrays;
import java.util.List;

public class PetRecordManager {
	public static final String RECORD_FILE_NAME = "PetRecords.dat";
	public static final File RECORD_FILE = new File(System.getenv("PWD") + "/bld/" + RECORD_FILE_NAME);
	private PetRecord[] _records; 

	PetRecordManager() {
		// This needs to be zero 
		_records = new PetRecord[0];
		if (!RECORD_FILE.exists()) {
			archive();
			// try {
			// 	RECORD_FILE.createNewFile();
			// } 
			// catch (IOException e) {
			// 	System.out.println("Can't create a file");
			// 	e.printStackTrace();
			// 	System.exit(0);
			// }
		}
	}

	// serialization
	// It's amazing how easy this is in java
	public void archive() {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(RECORD_FILE));
			outputStream.writeObject(_records);
			outputStream.close();
		} 
		catch (IOException e) {
			System.out.println("Shoot Dawg");
			e.printStackTrace();
			System.exit(0);
		}
	}
	public void unarchive() {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(RECORD_FILE));
			setRecords((PetRecord[])inputStream.readObject());
			inputStream.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Shoot Dawg");
			e.printStackTrace();
			System.exit(0);
		}
		catch (ClassNotFoundException e) {
			System.out.println("Shoot Dawg");
			e.printStackTrace();
			System.exit(0);
		}
		catch (IOException e) {
			System.out.println("Shoot Dawg");
			e.printStackTrace();
			System.exit(0);
		}
	}

	// records information (extreme code copying, watch out)
	public static PetRecord[] smallestPets(PetRecord[] records) {
		PetRecord[] smallestPets = null;
		if (records.length > 0) {
			smallestPets = new PetRecord[1];
			smallestPets[0] = records[0];
			// start at index one so we don't get a tow of the same record
			for (int x = 1;x < records.length;x++) {
				// Gett the smallest pets while accounting for the exact same weight
				if (records[x].getWeight() < smallestPets[0].getWeight()) {
					smallestPets = new PetRecord[1];
					smallestPets[0] = records[x];
				} else if (records[x].getWeight() == smallestPets[0].getWeight()) {
					smallestPets = PetRecordManager.append(smallestPets,records[x]);
				}
			}
		}

		return smallestPets;
	}
	public static PetRecord[] largestPets(PetRecord[] records) {
		PetRecord[] largestPets = null;
		if (records.length > 0) {
			largestPets = new PetRecord[1];
			largestPets[0] = records[0];
			// start at index one so we don't get a tow of the same record
			for (int x = 1;x < records.length;x++) {
				// Gett the smallest pets while accounting for the exact same weight
				if (records[x].getWeight() > largestPets[0].getWeight()) {
					largestPets = new PetRecord[1];
					largestPets[0] = records[x];
				} else if (records[x].getWeight() == largestPets[0].getWeight()) {
					largestPets = PetRecordManager.append(largestPets,records[x]);
				}
			}
		}

		return largestPets;
	}
	public static PetRecord[] oldestPets(PetRecord[] records) {
		PetRecord[] oldestPets = null;
		if (records.length > 0) {
			oldestPets = new PetRecord[1];
			oldestPets[0] = records[0];
			// start at index one so we don't get a tow of the same record
			for (int x = 1;x < records.length;x++) {
				// Gett the smallest pets while accounting for the exact same weight
				if (records[x].getAge() > oldestPets[0].getAge()) {
					oldestPets = new PetRecord[1];
					oldestPets[0] = records[x];
				} else if (records[x].getAge() == oldestPets[0].getAge()) {
					oldestPets = PetRecordManager.append(oldestPets,records[x]);
				}
			}
		}

		return oldestPets;
	}
	public static PetRecord[] youngestPets(PetRecord[] records) {
		PetRecord[] youngestPets = null;
		if (records.length > 0) {
			youngestPets = new PetRecord[1];
			youngestPets[0] = records[0];
			// start at index one so we don't get a tow of the same record
			for (int x = 1;x < records.length;x++) {
				// Gett the smallest pets while accounting for the exact same weight
				if (records[x].getAge() < youngestPets[0].getAge()) {
					youngestPets = new PetRecord[1];
					youngestPets[0] = records[x];
				} else if (records[x].getAge() == youngestPets[0].getAge()) {
					youngestPets = PetRecordManager.append(youngestPets,records[x]);
				}
			}
		}

		return youngestPets;
	}


	// boiler
	public void add(PetRecord record) {
		// List<PetRecord> l = Arrays.asList(_records);
		// l.add(record);
		// setRecords(Arrays.copyOf(l.toArray(),l.size(),PetRecord[].class));
		setRecords(PetRecordManager.append(_records,record));
	}
	public void remove(PetRecord record) {
		int recordIndex = -1;
		for (int x = 0;x < _records.length;x++) {
			if (_records[x].equals(record))
				recordIndex = x;
		}
		if (recordIndex == -1)
			throw new IllegalArgumentException("Record not found");

		PetRecord[] firstPart = Arrays.copyOf(_records,recordIndex - 1,PetRecord[].class);
		PetRecord[] secondPart = Arrays.copyOfRange(_records,recordIndex + 1,_records.length,PetRecord[].class);

		setRecords(PetRecordManager.concat(firstPart,secondPart));

	}
	public PetRecord[] getRecords() {
		return Arrays.copyOf(_records,_records.length);
	}
	private void setRecords(PetRecord[] records) {
		if (_records == null)
			throw new IllegalArgumentException("The manager needs *some* records");
		_records = records;
	}

	// Helper methods 
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
}