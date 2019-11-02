

public class Movie {

	private String title;
	private String status;
	private String synopsis;
	private String director;
	private String[] cast;
	private double rating;
	private String pastReview;
	private int pastRating;
	private int attribute;

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

	public String[] getCast() {
		return this.cast;
	}

	/**
	 * 
	 * @param cast
	 */
	public void setCast(String[] cast) {
		this.cast = cast;
	}

	public double getRating() {
		return this.rating;
	}

	/**
	 * 
	 * @param rating
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getPastReview() {
		return this.pastReview;
	}

	/**
	 * 
	 * @param pastReview
	 */
	public void setPastReview(String pastReview) {
		this.pastReview = pastReview;
	}

	public int getPastRating() {
		return this.pastRating;
	}

	/**
	 * 
	 * @param pastRating
	 */
	public void setPastRating(int pastRating) {
		this.pastRating = pastRating;
	}

	public void getAttribute() {
		// TODO - implement Movie.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		this.attribute = attribute;
	}

}