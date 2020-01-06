package singlyLinkedList;

public class TestRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SLinkedlist list = new SLinkedlist();
		System.out.println(list.head);
		
		list.add("hk");
		list.add("a");
		list.add("am");
		list.add("ar");
		list.add("a");
		list.add("bas");
		list.add(null);
		list.add(null);
		list.add(1);
		System.out.println(list.getSize());
		
		list.remove(0);
		System.out.println(list.getSize());
		list.remove(3);
		System.out.println(list.getSize());
		for(int i=0;i<list.getSize();i++) {
			System.out.println(list.get(i));
		}		

	}

}
