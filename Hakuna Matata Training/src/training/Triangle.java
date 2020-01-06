/*
 * Input1: 9
 * 
 * Output1:
 *              9                 
              8 9 8               
            7 8 9 8 7             
          6 7 8 9 8 7 6           
        5 6 7 8 9 8 7 6 5         
      4 5 6 7 8 9 8 7 6 5 4       
    3 4 5 6 7 8 9 8 7 6 5 4 3     
  2 3 4 5 6 7 8 9 8 7 6 5 4 3 2   
1 2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 1 


Input2: 7

Output2: 
            7             
          6 7 6           
        5 6 7 6 5         
      4 5 6 7 6 5 4       
    3 4 5 6 7 6 5 4 3     
  2 3 4 5 6 7 6 5 4 3 2   
1 2 3 4 5 6 7 6 5 4 3 2 1 


 */

package training;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number: ");
		int n = in.nextInt();
		in.close();
		int noOfSpace = n-1;
		int odd=n;
		//printing rows
		for(int i=0;i<n;i++) {
			int temp=noOfSpace;
			//printing first -
			while(temp-->0) {
				System.out.print("  ");
			}
			int no=odd;
			//printing number
			while(n>=no) {
				System.out.print(no+" ");
				no++;
			}
			no=no-2;
			while(no>=odd) {
				System.out.print(no+" ");
				no--;
			}
			temp=noOfSpace;
			odd--;
			//printing second -
			while(temp-->0) {
				System.out.print("  ");
			}
			noOfSpace--;
			System.out.println();
		}
	}

}
