package view;

import Entities.Movie;
import Entities.MovieCensorship;
import Entities.MovieType;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Entities.Movie.addMovie;

public class manageMovieListingView extends MoblimaViews {

    public static void main(String[] args) {
        MoblimaViews menuViews = new manageMovieListingView();
        menuViews.enterView();
    }

public void enterView() {
    MoblimaViews menuViews = null;
    int choice;
    boolean loop = true;

        //Page used by Admin to make changes to Movie Listing
        System.out.println("Admin - Manage Movie Listing");
        System.out.println("*************************************");
        Scanner sc = new Scanner(System.in);
        while (loop) {
            System.out.println("1) Create");
            System.out.println("2) Update");
            System.out.println("3) Remove");
            System.out.println("4) Go back");
            System.out.print("Enter your choice: ");
            //PRINT MENU FOR HOMEPAGE USED BY BOTH MOVIE-GOERS
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        //Create Movie
                        createMovie();
                        //bring user to SearchMovieView where they can view MovieListing
                        menuViews = new SearchMovieView();
                        break;
                    case 2:
                        //Update Movie
                        updateMovie();
                        //bring user to Top 5 By Sales/OverallRatingView
                        menuViews = new BookingHistoryView();
                        break;
                    case 3:
                        //Delete Movie;
                        deleteMovie();
                        //bring user to Top 5 By Sales/OverallRatingView
                        menuViews = new BookingView();
                        break;
                    case 4:
                        loop = false;
                        break;
                    default:
                        System.out.println("Please enter a choice between 1 to 3.");
                        System.out.println("Please enter a choice between 1 to 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please select a number between 1 to 3:");
                System.out.println("Invalid choice! Please select a number between 1 to 4:");
                sc.next();
            }
            menuViews.enterView();
        }
    }

    private void createMovie() {
        String title, status, synopsis, director, cast; // Variables to be passed into Movie.addMovie();
        int choice;
        MovieCensorship movieCensorship = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the following Movie details below.");
        System.out.print("Enter Title: ");
        title = sc.nextLine();
        System.out.print("Enter Status: ");
        status = sc.nextLine();
        System.out.println(" Movie types: ");
        MovieType[] movieTypes = MovieType.values();
        for (MovieType movieType : movieTypes) {
            //.ordinal() is to get the index in the array.
            System.out.println((movieType.ordinal() + 1) + ") " + movieType.getDescription());
        }
        System.out.print("Enter Movie Type: ");
        choice = sc.nextInt();
        MovieType movieType = movieTypes[choice - 1];
        System.out.print("Enter Synopsis: ");
        if (sc.hasNextLine())
            sc.nextLine();
        synopsis = sc.nextLine();
        System.out.print("Enter Director(s): ");
        director = sc.nextLine();
        System.out.print("Enter Cast(s): ");
        cast = sc.nextLine();
        MovieCensorship[] censorships = MovieCensorship.values();
        for (MovieCensorship censorship : censorships) {
            //.ordinal() is to get the index in the array.
            System.out.println((censorship.ordinal() + 1) + ") " + censorship.getDescription());
        }
        System.out.print("Enter Censorship: ");
        choice = sc.nextInt();
        if (choice == 1) {
            movieCensorship = MovieCensorship.G;
        } else if (choice == 2) {
            movieCensorship = MovieCensorship.PG;
        } else if (choice == 3) {
            movieCensorship = MovieCensorship.PG13;
        } else if (choice == 4) {
            movieCensorship = MovieCensorship.NC16;
        } else if (choice == 5) {
            movieCensorship = MovieCensorship.M18;
        } else if (choice == 6) {
            movieCensorship = MovieCensorship.R21;
        } else {
        }
        addMovie(title, status, synopsis, director, movieType, cast, movieCensorship);
    }

    private boolean updateMovie() {

        return false;
    }

    private boolean deleteMovie() {

        return false;
    }
}

