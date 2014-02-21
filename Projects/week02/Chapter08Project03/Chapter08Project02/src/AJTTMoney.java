import java.util.Currency;
import java.math.RoundingMode;
import java.math.BigDecimal;

public class AJTTMoney {
	private static final Currency USD = Currency.getInstance("USD");
    private static final RoundingMode ROUNDING = RoundingMode.HALF_EVEN;
	private BigDecimal _amount; 

	AJTTMoney() {
		setAmount(new BigDecimal(0));
	}
	AJTTMoney(BigDecimal amount) {
		this.setAmount(amount);
	}
	AJTTMoney(AJTTMoney money) {
		this.setAmount(money.amount());
	}

	public void setAmount(BigDecimal amount) {
		_amount = amount.setScale(USD.getDefaultFractionDigits(), ROUNDING);
	}

	public BigDecimal amount() {
		return _amount;
	}

	// Object
	@Override
	public String toString() {
		return String.format("$" + amount());
	}
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		else if (o.getClass() != this.getClass())
			return false;
		else {
			AJTTMoney otherMoney = (AJTTMoney)o;
			boolean amountIsEqual = otherMoney.amount().equals(this.amount());
			return amountIsEqual;
		}
	}
	@Override
	public int hashCode() {
		return this.amount().hashCode();
	}
}