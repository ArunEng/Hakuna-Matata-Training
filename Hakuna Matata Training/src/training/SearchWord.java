package training;

import java.util.Scanner;

public class SearchWord {
	final int a = 5;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// getting input
		System.out.println("Enter paragraph: ");
		String paragraph = in.nextLine();
		System.out.println("Enter word: ");
		String word = in.nextLine();
		in.close();

		// without using searching
		System.out.println("Usign normal method: " + withoutUsingSearch(paragraph, word));

		// with using searching
		System.out.println("Using KMP algorithm: " + withUsingSearch(paragraph, word));

	}

	// with using searching - Knuth-Morris-Pratt algorithm
	private static String withUsingSearch(String paragraph, String word) {
		// if pattern length > text length return "No"
		if (word.length() > paragraph.length()) {
			return "No";
		}

		int lps[] = build(word);
		for (int i = 0, j = 0; i < paragraph.length();) {

			if (paragraph.charAt(i) == word.charAt(j)) {
				i++;
				j++;
			}
			if (j == word.length()) {
				j = lps[j - 1];
				return "Yes";
			} else if (i < word.length() && paragraph.charAt(i) != word.charAt(j)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					System.out.println("hi");
					i++;
				}
			}
		}
		return "No";
	}

	// building auxiliary array for Knuth-Morris-Pratt
	private static int[] build(String word) {
		int[] lps = new int[word.length()];
		int i = 1, j = 0;
		while (i < word.length()) {
			if (word.charAt(i) == word.charAt(j)) {
				lps[i] = j + 1;
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					lps[i++] = 0;
				}
			}
		}

		return lps;
	}

	// using naive search
	private static String withoutUsingSearch(String paragraph, String word) {

		if (word.length() > paragraph.length()) {
			return "No";
		}
		for (int i = 0; i < paragraph.length(); i++) {

			if (paragraph.charAt(i) == word.charAt(0)) {

				boolean flag = false;
				for (int j = 1; j < word.length(); j++) {

					if (word.charAt(j) != paragraph.charAt(i + j)) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					return "Yes";
				}
			}
		}
		return "No";
	}

}
