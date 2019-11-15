package Controllers;
import Entities.Movie;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JTextArea;

public class MovieDetailsCtrl{

    public static boolean displayMovieDetails(String movieTitle) {
        ArrayList<Movie> movies = Movie.getAllMoviesData();
        
        //JTextArea text = new JTextArea(String text, 5, 100)
        
        for(Movie movie : movies){
            if(movieTitle.equalsIgnoreCase(movie.getTitle())){
            	System.out.println("*********************************************");
            	
            	System.out.println(">>>>>>>>>>\n");
            	System.out.println("* ".repeat(25));
            	
            	String movieName = movie.getTitle() + " " + movie.getCensorship() + " (" + movie.getMovieType().getDescription() + ")";
            	String str = " " + "=".repeat(10) + " " + movieName + " " + "=".repeat(10);
            	System.out.printf("*  %-47s*\n",str);
	   			
	
	   			System.out.printf("*  %-51s*\n", "");
	   			System.out.printf("*  %-51s*\n", "1) View details of a movie");
	   			System.out.printf("*  %-51s*\n", "2) Return to main menu");
	   			System.out.printf("*  %-51s*\n","");
	   			 
	   			System.out.println("* ".repeat(str.length() / 2 + 1));
	   			System.out.println("");
            	
        		System.out.println("Movie: " + movie.getTitle() + " " + movie.getCensorship() + " (" + movie.getMovieType().getDescription() + ")");
        		System.out.println("Status: " + movie.getStatus().getDescription());
        		System.out.println("Director: " + movie.getDirector());
        		System.out.println("Cast: " + movie.getCast());
        		JTextArea text = new JTextArea(movie.getSynopsis(), 5, 50);
        		text.setLineWrap(true);
        		text.setWrapStyleWord(true);
        		System.out.println("Synopsis: ");
        		System.out.println("    " + addLinebreaks(movie.getSynopsis(), 100));
        		System.out.print("Overall Rating: ");
        		if (movie.getMovieReviews().size() > 1)
        			System.out.println(String.format("%.1f", movie.getAvgRating()));
        		else
        			System.out.println("NA");
        		return true;
            }
        }
        return false;
    }
    
    public static String addLinebreaks(String input, int maxLineLength) {
        StringTokenizer tok = new StringTokenizer(input, " ");
        StringBuilder output = new StringBuilder(input.length());
        int lineLen = 0;
        while (tok.hasMoreTokens()) {
            String word = tok.nextToken();

            if (lineLen + word.length() > maxLineLength) {
                output.append("\n    ");
                lineLen = 0;
            }
            output.append(word);
            output.append(" ");
            lineLen += word.length() + 1;
        }
        return output.toString();
    }


}