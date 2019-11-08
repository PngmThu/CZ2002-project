//int  contact = Integer.parseInt(star.nextToken().trim()); 

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TextDB {
	public static final String SEPARATOR = "|";

    // an example of reading
	public static ArrayList readMovies(String filename) throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList alr = new ArrayList() ;// to store Movies data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st; 
				StringTokenizer star;
				
				st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				
				// Separate sigle attributes and array by |@
				star = new StringTokenizer(st , "@");	// pass in the string to the string tokenizer using delimiter ","

				String  p1 = star.nextToken().trim();	// first token: title, status, synopsis, director, avgRating
				String  castData = star.nextToken().trim();	// second token
				String  movieReviewsData = star.nextToken().trim();
				
				// Separate first token: title, status, synopsis, director, avgRating, type
				st = (String)p1;
				star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","
				System.out.println("st: " + st);
				String  title = star.nextToken().trim();
				String  status = star.nextToken().trim();
				String  synopsis = star.nextToken().trim();
				String  director = star.nextToken().trim();
				double  avgRating = Double.parseDouble(star.nextToken().trim()); 
				String  type = star.nextToken().trim();
				
				// Separate cast by |
				st = (String)castData;
				star = new StringTokenizer(st , SEPARATOR);
				
				ArrayList<String> cast = new ArrayList<String>();
				
				while (star.hasMoreTokens()) {  
					 cast.add(star.nextToken());  
			    }  
				
				// Separate movieReviews by ||
				st = (String)movieReviewsData;
				star = new StringTokenizer(st , "||");
				
				List<String> movieReviewStr = new ArrayList<String>();
				
				while (star.hasMoreTokens()) {  
					movieReviewStr.add(star.nextToken());  
			    }
				
				// Separate each movieReview object (reviewer, content, rating) by |
				ArrayList<MovieReview> movieReviews = new ArrayList<MovieReview>();
				MovieReview tempMovieReview;
				
				String reviewer, content;
				int rating;
				
				for (i = 0 ; i < movieReviewStr.size() ; i++) {
					star = new StringTokenizer(st , SEPARATOR);
					reviewer = star.nextToken().trim();
					content = star.nextToken().trim();
					rating = Integer.parseInt(star.nextToken().trim());
					tempMovieReview = new MovieReview(reviewer, content, rating);
					movieReviews.add(tempMovieReview);
				}
				
				
				// create Movie object from file data
				//Movie movie = new Movie(title, status, synopsis, director, avgRating, type, cast, movieReviews);
				// add to Professors list
				//alr.add(movie) ;
			}
			return alr ;
	}

  // an example of saving
public static void saveMovies(String filename, List al) throws IOException {
		List alw = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < al.size() ; i++) {
				Movie movie = (Movie)al.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(movie.getTitle());
				st.append(SEPARATOR);
				st.append(movie.getStatus());
				st.append(SEPARATOR);
				st.append(movie.getSynopsis());
				st.append(SEPARATOR);
				st.append(movie.getDirector());
				st.append(SEPARATOR);
				st.append(movie.getAvgRating());
				st.append(SEPARATOR);
				//st.append(movie.getType());
				st.append("|@");
				ArrayList<String> cast = movie.getCast();
				for (int t = 0 ; t < cast.size() ; t++)  {
					st.append(cast.get(t));
					st.append(SEPARATOR);
				}
				st.append("@");
				ArrayList<MovieReview> movieReviews = movie.getMovieReviews();
				for (int t = 0 ; t < movieReviews.size() ; t++)  {
					st.append(movieReviews.get(t).getReviewer());
					st.append(SEPARATOR);
					st.append(movieReviews.get(t).getContent());
					st.append(SEPARATOR);
					st.append(movieReviews.get(t).getRating());
					st.append(SEPARATOR);
					if (t != movieReviews.size() - 1)
						st.append("||");
				}
				
				alw.add(st.toString()) ;
			}
			write(filename,alw);
	}

  /** Write fixed content to the given file. */
  public static void write(String fileName, List data) throws IOException  {
    PrintWriter out = new PrintWriter(new FileWriter(fileName));

    try {
		for (int i =0; i < data.size() ; i++) {
      		out.println((String)data.get(i));
		}
    }
    finally {
      out.close();
    }
  }

  /** Read the contents of the given file. */
  public static List read(String fileName) throws IOException {
	List data = new ArrayList() ;
    Scanner scanner = new Scanner(new FileInputStream(fileName));
    try {
      while (scanner.hasNextLine()){
        data.add(scanner.nextLine());
      }
    }
    finally{
      scanner.close();
    }
    return data;
  }

public static void main(String[] aArgs)  {
    	TextDB txtDB = new TextDB();
    	String filename = ".\\data\\movie.txt" ;
		try {
			// read file containing Professor records.
			ArrayList al = TextDB.readMovies(filename) ;
			System.out.println("Size of al: " + al.size());
			for (int i = 0 ; i < al.size() ; i++) {
					Movie movie = (Movie)al.get(i);
					System.out.println("Title: " + movie.getTitle() );
					System.out.println("Status: " + movie.getStatus() );
			}
			//*Professor p1 = new Professor("Joseph","jos@ntu.edu.sg",67909999);
			// al is an array list containing Professor objs
			//*al.add(p1);
			// write Professor record/s to file.
			//*TextDB.saveProfessors(filename, al);
		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
  }
}