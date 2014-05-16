import java.util.Arrays;

public class Operation { 
	public static final String[] VALID_OPERATORS = {"+","-","/","*"};
	private String _operator;
	private double[] _operands;

	Operation(double[] operands) {
		setOperands(operands);
	}
	Operation(String operator, double[] operands) {
		setOperator(operator);
		setOperands(operands);
	}

	// Setters
	public void setOperator(String operator) {
		if (!(Arrays.asList(VALID_OPERATORS).contains(operator)))
			throw new UnknownOperatorException("\"" + operator + "\" is not an operator");
		_operator = operator;
	}
	public void setOperands(double[] operands) {
		int operandCount = operands.length;
		boolean hasTwoElements = (operandCount == 2);
		boolean isNull = (operands == null);
		boolean hasNull = Arrays.asList(operands).contains(null);

		if (hasTwoElements && !hasNull && !isNull)
			_operands = operands;
		else 
			throw new IllegalArgumentException(Arrays.toString(operands) + " is invalid.");
	}

	// Getters
	public String getOperator() {
		return _operator;
	}
	public double[] getOperands() {
		return  Arrays.copyOf(_operands,_operands.length);
	}

}