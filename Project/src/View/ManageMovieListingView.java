package View;

import Entities.Movie;

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
            System.out.println("*************************************");
            System.out.println("Admin - Manage Movie Listing");
            System.out.println("*************************************");
            System.out.println("1) Create");
            System.out.println("2) Update");
            System.out.println("3) Remove");
            System.out.println("4) Go back\n");
            System.out.print("Enter your choice: ");
            choice = readInt(false);
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
        System.out.println("*************************************");
        System.out.println("Movie title: " + movie.getTitle());
        System.out.println("Status: " + movie.getStatus().getDescription());
        System.out.println("Movie type: " + movie.getMovieType().getDescription());
        System.out.println("Synopsis: " + movie.getSynopsis());
        System.out.println("Director(s): " + movie.getDirector());
        System.out.println("Cast(s): " + movie.getCast());
        System.out.println("*************************************");
;    }
}

