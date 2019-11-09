package Entities;

public enum MovieGoerGroup {
	STUDENT("Student"),
	ADULT("Adult"),
	SENIOR("Senior Citizen");
   
	private final String description;
	
	MovieGoerGroup(String desc){
		description = desc; 
	}
	
	public String getDescription() {
		return description;
	}
}


