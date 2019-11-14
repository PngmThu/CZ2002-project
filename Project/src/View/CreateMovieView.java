package View;

import Entities.Movie;
import Entities.MovieStatus;
import Entities.MovieType;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Controllers.CreateMovieCtrl.*;
import static Controllers.CreateMovieCtrl.addMovie;

public class CreateMovieView extends ManageMovieListingView{
    public void enterView() {
        String title, synopsis, director, cast;
        MovieStatus status;// Variables to be passed into Movie.addMovie();
        int choice, movieTypeChoice=0, censorshipChoice=0, movieStatusChoice=0;
        Movie movie = null;
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        //Prompt user to enter new movie details.
        while (loop) {
            try {
                System.out.println("*************************************");
                System.out.println("Admin - Create a Movie");
                System.out.println("*************************************");
                System.out.println("Please enter the following Movie details below.");
                System.out.print("Enter Title: ");//Input to change Movie Title
                title = sc.nextLine();//Scan for input
                displayMovieStatus();
                try {
                    System.out.print("Enter Status: ");
                    movieStatusChoice = sc.nextInt();
                    if (movieStatusChoice <= 0 || movieStatusChoice > MovieStatus.values().length) {
                        System.out.println("Please enter a number between 1 to " + MovieStatus.values().length + ".");
                        continue;
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Please enter a number between 1 to " + MovieStatus.values().length + ".");
                    sc.next();
                    continue;
                }
                displayMovieTypes();//Method in controller to retrieve MovieTypes entity
                System.out.print("Enter Movie Type: ");
                try {
                    System.out.print("Enter Status: ");
                    movieTypeChoice = sc.nextInt();
                    if (movieTypeChoice <= 0 || movieTypeChoice > MovieType.values().length) {
                        System.out.println("Please enter a number between 1 to " + MovieType.values().length + ".");
                        continue;
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Please enter a number between 1 to " + MovieType.values().length + ".");
                    sc.next();
                    continue;
                }
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
                movie = addMovie(title, movieStatusChoice, synopsis, director, movieTypeChoice, cast, censorshipChoice);
                displayMovie(movie);
                System.out.println("1)Confirm Create");
                System.out.println("2)Go back");
                System.out.println("Movie Added Successfully!");
            } catch(InputMismatchException e) {
                System.out.println("Some entry are invalid, please try again.");
                sc.next();
            }
        }
    }
}
