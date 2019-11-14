package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cinema implements Serializable{
	private int cineplexId;
	private int id;
	private String cinemaCode;
	private CinemaClass cinemaClass;  //CinemaClass.REG, ATMOS, PLATINUM
	private int rowSize;
	private int colSize;
	private Seat[][] seats;
	private ArrayList<ShowTime> showTimes;
	
	public Cinema(int cineplexId, int id, String cinemaCode, int rowSize, int colSize, CinemaClass cinemaClass) {
		int i,j;
		
		this.cineplexId = cineplexId;
		this.id = id;
		this.cinemaCode = cinemaCode;
		this.cinemaClass = cinemaClass;
		this.showTimes = new ArrayList<>();
		this.rowSize = rowSize;
		this.colSize = colSize;
		
		Seat[][] seats = new Seat[this.rowSize][this.colSize];
		for (i = 0 ; i < this.rowSize ; i++) {        
			for (j = 0 ; j < this.colSize ; j++) {
				seats[i][j] = new Seat(i, j);
			}
		}
		this.seats = seats;
	}
	
	public Cinema(int cineplexId, int id) {
		this.cineplexId = cineplexId;
		this.id = id;
	}

	public int getCineplexId() {
		return this.cineplexId;
	}

	public int getId() {
		return this.id;
	}
	
	public String getCinemaCode() {
		return this.cinemaCode;
	}
	
	public CinemaClass getCinemaClass() {
		return this.cinemaClass;
	}
	
	public int getRowSize() {
		return this.rowSize;
	}
	
	public Seat[][] getSeats() {
		return this.seats;
	}
	
	public int getColSize() {
		return this.colSize;
	}


	public ArrayList<ShowTime> getShowTimes() {
		return this.showTimes;
	}
	
	public ShowTime addShowTime(Movie movie, int d, int m, int y, int hour, int min) {
		//Pass cinema to ShowTime
		ShowTime showTime = new ShowTime(this, movie, d, m, y, hour, min);
		this.showTimes.add(showTime);

		Cinema updatedCinema = this;
		SerializeDB.updateSerializedObject(".\\data\\cinema.dat", updatedCinema);

		return showTime;
	}

    public void removeShowTime(ShowTime showtime) {
        //Pass cinema to ShowTime
        this.showTimes.remove(showtime);
        Cinema updatedCinema = this;
        SerializeDB.updateSerializedObject(".\\data\\cinema.dat", updatedCinema);
    }

	public static void initializeData() {  //Call by classname: Cinema.initializeData()
		List list = null;
		int i;
		List data = new ArrayList<>();
		String filename = ".\\data\\cinema.dat";
		
		Cinema cinema;
		
		ArrayList<Cineplex> cineplexes = Cineplex.getAllCineplexesData();
		
		
		//For cineplex 0: 
		Cineplex cineplex = cineplexes.get(0);
		//cinema 0: REG
		cinema = cineplex.addCinema("JMA", 10, 16, CinemaClass.REG);
		data.add(cinema);
		//cinema 1: ATMOS
		cinema = cineplex.addCinema("JMB", 10, 12, CinemaClass.ATMOS);
		data.add(cinema);
		//cinema 2: Platinum
		cinema = cineplex.addCinema("JMC", 4, 4, CinemaClass.PLATINUM);
		data.add(cinema);
		
		//For cineplex 1: 
		cineplex = cineplexes.get(1);
		//cinema 0
		cinema = cineplex.addCinema("PPA", 10, 16, CinemaClass.REG);
		data.add(cinema);
		//cinema 1
		cinema = cineplex.addCinema("PPB", 10, 14, CinemaClass.ATMOS);
		data.add(cinema);
		//cinema 2
		cinema = cineplex.addCinema("PPC", 6, 6, CinemaClass.PLATINUM);
		data.add(cinema);

		//For cineplex 2: Orchard
		cineplex = cineplexes.get(2);
		//cinema 0
		cinema = cineplex.addCinema("OCA", 12, 16, CinemaClass.REG);
		data.add(cinema);
		//cinema 1
		cinema = cineplex.addCinema("OCB", 10, 14, CinemaClass.ATMOS);
		data.add(cinema);
		//cinema 2
		cinema = cineplex.addCinema("OCC", 6, 6, CinemaClass.PLATINUM);
		data.add(cinema);
		
		
		SerializeDB.writeSerializedObject(filename, data);  //Write data
		
		ArrayList<Cinema> cinemas = Cinema.getAllCinemasData();   
		
		ArrayList<Movie> movies = Movie.getAllMoviesData();
		
		//Add ShowTimes for cinemas
		for (i = 0 ; i < cinemas.size() ; i += 3) {  //For each cineplex
			//Cinema 0
			cinema = cinemas.get(i);
			cinema.addShowTime(movies.get(0), 10, 11, 2019, 10, 30);
			//Cinema 1
			cinema = cinemas.get(i+1);
			cinema.addShowTime(movies.get(1), 11, 11, 2019, 21, 0);
			//Cinema 2
			cinema = cinemas.get(i+2);
			cinema.addShowTime(movies.get(0), 12, 11, 2019, 14, 45);
		}
		
		//Book a seat in cinema 0 of cineplex 0
		cinema = cinemas.get(0);
		ShowTime st = new ShowTime(cinema, movies.get(0), 10, 11, 2019, 10, 30);
		st.bookSeatAt(new Seat(0, 1));
	}
	
	public static ArrayList<Cinema> getAllCinemasData() {   //Call by classname: Cinema.getAllCinemasData()
		List list = null;
		String filename = ".\\data\\cinema.dat";
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
		
		return (ArrayList<Cinema>) list;
	}
	
	public void showCinemaInfo() {  
		int i, j, k;
		System.out.println("*********************************************");
		System.out.println("cineplexId: " + this.cineplexId );
		System.out.println("id (cinema): " + this.id);
		System.out.println("cinemaType: " + this.cinemaClass);
		System.out.println("rowSize: " + this.rowSize);
		System.out.println("colSize: " + this.colSize);
		
		System.out.println("showTimes: ");
		for (i = 0 ; i < showTimes.size() ; i++) {
			ShowTime st = showTimes.get(i);
			System.out.println("- movie Title: " + st.getMovie().getTitle());
			System.out.println("  date: " + st.getFullDateString() + "; time: " + st.getTimeString());
			
			System.out.print("  seatStatus (reserved): ");
			boolean[][] seatStatus = st.getSeatStatus();
			for (j = 0 ; j < seatStatus.length ; j++) {  //row
				for (k = 0 ; k < seatStatus[j].length ; k++) {  //column
					if (seatStatus[j][k]) {
						char x = (char)('A' + j);
						System.out.printf("%c%d ",x,k);
					}
				}
			}
			System.out.println("");
		}
	}

	public static Cinema getCinemaAt(int cineplexId, int id) {   //Call by classname: Cinema.getCinemaAt()
		List list = null;
		String filename = ".\\data\\cinema.dat";
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
		
		Cinema c = new Cinema(cineplexId, id);
		for (int i = 0 ; i < list.size() ; i++) {
			if (c.equals(list.get(i)))
				return (Cinema)list.get(i);
		}
		return null;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Cinema) {
			Cinema cinema = (Cinema)o;
			return (getCineplexId() == cinema.getCineplexId()) && (getId() == cinema.getId());
		}
		return false;
	}

}