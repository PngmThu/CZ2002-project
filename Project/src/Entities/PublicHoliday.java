package Entities;

import java.text.SimpleDateFormat;
import java.util.*;


public class PublicHoliday {
	private ArrayList<Date> dates = new ArrayList<>();
	private Date date;
	private static String[] publicHolidays = new String[] {"25-12-2019","01-01-2020","25-01-2020","26-01-2020","26-01-2020","10-04-2020",
												"01-05-2020","07-05-2020","24-05-2020","31-07-2020","09-08-2020","14-11-2020","25-12-2020"};
	
	 
	public static boolean isPublicHoliday(Date date) {
		int i;
		SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
        String dateString = ft.format(date);
        for (i = 0 ; i < publicHolidays.length ; i++) {
        	if (dateString.equals(publicHolidays[i]))
        		return true;
        }
        return false;
	}
}
