package singlyLinkedList;

public class SLinkedlist {
	
	int size;
	Node head;
	
	public SLinkedlist(){
		size=0;
	}
	
	public boolean add(Object o) {
		
		if(head==null) {
			head = new Node(o);
			size++;
			return true;
		}
		Node currentNode = head;
		while(currentNode.getNextNode()!=null) {
			currentNode = currentNode.getNextNode();
		}
		Node newNode = new Node(o);
		currentNode.setNextNode(newNode);
		size++;
		return true;
	}
	
	public Object remove(int index) {
		Object o ;
		if(index<0 || index>=size) {
			return false;			
		}
		
		if(index==0) {
			o=head.getData();
			head = head.getNextNode();
			size--;
			return o;
		}
		Node currentNode = head;
		for(int i=0;i<index-1;i++) {
			currentNode = currentNode.getNextNode();
		}
		o = currentNode.getNextNode().getData();
		currentNode.setNextNode(currentNode.getNextNode().getNextNode());
		size--;
		return o;
	}
	
	
	public Object get(int index) {
		if(index<0 || index>=size) {
			throw new ArrayIndexOutOfBoundsException("inde out of bound");
		}
		
		if(index==0) {
			return head.data;
		}
		Node currentNode = head.getNextNode();
		for(int i=1;i<index;i++) {
			currentNode = currentNode.getNextNode();
		}
		return currentNode.data;
		
		
	}
	
	public int getSize() {
		return size;
	}
	
}
