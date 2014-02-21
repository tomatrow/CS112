import java.math.BigDecimal;

class Action extends Movie {
	public static BigDecimal LATE_FEE_MULTIPLIER = new BigDecimal(3.00);
	
	Action(String title, Rating rating, int idNumber) {
		super(title,rating,idNumber);
	}

	@Override
	AJTTMoney calcLateFees(int daysLate) {
		if (daysLate < 0)
			throw new IllegalArgumentException("Days must be positive");
		return new AJTTMoney(LATE_FEE_MULTIPLIER.multiply(new BigDecimal(daysLate)));
	}
}