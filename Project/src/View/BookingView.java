package View;

import java.util.ArrayList;
import java.util.Scanner;

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
    	Scanner sc = new Scanner(System.in);
    	int index, intInput, row, col;
    	double price;
    	String strInput, name, mobile, email;
    	MovieGoerGroup ageGroup = null;
    	MovieGoer movieGoer = null;
    	
    	ArrayList<Cinema> cinemaList = Cinema.getAllCinemasData();
    	ArrayList<Movie> movieList = Movie.getAllMoviesData();
    	ArrayList<MovieGoer> moviegoerList = MovieGoer.getAllMovieGoersData();
    	ArrayList<ShowTime> showtimeList = new ArrayList<ShowTime>();
    	
    	System.out.println("======================== Movie Booking ========================");
    	for(Movie movie: movieList) {
    		System.out.println("Movie: " + movie.getTitle());
    	}
    	System.out.print("\nEnter Title: ");
    	strInput = sc.nextLine();
    	index = 1;
    	System.out.println("======================== "+ strInput + " Showtimes ========================");
    	for(Cinema cinema: cinemaList) {
    		for(ShowTime st: cinema.getShowTimes()) {
    			if(st.getMovie().getTitle().equalsIgnoreCase(strInput) && 
    					!st.getMovie().getStatus().equals(MovieStatus.END)) {
    				System.out.println("(" + index + ")\tCinema Code: " + st.getCinema().getCinemaCode() + 
    						"\n\tDate: " + st.getFullDateString() + "\tTime: " + st.getTimeString());
    				System.out.println();
    				showtimeList.add(st);
    				index++;
    			}
    		}
    	}
    	System.out.print("\nChoose a Show Time Number: ");
    	intInput = sc.nextInt();
    	ShowTime showTime = showtimeList.get(intInput-1);
    	showTime.getDayOfWeek();
    	displaySeat(showTime);
    	sc.nextLine();
    	System.out.println("Enter Seat Row:");
    	strInput = sc.nextLine();
		row = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(strInput.toUpperCase());
    	System.out.println("Enter Seat Column:");
		col = sc.nextInt();
    	col -= 1;
    	Seat seat = new Seat(row, col);
    	sc.nextLine();
    	
    	
    	
		System.out.println("Enter Name:");
		name = sc.nextLine();
		System.out.println("Enter Age Group:");
		System.out.println("(1) Student");
		System.out.println("(2) Adult");
		System.out.println("(3) Senior");
		intInput = sc.nextInt();
		switch(intInput) {
			case 1:		ageGroup = MovieGoerGroup.STUDENT;
						break;
			case 2:		ageGroup = MovieGoerGroup.ADULT;
						break;
			case 3:		ageGroup = MovieGoerGroup.SENIOR;
						break;
			default:	break;
			
		}
		sc.nextLine();
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
		System.out.println("Seat:\t" + seat.getSeatString());
		System.out.println("Price:\t$" + price);
    	System.out.println("\nConfirm Booking? (Y/N)");
    	strInput = sc.nextLine();
    	if(!strInput.equalsIgnoreCase("Y")) {
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
    	
    	showTime.bookSeatAt(seat);
    	String insertBooking = ".\\data\\booking.dat";
		String updateMovieGoer = ".\\data\\movieGoer.dat";
    	//Booking booking = new Booking(movieGoer, price, showTime, seat);
		//SerializeDB.insertSerializedObject(insertBooking, booking);
		//movieGoer.addBooking(booking);
	
		SerializeDB.updateSerializedObject(updateMovieGoer, movieGoer);
    	
    	System.out.println(movieGoer.getBookings().size());
    	
    	
    	
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
