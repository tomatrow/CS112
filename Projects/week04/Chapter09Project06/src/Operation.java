import java.util.Arrays;

public class Operation { 
	public static final String[] VALID_OPERATORS = {"+","-","/","*"};
	private String _operator;
	private double[] _operands;

	Operation(String operator, double[] operands) {
		setOperator(operator);
		setOperands(operands);
	}

	// Setters
	private void setOperator(String operator) {
		if (!(Arrays.asList(VALID_OPERATORS).contains(operator)))
			throw new UnknownOperatorException("\"" + operator + "\" is not an operator");
		_operator = operator;
	}
	private void setOperands(double[] operands) {
		int operandCount = operands.length;
		boolean hasTwoElements = (operandCount == 2);
		boolean hasNull = Arrays.asList(operands).contains(null);
		boolean isNull = (operands == null);

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