/*
 * Enter From Date: 
	01-02-2000
	Enter To Date: 
	01-02-2004
	1461

 */

package training;

import java.util.Scanner;

public class CountDays {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter From Date: ");
		String fromDate = in.nextLine();
		System.out.println("Enter To Date: ");
		String toDate = in.nextLine();
		in.close();
		int[] from = new int[3];
		int[] to = new int[3];
		String str = "";
		
		for(int i=0,j=0;i<fromDate.length();i++) {
			if(fromDate.charAt(i)=='-') {
				from[j] = Integer.parseInt(str);
				str="";
				j++;
			}else {
				str+=fromDate.charAt(i);
			}
			if( i == fromDate.length()-1) {
				from[j] = Integer.parseInt(str);
				
			}
		}
		str="";
		for(int i=0,j=0;i<toDate.length();i++) {
			if(toDate.charAt(i)=='-') {
				to[j] = Integer.parseInt(str);
				str="";
				j++;
			}else {
				str+=toDate.charAt(i);
			}
			
			if(i==toDate.length()-1) {
				to[j] = Integer.parseInt(str);
			}
		}
		computeDate(from, to);
		
	}

	private static void computeDate(int[] from, int[] to) {
		int [] month = {31,28,31,30,31,30,31,31,30,31,30,31};
		int n1 = from[2]*365+from[0];
		for(int i=0;i<from[1]-1;i++) {
			n1 += month[i];
		}
		n1+=countLeapYears(from);
		
		int n2 = to[2]*365+to[0];
		for(int i=0;i<to[1]-1;i++) {
			n2+=month[i];
		}
		n2+=countLeapYears(to);
		
		System.out.println(Math.abs(n2-n1));
		
		
	}

	private static int countLeapYears(int[] date) {
		int years=date[2];
		if(date[1]<=2) {
			years--;
		}
		return years/4-years/100+years/400;
		
	}
	
	

}
