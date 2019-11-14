package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MoblimaViews{
	Scanner sc = new Scanner(System.in);
    public void enterView() {
    }
    
    public int readInt(Boolean Loop) {
    	
        
        do {
        	try {
                int input = sc.nextInt();    
                return input;
            } catch (InputMismatchException e) {
            	sc.nextLine(); // Cleaning Scanner
                System.out.println("Invalid Input! Please enter a Number" + (Loop ? ":" : "."));
            }
        }while(Loop);

        return -1;
    }
}
