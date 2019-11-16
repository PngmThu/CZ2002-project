package View;

import Controllers.CreateShowtimeCtrl;
import Entities.Cinema;
import Entities.Cineplex;
import Entities.Movie;

import java.sql.Time;
import java.util.Date;

public class CreateShowTimeView extends ManageShowTimesView {
    private Movie movie;
    private Cineplex cineplex;
    private Cinema cinema;

    public CreateShowTimeView(Movie movie, Cineplex cineplex, Cinema cinema){
        this.movie = movie;
        this.cineplex = cineplex;
        this.cinema = cinema;
    }
    @Override
    public void enterView() {
        int choice, d=0, m=0, y=0, hour=0, min=0;
        boolean loop = true;
        Date showtimeDate = null;
        Time time = null;

        while (loop) {
            System.out.println("\n>>>>>>>>>>\n");
            System.out.println("*************************************");
            System.out.println("Staff - CREATE SHOWTIME");
            System.out.println("*************************************");
            System.out.println("Admin - Creating Showtime");
            System.out.println("*************************************");
            System.out.println("Movie: " + movie.getTitle());
            System.out.println("Cineplex: " + cineplex.getLocation());
            System.out.println("Cinema: " + cinema.getCinemaCode());
            System.out.println("*************************************");

            System.out.println("===== Please enter the following showtime details below =====");
            while (loop) {
                System.out.print("Enter Year: ");//Input to change Movie Title
                y = readInt(3);//Scan for input
                if (y==-1) continue;
                if (y<2019 || y>2050){
                    System.out.println("Please enter a value between 2019 to 2050.");
                    continue;
                }
                break;
            }
            while (loop) {
                System.out.print("Enter Month: ");
                m = readInt(3);
                if (m==-1) continue;
                if (m<=0 || m>12){
                    System.out.println("Please enter a value between 1 to 12.");
                    continue;
                }
                break;
            }
           while (loop){
               System.out.print("Enter Day: ");
               d = readInt(3);
               if (d==-1) continue;
               else if (d<=0 || d>31){
                   System.out.println("Please enter a value between 1 to 31.");
                   continue;
               }
               break;
           }
            while (loop){
                System.out.print("Enter Hour: ");
                hour = readInt(3);
                if (hour == -1) continue;
                else if (hour<0 || hour>23){
                    System.out.println("Please enter a value between 0 to 23.");
                    continue;
                }
                break;
            }
            while (loop){
                System.out.print("Enter Minute: ");
                min = readInt(3);
                if (min == -1) continue;
                else if (min<0 || min>60){
                    System.out.println("Please enter a value between 0 to 60.");
                    continue;
                }
                break;
            }
            break;
        }
        CreateShowtimeCtrl.addShowTime(cinema, movie, d, m, y, hour, min);
    }
}
