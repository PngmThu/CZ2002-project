package view;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieGoerView extends MoblimaViews {
    public void enterView(){
        int choice;
        boolean loop = true;
        MoblimaViews menuViews = null;

        Scanner sc = new Scanner(System.in);
        while (loop) {
            //PRINT MENU FOR HOMEPAGE USED BY BOTH MOVIE-GOERS
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        //bring user to SearchMovieView where they can view MovieListing
                        menuViews = new SearchMovieView();
                        break;
                    case 2:
                        //bring user to Top 5 By Sales/OverallRatingView
                        menuViews = new BookingHistoryView();
                        break;
                    case 3:
                        //bring user to Top 5 By Sales/OverallRatingView
                        menuViews = new BookingView();
                        break;
                    case 4:
                        loop = false;
                        break;
                    default:
                        System.out.println("Please enter a choice between 1 to 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please select a number between 1 to 4:");
                sc.next();
            }
            menuViews.enterView();
        }
    }
}
