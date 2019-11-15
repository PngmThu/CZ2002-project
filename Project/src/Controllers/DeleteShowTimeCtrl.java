package Controllers;

import Entities.Cinema;
import Entities.ShowTime;

import java.util.ArrayList;

public class DeleteShowTimeCtrl {
    public static void removeShowTime(Cinema cinema, ArrayList<ShowTime> showtimes, int index){
        cinema.removeShowTime(showtimes.get(index-1));
        System.out.println("Successfully deleted showtime.");
    }

}
