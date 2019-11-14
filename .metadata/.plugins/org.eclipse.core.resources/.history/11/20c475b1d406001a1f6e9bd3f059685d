package view;

import Controllers.MovieDetailsCtrl;
import Entities.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieDetailsView extends MoblimaViews{
    private String movieTitle;

//    public static void main(String[] args){
//        MoblimaViews menuViews;
//        menuViews = new MovieDetailView("Frozen 2");
//        menuViews.enterView();
//    }

    public MovieDetailsView(String movieTitle){
        this.movieTitle = movieTitle;
    }

    //public static void main(String [] args){
    public void enterView(){
        //pass movieTitle
        MovieDetailsCtrl.displayMovieDetail(movieTitle);
        displayMovieDetailMenu();
    }

    private void displayMovieDetailMenu() {
        int choice;
        ArrayList<Movie> movies = Movie.getAllMoviesData();
        Scanner sc = new Scanner(System.in);
        Movie movie = null;
        for (int i = 0; i < movies.size(); i++) {
            movie = movies.get(i);
            if(movie.getTitle().equals(this.movieTitle)){
                break;
            }
        }
        if (movie.getStatus().equals("Upcoming")) {
            System.out.println("1) Return to Search/List Movies page. ");
            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Invalid choice!");
            }
            choice = sc.nextInt();
            // ADD CODE TO MOVE USER TO SEARCH/LIST MOVIES PAGE
        } else {
            System.out.println("1) Return to Search/List Movies page. ");
            System.out.println("2) Review/Rate the movie.");
            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Invalid choice!");
            }
            choice = sc.nextInt();
            if(choice == 1){
                // ADD CODE TO MOVE USER TO SEARCH/LIST MOVIES PAGE
            }else{
                // ADD CODE TO MOVE USER TO REVIEW/RATE PAGE
            }

        }
    }


}
