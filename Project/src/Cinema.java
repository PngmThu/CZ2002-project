import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cinema implements Serializable{
	private int cineplexId;
	private int id;
	private String cinemaType;  //Standard, Atmos, Platinum
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
	
	public void addShowTime(String movieName, int d, int m, int y, int hour, int min) {
		//Pass cinema to ShowTime
		ShowTime showTime = new ShowTime(this, movieName, d, m, y, hour, min); 
		this.showTimes.add(showTime);
		///////Update in database////////
	}
	
	public static void initializeData() {  //Call by classname: Cinema.initializeData()
		List list = null;
		int i;
		List data = new ArrayList<>();
		String filename = ".\\data\\cinema.dat";
		
		Cinema cinema;
		
		ArrayList<Cineplex> cineplexes = Cineplex.getAllCineplexesData();
		
		for (i = 0 ; i < cineplexes.size() ; i++) {
			Cineplex cineplex = cineplexes.get(i);
			//cinema 0
			cinema = cineplex.addCinema("Standard");
			cinema.addShowTime("Big Hero 6", 10, 11, 2019, 10, 30);
			data.
			//cinema 1
			cinema = cineplex.addCinema("Atmos");
			cinema.addShowTime("Avengers: Endgame", 11, 11, 2019, 21, 0);
			//cinema 2
			cineplex.addCinema("Platinum");
			cinema.addShowTime("Big Hero 6", 12, 11, 2019, 14, 45);
		}
		
		Movie movie = new Movie("Big Hero 6","Showing","A nice movie for family","Don Hall, Chris Williams",4.8,
				"Blockbuster",cast,movieReviews);
		data.add(movie);
		SerializeDB.writeSerializedObject(filename, data);  //Write data
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
	}

}