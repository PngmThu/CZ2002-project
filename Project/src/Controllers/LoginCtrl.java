package Controllers;
import java.util.Scanner;
import Entities.Staff;

public class LoginCtrl {
    public static boolean verifyLogin() {
        Scanner sc = new Scanner(System.in);
        String username, password;
        System.out.print("Enter Username: ");
        username = sc.nextLine();
        System.out.print("Enter Password: ");
        password = sc.nextLine();
        Staff user = new Staff(username,password);
        for (Staff staff : Staff.getAllStaffsData()){
            if (staff.getUsername().equals(user.getUsername())){
                if (staff.getHashedPassword().equals(user.getHashedPassword())) {
                    System.out.println("Login Successfully.");
                    return true;
                }
                System.out.println("Invalid Password, please try again.");
                return false;
            }
        }
        System.out.println("Invalid Username, please try again");
        return false;
    }
}
