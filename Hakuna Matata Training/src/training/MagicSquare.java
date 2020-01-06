/*Input1: 5
 * Output1: 9 3 22 16 15 
			2 21 20 14 8 
			25 19 13 7 1 
			18 12 6 5 24 
			11 10 4 23 17*/
/*
 * Input2: 8
 * Output2: 64 63 3 4 5 6 58 57 
			56 55 11 12 13 14 50 49 
			17 18 46 45 44 43 23 24 
			25 26 38 37 36 35 31 32 
			33 34 30 29 28 27 39 40 
			41 42 22 21 20 19 47 48 
			16 15 51 52 53 54 10 9 
			8 7 59 60 61 62 2 1
 */
/*
 * Input3: 6
 * Output3:29 7 6 20 25 24 
			9 32 1 27 23 19 
			31 3 8 22 21 26 
			2 34 33 11 16 15 
			36 5 28 18 14 10 
			4 30 35 13 12 17 
 * 
 */

package training;

import java.util.Scanner;

public class MagicSquare {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number: ");
		int n = in.nextInt();
		in.close();
		if (n % 2 != 0) {
			int[][] arr = oddMagicSquare(n);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			if (n % 4 == 0) {
				doublyEvenMagicSquare(n);
			} else {
				singlyEvenMagicSquare(n);
			}
		}

	}

	private static void singlyEvenMagicSquare(int n) {
		int size = n * n;
		int halfN = n / 2;
		int subSquareSize = size / 4;
		// splitting into four magic squares
		int[][] subSquare = oddMagicSquare(halfN);

		int[] quadrantFactors = { 0, 2, 3, 1 };
		int[][] result = new int[n][n];
		
		//assigning values based on odd magic square   
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				int quadrant = (r / halfN) * 2 + (c / halfN);
				result[r][c] = subSquare[r % halfN][c % halfN];
				result[r][c] += quadrantFactors[quadrant] * subSquareSize;
			}
		}

		int nColsLeft = halfN / 2;
		int nColsRight = nColsLeft - 1;

		for (int r = 0; r < halfN; r++)
			for (int c = 0; c < n; c++) {
				if (c < nColsLeft || c >= n - nColsRight || (c == nColsLeft && r == nColsLeft)) {

					if (c == 0 && r == nColsLeft)
						continue;

					int tmp = result[r][c];
					result[r][c] = result[r + halfN][c];
					result[r + halfN][c] = tmp;
				}
			}

		// printing magic square
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void doublyEvenMagicSquare(int n) {
		int[][] magicSquare = new int[n][n];

		// fill matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magicSquare[i][j] = (n * i) + j + 1;
			}
		}

		// changing top left corner
		for (int i = 0; i < n / 4; i++) {
			for (int j = 0; j < n / 4; j++) {
				magicSquare[i][j] = (n * n + 1) - magicSquare[i][j];
			}
		}

		// changing top right corner
		for (int i = 0; i < n / 4; i++) {
			for (int j = 3 * n / 4; j < n; j++) {
				magicSquare[i][j] = (n * n + 1) - magicSquare[i][j];
			}
		}

		// changing bottom left corner
		for (int i = 3 * n / 4; i < n; i++) {
			for (int j = 0; j < n / 4; j++) {
				magicSquare[i][j] = (n * n + 1) - magicSquare[i][j];
			}
		}

		// changing bottom right corner
		for (int i = 3 * n / 4; i < n; i++) {
			for (int j = 3 * n / 4; j < n; j++) {
				magicSquare[i][j] = (n * n + 1) - magicSquare[i][j];
			}
		}

		// changing center
		for (int i = n / 4; i < 3 * n / 4; i++) {
			for (int j = n / 4; j < 3 * n / 4; j++) {
				magicSquare[i][j] = (n * n + 1) - magicSquare[i][j];
			}
		}

		// printing magic square
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(magicSquare[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] oddMagicSquare(int n) {
		int[][] magicSquare = new int[n][n];
		int i = n / 2, j = n - 1;
		int t = 1;
		while (t <= n * n) {
			if (i == -1 && j == n) {
				i = 0;
				j = n - 2;
			} else {
				if (i == -1) {
					i = n - 1;
				}
				if (j == n) {
					j = 0;
				}
			}

			if (magicSquare[i][j] == 0) {
				magicSquare[i][j] = t;
				t++;
			} else {
				j -= 2;
				i++;
				continue;
			}
			i--;
			j++;
		}

		return magicSquare;
	}

}
