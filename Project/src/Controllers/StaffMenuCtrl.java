package Controllers;

import view.ManageShowTimesView;
import view.ManageSystemSettingsView;
import view.MoblimaViews;
import view.manageMovieListingView;

public class StaffMenuCtrl {
    public static void changeView(int choice) {
        MoblimaViews menuViews = null;
        if (choice==1){
            menuViews = new manageMovieListingView();
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
