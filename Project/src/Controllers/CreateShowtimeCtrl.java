package Controllers;

import Entities.Cinema;
import Entities.Movie;
import Entities.ShowTime;

import java.sql.Time;
import java.util.Date;

public class CreateShowtimeCtrl {
    public static boolean addShowTime(Cinema cinema, Movie movie, int d, int m, int y, int hour, int min){
        ShowTime showtime = cinema.addShowTime(movie,d,m,y,hour,min);
        System.out.println("Showtime successfully added.");
        showtime.showShowTimeInfo();
        return true;
    }
}
