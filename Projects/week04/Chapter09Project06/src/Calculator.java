import java.util.Arrays;

public class Calculator {
	private double _result;

	Calculator() {
		this(0.0);
	}
	Calculator(double result) {
		_result = result;
	}

	public static double performOperation(Operation operation) {
		if (operation.getOperator() == "+") {
			return operation.getOperands()[0] + operation.getOperands()[1];
		} else if (operation.getOperator() == "-") {
			return operation.getOperands()[0] - operation.getOperands()[1];
		} else if (operation.getOperator() == "*") {
			return operation.getOperands()[0] * operation.getOperands()[1];
		} else  { // operator == "/"
			return operation.getOperands()[0] / operation.getOperands()[1];
		}
	}

	// arithmetic
	public void add(double operand) {
		Operation op = new Operation("+",new double[]{getResult(),operand});
		setResult(performOperation(op));
	}
	public void subtract(double operand) {
		Operation op = new Operation("-",new double[]{getResult(),operand});
		setResult(performOperation(op));	
	}
	public void multiply(double operand) {
		Operation op = new Operation("*",new double[]{getResult(),operand});
		setResult(performOperation(op));	
	}
	public void divide(double operand) {
		Operation op = new Operation("/",new double[]{getResult(),operand});
		setResult(performOperation(op));	
	}
	public void clear() {
		Operation op = new Operation("*",new double[]{getResult(),0.0});
		setResult(performOperation(op));		
	}


	// Boiler
	protected void setResult(double result) {
		_result = result;
	}
	public double getResult() {
		return _result;
	}
}