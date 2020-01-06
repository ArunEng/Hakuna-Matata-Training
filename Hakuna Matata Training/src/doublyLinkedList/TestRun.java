package doublyLinkedList;

public class TestRun {

	public static void main(String[] args) {
		DLinkedList dl = new DLinkedList();
		dl.add(1);
		dl.add(2);
		dl.add(3);
		dl.add(4);
		dl.add(5);
		dl.add(6);
		dl.add(7);
		dl.add(8);
		System.out.println("size: "+dl.getSize());
		dl.remove(0);
		dl.remove(dl.getSize()-1);
		dl.remove(2);
		for(int i=0;i<dl.getSize();i++) {
			System.out.println(dl.get(i));
		}
		System.out.println("tail data "+dl.tail.data);
		System.out.println("head data "+dl.head.data);
		
	}

}
