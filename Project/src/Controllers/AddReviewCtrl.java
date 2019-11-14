package Controllers;
import Entities.Movie;
import java.util.ArrayList;
import java.util.Scanner;
import View.AddReviewView;

public class AddReviewCtrl {
		
	public static void addNewReview(String movieTitle, String reviewer, String content, int rating) {
		int i;
		ArrayList<Movie> movies = Movie.getAllMoviesData();
		Movie movie=null;
		for(i=0 ; i < movies.size() ; i++) {
	        movie = movies.get(i);
	        if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
	        	movie.addMovieReview(reviewer, content, rating);	
	        	break;
	        }
	    }
	  
	} 
}
