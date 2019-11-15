package View;

import Entities.Movie;

import static Controllers.UpdateMovieCtrl.retrieveMovieDetails;
import static Controllers.UpdateMovieCtrl.updateStatus;
import static Controllers.DeleteMovieCtrl.checkMovieDeleted;

public class DeleteMovieView extends ManageMovieListingView {
    @Override
    public void enterView() {
        boolean loop = true;
        int choice;
        String movieTitle;
        Movie movieFound = null;
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

            /*********************Display Menu**************************/
            System.out.println(">>>>>>>>>>\n");

            int num = 13;
            String str = " " + "_".repeat(num) + " Staff - DELETE MOVIE " + "_".repeat(num);
            System.out.println(str);
            //System.out.println("str.length() - 3: " + (str.length() - 3));
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "1) Confirm Delete?");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "2) Back to Main Menu");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n","");

            System.out.println("* ".repeat(str.length() / 2 + 1));
            System.out.println("");
            /***********************************************************/

            System.out.print("Enter your choice: ");
            choice = readInt(1);
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
