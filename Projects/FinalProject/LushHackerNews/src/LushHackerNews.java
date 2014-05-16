/*
	File Name:          LushHackerNews.java
	Programmer:         Andrew Caldwell
	Date Last Modified: May. 15, 2014
	Problem Statement:
		Make a reddit client. 

	Overall Plan:
		Get json from a reddit url
		parse json for t3 data 
		save as model object 
		display to user 

	Classes needed and Purpose:
	main class - LushHackerNews
	MainFrame - The main view we build upon
	Controller					- glue interface 
	ImagePostCell				- image view 
	ImagePostPanel				- view for base model object 
	ImageScrollPanel			- holds a scolling multi image view 
	ImageScrollPanelDelegate	- informs of click on an image 
	JsonParser					- parses json 
	RedditImagePost				- base model object 
	RootPanel					- holds the other panels 
	SubredditControls			- main application controls 
	SubredditControlsDelegate	- informs of events 
	SubredditRequest			- uses GET from reddit 
*/

import java.util.ArrayList;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.JOptionPane;

public class LushHackerNews {
	public static void main(String[] args) {
		MainFrame mainframe = new MainFrame(new RedditController());	
	}
	public static ImageIcon[] ImagesForUrls(URL[] urls) {
		ImageIcon[] icons = new ImageIcon[urls.length];
		try {
			for (int x = 0;x < urls.length;x++) {
				icons[x] = downloadImageForUrl(urls[x]);
			}
		}
		catch  (IOException e) {
			e.printStackTrace();
		}
		return icons;
	}
	public static ImageIcon downloadImageForUrl(URL url) throws IOException {
		Image image = null;
	    image = ImageIO.read(url);
		return new ImageIcon(image);
	}
	public static class RedditController implements Controller, ImageScrollPanelDelegate, SubredditControlsDelegate {
		MainFrame _frame;
		ArrayList<RedditImagePost> _imagePosts;
		public void onVisible(MainFrame frame) {
			_frame = frame;
			_frame._rootPanel._scrollPanel.setDelegate(this);
			_frame._rootPanel._controlsPanel.setDelegate(this);
		} 
		public void imageAtIndexClicked(int index) {
			System.out.println(index);
			JOptionPane.showMessageDialog( _frame, new ImagePostPanel(_imagePosts.get(index)), "Index: " + index, JOptionPane.PLAIN_MESSAGE);
		}
		public void buttonClickedWithText(String text) {
			System.out.println(text);
			String subreddit = text.trim();
			SubredditRequest request = new SubredditRequest(subreddit, SubredditRequest.Top_Request_Period.DAY);
			String resultJson = request.performJsonRequest();
			JsonParser parser = new JsonParser(resultJson);
			_imagePosts = parser.getImagePosts();
			URL[] thumbnailUrls = new URL[_imagePosts.size()];
			for (int x = 0;x < _imagePosts.size();x++) {
				thumbnailUrls[x] = _imagePosts.get(x).getThumbnail();
			}
			ImageIcon[] icons = ImagesForUrls(thumbnailUrls);
			for (int x = 0;x < icons.length;x++) {
				_frame._rootPanel._scrollPanel._imageCells.get(x).setIcon(icons[x]);
			}
		}
	}

}

