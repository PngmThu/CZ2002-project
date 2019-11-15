package View;

import Entities.MovieType;
import Entities.TicketType;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static Controllers.UpdateTicketPricesCtrl.*;

public class UpdateTicketPricesView extends ManageSystemSettingsView{
    @Override
    public void enterView() {
        boolean loop = true;
        int movieTypeChoice, ticketTypeChoice, index;
        double price = 0;

        while(loop) {
            /*********************Display Menu**************************/
            System.out.println("\n>>>>>>>>>>\n");
            int num = 13;
            String str = " " + "_".repeat(num) + " Staff - SELECT A MOVIE TYPE " + "_".repeat(num);
            System.out.println(str);
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "");
            displayMovieTypesOptions(str);
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", (MovieType.values().length+1)+") Back to Main Menu");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n","");
            System.out.println("* ".repeat(str.length() / 2 + 1));
            System.out.println("");
            /***********************************************************/
            System.out.print("Enter your choice: ");
            movieTypeChoice = readInt(1);
            if (movieTypeChoice <= 0 || movieTypeChoice >MovieType.values().length+1) {
                System.out.println("Please enter a number between 1 to " + ( MovieType.values().length+1) + ".");
                continue;
            } else if (movieTypeChoice == (MovieType.values().length+1)) {
                return;
            } else {
                while (loop){
                    ArrayList<TicketType> filteredTicketTypes = filterTicketTypes(movieTypeChoice);
                    displayTicketTypes(filteredTicketTypes,movieTypeChoice);
                    System.out.print("Enter your choice: ");
                    ticketTypeChoice = readInt(1);
                    if (ticketTypeChoice == -1) continue;
                    else if (ticketTypeChoice <= 0 || ticketTypeChoice > filteredTicketTypes.size() + 1) {
                        System.out.println("Please enter a number between 1 to " + filteredTicketTypes.size() + 1);
                        continue;
                    } else if (ticketTypeChoice == filteredTicketTypes.size() + 1) break;
                    while (loop) {
                        System.out.print("Enter new ticket price: ");
                        try {
                            price = sc.nextDouble();

                            if (price <= 0) {
                                System.out.println("Please enter a positive price.");
                                continue;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a integer");
                            sc.next();
                            continue;
                        }
                        break;
                    }
                    TicketType ticketType = updateTicketPrice(movieTypeChoice, ticketTypeChoice, price);
                    System.out.println("Ticket Price updated Successfully");
                    System.out.println("Updated Ticket Type");
                    System.out.println("*************************************");
                    ticketType.showTicketTypeInfo();
                    return;
                }
            }
        }
    }
}
