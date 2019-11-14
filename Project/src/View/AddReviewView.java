package View;
import Controllers.AddReviewCtrl;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Controllers.AddReviewCtrl;
import Entities.Movie;
public class AddReviewView extends MoblimaViews{
	private String movieTitle; 
	 
	public static void main(String args[]) {//test
		MoblimaViews menuViews;
		menuViews = new AddReviewView("Big Hero 6");
		menuViews.enterView();
	}
	
	public AddReviewView(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public void enterView() {
		String content;
		String reviewer;
		int rating;
		
		boolean loop = true;
		String temp;
		
		Scanner sc = new Scanner(System.in);
		
		while (loop) {
			System.out.print("Enter your name: ");
			reviewer = sc.nextLine();
			
			System.out.print("Enter your review: ");
			content = sc.nextLine();
			try {
				System.out.print("Enter rating (0 - 5): ");
				rating=sc.nextInt();
				if (rating < 0 || rating > 5) {
					System.out.println("Invalid rating! Please enter an integer from 0 to 5! Try again.");
					System.out.println("");
					sc.nextLine();
					continue;
				}
			} catch (InputMismatchException e) {
			    System.out.println("Invalid rating! Please enter an integer from 0 to 5! Try again.");
			    System.out.println("");
			    sc.nextLine();
			    continue;
		    }
			
			System.out.print("Submit? (y/n) : ");
			sc.nextLine();
			temp = sc.nextLine();
			
			if (temp.equalsIgnoreCase("y")) {
				//Add review
				AddReviewCtrl.addNewReview(this.movieTitle, reviewer, content, rating);
				System.out.println("-->> REVIEW IS ADDED <<--");
			} 
			
			loop = false;
			System.out.println("");
		 }
	}
}