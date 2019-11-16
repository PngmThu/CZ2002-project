package Controllers;

import java.util.ArrayList;

import Entities.MovieGoer;
import Entities.MovieGoerGroup;

public class ParticularsCtrl {
	public static MovieGoer movieGoerExist(String email) {
		ArrayList<MovieGoer> movieGoers = MovieGoer.getAllMovieGoersData();

		for(MovieGoer movieGoer: movieGoers) {
			if (email.equals(movieGoer.getEmail()))
				return movieGoer;
		}
		return null;
	}
	
	public static MovieGoer addMovieGoer(String name, String mobile, String email, MovieGoerGroup ageGroup) {
		return MovieGoer.addMovieGoer(new MovieGoer(name, mobile, email, ageGroup));
	}
}
