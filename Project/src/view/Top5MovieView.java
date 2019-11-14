package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Controllers.StaffMenuCtrl;
import Controllers.Top5MovieCtrl;
import Entities.Movie;

public class Top5MovieView extends MoblimaViews {
	
	public static void main(String[] args) {
        MoblimaViews menuViews = new Top5MovieView();
        menuViews.enterView();
    }
	
	public void enterView(){
        MoblimaViews menuViews = null;
        int choice;
        boolean loop = true;
        ArrayList<Movie> movies;

        Scanner sc = new Scanner(System.in);
        while (loop) {
            //Print Menu to list top 5 movies by ticket sales OR by overall reviewers� ratings
        	System.out.println("*********************************************");
        	System.out.println("List the top 5 movies BY: ");
            System.out.println("1) Ticket sales");
            System.out.println("2) Overall reviewers� ratings");
            System.out.println("Enter 3 to EXIT");
            System.out.println("");
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
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
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please select a number between 1 to 3!");
                sc.next();
            }
        }
    }
}
