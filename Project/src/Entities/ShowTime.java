package Entities;

import java.util.*;
import java.text.*;
import java.io.Serializable;
import java.sql.Time;

public class ShowTime implements Serializable{
	private Cinema cinema;
	private Movie movie;
	private Date date;
	private Time time;
	private boolean[][] seatStatus; //false is empty, true is reserved
	
	
	public ShowTime(Cinema cinema, Movie movie, int d, int m, int y, int hour, int min) {
		this.cinema = cinema;
		this.movie = movie;
		this.date = new Date(y-1900, m-1, d);  //input = (year-1900,month-1,date)
		this.time = new Time(hour, min, 0);
		
		int rowSize = cinema.getColSize();
		int colSize = cinema.getColSize();
		this.seatStatus = new boolean[rowSize][colSize];
		for (int i = 0 ; i < rowSize ; i++) {
			for (int j = 0 ; j < colSize ; j++) {
				seatStatus[i][j] = false;
			}
		}
	}
	
	public Cinema getCinema() {
		return this.cinema;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie){ this.movie = movie;}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date){ this.date = date;}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time){this.time = time;}
	
	
	public String getFullDateString() {
        SimpleDateFormat ft = new SimpleDateFormat ("E dd-MM-yyyy");
        return ft.format(this.date);
	}
	
	public String getDayMonthString() {
        SimpleDateFormat ft = new SimpleDateFormat ("dd-MM");
        return ft.format(this.date);
	}
	
	public String getDayOfWeek() {
		SimpleDateFormat ft = new SimpleDateFormat ("EE");
		return ft.format(this.date);
	}
	
	public String getTimeString() {
		SimpleDateFormat ft = new SimpleDateFormat ("H:mm");
        return ft.format(this.time);
	}
	
	public boolean[][] getSeatStatus() {
		return this.seatStatus;
	}
	
	public boolean getSeatStatusAt(int row, int col) {
		return this.seatStatus[row][col];
	}
	
	public void bookSeatAt(Seat seat) {
		int row = seat.getRow();
		int col = seat.getCol();
		seatStatus[row][col] = true;   //Book seat
		Cinema updatedCinema = this.getCinema();
		SerializeDB.updateSerializedObject(".\\data\\cinema.dat", updatedCinema);	
	}
	
	public void showShowTimeInfo() {  
		System.out.println("*************************************");
		System.out.println("cineplexId: " + this.cinema.getCineplexId());
		System.out.println("cinema id: " + this.cinema.getId());
		System.out.println("cinemaClass: " + this.cinema.getCinemaClass());
		System.out.println("movie's title: " + this.movie.getTitle() );
		System.out.println("movieType: " + this.movie.getMovieType());
		System.out.println("date: " + this.getFullDateString());
		System.out.println("time: " + this.getTimeString());
		System.out.println("isPublicHoliday: " + PublicHoliday.isPublicHoliday(this.date));
	}
	
	
	public boolean equals(Object o) {
		if (o instanceof ShowTime) {
			ShowTime st = (ShowTime)o;
			return cinema.equals(st.getCinema()) && getMovie().equals(st.getMovie()) 
					&& date.equals(st.getDate()) && time.equals(st.getTime());
		}
		return false;
	}
	
}