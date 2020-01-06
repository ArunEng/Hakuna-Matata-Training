/*Input1:
 * Enter number of elements: 
	3
	Enter numbers: 
	56 10 20
	Largest to smallest: 
	562010
	Smallest to largest: 
	102056 
*/

/*
 * Input2:
 * Enter number of elements: 
	6
	Enter numbers: 
	12 6 89 75 43 38
	Largest to smallest: 
	89754338126
	Smallest to largest: 
	61238437589
 */

package training;

import java.util.Scanner;

public class LargestAndSmallest {

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

		// sorting- ascending order
		bubbleSort(arr);

		// printing from reverse
		System.out.println("Largest to smallest: ");
		for (int i = n - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}

		// printing from first
		System.out.println("\nSmallest to largest: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

	}

	// sorting using bubble sort
	static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] >= arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
