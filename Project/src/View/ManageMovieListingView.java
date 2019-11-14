package View;

import Controllers.CreateMovieCtrl;
import Entities.Movie;
import Entities.MovieStatus;
import Entities.MovieType;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Controllers.CreateMovieCtrl.*;
import static Controllers.UpdateMovieCtrl.*;

public class ManageMovieListingView extends MoblimaViews {

    public static void main(String[] args) {
        MoblimaViews menuViews = new ManageMovieListingView();
        menuViews.enterView();
    }

public void enterView() {
int choice;
    boolean loop = true;
        //Page used by Admin to make changes to Movie Listing
        Scanner sc = new Scanner(System.in);
        MoblimaViews menuView = null;
        while (loop) {
            System.out.println("*************************************");
            System.out.println("Admin - Manage Movie Listing");
            System.out.println("*************************************");
            System.out.println("1) Create");
            System.out.println("2) Update");
            System.out.println("3) Remove");
            System.out.println("4) Go back");
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        //Create Movie
                        menuView = new CreateMovieView();
                        menuView.enterView();
                        break;
                    case 2:
                        //Update Movie
                        menuView = new UpdateMovieView();
                        menuView.enterView();
                        break;
                    case 3:
                        //Delete Movie;
                        menuView = new DeleteMovieView();
                        menuView.enterView();
                        break;
                    case 4:
                        loop = false;
                        break;
                    default:
                        System.out.println("Please enter a choice between 1 to 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry. Please select a number between 1 to 4.");
                sc.next();
            }
        }
    }

    private void updateMovie() {
        // Variables to be passed into UpdateMovieCtrl;
        String movieTitle=null, synopsis=null, directors=null, casts=null;
        int choice;
        Movie movieFound = null;
        boolean loop = true;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Movie Title: ");
        movieTitle = sc.nextLine();
        movieFound = retrieveMovieDetails(movieTitle);
        if(movieFound == null){
            System.out.println("The movie does not exist, please try again.");
            return;
        }
        displayMovie(movieFound);
        //Menu for multiple updates
        while (loop) {
            System.out.println("*************************************");
            System.out.println("Admin - Update Movie");
            System.out.println("*************************************");
            System.out.println("- Select a detail to update -");
            System.out.println("1) Status");
            System.out.println("2) Movie Type");
            System.out.println("3) Censorship");
            System.out.println("4) Synopsis");
            System.out.println("5) Director(s)");
            System.out.println("6) Cast(s)");
            System.out.println("7) Go back");

            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
                if (sc.hasNextLine())
                    sc.nextLine();
                switch (choice) {
                    case 1:
                        displayMovieStatus();
                        System.out.print("Enter new status:");
                        choice = sc.nextInt();
                        updateStatus(movieTitle,choice);
                        break;
                    case 2:
                        displayMovieTypes();
                        System.out.print("Enter Movie Type: ");
                        choice = sc.nextInt();
                        updateMovieType(movieTitle, choice);
                        if (sc.hasNextLine())
                            sc.nextLine();
                        break;
                    case 3:
                        displayCensorShipTypes();
                        System.out.print("Enter Censorship: ");
                        choice = sc.nextInt();
                        updateCensorship(movieTitle,choice);
                        if (sc.hasNextLine())
                            sc.nextLine();
                        break;
                    case 4:
                        System.out.print("Enter Synopsis: ");
                        synopsis = sc.nextLine();
                        updateSynopsis(movieTitle,synopsis);
                        break;
                    case 5:
                        System.out.print("Enter Directors: ");
                        directors = sc.nextLine();
                        updateDirectors(movieTitle,directors);
                        break;
                    case 6:
                        System.out.print("Enter Casts: ");
                        casts = sc.nextLine();
                        updateCasts(movieTitle,casts);
                        break;
                    case 7:
                        loop = false;
                        break;
                    default:
                        System.out.println("Please enter a choice between 1 to 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry. Please select a number between 1 to 7.");
                sc.next();
            }
        }
    }
    private void deleteMovie() {
        boolean loop = true;
        int choice;
        String movieTitle;
        Movie movieFound = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("*************************************");
        System.out.println("Admin - Delete a Movie");
        System.out.println("*************************************");
        System.out.print("Enter Movie Title: ");
        movieTitle = sc.nextLine();
        movieFound = retrieveMovieDetails(movieTitle);
        if(movieFound == null){
            System.out.println("The movie does not exist, please try again.");
            return;
        }
        while (loop){
            try {
                displayMovie(movieFound);
                System.out.println("1) Confirm Delete? ");
                System.out.println("2) Back ");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                if (sc.hasNextLine())
                    sc.nextLine();
                if (choice == 1){
                    updateStatus((movieFound.getTitle()), 4);
                    loop=false;
                } else if (choice == 2){
                    System.out.println("\nCancelling delete...");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry. Please select a number 1 or 2.");
                sc.next();
            }
        }
    }
    void displayMovie(Movie movie){
        System.out.println("*************************************");
        System.out.println("Movie title: " + movie.getTitle());
        System.out.println("Status: " + movie.getStatus());
        System.out.println("Movie type: " + movie.getMovieType().getDescription());
        System.out.println("Synopsis: " + movie.getSynopsis());
        System.out.println("Director(s): " + movie.getDirector());
        System.out.println("Cast(s): " + movie.getCast());
        System.out.println("*************************************");
;    }
}

