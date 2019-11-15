package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Staff implements Serializable{

	private String username;
	private String hashedPassword;
	
	public Staff(String username, String password) {
		this.username = username;
		
		Base64.Encoder enc = Base64.getEncoder();
		
		// encode data using BASE64
        String encoded = enc.encodeToString(password.getBytes());
        
        this.hashedPassword = encoded;
	}

	public String getUsername() {
		return this.username;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public String getHashedPassword() {
		return this.hashedPassword;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		Base64.Encoder enc = Base64.getEncoder();
		
		// encode data using BASE64
        String encoded = enc.encodeToString(password.getBytes());
        
        this.hashedPassword = encoded;
	}
	
	public String getPassword() {
		Base64.Decoder dec = Base64.getDecoder();
		 
		// Decode data
	    String decoded = new String(dec.decode(this.hashedPassword));
	    
	    return decoded;
	}
	
	public static void initializeData() {  //Call by classname: Staff.initializeData()
		List list = null;
		int i;		

		List data = new ArrayList<>();
		String filename = ".\\data\\staff.dat";
		
		Staff staff;
		staff = new Staff("MinhThu", "Thu0602");
		data.add(staff);
		staff = new Staff("Yuanchao", "YuanchaoLoh");
		data.add(staff);
		
		SerializeDB.writeSerializedObject(filename, data);  //Write data
	}
	
	public static ArrayList<Staff> getAllStaffsData() {   //Call by classname: Staff.getAllStaffsData()
		List list = null;
		String filename = ".\\data\\staff.dat";
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
		
		return (ArrayList<Staff>) list;
	}
	
	public static ArrayList<Staff> addStaffAccount(Staff staff) {   //Call by classname: Staff.addStaffAccount()
		List list = null;
		String filename = ".\\data\\staff.dat";
		list = (ArrayList)SerializeDB.insertSerializedObject(filename, staff);  //Read data
		
		return (ArrayList<Staff>) list;
	}
	
	public void showStaffInfo() { 
		int i;
		System.out.println("*********************************************");
		System.out.println("username: " + this.username );
		System.out.println("password: " + this.getPassword());
		System.out.println("hashedPassword: " + this.hashedPassword);
	}
	
	public void updatePassword(String password) {
		Base64.Encoder enc = Base64.getEncoder();
		
		// encode data using BASE64
        String encoded = enc.encodeToString(password.getBytes());
        
        this.hashedPassword = encoded;
		
		Staff updatedStaff = this;
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\staff.dat", updatedStaff);
	}
	
	public boolean equals(Object o) {
		if (o instanceof Staff) {
			Staff staff = (Staff)o;
			return getUsername().equals(staff.getUsername()) && getHashedPassword().equals(staff.getHashedPassword());
		}
		return false;
	}

}