

public class Vendor {

	private String vendorName;
	private Cineplex[] cineplexes;
	
	public Vendor() {
		vendorName = "MOBLIMA";
	    //////////////////////////////////////////
	}

	public Cineplex[] getCineplexes() {
		// TODO - implement Vendor.getCineplex
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public void setCineplexes(Cineplex[] c) {
		this.cineplexes = c;
	}

	public String getVendorName() {
		return this.vendorName;
	}

	/**
	 * 
	 * @param vendorName
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

}