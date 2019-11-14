package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieGoerView extends MoblimaViews {
    public void enterView(){
        int choice;
        boolean loop = true;
        MoblimaViews menuViews = null;
        
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        while (loop) {
            //PRINT MENU FOR HOMEPAGE USED BY BOTH MOVIE-GOERS
        	System.out.println("1) Find a Movie");
            System.out.println("2) Booking History");
            System.out.println("3) Book Now");
            System.out.println("4) Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        //bring user to SearchMovieView where they can view MovieListing
                        menuViews = new SearchMovieView();
                        break;
                    case 2:
                        //bring user to BookingHistoryView where they can view their history of bookings
                        menuViews = new BookingHistoryView();
                        break;
                    case 3:
                        //bring user to BookingView where they can begin the booking process
                        menuViews = new BookingView();
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
            menuViews.enterView();
        }
    }
}
