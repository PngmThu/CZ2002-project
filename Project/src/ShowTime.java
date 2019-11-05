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
		this.date = new Date(y, m, d);
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
        SimpleDateFormat ft = new SimpleDateFormat ("E dd-MM-yy");
        return ft.format(this.date);
	}
	
	public String getTimeString() {
		SimpleDateFormat ft = new SimpleDateFormat ("H:mm");
        return ft.format(this.time);
	}
	
	public int getSeatStatusAt(int row, int col) {
		return this.seatStatus[row][col];
	}
	
	public void setSeatStatusAt(int row, int col, int value) {
		seatStatus[row][col] = value;
	}
	
	public int getEmptySeatsCnt() {
		return this.emptySeatsCnt;
	}
}