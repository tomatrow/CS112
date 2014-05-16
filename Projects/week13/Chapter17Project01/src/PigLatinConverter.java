import java.util.Arrays;

public class PigLatinConverter {
	public String _rawText;

	PigLatinConverter(String rawText) {
		setRawText(rawText);
	}
	public String convertText() {
		String[] words = _rawText.split("[ \n]");
		for (int x = 0;x < words.length;++x) {
			if (words[x].substring(0,1).matches("[aeiouy]")) {
				words[x] += "way";
			} else {
				words[x] = words[x].substring(1) + words[x].substring(0,1) + "ay";
			}
		}
		return join(words);
	}
	private static String join(String[] array) {
		StringBuilder builder = new StringBuilder();
		String seperator = " ";
		for (String word : array) {
			builder.append(word + seperator);
		}
		return builder.toString();
	}
	public void setRawText(String rawText) {
		_rawText = rawText;
	}
}