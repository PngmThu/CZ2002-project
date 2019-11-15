package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageSystemSettingsView extends MoblimaViews{

    public static void main(String[]args){
        ManageSystemSettingsView menuView = new ManageSystemSettingsView();
        menuView.enterView();
    }

    @Override
    public void enterView(){
        int choice;
        boolean loop = true;
        //Page used by Admin to make changes to Ticket Prices and Public Holidays
        while (loop) {
            /*********************Display Menu**************************/
            System.out.println(">>>>>>>>>>\n");

            int num = 13;
            String str = " " + "_".repeat(num) + " Staff - CONFIGURE SYSTEM SETTINGS " + "_".repeat(num);
            System.out.println(str);
            //System.out.println("str.length() - 3: " + (str.length() - 3));
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "1) Update ticket prices");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "2) Update public holidays");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "3) Back to Main Menu");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n","");

            System.out.println("* ".repeat(str.length() / 2 + 1));
            System.out.println("");
            /***********************************************************/

            System.out.print("Enter your choice: ");
            choice = readInt(1);
            if (choice == -1) continue;
            switch (choice) {
                case 1:
                    menuView = new UpdateTicketPricesView();
                    break;
                case 2:
                    menuView = new UpdatePublicHolidaysView();
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Please enter a choice between 1 to 3.");
            }
            if (loop && menuView!=null)
                menuView.enterView();
        }
    }
}
