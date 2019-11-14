package Controllers;

import View.ManageShowTimesView;
import View.ManageSystemSettingsView;
import View.MoblimaViews;
import View.ManageMovieListingView;

public class StaffMenuCtrl {
    public static void changeView(int choice) {
        MoblimaViews menuViews = null;
        if (choice==1){
            menuViews = new ManageMovieListingView();
        }
        else if(choice == 2){
            menuViews = new ManageShowTimesView();
        }
        else{
            menuViews = new ManageSystemSettingsView();
        }

        menuViews.enterView();
    }
}
