package View;

import java.util.ArrayList;

import Controllers.BookingCtrl;
import Controllers.BookingHistoryCtrl;
import Entities.Booking;
import Entities.Movie;
import Entities.MovieGoer;
import Entities.MovieGoerGroup;
import Entities.Seat;
import Entities.ShowTime;


public class BookingView extends MoblimaViews{
	
    public void enterView(){
    	int index, numTicket = 0, scInt, row, col;
    	double price;
    	String scString, name, mobile = null, email;
    	MovieGoerGroup ageGroup = null;
    	MovieGoer movieGoer = null;
    	Movie movie = null;
    	ArrayList<Seat> seatList = new ArrayList<Seat>();
  	
    	System.out.println("======================== Movie Booking ========================");
    	BookingCtrl.displayMovies();
   
    	for(int i = 2; i >= 0; i--) {
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
    		System.out.println("Returning you to the Visitor Menu");
    		return;
    	}
    	System.out.print("\nChoose a Show Time Number: ");
    	scInt = readInt(3);
    	if(scInt == -1 || scInt <= 0 || scInt >= showTimeList.size())
    		return;
    	ShowTime showTime = showTimeList.get(scInt-1);
    	System.out.print("\nNumber of Tickets to Purchase: ");
    	numTicket = readInt(3);
    	if(numTicket == -1)
    		return;
    	
    	for(int i = 0; i < numTicket; i++) {
    		
    		BookingCtrl.displaySeat(showTime);
    		System.out.print("\nEnter Seat Row: ");
    		scString = sc.nextLine();
    		
    		for(int x = 2; x >= 0; x--) {
    			System.out.print("\nEnter Seat Row: ");
    			scString = sc.nextLine();
            	try {
            		if(scString.length() != 1) {
            			throw new Exception("'" + scString + "' is entered incorrectly.");
            		}else {
            			break;
            		}
                } catch (Exception e) {
                   System.out.print(e.getMessage());
                }
            	if(x == 0) {
            		System.out.print(" Returning back to the Menu.\n");
            		return;
            	}else {
            		System.out.print("\t" + x + " tries left.");
            	}
    		}
  		
    		row = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(scString.toUpperCase());
        	System.out.print("\nEnter Seat Column: ");
    		col = readInt(3);
    		if(col == -1)
        		return;
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
			scInt = readInt(3);
			if(scInt == -1)
	    		return;
			if(scInt >= 0 && scInt < MovieGoerGroup.values().length) {
				ageGroup = MovieGoerGroup.values()[scInt-1];
			}
		}while(ageGroup == null);
		
		for(int i = 2; i >= 0; i--) {
			if(i == 0)
    			return;
			System.out.println("Enter Mobile (8 digits):");
    		mobile = sc.nextLine();
        	try {
        		int num = Integer.parseInt(mobile);
        		
        		if(mobile.length() != 8) {
        			throw new Exception("'" + mobile + "' is not 8 digits.\t" + i + " tries left.");
        		}else {
        			break;
        		}
            } catch (NumberFormatException e) {
            	System.out.println(mobile + " is not a number.\t" + i + " tries left.");
            } catch (Exception e) {
               System.out.println(e.getMessage());
            }
		}
		
		System.out.println("Enter Email:");
		email = sc.nextLine();	

		price = (double)numTicket * BookingCtrl.getPrice(showTime, ageGroup);
		
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
    	movieGoer = BookingCtrl.movieGoerExist(email);
    	if(movieGoer == null) {
    		movieGoer = BookingCtrl.addMovieGoer(name, mobile, email, ageGroup);
    	}

    	if(BookingCtrl.confirmBooking(movieGoer, price, showTime, seatList)) {
    		System.out.println("Booking done successfully! Returning back to the Menu.");
    	}else {
    		System.out.println("Error! Returning back to the Menu.");
    	}
    	
    }
}
