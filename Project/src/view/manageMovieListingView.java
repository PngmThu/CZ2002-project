package view;

import Controllers.CreateMovieCtrl;
import Controllers.UpdateMovieCtrl;
import Entities.Movie;


import java.util.InputMismatchException;
import java.util.Scanner;

import static Controllers.CreateMovieCtrl.displayCensorShipTypes;
import static Controllers.CreateMovieCtrl.displayMovieTypes;

import static Controllers.UpdateMovieCtrl.*;

public class manageMovieListingView extends MoblimaViews {

    public static void main(String[] args) {
        MoblimaViews menuViews = new manageMovieListingView();
        menuViews.enterView();
    }

public void enterView() {
    int choice;
    boolean loop = true;
        //Page used by Admin to make changes to Movie Listing
        Scanner sc = new Scanner(System.in);
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
                        createMovie();
                        break;
                    case 2:
                        //Update Movie
                        updateMovie();
                        break;
                    case 3:
                        //Delete Movie;
                        deleteMovie();
                        break;
                    case 4:
                        loop = false;
                        break;
                    default:
                        System.out.println("Please enter a choice between 1 to 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please select a number between 1 to 4:");
                sc.next();
            }
        }
    }

    private void createMovie() {
        String title, status, synopsis, director, cast; // Variables to be passed into Movie.addMovie();
        int choice, movieTypeChoice, censorshipChoice;
        Scanner sc = new Scanner(System.in);
        //Prompt user to enter new movie details.
        System.out.println("Please enter the following Movie details below.");
        System.out.print("Enter Title: ");//Input to change Movie Title
        title = sc.nextLine();//Scan for input
        System.out.print("Enter Status: ");
        status = sc.nextLine();
        displayMovieTypes();//Method in controller to retrieve MovieTypes entity
        System.out.print("Enter Movie Type: ");
        movieTypeChoice = sc.nextInt();
        System.out.print("Enter Synopsis: ");
        if (sc.hasNextLine())
            sc.nextLine();
        synopsis = sc.nextLine();
        System.out.print("Enter Director(s): ");
        director = sc.nextLine();
        System.out.print("Enter Cast(s): ");
        cast = sc.nextLine();
        displayCensorShipTypes();//Method in controller to retrieve MovieCensorshipTypes entity
        System.out.print("Enter Censorship: ");
        censorshipChoice = sc.nextInt();
        if (sc.hasNextLine())
            sc.nextLine();
        //Pass collected user inputs to CreateMovieCtrl
        CreateMovieCtrl.addMovie(title, status, synopsis, director, movieTypeChoice, cast, censorshipChoice);
    }

    private void updateMovie() {
        // Variables to be passed into UpdateMovieCtrl;
        String movieTitle=null, status=null, synopsis=null, directors=null, casts=null;

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
            System.out.println("- Select a detail to update -");
            System.out.println("1) Status");
            System.out.println("2) Movie Type");
            System.out.println("3) Censorship");
            System.out.println("4) Synopsis");
            System.out.println("5) Director(s)");
            System.out.println("6) Cast(s)");
            System.out.println("7) Done");

            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
                if (sc.hasNextLine())
                    sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter new status:");
                        status = sc.nextLine();
                        updateStatus(movieTitle,status);
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
                        System.out.println("Please enter a choice between 1 to 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please select a number between 1 to 6:");
                sc.next();
            }
        }
    }
    private void deleteMovie() {
        int choice;
        String movieTitle;
        Movie movieFound = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Movie Title: ");
        movieTitle = sc.nextLine();
        movieFound = retrieveMovieDetails(movieTitle);
        if(movieFound == null){
            System.out.println("The movie does not exist, please try again.");
            return;
        }
        displayMovie(movieFound);
        System.out.println("1) Confirm Delete? ");
        System.out.println("2) Back ");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        if (sc.hasNextLine())
            sc.nextLine();
        try {
            if (choice == 1){
                UpdateMovieCtrl.updateStatus(movieFound,"End Of Showing");
            } else if (choice == 2){
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice! Please select a number 1 or 2:");
            sc.next();
        }
    }
    private void displayMovie(Movie movie){
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

