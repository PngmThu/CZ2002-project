package view;

import Controllers.LoginCtrl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginView extends MoblimaViews {
    //Staff have to login to use all the different admin functions
    //Use LoginCtrl to verify staff login
    public void enterView(){
        MoblimaViews menuViews = null;
        int choice;
        boolean loop = true, loginVerification = false;

        Scanner sc = new Scanner(System.in);
        while (loop) {
            //Print Menu For Login View
            System.out.println("1) Login");
            System.out.println("2) Go Back");
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        loginVerification = LoginCtrl.verifyLogin();
                        if (loginVerification)
                            menuViews = new StaffMenuView();
                        break;
                    case 2:
                        loop = false;
                        break;
                    default:
                        System.out.println("Please enter a choice between 1 to 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please select a number between 1 to 2:");
                sc.next();
            }
            if (loop && menuViews!=null)
                menuViews.enterView();
        }
    }

}
