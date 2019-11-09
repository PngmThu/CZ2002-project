package Controllers;
import Entities.Movie;

import java.util.ArrayList;

public class MovieDetailsCtrl{



    public static void displayMovieDetail(String movieTitle) {

        ArrayList<Movie> movies = Movie.getAllMoviesData();
        for(Movie movie : movies){
            if(movieTitle.equals(movie.getTitle())){
                  movie.showMovieInfo();
            }
        }
        System.out.println("*********************************************");
        // menu = new BookingView(movie);
    }
}