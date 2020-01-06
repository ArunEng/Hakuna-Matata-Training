/*
 * Stack data structure implemented by arraylist
 */

package stack;

import arrList.Arrlist;

public class ArrStack extends Arrlist{

	public ArrStack() {
	}
	
	//stack with capacity
	public ArrStack(int capacity) {
		super(capacity);
	}
	
	public boolean push(Object o){
		
		return add(o);
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

