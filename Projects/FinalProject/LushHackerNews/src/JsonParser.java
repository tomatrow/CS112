/*
	Match Plan 
		Stage 1: Get rid of medialinks 
			"\"media_embed\": {[^}]*},"   ~>  ""
		Stage 2: Grab t3 data in array 
			"{\"kind\": \"t3\", \"data\": {([^}]*)}}"   ~>  String[]
		Stage 3: Create a Dictionary for each item in the String[]
			"\"([^\"]*)\": ([^,]*)"      ~>   Dictionary<key,value>
		Stage 4: Extract wanted from each dictionary into a model object
			String 	subreddit  
			String 	author
			Url 	permalink // specific reddit path 
			Url 	url   // Direct url, need to check if it's an image by looking at the extention (png|jpg)
			String 	title
			Date 	created 
*/
/* 
	Example of wanted data: 
		"subreddit": "photoshopbattles",
		"author": "JufishBong", 
		"permalink": "/r/photoshopbattles/comments/25l4f9/white_guy_in_front_of_mlk_statue_while_black_guy/", 
		"url": "http://i.imgur.com/Ti53UWc.jpg",  
		"title": "White guy in front of MLK statue while black guy *smh* (x-post from /r/funny)",
		"created_utc": 1400114673.0
*/

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.net.URL;
import java.util.Date;
import java.net.MalformedURLException;


public class JsonParser {
	private String _jsonSource;

	public static final ArrayList<String> JSON_KEYS = new ArrayList<String>(Arrays.asList("subreddit", "author", "permalink", "created_utc", "url", "title", "thumbnail"));
	private static final String MEDIA_LINKS_REGEX = "\"(secure_)|()media_embed\": \\{[^\\}]*\\},";
	private static final String T_THREE_DATA_REGEX = "(?:(\\{\"kind\": \"t3\", \"data\": \\{))([^}]*)\\}\\}";
	private static final String DICTIONARY_REGEX = "\"([^\"]*)\": ([^,]*)";

	JsonParser(String json) {
		_jsonSource = json;
	}
	public ArrayList<RedditImagePost> getImagePosts() {
		ArrayList<RedditImagePost> posts = new ArrayList<RedditImagePost>();
		ArrayList<String> t3Data = getTThreeData(removeMediaLinks(_jsonSource));
		for (String singlePostData: t3Data) {
			// skip everything if it's not an image post
			Map<String,Object> dataMap = getDataMap(singlePostData);

			String possibleImageUrl = (String) dataMap.get("url");
			if (possibleImageUrl == null || !(possibleImageUrl.endsWith(".jpg") || possibleImageUrl.endsWith(".png")))
				continue;
			
			RedditImagePost imagePost = extractImagePost(dataMap);
			posts.add(imagePost);
		}
		return posts;
	}
	private static RedditImagePost extractImagePost(Map<String,Object> dataMap) {
		URL permalink = null;
		URL url = null;
		URL thumbnail = null;
		String subreddit = (String) dataMap.get("subreddit");
		String author = (String) dataMap.get("author");
		Double created_utc = (Double)dataMap.get("created_utc");
		Date created = new Date(created_utc.longValue());
		String title = (String) dataMap.get("title");
		try {
			permalink = RedditImagePost.permaLinkFromPath((String)dataMap.get("permalink"));
			url = new URL((String)dataMap.get("url"));
			// System.out.println(dataMap.get("thumbnail"));
			thumbnail = new URL((String)dataMap.get("thumbnail"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new RedditImagePost(subreddit,author,created,title,permalink, url, thumbnail);
	}

	// parsing methods 
	public static String removeMediaLinks(String json) {
		return json.replaceAll(MEDIA_LINKS_REGEX, "");
	}
	public static ArrayList<String> getTThreeData(String json) {
		ArrayList<String> allTheData = matches(T_THREE_DATA_REGEX, json);
		return allTheData;
	}
	public static Map<String,Object> getDataMap(String jsonDictionary) {
		Matcher matcher = Pattern.compile(DICTIONARY_REGEX).matcher(jsonDictionary);
		Map<String,Object> dataMap = new HashMap<String,Object>();

        while (matcher.find()) {
        	String[] keyAndValue = matcher.group(0).split(":",2);
        	String key = removeSurroundingQuotes(keyAndValue[0].trim());
        	String value = keyAndValue[1].trim();
        	// if (key.equals("thumbnail"))
	        	// System.out.print(value + " ");
        	if (isWantedData(key) && !value.contains("{") && !value.contains("}")) {// get rid of some unwanted pairs 	
        		// System.out.println(matcher.group(0));
        		// System.out.println(Arrays.toString(keyAndValue));
	        	dataMap.put(key, decode(value));
        	}
        }
        
        return dataMap;
	}
	public static Object decode(String rawData) {
		// System.out.println(rawData);
		if (rawData == null || rawData.equals("null")) { // null
			return null;
		} else if (rawData.substring(0,1).equals("\"")) { // string
			return removeSurroundingQuotes(rawData);
		} else if (rawData.matches("true|false")) {// boolean
			return Boolean.valueOf(rawData);
		} else if (rawData.matches("[0-9\\.]*")) {// a number 
			return Double.valueOf(rawData);
		} else { // we couldn't don't know 
			return null;
		}
	}

	// private helper methods 
	private static boolean isWantedData(String key) {
		boolean isPartOfWantedKeys = JSON_KEYS.contains(key);
		// System.out.println(key + " " + isPartOfWantedKeys);
		return isPartOfWantedKeys;
	}
	private static String removeSurroundingQuotes(String input) {
		return new String(input.substring(1,input.length()-1));
	}

	private static ArrayList<String> matches(String regex, String data) {
		ArrayList<String> matches = new ArrayList<String>();
		Matcher matcher = Pattern.compile(regex).matcher(data);
        while (matcher.find()) {
        	String match = matcher.group();
        	matches.add(match);
        }
        return matches;
	}
}