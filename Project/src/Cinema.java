

public class Cinema1 {

	private Seat[] seats;
	private ShowTime[] getShowTime;
	private int id;

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

	public ShowTime[] getGetShowTime() {
		return this.getShowTime;
	}

	/**
	 * 
	 * @param getShowTime
	 */
	public void setGetShowTime(ShowTime[] getShowTime) {
		this.getShowTime = getShowTime;
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

}