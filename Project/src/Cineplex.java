import java.io.Serializable;
import java.util.*;

public class Cineplex implements Serializable{

	private String location;
	private ArrayList<Cinema> cinemas;
	
	public Cineplex(String location) {
		this.location = location;
		cinemas = new ArrayList<>();
	}

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

	public Cinema getCinemaAt(int index) {
		return this.cinemas.get(index);
	}

	public void addCinema(int id) {
		Cinema cinema = new Cinema(id);
		cinemas.add(cinema);
	}

}