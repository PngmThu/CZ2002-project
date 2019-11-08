import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {

	private String title;
	private String status;
	private String synopsis;
	private String director;
	private double avgRating;
	private String movieType;
	private ArrayList<String> cast;
	private ArrayList<MovieReview> movieReviews;
	
	public Movie(String title, String status, String synopsis, String director, double avgRating, String movieType, ArrayList<String> cast, ArrayList<MovieReview> movieReviews) {
		this.title = title;
		this.status = status;
		this.synopsis = synopsis;
		this.director = director;
		this.avgRating = avgRating;
		this.movieType = movieType;
		this.cast = cast;
		this.movieReviews = movieReviews;
		
	}

	public String getTitle() {
		return this.title;
	}

	public String getStatus() {
		return this.status;
	}

	public String getSynopsis() {
		return this.synopsis;
	}

	public String getDirector() {
		return this.director;
	}

	public double getAvgRating() {
		return this.avgRating;
	}
	
	public String getMovieType() {
		return this.movieType;
	}
	
	public ArrayList<String> getCast() {
		return this.cast;
	}
	
	public ArrayList<MovieReview> getMovieReviews() {
		return this.movieReviews;
	}
	
	public static void initializeData() {  //Call by classname: Movie.initializeData()
		List list = null;
		int i;
		
		List data = new ArrayList<>();
		String filename = ".\\data\\movie.dat";
		ArrayList<String> cast = new ArrayList<>();
		cast.add("Ryan Potter");      cast.add("Honey Lemon");
		ArrayList<MovieReview> movieReviews = new ArrayList<>();
		MovieReview review = new MovieReview("John","Very touching",4);   movieReviews.add(review);
		review = new MovieReview("Andy","A meaningful movie",5);          movieReviews.add(review);
		
		Movie movie = new Movie("Big Hero 6","Showing","A nice movie for family","Don Hall, Chris Williams",4.8,
				"Blockbuster",cast,movieReviews);
		data.add(movie);
		SerializeDB.writeSerializedObject(filename, data);  //Write data
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
		
		/*
		//Call to update status
		//movie.updateStatus("Upcoming");
		
		for (i = 0 ; i < list.size() ; i++) {
			Movie m = (Movie)list.get(i);
			System.out.println("Title: " + m.getTitle() );
			System.out.println("Status: " + m.getStatus());
		}
		*/
	}
	
	public static ArrayList<Movie> getAllMoviesData() {   //Call by classname: Movie.getAllMoviesData()
		List list = null;
		String filename = ".\\data\\movie.dat";
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
		
		return (ArrayList<Movie>) list;
	}
	
	public void showMovieInfo() {  
		int i;
		System.out.println("*********************************************");
		System.out.println("Title: " + this.title );
		System.out.println("Status: " + this.status);
		System.out.println("Synopsis: " + this.synopsis);
		System.out.println("Director: " + this.director);
		System.out.println("avgRating: " + this.avgRating);
		System.out.println("movieType: " + this.movieType);
		System.out.println("cast: ");
		for (i = 0 ; i < cast.size() ; i++) {
			System.out.println("- " + cast.get(i));
		}
		System.out.println("movieReviews: ");
		for (i = 0 ; i < movieReviews.size() ; i++) {
			MovieReview mr = movieReviews.get(i);
			System.out.println("- reviewer: " + mr.getReviewer() + "; content: " + mr.getContent() + "; rating: " + mr.getRating());
		}
	}
	
	public void updateStatus(String stt) {
		this.status = stt;
		Movie updatedMovie = this;
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\movie.dat", updatedMovie);
	}
	
	
	public void updateAvgRating(double avgR) {
		this.avgRating = avgR;
		Movie updatedMovie = this;
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\movie.dat", updatedMovie);
	}
	
	public void addMovieReview(MovieReview mr) {
		this.movieReviews.add(mr);
		Movie updatedMovie = this;
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\movie.dat", updatedMovie);
	}
	
	public boolean equals(Object o) {
		if (o instanceof Movie) {
			Movie movie = (Movie)o;
			return (getTitle().equals(movie.getTitle()));
		}
		return false;
	}
}