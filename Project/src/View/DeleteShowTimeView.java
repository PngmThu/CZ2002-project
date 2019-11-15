package View;

import Entities.Cinema;
import Entities.Cineplex;
import Entities.Movie;
import Entities.ShowTime;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Controllers.DeleteShowTimeCtrl.removeShowTime;

public class DeleteShowTimeView extends ManageShowTimesView {
    private Movie movie;
    private Cineplex cineplex;
    private Cinema cinema;

    public DeleteShowTimeView(Movie movie, Cineplex cineplex, Cinema cinema){
        this.movie = movie;
        this.cineplex = cineplex;
        this.cinema = cinema;
    }

    public void enterView() {
        boolean loop = true; int index=0; int choice, d=0, m=0, y=0, hour=0, min=0;
        ArrayList<ShowTime> showtimes = cinema.getShowTimes();
        ShowTime showtime = null;

        while(loop) {
            System.out.println("*************************************");
            System.out.println("Admin - Deleting Showtime");
            System.out.println("*************************************");
            System.out.println("Movie: " + movie.getTitle());
            System.out.println("Cineplex: " + cineplex.getLocation());
            System.out.println("Cinema: " + cinema.getCinemaCode());
            System.out.println("*************************************");
            System.out.println("Admin - Select a Showtime");
            System.out.println("*************************************");
            for (index=0; index<showtimes.size(); index++){
                System.out.println("*************************************");
                System.out.println((index+1)+") Showtime " + (index+1));
                showtime = showtimes.get(index);
                showtime.showShowTimeInfo();
                System.out.println("*************************************");
            }
            if (index==0) System.out.println("There is no showtime available.");
            System.out.println((index+1) + ") Go back\n");
            System.out.print("Enter your choice: ");
            choice = readInt(false);
            if (choice==-1) continue;
            if (choice==0 || choice>(showtimes.size()+1)){
                System.out.println("Please enter a number between 1 to " + (showtimes.size() + 1) + ".");
            } else if (choice==(showtimes.size()+1)) {
                return;
            } else if (choice>0 || choice<=(showtimes.size())){
                removeShowTime(cinema,showtimes,index);
                break;
            }
        }
    }
}
