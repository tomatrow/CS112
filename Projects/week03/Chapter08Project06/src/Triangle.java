public class Triangle extends Figure {
	Triangle(Screen screen) {
		this(screen,new Frame());
	}
	Triangle(Screen screen, Frame frame) {
		setScreen(screen);
		setFrame(frame);
	}
	@Override 
	void draw() {
		// Naaaaaants ingonyama bagithi Baba!
		// Sithi uhm ingonyama!
		// It's the Cirrrrcle of Life!
		
		getScreen().addLine(upperMiddle(),lowerRight());
		getScreen().addLine(lowerRight(),lowerLeft());
		getScreen().addLine(lowerLeft(),upperMiddle());
	}

	@Override
	void erase() {
		getScreen().removeLine(upperMiddle(),lowerRight());
		getScreen().removeLine(lowerRight(),lowerLeft());
		getScreen().removeLine(lowerLeft(),upperMiddle());
	}

	public Point upperMiddle() {
		return new Point(getFrame().getOrigin().getX() + getFrame().getWidth()/2, getFrame().getOrigin().getY());
	}
}