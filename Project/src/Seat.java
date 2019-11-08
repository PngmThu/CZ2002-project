import java.io.Serializable;

public class Seat implements Serializable{
	private int row;
	private int col;
	private String type;
	
	public Seat(int row, int col, String type) {
		this.row = row;
		this.col = col;
		this.type = type;  //Standard or Couple
	}

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

	public int getRow() {
		return this.row;
	}

	/**
	 * 
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return this.col;
	}

	/**
	 * 
	 * @param number
	 */
	public void setCol(int col) {
		this.col = col;
	}

}