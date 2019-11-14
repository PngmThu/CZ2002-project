package Controllers;
import Entities.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieDetailsCtrl{



    public static void displayMovieDetails(String movieTitle) {
        ArrayList<Movie> movies = Movie.getAllMoviesData();
        
        for(Movie movie : movies){
            if(movieTitle.equalsIgnoreCase(movie.getTitle())){
            	System.out.println("*********************************************");
        		System.out.println("Movie: " + movie.getTitle() + movie.getCensorship() + " (" + movie.getMovieType().getDescription() + ")");
        		System.out.println("Status: " + movie.getStatus());
        		System.out.println("Director: " + movie.getDirector());
        		System.out.println("Cast: " + movie.getCast());
        		System.out.println("Synopsis: " + movie.getSynopsis());
        		System.out.println("Overall Rating: " + String.format("%.2f", movie.getAvgRating()));
        		break;
            }
        }
    }


}