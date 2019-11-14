package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageSystemSettingsView extends MoblimaViews{
    public void enterView(){
        int choice;
        boolean loop = true;
        //Page used by Admin to make changes to Movie Listing
        Scanner sc = new Scanner(System.in);
        while (loop) {
            System.out.println("*************************************");
            System.out.println("Admin - Configure System Settings");
            System.out.println("*************************************");
            System.out.println("1) Update Ticket Prices");
            System.out.println("2) Update Public Holidays");
            System.out.println("3) Go back");
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        //Create Movie
                        updateTicketPrices();
                        break;
                    case 2:
                        //Update Movie
                        updatePublicHolidays();
                        break;
                    case 3:
                        loop = false;
                        break;
                    default:
                        System.out.println("Please enter a choice between 1 to 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please select a number between 1 to 3.");
                sc.next();
            }
        }
    }
    private void updateTicketPrices(){

    }

    private void updatePublicHolidays(){

    }
}
