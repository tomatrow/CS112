import java.math.BigDecimal;

class Movie {
	public static enum Rating {
		G,PG,PG_13,R;
	}
	public static BigDecimal LATE_FEE_MULTIPLIER = new BigDecimal(2.00);

	private Rating _rating;
	private int _idNumber;
	private String _title;

	Movie() {
		this(null,null,0);
	}
	Movie(String title, Rating rating, int idNumber) {	
		setRating(rating);
		setIdNumber(idNumber);
		setTitle(title);
	}

	AJTTMoney calcLateFees(int daysLate) {
		if (daysLate < 0)
			throw new IllegalArgumentException("Days must be positive");
		return new AJTTMoney(LATE_FEE_MULTIPLIER.multiply(new BigDecimal(daysLate)));
	}

	// getters
	public Rating rating() {
		return _rating;
	}
	public int idNumber() {
		return _idNumber;
	}
	public String title() {
		return _title;
	}

	// setters
	public void setIdNumber(int idNumber) {
		if (idNumber < 0) 
			throw new IllegalArgumentException("ID must be positive");
		_idNumber = idNumber;
	}
	public void setRating(Rating rating) {
		_rating = rating;
	}
	public void setTitle(String title) {
		_title = title;
	}

	// Object
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		else if (this.getClass() != o.getClass())
			return false;
		else {
			Movie otherMovie = (Movie)o;
			boolean idNumberIsEqual = this.idNumber() == otherMovie.idNumber();
			return idNumberIsEqual;
		}
	}

	@Override
	public int hashCode() {
		return this.rating().ordinal() ^ this.idNumber() ^ this.title().hashCode();
	}
	@Override
	public String toString() {
		return this.getClass().getName() + ":" + this.title() + "," + this.rating() + "," + this.idNumber();
	}
}