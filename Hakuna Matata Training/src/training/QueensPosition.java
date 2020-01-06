/*
 * Input1: 8
 * 
 * Output1: Q - - - - - - - 
			- - - - - - Q - 
			- - - - Q - - - 
			- - - - - - - Q 
			- Q - - - - - - 
			- - - Q - - - - 
			- - - - - Q - - 
			- - Q - - - - - 
 *
 *Input2: 4
 *Output2:  - - Q - 
			Q - - - 
			- - - Q 
			- Q - - 
 *
 */


package training;

import java.util.Scanner;

public class QueensPosition {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter no of queen");
		int n = in.nextInt();
		in.close();
		char[][] queen = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				queen[i][j] = '-';
			}
		}

		if (solveQueens(queen, 0)) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(queen[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("Nothing");
		}
	}

	static boolean solveQueens(char[][] queen, int n) {
		// base case
		if (n >= queen.length) {
			return true;
		}

		for (int i = 0; i < queen.length; i++) {
			if (noConflicts(queen, i, n)) {
				queen[i][n] = 'Q';

				// checking again
				if (solveQueens(queen, n + 1)) {
					return true;
				}
				queen[i][n] = '-';
			}
		}
		return false;

	}

	// checking conflicts
	private static boolean noConflicts(char[][] queen, int row, int col) {

		return checkRow(queen, row, col) && checkColumn(queen, row, col) && upperDiagonal(queen, row, col)
				&& lowerDiagonal(queen, row, col);
	}

	// checking lower diagonal - south west
	private static boolean upperDiagonal(char[][] queen, int row, int col) {
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (queen[i][j] == 'Q') {
				return false;
			}
		}

		return true;
	}

	// checking upper diagonal - north west
	private static boolean lowerDiagonal(char[][] queen, int row, int col) {

		for (int i = row, j = col; j >= 0 && i < queen.length; i++, j--) {
			if (queen[i][j] == 'Q') {
				return false;
			}
		}

		return true;
	}

	// checking column
	private static boolean checkColumn(char[][] queen, int row, int col) {
		for (int i = 0; i < queen.length; i++) {
			if (queen[i][col] == 'Q') {
				return false;
			}
		}
		return true;
	}

	// checking row
	private static boolean checkRow(char[][] queen, int row, int col) {
		for (int i = 0; i < queen.length; i++) {
			if (queen[row][i] == 'Q') {
				return false;
			}
		}
		return true;
	}

}
