/*
 * Input1: 216.58.216.164 Output1: Valid
 * 
 * Input2: 256.255.2.54 Output2: Invalid
 */

package training;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPValidator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter ip: ");
		String ip = in.nextLine();
		in.close();
		System.out.println("Using Regex: ");
		usingRegex(ip);
//		System.out.println("Using string: ");
//		usingString(ip);
		
	}
	
	static void usingRegex(String ip) {
		
		/*regex pattern 25[0-5]-checks for 250 to 255.
		 * 2[0-4][0-9]- checks for 200 to 249.
		 * 1[0-9][0-9]- checks for 100 to 199.
		 * [1-9]?[0-9]- checks for 0 to 99. 
		 */
		Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])$");
		Matcher matcher = pattern.matcher(ip);
		if(matcher.find()) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}
	}
	
	static void usingString(String ip) {
		int[] arr = new int[4];
		String str="";
		//splitting string
		for(int i=0,j=0;i<ip.length()&&j<4;i++) {
			if(ip.charAt(i)=='.') {
				arr[j] = Integer.parseInt(str);
				j++;
				str="";
				
			}else if(ip.charAt(i)>=48 && ip.charAt(i)<=57){
				str+=ip.charAt(i);
			}
			else {
				System.out.println("Invalid");
				return ;
			}
			if(i==ip.length()-1) {
				arr[j] = Integer.parseInt(str);
			}
		}
		//checking for range 0 to 255
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>255 || arr[i]<0) {
				System.out.println("Invalid");
				return;
			}
		}
		System.out.println("Valid");
	}

}
