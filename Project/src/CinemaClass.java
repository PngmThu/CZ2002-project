public enum CinemaClass {
	REG("Digital Hall"),
	ATMOS("Atmos Hall"),
    PLATINUM("Platinum Movie Suites");
   
	private final String description;
	
	CinemaClass(String desc){
		description = desc; 
	}
	
	public String getDescription() {
		return description;
	}
}


