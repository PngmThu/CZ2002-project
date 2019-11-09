package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MoblimaApp {
	public static void main(String[] args) {
		MoblimaViews menuViews = null;
		int choice;
		boolean loop = true;
		System.out.println("Welcome to Moblima!");
		Scanner sc = new Scanner(System.in);
		while (loop) {
			System.out.println("1) MovieGoer");
			System.out.println("2) Staff");
			System.out.println("3) Exit");

			//PRINT MENU FOR HOMEPAGE USED BY BOTH MOVIE-GOERS & STAFF
			try {
				choice = sc.nextInt();
				switch (choice) {
					case 1:
						//bring user to SearchMovieView
						menuViews = new SearchMovieView();
						break;
					case 2:
						//bring user to MovieListingView
						menuViews = new MovieListingView();
						break;
					case 3:
						loop = false;
						break;
					default:
						System.out.println("Please enter a choice between 1 to 5.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid choice! Please select a number between 1 to 5:");
				sc.next();
			}
			menuViews.enterView();
		}
	}

}
