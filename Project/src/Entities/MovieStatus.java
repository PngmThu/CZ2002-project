package Entities;

public enum MovieStatus {
	COMING("Coming Soon"),
	PREVIEW("Preview"),
    NOW("Now Showing"),
    END("End of Showing");
	private final String description;
	
	MovieStatus(String desc){
		description = desc; 
	}
	
	public String getDescription() {
		return description;
	}
}

