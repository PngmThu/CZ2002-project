import java.io.Serializable;
import java.util.ArrayList;

public class Cinema implements Serializable{
	private int cineplexId;
	private int id;
	private String cinemaType;
	private int rowSize = 12;
	private int colSize = 16;
	private ArrayList<ShowTime> showTimes;
	
	public Cinema(int cineplexId, int id, String cinemaType) {
		this.cineplexId = cineplexId;
		this.id = id;
		this.cinemaType = cinemaType;
		this.showTimes = new ArrayList<>();
	}

	public int getCineplexId() {
		return this.cineplexId;
	}

	public int getId() {
		return this.id;
	}
	
	public String getCinemaType() {
		return this.cinemaType;
	}
	
	public int getRowSize() {
		return this.rowSize;
	}
	
	public int getColSize() {
		return this.colSize;
	}

	public ArrayList<ShowTime> getShowTimes() {
		return this.showTimes;
	}

	public void setShowTimes(ArrayList<ShowTime> showTimes) {
		this.showTimes = showTimes;
	}
	
	public void addShowTime(String movieName, int d, int m, int y, int hour, int min) {
		//Pass cinema to ShowTime
		ShowTime showTime = new ShowTime(this, movieName, d, m, y, hour, min); 
		this.showTimes.add(showTime);
	}

}