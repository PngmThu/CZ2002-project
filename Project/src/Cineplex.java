

public class Cineplex {

	private String location;
	private Cinema[] cinemaManage;

	public String getLocation() {
		return this.location;
	}

	/**
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	public Cinema[] getCinemaManage() {
		return this.cinemaManage;
	}

	/**
	 * 
	 * @param cinemaManage
	 */
	public void setCinemaManage(Cinema[] cinemaManage) {
		this.cinemaManage = cinemaManage;
	}

}