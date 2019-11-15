package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MoblimaViews{
	Scanner sc = new Scanner(System.in);
    MoblimaViews menuView = null;
    public abstract void enterView();
    
    public int readInt(int loop) {
        do {
        	loop--;
        	try {
                int input = sc.nextInt();
                sc.nextLine();
                return input;
            } catch (InputMismatchException e) {
            	sc.nextLine(); // Cleaning Scanner
                if(loop == 0) {
                	System.out.println("Invalid Input! Please enter a Number.");
                	System.out.println("Returning back to the Menu.\n");
                }else {
                	System.out.println("Invalid Input! Please enter a Number.\t" + loop + " tries left.");
                }
            }   	
        }while(loop != 0);

        return -1;
    }
}


