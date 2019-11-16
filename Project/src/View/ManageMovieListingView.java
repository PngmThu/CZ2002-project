package View;

import Entities.Movie;

import java.util.ArrayList;

import static Controllers.MovieDetailsCtrl.addLinebreaks;

public class ManageMovieListingView extends MoblimaViews {

    public static void main(String[] args) {
        MoblimaViews menuViews = new ManageMovieListingView();
        menuViews.enterView();
    }
    @Override
    public void enterView() {
        int choice;
        boolean loop = true;
        //Page used by Admin to make changes to Movie Listing
        while (loop) {
            /*********************Display Menu**************************/
            System.out.println("\n>>>>>>>>>>\n");
            int num = 13;
            String str = " " + "_".repeat(num) + " Staff - MANAGE MOVIE LISTING " + "_".repeat(num);
            System.out.println(str);
            //System.out.println("str.length() - 3: " + (str.length() - 3));
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "1) Create a movie");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "2) Update a movie");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "3) Delete a movie");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "4) Back to Main Menu");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n","");

            System.out.println("* ".repeat(str.length() / 2 + 1));
            System.out.println("");
            /***********************************************************/
            System.out.print("Enter your choice: ");
            choice = readInt(1);
            if (choice == -1) continue;
            switch (choice) {
                case 1:
                    //Create Movie
                    menuView = new CreateMovieView();
                    break;
                case 2:
                    //Update Movie
                    menuView = new UpdateMovieView();
                    break;
                case 3:
                    //Delete Movie;
                    menuView = new DeleteMovieView();
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("Please enter a choice between 1 to 4.");
            }
            if (loop && menuView!=null)
                menuView.enterView();
        }
    }

    protected void displayMovie(Movie movie){
        System.out.println(">>>>>>>>>>\n");

        /********************************Display Information***********************************/

        //Chang num to increase the length of the box
        int num = 45;
        String movieName = movie.getTitle() + " " + movie.getCensorship() + " (" + movie.getMovieType().getDescription() + ")";
        num = (105 - movieName.length()) / 2 + 1;

        String str = "=".repeat(num) + " " + movieName + " " + "=".repeat(num);

        //System.out.println("str.length(): " + (str.length()));

        //Top horizontal border
        System.out.println("* ".repeat(str.length() / 2 + 4));

        //Movie Name
        System.out.printf("*  %-" + (str.length() + 2) + "s*\n",str);

        //Movie Information
        System.out.printf("*  %-" + (str.length() + 2) + "s*\n","\u2022 Status: " + movie.getStatus().getDescription());
        System.out.printf("*  %-" + (str.length() + 2) + "s*\n","\u2022 Director: " + movie.getDirector());
        System.out.printf("*  %-" + (str.length() + 2) + "s*\n","\u2022 Cast: " + movie.getCast());

        System.out.printf("*  %-" + (str.length() + 2) + "s*\n","\u2022 Synopsis: ");
        ArrayList<String> strList = addLinebreaks(movie.getSynopsis(), 100);
        for (String string : strList) {
            System.out.printf("*  %-" + (str.length() + 2) + "s*\n","    " + string);
        }

        if (movie.getMovieReviews().size() > 1) {
            System.out.printf("*  %-" + (str.length() + 2) + "s*\n","\u2022 Overall Rating: " + String.format("%.1f", movie.getAvgRating()));
        } else {
            System.out.printf("*  %-" + (str.length() + 2) + "s*\n","\u2022 Overall Rating: NA");
        }

        //Bottom horizontal border
        System.out.printf("*  %-" + (str.length() + 2) + "s*\n","");
        System.out.println("* ".repeat(str.length() / 2 + 4));

        /*****************************************************************************************/
;    }
}

