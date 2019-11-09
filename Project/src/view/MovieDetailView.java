package view;

import Controllers.MovieDetailsCtrl;
import Controllers.MovieReviewCtrl;
import Entities.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieDetailView extends MoblimaViews{
    private String movieTitle;

    public void enterView(){
        //pass movieTitle
        MovieDetailsCtrl.displayMovieDetail(movieTitle);
    }

    public static void main(String [] args){
        int choice;
        ArrayList<Movie> movies = Movie.getAllMoviesData();
        Scanner sc = new Scanner(System.in);
        Movie movie = null;
        for(int i = 0 ; i < movies.size() ; i++) {
            movie = movies.get(i);
        }
        if(movie.getStatus().equals("Upcoming")){

        }

//        for(i = 0 ; i < movies.size() ; i++) {
//            Movie movie = movies.get(i);
//        }


        System.out.println("Please select your choice: ");
        System.out.println("1) Return to Search/List Movies page. ");
        System.out.println("2) Review/Rate the movie.");
        choice = sc.nextInt();
    }

}
