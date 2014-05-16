import java.util.logging.Logger;
import java.util.logging.Level;

public class RegexTest01 {
	private final static Logger LOGGER = Logger.getLogger(RegexTest01.class .getName()); 

	public static void main(String[] args) {
		LOGGER.setLevel(Level.INFO);
		String mainTestString = "# Title\n\nAnd *now* [a link](http://www.google.com) to **follow** and [another](http://yahoo.com/).\n\n* One\n* Two\n* Three\n\n## Subhead\n\nOne **two** three **four** five.\n\nOne __two__ three _four_ five __six__ seven _eight_.\n\n1. One\n2. Two\n3. Three\n\nMore text with `inline($code)` sample.\n\n> A block quote\n> across two lines.\n\nMore text...taht is not a paragraph. But it could be. Like right now. \n\n";
		System.out.println(RegexParser.parse(mainTestString));
		// paragraphTest();
		// ol_listTest();
		// regexTest();

	}
	public static void paragraphTest() {
		String s = "";
		String parsed = RegexParser.paragraph(s);
		System.out.println(s + "\n\n\n" + parsed);
	}
	public static void regexTest() {
		String regex = "^</?(ul|ol|li|h|p|bl).*";
		String testString = "<bdockquote>text</blockquote>";
		boolean match = testString.matches(regex);
		System.out.println(match);
	}
	public static void parseTest() {
		String s = "## Header\n#### Anthoer Header\n**Hello** **world**\n[THENAME](THELINK)\n ~~strikeThrough~~\n \"quotes\" ";
		String testEmphasis = "*Hello* **world** and some `code`";
		String parsed = RegexParser.parse(testEmphasis);
		System.out.println(testEmphasis + "\n\n\n" + parsed);
	}
	public static void horizontalRuleTest() {
		String s = "Hello\n--------\nworld";
		String parsed = RegexParser.horizontalRule(s);
		System.out.println(s + "\n\n\n" + parsed);
	}
	public static void blockquoteTest() { 
		String s = "\n> Heloo \n> wold";
		String parsed = RegexParser.blockquote(s);
		System.out.println(s + "\n\n\n" + parsed);
	}
	public static void ol_listTest() {
		String s = "\n1. hello\n2. world \n3. I am fine\n";
		String olParsed = RegexParser.ol_list(s);
		String olFixParsed = RegexParser.fix_ol(olParsed);
		System.out.println(s + olFixParsed);
	}
	public static void ul_listTest() {
		String s = "\n* hello\n* world \n* I am fine\n";
		String ulParsed = RegexParser.ul_list(s);
		String ulFixParsed = RegexParser.fix_ul(ulParsed);
		System.out.println(s + ulFixParsed);
	}
	public static void bolding() {

		String s = "**He\nllo****World**";
		// String prepareForBold = s.replaceAll("\\*\\*([^\\n*]+)\\*\\*", "|`$1`|"); // can also use lazy quantifier: (.+?)
		String prepareForBold = s.replaceAll("\\*\\*([^\\n*]+)\\*\\*", "@"); // can also use lazy quantifier: (.+?)

		String bold = prepareForBold.replaceAll("\\|`.+?`\\|", "@");
        /*
        Regex: 
            \|`.+?`\|
        Purpose: 
			
        Example: replaceAll("\\|`.+?`\\|", "@")
            This: 
				**He
				llo**|`World`|
            Turns into This:
				**He
				llo**@
        */

		// LOGGER.info("" + s.equals(bold));	
		LOGGER.info("\n" + s + "\n" + prepareForBold);
	}
}