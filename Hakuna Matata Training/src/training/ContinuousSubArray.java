/*
 * Input1: 4 5 8 9 23 6 8 2 1 Output1: 8 2 1
 * 
 * Input2: 2 3 4 5 6 7 8 9 10 0 Output2: 6 7
 */

package training;

import java.util.Scanner;

public class ContinuousSubArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter total number of elements:");
		int n = in.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter elements of array:");
		for(int i=0;i<n;i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("Enter Value: ");
		int value = in.nextInt();
		in.close();
		System.out.println("First:");
		first(arr,value);
		System.out.println("Second: ");
		second(arr,value);
	}
	
	static void first(int[] arr, int value) {
		int i=0,j=1;
		if(arr[i] == value) {
			System.out.println(arr[i]);
			return;
		}
		int sum=0;
		sum+=arr[i];
		for(j=1;j<=arr.length;j++) {
			while(sum>value && i<(j-1)) {
				sum-=arr[i];
				i++;
			}
			if(sum==value) {
				for(int k=i;k<j;k++) {
					System.out.println(arr[k]);
				}
				return ;
			}
			if(j<arr.length) {
				sum+=arr[j];
			}
		}
		System.out.println("Value is not found.");
	}
	
	static void second(int[] arr,int value) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == value) {
				System.out.println(arr[i]);
				return ;
			}
			int sum=arr[i];
			for(int j=i+1;j<arr.length;j++) {
				sum+=arr[j];
				if(sum==value) {
					for(int k=i;k<=j;) {
						System.out.println(arr[k]);
						k++;
					}
					return ;
				}
				if(sum>value) {
					break;
				}
			}
		}
	}

}
