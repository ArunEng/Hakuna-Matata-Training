/*
 * Stack data structure implemented by singly linkedlist
 */

package stack;

import singlyLinkedList.SLinkedlist;

public class LinkedStack extends SLinkedlist {
	
	//no-arg constructor
	public LinkedStack() {
		super();
	}
	
	public boolean push(Object o) {
		add(o);
		return true;
	}
	
	public Object pop() {
		return remove(getSize()-1);
	}
	
	public Object peek() {
		return get(getSize()-1);
	}
	
	public boolean isEmpty() {
		return getSize()==0;
	}
	
}
