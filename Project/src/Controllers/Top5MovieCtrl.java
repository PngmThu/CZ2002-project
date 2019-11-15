package Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Entities.Booking;
import Entities.Movie;
import Entities.MovieStatus;

class MovieCompareBySales implements Comparator<Movie> {
	@Override
	public int compare(Movie o1, Movie o2) {
		if (Booking.getSales(o2) < Booking.getSales(o1))
			return -1;
		return 1;
	}
}

class MovieCompareByRatings implements Comparator<Movie> {
	@Override
	public int compare(Movie o1, Movie o2) {
		if (o2.getAvgRating() < o1.getAvgRating())
			return -1;
		return 1;
	}
}

public class Top5MovieCtrl {

	public static ArrayList<Movie> moviesBySales() {
		ArrayList<Movie> movies = Movie.getAllMoviesData();
		ArrayList<Movie> temp = new ArrayList<>();
		
		for (Movie movie: movies) {
			if (movie.getStatus().equals(MovieStatus.NOW) || movie.getStatus().equals(MovieStatus.PREVIEW)) {
				temp.add(movie);
			}
		}
		
		Collections.sort(temp, new MovieCompareBySales());
		
		return temp;
	}
	
	public static ArrayList<Movie> moviesByRatings() {
		ArrayList<Movie> movies = Movie.getAllMoviesData();
		Collections.sort(movies, new MovieCompareByRatings());
		
		return movies;
	}
	
	public static void displayBySales() {
		int i, size;
		ArrayList<Movie> movies = Top5MovieCtrl.moviesBySales();
		
		if (movies.size() >= 5)
			size = 5;
		else
			size = movies.size();
		
		System.out.println("");
		System.out.println("==== List top 5 movies BY ticket sales ===");
		for (i = 0 ; i < size ; i++) {
			Movie movie = movies.get(i);
			System.out.println("\u2022 " + movie.getTitle() +
					" with a total ticket sales of $" + Booking.getSales(movie) + "!" );
		}
		System.out.println("");
	}
	
	public static void displayByRatings() {
		int i, size;
		ArrayList<Movie> movies = Top5MovieCtrl.moviesByRatings();
		
		if (movies.size() >= 5)
			size = 5;
		else
			size = movies.size();
		
		System.out.println("");
		System.out.println("=== List top 5 movies BY overall reviewers' ratings ===");
		for (i = 0 ; i < size ; i++) {
			Movie movie = movies.get(i);
			System.out.println("\u2022 " + movie.getTitle() +
					" with an average rating of " + movie.getAvgRating() + "!");
		}
		System.out.println("");
	}
}
