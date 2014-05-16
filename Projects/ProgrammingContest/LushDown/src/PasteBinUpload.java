import java.awt.List;
import java.util.ArrayList;
import javax.xml.ws.ProtocolException;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class PasteBinUpload {
	protected String api_option 		    = "paste";
	protected String api_paste_expire_date  = "10M";
	protected String api_paste_format 		= "text";
	protected String api_user_key 			= ""; 
	protected String api_dev_key 		    = "88358a2fa0b6c259c792521b3648876d";
	protected String api_paste_private 		= "0"; 
	protected String api_paste_code;
	protected String api_paste_name;

	public PasteBinUpload(String pasteCode, String pasteName) {
		try {
			api_paste_name	= URLEncoder.encode(pasteName, "UTF-8");
			api_paste_code	= URLEncoder.encode(pasteCode, "UTF-8");
			// api_paste_code = pasteCode;// This is really wrong. 
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public String uploadUrl() {
		String errorMessage = null;
		try {
			HttpURLConnection connection = createConnection();

			connection.connect();

			return getResponse(connection);
		}
		catch (IOException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		}
		return errorMessage;
	}
	private HttpURLConnection createConnection() throws MalformedURLException, IOException {
		URL url = new URL("http://pastebin.com/api/api_post.php");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setReadTimeout(10000);
		connection.setConnectTimeout(15000);
		connection.setRequestMethod("POST");
		connection.setDoInput(true);
		connection.setDoOutput(true);

		OutputStream outputStream = connection.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
		writer.write(getQuery(getParameters()));
		writer.flush();
		writer.close();
		outputStream.close();

		return connection;
	}
	private String getResponse(HttpURLConnection connection) throws IOException {
		InputStream inputStream = connection.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuffer response = new StringBuffer(); 
		String line;
		while((line = bufferedReader.readLine()) != null) {
			response.append(line);
		}
		bufferedReader.close();

		return response.toString();
	}

	private ArrayList<LushNameValuePair> getParameters() {
			ArrayList<LushNameValuePair> parameters = new ArrayList<LushNameValuePair>();
			
			parameters.add(new LushNameValuePair("api_option", api_option));
			parameters.add(new LushNameValuePair("api_user_key", api_user_key));
			parameters.add(new LushNameValuePair("api_paste_private", api_paste_private));
			parameters.add(new LushNameValuePair("api_paste_name", api_paste_name));
			parameters.add(new LushNameValuePair("api_paste_expire_date", api_paste_expire_date));
			parameters.add(new LushNameValuePair("api_paste_format", api_paste_format));
			parameters.add(new LushNameValuePair("api_dev_key", api_dev_key));
			parameters.add(new LushNameValuePair("api_paste_code", api_paste_code));

			return parameters;
	}

	private String getQuery(ArrayList <LushNameValuePair> parameters) throws UnsupportedEncodingException {
	    String result = "";
	    boolean first = true;
	    for (LushNameValuePair valuePair : parameters) {
	        if (first)
	            first = false;
	        else
	            result += "&";

	        result += URLEncoder.encode(valuePair.getName(), "UTF-8");
	        result += "=";
	        result += URLEncoder.encode(valuePair.getValue(), "UTF-8");
	    }

	    return result.toString();
	}
}