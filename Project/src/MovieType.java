public enum MovieType {
	REG("Regular"),
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

