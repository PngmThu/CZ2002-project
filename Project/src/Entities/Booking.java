package Entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Booking implements Serializable {
	private String transactionId;  //format: XXXYYYYMMDDhhmm (XXX : cinema code in letters)
	private MovieGoer movieGoer;
	private double price;
	private ShowTime showTime;
	private Seat seat;

	public Booking(MovieGoer movieGoer, double price, ShowTime showTime, Seat seat) {
		Date date = new Date();   // this object contains the current date value
		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddHHmm");
		String cinemaCode = showTime.getCinema().getCinemaCode();
		String insertBooking = ".\\data\\booking.dat";
		String updateMovieGoer = ".\\data\\movieGoer.dat";
		
//		showTime.bookSeatAt(seat);
		
		this.transactionId = cinemaCode + ft.format(date);
		this.price = price;
		this.movieGoer = movieGoer;
		this.showTime = showTime;
		this.seat = seat;
//		System.out.println(this.getPrice());
//		SerializeDB.insertSerializedObject(insertBooking, this);
//		movieGoer.getBookings().add(this);
//		SerializeDB.updateSerializedObject(updateMovieGoer, movieGoer);
	}
	
	public String getTransactionId() {
		return this.transactionId;
	}

	public MovieGoer getMovieGoer() {
		return this.movieGoer;
	}

	public double getPrice() {
		return this.price;
	}

	public ShowTime getShowTime() {
		return this.showTime;
	}

	public Seat getSeat() {
		return this.seat;
	}
	
	public static void initializeData() {  //Call by classname: Booking.initializeData()
		List list = null;
		int i;		
		List data = new ArrayList<>();
		String filename = ".\\data\\booking.dat";
		
		ArrayList<MovieGoer> movieGoers = MovieGoer.getAllMovieGoersData();
		ArrayList<Cinema> cinemas = Cinema.getAllCinemasData();
		
		MovieGoer movieGoer = movieGoers.get(0);
		Cinema cinema = Cinema.getCinemaAt(0, 0);
		ShowTime showTime = cinema.getShowTimes().get(0);
		Seat seat = new Seat(1,1);
		Booking booking = new Booking(movieGoer, 30, showTime, seat);
		data.add(booking);
		
		SerializeDB.writeSerializedObject(filename, data);  //Write data
	}
	
	public static ArrayList<Booking> getAllBookingsData() {   //Call by classname: Booking.getAllBookingsData()
		List list = null;
		String filename = ".\\data\\booking.dat";
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
		
		return (ArrayList<Booking>) list;
	}
	
	public void showBookingInfo() { 
		int i;
		System.out.println("*********************************************");
		System.out.println("transactionId: " + this.transactionId);
		System.out.println("movieGoerGroup: " + this.movieGoer.getMovieGoerGroup());
		System.out.println("price: " + this.price);
		System.out.println("-- showTime -- ");
		this.showTime.showShowTimeInfo();
		System.out.println("seat: " + this.seat.getSeatString());
	}

}