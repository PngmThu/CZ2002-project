package Controllers;

import Entities.Cinema;
import Entities.ShowTime;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class UpdateShowTimeCtrl {
    public static void updateShowTime(Cinema cinema, int index, int y, int m, int d, int hour, int min){
        ArrayList<ShowTime> showtimes = cinema.getShowTimes();
        Date date = new Date(y-1900, m-1, d);  //input = (year-1900,month-1,date)
        Time time = new Time(hour, min, 0);

        showtimes.get(index-1).setDate(date);
        showtimes.get(index-1).setTime(time);
        showtimes.get(index-1).showShowTimeInfo();
        System.out.println("Successfully updated showtime.");
    }

}
