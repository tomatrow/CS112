public class LushNameValuePair {
	private String _name;
	private String _value;

	public LushNameValuePair(String name, String value) {
		_name = name;
		_value = value;
	}

	public String getValue() {
		return _value;
	}
	public String getName() {
		return _name;
	}
}