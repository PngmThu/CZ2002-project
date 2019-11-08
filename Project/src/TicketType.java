
public class TicketType {
	
	private String movieType;
	private String cinemaType;
	private int movieGoerGroup; //0: children, 1: student, 2: adult, 3: senior
	private String dayOfWeek;   //Mon, Tue, Wed, Thu, Fri, Sat, Sun
	private Boolean publicHoliday;
	private double price;

	public String getMovieType() {
		return this.movieType;
	}

	public String getCinemaType() {
		return this.cinemaType;
	}

	public int getMovieGoerGroup() {
		return this.movieGoerGroup;
	}

	public String getDayOfWeek() {
		return this.dayOfWeek;
	}

	public Boolean isPublicHoliday() {
		return this.publicHoliday;
	}

	public double getPrice() {
		return this.price;
	}
}
