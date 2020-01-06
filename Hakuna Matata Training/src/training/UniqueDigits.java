package training;

import java.util.Scanner;

public class UniqueDigits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter start number: ");
		int start = in.nextInt();
		System.out.println("Enter end number: ");
		int end = in.nextInt();
		in.close();
		for(int i=start;i<=end;i++) {
			if(isUnique(i)) {
				System.out.println(i);
			}
		}
	}
	
	//checking unique
	private static boolean isUnique(int i) {
		boolean[] flag = new boolean[10];
		while(i>0) {
			int a = i%10;
			if(!flag[a]) {
				flag[a]=true;
			}else {
				return false;
			}
			i=i/10;
		}
		return true;
	}
}
