package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieGoerView extends MoblimaViews {
    public void enterView(){
        int choice;
        boolean loop = true;
        System.out.println("");

        while (loop) {
            //PRINT MENU FOR HOMEPAGE USED BY MOVIE-GOERS
            /*********************Display Menu**************************/
            int num = 13;
            System.out.println("\n>>>>>>>>>>\n");
            String str = " " + "_".repeat(num) + " MovieGoer - HOME MENU " + "_".repeat(num);
            System.out.println(str);
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "1) Movie Listing");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "2) Booking History");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "3) Booking History");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "4) List Top 5 Movies");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "5) Back to main menu");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n","");

            System.out.println("* ".repeat(str.length() / 2 + 1));
            System.out.println("");
            /***********************************************************/

            System.out.print("Enter your choice: ");
            choice = readInt(1);
            if (choice==-1) continue;
            switch (choice) {
                case 1:
                    //bring user to SearchMovieView where they can view MovieListing
                    menuView = new MovieListingView();
                    break;
                case 2:
                    //bring user to BookingHistoryView where they can view their history of bookings
                    menuView = new BookingHistoryView();
                    break;
                case 3:
                    //bring user to BookingView where they can begin the booking process
                    menuView = new BookingView();
                    break;
                case 4:
                    //bring user to Top5MovieView where they can view by overall sales or ratings.
                    menuView = new Top5MovieView();
                    break;
                case 5:
                    loop = false;
                    break;
                default:
                    System.out.println("Please enter a choice between 1 to 5.");
            }
            if (loop && menuView!=null)
                menuView.enterView();
        }
    }
}
