package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {

	private String title;
	private MovieStatus status;
	private String synopsis;
	private String director;
	private double avgRating;
	private MovieType movieType;  //MovieType._3D , BLOCKBUSTER , REG
	private String cast;
	private MovieCensorship censorship;
	private ArrayList<MovieReview> movieReviews;
	
	public Movie(String title, MovieStatus status, String synopsis, String director, MovieType movieType, String cast, MovieCensorship censorship) {
		this.title = title;
		this.status = status;
		this.synopsis = synopsis;
		this.director = director;
		this.avgRating = 0;
		this.movieType = movieType;
		this.cast = cast;
		this.censorship = censorship;
		this.movieReviews = new ArrayList<>();
	}

	public String getTitle() {
		return this.title;
	}

	public MovieStatus getStatus() {
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
	
	public MovieType getMovieType() {
		return this.movieType;
	}
	
	public String getCast() {
		return this.cast;
	}
	
	public MovieCensorship getCensorship() {
		return this.censorship;
	}
	
	public ArrayList<MovieReview> getMovieReviews() {
		return this.movieReviews;
	}
	
	public static void initializeData() {  //Call by classname: Movie.initializeData()
		List list = null;
		int i;
		List data = new ArrayList<>();
		String filename = ".\\data\\movie.dat";
		
		String cast;
		ArrayList<MovieReview> movieReviews;
		MovieReview review;
		Movie movie;
		String synopsis;
		
		//Movie 0: Big Hero 6
		cast = "Ryan Potter, Scott Adsit, Jamie Chung";
		synopsis = "The special bond that develops between plus-sized inflatable robot Baymax, and prodigy Hiro Hamada, who team up with a group of friends to form a band of high-tech heroes.";
		
		movie = new Movie("Big Hero 6", MovieStatus.NOW,synopsis,"Don Hall, Chris Williams",MovieType._3D,cast,MovieCensorship.PG);
		data.add(movie);
		
		//Movie 1: Avengers: Endgame
		cast = "Robert Downey Jr., Chris Evans, Chris Hemsworth, Mark Ruffalo";
		synopsis = "The grave course of events set in motion by Thanos that wiped out half the universe and fractured the Avengers ranks compels the remaining Avengers to take one final stand in Marvel Studios’ grand conclusion to twenty-two films, “Avengers: Endgame.”";
		
		movie = new Movie("Avengers: Endgame",MovieStatus.PREVIEW,synopsis,"Anthony Russo, Joe Russo",MovieType.BLOCKBUSTER,cast,MovieCensorship.PG13);
		data.add(movie);

		//Movie 2: Disney's Maleficent: Mistress of Evil
		cast = "Elle Fanning, Angelina Jolie , Michelle Pfeiffer , Sam Riley";
		synopsis = "Maleficent and her goddaughter Aurora begin to question the complex family ties that bind them as they are pulled in different directions by impending nuptials, unexpected allies, and dark new forces at play.";

		movie = new Movie("Disney's Maleficent: Mistress of Evil",MovieStatus.NOW,synopsis,"Joachim Ronning",MovieType.REG,cast,MovieCensorship.PG);
		data.add(movie);

		//Movie 3: Joker
		cast = "Robert De Niro, Joaquin Phoenix, Zazie Beetz, Shea Whigham, Brett Cullen";
		synopsis = "A failed stand-up comedian is driven insane and becomes a psychopathic murderer.";

		movie = new Movie("Joker",MovieStatus.NOW,synopsis,"Todd Phillips",MovieType.REG,cast,MovieCensorship.NC16);
		data.add(movie);

		//Movie 4: Terminator: Dark Fate
		cast = "Diego Boneta, Arnold Schwarzenegger, Linda Hamilton, Mackenzie Davis, Natalia Reyes, Gabriel Luna";
		synopsis = "Linda Hamilton (Sarah Connor) and Arnold Schwarzenegger (T-800) return in their iconic roles in Terminator: Dark Fate, directed by Tim Miller (Deadpool) and produced by visionary filmmaker James Cameron and David Ellison. Following the events of Terminator 2: Judgment Day, Terminator: Dark Fate also stars Mackenzie Davis, Natalia Reyes, Gabriel Luna, and Diego Boneta.";

		movie = new Movie("Terminator: Dark Fate",MovieStatus.NOW,synopsis,"Tim Miller",MovieType.BLOCKBUSTER,cast,MovieCensorship.NC16);
		data.add(movie);

		//Movie 5: Ejen Ali The Movie
		cast = "Ida Rahayum , Noorhayati Maslini, Shafiq Isa, Azman Zulkiply";
		synopsis = "After being accidentally recruited as a spy, 12 year old Ejen Ali embraces his role in secret agency MATA as Cyberaya’s new line of defense. Unknown to Ali, MATA has developed his invention the Atlas gadget to upgrade IRIS into IRIS Neo, testing it as standard equipment for all MATA agents. When the new invention leads to Ali questioning his place and usefulness to MATA, he is approached by a rogue figure who claims to know about a surprising personal connection to Ali. Risking his loyalty to MATA, Ejen Ali embarks on a thrilling chase to unravel these mysterious links.";

		movie = new Movie("Ejen Ali The Movie",MovieStatus.COMING,synopsis,"Usamah Zaid Yasin",MovieType.REG,cast,MovieCensorship.PG);
		data.add(movie);

		//Movie 6: Frozen 2
		cast = "Kristen Bell, Josh Gad, Sterling K. Brown";
		synopsis = "Anna, Elsa, Kristoff, Olaf and Sven leave Arendelle to travel to an ancient, autumn-bound forest of an enchanted land. They set out to find the origin of Elsa's powers in order to save their kingdom.";

		movie = new Movie("Frozen 2",MovieStatus.COMING,synopsis,"Chris Buck, Jennifer Lee",MovieType.REG,cast,MovieCensorship.PG);
		data.add(movie);
		
		SerializeDB.writeSerializedObject(filename, data);  //Write data
		
		//Add reviews
		ArrayList<Movie> movies = Movie.getAllMoviesData();

		//Movie 0: Big Hero 6
		movies.get(0).addMovieReview("John","A touching ending.",4);
		movies.get(0).addMovieReview("Andy","I cried at the end",5);

		//Movie 1: Avengers: Endgame
		movies.get(1).addMovieReview("John","A movie everyone has been waiting for. Worth the wait.",5);
		movies.get(1).addMovieReview("Andy","Movie of the year!",5);

		//Movie 2: Disney's Maleficent: Mistress of Evil
		movies.get(2).addMovieReview("John","Brought my kids to watch this movie and they love it!",4);
		movies.get(2).addMovieReview("Andy","Awesomee",3);

		////Movie 3: Joker
		movies.get(3).addMovieReview("John","Well done! Actors and director did a great job!",4);
		movies.get(3).addMovieReview("Andy","WOW!",2);

		//Movie 4: Terminator: Dark Fate
		movies.get(4).addMovieReview("John","Best movie ever!",4);
		movies.get(4).addMovieReview("Andy","Love the ending!",4);
		
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
		System.out.println("cast: " + this.cast);
		
		System.out.println("movieReviews: ");
		for (i = 0 ; i < movieReviews.size() ; i++) {
			MovieReview mr = movieReviews.get(i);
			System.out.println("- reviewer: " + mr.getReviewer() + "; content: " + mr.getContent() + "; rating: " + mr.getRating());
		}
	}
	
	public void updateStatus(MovieStatus status) {
		this.status = status;
		Movie updatedMovie = this;
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\movie.dat", updatedMovie);
	}

	public void updateMovieType(MovieType mt) {
		this.movieType = mt;
		Movie updatedMovie = this;
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\movie.dat", updatedMovie);
	}

	public void updateMovieCensorship(MovieCensorship mss) {
		this.censorship = mss;
		Movie updatedMovie = this;
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\movie.dat", updatedMovie);
	}

	public void updateSynopsis(String sns) {
		this.synopsis = sns;
		Movie updatedMovie = this;
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\movie.dat", updatedMovie);
	}

	public void updateDirectors(String drt) {
		this.director = drt;
		Movie updatedMovie = this;
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\movie.dat", updatedMovie);
	}

	public void updateCasts(String cst) {
		this.cast = cst;
		Movie updatedMovie = this;
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\movie.dat", updatedMovie);
	}

	public static Movie addMovie(String title, MovieStatus status, String synopsis, String director, MovieType movieType, String cast, MovieCensorship censorship){
		Movie movie = new Movie(title, status, synopsis, director, movieType, cast,censorship);
		SerializeDB.insertSerializedObject(".\\data\\movie.dat", movie);
		return movie;
	}

	public MovieReview addMovieReview(String reviewer, String content, int rating) {
		double sum = 0;
		MovieReview movieReview;
		movieReview= new MovieReview(reviewer, content, rating);
		this.movieReviews.add(movieReview);
		
		//Update avgRating
		for (int i = 0 ; i < this.movieReviews.size() ; i++) {
			movieReview = this.movieReviews.get(i);
			sum += movieReview.getRating();
		}
		this.avgRating = sum / this.movieReviews.size();
		
		Movie updatedMovie = this;
		List list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\movie.dat", updatedMovie);
		
		return movieReview;
	}

	public void deleteMovie() {
		SerializeDB.deleteSerializedObject(".\\data\\movie.dat", this);
	}
	
	public boolean equals(Object o) {
		if (o instanceof Movie) {
			Movie movie = (Movie)o;
			return (getTitle().equals(movie.getTitle()));
		}
		return false;
	}
}