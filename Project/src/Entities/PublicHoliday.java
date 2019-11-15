package Entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;


public class PublicHoliday implements Serializable {
	private String date;

	public PublicHoliday (String date) {    //in format dd-MM-yyyy like 25-12-2019
		this.date = date;
	}

	public String getDate() {
		return this.date;
	}
	 
	public static boolean isPublicHoliday(Date date) {
		int i;
		ArrayList<PublicHoliday> publicHolidays = PublicHoliday.getAllPublicHolidaysData();

		SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
        String dateString = ft.format(date);
        for (i = 0 ; i < publicHolidays.size() ; i++) {
        	if (dateString.equals(publicHolidays.get(i).getDate()))
        		return true;
        }
        return false;
	}

	public static void initializeData() {  //Call by classname: PublicHoliday.initializeData()
		List list = null;
		int i;
		PublicHoliday publicHoliday;
		List data = new ArrayList<>();
		String filename = ".\\data\\publicHoliday.dat";

		String[] publicHolidays = new String[] {"25-12-2019","01-01-2020","25-01-2020","26-01-2020","26-01-2020","10-04-2020",
				"01-05-2020","07-05-2020","24-05-2020","31-07-2020","09-08-2020","14-11-2020","25-12-2020"};

		for (i = 0 ; i < publicHolidays.length ; i++) {
			publicHoliday = new PublicHoliday(publicHolidays[i]);
			data.add(publicHoliday);
		}

		SerializeDB.writeSerializedObject(filename, data);  //Write data
	}

	public static ArrayList<PublicHoliday> getAllPublicHolidaysData() {
		List list = null;
		String filename = ".\\data\\publicHoliday.dat";
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data

		return (ArrayList<PublicHoliday>) list;
	}

	public void showPublicHolidayInfo() {
		int i;
		System.out.println("date: " + this.date );
	}

	public boolean equals(Object o) {
		if (o instanceof PublicHoliday) {
			PublicHoliday publicHoliday = (PublicHoliday)o;
			return getDate().equals(publicHoliday.getDate());
		}
		return false;
	}

}
