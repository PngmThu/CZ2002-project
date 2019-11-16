package View;

import java.util.ArrayList;

import Controllers.BookingCtrl;
import Entities.Movie;
import Entities.MovieGoer;
import Entities.Seat;
import Entities.ShowTime;

public class BookingView extends MoblimaViews{
	
    public void enterView(){
    	int chances = 2, scInt = 0;
    	double price;
    	String scString = null;
    	Movie movie = null;
    	ArrayList<Seat> seatList = new ArrayList<Seat>();
  	
    	BookingCtrl.displayMovies();
    	for(int i = chances; i >= 0; i--) {
    		System.out.print("\nEnter Title: ");
        	scString = sc.nextLine();
        	movie = BookingCtrl.movieExist(scString);
        	if(movie == null) {
        		if(i == 0) {
        			System.out.println("Movie does not exist. Returning back to the Menu.\n");
        			return;
        		}else {
        			System.out.println("Movie does not exist.\t" + i + " tries left.");
        		}
        	}else {
        		break;
        	}	
    	}   	
	
    	System.out.println("======================== "+ movie.getTitle() + " Showtimes ========================");
    	ArrayList<ShowTime> showTimeList = BookingCtrl.displayShowTimes(movie);
    	if(showTimeList.size() == 0) {
    		System.out.println("Sorry, " + movie.getTitle() + " do not have Showtimes available.");
    		System.out.println("Returning you to the Menu.");
    		return;
    	}
    	
    	for(int i = chances; i >= 0; i--) {
			System.out.print("\nChoose a Show Time Number: ");
			scInt = readInt(3);
			
			if(scInt == -1)
				return;
			if(scInt <= 0 || scInt > showTimeList.size()) {
				if(i == 0) {
        			System.out.println("Invalid Input. Returning back to the Menu.\n");
        			return;
        		}else {
        			System.out.println("Invalid Input.\t" + i + " tries left.");
        		}
	    	}else {
	    		break;
	    	}
		}
    	ShowTime showTime = showTimeList.get(scInt-1);
    	
    	menuView = new SeatView();
    	SeatView sv = (SeatView)menuView;
    	seatList = sv.enterView(showTime);
    	menuView = new ParticularsView();
    	//ParticularsView pv = (ParticularView)menuView;
    	//movieGoer = pv.enterView();
    	ParticularsView pv = (ParticularsView)menuView;
    	pv.enterView();
    	MovieGoer movieGoer = pv.getMovieGoer();
    	price = seatList.size() * BookingCtrl.getPrice(showTime, movieGoer.getMovieGoerGroup());

		System.out.println("======================== Confirm Booking ========================");
		System.out.println("Cinema:\t" + showTime.getCinema().getCinemaCode() + " (" 
		+ showTime.getCinema().getCinemaClass() + ")");
		System.out.println("Movie:\t" + showTime.getMovie().getTitle() + " " 
		+ showTime.getMovie().getCensorship());
		System.out.println("Date:\t" + showTime.getDayOfWeek() + ", Time: " + showTime.getTimeString());
		System.out.print("Seat:\t");
		for(Seat seat: seatList) {
			System.out.print(seat.getSeatString() + " ");
		}
		System.out.println("\nPrice:\t$" + price);
		
    	System.out.println("\nConfirm Booking? (Y/N)");
    	scString = sc.nextLine();
    	if(!scString.equalsIgnoreCase("Y")) {
    		System.out.println("Returning back to the Menu.");
    		return;
    	}

    	if(BookingCtrl.confirmBooking(movieGoer, price, showTime, seatList)) {
    		System.out.println("Booking done successfully! Returning back to the Menu.");
    	}else {
    		System.out.println("Error! Returning back to the Menu.");
    	}	
    }
}
