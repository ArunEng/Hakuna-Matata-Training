package arrList;

public class TestRun {

	public static void main(String[] args) {
		Arrlist arr = new Arrlist(3);
		
		System.out.println(arr.getCapacity());
		for(int i=0;i<10;i++) {
			arr.add(i+1);
		}
		
		System.out.println("Size: "+arr.getSize()+" Capacity: "+arr.getCapacity());
		for(int i=0;i<arr.getSize();i++) {
			System.out.println(arr.get(i));
		}
		
		
		System.out.println("Size: "+arr.getSize()+" Capacity: "+arr.getCapacity());
		System.out.println("Last: "+arr.remove(arr.getSize()-1));
		
		for(int i=0;i<arr.getSize();i++) {
			System.out.println(arr.get(i));
		}
		
	}

}
