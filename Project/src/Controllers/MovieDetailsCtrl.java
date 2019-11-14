package Controllers;
import Entities.Movie;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JTextArea;

public class MovieDetailsCtrl{

    public static void displayMovieDetails(String movieTitle) {
        ArrayList<Movie> movies = Movie.getAllMoviesData();
        
        //JTextArea text = new JTextArea(String text, 5, 100)
        
        for(Movie movie : movies){
            if(movieTitle.equalsIgnoreCase(movie.getTitle())){
            	System.out.println("*********************************************");
        		System.out.println("Movie: " + movie.getTitle() + " " + movie.getCensorship() + " (" + movie.getMovieType().getDescription() + ")");
        		System.out.println("Status: " + movie.getStatus().getDescription());
        		System.out.println("Director: " + movie.getDirector());
        		System.out.println("Cast: " + movie.getCast());
        		JTextArea text = new JTextArea(movie.getSynopsis(), 5, 50);
        		text.setLineWrap(true);
        		text.setWrapStyleWord(true);
        		System.out.println("Synopsis: ");
        		System.out.println("    " + addLinebreaks(movie.getSynopsis(), 100));
        		System.out.println("Overall Rating: " + String.format("%.1f", movie.getAvgRating()));
        		break;
            }
        }
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