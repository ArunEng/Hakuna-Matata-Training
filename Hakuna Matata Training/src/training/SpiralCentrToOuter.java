/*
 * Input1: 4 4 Output1: 10 11 7 6 5 9 13 14 15 16 12 8 4 3 2 1
 * 
 * Input2: 2 2 Output2: 3 4 2 1
 */

package training;

import java.util.Scanner;

public class SpiralCentrToOuter {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number: ");
		int n = in.nextInt();
		int m = in.nextInt();
		in.close();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = (n * i) + j + 1;
			}
		}
		System.out.println("First Method: ");
		firstMethod(n, m, arr);
		System.out.println("\nSecond Method: ");
		secondMethod(n,m,arr);

	}
	
	//getting spiral and printing in reverse
	static void firstMethod(int r, int c, int[][]arr) {
		int ir=0,ic=0,value=0;
		int mr=r-1,mc=c-1;
		int res[] = new int[r*c];//to store spiral order
		while(value<r*c) {
			for(int i=ic;i<=mc;i++) {
				res[value] = arr[ir][i];
				value++;
			}
			for(int i=ir+1;i<=mr;i++) {
				res[value] = arr[i][mc];
				value++;
			}
			for(int i=mc-1;i>=ic;i--) {
				res[value] = arr[mr][i];
				value++;
			}
			for(int i=mr-1;i>ir;i--) {
				res[value] = arr[i][ic];
				value++;
			}
			ic++;
			ir++;
			mc--;
			mr--;
		}
		
		//printing in reverse
		for(int i=res.length-1;i>=0;i--) {
			System.out.print(res[i]+" ");
		}
	}

	static void secondMethod(int m,int n,int[][] arr) {
		int[] res = new int[m*n];
		int i, k = 0, l = 0;
		int z=0;
		
		while(k<m && l<n) {
			int val;
			for(i=l;i<n;++i) {
				val = arr[k][i];
				res[z] = val;
				++z;
			}
			k++;
			for(i=k;i<m;++i) {
				val = arr[i][n-1];
				res[z] = val;
				++z;
			}
			n--;
			if(k<m) {
				for(i=n-1;i>=l;--i) {
					val = arr[m-1][i];
					res[z] = val;
					++z;
				}
				m--;
			}
			
			if(l<n) {
				for(i = m-1;i>=k;--i) {
					val = arr[i][l];
					res[z] = val;
					++z;
				}
				l++;
			}
		}
		
		for(i=z-1;i>=0;i--) {
			System.out.print(res[i]+" ");
		}
		

	}

}
