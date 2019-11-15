package Controllers;

import View.*;

public class StaffMenuCtrl {
    public static void changeView(int choice) {
        MoblimaViews menuViews = null;
        if (choice==1){
            menuViews = new ManageMovieListingView();
        }
        else if(choice == 2){
            menuViews = new ManageShowTimesView();
        }
        else if(choice == 3){
            menuViews = new ManageSystemSettingsView();
        } else{
            menuViews = new Top5MovieView();
        }

        menuViews.enterView();
    }
}
