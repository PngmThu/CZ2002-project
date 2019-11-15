package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controllers.BookingHistoryCtrl;
import Entities.MovieGoer;

public class BookingHistoryView extends MoblimaViews{ //Allow Moviegoers to view booking history
	//DO NOT have to implement login, as we can simply use their email address and mobile number to go the entity to
    //grab their booking history. Pass this to BookingHistoryCtrl to get all their past bookings
    
	public static void main(String[] args) {
        MoblimaViews menuViews = new BookingHistoryView();
        menuViews.enterView();
    }
	
	public void enterView(){
        MoblimaViews menuViews = null;
        int choice;
        boolean loop = true;

        Scanner sc = new Scanner(System.in);
        
        try {
	        System.out.print("Enter your email: ");
	        String email = sc.nextLine();
	        
	        if (BookingHistoryCtrl.movieGoerExist(email) != null) {  //movieGoer is in the data
	        	MovieGoer movieGoer = BookingHistoryCtrl.movieGoerExist(email);
	        	//Show booking history
	        	BookingHistoryCtrl.showBookingHistory(movieGoer);
	        } else {
	        	System.out.println("You have made no transactions!");  
	        }
        } catch (InputMismatchException e) {
            System.out.println("Input Error!");
            sc.next();
        }
        
    }
}
