import java.math.BigDecimal;

class Chapter08Project02 {
	public static void main(String[] args) {
		Movie[] movies = new Movie[3];
		String bestMovieEver = "Lord of the Rings";
		movies[0] = new Action(bestMovieEver,Movie.Rating.PG_13,254);
		movies[1] = new Comedy(bestMovieEver,Movie.Rating.PG,3021);
		movies[2] = new Drama(bestMovieEver,Movie.Rating.R,42);
		for (Movie m : movies)
			System.out.println(m);
	}
}