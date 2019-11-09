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

	public Booking(MovieGoer movieGoer, ShowTime showTime, Seat seat) {
		Date date = new Date();   // this object contains the current date value
		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddHHmm");
		String cinemaCode = showTime.getCinema().getCinemaCode();
		this.transactionId = cinemaCode + ft.format(date);
		
		this.movieGoer = movieGoer;
		this.showTime = showTime;
		this.seat = seat;
		
		//this.price = TicketType.computePrice(movieType, cinemaType, movieGoerGroup, dayOfWeek, isPublicHoliday, isBefore6pm)
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
	
	public static ArrayList<Booking> getAllBookingsData() {   //Call by classname: Booking.getAllBookingsData()
		List list = null;
		String filename = ".\\data\\booking.dat";
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
		
		return (ArrayList<Booking>) list;
	}
	
	public void showBookingInfo() { 
		int i;
		System.out.println("*********************************************");
		System.out.println("id: " + this.id );
		System.out.println("location: " + this.location);
		System.out.println("numOfCinemas: " + this.numOfCinemas);
	}

}