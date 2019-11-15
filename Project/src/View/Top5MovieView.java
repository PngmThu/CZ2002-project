package View;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Controllers.Top5MovieCtrl;
import Entities.Movie;

public class Top5MovieView extends MoblimaViews {
	
	public static void main(String[] args) {
        MoblimaViews menuViews = new Top5MovieView();
        menuViews.enterView();
    }
	
	public void enterView(){
        int choice;
        boolean loop = true;
        ArrayList<Movie> movies;

        while (loop) {
            //Print Menu to list top 5 movies by ticket sales OR by overall reviewers� ratings
        	System.out.println("*********************************************");
        	System.out.println("List top 5 movies BY: ");
            System.out.println("1) Ticket sales");
            System.out.println("2) Overall reviewers' ratings");
            System.out.println("3) Return to main menu");
            System.out.println("");
            System.out.print("Enter your choice: ");

            choice = readInt(1);
		    if (choice == -1) 
		    	continue;
		    
            switch (choice) {
                case 1:
                	Top5MovieCtrl.displayBySales();
                	break;
                case 2:
                	Top5MovieCtrl.displayByRatings();
                	break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Please enter a choice between 1 to 3.");
                    System.out.println("");
		            break;
            }
        }
    }
}
