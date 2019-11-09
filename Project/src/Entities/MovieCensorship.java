package Entities;

public enum MovieCensorship {
	G("General"),
	PG("Parental guidance"),
    PG13("Parental guidance 13"),
	NC16("No children under 16"),
	M18("Mature 18"),
	R21("Restricted 21");
	private final String description;
	
	MovieCensorship(String desc){
		description = desc; 
	}
	
	public String getDescription() {
		return description;
	}
}

