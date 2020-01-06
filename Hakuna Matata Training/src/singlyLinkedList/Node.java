package singlyLinkedList;

public class Node {
	
	Node next;
	Object data;
	
	public Node(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return this.data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public Node getNextNode() {
		return next;
	}
	
	public void setNextNode(Node next) {
		this.next = next;
	}
	
}
