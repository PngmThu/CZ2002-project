package View;

import Entities.Movie;

import static Controllers.UpdateMovieCtrl.retrieveMovieDetails;
import static Controllers.UpdateMovieCtrl.updateStatus;
import static Controllers.DeleteMovieCtrl.checkMovieDeleted;

public class DeleteMovieView extends ManageMovieListingView {
    public void enterView() {
        boolean loop = true;
        int choice;
        String movieTitle;
        Movie movieFound = null;
        System.out.println("*************************************");
        System.out.println("Admin - Delete a Movie");
        System.out.println("*************************************");
        System.out.print("Enter Movie Title: ");
        movieTitle = sc.nextLine();
        movieFound = retrieveMovieDetails(movieTitle);
        if(movieFound == null){
            System.out.println("The movie does not exist, please try again.");
            return;
        } else if (checkMovieDeleted(movieFound)) {
            System.out.println("The movie has already been deleted.");
            return;
        }
        while (loop){
            displayMovie(movieFound);
            System.out.println("1) Confirm Delete? ");
            System.out.println("2) Back ");
            System.out.print("Enter your choice: ");
            choice = readInt(false);
            if (choice == 1){
                updateStatus((movieFound.getTitle()), 4);
                loop=false;
            } else if (choice == 2){
                System.out.println("\nCancelling delete...");
                return;
            } else if (choice == -1) return;
            else System.out.println("Please enter a number 1 or 2");
        }
    }
}
