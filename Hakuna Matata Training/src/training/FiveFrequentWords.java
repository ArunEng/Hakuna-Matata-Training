/*
 * Input1: A paragraph is a self-contained unit of a discourse in writing dealing with a particular point or idea. A paragraph consists of one or more sentences
 * 
 * Output1:
 *  A - 5
	paragraph - 2
	of - 2
	or - 2
	unit - 1
 */

package training;

import java.util.Scanner;

public class FiveFrequentWords {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter paragraph: ");
		String paragraph = in.nextLine();
		String str="";
		in.close();
		String[][] words = new String[paragraph.length()][2];
		
		for(int i=0;i<paragraph.length();i++) {
			if(paragraph.charAt(i)==' '||paragraph.charAt(i)=='.' || paragraph.charAt(i)==',') {
				contains(str,words);
				str="";
				
			}else {
				str+=paragraph.charAt(i);
			}
		}
		sort(words);
		
		for(int i=0;i<5 && words[i][0]!=null;i++) {
			System.out.println(words[i][0]+" - "+words[i][1]);
		}
		
	}
	
	static void contains(String str, String[][] paragraph) {
		int n=0;
		int i=0;
		for(i=0;i<paragraph.length && paragraph[i][0]!=null;i++) {
			if(str.equalsIgnoreCase(paragraph[i][0])) {
				n = Integer.parseInt(paragraph[i][1]);
				n++;
				paragraph[i][1] = ""+n;
				return ;
			}
		}
		
		paragraph[i][0] = str;
		paragraph[i][1] = ""+1;
		
	}
	
	
	//sorting words
	static void sort(String[][] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[i][1]!=null && arr[j][1]!=null && Integer.parseInt(arr[i][1])>Integer.parseInt(arr[j][1])) {
					String temp2 = arr[i][0];
					arr[i][0] = arr[j][0];
					arr[j][0] = temp2;
					String temp1 = arr[i][1];
					arr[i][1] = arr[j][1];
					arr[j][1] = temp1;
					
				}
			}
		}
		
	}

}
