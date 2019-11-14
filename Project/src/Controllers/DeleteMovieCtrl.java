package Controllers;

import Entities.Movie;
import Entities.MovieStatus;

public class DeleteMovieCtrl {
    public static boolean checkMovieDeleted(Movie movie){
        if (movie.getStatus().equals(MovieStatus.END))
            return true;
        return false;
    }
}
