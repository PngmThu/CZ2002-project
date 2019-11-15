package View;

import Controllers.UpdateShowTimeCtrl;
import Entities.Cinema;
import Entities.Cineplex;
import Entities.Movie;
import Entities.ShowTime;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Controllers.UpdateShowTimeCtrl.updateShowTime;

public class UpdateShowTimeView extends ManageShowTimesView{
    private Movie movie;
    private Cineplex cineplex;
    private Cinema cinema;

    public UpdateShowTimeView (Movie movie, Cineplex cineplex, Cinema cinema){
        this.movie = movie;
        this.cineplex = cineplex;
        this.cinema = cinema;
    }
    @Override
    public void enterView() {
        boolean loop = true; int index=0; int choice, d=0, m=0, y=0, hour=0, min=0;
        ArrayList<ShowTime> showtimes = cinema.getShowTimes();
        ShowTime showtime = null;

        while(loop) {
                System.out.println("*************************************");
                System.out.println("Admin - Updating Showtime");
                System.out.println("*************************************");
                System.out.println("Movie: " + movie.getTitle());
                System.out.println("Cineplex: " + cineplex.getLocation());
                System.out.println("Cinema: " + cinema.getCinemaCode());
                System.out.println("*************************************");
                System.out.println("Admin - Select a Showtime");
                System.out.println("*************************************");
                for (index=0; index<showtimes.size(); index++){
                    System.out.println("*************************************");
                    System.out.println("Showtime " + (index+1));
                    showtime = showtimes.get(index);
                    showtime.showShowTimeInfo();
                }
                System.out.println((index+1) + ") Go back\n");
                System.out.print("Enter your choice: ");
                choice = readInt(false);
                if (choice<=0 || choice>(showtimes.size()+1)){
                    System.out.println("Please enter a number between 1 to " + (showtimes.size() + 1) + ".");
                } else if (choice==(showtimes.size()+1)) {
                    return;
                } else if (choice>0 || choice<=(showtimes.size())){
                    System.out.println("---- Please update the following ShowTime details below ----");
                    while (loop) {
                        System.out.print("Enter new Year: ");//Input to change Movie Title
                        y = readInt(false);//Scan for input
                        if (y==-1) continue;
                        if (y<2019 || y>2050){
                            System.out.println("Please enter a value between 2019 to 2050.");
                            continue;
                        }
                        break;
                    }
                    while (loop) {
                        System.out.print("Enter new Month: ");
                        m = readInt(false);
                        if (m==-1) continue;
                        if (m<=0 || m>12){
                            System.out.println("Please enter a value between 1 to 12.");
                            continue;
                        }
                        break;
                    }
                    while (loop){
                        System.out.print("Enter Day: ");
                        d = readInt(false);
                        if (d==-1) continue;
                        else if (d<=0 || d>31){
                            System.out.println("Please enter a value between 1 to 31.");
                            continue;
                        }
                        break;
                    }
                    while (loop){
                        System.out.print("Enter new Hour: ");
                        hour = readInt(false);
                        if (hour == -1) continue;
                        else if (hour<0 || hour>23){
                            System.out.println("Please enter a value between 0 to 23.");
                            continue;
                        }
                        break;
                    }
                    while (loop){
                        System.out.print("Enter new Minute: ");
                        min = readInt(false);
                        if (min == -1) continue;
                        else if (min<0 || min>60){
                            System.out.println("Please enter a value between 0 to 60.");
                            continue;
                        }
                        break;
                    }
                    updateShowTime(cinema,index-1,y,m,d,hour,min);
                    break;
                }
        }
    }
}
