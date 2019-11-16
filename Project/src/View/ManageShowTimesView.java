package View;

import Entities.Cinema;
import Entities.Cineplex;
import Entities.Movie;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

/*

 @param
 @return
 */

public class ManageShowTimesView extends MoblimaViews {

    public static void main(String[] args){
        ManageShowTimesView view = new ManageShowTimesView();
        view.enterView();
    }
    @Override
    public void enterView(){
        int choice;
        boolean loop = true;
        Cineplex cineplex = null; Movie movie=null; Cinema cinema = null;
        //Page used by Admin to make changes to Movie Listing
        while (loop) {
            /*********************Display Menu**************************/
            int num = 13;
            System.out.println("\n>>>>>>>>>>\n");
            String str = " " + "_".repeat(num) + " Staff - MANAGE MOVIE SHOWTIMES " + "_".repeat(num);
            System.out.println(str);
            //System.out.println("str.length() - 3: " + (str.length() - 3));
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "1) Create a showtime");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "2) Update a showtime");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "3) Delete a showtime");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "4) Back to Main Menu");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n","");

            System.out.println("* ".repeat(str.length() / 2 + 1));
            System.out.println("");
            /***********************************************************/
            System.out.print("Enter your choice: ");
            choice = readInt(1);
            if (choice == -1) continue;
            else if (choice <=0 || choice>4){
                System.out.println("Please enter a number between 1 to 4.");
                continue;
            }
            else if (choice == 4){
                return;
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
                    menuView = new CreateShowTimeView(movie,cineplex,cinema);
                    break;
                case 2:
                    //Update Showtime
                    menuView = new UpdateShowTimeView(movie,cineplex,cinema);
                    break;
                case 3:
                    //Delete Showtime;
                    menuView = new DeleteShowTimeView(movie,cineplex,cinema);
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("Please enter a choice between 1 to 4.");
            }
            if (loop && menuView!=null)
                menuView.enterView();
        }
    }

    private Movie chooseMovie(){
        boolean loop = true;
        int choice; int index=0;//Format Print Indexes
        ArrayList<Movie> movies = Movie.getAllMoviesData();
        Movie movie = null;
        while(loop) {
            System.out.println("*************************************");
            System.out.println("Admin - Select a Movie");
            System.out.println("*************************************");
            for (index=0; index<movies.size(); index++){
                movie = movies.get(index);
                System.out.printf("%d%s",(index+1),(") " +movie.getTitle() + "\n"));
            }
            System.out.println((index+1) + ") Go back");
            System.out.print("Enter your choice: ");
            choice = readInt(1);
            if (choice==-1) continue;
            if (choice<=0 || choice>(movies.size()+1)){
                System.out.println("Please enter a number between 1 to " + (movies.size() + 1) + ".");
                continue;
            } else if (choice==(movies.size()+1)) {
                return null;//Return null if Staff choose to go back.
            } else if (choice>0 || choice<=(movies.size())){
                index=choice-1;
                break;
            }
        }
        return movies.get(index);
    }

    private Cineplex chooseCineplex(){
        boolean loop = true;
        int choice; int index=0;//Format Print Indexes
        ArrayList<Cineplex> cineplexes = Cineplex.getAllCineplexesData();
        Cineplex cineplex = null;
        while(loop) {
            System.out.println("*************************************");
            System.out.println("Admin - Select a Cineplex");
            System.out.println("*************************************");
            for (index=0; index<cineplexes.size(); index++){
                cineplex = cineplexes.get(index);
                System.out.printf("%d%s",(cineplex.getId()+1),(") " +cineplex.getLocation() + "\n"));
            }
            System.out.println((index+1) + ") Go back\n");
            System.out.print("Enter your choice: ");
            choice = readInt(1);

            if (choice == -1) continue;
            if (choice<=0 || choice>(cineplexes.size()+1)){
                System.out.println("Please enter a number between 1 to " + (cineplexes.size() + 1) + ".");
                continue;
            } else if (choice==(cineplexes.size()+1)) {
                return null;//Return null if Staff choose to go back.
            } else if (choice>0 || choice<=(cineplexes.size())){
                index=choice-1;
                break;
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
        while(loop) {
                System.out.println("*************************************");
                System.out.println("Admin - Select a Cinema");
                System.out.println("*************************************");
                for (index=0; index<cinemas.size(); index++){
                    cinema = cinemas.get(index);
                    System.out.printf("%d%s",(cinema.getId()+1),(") " + cinema.getCinemaClass() + "\n"));
                }
                System.out.println((index+1) + ") Go back\n");
                System.out.print("Enter your choice: ");
                choice = readInt(1);

                if (choice == -1)  continue;

                else if (choice<=0 || choice>(cinemas.size()+1)){
                    System.out.println("Please enter a number between 1 to " + (cinemas.size() + 1) + ".");
                    continue;
                } else if (choice==(cinemas.size()+1)) {
                    return null;//Return null if Staff choose to go back.
                } else if (choice>0 || choice<=(cinemas.size())){
                    index=choice-1;
                    break;
                }
        }
        return cinemas.get(index);
    }
}

