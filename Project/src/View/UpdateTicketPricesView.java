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
            System.out.println("*************************************");
            System.out.println("Admin - Update Ticket Prices");
            System.out.println("*************************************");
            displayMovieTypesOptions();
            System.out.println(MovieType.values().length+1 + ") Go back\n");
            System.out.print("Enter your choice: ");
            movieTypeChoice = readInt(false);
            if (movieTypeChoice <= 0 || movieTypeChoice >MovieType.values().length+1) {
                System.out.println("Please enter a number between 1 to " + ( MovieType.values().length+1) + ".");
                continue;
            } else if (movieTypeChoice == (MovieType.values().length+1)) {
                return;
            } else {
                while (loop){
                    index = 1;
                    ArrayList<TicketType> filteredTicketTypes = filterTicketTypes(movieTypeChoice);
                    System.out.println("*************************************");
                    System.out.println("Admin - Select a Ticket Type");
                    System.out.println("*************************************");
                    System.out.println(index + ") Ticket Type " + index);
                    for (TicketType ticketType : filteredTicketTypes) {
                        ticketType.showTicketTypeInfo();
                        index++;
                    }
                    System.out.println((index + 1) + ") Go back\n");
                    System.out.println("Enter your choice: ");
                    ticketTypeChoice = readInt(false);
                    if (ticketTypeChoice == -1) continue;
                    else if (ticketTypeChoice <= 0 || ticketTypeChoice > filteredTicketTypes.size() + 1) {
                        System.out.println("Please enter a number between 1 to " + filteredTicketTypes.size() + 1);
                        continue;
                    } else if (ticketTypeChoice == filteredTicketTypes.size() + 1) break;
                    while (loop) {
                        System.out.println("Enter new ticket price: ");
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
