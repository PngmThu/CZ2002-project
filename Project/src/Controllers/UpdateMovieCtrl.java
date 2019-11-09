package Controllers;

import Entities.Movie;
import Entities.MovieCensorship;
import Entities.MovieType;

import java.util.ArrayList;

import static Entities.Movie.getAllMoviesData;

public class UpdateMovieCtrl { //Updates Movie - To change movie details or to delete movie.
    public static Movie retrieveMovieDetails(String movieTitle){
        ArrayList<Movie> movies = getAllMoviesData();
        for (Movie movie: movies) {
            if (movie.getTitle().equals(movieTitle))
                return movie;
        }
        return null;
    }

    public static void updateStatus(String movieTitle, String status){
        ArrayList<Movie> movies = getAllMoviesData();
        for (Movie movie : movies){
            if (movie.getTitle().equals(movieTitle)){
                movie.updateStatus(status);
                System.out.println("Movie status updated successfully.");
                return;
            }
        }
        System.out.println("Movie update unsuccessful, please try again.");
    }

    public static void updateMovieType(String movieTitle, int movieTypeChoice){
        MovieType movieType = null;

        if (movieTypeChoice ==1){
            movieType = MovieType.REG;
        } else if (movieTypeChoice == 2){
            movieType = MovieType._3D;
        } else if (movieTypeChoice == 3) {
            movieType = MovieType.BLOCKBUSTER;
        }else{}
        ArrayList<Movie> movies = getAllMoviesData();
        for (Movie movie : movies){
            if (movie.getTitle().equals(movieTitle)){
                movie.updateMovieType(movieType);
                System.out.println("Movie Type updated successfully.");
                return;
            }
        }
        System.out.println("Movie update unsuccessful, please try again.");
    }

    public static void updateCensorship(String movieTitle, int censorshipChoice){
        MovieCensorship censorship = null;
        if (censorshipChoice == 1) {
            censorship = MovieCensorship.G;
        } else if (censorshipChoice == 2) {
            censorship = MovieCensorship.PG;
        } else if (censorshipChoice == 3) {
            censorship = MovieCensorship.PG13;
        } else if (censorshipChoice == 4) {
            censorship = MovieCensorship.NC16;
        } else if (censorshipChoice == 5) {
            censorship = MovieCensorship.M18;
        } else if (censorshipChoice == 6) {
            censorship = MovieCensorship.R21;
        } else {
        }
        ArrayList<Movie> movies = getAllMoviesData();
        for (Movie movie : movies){
            if (movie.getTitle().equals(movieTitle)){
                movie.updateMovieCensorship(censorship);
                System.out.println("Movie Censorship updated successfully.");
                return;
            }
        }
        System.out.println("Movie update unsuccessful, please try again.");
    }

    public static void updateSynopsis(String movieTitle, String synopsis){
        ArrayList<Movie> movies = getAllMoviesData();
        for (Movie movie : movies){
            if (movie.getTitle().equals(movieTitle)){
                movie.updateSynopsis(synopsis);
                System.out.println("Movie Synopsis updated successfully.");
                return;
            }
        }
        System.out.println("Movie update unsuccessful, please try again.");
    }

    public static void updateDirectors(String movieTitle, String directors){
        ArrayList<Movie> movies = getAllMoviesData();
        for (Movie movie : movies){
            if (movie.getTitle().equals(movieTitle)){
                movie.updateDirectors(directors);
                System.out.println("Movie Directors updated successfully.");
                return;
            }
        }
        System.out.println("Movie update unsuccessful, please try again.");
    }

    public static void updateCasts(String movieTitle, String casts){
        ArrayList<Movie> movies = getAllMoviesData();
        for (Movie movie : movies){
            if (movie.getTitle().equals(movieTitle)){
                movie.updateCasts(casts);
                System.out.println("Movie Casts updated successfully.");
                return;
            }
        }
        System.out.println("Movie update unsuccessful, please try again.");
    }

    public static void updateStatus(Movie movie, String status){
        if (movie.getStatus().equals(status))
            System.out.println("This movie is non-existent.");
        else{
        movie.updateStatus(status);
        System.out.println("Movie successfully deleted.");
        return;
        }
    }

}
