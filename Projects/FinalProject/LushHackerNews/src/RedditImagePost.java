/*
	String 	subreddit  
	String 	author
	Url 	permalink // specific reddit path 
	Date 	created 
	Url 	url   // Direct url, need to check if it's an image by looking at the extention (png|jpg)
	String 	title
*/




import java.net.URL;
import java.util.Date;
import java.net.MalformedURLException;
import java.io.Serializable;

public class RedditImagePost implements Serializable {
	private String 	_title;
	private String 	_author;
	private String 	_subreddit;
	private Date 	_created;
	private URL 	_permalink;
	private URL 	_url;      // The content this post links to 
	private URL     _thumbnail;

	private static final String REDDIT_DOMAIN = "http://www.reddit.com";
	public RedditImagePost() {
		this("subreddit","author", null, "title", null, null, null);
	}
	public RedditImagePost(String subreddit, String author, Date created, String title, URL permalink, URL url, URL thumbnail) {
		setSubreddit(subreddit);
		setAuthor(author);
		setCreated(created);
		setTitle(title);
		setPermalink(permalink);
		setUrl(url);
		setThumbnail(thumbnail);
	}

	// Getters 
	public String getSubreddit() {
		return _subreddit;
	}
	public String getAuthor() {
		return _author;
	}
	public Date getCreated() {
		return _created;
	}
	public String getTitle() {
		return _title;
	}
	public URL getPermalink() {
		return _permalink;
	}
	public URL getUrl() {
		return _url;
	}
	public URL getThumbnail() {
		return _thumbnail;
	}

	// Setters 
	private void setSubreddit(String subreddit) {
		_subreddit = subreddit;
	}
	private void setAuthor(String author) {
		_author = author;
	}
	private void setCreated(Date created) {
		_created = created;
	}
	private void setTitle(String title) {
		_title = title;
	}
	private void setPermalink(URL permalink) {
		_permalink = permalink;
	}
	private void setUrl(URL url) {
		_url = url;
	}
	private void setThumbnail(URL thumbnail) {
		_thumbnail = thumbnail;
	}

	// Public helper methods 
	public static URL permaLinkFromPath(String path) throws  MalformedURLException {
			return new URL(REDDIT_DOMAIN + path);
	}
	// Object 
	@Override 
	public String toString() {
		return String.format("%s,%s", getAuthor(),getTitle());
	}
	// @Override 
	// public boolean equals(Object o) {

	// }
	@Override
	public int hashCode() {
		return getPermalink().hashCode() ^ getTitle().hashCode() ^ getCreated().hashCode() ^ getAuthor().hashCode() ;
	}

}