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
            /*********************Display Menu**************************/
            System.out.println("\n>>>>>>>>>>\n");

            int num = 18;
            String str = " " + "_".repeat(num) + " Staff - HOME MENU " + "_".repeat(num);
            System.out.println(str);
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "1) Create/Update/Remove Movie Listing");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "2) Create/Update/Remove Showtimes");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "3) Configure System Settings");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "4) View Top 5 Movies by Sales and Ratings");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "5) Logout");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n","");

            System.out.println("* ".repeat(str.length() / 2 + 1));
            System.out.println("");
            /***********************************************************/

            System.out.print("Enter your choice: ");
            choice = readInt(1);
            if (choice == -1) continue;
            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                    StaffMenuCtrl.changeView(choice);
                    break;
                case 5:
                    loop = false;
                    break;
                default:
                    System.out.println("Please enter a choice between 1 to 5.");
            }
        }
    }


}
