package View;

import Controllers.ParticularsCtrl;
import Entities.MovieGoer;
import Entities.MovieGoerGroup;

public class ParticularsView extends MoblimaViews{
	
	private MovieGoer movieGoer;
	
	public MovieGoer getMovieGoer() {
		return this.movieGoer;
	}
	
	public void enterView() {
		int index, chances = 2, scInt = 0;
    	String name, mobile = null, email;
    	MovieGoerGroup ageGroup = null;
		
		System.out.print("\nEnter Name: ");
		name = sc.nextLine();
		System.out.println("Enter Age Group:");
		
		index = 1;
		for(MovieGoerGroup group: MovieGoerGroup.values()) {
			System.out.println("(" + index + ") " + group.getDescription());
			index++;
		}
	
		for(int i = chances; i >= 0; i--) {
			scInt = readInt(3);
			if(scInt == -1)
				return;
			if(scInt <= 0 || scInt > MovieGoerGroup.values().length) {
				if(i == 0) {
	    			System.out.println("Invalid Input. Returning back to the Menu.\n");
	    			return;
	    		}else {
	    			System.out.println("Invalid Input.\t" + i + " tries left.");
	    		}
	    	}else {
	    		ageGroup = MovieGoerGroup.values()[(scInt - 1)];
	    		break;
	    	}
		}
		
		for(int i = chances; i >= 0; i--) {
			if(i == 0)
				return;
			System.out.println("Enter Mobile (8 digits):");
			mobile = sc.nextLine();
	    	try {
	    		Integer.parseInt(mobile);
	    		
	    		if(mobile.length() != 8) {
	    			throw new Exception("'" + mobile + "' is not 8 digits.\t" + i + " tries left.");
	    		}else {
	    			break;
	    		}
	        } catch (NumberFormatException e) {
	        	System.out.println(mobile + " is not a number.\t" + i + " tries left.");
	        } catch (Exception e) {
	           System.out.println(e.getMessage());
	        }
		}
		System.out.println("Enter Email:");
		email = sc.nextLine();
		
		movieGoer = ParticularsCtrl.movieGoerExist(email);
		if(movieGoer == null) {
    		movieGoer = ParticularsCtrl.addMovieGoer(name, mobile, email, ageGroup);
    	}
	}
}
