package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieGoerView extends MoblimaViews {
    public void enterView(){
        int choice;
        boolean loop = true;
        System.out.println("");

        while (loop) {
            //PRINT MENU FOR HOMEPAGE USED BY BOTH MOVIE-GOERS
        	System.out.println("1) Find a Movie");
            System.out.println("2) Booking History");
            System.out.println("3) Book Now");
            System.out.println("4) Exit");
            System.out.print("Enter your choice: ");

            choice = readInt(1);
            if (choice==-1) continue;
            switch (choice) {
                case 1:
                    //bring user to SearchMovieView where they can view MovieListing
                    menuView = new SearchMovieView();
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
                    loop = false;
                    break;
                default:
                    System.out.println("Please enter a choice between 1 to 4.");
            }
            menuView.enterView();
        }
    }
}
