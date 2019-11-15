package Controllers;

import java.util.ArrayList;

import Entities.Booking;
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

public class BookingCtrl {
	
	private static ArrayList<Movie> movieList = Movie.getAllMoviesData();
	private static ArrayList<Cinema> cinemaList = Cinema.getAllCinemasData();
	
	public static void displayMovies() {
		for(Movie movie: movieList) {
    		System.out.println("Movie: " + movie.getTitle());
    	}
	}
	
	public static ArrayList<ShowTime> displayShowTimes(Movie movie) {
		int index = 1;
		ArrayList<ShowTime> showTimeList = new ArrayList<ShowTime>();
		for(Cinema cinema: cinemaList) {
    		for(ShowTime showTime: cinema.getShowTimes()) {
    			if(showTime.getMovie().getTitle().equalsIgnoreCase(movie.getTitle()) && 
    					!showTime.getMovie().getStatus().equals(MovieStatus.END)) {
    				System.out.println("(" + index + ")\tCinema Code: " + cinema.getCinemaCode() + 
    						"\n\tDate: " + showTime.getFullDateString() + "\tTime: " + showTime.getTimeString());
    				System.out.println();
    				showTimeList.add(showTime);
    				index++;
    			}
    		}
    	}
		return showTimeList;
	}
	
	public static MovieGoer movieGoerExist(String email) {
		ArrayList<MovieGoer> movieGoers = MovieGoer.getAllMovieGoersData();
		MovieGoer mg = new MovieGoer(email);

		for(MovieGoer movieGoer: movieGoers) {
			if (email.equals(movieGoer.getEmail()))
				return movieGoer;
		}
		return null;  //Not in the record of MovieGoer
	}
	
	public static Movie movieExist(String title) {
		for(Movie movie: movieList) {
			if(movie.getTitle().equalsIgnoreCase(title)) {
				return movie;
			}
		}
		return null;
	}
	
	public static double getPrice(ShowTime showTime, MovieGoerGroup ageGroup) {
		MovieType movieType = showTime.getMovie().getMovieType();
		CinemaClass cinemaClass = showTime.getCinema().getCinemaClass();
		MovieGoerGroup movieGoerGroup = ageGroup;
		String dayOfWeek = showTime.getDayOfWeek();
		String isPublicHoliday;
		if (PublicHoliday.isPublicHoliday(showTime.getDate())) 
			isPublicHoliday = "true";
		else
			isPublicHoliday = "false";	
		//-1 if not found in TicketType
		return TicketType.computePrice(movieType, cinemaClass, movieGoerGroup, dayOfWeek, isPublicHoliday);  	
	}
	
	public static MovieGoer addMovieGoer(String name, String mobile, String email, MovieGoerGroup ageGroup) {
		return MovieGoer.addMovieGoer(new MovieGoer(name, mobile, email, ageGroup));
	}
	
	public static boolean confirmBooking(MovieGoer movieGoer, double price, ShowTime showTime, 
			ArrayList<Seat> seatList) {
		String bookingFile = ".\\data\\booking.dat";
		String movieGoerFile = ".\\data\\movieGoer.dat";
		
		for(Seat seat: seatList) {
	    	showTime.bookSeatAt(seat);
	    }
		Booking booking = new Booking(movieGoer, price, showTime, seatList);
		SerializeDB.insertSerializedObject(bookingFile, booking);
		movieGoer.addBooking(booking);		
		SerializeDB.updateSerializedObject(movieGoerFile, movieGoer);
		return true;
	}
	
	
	public static void displaySeat(ShowTime showtime) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int row, col, decorate, r, c;
		boolean[][] seatStatus;
		
		seatStatus = showtime.getSeatStatus();
		row = showtime.getCinema().getRowSize();
		col = showtime.getCinema().getColSize();
		
		System.out.println("======================== Seat Layout ========================");
		System.out.println();
		System.out.print("    ");
		for(decorate = 1; decorate <= (col/2); decorate++) {
			System.out.print(String.format("%02d", decorate) + "  ");
		}
		System.out.print("\t ");
		for(; decorate <= col; decorate++) {
			System.out.print(String.format("%02d", decorate) + "  ");
		}
		System.out.println("");
		for(r = 0; r < row; r++) {
			decorate = 0;
			System.out.print("  ");
			while(decorate < (2*col + 1)) {
				
				System.out.print("=");
				decorate++;
			}
			System.out.print(" \t");
			while(decorate < (4*col + 2)) {
				System.out.print("=");
				decorate++;
			}
			System.out.println();
			System.out.print(alphabet.charAt(r) + " |");
			for(c = 0; c < (col/2); c++) {
				if(seatStatus[r][c]) {
					System.out.print(" x |");
				}else {
					System.out.print("   |");
				}
				if(seatStatus[r][c]) {
					
				}
			}
			System.out.print(" \t|");
			for(; c < col; c++) {
				if(seatStatus[r][c]) {
					System.out.print(" x |");
				}else {
					System.out.print("   |");
				}
			}
			System.out.println();
		}
		decorate = 0;
		System.out.print("  ");
		while(decorate < (2*col + 1)) {
			System.out.print("=");
			decorate++;
		}
		System.out.print(" \t");
		while(decorate < (4*col + 2)) {
			System.out.print("=");
			decorate++;
		}
		System.out.println("\n");
	}
}
