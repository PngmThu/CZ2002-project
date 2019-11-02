

public class Booking {

	private MovieGoer movieGoer;
	private String transactionId;
	private Seat[] seats;
	private double price;
	private ShowTime showTime;

	public MovieGoer getMovieGoer() {
		return this.movieGoer;
	}

	/**
	 * 
	 * @param movieGoer
	 */
	public void setMovieGoer(MovieGoer movieGoer) {
		this.movieGoer = movieGoer;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	/**
	 * 
	 * @param transactionId
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Seat[] getSeats() {
		return this.seats;
	}

	/**
	 * 
	 * @param seats
	 */
	public void setSeats(Seat[] seats) {
		this.seats = seats;
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public ShowTime getShowTime() {
		return this.showTime;
	}

	/**
	 * 
	 * @param showTime
	 */
	public void setShowTime(ShowTime showTime) {
		this.showTime = showTime;
	}

}