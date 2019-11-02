import java.util.ArrayList;

public class Movie {

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

	/**
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public String getSynopsis() {
		return this.synopsis;
	}

	/**
	 * 
	 * @param synopsis
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getDirector() {
		return this.director;
	}

	/**
	 * 
	 * @param director
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	public ArrayList<String> getCast() {
		return this.cast;
	}

	/**
	 * 
	 * @param cast
	 */
	public void setCast(ArrayList<String> cast) {
		this.cast = cast;
	}

	public double getAvgRating() {
		return this.avgRating;
	}

	public ArrayList<MovieReview> getMovieReviews() {
		return this.movieReviews;
	}

	public String getType() {
		return this.type;
	}
}