package Controllers;

import Entities.MovieGoerGroup;
import Entities.MovieType;
import Entities.TicketType;

import java.util.ArrayList;

import static Controllers.MovieDetailsCtrl.addLinebreaks;

public class UpdateTicketPricesCtrl {
    public static void displayMovieTypesOptions(String str){
        int index = 1;
        for (MovieType movieType : MovieType.values()){
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", (index+") " +movieType.getDescription()));
            index++;
        }
    }
    public static void displayTicketTypes(ArrayList<TicketType> ticketTypes, int movieTypeChoice){
        int index = 1;
        System.out.println("\n>>>>>>>>>>\n");

        /********************************Display Information***********************************/
        //Chang num to increase the length of the box
        int num = 20;
        for (TicketType ticketType : ticketTypes) {
            MovieGoerGroup[] movieGoerGroups = ticketType.getMovieGoerGroupL();
            String [] dayOfWeeks = ticketType.getDayOfWeekL();
            String[] isPublicHoliday = ticketType.getIsPublicHolidayL();
            String movieGoerGroup = "";
            String dayOfWeek = "";
            String publicHoliday = "";

            for (int i = 0; i<movieGoerGroups.length; i++){
                movieGoerGroup+= movieGoerGroups[i] + " ";
            }
            for (int i = 0; i<dayOfWeeks.length; i++){
                dayOfWeek+= dayOfWeeks[i] + " ";
            }
            for (int i = 0; i<isPublicHoliday.length; i++){
                publicHoliday+= isPublicHoliday[i] + " ";
            }

            String str = "=".repeat(num) + " " + (index + ") Ticket Type " + index) +" " + "=".repeat(num);
            //Top horizontal border
            System.out.println("\n"+("* ".repeat(str.length() / 2 + 4)));
            //Ticket Type #
            System.out.printf("*  %-" + (str.length() + 2) + "s*\n", str);
            //Ticket Type Information
            System.out.printf("*  %-" + (str.length() + 2) + "s*\n", "\u2022 Movie type: " + ticketType.getMovieType());
            System.out.printf("*  %-" + (str.length() + 2) + "s*\n", "\u2022 Cinema class: " + ticketType.getCinemaClass());
            System.out.printf("*  %-" + (str.length() + 2) + "s*\n", "\u2022 Moviegoer group: " + movieGoerGroup);
            System.out.printf("*  %-" + (str.length() + 2) + "s*\n", "\u2022 Day of week: " + dayOfWeek);
            System.out.printf("*  %-" + (str.length() + 2) + "s*\n", "\u2022 Public holiday: " + publicHoliday);
            System.out.printf("*  %-" + (str.length() + 2) + "s*\n", "\u2022 Price: " + ticketType.getPrice());
            //Bottom horizontal border
            System.out.printf("*  %-" + (str.length() + 2) + "s*\n","");
            System.out.println("* ".repeat(str.length() / 2 + 4));
            index++;
        }
        System.out.println("\n" + index + ") Back to Main Menu ");
        System.out.println("\n>>>>>>>>>>\n");
        /*****************************************************************************************/
    }

    public static ArrayList<TicketType> filterTicketTypes(int choice){
        TicketType ticketType = null;
        ArrayList<TicketType> ticketTypes = TicketType.getAllTicketTypesData();
        MovieType movieType = null;
        if (choice == 1){
            movieType = MovieType.REG;
        } else if (choice == 2){
            movieType = MovieType._3D;
        } else if (choice == 3){
            movieType = MovieType.BLOCKBUSTER;
        }

        for (int i=0; i<ticketTypes.size(); i++){
            ticketType = ticketTypes.get(i);
            if (!(ticketType.getMovieType().getDescription().equalsIgnoreCase(movieType.getDescription()))){
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
