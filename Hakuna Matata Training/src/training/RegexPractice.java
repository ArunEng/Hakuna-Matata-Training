package training;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter large string: ");
		String largeString = in.nextLine();
		in.close();
		Pattern pattern = Pattern.compile("(^[a-zA-Z]+)|((\\d){10})|(:?[\\w]+@[a-zA-Z]+\\.[a-z]{2,5}$)");
		Matcher matcher = pattern.matcher(largeString);
		
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
		
	}

}
