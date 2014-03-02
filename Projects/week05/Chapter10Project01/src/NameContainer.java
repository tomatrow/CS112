public class NameContainer {
	private String _name;
	private int _rank;
	private boolean _gender; // true = boy, false == girl
	private int _count;
	NameContainer() {
		this("",-1,true,-1);
	}
	NameContainer(String name, int rank, boolean gender, int count) {
		_name = name;
		_rank = rank;
		_gender = gender;
		_count = count;
	}
	public String getName() {
		return _name;
	}
	public int getRank() {
		return _rank;
	}
	public boolean getGender() {
		return _gender;
	}
	public int getCount() {
		return _count;
	}
	public String toString() {
		return String.format("%s:%s:%s:%s",getName(),getRank(),getGender(),getCount());
	}
}