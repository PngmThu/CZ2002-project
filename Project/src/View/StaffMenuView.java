package View;

import Controllers.StaffMenuCtrl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StaffMenuView extends MoblimaViews {
    public void enterView(){
        int choice;
        boolean loop = true, loginVerification = false;

        while (loop) {
            //Print Menu For Login View
            System.out.println("1) Create/Update/Remove Movie Listing");
            System.out.println("2) Create/Update/Remove Showtimes");
            System.out.println("3) Change System Settings");
            System.out.println("4) Exit");
            choice = readInt(1);
            if (choice == -1) continue;
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    StaffMenuCtrl.changeView(choice);
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("Please enter a choice between 1 to 4.");
            }
        }
    }


}
