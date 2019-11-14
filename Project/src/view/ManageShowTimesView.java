package view;

import Controllers.CreateMovieCtrl;
import Controllers.CreateShowtimeCtrl;
import Entities.Cinema;
import Entities.Cineplex;
import Entities.Movie;
import Entities.ShowTime;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageShowTimesView extends MoblimaViews {

    public static void main(String[] args){
        ManageShowTimesView view = new ManageShowTimesView();
        view.enterView();
    }

    public void enterView(){
        int choice;
        boolean loop = true;
        Cineplex cineplex = null; Movie movie=null; Cinema cinema = null;
        //Page used by Admin to make changes to Movie Listing
        Scanner sc = new Scanner(System.in);
        while (loop) {
            System.out.println("*************************************");
            System.out.println("Admin - Manage Movie Showtimes");
            System.out.println("*************************************");
            System.out.println("1) Create");
            System.out.println("2) Update");
            System.out.println("3) Remove");
            System.out.println("4) Go back");
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
                if (sc.hasNextLine())
                    sc.nextLine();
                if (choice == 4){
                    break;
                }
                movie = chooseMovie();
                if (movie==null)
                    continue;
                cineplex = chooseCineplex();
                if (cineplex==null)
                    continue;
                cinema = chooseCinema(cineplex);
                if (cinema==null)
                    continue;
                switch (choice) {
                    case 1:
                        //Create Showtime
                        createShowtime(movie,cineplex,cinema);
                        break;
                    case 2:
                        //Update Showtime
                        updateShowtime(movie,cineplex,cinema);
                        break;
                    case 3:
                        //Delete Showtime;
                        deleteShowtime(movie,cineplex,cinema);
                        break;
                    case 4:
                        loop = false;
                        break;
                    default:
                        System.out.println("Please enter a choice between 1 to 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please select a number between 1 to 4.");
            }
        }
    }

    private void createShowtime (Movie movie, Cineplex cineplex, Cinema cinema){
        int choice, d=0, m=0, y=0, hour=0, min=0;
        boolean loop = true;
        Date showtimeDate = null;
        Time time = null;
        Scanner sc = new Scanner(System.in);

        while (loop) {
            System.out.println("*************************************");
            System.out.println("Admin - Creating Showtime");
            System.out.println("*************************************");
            System.out.println("Movie: " + movie.getTitle());
            System.out.println("Cineplex: " + cineplex.getLocation());
            System.out.println("Cinema: " + cinema.getCinemaCode());
            System.out.println("*************************************");

            System.out.println("Please enter the following ShowTime details below.");
            System.out.print("Enter Year: ");//Input to change Movie Title
            y = sc.nextInt();//Scan for input
            System.out.print("Enter Month: ");
            m = sc.nextInt();
            System.out.print("Enter Day: ");
            d = sc.nextInt();
            System.out.print("Enter Hour: ");
            hour = sc.nextInt();
            System.out.print("Enter Minute: ");
            min = sc.nextInt();
            break;
        }
        CreateShowtimeCtrl.addShowTime(cinema, movie, d, m, y, hour, min);


    }

    private void updateShowtime (Movie movie, Cineplex cineplex, Cinema cinema){
        boolean loop = true; int index=0; int choice, d=0, m=0, y=0, hour=0, min=0;
        ArrayList<ShowTime> showtimes = cinema.getShowTimes();
        ShowTime showtime = null;
        Scanner sc = new Scanner(System.in);

        while(loop) {
            try {
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
                System.out.println((index+1) + ") Go back");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                if (sc.hasNextLine())
                    sc.nextLine();
                if (choice==0 || choice>(showtimes.size()+1)){
                    System.out.println("Please enter a number between 1 to " + (showtimes.size() + 1) + ".");
                } else if (choice==(showtimes.size()+1)) {
                    return;
                } else if (choice>0 || choice<=(showtimes.size())){
                    System.out.print("Enter Year: ");//Input to change Movie Title
                    y = sc.nextInt();//Scan for input
                    System.out.print("Enter Month: ");
                    m = sc.nextInt();
                    System.out.print("Enter Day: ");
                    d = sc.nextInt();
                    System.out.print("Enter Hour: ");
                    hour = sc.nextInt();
                    System.out.print("Enter Minute: ");
                    min = sc.nextInt();

                    Date date = new Date(y-1900, m-1, d);  //input = (year-1900,month-1,date)
                    Time time = new Time(hour, min, 0);

                    showtimes.get(index-1).setDate(date);
                    showtimes.get(index-1).setTime(time);
                    showtimes.get(index-1).showShowTimeInfo();
                    System.out.println("Successfully added showtime.");
                    break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Please enter a number between 1 to " + (showtimes.size() + 1) + ".");
                sc.next();
            }
        }
    }

    private void deleteShowtime (Movie movie, Cineplex cineplex, Cinema cinema){
        boolean loop = true; int index=0; int choice, d=0, m=0, y=0, hour=0, min=0;
        ArrayList<ShowTime> showtimes = cinema.getShowTimes();
        ShowTime showtime = null;
        Scanner sc = new Scanner(System.in);

        while(loop) {
            try {
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
                    System.out.println("Showtime " + (index+1));
                    showtime = showtimes.get(index);
                    showtime.showShowTimeInfo();
                }
                System.out.println((index+1) + ") Go back");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                if (sc.hasNextLine())
                    sc.nextLine();
                if (choice==0 || choice>(showtimes.size()+1)){
                    System.out.println("Please enter a number between 1 to " + (showtimes.size() + 1) + ".");
                } else if (choice==(showtimes.size()+1)) {
                    return;
                } else if (choice>0 || choice<=(showtimes.size())){

                    cinema.removeShowTime(showtimes.get(index-1));
                    System.out.println("Successfully deleted showtime.");
                    break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Please enter a number between 1 to " + (showtimes.size() + 1) + ".");
                sc.next();
            }
        }
    }

    private Movie chooseMovie(){
        boolean loop = true;
        int choice; int index=0;//Format Print Indexes
        ArrayList<Movie> movies = Movie.getAllMoviesData();
        Movie movie = null;
        Scanner sc = new Scanner(System.in);
        while(loop) {
            try {
                System.out.println("*************************************");
                System.out.println("Admin - Select a Movie");
                System.out.println("*************************************");
                for (index=0; index<movies.size(); index++){
                    movie = movies.get(index);
                    System.out.printf("%d%s",(index+1),(") " +movie.getTitle() + "\n"));
                }
                System.out.println((index+1) + ") Go back");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                if (sc.hasNextLine())
                    sc.nextLine();
                if (choice==0 || choice>(movies.size()+1)){
                    System.out.println("Please enter a number between 1 to " + (movies.size() + 1) + ".");
                } else if (choice==(movies.size()+1)) {
                    return null;//Return null if Staff choose to go back.
                } else if (choice>0 || choice<=(movies.size())){
                    index=choice-1;
                    break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Please enter a number between 1 to " + (movies.size() + 1) + ".");
                sc.next();
            }
        }
        return movies.get(index);
    }

    private Cineplex chooseCineplex(){
        boolean loop = true;
        int choice; int index=0;//Format Print Indexes
        ArrayList<Cineplex> cineplexes = Cineplex.getAllCineplexesData();
        Cineplex cineplex = null;
        Scanner sc = new Scanner(System.in);
        while(loop) {
            try {
                System.out.println("*************************************");
                System.out.println("Admin - Select a Cineplex");
                System.out.println("*************************************");
                for (index=0; index<cineplexes.size(); index++){
                    cineplex = cineplexes.get(index);
                    System.out.printf("%d%s",(cineplex.getId()+1),(") " +cineplex.getLocation() + "\n"));
                }
                System.out.println((index+1) + ") Go back");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                if (sc.hasNextLine())
                    sc.nextLine();
                if (choice==0 || choice>(cineplexes.size()+1)){
                    System.out.println("Please enter a number between 1 to " + (cineplexes.size() + 1) + ".");
                } else if (choice==(cineplexes.size()+1)) {
                    return null;//Return null if Staff choose to go back.
                } else if (choice>0 || choice<=(cineplexes.size())){
                    index=choice-1;
                    break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Please enter a number between 1 to " + (cineplexes.size() + 1) + ".");
                sc.next();
            }
        }
        return cineplexes.get(index);
    }

    private Cinema chooseCinema(Cineplex cineplex){
        boolean loop = true;
        int choice; int index=0;//Format Print Indexes
        ArrayList<Cinema> cinemas = Cinema.getAllCinemasData();
        Cinema cinema = null;

        int i=0;
        while( i<cinemas.size()){
            cinema = cinemas.get(i);
            if (cinema.getCineplexId()!=cineplex.getId()){
                cinemas.remove(cinema);
            }
            else{
                i++;
            }
        }

        Scanner sc = new Scanner(System.in);

        while(loop) {
            try {
                System.out.println("*************************************");
                System.out.println("Admin - Select a Cinema");
                System.out.println("*************************************");
                for (index=0; index<cinemas.size(); index++){
                    cinema = cinemas.get(index);
                    System.out.printf("%d%s",(cinema.getId()+1),(") " + cinema.getCinemaClass() + "\n"));
                }
                System.out.println((index+1) + ") Go back");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                if (sc.hasNextLine())
                    sc.nextLine();
                if (choice==0 || choice>(cinemas.size()+1)){
                    System.out.println("Please enter a number between 1 to " + (cinemas.size() + 1) + ".");
                } else if (choice==(cinemas.size()+1)) {
                    return null;//Return null if Staff choose to go back.
                } else if (choice>0 || choice<=(cinemas.size())){
                    index=choice-1;
                    break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Please enter a number between 1 to " + (cinemas.size() + 1) + ".");
                sc.next();
            }
        }
        return cinemas.get(index);
    }
}

