import java.io.Serializable;
import java.util.ArrayList;

public class Cinema implements Serializable{
	private int id;
	private int rowSize = 12;
	private int colSize = 16;
	private Seat[][] seats;
	private ArrayList<ShowTime> showTimes;
	
	public Cinema(int id) {
		this.id = id;
		this.seats = new Seat[rowSize][colSize];
		this.showTimes = new ArrayList<>();
	}
	
	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRowSize() {
		return this.rowSize;
	}
	
	public int getColSize() {
		return this.colSize;
	}

	public Seat[][] getSeats() {
		return this.seats;
	}

	public void setSeatAt(int row, int col, String type) {
		seats[row][col] = new Seat(row, col, type);
	}

	public ArrayList<ShowTime> getShowTimes() {
		return this.showTimes;
	}

	/**
	 * 
	 * @param getShowTime
	 */
	public void setShowTimes(ArrayList<ShowTime> showTimes) {
		this.showTimes = showTimes;
	}
	
	public void addShowTime(String movieName, int d, int m, int y, int hour, int min) {
		//Pass cinema to ShowTime
		ShowTime showTime = new ShowTime(this, movieName, d, m, y, hour, min); 
		this.showTimes.add(showTime);
	}

}