import java.math.BigDecimal;

public class Rental {
	private int _daysLate;
	private Movie _movie;
	private int _idNumber;

	Rental() {
		this(0,null,0);
	}
	Rental(int idNumber, Movie movie, int daysLate) {
		setIdNumber(idNumber);
		setMovie(movie);
		setDaysLate(daysLate);
	}

	// ?
	public AJTTMoney lateFees() {
		return this.movie().calcLateFees(this.daysLate());
	}

	// setters
	public void setIdNumber(int idNumber) {
		if (idNumber < 0)
			throw new IllegalArgumentException("ID number must be greater than zero.");
		_idNumber = idNumber;
	}
	public void setMovie(Movie movie) {
		_movie = movie;
	}
	public void setDaysLate(int daysLate) {
		if (daysLate < 0)
			throw new IllegalArgumentException("Number of days late be greater than zero.");
		_daysLate = daysLate;
	}

	// getters
	public int idNumber() {
		return _idNumber;
	}
	public Movie movie() {
		return _movie;
	}
	public int daysLate() {
		return _daysLate;
	}

	// Object 
	@Override
	public String toString() {
		return this.getClass().getName() + ":" + idNumber() + ",<" + movie() + ">," + daysLate();
	}
}