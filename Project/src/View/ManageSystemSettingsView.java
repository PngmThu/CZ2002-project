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
            System.out.println("*************************************");
            System.out.println("Admin - Configure System Settings");
            System.out.println("*************************************");
            System.out.println("1) Update Ticket Prices");
            System.out.println("2) Update Public Holidays");
            System.out.println("3) Go back\n");
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
