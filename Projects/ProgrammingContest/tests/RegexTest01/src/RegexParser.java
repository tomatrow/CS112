import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
/*
Regex Conversion Tips:
	Removes "Start and end regex delimiters" from PHP strings
	Replace \ "String Replacement" tokens with $
	Example:
		`/\2/` with "$2"
*/
// PHP Regexes
/*
'/(#+)(.*)/' => 'self::header',                           // headers
'/\[([^\[]+)\]\(([^\)]+)\)/' => '<a href=\'\2\'>\1</a>',  // links
'/(\*\*|__)(.*?)\1/' => '<strong>\2</strong>',            // bold
'/(\*|_)(.*?)\1/' => '<em>\2</em>',                       // emphasis
'/\~\~(.*?)\~\~/' => '<del>\1</del>',                     // del
'/\:\"(.*?)\"\:/' => '<q>\1</q>',                         // quote
'/`(.*?)`/' => '<code>\1</code>',                         // inline code
'/\n\*(.*)/' => 'self::ul_list',                          // ul lists
'/\n[0-9]+\.(.*)/' => 'self::ol_list',                    // ol lists
'/\n(&gt;|\>)(.*)/' => 'self::blockquote ',               // blockquotes
'/\n-{5,}/' => "\n<hr />",                                // horizontal rule
'/\n([^\n]+)\n/' => 'self::para',                         // add paragraphs
'/<\/ul>\s?<ul>/' => '',                                  // fix extra ul
'/<\/ol>\s?<ol>/' => '',                                  // fix extra ol
'/<\/blockquote><blockquote>/' => "\n"                    // fix extra blockquote
*/
/*
Features Skipped for the Sake of Lines and Time
	* clarity
	* bug-freeness
	* multi-level lists 
*/
	
public class RegexParser {
	public static String parse(String s) {
		// I should be a functional programmer. 
		// Or learn how to use loops. 
		return paragraph(horizontalRule(blockquote(fix_ol(fix_ul(ol_list(ul_list(code(quote(del(emphasis(bold(link(header(s))))))))))))));
	}
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
		String regex = "\\[([^\\[]+)\\]\\(([^\\)]+)\\)";
		String replacement = "<a href=\\'$2\\'>$1</a>";
		return s.replaceAll(regex, replacement);
	}
	public static String bold(String s) {
		String regex = "(\\*\\*|__)(.*?)\\1";
		String replacement = "<strong>$2</strong>";
		return s.replaceAll(regex, replacement);
	}
	public static String emphasis(String s) {
		String regex = "(\\*|_)(.*?)\\1";
		String replacement = "<em>$2</em>";
		return s.replaceAll(regex, replacement);
	}
	public static String del(String s) {
		String regex = "\\~\\~(.*?)\\~\\~";
		String replacement = "<del>$1</del>";
		return s.replaceAll(regex, replacement);
	}
	public static String quote(String s) {
		String regex = "\"(.*?)\"";
		String replacement = "<q>$1</q>";
		return s.replaceAll(regex, replacement);
	}
	public static String code(String s) {
		String regex = "`(.*?)`";
		String replacement = "<code>$1</code>";
		return s.replaceAll(regex, replacement);
	}
	public static String ul_list(String s) {
		String regex = "\\n\\*(.*)";
		String formatString = "\n<ul>\n\t<li>%s</li>\n</ul>";

		Matcher m = Pattern.compile(regex).matcher(s);
		StringBuffer stringBuffer = new StringBuffer();

        while (m.find()) {
        	String match = m.group();
        	String listItem = String.format(formatString,match.substring(2).trim());
        	m.appendReplacement(stringBuffer, listItem);
        }
        m.appendTail(stringBuffer);

		return stringBuffer.toString();
	}
	public static String ol_list(String s) {
		String regex = "\\n[0-9]+\\.(.*)";
		String formatString = "\n<ol>\n\t<li>%s</li>\n</ol>";
		
		Matcher m = Pattern.compile(regex).matcher(s);
		StringBuffer stringBuffer = new StringBuffer();

        while (m.find()) {
        	String match = m.group();
        	String listItem = String.format(formatString,match.substring(3).trim());
        	m.appendReplacement(stringBuffer, listItem);
        }
        m.appendTail(stringBuffer);

		return stringBuffer.toString();
	}
	public static String blockquote(String s) {
		String regex = "\n(&gt;|\\>)(.*)";
		String formatString = "\n<blockquote>%s</blockquote>";
		
		Matcher m = Pattern.compile(regex).matcher(s);
		StringBuffer stringBuffer = new StringBuffer();

        while (m.find()) {
        	String match = m.group();
        	String blockquoteItem = String.format(formatString,match.trim().substring(1));
        	m.appendReplacement(stringBuffer, blockquoteItem);
        }
        m.appendTail(stringBuffer);

		return stringBuffer.toString();
	}
	public static String horizontalRule(String s) {
		String regex = "\n-{5,}";
		String replacement = "\n<hr />";
		return s.replaceAll(regex, replacement);
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

    		int cashIndex = item.indexOf("$");
        	if (cashIndex != -1)
	        	item = item.substring(0, cashIndex) + "\\" + item.substring(cashIndex);

        	m.appendReplacement(stringBuffer, item);
        }
        m.appendTail(stringBuffer);

		return stringBuffer.toString();
	}
	public static String fix_ul(String s) {
		String regex = "\\n</ul>\\n<ul>";
		String replacement = "";
		return s.replaceAll(regex, replacement);
	}
	public static String fix_ol(String s) {
		String regex = "\\n</ol>\\n<ol>";
		String replacement = "";
		return s.replaceAll(regex, replacement);
	} 
}