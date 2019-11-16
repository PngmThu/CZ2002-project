package Controllers;

import Entities.ShowTime;

public class SeatCtrl {
	private boolean selectedSeats[][];
	
	public SeatCtrl(int row, int col) {
		this.selectedSeats = new boolean[row][col];
	}
	
	public void selectSeat(int row, int col) {
		this.selectedSeats[row][col] = true;
	}
	
	public void displaySeat(ShowTime showTime) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int row, col, decorate, r, c;
		boolean[][] seatStatus;
		
		seatStatus = showTime.getSeatStatus();
		row = showTime.getCinema().getRowSize();
		col = showTime.getCinema().getColSize();
		
		System.out.println("======================== Seat Layout ========================");
		System.out.println();
		System.out.print("===");
		for(decorate = 1; decorate <= (col/2); decorate++) {
			System.out.print("====");
		}
		System.out.print("| SCREEN |");
		for(; decorate <= col; decorate++) {
			System.out.print("====");
		}
		System.out.print("===");
		System.out.println();
		System.out.println();
		System.out.print("     ");
		for(decorate = 1; decorate <= (col/2); decorate++) {
			System.out.print(String.format("%02d", decorate) + "  ");
		}
		System.out.print("\t ");
		for(; decorate <= col; decorate++) {
			System.out.print(String.format("%02d", decorate) + "  ");
		}
		System.out.println("");
		for(r = 0; r < row; r++) {
			decorate = 0;
			System.out.print("   ");
			while(decorate < (2*col + 1)) {
				
				System.out.print("=");
				decorate++;
			}
			System.out.print(" \t");
			while(decorate < (4*col + 2)) {
				System.out.print("=");
				decorate++;
			}
			System.out.println();
			System.out.print(" " + alphabet.charAt(r) + " |");
			for(c = 0; c < (col/2); c++) {
				if(seatStatus[r][c]) {
					System.out.print(" x |");
				}else if(this.selectedSeats[r][c]){
					System.out.print(" # |");
				}else {
					System.out.print("   |");
				}
			}
			System.out.print(" \t|");
			for(; c < col; c++) {
				if(seatStatus[r][c]) {
					System.out.print(" x |");
				}else if(this.selectedSeats[r][c]){
					System.out.print(" # |");
				}else {
					System.out.print("   |");
				}
			}
			System.out.println();
		}
		decorate = 0;
		System.out.print("   ");
		while(decorate < (2*col + 1)) {
			System.out.print("=");
			decorate++;
		}
		System.out.print(" \t");
		while(decorate < (4*col + 2)) {
			System.out.print("=");
			decorate++;
		}
		System.out.println("\n");
		
		System.out.print("=====");
		for(decorate = 1; decorate <= (col/2); decorate++) {
			System.out.print("===");
		}
		System.out.print("| ENTRANCE |");
		for(; decorate <= col; decorate++) {
			System.out.print("===");
		}
		System.out.print("=====");
		System.out.println();
	}
}
