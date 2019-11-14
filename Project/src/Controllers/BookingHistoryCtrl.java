package Controllers;

import java.util.ArrayList;

import Entities.Booking;
import Entities.MovieGoer;
import Entities.PublicHoliday;
import Entities.*;


public class BookingHistoryCtrl {
	
	//Find movieGoer in the data
	public static MovieGoer movieGoerExist(String email) {
		ArrayList<MovieGoer> movieGoers = MovieGoer.getAllMovieGoersData();
		MovieGoer mg = new MovieGoer(email);
		
		for (int i = 0 ; i < movieGoers.size() ; i++) {
			MovieGoer movieGoer = movieGoers.get(i);
			if (mg.equals(movieGoer))
				return movieGoer;
		}
		return null;  //Not in the record of MovieGoer
	}
	
	public static void showBookingHistory(MovieGoer mg) {
		int i, j;
		ArrayList<Cineplex> cineplexes = Cineplex.getAllCineplexesData();
		ArrayList<Booking> bookings = Booking.getAllBookingsData();
		for (i = 0 ; i < bookings.size() ; i++) {
			Booking booking = bookings.get(i);
			if (mg.equals(booking.getMovieGoer())) {
				System.out.println("*********************************************");
				System.out.println("Transaction ID: " + booking.getTransactionId());
				System.out.println("Price: " + booking.getPrice());
				ShowTime showTime = booking.getShowTime();
				Cinema cinema = showTime.getCinema();
				System.out.println("------ Show Time ------");
				System.out.println("Cineplex's location: " + cineplexes.get(cinema.getCineplexId()).getLocation());
				System.out.println("Movie: " + showTime.getMovie().getTitle() + " (" + showTime.getMovie().getMovieType().getDescription() + ")");
				System.out.println("Cinema ID: " + cinema.getId() + " (" + cinema.getCinemaClass().getDescription() + ")");
				System.out.println("Date: " + showTime.getFullDateString() + "  -  " + "Time: " + showTime.getTimeString());
				System.out.print("Is it on public holiday?  ");
				if (PublicHoliday.isPublicHoliday(showTime.getDate())) {
					System.out.println("Yes");
				} else
					System.out.println("No");
				
				System.out.print("Seats: ");
				ArrayList<Seat> seats = booking.getSeat();
				for (j = 0 ; j < seats.size() ; j++) {
					Seat seat = seats.get(j);
					System.out.print(seat.getSeatString() + " ");
				}
				System.out.println("");
			}
		}
	}
}
