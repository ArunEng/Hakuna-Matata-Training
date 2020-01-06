//Input1: a10b4gh2 Output1: aaaaaaaaaabbbbghgh
//Input2: abcd2ef4 Output2: abcdabcdefefefef

package training;

import java.util.ArrayList;
import java.util.Scanner;


public class CharacterRepeater {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter string: ");
		String str = in.nextLine();
		in.close();
		System.out.println("First Method: ");
		repeatFirst(str);
		System.out.println("\nSecond Method: ");
		toarray(str);
	}
	
	static void repeatFirst(String str) {
		
		String number="";
		String character = "";
		
		for(int i=0;i<str.length();) {
			character=""; number="";
			while(i<str.length() && (str.charAt(i)<48 || str.charAt(i)>57)) {
				character+=str.charAt(i);
				i++;
			}
			while(i<str.length() && str.charAt(i)>=48 && str.charAt(i)<=57) {
				number+=str.charAt(i);
				i++;
			}
			
			
			if(i==str.length() && number=="") {
				System.out.print(character);
				break;
			}
			
			for(int j=0;j<Integer.parseInt(number);j++) {
				System.out.print(character);
			}
			
		}
	}
	
	static void toarray(String str) {
		ArrayList<String> character = new ArrayList<>();
		ArrayList<Integer> number = new ArrayList<>();
		
		for(int i=0;i<str.length();) {
			String temp1="";
			while(i<str.length() && (str.charAt(i)<48 || str.charAt(i)>57)) {
				temp1+=str.charAt(i);
				i++;
			}
			character.add(temp1);
			
			String temp2 = "";
			while(i<str.length() && str.charAt(i)>=48 && str.charAt(i)<=57) {
				temp2+=str.charAt(i);
				i++;
			}
			number.add(Integer.parseInt(temp2));
		}
		
		for(int i=0;i<character.size();i++) {
			int j=0;
			while(j++<number.get(i)) {
				System.out.print(character.get(i));
			}
		}
		
	}

}
