package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovieGoer implements Serializable{

	private String name;
	private String mobile;
	private String email;
	private MovieGoerGroup movieGoerGroup;  //1: student, 2: adult, 3: senior
	private ArrayList<Booking> bookings;
	
	public MovieGoer(String name, String mobile, String email, MovieGoerGroup movieGoerGroup) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.movieGoerGroup = movieGoerGroup;
		this.bookings = new ArrayList<Booking>();
	}

	public String getName() {
		return this.name;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return this.email;
	}

	public MovieGoerGroup getMovieGoerGroup() {
		return this.movieGoerGroup;
	}
	
	public ArrayList<Booking> getBookings() {
		return this.bookings;
	}
	
	public static MovieGoer addMovieGoer(MovieGoer movieGoer) {   //Call by classname: MovieGoer.addMovieGoer()
		String filename = ".\\data\\movieGoer.dat";
		SerializeDB.insertSerializedObject(filename, movieGoer);  //Read data
		return movieGoer;
	}
	public void addBooking(Booking booking) {
		this.bookings.add(booking);
	}
	
	public static void initializeData() {  //Call by classname: MovieGoer.initializeData()	
		MovieGoer movieGoer;
		List data = new ArrayList<>();
		String filename = ".\\data\\movieGoer.dat";
		
		movieGoer = new MovieGoer("Minh Thu", "86187124", "phamthu0602@gmai.com", MovieGoerGroup.STUDENT);  //student
		data.add(movieGoer);
		movieGoer = new MovieGoer("Yuanchao", "93802613", "yuanchao.loh@gmail.com", MovieGoerGroup.SENIOR);  //senior
		data.add(movieGoer);
		
		SerializeDB.writeSerializedObject(filename, data);  //Write data
	}
	
	public static ArrayList<MovieGoer> getAllMovieGoersData() {   //Call by classname: MovieGoer.getAllMovieGoersData()
		List list = null;
		String filename = ".\\data\\movieGoer.dat";
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
		
		return (ArrayList<MovieGoer>) list;
	}
	
	public void showMovieGoerInfo() { 
		System.out.println("*********************************************");
		System.out.println("name: " + this.name );
		System.out.println("mobile: " + this.mobile);
		System.out.println("email: " + this.email);
		System.out.println("movieGoerGroup: " + this.movieGoerGroup);
	}
	
	public boolean equals(Object o) {
		if (o instanceof MovieGoer) {
			MovieGoer movieGoer = (MovieGoer)o;
			return name.equals(movieGoer.getName()) && email.equals(movieGoer.getEmail());
		}
		return false;
	}

}