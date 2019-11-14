package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controllers.MovieListingCtrl;

public class MovieListingView extends MoblimaViews {
	public static void main(String[] args) {
        MoblimaViews menuViews = new MovieListingView();
        menuViews.enterView();
    }
	
	public void enterView() {
        MoblimaViews menuViews = null;
        int choice;
        boolean loop = true;

        Scanner sc = new Scanner(System.in);
		
		while (loop) {
			 MovieListingCtrl.displayMovieListing();
			 System.out.println(">>>>>>>>");
			 System.out.println("1) View details of a movie");
			 System.out.println("2) Return to main menu");
			 System.out.print("Enter your choice: ");
			 try {
			     choice = sc.nextInt();
			     switch (choice) {
			         case 1:
			             ///View movie details
			        	 menuViews = new MovieDetailsView();
			             break;
			         case 2:
			             loop = false;
			             break;
			         default:
			             System.out.println("Please enter a choice between 1 to 2.");
			             sc.nextLine();
			             break;
			     }
			 } catch (InputMismatchException e) {
			     System.out.println("Invalid choice! Please select a number between 1 to 2.");
			     sc.nextLine();
		     }
		     if (loop && menuViews!=null)
		         menuViews.enterView();
		 }
    }
}
//All controllers should have switchview? Switch view will display a menu to see if user would want to change to different views.
//Movie listing controller should have switch view? (Parameters to pass in: user's choice.
//


//Display a list of all the movies available in Moblima to Moviegoers, using MovieListingViewCtrl.
//Movies Attributes I Need:
//Title, Censorship, ReasonForCensor, ScreenTime, Language

//Format of Display

// ============== NOW SHOWING ================
// ___________________________________________
//
// 1. Hello World
// -------------------------------------------
//  PG13 - Horror and Some Coarse  Langauge
//  90 mins
//  English
// ___________________________________________
//
// 2. Disney's Maleficent: Mistress of Evil
// -------------------------------------------
//  PG - Some Intense Sequences
//  119 mins
//  English
// ___________________________________________
//
// 3. The Shining
// -------------------------------------------
// M18 - Nudity
// 144 mins
// English
// ___________________________________________
//
// =============== PREVIEWS ==================
// ___________________________________________
//
// 4. Star Wars: The Rise of Skywalker
// -------------------------------------------
// PG
// 120 mins
// English
// ___________________________________________
//
// ============== COMING SOON ================
// ___________________________________________
//
// 5. Last Christmas
// -------------------------------------------
// TBA - To be announced
// 120 mins
// English
// ___________________________________________
//
//

