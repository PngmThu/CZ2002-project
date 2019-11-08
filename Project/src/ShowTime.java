import java.util.*;
import java.text.*;
import java.io.Serializable;
import java.sql.Time;

public class ShowTime implements Serializable{
	private Cinema cinema;
	private String movieName;
	private Date date;
	private Time time;
	private int[][] seatStatus; //0 is empty, 1 is reserved
	private int emptySeatsCnt;
	
	
	public ShowTime(Cinema cinema, String movieName, int d, int m, int y, int hour, int min) {
		this.cinema = cinema;
		this.movieName = movieName;
		this.date = new Date(y-1900, m-1, d);  //input = (year-1900,month-1,date)
		this.time = new Time(hour, min, 0);
		
		int rowSize = cinema.getColSize();
		int colSize = cinema.getColSize();
		this.seatStatus = new int[rowSize][colSize];
		for (int i = 0 ; i < rowSize ; i++) {
			for (int j = 0 ; j < colSize ; j++) {
				seatStatus[i][j] = 0;
			}
		}
		
		this.emptySeatsCnt = rowSize * colSize;
	}
	
	public Cinema getCinema() {
		return this.cinema;
	}

	public String getMovieName() {
		return this.movieName;
	}

	/**
	 * 
	 * @param movie
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
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
	
	public int[][] getSeatStatus() {
		return this.seatStatus;
	}
	
	public int getSeatStatusAt(int row, int col) {
		return this.seatStatus[row][col];
	}
	
	public void bookSeatAt(int row, int col) {
		seatStatus[row][col] = 1;   //Book seat
		emptySeatsCnt--;
	}
	
	public int getEmptySeatsCnt() {
		return this.emptySeatsCnt;
	}
	
	public boolean equals(Object o) {
		if (o instanceof ShowTime) {
			ShowTime st = (ShowTime)o;
			return cinema.equals(st.getCinema()) && getMovieName().equals(st.getMovieName()) 
					&& date.equals(st.getDate()) && time.equals(st.getTime());
		}
		return false;
	}
	
}