import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;

public class ImagePostCell extends JLabel {
	public static final ImageIcon _defaultImage = new ImageIcon( System.getProperty("user.dir") + "/src/resources/defaultimage.jpg");
	public MouseListener _listener;
	public ImagePostCell() {
		this(_defaultImage,null);
	}
	public ImagePostCell(MouseListener listener) {
		this(_defaultImage,listener);
	}
	public ImagePostCell(ImageIcon image) {
		this(image, null);
	}
	public ImagePostCell(ImageIcon image, MouseListener listener) {
		super(image);
		_listener = listener;
		addMouseListener(_listener);
	}
}