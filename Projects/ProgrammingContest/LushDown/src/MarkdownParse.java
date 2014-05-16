import java.util.regex.Pattern;
import java.util.regex.Matcher;
	
public class MarkdownParse {
	public static String parse(String s) {
		// I should be a functional programmer. 
		// Or implement this with loops and an array.
		return paragraph(horizontalRule(blockquote(fix_ol(fix_ul(ol_list(ul_list(code(quote(emphasis(bold(link(header(s)))))))))))));
	}
	private static String replace(String s, String regex, String replacement) {
		// All the magic is right here. 
		return s.replaceAll(regex, replacement);
	}
	private static String complexReplace(String s, String regex, String formatString, int beginIndex) {
		Matcher matcher = Pattern.compile(regex).matcher(s);
		StringBuffer stringBuffer = new StringBuffer();

        while (matcher.find()) {
        	String match = matcher.group();
        	String replacement = String.format(formatString,match.substring(beginIndex).trim()); 
        	matcher.appendReplacement(stringBuffer, replacement);
        }
        matcher.appendTail(stringBuffer);

		return stringBuffer.toString();
	}
	// Replacement functions in order of calling in parse. 
	public static String header(String s) {
		String regex = "(#+)(.*)";
		Matcher m = Pattern.compile(regex).matcher(s);
		StringBuffer stringBuffer = new StringBuffer();

        while (m.find()) {
        	String headerLine = m.group();
        	String onlyHeaderTokens = headerLine.replaceAll("[^#]", "");
        	int headerLevel = (onlyHeaderTokens.length() <= 5)?onlyHeaderTokens.length():5;// The header level only goes up to five.
        	String htmlHeader = String.format("<h%d>%s</h%d>", headerLevel, headerLine.substring(onlyHeaderTokens.length()), headerLevel);
        	m.appendReplacement(stringBuffer, htmlHeader);
        }
        m.appendTail(stringBuffer);

		return stringBuffer.toString();
	}
	public static String link(String s) {
		return replace(s, "\\[([^\\[]+)\\]\\(([^\\)]+)\\)", "<a href=\\'$2\\'>$1</a>");
	}
	public static String bold(String s) {
		return replace(s, "(\\*\\*|__)(.*?)\\1", "<strong>$2</strong>");
	}
	public static String emphasis(String s) {
		return replace(s, "(\\*|_)(.*?)\\1", "<em>$2</em>");
	}
	public static String quote(String s) {
		return replace(s, "\"(.*?)\"", "<q>$1</q>");
	}
	public static String code(String s) {
		return replace(s, "`(.*?)`", "<code>$1</code>");
	}
	public static String ul_list(String s) {
		return complexReplace(s, "\\n\\*(.*)", "\n<ul>\n\t<li>%s</li>\n</ul>", 2);
	}
	public static String ol_list(String s) {
		return complexReplace(s, "\\n[0-9]+\\.(.*)", "\n<ol>\n\t<li>%s</li>\n</ol>", 3);
	}
	public static String blockquote(String s) {
		return complexReplace(s, "\n(&gt;|\\>)(.*)", "\n<blockquote>%s</blockquote>", 2);
	}
	public static String horizontalRule(String s) {
		return replace(s, "\n-{5,}", "\n<hr />");
	}
	public static String paragraph(String s) {
		String regex = "\n([^\n]+)\n";
		String formatString = "\n<p>%s</p>\n";
		String inTagRegex = "^</?(ul|ol|li|h|p|bl).*";

		Matcher m = Pattern.compile(regex).matcher(s);
		StringBuffer stringBuffer = new StringBuffer();

        while (m.find()) {
        	String match = m.group();

        	String item = "";
        	if (match.trim().matches(inTagRegex)) {
        		item = String.format("\n%s\n",match);
        	} else {
        		item = String.format(formatString, match.trim());
        	}
        	// Matcher can't handle the end-of-string character in a recursive search and replace
    		int cashIndex = item.indexOf("$");
        	if (cashIndex != -1)
	        	item = item.substring(0, cashIndex) + "\\" + item.substring(cashIndex);

        	m.appendReplacement(stringBuffer, item);
        }
        m.appendTail(stringBuffer);

		return stringBuffer.toString();
	}
	public static String fix_ul(String s) {
		return replace(s,"\\n</ul>\\n<ul>", "");
	}
	public static String fix_ol(String s) {
		return replace(s,"\\n</ol>\\n<ol>", "");
	} 
}