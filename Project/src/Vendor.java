import java.io.Serializable;
import java.util.*;

public class Vendor implements Serializable{

	private String vendorName;
	private ArrayList<Cineplex> cineplexes;
	
	public Vendor() {
		vendorName = "MOBLIMA";
	    this.cineplexes = new ArrayList<>();
	}
	
	public String getVendorName() {
		return this.vendorName;
	}

	public Cineplex getCineplexAt(int index) {
		return this.cineplexes.get(index);
	}

	/**
	 * 
	 * @param c
	 */
	public void addCineplex(String location) {
		Cineplex cineplex = new Cineplex(location);
		cineplexes.add(cineplex);
	}

}