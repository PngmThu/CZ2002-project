package View;


import Controllers.LoginCtrl;

import java.util.Base64;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginView extends MoblimaViews {
    //Staff have to login to use all the different admin functions
    //Use LoginCtrl to verify staff login
	
	public static void main(String[] args) {
        MoblimaViews menuViews = new LoginView();
        menuViews.enterView();
    }
	
    public void enterView(){
        MoblimaViews menuViews = null;
        int choice;
        boolean loop = true;

        Scanner sc = new Scanner(System.in);
        while (loop) {
            //Print Menu For Login View
        	boolean loginVerification = false;
        	menuViews = null;
            System.out.println("*************************************");
            System.out.println("Admin - Staff Menu");
            System.out.println("*************************************");
            System.out.println("1) Login");
            System.out.println("2) Go Back");
            System.out.print("Enter your choice: ");
            choice = readInt(1);
            if (choice==-1) continue;
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
                    break;
            }
            if (loop && menuViews!=null)
                menuViews.enterView();
        }
    }

}
