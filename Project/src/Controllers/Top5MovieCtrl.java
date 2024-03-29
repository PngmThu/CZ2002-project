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

		/********************************Display Information***********************************/
		//Chang num to increase the length of the box
		int num = 20;
		String str = "=".repeat(num) + " " + "LIST TOP 5 MOVIES BY TICKET SALES"  +" " + "=".repeat(num);
		//Top horizontal border
		System.out.println("\n"+("* ".repeat(str.length() / 2 + 4)));
		//Ticket Type #
		System.out.printf("*  %-" + (str.length() + 2) + "s*\n", str);
		//Top Movies By Ticket Sales Information
		for (i = 0 ; i < size ; i++) {
			Movie movie = movies.get(i);
			System.out.printf("*  %-" + (str.length() + 2) + "s*\n", "\u2022 " + movie.getTitle() +
					" with a total ticket sales of $" + Booking.getSales(movie) + "!");
		}
		//Bottom horizontal border
		System.out.printf("*  %-" + (str.length() + 2) + "s*\n","");
		System.out.println("* ".repeat(str.length() / 2 + 4));
		/*****************************************************************************************/
	}
	
	public static void displayByRatings() {
		int i, size;
		ArrayList<Movie> movies = Top5MovieCtrl.moviesByRatings();
		
		if (movies.size() >= 5)
			size = 5;
		else
			size = movies.size();

		/********************************Display Information***********************************/
		//Chang num to increase the length of the box
		int num = 13;
		String str = "=".repeat(num) + " " + "LIST TOP 5 MOVIES BY OVERALL REVIEWERS' RATING"  +" " + "=".repeat(num);
		//Top horizontal border
		System.out.println("\n"+("* ".repeat(str.length() / 2 + 4)));
		//Ticket Type #
		System.out.printf("*  %-" + (str.length() + 2) + "s*\n", str);
		//Top Movies By Average Ratings Information
		for (i = 0 ; i < size ; i++) {
			Movie movie = movies.get(i);
			System.out.printf("*  %-" + (str.length() + 2) + "s*\n", "\u2022 " + movie.getTitle() +
					" with a overall rating of " + String.format("%.1f", movie.getAvgRating()) + "!");
		}
		//Bottom horizontal border
		System.out.printf("*  %-" + (str.length() + 2) + "s*\n","");
		System.out.println("* ".repeat(str.length() / 2 + 4));
		/*****************************************************************************************/
	}
}
