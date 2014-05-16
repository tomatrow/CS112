/*
	File Name:          Chapter17Project03.java
	Programmer:         Andrew Caldwell
	Date Last Modified: May. 9, 2014
	Problem Statement:
		Create a calculator using swing. 

	Overall Plan:
		Use old classes from a text calculator for the model. 
		Make a swing gui with GridLayout and Arrays of buttons representing each number and operator. 
		Bring everything together in the controller 

	Classes needed and Purpose:
	main class - Chapter17Project03
	CalculatorController - Binds everything together 
	MainFrame - Holds result and operand labels and the operator and operand panes 
	DivisionByZeroException - flow control for division by zero 
	OperandPane - Holds operands 
	OperatorPane - Holds operators 
	UnknownOperatorException - flow control for strange operators  
	Calculator - The calculator class 
*/


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.ArrayList;

public class Chapter17Project03 {
	public static void main(String[] args) {
		CalculatorController controller = new CalculatorController();
		MainFrame _frame = new MainFrame(controller);
		controller._frame = _frame;
	}
	public static class CalculatorController implements ActionListener {
		private Calculator _calculator;
		private final ArrayList<String> _operators = new ArrayList<String>(Arrays.asList(OperatorPane.operatorStrings));
		private final ArrayList<String> _operands = new ArrayList<String>(Arrays.asList(OperandPane.operandStrings));
		MainFrame _frame;

		public CalculatorController() {
			_calculator = new Calculator();
		}
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			boolean commandIsOperator = _operators.contains(command);
			
			actionResponse: {
				if (commandIsOperator) {
					double[] operands = {_calculator.getResult(), Double.valueOf(_frame._operandLabel.getText().substring(8))};
					Operation operation = new Operation(command, operands);
					try {
						_calculator.performOperation(operation);
					} catch (DivisionByZeroException ex) {
						_frame._operandLabel.setText(ex.getMessage());
						break actionResponse;
					}
					_frame._resultLabel.setText("Result: " + _calculator.getResult());
				} else {
					if (command.equals("Clear")) {
						_frame._operandLabel.setText("Operand: ");
					} else if (command.equals("Reset")) {
						_calculator.reset();
						_frame._resultLabel.setText("Result: ");
					} else if (command.equals(".")) {
						if (_frame._operandLabel.getText().indexOf('.') == -1) {
							_frame._operandLabel.setText(_frame._operandLabel.getText() + command);
						}
					} else {// It's a number 
						_frame._operandLabel.setText(_frame._operandLabel.getText() + command);
					}
				}
			}
		}
	}
}