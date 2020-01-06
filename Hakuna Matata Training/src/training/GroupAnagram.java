/*Input1: and dna dog god this shit what htaw re er
 * Output:  Group of anagrams: 
			this shit  - 2
			what htaw  - 2
			and dna  - 2
			dog god  - 2
			re er  - 2
 *  
 *  Input2: A paragraph is a self-contained unit of a discourse in writing dealing with a particular point or idea. A paragraph consists of one or more sentences. Though not required by the syntax of any language, paragraphs are usually an expected part of formal writing, used to organize longer prose.
 *  
 *  Output2: Group of anagrams: 
			writing writing  - 2
			prose  - 1
			syntax  - 1
			usually  - 1
			of of of of  - 4
			used  - 1
			paragraph paragraph  - 2
			are  - 1
			not  - 1
			point  - 1
			unit  - 1
			Though  - 1
			by  - 1
			part  - 1
			paragraphs  - 1
			formal  - 1
			A a a a A  - 5
			consists  - 1
			or or  - 2
			particular  - 1
			more  - 1
			in  - 1
			to  - 1
			dealing  - 1
			one  - 1
			required  - 1
			is  - 1
			idea  - 1
			organize  - 1
			self-contained  - 1
			expected  - 1
			sentences  - 1
			discourse  - 1
			any  - 1
			language  - 1
			an  - 1
			the  - 1
			longer  - 1
			with  - 1

 */
package training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GroupAnagram {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter paragraph: ");
		String paragraph = in.nextLine();
		in.close();
		HashMap<String, ArrayList<String>> anagramNumbers = new HashMap<>();
		String str = "";
		for (int i = 0; i < paragraph.length() + 1; i++) {
			if (i == paragraph.length() || paragraph.charAt(i) == ' ' || paragraph.charAt(i) == '.'
					|| paragraph.charAt(i) == ',') {

				String temp = bubbleSort(str).toLowerCase();

				if (anagramNumbers.containsKey(temp)) {
					ArrayList<String> list = anagramNumbers.get(temp);
					list.add(str);
					anagramNumbers.put(temp, list);
					str = "";

				} else {
					ArrayList<String> list = new ArrayList<>();
					list.add(str);
					anagramNumbers.put(temp, list);
					str = "";
				}
			} else {
				str += paragraph.charAt(i);
			}
		}

		// printing values
		System.out.println("Group of anagrams: ");
		for (Map.Entry<String, ArrayList<String>> a : anagramNumbers.entrySet()) {
			ArrayList<String> list = anagramNumbers.get(a.getKey());
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println(" - " + list.size());
		}

	}
	
	//sorting words in paragraph
	static String bubbleSort(String s) {
		StringBuilder str = new StringBuilder(s);

		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) >= str.charAt(j)) {
					char c = str.charAt(i);
					char c2 = str.charAt(j);
					str.setCharAt(i, c2);
					str.setCharAt(j, c);
				}
			}
		}
		return str.toString();
	}

}
