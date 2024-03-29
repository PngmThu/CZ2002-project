package Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Entities.Movie;
import Entities.MovieStatus;

public class MovieListingCtrl {
	public static void displayMovieListing() {
		int i;
		ArrayList<Movie> movies = Movie.getAllMoviesData();
		ArrayList<Movie> nowShowing = new ArrayList<>();
		ArrayList<Movie> preview = new ArrayList<>();
		ArrayList<Movie> comingSoon = new ArrayList<>();
		
		System.out.println("");
		for (i = 0 ; i < movies.size() ; i++) {
			Movie movie = movies.get(i);
			if (movie.getStatus().equals(MovieStatus.NOW)) {
				nowShowing.add(movie);
			}
			else if (movie.getStatus().equals(MovieStatus.PREVIEW)) {
				preview.add(movie);
			}
			else if (movie.getStatus().equals(MovieStatus.COMING)) {
				comingSoon.add(movie);
			}
		}
		
		Integer[] sizes = { nowShowing.size(), preview.size(), comingSoon.size() }; 
		int maxSize = Collections.max(Arrays.asList(sizes)); 
		Movie movie;
		String str;
		
		System.out.println("* ".repeat(76));
		
		System.out.printf("*  %-47s","================ NOW SHOWING ================");
		System.out.printf("*  %-47s","================== PREVIEW ==================");
		System.out.printf("*  %-47s","================ COMING SOON ================");
		System.out.printf("*\n");
		System.out.printf("*  %-47s*  %-47s*  %-47s*\n","","","");
		
		String triangle = String.valueOf((char)0x25B6);
		for (i = 0 ; i < maxSize ; i++) {
			if (i < nowShowing.size()) {
				movie = nowShowing.get(i);
				str =  "\u2022 " + movie.getTitle() + " (" + movie.getCensorship() + ")";
				System.out.printf("*  %-47s",str);
			} else {
				System.out.printf("*  %-47s","");
			}
			
			if (i < preview.size()) {
				movie = preview.get(i);
				str = "\u2022 " + movie.getTitle() + " (" + movie.getCensorship() + ")";
				System.out.printf("*  %-47s",str);
			} else {
				System.out.printf("*  %-47s","");
			}
			
			if (i < comingSoon.size()) {
				movie = comingSoon.get(i);
				str = "\u2022 " + movie.getTitle() + " (" + movie.getCensorship() + ")";
				System.out.printf("*  %-47s",str);
			} else {
				System.out.printf("*  %-47s","");
			}
			System.out.printf("*\n");
		}
		System.out.printf("*  %-47s*  %-47s*  %-47s*\n","","","");
		System.out.printf("*  %-47s*  %-47s*  %-47s*\n","","","");
		System.out.println("* ".repeat(76));
		System.out.println("");
	
//		str = "\u2022 " + "abc" + " (" + "PG" + ")";
//		System.out.printf("%-50s",str);
//		System.out.printf("%-50s",str);
//		System.out.println("");
//		System.out.printf("%-50s","");
//		System.out.printf("%-50s",str);
	}
	
	//public static void printHorizontalBorder(int length)
}
