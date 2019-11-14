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
        while (loop) {
            System.out.println("*************************************");
            System.out.println("Admin - Manage Movie Listing");
            System.out.println("*************************************");
            System.out.println("1) Create");
            System.out.println("2) Update");
            System.out.println("3) Remove");
            System.out.println("4) Go back");
            System.out.print("Enter your choice: ");
            choice = readInt(false);
            if (choice == -1) continue;
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
        }
    }

    protected void displayMovie(Movie movie){
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

