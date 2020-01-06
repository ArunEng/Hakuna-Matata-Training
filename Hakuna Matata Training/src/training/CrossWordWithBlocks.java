package training;

import java.util.Scanner;

public class CrossWordWithBlocks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter matrix size: ");
		// getting matrix size
		int size = in.nextInt();
		char[][] matrix = new char[size][size];

		// marking blocks
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int row = (int) (Math.random() * size);
				int col = (int) (Math.random() * size);
				if (row % 2 != 0 || col % 2 == 0) {
					matrix[row][col] = 'x';
				}
			}
		}

		// printing generated blocks
		System.out.println("Matrix: ");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		// getting no of inputs
		System.out.println("Enter no of input: ");
		int noOfInput = in.nextInt();
		System.out.println("Enter " + noOfInput + " index, length, direction: ");
		while (noOfInput-- > 0) {
			// getting inputs
			int row = in.nextInt();
			int col = in.nextInt();
			int length = in.nextInt();
			String direction = in.next();
			// checking current index
			if (matrix[row][col] == 'x') {
				System.out.println("Cannot place word in index.");
			} else {
				// checking up
				if (direction.equalsIgnoreCase("up")) {
					if (checkUp(matrix, length, row, col)) {
						System.out.println("Successfully placed your word.");

					} else {
						System.out.println("Blocks inbetween. Cannot place your word.");
					}

				} // checking down
				else if (direction.equalsIgnoreCase("down")) {
					if (checkDown(matrix, length, row, col)) {
						System.out.println("Successfully placed your word.");

					} else {
						System.out.println("Blocks inbetween. Cannot place your word.");
					}
				} // checking left
				else if (direction.equalsIgnoreCase("left")) {
					if (checkLeft(matrix, length, row, col)) {
						System.out.println("Successfully placed your word.");
					} else {
						System.out.println("Blocks inbetween. Cannot place your word.");
					}
				} // checking right
				else if (direction.equalsIgnoreCase("right")) {
					if (checkRight(matrix, length, row, col)) {
						System.out.println("Successfully placed your word.");
					} else {
						System.out.println("Blocks inbetween. Cannot place your word.");
					}
				}
			}
		}
		in.close();
		// printing final matrix
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static boolean checkRight(char[][] matrix, int length, int row, int col) {
		// returning if length exceeds
		if ((col + length) <= matrix.length) {
			return false;
		} else {// checking for blocks
			for (int i = col; i < col + length; i++) {
				if (matrix[row][i] == 'x') {
					return false;
				}
			} // assigning temporary letters
			for (int i = col; i < col + length; i++) {
				matrix[row][i] = 'W';
			}
			return true;
		}

	}

	private static boolean checkLeft(char[][] matrix, int length, int row, int col) {
		// returning if length exceeds
		if ((col + 1) - length < 0) {
			return false;
		} else {// checking for blocks
			for (int i = col; i > col - length; i++) {
				if (matrix[row][i] == 'x') {
					return false;
				}
			} // assigning temporary letters
			for (int i = col; i > col - length; i++) {
				matrix[row][i] = 'W';
			}
			return true;
		}
	}

	private static boolean checkDown(char[][] matrix, int length, int row, int col) {
		// returning if length exceeds
		if (row + length <= matrix.length) {
			return false;
		} else {// checking for blocks
			for (int i = row; i < row + length; i++) {
				if (matrix[i][col] == 'x') {
					return false;
				}
			} // assigning temporary letters
			for (int i = row; i < row + length; i++) {
				matrix[i][col] = 'W';
			}
			return true;
		}
	}

	private static boolean checkUp(char[][] matrix, int length, int row, int col) {
		// returning if length exceeds
		if ((row + 1) - length < 0) {
			return false;
		} else {// checking for blocks
			for (int i = row; i > row - length; i--) {
				if (matrix[i][col] == 'x') {
					return false;
				}
			}
			// assigning temporary letters
			for (int i = row; i > row - length; i--) {
				matrix[i][col] = 'W';
			}
			return true;
		}
	}
}
