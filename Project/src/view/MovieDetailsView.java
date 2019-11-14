package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Controllers.MovieDetailsCtrl;
import Entities.Movie;

public class MovieDetailsView extends MoblimaViews{
    private String movieTitle;

    public static void main(String[] args){
    	
        MoblimaViews menuViews;
        menuViews = new MovieDetailsView();
        menuViews.enterView();
    }

//    public MovieDetailsView(String movieTitle){
//        this.movieTitle = movieTitle;
//    }

    //public static void main(String [] args){
    public void enterView(){
        //pass movieTitle
//        MovieDetailsCtrl.displayMovieDetail(movieTitle);
//        displayMovieDetailMenu();
    	
		 MoblimaViews menuViews = null;
		 int choice;
		 boolean loop = true;
		 String movieTitle;
		
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("Enter a movie to view details: ");
		 movieTitle = sc.nextLine();
		 
		 MovieDetailsCtrl.displayMovieDetails(movieTitle);
		 
		 while (loop) {
			 System.out.println(">>>>>>>>");
			 System.out.println("1) Display reviews");
			 System.out.println("2) Add your review");
			 System.out.println("3) Return to List-Movies page");
			 System.out.print("Enter your choice: ");
			 try {
			     choice = sc.nextInt();
			     switch (choice) {
			         case 1:
			             ///Show movie details
			        	 
			        	 //menuViews go to MovieReview
			             break;
			         case 2:
			             ///Show movie details
			        	 
			        	 //menuViews go to MovieReview
			             break;
			         case 3:
			             loop = false;
			             break;
			         default:
			             System.out.println("Please enter a choice between 1 to 3.");
			     }
			 } catch (InputMismatchException e) {
			     System.out.println("Invalid choice! Please select a number between 1 to 3:");
			     sc.next();
		     }
		     if (loop && menuViews!=null)
		         menuViews.enterView();
		 }
		 
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
