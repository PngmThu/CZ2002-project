package View;

import Entities.Movie;
import Entities.MovieCensorship;
import Entities.MovieStatus;
import Entities.MovieType;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Controllers.CreateMovieCtrl.*;
import static Controllers.UpdateMovieCtrl.*;

public class UpdateMovieView extends ManageMovieListingView {
    @Override
    public void enterView() {
        String movieTitle=null, synopsis=null, directors=null, casts=null;
        int choice;
        Movie movieFound = null;
        boolean loop = true;
        System.out.println("---- Search For Movie ----");
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
            System.out.println("---- Select a movie detail to update ----");
            System.out.println("1) Status");
            System.out.println("2) Movie Type");
            System.out.println("3) Censorship");
            System.out.println("4) Synopsis");
            System.out.println("5) Director(s)");
            System.out.println("6) Cast(s)");
            System.out.println("7) Go back\n");
            System.out.print("Enter your choice: ");
            choice = readInt(1);
            if (choice==-1) continue;
            switch (choice) {
                case 1:
                    displayMovieStatus();
                    System.out.println((MovieStatus.values().length+1) + ") Go back");
                    System.out.print("Enter your choice: ");
                    choice = readInt(1);
                    if (choice == -1 || choice == (MovieStatus.values().length+1)) continue;
                    else if (choice <= 0 || choice > MovieStatus.values().length+1) {
                        System.out.println("Please enter a number between 1 to " + MovieStatus.values().length+1 + ".");
                        continue;
                    }
                    updateStatus(movieTitle,choice);
                    break;
                case 2:
                    displayMovieTypes();
                    System.out.println((MovieType.values().length+1) + ") Go back");
                    System.out.print("Enter your choice: ");
                    choice = readInt(1);
                    if (choice == -1 || choice == (MovieType.values().length+1)) continue;
                    else if (choice <= 0 || choice > MovieType.values().length+1) {
                        System.out.println("Please enter a number between 1 to " + MovieType.values().length+1 + ".");
                        continue;
                    }
                    updateMovieType(movieTitle, choice);
                    break;
                case 3:
                    displayCensorShipTypes();
                    System.out.println((MovieCensorship.values().length+1) + ") Go back");
                    System.out.print("Enter your choice: ");
                    choice = readInt(1);
                    if (choice == -1 || choice == MovieCensorship.values().length+1) continue;
                    else if (choice <= 0 || choice > MovieCensorship.values().length) {
                        System.out.println("Please enter a number between 1 to " + MovieCensorship.values().length + ".");
                        continue;
                    }
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
        }
    }
}
