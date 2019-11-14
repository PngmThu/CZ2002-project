package Controllers;

import Entities.MovieCensorship;
import Entities.MovieStatus;
import Entities.MovieType;
import Entities.Movie;

public class CreateMovieCtrl {// To Support the creation of a new movie.
    public static void displayCensorShipTypes(){// Gather Censorship types and pass back to manageMovieListingView
        MovieCensorship[] censorships = MovieCensorship.values();
        for (MovieCensorship censorship : censorships) {
            //.ordinal() is to get the index in the array.
            System.out.println((censorship.ordinal() + 1) + ") " + censorship.getDescription());
        }
    }

    public static void displayMovieTypes(){
        System.out.println(" Movie types: ");
        MovieType[] movieTypes = MovieType.values();
        for (MovieType movieType : movieTypes) {
            //.ordinal() is to get the index in the array.
            System.out.println((movieType.ordinal() + 1) + ") " + movieType.getDescription());
        }
    }

    public static void displayMovieStatus(){
        System.out.println(" Movie Status: ");
        MovieStatus[] moviestatuses = MovieStatus.values();
        for (MovieStatus movieStatus: moviestatuses) {
            //.ordinal() is to get the index in the array.
            System.out.println((movieStatus.ordinal() + 1) + ") " + movieStatus.getDescription());
        }
    }

    public static Movie addMovie(String title, int movieStatusChoice, String synopsis,
                                String director, int movieTypeChoice, String cast, int censorshipChoice){
        MovieCensorship movieCensorship = null;
        MovieType movieType = null;
        MovieStatus movieStatus = null;
        if (movieTypeChoice ==1){
            movieType = MovieType.REG;
        } else if (movieTypeChoice == 2){
            movieType = MovieType._3D;
        } else if (movieTypeChoice == 3) {
            movieType = MovieType.BLOCKBUSTER;
        }else{
        }
        if (censorshipChoice == 1) {
            movieCensorship = MovieCensorship.G;
        } else if (censorshipChoice == 2) {
            movieCensorship = MovieCensorship.PG;
        } else if (censorshipChoice == 3) {
            movieCensorship = MovieCensorship.PG13;
        } else if (censorshipChoice == 4) {
            movieCensorship = MovieCensorship.NC16;
        } else if (censorshipChoice == 5) {
            movieCensorship = MovieCensorship.M18;
        } else if (censorshipChoice == 6) {
            movieCensorship = MovieCensorship.R21;
        } else {
        }
        if (movieStatusChoice == 1){
            movieStatus = MovieStatus.COMING;
        } else if(movieStatusChoice == 2){
            movieStatus = MovieStatus.PREVIEW;
        } else if(movieStatusChoice == 3){
            movieStatus = MovieStatus.NOW;
        } else if(movieStatusChoice == 4){
            movieStatus = MovieStatus.END;
        }
        return Movie.addMovie(title, movieStatus, synopsis, director, movieType, cast, movieCensorship);
    }

    public static void deleteMovie(Movie movie){
        movie.deleteMovie();
    }
}
