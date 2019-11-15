package View;

import Entities.Movie;
import Entities.MovieCensorship;
import Entities.MovieStatus;
import Entities.MovieType;

import static Controllers.CreateMovieCtrl.*;
import static Controllers.CreateMovieCtrl.addMovie;

public class CreateMovieView extends ManageMovieListingView{
    @Override
    public void enterView() {
        /***Variables to be passed into Movie.addMovie();***/
        int choice, movieTypeChoice, censorshipChoice, movieStatusChoice;
        String title, synopsis, director, cast;
        Movie movie = null;
        /*************************************************/

        boolean loop = true; //Control the loop.

        //Prompt user to enter new movie details.
        while (loop) {
            System.out.println("*************************************");
            System.out.println("Admin - Create a Movie");
            System.out.println("*************************************");
            System.out.println("---- Enter the following movie details below ----");
            //Get movie title input from user
            System.out.print("Enter Title: ");//Input to change Movie Title
            title = sc.nextLine();
            if (checkExistingMovie(title)){
                System.out.println("The movie has already been created.");
                return;
            }
            //Get movie status input from user
            displayMovieStatus();//Method in controller to display MovieStatus entity
            System.out.print("Enter Status: ");
            movieStatusChoice = readInt(1);
            if (movieStatusChoice == -1) continue;
            else if (movieStatusChoice <= 0 || movieStatusChoice > MovieStatus.values().length) {
                System.out.println("Please enter a number between 1 to " + MovieStatus.values().length + ".");
                continue;
            }
            //Get movie type input from user
            displayMovieTypes();//Method in controller to display MovieTypes entity
            System.out.print("Enter Movie Type: ");
            movieTypeChoice = readInt(1);
            if (movieTypeChoice == -1) continue;
            else if (movieTypeChoice <= 0 || movieTypeChoice > MovieType.values().length) {
                System.out.println("Please enter a number between 1 to " + MovieType.values().length + ".");
                continue;
            }
            //Get movie synopsis input from user
            System.out.print("Enter Synopsis: ");
            synopsis = sc.nextLine();
            //Get movie directors input from user
            System.out.print("Enter Director(s): ");
            director = sc.nextLine();
            //Get movie cast(s) input from user
            System.out.print("Enter Cast(s): ");
            cast = sc.nextLine();
            //Get movie censorship input from user
            displayCensorShipTypes();//Method in controller to display MovieCensorshipTypes entity
            System.out.print("Enter Censorship: ");
            censorshipChoice = readInt(1);
            if (censorshipChoice == -1) continue;
            else if (movieTypeChoice <= 0 || movieTypeChoice > MovieType.values().length) {
                System.out.println("Please enter a number between 1 to " + MovieCensorship.values().length + ".");
                continue;
            }
            //Pass collected user inputs to CreateMovieCtrl
            movie = addMovie(title, movieStatusChoice, synopsis, director, movieTypeChoice, cast, censorshipChoice);

            while (loop) {
                displayMovie(movie);
                System.out.println("1) Create Movie?");
                System.out.println("2) Cancel");
                System.out.print("Enter your choice: ");
                choice = readInt(3);
                if (choice == 1){
                    System.out.println("Movie Created Successfully!");
                    return;
                } else if (choice == 2){
                    //Calling CreateMovieCtrl to delete newly created movie.
                    deleteMovie(movie);
                    System.out.println("Cancelling Movie Creation...");
                    return;
                }else System.out.println("Please enter a number 1 or 2.");
            }
        }
    }
}
