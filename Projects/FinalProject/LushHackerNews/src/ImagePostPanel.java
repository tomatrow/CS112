import java.util.ArrayList;
import java.util.Date;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class ImagePostPanel extends JPanel {
	public RedditImagePost _post;
	public ImagePostCell _contentImage;

	public ImagePostPanel(RedditImagePost post) {
		super();
		_post = post;

		buildInfoPanel();
		_contentImage = new ImagePostCell(downloadImageForUrl(_post.getUrl()));
		add(_contentImage);

	}
	public static ImageIcon downloadImageForUrl(URL url) {
		Image image = null;
		try {
		    image = ImageIO.read(url);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return new ImageIcon(image);
	}
	private void buildInfoPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		JLabel title = new JLabel("Title: " + _post.getTitle());
		JLabel author = new JLabel("Author: " + _post.getAuthor());
		panel.add(title);
		panel.add(author);
		add(panel);
	}
}