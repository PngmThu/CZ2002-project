package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenuView {
	public static void MainMenuViewDisplay(){
	//Home Page - Land here when app launch
		int choice;

		while(true) {
		//PRINT MENU FOR HOMEPAGE USED BY BOTH MOVIE-GOERS & STAFF
		System.out.println("1) Search for a Movie");
		System.out.println("2) List Movies");
		System.out.println("3) View Booking History");
		System.out.println("4) Staff Login");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your choice: ");  //USER'S CHOICE
		choice = sc.nextInt();

		
		switch(choice){
		case 1:
			//bring user to SearchMovieView
			break; 
		case 2: 
			//bring user to MovieListingView
			break;
		case 3:
			//bring user to BookingHistoryView
			break;
		case 4:
			//bring user to LoginView
			break;
		default:
			System.out.println("Please enter a choice between 1 to 4.");
			break;
			}
		}
	}
}
