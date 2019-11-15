package Controllers;
import Entities.Movie;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JTextArea;

public class MovieDetailsCtrl{

    public static boolean displayMovieDetails(String movieTitle) {
        ArrayList<Movie> movies = Movie.getAllMoviesData();
        
        for(Movie movie : movies){
            if(movieTitle.equalsIgnoreCase(movie.getTitle())){
            	System.out.println("");
            	
            	System.out.println(">>>>>>>>>>\n");
            	
            	//Chang num to increase the length of the box
            	int num = 45;
            	String movieName = movie.getTitle() + " " + movie.getCensorship() + " (" + movie.getMovieType().getDescription() + ")";
            	num = (105 - movieName.length()) / 2 + 1;
            	
            	String str = "=".repeat(num) + " " + movieName + " " + "=".repeat(num);
            	
            	//System.out.println("str.length(): " + (str.length()));
            	
            	//Top horizontal border
            	System.out.println("* ".repeat(str.length() / 2 + 4));
            	
            	//Movie Name
            	System.out.printf("*  %-" + (str.length() + 2) + "s*\n",str);
            	
            	//Movie Information
            	System.out.printf("*  %-" + (str.length() + 2) + "s*\n","\u2022 Status: " + movie.getStatus().getDescription());
            	System.out.printf("*  %-" + (str.length() + 2) + "s*\n","\u2022 Director: " + movie.getDirector());
            	System.out.printf("*  %-" + (str.length() + 2) + "s*\n","\u2022 Cast: " + movie.getCast());
            	
            	System.out.printf("*  %-" + (str.length() + 2) + "s*\n","\u2022 Synopsis: ");            	
            	ArrayList<String> strList = addLinebreaks(movie.getSynopsis(), 100);
            	for (String string : strList) {
            		System.out.printf("*  %-" + (str.length() + 2) + "s*\n","    " + string);
            	}

            	if (movie.getMovieReviews().size() > 1) {
            		System.out.printf("*  %-" + (str.length() + 2) + "s*\n","\u2022 Overall Rating: " + String.format("%.1f", movie.getAvgRating()));
            	} else {
            		System.out.printf("*  %-" + (str.length() + 2) + "s*\n","\u2022 Overall Rating: NA");
            	}
            	
            	//Bottom horizontal border
            	System.out.printf("*  %-" + (str.length() + 2) + "s*\n","");
            	System.out.println("* ".repeat(str.length() / 2 + 4));

        		return true;
            }
        }
        return false;
    }
    
    public static ArrayList<String> addLinebreaks(String input, int maxLineLength) {
        StringTokenizer tok = new StringTokenizer(input, " ");
        StringBuilder output = new StringBuilder(input.length());
        ArrayList<String> strList = new ArrayList<>();
        int lineLen = 0;
        while (tok.hasMoreTokens()) {
            String word = tok.nextToken();

            if (lineLen + word.length() > maxLineLength) {
                //output.append("\n   ");
            	strList.add(output.toString());
            	output = new StringBuilder(input.length());
                lineLen = 0;
            }
            output.append(word);
            output.append(" ");
            lineLen += word.length() + 1;
        }
        strList.add(output.toString());
        return strList;
    }


}