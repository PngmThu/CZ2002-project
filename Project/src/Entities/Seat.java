package Entities;

import java.io.Serializable;

public class Seat implements Serializable{
	private int row;
	private int col;
	
	
	public Seat(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return this.col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	public String getSeatString() {
		String str;
		char c = (char)('A' + this.row);
		str = c + Integer.toString(this.col);
		return str;
	}

}