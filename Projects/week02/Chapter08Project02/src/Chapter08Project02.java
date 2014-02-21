/* Chapter No. 08 - Project No. 02
    File Name:          Chapter08Project02.java
    Programmer:         Andrew Caldwell
    Date Last Modified: Jan. 30, 2014
    
    Problem Statement:
		Use polymorphism in a movie model
    
    Overall Plan
		intialize movieArray with three Movie subclasses
		print out movieArray

    Classes needed and Purpose
    main class - Chapter08Project02
    Movie - movie model
	Action - movie model subclass
	Drama - movie model subclass
	Comedy - movie model subclass
	AJTTMoney - money container
*/

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