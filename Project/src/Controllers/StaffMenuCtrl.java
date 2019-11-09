package Controllers;

import view.MoblimaViews;
import view.manageMovieListingView;
import view.manageMovieShowTimesView;
import view.manageSystemSettingsView;

public class StaffMenuCtrl {
    public static void changeView(int choice) {
        MoblimaViews menuViews = null;
        if (choice==1){
            menuViews = new manageMovieListingView();
        }
        else if(choice == 2){
            menuViews = new manageMovieShowTimesView();
        }
        else{
            menuViews = new manageSystemSettingsView();
        }

        menuViews.enterView();
    }
}
