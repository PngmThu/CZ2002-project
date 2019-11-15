package Entities;

import java.io.Serializable;
import java.util.*;

public class TicketType implements Serializable {
	
	private MovieType movieType;
	private CinemaClass cinemaClass;
	private MovieGoerGroup[] movieGoerGroupL;      
	private String[] dayOfWeekL;        //Mon, Tue, Wed, Thu, Fri, Sat, Sun (write in order)
	private String[] isPublicHolidayL;  //true, false  (write in order)
	private double price;
	
	public TicketType(MovieType movieType, CinemaClass cinemaClass, MovieGoerGroup[] movieGoerGroupL,
					  String[] dayOfWeekL, String[] isPublicHolidayL, double price) {
		this.movieType = movieType;
		this.cinemaClass = cinemaClass;
		this.movieGoerGroupL = movieGoerGroupL;
		this.dayOfWeekL = dayOfWeekL;
		this.isPublicHolidayL = isPublicHolidayL;
		this.price = price;
	}

	public MovieType getMovieType() {
		return this.movieType;
	}
	
	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	public CinemaClass getCinemaClass() {
		return this.cinemaClass;
	}
	
	public void setCinemaClass(CinemaClass cinemaClass) {
		this.cinemaClass = cinemaClass;
	}

	public MovieGoerGroup[] getMovieGoerGroupL() {
		return this.movieGoerGroupL;
	}

	public String[] getDayOfWeekL() {
		return this.dayOfWeekL;
	}

	public String[] getIsPublicHolidayL() {
		return this.isPublicHolidayL;
	}

	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean inMovieGoerGroupL(MovieGoerGroup group) {
		for (int i = 0 ; i < movieGoerGroupL.length ; i++) {
			if (group == movieGoerGroupL[i]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean inDayOfWeekL(String day) {
		for (int i = 0 ; i < dayOfWeekL.length ; i++) {
			if (day.equals(dayOfWeekL[i])) {
				return true;
			}
		}
		return false;
	}
	
	public boolean inIsPublicHolidayL(String value) {
		for (int i = 0 ; i < isPublicHolidayL.length ; i++) {
			if (value.equals(isPublicHolidayL[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static void initializeData() {  //Call by classname: TicketType.initializeData()	
		List list;
		int i;
		List data = new ArrayList<>();
		String filename = ".\\data\\ticketType.dat";
		
		MovieType movieType;
		CinemaClass cinemaClass;
		MovieGoerGroup[] movieGoerGroupL;
		String[] dayOfWeekL;
		String[] isPublicHolidayL;
		double price;
		TicketType ticketType, temp;
		
		//Type 1
		movieType = MovieType.REG;
		cinemaClass = CinemaClass.REG;
		movieGoerGroupL = new MovieGoerGroup[] {MovieGoerGroup.SENIOR};
		dayOfWeekL = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri"};
		isPublicHolidayL = new String[] {"false"};
		price = 5;
		ticketType = new TicketType(movieType,cinemaClass,movieGoerGroupL,dayOfWeekL,isPublicHolidayL,price);
		data.add(ticketType);
		
		//Type 2
		movieType = MovieType.REG;
		cinemaClass = CinemaClass.REG;
		movieGoerGroupL = new MovieGoerGroup[] {MovieGoerGroup.STUDENT};
		dayOfWeekL = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri"};
		isPublicHolidayL = new String[] {"false"};
		price = 7;
		ticketType = new TicketType(movieType,cinemaClass,movieGoerGroupL,dayOfWeekL,isPublicHolidayL,price);
		data.add(ticketType);
		
		//Type 3
		movieType = MovieType.REG;
		cinemaClass = CinemaClass.REG;
		movieGoerGroupL = new MovieGoerGroup[] {MovieGoerGroup.ADULT};
		dayOfWeekL = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri"};
		isPublicHolidayL = new String[] {"false"};
		price = 9;
		ticketType = new TicketType(movieType,cinemaClass,movieGoerGroupL,dayOfWeekL,isPublicHolidayL,price);
		data.add(ticketType);
		
		//Type 4: Sat, Sun 
		movieType = MovieType.REG;
		cinemaClass = CinemaClass.REG;
		movieGoerGroupL = new MovieGoerGroup[] {MovieGoerGroup.STUDENT, MovieGoerGroup.ADULT, MovieGoerGroup.SENIOR};
		dayOfWeekL = new String[] {"Sat", "Sun"};
		isPublicHolidayL = new String[] {"false"};
		price = 13;
		ticketType = new TicketType(movieType,cinemaClass,movieGoerGroupL,dayOfWeekL,isPublicHolidayL,price);
		data.add(ticketType);
		
		//Type 5: public holiday 
		movieType = MovieType.REG;
		cinemaClass = CinemaClass.REG;
		movieGoerGroupL = new MovieGoerGroup[] {MovieGoerGroup.STUDENT, MovieGoerGroup.ADULT, MovieGoerGroup.SENIOR};
		dayOfWeekL = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		isPublicHolidayL = new String[] {"true"};  //public holiday
		price = 13;
		ticketType = new TicketType(movieType,cinemaClass,movieGoerGroupL,dayOfWeekL,isPublicHolidayL,price);
		data.add(ticketType);
		
		//Type 6: Atmos cinemaType
		movieType = MovieType.REG;
		cinemaClass = CinemaClass.ATMOS;
		movieGoerGroupL = new MovieGoerGroup[] {MovieGoerGroup.STUDENT, MovieGoerGroup.ADULT, MovieGoerGroup.SENIOR};
		dayOfWeekL = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		isPublicHolidayL = new String[] {"true", "false"}; 
		price = 14;
		ticketType = new TicketType(movieType,cinemaClass,movieGoerGroupL,dayOfWeekL,isPublicHolidayL,price);
		data.add(ticketType);
		
		//Type 7: Platinum cinemaType
		movieType = MovieType.REG;
		cinemaClass = CinemaClass.PLATINUM;
		movieGoerGroupL = new MovieGoerGroup[] {MovieGoerGroup.STUDENT, MovieGoerGroup.ADULT, MovieGoerGroup.SENIOR};
		dayOfWeekL = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		isPublicHolidayL = new String[] {"true", "false"}; 
		price = 28;
		ticketType = new TicketType(movieType,cinemaClass,movieGoerGroupL,dayOfWeekL,isPublicHolidayL,price);
		data.add(ticketType);
		
		//3D movie: price + 2
		for(i = 0 ; i < 7 ; i++) {
			temp = (TicketType) data.get(i);
			ticketType = new TicketType(MovieType._3D, temp.getCinemaClass(), temp.getMovieGoerGroupL(),
										temp.getDayOfWeekL(), temp.getIsPublicHolidayL(), temp.getPrice() + 2);
			data.add(ticketType);
		}
		
		//Blockbuster movie: price + 1
		for(i = 0 ; i < 7 ; i++) {
			temp = (TicketType) data.get(i);
			ticketType = new TicketType(MovieType.BLOCKBUSTER, temp.getCinemaClass(), temp.getMovieGoerGroupL(),
										temp.getDayOfWeekL(), temp.getIsPublicHolidayL(), temp.getPrice() + 2);
			data.add(ticketType);
		}
		
		SerializeDB.writeSerializedObject(filename, data);  //Write data
	}
	
	public static ArrayList<TicketType> getAllTicketTypesData() {   //Call by classname: TicketType.getAllTicketTypesData()
		List list = null;
		String filename = ".\\data\\ticketType.dat";
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
		
		return (ArrayList<TicketType>) list;
	}

	public static void storeNewTicketTypesData(List list){
		String filename = ".\\data\\ticketType.dat";
		SerializeDB.writeSerializedObject(filename, list);  //Read data
	}
	
	public void showTicketTypeInfo() {  
		int i;
		System.out.println("*************************************");
		System.out.println("movieType: " + this.movieType );
		System.out.println("cinemaClass: " + this.cinemaClass);
		
		System.out.print("movieGoerGroupL:  ");
		MovieGoerGroup[] movieGoerGroupL = this.movieGoerGroupL;
		for (i = 0 ; i < movieGoerGroupL.length ; i++) {
			System.out.print(movieGoerGroupL[i] + "  ");
		}
		System.out.println("");
		
		System.out.print("dayOfWeekL:  ");
		String[] dayOfWeekL = this.dayOfWeekL;
		for (i = 0 ; i < dayOfWeekL.length ; i++) {
			System.out.print(dayOfWeekL[i] + "  ");
		}
		System.out.println("");
		
		System.out.print("isPublicHolidayL:  ");
		String[] isPublicHolidayL = this.isPublicHolidayL;
		for (i = 0 ; i < isPublicHolidayL.length ; i++) {
			System.out.print(isPublicHolidayL[i] + "  ");
		}
		System.out.println("");
		
		System.out.println("price: " + this.price);
	}
	
	//MovieGoer movieGoer, ShowTime showTime
	//String movieType, String cinemaType, MovieGoerGroup movieGoerGroup, String dayOfWeek, String isPublicHoliday
	public static double computePrice(MovieType movieType, CinemaClass cinemaClass, MovieGoerGroup movieGoerGroup, 
			                             String dayOfWeek, String isPublicHoliday) {
		ArrayList<TicketType> ticketTypes = TicketType.getAllTicketTypesData();
		
		for (int i = 0 ; i < ticketTypes.size() ; i++) {
			TicketType tt = ticketTypes.get(i);
			if (movieType.equals(tt.getMovieType()) && cinemaClass.equals(tt.getCinemaClass()) &&
					tt.inMovieGoerGroupL(movieGoerGroup) && tt.inDayOfWeekL(dayOfWeek) && tt.inIsPublicHolidayL(isPublicHoliday)) {
				return tt.getPrice();
			}
		}
		return -1;   //Not found in the TicketType list
	}
	
	public boolean equals(Object o) {
		if (o instanceof TicketType) {
			TicketType tt = (TicketType)o;
			return getMovieType().equals(tt.getMovieType()) && getCinemaClass().equals(tt.getCinemaClass()) &&
					Arrays.equals(movieGoerGroupL, tt.getMovieGoerGroupL()) && Arrays.equals(dayOfWeekL, tt.getDayOfWeekL()) &&
					Arrays.equals(isPublicHolidayL, tt.getIsPublicHolidayL());
		}
		return false;
	}
	
}
