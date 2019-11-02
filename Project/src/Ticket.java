

public class Ticket {

	private String type;
	private String standard;
	private int age;
	private String day;
	private Boolean publicHoliday;
	private double price;

	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getStandard() {
		return this.standard;
	}

	/**
	 * 
	 * @param standard
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}

	public int getAge() {
		return this.age;
	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	public String getDay() {
		return this.day;
	}

	/**
	 * 
	 * @param day
	 */
	public void setDay(String day) {
		this.day = day;
	}

	public Boolean getPublicHoliday() {
		return this.publicHoliday;
	}

	/**
	 * 
	 * @param publicHoliday
	 */
	public void setPublicHoliday(Boolean publicHoliday) {
		this.publicHoliday = publicHoliday;
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}