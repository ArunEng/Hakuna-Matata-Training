package queue;

import singlyLinkedList.SLinkedlist;

public class LinkedQueue extends SLinkedlist {
	
	public LinkedQueue() {
		super();
	}
	
	public boolean enqueue(Object o) {
		add(o);
		return true;
	}
	
	public Object dequeue() {
		return remove(0);
	}
	
	public Object element() {
		return get(0);
	}
	
	public boolean isEmpty() {
		return getSize()==0;
	}
}
