

public class Cineplex {

	private String location;
	private Cinema[] cinemas;

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

	public Cinema[] getCinemas() {
		return this.cinemas;
	}

	/**
	 * 
	 * @param cinemaManage
	 */
	public void setCinemaManage(Cinema[] cinemas) {
		this.cinemas = cinemas;
	}

}