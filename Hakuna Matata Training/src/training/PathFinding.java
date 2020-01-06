package training;

import java.util.Scanner;

public class PathFinding {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// getting input
		System.out.println("Enter matrix size: ");
		int n = in.nextInt();
		int[][] matrix = new int[n][n];
		
		//filling matrix randomly
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int row = (int) (Math.random() * n);
				int col = (int) (Math.random() * n);
				if ((row % 2 == 0 && col % 2 != 0) || (row % 2 != 0 && col % 2 == 0)) {
					matrix[row][col] = 1;
				}
			}
		}
		
		//to check visited path
		boolean[][] flag = new boolean[n][n];
		
		//getting start and end point
		System.out.println("Input: ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		//getting start index
		System.out.println("Enter start index(0's are path and 1's are block): ");
		int startRow = in.nextInt();
		int startColumn = in.nextInt();
		
		//getting end index
		System.out.println("Enter end index(0's are path and 1's are block): ");
		int endRow = in.nextInt();
		int endColumn = in.nextInt();
		in.close();
		
		//finding path
		if (findPath(matrix, startRow, startColumn, endRow, endColumn, flag)) {
			System.out.println("Path exists");
		}else {
			System.out.println("No path");
		}
		
	}
	
	
	//path finding using backtracking
	static boolean findPath(int[][] matrix, int startRow, int startColumn, int endRow, int endColumn,
			boolean[][] flag) {
		
	
		//base case for ending search
		if (startRow == endRow && startColumn == endColumn) {
			return true;
		}
		
		//checking for right
		if (moveRight(matrix, startRow, startColumn, endRow, endColumn, flag)) {
			//marking cell as visited
			flag[startRow][startColumn] = true;
			//checking again
			if(findPath(matrix, startRow, startColumn + 1, endRow, endColumn, flag)) {
				return true;
			}
			//changing to false if checking again fails
			flag[startRow][startColumn] = false;
		}
		
		//checking for up
		if (moveUp(matrix, startRow, startColumn, endRow, endColumn, flag)) {
			//marking cell as visited
			flag[startRow][startColumn] = true;
			//checking again
			if(findPath(matrix, startRow - 1, startColumn, endRow, endColumn, flag)) {
				return true;
			}
			//changing to false if checking again fails
			flag[startRow][startColumn] = true;
		}
			
		//checking for down
		if (moveDown(matrix, startRow, startColumn, endRow, endColumn, flag)) {
			//marking cell as visited
			flag[startRow][startColumn] = true;
			//checking again
			if(findPath(matrix, startRow + 1, startColumn, endRow, endColumn, flag)) {
				return true;
			}
			//changing to false if checking again fails
			flag[startRow][startColumn] = true;
		}
			
			
		//checking for left
		if (moveLeft(matrix, startRow, startColumn, endRow, endColumn, flag)) {
			//marking cell as visited
			flag[startRow][startColumn] = true;
			//checking again
			if(findPath(matrix, startRow, startColumn - 1, endRow, endColumn, flag)) {
				return true;
			}
			//changing to false if checking again fails
			flag[startRow][startColumn] = true;
		}
		
		
		
		return false;

	}

	//condition to move right
	private static boolean moveRight(int[][] matrix, int startRow, int startColumn, int endRow, int endColumn,
			boolean[][] flag) {
		if (startColumn + 1 < matrix.length && matrix[startRow][startColumn + 1] == 0
				&& !flag[startRow][startColumn + 1]) {
			
			return true;
		}
		return false;
	}

	//condition to move left
	private static boolean moveLeft(int[][] matrix, int startRow, int startColumn, int endRow, int endColumn,
			boolean[][] flag) {
		if (startColumn - 1 >= 0 && matrix[startRow][startColumn - 1] == 0 && !flag[startRow][startColumn - 1]) {
			
			return true;
		}
		return false;
	}

	//condition to move down
	private static boolean moveDown(int[][] matrix, int startRow, int startColumn, int endRow, int endColumn,
			boolean[][] flag) {
		if (startRow + 1 < matrix.length && matrix[startRow + 1][startColumn] == 0
				&& !flag[startRow + 1][startColumn]) {
			
			return true;
		}
		return false;
	}

	//condition to move up
	private static boolean moveUp(int[][] matrix, int startRow, int startColumn, int endRow, int endColumn,
			boolean[][] flag) {
		if (startRow - 1 >= 0 && matrix[startRow - 1][startColumn] == 0 && !flag[startRow - 1][startColumn]) {
			
			return true;
		}
		return false;
	}

}
