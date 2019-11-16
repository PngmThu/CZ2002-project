package View;

import java.util.ArrayList;

import Controllers.SeatCtrl;
import Entities.Seat;
import Entities.ShowTime;

public class SeatView extends MoblimaViews{

	public void enterView() {
	}
	
	public ArrayList<Seat> enterView(ShowTime showTime){
		int chances = 2, numTicket = 0, row, col;
		int area[] = new int[2];
		String scString;
		ArrayList<Seat> seatList = new ArrayList<Seat>();
		
		for(int i = chances; i >= 0; i--) {
    		System.out.print("\nNumber of Tickets to Purchase(Max. 5): ");
    		numTicket = readInt(3);
    		if(numTicket == -1)
				return null;
			if(numTicket <= 0 || numTicket > 5) {
				if(i == 0) {
        			System.out.println("Invalid Input. Returning back to the Menu.\n");
        			return null;
        		}else {
        			System.out.println("Invalid Input.\t" + i + " tries left.");
        		}
	    	}else {
	    		break;
	    	}
		}    	
    	area[0] = showTime.getCinema().getRowSize();
    	area[1] = showTime.getCinema().getColSize();
    	SeatCtrl seatCtrl = new SeatCtrl(area[0], area[1]);
    	for(int i = 0; i < numTicket; i++) {
    		seatCtrl.displaySeat(showTime);
    		for(int x = 2; x >= 0; x--) {
    			System.out.print("\nEnter Seat(Example: A1): ");
    			scString = sc.nextLine();
    			if(scString.length() == 2 || scString.length() == 3) {
    				row = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(scString.toUpperCase().charAt(0));
    				if(sc.toString().length() == 2) {
    					col = scString.charAt(1) - '0' - 1;
    				}else {
    					col = Integer.parseInt(scString.substring(1)) - 1;
    				}
            		if(row < 0 || row >= area[0] || col < 0 || col >= area[1] ) {
            			if(x == 0) {
            				System.out.println(scString + " is Invalid! Returning to the Menu.");
            				return null;
            			}else {
            				System.out.println(scString + " is Invalid!\t" + x + " tries left.");
            			}
            			
            		}else {
            			if(showTime.getSeatStatusAt(row, col)) {
        	        		if(x == 0) {
        	        			System.out.println("Seat is occupied. Returning to the Menu.");
        	        			return null;
        	        		}else {
        	        			System.out.println("Seat is occupied.\t" + x + " tries left.");
        	        		}
        	        	}else {
        	        		if(i == 0) {
        	        			seatList.add(new Seat(row, col));
        	        			seatCtrl.selectSeat(row, col);
        	        		}else {
        	        			for(Seat seat: seatList) {
        	                		if(seat.getRow() == row && seat.getCol() == col) {
        	                			System.out.println("You have already selected this seat in your previous selection.");
        	                			return null;
        	                		}
        	                	}
        	        			seatList.add(new Seat(row, col));
        	        			seatCtrl.selectSeat(row, col);
        	        		}
        	        		break;
        	        	}
            		}
    			}else {
    				if(x == 0) {
    					System.out.println(scString + " is Invalid! Returning to the Menu.");
    					return null;
    				}else {
    					System.out.println(scString + " is Invalid!\t" + x + " tries left.");
    				}		
    			}
    		}
    	}
    	return seatList;
    }
}
