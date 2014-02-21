public class Rectangle extends Figure {
	Rectangle(Screen screen,Frame frame) {
		setScreen(screen);
		setFrame(frame);
	}
	@Override
	void draw() {
		// Naaaaaants ingonyama bagithi Baba!
		// Sithi uhm ingonyama!
		// It's the Cirrrrcle of Life!
		getScreen().addLine(upperLeft(),upperRight());
		getScreen().addLine(upperRight(),lowerRight());
		getScreen().addLine(lowerRight(),lowerLeft());
		getScreen().addLine(lowerLeft(),upperLeft());
	}
	@Override
	void erase() {
		getScreen().removeLine(upperLeft(),upperRight());
		getScreen().removeLine(upperRight(),lowerRight());
		getScreen().removeLine(lowerRight(),lowerLeft());
		getScreen().removeLine(lowerLeft(),upperLeft());
	}
}