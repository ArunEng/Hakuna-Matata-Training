/*
 * Input1:		Index from 0 to 8 and number from 1 to 9 :
 * 				0 0 0 0 0 0 0 0 0 
				0 0 0 0 0 0 0 0 0 
				0 0 0 0 0 0 0 0 0 
				0 0 0 0 0 0 0 0 0 
				0 0 0 0 0 0 0 0 0 
				0 0 0 0 0 0 0 0 0 
				0 0 0 0 0 0 0 0 0 
				0 0 0 0 0 0 0 0 0 
				0 0 0 0 0 0 0 0 0

   *Output1:	1 3 4 | 2 9 7 | 6 5 8 | 
				9 8 7 | 4 6 5 | 3 1 2 | 
				5 6 2 | 3 8 1 | 9 7 4 | 
				-----------------------
				2 4 6 | 8 1 9 | 7 3 5 | 
				7 1 8 | 5 4 3 | 2 9 6 | 
				3 9 5 | 7 2 6 | 8 4 1 | 
				-----------------------
				4 5 9 | 6 3 2 | 1 8 7 | 
				8 2 3 | 1 7 4 | 5 6 9 | 
				6 7 1 | 9 5 8 | 4 2 3 | 
	            -----------------------
   *
   *
   *
   *Input2: 	Index from 0 to 8 and number from 1 to 9 :
   *			5 3 0 0 7 0 0 0 0
				6 0 0 1 9 5 0 0 0
				0 9 8 0 0 0 0 6 0
				8 0 0 0 6 0 0 0 3
				4 0 0 8 0 3 0 0 1
				7 0 0 0 2 0 0 0 6
				0 6 0 0 0 0 2 8 0
				0 0 0 4 1 9 0 0 5
				0 0 0 0 8 0 0 7 9
	
	Output2:	5 3 4 | 6 7 8 | 9 1 2 | 
				6 7 2 | 1 9 5 | 3 4 8 | 
				1 9 8 | 3 4 2 | 5 6 7 | 
				-----------------------
				8 5 9 | 7 6 1 | 4 2 3 | 
				4 2 6 | 8 5 3 | 7 9 1 | 
				7 1 3 | 9 2 4 | 8 5 6 | 
				-----------------------
				9 6 1 | 5 3 7 | 2 8 4 | 
				2 8 7 | 4 1 9 | 6 3 5 | 
				3 4 5 | 2 8 6 | 1 7 9 | 
				-----------------------
 */

package training;

import java.util.Scanner;

public class SudokuSolver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//getting input
		int[][] sudoku = new int[9][9];
		System.out.println("Index from 0 to 8 and enter number from 1 to 9 : ");
		System.out.println("Input sudoku: ");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = in.nextInt();
			}
		}
		in.close();
		
		System.out.println("\nOutput: ");
		if (solveSudoku(sudoku)) {
			//if true print sudoku
			for (int row = 0; row < 9; row++) {
				for (int col = 0; col < 9; col++) {
					System.out.print(sudoku[row][col] + " ");
					if(col%3==0+2) {
						System.out.print("| ");
					}
				}
				System.out.println();
				if(row%3==0+2) {
					System.out.println("-----------------------");
				}
			}
		}else {
			System.out.println("Error in input.");
		}
	}

	static boolean solveSudoku(int[][] sudoku) {
		int row = 0, col = 0;
		boolean flag = true;
		
		// getting unassigned place
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0) {
					row = i;
					col = j;
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			}
		}
		//if no unassigned place is there return true
		if (flag) {
			return true;
		}
		//assigning numbers from 1 to 9
		for (int num = 1; num <= 9; num++) {
			if (noConflicts(sudoku, row, col, num)) {
				sudoku[row][col] = num;
				if (solveSudoku(sudoku)) {
					return true;
				}
				sudoku[row][col] = 0;
			}
		}
		return false;

	}
	
	//checking for conflicts in row, column and box
	private static boolean noConflicts(int[][] sudoku, int row, int col, int num) {

		return (!usedInRow(sudoku, row, num)) && (!usedInColumn(sudoku, col, num))
				&& (!usedInBox(sudoku, row - row % 3, col - col % 3, num));
	}
	
	//checking for conflicts in box
	private static boolean usedInBox(int[][] sudoku, int row, int col, int num) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (sudoku[row + i][col + j] == num) {
					return true;
				}
			}
		}
		return false;
	}
	
	//checking for conflicts in column
	private static boolean usedInColumn(int[][] sudoku, int col, int num) {
		for (int row = 0; row < 9; row++) {
			if (sudoku[row][col] == num) {
				return true;
			}
		}
		return false;
	}
	
	//checking for conflicts in row
	private static boolean usedInRow(int[][] sudoku, int row, int num) {
		for (int col = 0; col < 9; col++) {
			if (sudoku[row][col] == num) {
				return true;
			}
		}
		return false;
	}

}
