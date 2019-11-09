package Entities;

import java.util.*;

public class TicketType {
	
	private MovieType movieType;
	private CinemaClass cinemaClass;
	private MovieGoerGroup[] movieGoerGroupL;      
	private String[] dayOfWeekL;        //Mon, Tue, Wed, Thu, Fri, Sat, Sun (write in order)
	private String[] isPublicHolidayL;  //true, false  (write in order)
	private String[] isBefore6pmL;      //true, false  (write in order)
	private double price;

	public MovieType getMovieType() {
		return this.movieType;
	}

	public CinemaClass getCinemaClass() {
		return this.cinemaClass;
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
	
	public String[] getIsBefore6pmL() {
		return this.isBefore6pmL;
	}

	public double getPrice() {
		return this.price;
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
	
	public boolean inIsBefore6pmL(String value) {
		for (int i = 0 ; i < isBefore6pmL.length ; i++) {
			if (value.equals(isBefore6pmL[i])) {
				return true;
			}
		}
		return false;
	}
	
	
	public static ArrayList<TicketType> getAllTicketTypesData() {   //Call by classname: TicketType.getAllTicketTypesData()
		List list = null;
		String filename = ".\\data\\ticketType.dat";
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
		
		return (ArrayList<TicketType>) list;
	}
	
	public static double computePrice(String movieType, String cinemaType, MovieGoerGroup movieGoerGroup, 
			                             String dayOfWeek, String isPublicHoliday, String isBefore6pm) {
		ArrayList<TicketType> ticketTypes = TicketType.getAllTicketTypesData();
		
		for (int i = 0 ; i < ticketTypes.size() ; i++) {
			TicketType tt = ticketTypes.get(i);
			if (movieType.equals(tt.getMovieType()) && cinemaType.equals(tt.getCinemaClass()) &&
					tt.inMovieGoerGroupL(movieGoerGroup) && tt.inDayOfWeekL(dayOfWeek) &&
					tt.inIsPublicHolidayL(isPublicHoliday) && tt.inIsBefore6pmL(isBefore6pm)) {
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
					Arrays.equals(isPublicHolidayL, tt.getIsPublicHolidayL()) && Arrays.equals(isBefore6pmL, tt.getIsBefore6pmL());
		}
		return false;
	}
	
}
