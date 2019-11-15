package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controllers.MovieListingCtrl;

public class MovieListingView extends MoblimaViews {
	public static void main(String[] args) {
        MoblimaViews menuViews = new MovieListingView();
        menuViews.enterView();
    }
	@Override
	public void enterView() {
        MoblimaViews menuViews = null;
        int choice;
        boolean loop = true;
		
		while (loop) {
			 menuViews = null;
			
			 MovieListingCtrl.displayMovieListing();
			 System.out.println(">>>>>>>>>>\n");
			 
			 /*********************Display Menu**************************/
			 int num = 13;
			 String str = " " + "_".repeat(num) + " MovieGoer - MOVIE LISTING " + "_".repeat(num);
			 System.out.println(str);
			 //System.out.println("str.length() - 3: " + (str.length() - 3));

			 System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "");
			 System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "1) View details of a movie");
			 System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "2) Return to main menu");
			 System.out.printf("*  %-" + (str.length() - 3) + "s*\n","");
			 
			 System.out.println("* ".repeat(str.length() / 2 + 1));
			 System.out.println("");
			 /***********************************************************/
			 
			 System.out.print("Enter your choice: ");
		     choice = readInt(1);
		     if (choice == -1) 
		    	 continue;
		     
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
		             break;
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

//* * * * * * * * * * Menu ************************
//*                                                   *
//*                                                   *
//*                                                   *
//*                                                   *
//*                                                   *

