package Entities;

public enum MovieType {
	REG("Digital"),
	_3D("3D"),
    BLOCKBUSTER("Blockbuster");
	private final String description;
	
	MovieType(String desc){
		description = desc; 
	}
	
	public String getDescription() {
		return description;
	}
}

