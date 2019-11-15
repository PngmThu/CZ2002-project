package View;

import Controllers.MovieDetailsCtrl;
import Entities.Movie;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Controllers.MovieDetailsCtrl;
import Entities.Movie;

public class MovieDetailsView extends MoblimaViews{

    public static void main(String[] args){
    	
        MoblimaViews menuViews;
        menuViews = new MovieDetailsView();
        menuViews.enterView();
    }

    
    public void enterView(){
		 int choice;
		 boolean loop;
		 String movieTitle = null;

		 
		 loop = false;
		 while (!loop) {
			 System.out.print("Enter a movie to view details: ");
			 movieTitle = sc.nextLine();
			 
			 loop = MovieDetailsCtrl.displayMovieDetails(movieTitle);
			 
			 if (!loop) {
				 System.out.println("~~~ No such movie! Try again! ~~~");
			 }
			 System.out.println("");
		 }
		 
		 loop = true;
		 while (loop) {
			 menuView = null;
			 
			 System.out.println(">>>>>>>>");
			 System.out.println("1) Display reviews for " + movieTitle);
			 System.out.println("2) Buy tickets for " + movieTitle);
			 System.out.println("3) Return to List-Movies page");
			 System.out.print("Enter your choice: ");

			 choice = readInt(1);
		     if (choice == -1) 
		    	 continue;
		     
		     switch (choice) {
		         case 1:
		             ///Display reviews: go to MovieReviewListView
		        	 menuView = new MovieReviewListView(movieTitle);
		             break;
		         case 2:
		             ///Buy tickets: go to BookingView
		        	 menuView = new BookingView();
		             break;
		         case 3:
		             loop = false;
		             break;
		         default:
		             System.out.println("Please enter a choice between 1 to 3.");
		             System.out.println("");
		             break;
		     }

		     if (loop && menuView!=null)
		         menuView.enterView();
		 }
		 
    }
}
