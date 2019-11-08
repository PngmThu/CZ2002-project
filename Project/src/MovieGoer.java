public class MovieGoer {

	private String name;
	private String mobile;
	private String email;
	private int movieGoerGroup;
	
	public MovieGoer(String name, String mobile, String email, int movieGoerGroup) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.movieGoerGroup = movieGoerGroup;
	}

	public String getName() {
		return this.name;
	}

	public String getMobile() {
		return this.mobile;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}