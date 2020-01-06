/*
   Input1:     Enter matrix size: 
				10
			   Enter number of input: 
				10
			   Enter 10 index, word length, direction: 
				9 9 9 up
				9 9 10 left
				1 3 5 down
				3 4 5 right
				7 0 4 right
				8 6 3 left
				5 5 4 down
				3 0 3 up
				0 6 5 left
				4 5 2 left
	
   Output1:		x x W W W W W x x x 
				W x x W x x x x x W 
				W x x W x x x x x W 
				W x x W W W W W W W 
				x x x W W W x x x W 
				x x x W x W x x x W 
				x x x x x W x x x W 
				W W W W x W x x x W 
				x x x x W W W x x W 
				W W W W W W W W W W 
				
	Input2:
	
 */

package training;

import java.util.Scanner;

public class CrossWord {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter matrix size: ");
		//getting matrix size
		int size = in.nextInt();
		char[][] matrix = new char[size][size];
		//getting no of input
		System.out.println("Enter number of input: ");
		int noOfInput = in.nextInt();
		System.out.println("Enter " + noOfInput + " index, word length, direction: ");
		
		
		while (noOfInput-- > 0) {
			//getting row, column, length, direction
			int row = in.nextInt();
			int col = in.nextInt();
			int length = in.nextInt();
			String direction = in.next();
			//checking row, column and length with respective size of matrix
			if((row>=0 && row<size) && (col>=0 && col<size) && length>0 && length<=size) {
				//moves up
				if(direction.equalsIgnoreCase("up")) {
					moveUp(matrix, length,row,col);
				}//moves down
				else if(direction.equals("down")) {
					moveDown(matrix,length,row,col);
					
				}//moves right
				else if(direction.equalsIgnoreCase("right")) {
					moveRight(matrix, length,row,col);
					
				}//moves left
				else if(direction.equalsIgnoreCase("left")) {
					moveLeft(matrix, length,row,col);
				}
			}
			
		}
		in.close();
		
		//filling remaining with spaces
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(matrix[i][j]!='W') {
					matrix[i][j]='x';
				}
			}
		}
		//printing matrix
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}

	}
	
	//moving left
	private static void moveLeft(char[][] matrix, int length,int row,int col) {
		for(int i=col;i>col-length;i--) {
			matrix[row][i] = 'W';
		}
	}
	
	//moving right
	private static void moveRight(char[][] matrix, int length,int row,int col) {
		for(int i=col;i<col+length;i++) {
			matrix[row][i] = 'W';
		}
	}
	
	//moving down
	private static void moveDown(char[][] matrix, int length,int row,int col) {
		for(int i=row;i<row+length;i++) {
			matrix[i][col] = 'W';
		}
	}
	
	//moving up
	private static void moveUp(char[][] matrix, int length,int row,int col) {
		for(int i=row;i>row-length;i--) {
			matrix[i][col] = 'W';
		}
	}

}
