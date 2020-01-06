/*
 * Input1: 02-07-2016 Output1: Saturday
 * 
 * Input2: 28-11-2019 Output2: Thursday
 */
package training;

import java.util.Scanner;

public class DateToDay {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter Date: ");
		String date = in.nextLine();
		in.close();
		int[] arr = new int[3];
		int j = 0;
		String str = "";
		int dd=0, mm=0 , yy=0;
		// splitting input to array
		for (int i = 0; i < date.length(); i++) {
			if (date.charAt(i) == '-') {
				arr[j] = Integer.parseInt(str);
				str = "";
				j++;
			} else {
				str += date.charAt(i);
			}
			if (i == date.length() - 1) {
				arr[j] = Integer.parseInt(str);
			}
		}
		dd = arr[0];
		mm = arr[1];
		yy = arr[2];
		getDay(dd, mm, yy);
		System.out.println("Zellers method: ");
		zellersMethod(dd, mm, yy);
		

	}
	
	static void getDay(int dd, int mm, int yy) {
		String days[] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		
		int[] month = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
		
		int yearCode = yy;
		yearCode -= (mm < 3) ? 1 : 0;
		yearCode = (yearCode + yearCode / 4 - yearCode / 100 + yearCode / 400 + month[mm - 1] + dd) % 7;

		System.out.println(days[yearCode]);
	}
	
	static void zellersMethod(int dd, int mm, int yy) {
		String days[] = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		
		if(mm==1) {
			mm=13;
			yy--;
		}
		if(mm==2) {
			mm=14;
			yy--;
		}
		
		int q = dd;
		int m = mm;
		int k = yy%100;
		int j = yy/100;
		
		//Zellers formula
		int h = q+(13*(m+1)/5)+k+(k/4)+(j/4)-2*j;
		
		System.out.println(days[h%7]);
		

	}

}
