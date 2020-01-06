//Input: MMMMMXIV Output: 5014
//Input: MDCLXVI Output: 1666
package training;

import java.util.Scanner;

public class RomanToNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Roman number: ");
		String roman = in.nextLine();
		in.close();
		System.out.println("First Method: ");
		first(roman);
		System.out.println("\nSecond Method: ");
		second(roman);

	}

	static void second(String roman) {
		int sum = 0;
		for (int i = 0; i < roman.length(); i++) {
			//getting roman char value
			int temp1 = contains(roman.charAt(i));
			//checking for next char
			if (i + 1 < roman.length()) {
				//getting i+1 char roman value
				int temp2 = contains(roman.charAt(i + 1));
				
				//if first roman value is greater add it to the sum
				if (temp1 >= temp2) {
					sum += temp1;
				} else {//else get difference like (V-I = 4 / X-I = 9) and add it to sum
					sum += temp2 - temp1;
					i++;
				}
			} else {//add last value to sum
				sum += temp1;
			}
		}
		System.out.println(sum);

	}

	static int contains(char c) {
		//assigning roman values
		char[] romanCharacters = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		int[] numbers = { 1, 5, 10, 50, 100, 500, 1000 };
		//to store roman number value
		int n = 0;
		
		//checking for value
		for (int i = 0; i < romanCharacters.length; i++) {
			if (romanCharacters[i] == c) {
				n = numbers[i];
				break;
			}
		}
		return n;
	}

	static void first(String roman) {
		int sum = 0;
		for (int i = 0; i < roman.length(); i++) {
			// checking for I
			if (roman.charAt(i) == 'I') {
				// checking i+1 is within length of input string
				if (i + 1 < roman.length() && roman.charAt(i + 1) == 'V') {
					sum += 4;
					i++;// incrementing to next character if V is found
				} else if (i + 1 < roman.length() && roman.charAt(i + 1) == 'X') {
					sum += 9;
					i++;
				} else {
					sum += 1;
				}
			}
			// checking for V
			else if (roman.charAt(i) == 'V') {
				sum += 5;// incrementing sum by 5
			}

			// checking for L
			else if (roman.charAt(i) == 'X') {
				if (i + 1 < roman.length() && roman.charAt(i + 1) == 'L') {
					sum += 40;
					i++;
				} else if (i + 1 < roman.length() && roman.charAt(i + 1) == 'C') {
					sum += 90;
					i++;
				} else {
					sum += 10;
				}

			}

			// checking for L
			else if (roman.charAt(i) == 'L') {
				sum += 50;

			}

			// checking for C
			else if (roman.charAt(i) == 'C') {
				if (i + 1 < roman.length() && roman.charAt(i + 1) == 'D') {
					sum += 400;
					i++;
				} else if (i + 1 < roman.length() && roman.charAt(i + 1) == 'M') {
					sum += 900;
					i++;
				} else {
					sum += 100;
				}

			}

			// checking for D
			else if (roman.charAt(i) == 'D') {
				sum += 500;

			}

			// checking for M
			else if (roman.charAt(i) == 'M') {
				sum += 1000;

			}
		}
		System.out.println(sum);
	}

}
