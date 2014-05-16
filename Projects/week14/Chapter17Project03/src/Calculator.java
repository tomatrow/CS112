import java.util.Arrays;

public class Calculator {
	private double _result;

	Calculator() {
		this(0.0);
	}
	Calculator(double result) {
		_result = result;
	}

	public void performOperation(Operation operation) {
		double result = getResult();
		if (operation.getOperator() == "+") {
			result = operation.getOperands()[0] + operation.getOperands()[1];
		} else if (operation.getOperator() == "-") {
			result = operation.getOperands()[0] - operation.getOperands()[1];
		} else if (operation.getOperator() == "*") {
			result = operation.getOperands()[0] * operation.getOperands()[1];
		} else  { // operator == "/"
			if (operation.getOperands()[1] >= -1.0e-10 && operation.getOperands()[1] <=  +1.0e-10) {
				throw new DivisionByZeroException("Can't divide by 0");
			} else {
				result = operation.getOperands()[0] / operation.getOperands()[1];// ZERRRRO
			} 
		}
		setResult(result);
	}

	// arithmetic
	public void add(double operand) {
		Operation op = new Operation("+",new double[]{getResult(),operand});
		performOperation(op);
	}
	public void subtract(double operand) {
		Operation op = new Operation("-",new double[]{getResult(),operand});
		performOperation(op);
	}
	public void multiply(double operand) {
		Operation op = new Operation("*",new double[]{getResult(),operand});
		performOperation(op);
	}
	public void divide(double operand) {
		Operation op = new Operation("/",new double[]{getResult(),operand});
		performOperation(op);
	}
	public void reset() {
		Operation op = new Operation("*",new double[]{getResult(),0.0});
		performOperation(op);		
	}

	// Boiler
	protected void setResult(double result) {
		_result = result;
	}
	public double getResult() {
		return _result;
	}
}