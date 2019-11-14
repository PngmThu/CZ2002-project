package view;

import Controllers.CreateMovieCtrl;

import java.util.Scanner;

import static Controllers.CreateMovieCtrl.displayCensorShipTypes;

public class CreateMovieView extends MoblimaViews{
    public void enterView() {
        String title, status, synopsis, director, cast; // Variables to be passed into Movie.addMovie();
        int choice, movieTypeChoice, censorshipChoice;
        Scanner sc = new Scanner(System.in);
        //Prompt user to enter new movie details.
        System.out.println("*************************************");
        System.out.println("Admin - Create a Movie");
        System.out.println("*************************************");
        System.out.println("Please enter the following Movie details below.");
        System.out.print("Enter Title: ");//Input to change Movie Title
        title = sc.nextLine();//Scan for input
        System.out.print("Enter Status: ");
        status = sc.nextLine();
        //displayMovieTypes();//Method in controller to retrieve MovieTypes entity
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
}
