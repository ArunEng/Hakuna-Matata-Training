package training;

import java.util.Scanner;

public class QueenCutHorse {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter queens position: ");
		int queenRow = in.nextInt();
		int queenColumn = in.nextInt();
		
		//checking for negative and greater than 7
		while(queenRow<0 || queenColumn<0 || queenRow>=8 || queenColumn>=8) {
			System.out.println("Please Enter number from 0 to 7.");
			System.out.println("Enter queens position: ");
			queenRow = in.nextInt();
			queenColumn = in.nextInt();
		}
		
		System.out.println("Enter horse position: ");
		int horseRow = in.nextInt();
		int horseColumn = in.nextInt();
		
		//checking for negative and greater than 7
		while(horseRow<0 || horseColumn<0 || horseRow>=8 || horseColumn>=8) {
			System.out.println("Please Enter number from 0 to 7.");
			System.out.println("Enter horse position: ");
			horseRow = in.nextInt();
			horseColumn = in.nextInt();
		}
		in.close();
				
		//checking for same place
		if(queenRow==horseRow && queenColumn==horseColumn) {
			System.out.println("Cannot place queen and horse in same place.");
			return ;
		}
		
		
		if(checkKnight2(queenRow, queenColumn, horseRow, horseColumn)) {
			System.out.println("Knight cuts the Queen.");
		}
		else if(checkQueen2(queenRow, queenColumn, horseRow, horseColumn)) {
			System.out.println("Queen cuts Knight");
		}
		else {
			System.out.println("Both are safe.");
		}
			
	}
	static boolean checkKnight1(int queenRow, int queenColumn, int horseRow, int horseColumn) {
		int chessBoard[][] = new int[8][8];
		chessBoard[horseRow][horseColumn] = 1; //initializing horse
		//checking top
		if(queenRow-2>=0) {
			if(queenColumn-1>=0 && chessBoard[queenRow-2][queenColumn-1]==1) {
				return true;
			}
			if(queenColumn+1<8 && chessBoard[queenRow-2][queenColumn+1]==1) {
				return true;
			}	
		}
		//checking bottom
		if(queenRow+2<8) {
			if(queenColumn-1>=0 && chessBoard[queenRow+2][queenColumn-1]==1) {
				return true;
			}
			if(queenColumn+1<8 && chessBoard[queenRow+2][queenColumn+1]==1) {
				return true;
			}
		}
		//checking right
		if(queenColumn+2<8) {
			if(queenRow+1<8 && chessBoard[queenRow+1][queenColumn+2]==1) {
				return true;
			}
			if(queenRow-1>=0 && chessBoard[queenRow-1][queenColumn+2]==1) {
				return true;
			}
		}
		
		//checking left
		if(queenColumn-2>=0) {
			if(queenRow+1<8 && chessBoard[queenRow+1][queenColumn-2]==1) {
				return true;
			}
			if(queenRow-1>=0 && chessBoard[queenRow-1][queenColumn-2]==1) {
				return true;
			}
		}
		return false;
	}
	
	static boolean checkKnight2(int qrow, int qcolumn, int hrow, int hcolumn) {
		//checking top left 
		if(hrow-2==qrow && hcolumn-1 == qcolumn ) {
			return true;
		}
		//checking top right
		else if(hrow-2==qrow && hcolumn+1 == qcolumn ) {
			return true;
		}
		//checking left up
		else if(hrow-1==qrow && hcolumn-2 == qcolumn ) {
			return true;
		}
		//checking left down
		else if(hrow+1==qrow && hcolumn-2 == qcolumn ) {
			return true;
		}
		//checking bottom right
		else if(hrow+2==qrow && hcolumn+1 == qcolumn ) {
			return true;
		}
		//checking bottom left
		else if(hrow+2==qrow && hcolumn-1 == qcolumn ) {
			return true;
		}
		//checking right down
		else if(hrow+1==qrow && hcolumn+2 == qcolumn ) {
			return true;
		}
		//checking right up
		else if(hrow-1==qrow && hcolumn+2 == qcolumn ) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	static boolean checkQueen1(int qR, int qC, int hR, int hC) {
		//check top
		for(int i=qR,j=qC,k=qC;i>=0;i--,j--,k++) {
			if(i==hR && hC==qC) {
				return true;
			}
			if(j>=0 && (i==hR && hC==j)) {
				return true;
			}
			if(k<8 &&(i==hR && hC==k)) {
				return true;
			}
			
			//check right
			if(k<8 && (qR==hR && k==hC)) {
				return true;
			}
			//check left
			if(j>=0 && (qR==hR && j==hC)) {
				return true;
			}
		}
		//check bottom
		for(int i=qR,j=qC,k=qC;i<8;i++,j--,k++) {
			if(i==hR && hC==qC) {
				return true;
			}
			if(j<=0 && (i==hR && j==hC)) {
				return true;
			}
			if(k<8 &&(i==hR && hC==k)) {
				return true;
			}
			//check right
			if(k<8 && (qR==hR && k==hC)) {
				return true;
			}
			//check left
			if(j>=0 && (qR==hR && j==hC)) {
				return true;
			}
		}
		return false;
	}
	
	static boolean checkQueen2(int qR, int qC, int hR, int hC) {
		//checking for vertical(Column)
		if(qR==hR) {
			return true;
		}
		//checking for horizontal(row)
		if(qC==hC) {
			return true;
		}
		//checking top 
		for(int i=qR-1,j=qC+1,k=qC-1;i>=0 && j<8;i--,j++,k--) {
			//going right
			if(i==hR && j==hC) {
				return true;
			}
			//going left
			if(k>=0 && (i==hR && k==hC)) {
				return true;
			}
		}
		//checking bottom
		for(int i=qR+1,j=qC+1,k=qC-1;i<8 && j<8;i++,j++,k--) {
			//going right
			if(i==hR && j==hC) {
				return true;
			}
			//going left
			if(k>=0 && (i==hR && k==hC)) {
				return true;
			}
		}
		return false;
	}
}
