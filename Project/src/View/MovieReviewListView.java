package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controllers.MovieDetailsCtrl;
import Controllers.MovieReviewListCtrl;
import Entities.Movie;
import Entities.MovieReview;
import java.util.*;

public class MovieReviewListView extends MoblimaViews{
	private String movieTitle;
	
	public static void main(String[] args){
		
        MoblimaViews menuViews;
        menuViews = new MovieReviewListView("Big Hero 6");
        menuViews.enterView();
    }
	
	public MovieReviewListView(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	@Override
    public void enterView(){
		 int choice;
		 boolean loop = true;
		 MovieReviewListCtrl.displayMovieReviews(this.movieTitle);
		 
		 while (loop) {
			 System.out.println(">>>>>>>>");
			 System.out.println("1) Add review for " + this.movieTitle);
			 System.out.println("2) Return to Movie-Details page");
			 System.out.print("Enter your choice: ");

			 choice = readInt(1);
		     if (choice == -1) 
		    	 continue;
		     
		     switch (choice) {
		         case 1:
		             ///Add review
		        	 menuView = new AddReviewView(this.movieTitle);
		             break;
		         case 2:
		             loop = false;
		             break;
		         default:
		             System.out.println("Please enter a choice between 1 to 2.");
		             System.out.println("");
		             break;
		     }
		     if (loop && menuView!=null)
		         menuView.enterView();
		 }
		 
    }
}
