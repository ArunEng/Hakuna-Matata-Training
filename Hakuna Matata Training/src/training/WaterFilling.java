/*
 * Input1: 7 0 4 2 5 0 6 4 0 5 Output1: 25
 * 
 * Input2: 2 3 6 2 3 6 2 3 6 7 Output2: 14
 * 
 */

package training;

import java.util.Scanner;

public class WaterFilling {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter total number of elements: ");
		int n = in.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter elements: ");
		for(int i=0;i<n;i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		System.out.println("First: ");
		usingTempArrays(arr);
		System.out.println("Second: ");
		usingTempVariables(arr);
		
	}
	
	static void usingTempArrays(int[] arr) {
		int[] temp1 = new int[arr.length];//to store max from left
		int[] temp2 = new int[arr.length];//to store max from right
		int sum=0;
		temp1[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(temp1[i-1]>arr[i]) {
				temp1[i] = temp1[i-1];
			}
			else {
				temp1[i] = arr[i];
			}
		}
		temp2[arr.length-1] = arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--) {
			if(temp2[i+1]>arr[i]) {
				temp2[i]=temp2[i+1];
			}else {
				temp2[i] = arr[i];
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			if(temp1[i]>temp2[i]) {
				sum+=temp2[i]-arr[i];
			}
			else {
				sum+=temp1[i]-arr[i];
			}
		}
		System.out.println("Water can fill upto: "+sum);
	}
	
	static void usingTempVariables(int[] arr) {
		int sum=0;
		int temp=0;//to hold water upto previous max
		int max = arr[0];
		int index=0;
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>=max) {
				max=arr[i];
				index=i;
				temp=0;
			}else {
				sum+=max-arr[i];
				temp+=max-arr[i];
			}
		}
		
		if(index<arr.length-1) {
			sum-=temp;
			max = arr[arr.length-1];
			for(int i=arr.length-1;i>=index;i--) {
				if(arr[i]>=max) {
					max=arr[i];
				}else {
					sum+=max-arr[i];
				}
			}
		}
		System.out.println("Water can fill upto: "+sum);
	}
}
