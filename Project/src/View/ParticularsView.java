package View;

import Controllers.ParticularsCtrl;
import Entities.MovieGoer;
import Entities.MovieGoerGroup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParticularsView extends MoblimaViews{
	
	private MovieGoer movieGoer;
	
	public MovieGoer getMovieGoer() {
		return this.movieGoer;
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		return matcher.find();
	}
	
	public void enterView() {
		int index, chances = 2, scInt = 0;
    	String name, mobile = null, email;
    	MovieGoerGroup ageGroup = null;
    	boolean validEmail=false;
		
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
			if(scInt == -1) {
				System.out.print(" Returning back to the Menu.");
				return;
			}
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
			System.out.println("Enter Mobile (8 digits):");
			mobile = sc.nextLine();
	    	try {
	    		Integer.parseInt(mobile);
	    		
	    		if(mobile.length() != 8) {
	    			throw new Exception("'" + mobile + "' is not 8 digits.");
	    		}else {
	    			break;
	    		}
	        } catch (NumberFormatException e) {	
	        	if(i == 0) {
	        		System.out.println(mobile + " is not a number. Returning to the Menu.");
	        		return;
	        	}else {
	        		System.out.println(mobile + " is not a number.\t" + i + " tries left.");
	        	}
	        } catch (Exception e) {
	           if(i == 0) {
	        	   System.out.println(e.getMessage() + " Returning to the Menu.");
	        	   return;
	           }else {
	        	   System.out.println(e.getMessage() + "\t" + i + " tries left.");
	           }
	        }
		}
		do {
			System.out.println("Enter Email:");
			email = sc.nextLine();

			if(validate(email) == true)
				validEmail=true;
			else
				System.out.println("Invalid email address, please enter a valid email address.");
		}while(validEmail==false);
		
		movieGoer = ParticularsCtrl.movieGoerExist(email);
		if(movieGoer == null) {
    		movieGoer = ParticularsCtrl.addMovieGoer(name, mobile, email, ageGroup);
    	}
	}
}
