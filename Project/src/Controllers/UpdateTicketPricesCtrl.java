package Controllers;

import Entities.MovieType;
import Entities.TicketType;

import java.util.ArrayList;

public class UpdateTicketPricesCtrl {
    public static void displayMovieTypesOptions(){
        int index = 1;
        for (MovieType movieType : MovieType.values()){
            System.out.println(index + ") " + movieType);
        }
    }

    public static ArrayList<TicketType> filterTicketTypes(int choice){
        ArrayList<TicketType> ticketTypes = TicketType.getAllTicketTypesData();
        MovieType movieType = null;
        if (choice == 1){
            movieType = MovieType.REG;
        } else if (choice == 2){
            movieType = MovieType._3D;
        } else if (choice == 3){
            movieType = MovieType.BLOCKBUSTER;
        }

        for (TicketType ticketType : ticketTypes){
            if (!(ticketType.getMovieType() == movieType)){
                ticketTypes.remove(ticketType);
            }
        }
        return ticketTypes;
    }

    public static TicketType updateTicketPrice(int movieTypeChoice, int ticketTypeChoice, double price){
        ArrayList<TicketType> ticketTypes = filterTicketTypes(movieTypeChoice);
        ticketTypes.get(ticketTypeChoice-1).setPrice(price);
        TicketType.storeNewTicketTypesData(ticketTypes);
        return ticketTypes.get(ticketTypeChoice-1);

    }
}
