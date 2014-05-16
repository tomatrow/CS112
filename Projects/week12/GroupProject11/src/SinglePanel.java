import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;

public class SinglePanel extends JPanel {
	private JLabel label;
	private JTextField text;
	private JButton button; 
	private String labelText;

	public Calculation calculator;

	SinglePanel(Calculation c, String labelText) {
		super();
		setBackground(Color.red);
		calculator = c;
		this.labelText = labelText;
		buildPanel();

	}
	private void buildPanel() {
		label = new JLabel(this.labelText);
		text = new JTextField(10);
		button = new JButton("Calculate");
		button.addActionListener(new CalcButtonListener());

		add(label);
		add(text);
		add(button);
	}
	private class CalcButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str;               // To hold text entered
			str = text.getText();
			JOptionPane.showMessageDialog(null, calculator.calculate(Double.parseDouble(str)));
		}
	 } 
}