package Entities;

import java.io.Serializable;

public class MovieReview implements Serializable {
	private String reviewer = "";
	private String content = "";
	private int rating = 0;
	
	public MovieReview(String reviewer, String content, int rating) {
		this.reviewer = reviewer;
		this.content = content;
		this.rating = rating;
	}
	
	public String getReviewer() {
		return reviewer;
	}
	
	public String getContent() {
		return content;
	}
	
	public int getRating() {
		return rating;
	}
}
