//Input1: 123 Output1: 12
//Input2: 3456 Output2: 16946

package training;

import java.util.Scanner;

public class Exponentiation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number: ");
		int number = in.nextInt();
		in.close();
		System.out.println("First Method: ");
		passInteger(number);
		System.out.println("\nSecond Method:");
		passCharArray((""+number).toCharArray());
		
	}
	
	//passing number as integer
	static void passInteger(int n) {
		int ten = tens(n);//calculating no of 10's
		int first = n/ten;//getting first digit
		int sum=0;
		while(n>10) {//checking upto last single digit
			int a = n/(ten/10);//getting first two digit
			int b = a/10;//getting first digit
			a=a%10;//getting remainder from first two digit(second digit)
			sum+=Math.pow(b, a);
			n=n%ten;//changing n to remainder
			ten=ten/10;
		}
		sum+=Math.pow(n, first);//doing for last term
		System.out.println(sum);
		
	}
	
	
	//passing number as character array
	static void passCharArray(char[] c) {
		int sum=0;
		for(int i=0;i<c.length-1;i++) {
			sum+=Math.pow(Integer.parseInt(""+c[i]), Integer.parseInt(""+c[i+1]));			
		}
		sum+=Math.pow(Integer.parseInt(""+c[c.length-1]), Integer.parseInt(""+c[0]));
		System.out.println(sum);
		
	}
	
	
	//to get tens value
	static int tens(int n) {
		int t=1;
		while(n>0) {
			n=n/10;
			t*=10;
		}
		return t/10;
	}
	

}
