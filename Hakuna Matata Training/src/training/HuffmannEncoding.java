/*Input1: baby 
 *Output1: b 0
			a 10
			y 11
			Huffmann Code: 
				01011
 * 
 * Input2: huffmanncoding
 * Output2: a - 0111
			c - 010
			d - 1000
			u - 1011
			f - 111
			g - 1101
			h - 1100
			i - 1010
			m - 1001
			n - 00
			o - 0110
			Huffmann Encoded String: 11001011111111100101110000010011010001010001101
 */

package training;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmannEncoding {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter String: ");
		String normalString = in.nextLine();
		in.close();
		//getting unique char from string
		char[] uniqueChar = getUniqueCharacter(normalString);
		//getting unique char count from string
		int[] charCount = getCount(normalString, uniqueChar);
		
		//priority queue to store 
		PriorityQueue<Node> queue = new PriorityQueue<>(charCount.length, new NodeComparator());
		
		
		//adding all nodes to queue
		for(int i=0;i<uniqueChar.length;i++) {
			//node to store new node
			Node node = new Node();
			//assigning values to the node
			node.data = charCount[i];
			node.c = uniqueChar[i];
			node.left=null;
			node.right=null;
			
			//adding node to the queue
			queue.add(node);
		}
		
		//root node
		Node root = null;
		
		
		//adding node
		while(queue.size()>1) {
			//getting first two nodes from queue
			Node node1 = queue.peek();
			queue.poll();
			Node node2 = queue.peek();
			queue.poll();
			
			//creating new node 
			Node newNode = new Node();
			//assigning values to the node
			newNode.data = node1.data+node2.data;
			newNode.c = ' ';//this value will not print
			newNode.left=node1;
			newNode.right=node2;
			
			//changing root to new node
			root = newNode;
			//adding new node to the queue
			queue.add(newNode);	
		}
		//to store code and char value
		HashMap<Character,String> code = new HashMap<>();
		
		//generates code for individual char
		getCode(root,"",code);
		
		for(Map.Entry<Character, String> value: code.entrySet()) {
			System.out.println(value.getKey()+" - "+value.getValue());
		}
		//getting huffmann code
		String huffmannCode = getHuffmannCode(code, normalString);
		
		System.out.println("Huffmann Encoded String: "+huffmannCode);
		System.out.println("DEcode: "+getHuffmannDecode(root, huffmannCode));
		
	}
	
	//generating huffmann code
	static String getHuffmannCode(HashMap<Character,String> code, String str) {
		String huffmannCode="";
		for(int i=0;i<str.length();i++) {
			huffmannCode+=code.get(str.charAt(i));
		}
		
		return huffmannCode;
	}


	//traversing a binary tree
	static void getCode(Node root,String str,HashMap<Character,String> code) {
		if(root.left==null && root.right==null) {
			code.put(root.c, str);
			return ;
		}
		getCode(root.left, str+"0",code);
		getCode(root.right, str+"1",code);
		
	}
	
	
	//decoding from huffmann code
	static String getHuffmannDecode(Node root,String code) {
		String original = "";
		Node temp=root;
		for(int i=0;i<code.length();i++) {
			if(code.charAt(i)=='0') {
				temp=temp.left;
				if(temp.left==null && temp.right==null) {
					original+=temp.c;
					temp=root;
				}
			}else {
				temp=temp.right;
				if(temp.right==null && temp.left==null) {
					original+=temp.c;
					temp=root;
				}
			}
		}
		return original;
	}
	
	//getting unique char count
	static int[] getCount(String str,char[] c) {
		int[] charCount = new int[c.length];
		
		for(int i=0;i<str.length();i++) {
			int index = contains(c,str.charAt(i));
			charCount[index]++;
		}
		return charCount;
		
		
	}
	
	//returning index of character
	static int contains(char[]ch, char c) {
		int i;
		for(i=0;i<ch.length;i++) {
			if(c==ch[i]) {
				break;
			}
		}
		return i;
	}
	
	
	//getting unique char from string
	static char[] getUniqueCharacter(String str) {
		ArrayList<Character> uniqueChar = new ArrayList<>();
		boolean[] flag = new boolean[256];
		for(int i=0;i<str.length();i++) {
			if(!flag[str.charAt(i)]) {
				uniqueChar.add(str.charAt(i));
				flag[str.charAt(i)] = true;
			}
		}
		char[] temp = new char[uniqueChar.size()];
		for(int i=0;i<temp.length;i++) {
			temp[i] = uniqueChar.get(i);
		}
		return temp;
	}
}

//to compare nodes with respect to frequency 
class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node a, Node b) {
		return a.data-b.data;
	}
		
}

class Node {
	int data;
	char c;
	Node left;
	Node right;
	
}
