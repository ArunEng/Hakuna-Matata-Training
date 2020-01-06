/*Input1:
 * Enter number of elements: 
	6
	Enter numbers: 
	20 30 34 56 23 12
	Output:
	30 20 56 34 12 23
*/

/*
 * Input2:
 * Enter number of elements: 
	9
	Enter numbers: 
	1 2 3 4 5 6 7 8 9
	Output:
	2 1 4 3 6 5 8 7 9 
 */

package training;

import java.util.Scanner;

public class Swapping {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// getting input
		System.out.println("Enter number of elements: ");
		int n = in.nextInt();
		System.out.println("Enter numbers: ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		System.out.println("By Swaping: ");
		bySwaping(arr);
		System.out.println("\nBy Adding: ");
		byAdding(arr);

		
	}
	
	private static void bySwaping(int[] arr){
		// swapping values
		for (int i = 0; i < arr.length; i = i + 2) {
			if (i % 2 == 0 && i + 1 < arr.length) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	
	//by adding two numbers and subtracting with respective numbers
	static void byAdding(int arr[]) {
		
		for(int i=1;i<arr.length;i=i+2) {
			int sum = arr[i]+arr[i-1];
			arr[i] = sum-arr[i-1];
			arr[i-1] = sum-arr[i];
		}
		
		System.out.println();
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
