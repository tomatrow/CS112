import javax.swing.*;
import java.awt.event.*; 
import java.awt.GridLayout;

public class ConverterPanel extends JFrame {
	private final int WINDOW_WIDTH = 320;
	private final int WINDOW_HEIGHT = 200;

	public ConverterPanel() {
		super();
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		setLayout(new GridLayout(4,1));
		// buildInterface();
		
		// add(panel);
		add(new SinglePanel(new Calculation() {
			@Override
			public String calculate(double number) {
				return "Yes";
			}
		}, "Height"));
		add(new SinglePanel(new Calculation() {
			@Override
			public String calculate(double number) {
				return "Yes";
			}
		}, "Weight"));
		add(new SinglePanel(new Calculation() {
			@Override
			public String calculate(double number) {
				return "Yes";
			}
		}, "Tabelspoon"));
		add(new SinglePanel(new Calculation() {
			@Override
			public String calculate(double number) {
				return "Yes";
			}
		}, ""));

		setVisible(true);
	}

	private void buildInterface() {
		// add some panel

	}
}