package view;

import Entities.Cineplex;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageShowTimesView extends MoblimaViews {
    public void enterView(){
        int choice;
        boolean loop = true;
        //Page used by Admin to make changes to Movie Listing
        Scanner sc = new Scanner(System.in);
        while (loop) {
            System.out.println("*************************************");
            System.out.println("Admin - Manage Movie Showtimes");
            System.out.println("*************************************");
            System.out.println("1) Create");
            System.out.println("2) Update");
            System.out.println("3) Remove");
            System.out.println("4) Go back");
            System.out.print("Enter your choice: ");
            //PRINT MENU FOR HOMEPAGE USED BY BOTH MOVIE-GOERS
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        //Create Movie
                        createShowtime();
                        break;
                    case 2:
                        //Update Movie
                        updateShowtime();
                        break;
                    case 3:
                        //Delete Movie;
                        deleteShowtime();
                        break;
                    case 4:
                        loop = false;
                        break;
                    default:
                        System.out.println("Please enter a choice between 1 to 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please select a number between 1 to 4:");
                sc.next();
            }
        }
    }
    private void chooseCineplex(ArrayList<Cineplex> cineplexes){
        Cineplex cineplex = null;
        for (int i=0; i<cineplexes.size(); i++){
            cineplex = cineplexes.get(i);
            System.out.println("%d)");
        }
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        try {
            switch (choice) {
                case 1:

                    break;
                case 2:
                    //Update Movie
                    updateShowtime();
                    break;
                case 3:
                    //Delete Movie;
                    deleteShowtime();
                    break;
                case 4:
                    //loop = false;
                    break;
                default:
                    System.out.println("Please enter a choice between 1 to 4.");
            }
        }catch (InputMismatchException e) {
        System.out.println("Invalid choice! Please select a number between 1 to 4:");
        sc.next();
        }
    }

    private void createShowtime (){

    }

    private void updateShowtime (){

    }

    private void deleteShowtime (){

    }
}
