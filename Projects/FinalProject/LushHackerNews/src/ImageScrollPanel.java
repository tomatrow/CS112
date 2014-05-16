import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ImageScrollPanel extends JScrollPane {
	public JPanel _imagesPanel;
	public ArrayList<ImagePostCell> _imageCells;
	public ImageScrollPanelDelegate _delegate;

	public ImageScrollPanel() {
		super();
		_imagesPanel = new JPanel();
		_imagesPanel.setLayout(new GridLayout(5,4));

		_imageCells = new ArrayList<ImagePostCell>();

		for (int x = 0;x < 20;x++) {
			_imageCells.add(new ImagePostCell());
		}
		for (ImagePostCell cell : _imageCells) {
			_imagesPanel.add(cell);
		}

		setViewportView(_imagesPanel);
	}
	public void setDelegate(ImageScrollPanelDelegate delegate) {
		_delegate = delegate;
		MouseListener listener = createListener();
		for (ImagePostCell cell : _imageCells) {
			cell.addMouseListener(listener);
		}
	}
	private MouseListener createListener() {
		return new MouseListener() {
			public void mouseClicked(MouseEvent event) {
				int index = _imageCells.indexOf(event.getComponent());
				if (_delegate != null)
					_delegate.imageAtIndexClicked(index);
			}
			public void mouseEntered(MouseEvent event) {
			}
			public void mouseExited(MouseEvent event) {
			}
			public void mousePressed(MouseEvent event) {
			}
			public void mouseReleased(MouseEvent event) {
			}

		};
	}
}