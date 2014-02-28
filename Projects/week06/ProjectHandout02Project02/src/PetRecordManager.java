import java.util.Arrays;

public class PetRecordManager {
	private PetRecord[] _records; 
	PetRecordManager() {

	}
	// boiler
	public getRecords() {
		// return copies
		PetRecord[] recordsCopy = new PetRecord[_records.length];
		
		for (int x = 0;x < _records.length;x++)
			recordsCopy[x] = _records[x].copy();

		return recordsCopy;
	}
}