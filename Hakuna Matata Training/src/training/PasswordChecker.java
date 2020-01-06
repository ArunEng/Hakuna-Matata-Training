package training;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter password: ");
		String largeString = in.nextLine();
		in.close();
		
		Pattern pattern = Pattern.compile("^(?=.+?[a-z])(?=.+?[A-Z])(?=.+?[0-9])(?=.+?[\\$@%#\\*&]).{8,24}$");
		Matcher matcher = pattern.matcher(largeString);
		
		if(matcher.matches()) {
			System.out.println("Password is strong");
		}else System.out.println("Password is weak");
	}

}
