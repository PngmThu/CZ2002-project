import java.io.Serializable;
import java.util.*;

public class Vendor implements Serializable{

	private String vendorName;
	private int numOfCineplexes;  //Cineplex: id [0, n - 1]
	
	public Vendor() {
		vendorName = "MOBLIMA";
		numOfCineplexes = 0;
	}
	
	public Vendor(int numOfCineplexes) {
		vendorName = "MOBLIMA";
		this.numOfCineplexes = numOfCineplexes;
	}
	
	public String getVendorName() {
		return this.vendorName;
	}
	
	public int getNumOfCineplexes() {
		return this.numOfCineplexes;
	}

	public Cineplex addCineplex(String location) {
		Cineplex cineplex = new Cineplex(numOfCineplexes, location);
		numOfCineplexes++;
		Vendor updatedVendor = this;
		
		SerializeDB.updateSerializedObject(".\\data\\vendor.dat", updatedVendor);
		SerializeDB.insertSerializedObject(".\\data\\cineplex.dat", cineplex);
		
		return cineplex;
	}
	
	public static void initializeData() {   //Call by classname: Vendor.initializeData()
		List list = null;
		int i;
		
		List data = new ArrayList<>();
		String filename = ".\\data\\vendor.dat";
		ArrayList<String> cast = new ArrayList<>();
		
		Vendor vendor = new Vendor();
		data.add(vendor);

		SerializeDB.writeSerializedObject(filename, data);  //Write data
	}
	
	public static Vendor getVendorData() {   //Call by classname: Vendor.getVendorData()
		List list = null;
		String filename = ".\\data\\vendor.dat";
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
		
		return (Vendor) list.get(0);
	}
	
	public void showVendorInfo() {   //Call by classname: Movie.showMovieInfo(...)
		int i;
		System.out.println("*********************************************");
		System.out.println("vendorName: " + this.vendorName );
		System.out.println("numOfCineplexes: " + this.numOfCineplexes);
	}
	
	public boolean equals(Object o) {
		if (o instanceof Vendor) {
			Vendor vendor = (Vendor)o;
			return (getVendorName().equals(vendor.getVendorName()));
		}
		return false;
	}
	
}