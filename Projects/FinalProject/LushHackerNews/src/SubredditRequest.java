import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SubredditRequest {
	public enum Top_Request_Period {
		HOUR, DAY, WEEK, MONTH, YEAR, ALL;
		public String requestString() {
			if (this == HOUR)
				return "hour";
			else if (this == DAY)
				return "day";
			else if (this == WEEK)
				return "week";
			else if (this == MONTH)
				return "month";
			else if (this == YEAR)
				return "year";
			else
				return "all";
		}
		public static Top_Request_Period periodForString(String period) {
			if (period.equals("hour"))
				return HOUR;
			else if (period.equals("day"))
				return DAY;
			else if (period.equals("week"))
				return WEEK;
			else if (period.equals("month"))
				return MONTH;
			else if (period.equals("year"))
				return YEAR;
			else
				return ALL;
		}
		public static String[] allRequestStrings() {
			return new String[]{"hour", "day", "week", "month","year", "all"};
		}
	}

	private Top_Request_Period _period;
	private String _subreddit;

	public static final String Top_Request_Period_Key = "t";
	public static final String Subreddit_Domain =  "http://www.reddit.com/r/";

	public SubredditRequest(String subreddit, Top_Request_Period period) {
		setSubreddit(subreddit);
		setPeriod(period);
	}
	// Setters and Getters 
	public void setPeriod(Top_Request_Period period) {
		_period = period;
	}
	public void setSubreddit(String subreddit) {
		if (!subreddit.matches("[a-zA-Z_0-9]*"))
			throw new IllegalArgumentException("Invalid subreddit");
		_subreddit = subreddit;
	}
	public Top_Request_Period getPeriod() {
		return _period;
	}
	public String getSubreddit() {
		return _subreddit;
	}

	public String performJsonRequest() {
		return getJSon(subbredditUrl(), Top_Request_Period_Key, _period.requestString());
	}

	private static String getJSon(String urlString, String requestKey, String requestValue) {
		try {
	        URL url = new URL(urlString + "/.json");

            URLConnection connection = url.openConnection();
            connection.addRequestProperty(requestKey, requestValue);

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            String inputLine = null;

            while ((inputLine = inputStream.readLine()) != null) {
                buffer.append(inputLine);
            }
            inputStream.close();
            return buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }	
		return null;
	}

	private String subbredditUrl() {
		return Subreddit_Domain + _subreddit;
	}
}