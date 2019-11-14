package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controllers.BookingCtrl;
import Entities.Cinema;
import Entities.CinemaClass;
import Entities.Movie;
import Entities.MovieGoer;
import Entities.MovieGoerGroup;
import Entities.MovieStatus;
import Entities.MovieType;
import Entities.PublicHoliday;
import Entities.Seat;
import Entities.SerializeDB;
import Entities.ShowTime;
import Entities.TicketType;

public class BookingView extends MoblimaViews{
	
    public void enterView(){
    	int index, numTicket = 0, scInt, row, col;
    	double price;
    	String scString, name, mobile, email;
    	MovieGoerGroup ageGroup = null;
    	MovieGoer movieGoer = null;
    	Movie movie;
    
    	ArrayList<MovieGoer> moviegoerList = MovieGoer.getAllMovieGoersData();
    	
    	System.out.println("======================== Movie Booking ========================");
    	BookingCtrl.displayMovies();
    	do {
    		System.out.print("\nEnter Title: ");
        	scString = sc.nextLine();
        	movie = BookingCtrl.movieExist(scString);
    	}while(movie == null);
	
    	System.out.println("======================== "+ movie.getTitle() + " Showtimes ========================");
    	ArrayList<ShowTime> showTimeList = BookingCtrl.displayShowTimes(movie);
    	if(showTimeList.size() == 0) {
    		System.out.println("Sorry, " + movie.getTitle() + " do not have Showtimes available.");
    		System.out.println("Returning you to the Visitor Menu");
    		return;
    	}
    	System.out.print("\nChoose a Show Time Number: ");
    	scInt = readInt(true);
    	ShowTime showTime = showTimeList.get(scInt-1);
    	System.out.print("\nNumber of Tickets to Purchase: ");
    	numTicket = readInt(true);
    	
    	ArrayList<Seat> seatList = new ArrayList<Seat>();
    	for(int i = 0; i < numTicket; i++) {
    		BookingCtrl.displaySeat(showTime);
    		System.out.print("\nEnter Seat Row: ");
    		scString = sc.nextLine();
    		row = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(scString.toUpperCase());
        	System.out.print("\nEnter Seat Column: ");
    		col = readInt(true);
        	col -= 1;
        	if(showTime.getSeatStatusAt(row, col)) {
        		System.out.println("Seat is occupied. Please try again.");
        		i--;
        	}else {
        		for(Seat seat: seatList) {
            		if(seat.getRow() == row && seat.getCol() == col) {
            			System.out.println("You have already selected this seat in your previous selection.");
            			System.out.println("Please try again.");
            			i--;
            			break;
            		}else {
            			seatList.add(new Seat(row, col));
            		}
            	}
        	}
    	} 	
    	
		System.out.print("\nEnter Name: ");
		name = sc.nextLine();
		System.out.println("Enter Age Group:");
		
		index = 1;
		for(MovieGoerGroup group: MovieGoerGroup.values()) {
			System.out.println("(" + index + ") " + group.getDescription());
			index++;
		}
		do {
			scInt = readInt(true);
			if(scInt >= 0 && scInt < MovieGoerGroup.values().length) {
				ageGroup = MovieGoerGroup.values()[scInt-1];
			}
		}while(ageGroup == null);
		System.out.println(ageGroup.getDescription());
		// Went to sleep
		System.out.println("Enter Mobile:");
		mobile = sc.nextLine();
		System.out.println("Enter Email:");
		email = sc.nextLine();
    	
		
		//************************************************************************************************
		MovieType movieType = showTime.getMovie().getMovieType();
		CinemaClass cinemaClass = showTime.getCinema().getCinemaClass();
		MovieGoerGroup movieGoerGroup = ageGroup;
		String dayOfWeek = showTime.getDayOfWeek();
		String isPublicHoliday;
		if (PublicHoliday.isPublicHoliday(showTime.getDate())) 
			isPublicHoliday = "true";
		else
			isPublicHoliday = "false";
		
		price = TicketType.computePrice(movieType, cinemaClass, movieGoerGroup, dayOfWeek, isPublicHoliday);  //-1 if not found in TicketType
		//************************************************************************************************
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
    		return;
    	}
    	
		for(MovieGoer mg: moviegoerList) {
    		if(mg.getEmail().equals(email)) {
    			movieGoer = mg;
    			break;
    		}
    	}
    	if(movieGoer == null) {
    		movieGoer = new MovieGoer(name, mobile, email, ageGroup);
    		movieGoer = MovieGoer.addMovieGoer(movieGoer);
    	}
	    for(Seat seat: seatList) {
	    	showTime.bookSeatAt(seat);
	    }
    	
    	String insertBooking = ".\\data\\booking.dat";
		String updateMovieGoer = ".\\data\\movieGoer.dat";
    	//Booking booking = new Booking(movieGoer, price, showTime, seat);
		//SerializeDB.insertSerializedObject(insertBooking, booking);
		//movieGoer.addBooking(booking);
	
		SerializeDB.updateSerializedObject(updateMovieGoer, movieGoer);
    	
    	System.out.println(movieGoer.getBookings().size());
    	
    	
    	
    }
    
    
}
