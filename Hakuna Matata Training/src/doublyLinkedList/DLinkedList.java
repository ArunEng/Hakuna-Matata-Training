package doublyLinkedList;

public class DLinkedList {
	private int size;
	Node head;
	Node tail;

	public DLinkedList() {
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public boolean add(Object o) {
		if (head == null) {
			head = new Node(o);
			size++;
			return true;
		}
		if (tail == null) {
			tail = new Node(o);
			tail.before = head;
			head.after = tail;
			size++;
			return true;
		}
		Node newNode = new Node(o);
		tail.after = newNode;
		newNode.before = tail;
		tail = newNode;
		size++;
		return true;
	}

	public Object get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("index out of bound");
		}
		if (index == 0) {
			return head.data;
		}
		Node currentNode = head.after;
		for (int i = 1; i < index; i++) {
			currentNode = currentNode.after;
		}
		return currentNode.data;
	}

	public boolean remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("index out of bound");
		}
		if (index == 0) {
			Node currentNode = head.after;
			head.data = null;
			head = currentNode;
			size--;
			return true;
		}

		if (index == size - 1) {
			Node currentNode = tail.before;
			tail.data = null;
			tail = currentNode;
			size--;
			return true;

		}

		Node currentNode = head.after;
		for (int i = 1; i < index; i++) {
			currentNode = currentNode.after;
		}
		Node next = currentNode.after;
		Node prev = currentNode.before;
		currentNode = null;
		next.before = prev;
		prev.after = next;
		size--;
		return true;

	}
}
