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

	
	public Date getDate() {
		return this.date;
	}

	public Time getTime() {
		return this.time;
	}
	
	
	public String getDateString() {
        SimpleDateFormat ft = new SimpleDateFormat ("E dd-MM-yyyy");
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
	
	public void bookSeatAt(int row, int col) {
		seatStatus[row][col] = true;   //Book seat
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