import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {

	private String title;
	private String status;
	private String synopsis;
	private String director;
	private double avgRating;
	private String type;
	private ArrayList<String> cast;
	private ArrayList<MovieReview> movieReviews;
	
	public Movie(String title, String status, String synopsis, String director, double avgRating, String type, ArrayList<String> cast, ArrayList<MovieReview> movieReviews) {
		this.title = title;
		this.status = status;
		this.synopsis = synopsis;
		this.director = director;
		this.avgRating = avgRating;
		this.type = type;
		this.cast = cast;
		this.movieReviews = movieReviews;
		
	}

	public String getTitle() {
		return this.title;
	}

	public String getStatus() {
		return this.status;
	}

	public void updateStatus(String stt) {
		this.status = stt;
		Movie updatedMovie = new Movie(title, status, synopsis, director, avgRating, type, cast, movieReviews);
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\movie.dat", updatedMovie);
	}

	public String getSynopsis() {
		return this.synopsis;
	}

	public String getDirector() {
		return this.director;
	}

	public ArrayList<String> getCast() {
		return this.cast;
	}

	public double getAvgRating() {
		return this.avgRating;
	}
	
	public void updateAvgRating(double avgR) {
		this.avgRating = avgR;
		Movie updatedMovie = new Movie(title, status, synopsis, director, avgRating, type, cast, movieReviews);
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\movie.dat", updatedMovie);
	}

	public ArrayList<MovieReview> getMovieReviews() {
		return this.movieReviews;
	}
	
	public void updateMovieReviews(ArrayList<MovieReview> l) {
		this.movieReviews = l;
		Movie updatedMovie = new Movie(title, status, synopsis, director, avgRating, type, cast, movieReviews);
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\movie.dat", updatedMovie);
	}

	public String getType() {
		return this.type;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Movie) {
			Movie movie = (Movie)o;
			return (getTitle().equals(movie.getTitle()));
		}
		return false;
	}
}