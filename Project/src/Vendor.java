

public class Vendor {

	private String vendorName;
	private Cineplex[] cineplexManage;

	public Cineplex[] getCineplex() {
		// TODO - implement Vendor.getCineplex
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public void setCineplexManage(Cineplex[] c) {
		this.cineplexManage = c;
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