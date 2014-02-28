/*
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
	Output
	Input
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
		+smallestPets #array of pets
		+largestPets #array of pets
		+youngestPets #array of pets
		+oldestPets #array of pets
		-archive #serialization
		-unarchive #deserialization
	@PetRecordCommunicator #communicates with the user 
		+readRecord 
		+writeRecord
		+readRecords
		+writeRecords
ClassPlan End
*/

public class ProjectHandout02Project02 {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}