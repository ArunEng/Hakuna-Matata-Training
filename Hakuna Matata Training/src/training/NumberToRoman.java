// Input1: 9999 Output: MMMMMMMMMCMXCIX
// Input2: 899 Output: DCCCXCIX
package training;

import java.util.Scanner;

public class NumberToRoman {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number: ");
		int number = in.nextInt();
		in.close();
		System.out.println("First Method: ");
		first(number);
		System.out.println("Second Method: ");
		second(number);
	}
	
	//using arrays of characters and number
	static void second(int n) {
		String[] romanCharacters = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
		int[] numbers = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
		String str="";
		int temp=0;
		
		//iterating from largest to smallest number
		for(int i=numbers.length-1;i>=0;i--) {
			//getting first number
			temp=n/numbers[i];
			//checking number >0 
			while(temp-->0) {
				str+=romanCharacters[i];
			}
			//reducing n
			n = n%numbers[i];
		}
		System.out.println(str);
	}
	
	//normal method
	static void first(int number) {
		String roman="";
		//checking number greater than zero
		while(number>0) {
			//checking greater than 1000 
			if(number>=1000) {
				roman+='M';
				number-=1000;
			}
			//checking greater than 500
			else if(number>=500) {
				//checking greater than 900 and adding Roman number CM(900)
				if(number>=900) {
					roman+="CM";
					number-=900;
				}
				//checking for 500 
				else {
					roman+="D";
					number-=500;
				}
			}
			else if(number>=100) {
				//checking for 400
				if(number>=400) {
					roman+="CD";
					number-=400;
				}
				//checking for 100
				else {
					roman+="C";
					number-=100;
				}
			}
			else if(number>=50) {
				//checking for 90
				if(number>=90) {
					roman+="XC";
					number-=90;
				}
				//checking for 50
				else {
					roman+="L";
					number-=50;
				}
			}
			else if(number>=10) {
				//checking for 40
				if(number>=40) {
					roman+="XL";
					number-=40;
				}
				//checking for 10
				else {
					roman+="X";
					number-=10;
				}
			}
			else if(number>=5) {
				//checking for 9
				if(number>=9) {
					roman+="IX";
					number-=9;
				}
				//checking for 5
				else {
					roman+="V";
					number-=5;
				}
			}
			else if(number>=1) {
				//checking for 4
				if(number==4) {
					roman+="IV";
					number-=4;
				}
				//checking 1
				else {
					roman+="I";
					number-=1;
				}
			}
		}
		System.out.println(roman);
	}
	
	
}
