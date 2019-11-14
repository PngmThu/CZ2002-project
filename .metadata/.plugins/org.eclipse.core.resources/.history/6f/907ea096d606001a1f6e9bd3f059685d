package view;

import java.util.ArrayList;
import java.util.Scanner;

import Entities.Booking;
import Entities.MovieGoer;

public class BookingHistoryView extends MoblimaViews{ //Allow Moviegoers to view booking history
	
    public void enterView() {
        //Call BookingHistoryController
    	Scanner sc = new Scanner(System.in);
    	int index;
    	String name, email;
    	MovieGoer movieGoer = null;
    	
    	ArrayList<MovieGoer> moviegoerList = MovieGoer.getAllMovieGoersData();
    	
    	System.out.println("======================== Booking History ========================");
    	System.out.println("\t\tUser Verification");
    	System.out.print("\tName: ");
    	name = sc.nextLine();
    	System.out.print("\n\tEmail: ");
    	email = sc.nextLine();
    	
    	for(MovieGoer mg: moviegoerList) {
    		if(mg.getEmail().equals(email)) {
    			movieGoer = mg;
    			break;
    		}
    	}
    	if(movieGoer == null) {
    		System.out.println("You did not make any bookings.");
    		return;
    	}else {
    		index = 1;
    		for(Booking booking: movieGoer.getBookings()) {
    			System.out.println("(" + index++ + ") Transaction ID:\t" + booking.getTransactionId());
    			System.out.println("Cinema:\t" + booking.getShowTime().getCinema().getCinemaCode() + " (" 
				+ booking.getShowTime().getCinema().getCinemaClass() + ")");
				System.out.println("Movie:\t" + booking.getShowTime().getMovie().getTitle()+ " " 
				+ booking.getShowTime().getMovie().getCensorship());
				System.out.println("Date:\t" + booking.getShowTime().getDayOfWeek() + ", Time: " 
				+ booking.getShowTime().getTimeString());
				System.out.println("Seat:\t" + booking.getSeat().getSeatString());
				System.out.println("Price:\t$" + booking.getPrice());
    		}
    		
    	}
    	
    }
}
