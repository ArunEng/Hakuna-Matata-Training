package stack;

class TestRun {

	public static void main(String[] args) {
		
		//stack implemented by arrayList
		ArrStack stack = new ArrStack(10);
		//pushing elements into stack
		for(int i=0;i<5;i++) {
			stack.push(i+1);
		}
		
		System.out.println("ArrayList Stack");
		//Popping elements from stack
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		//stack implemented by Singly LinkedList
		LinkedStack lStack = new LinkedStack();
		
		//pushing elements into stack
		for(int i=0;i<5;i++) {
			lStack.push(i+1);
		}
		System.out.println("LinkedList Stack");
		//popping elements from stack
		while(!lStack.isEmpty()) {
			System.out.println(lStack.pop());
		}
		
		
	}

}
