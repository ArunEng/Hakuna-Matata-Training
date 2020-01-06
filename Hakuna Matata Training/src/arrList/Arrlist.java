package arrList;

import java.util.Arrays;

public class Arrlist {
	private int capacity = 10;
	private transient int size = 0;
	
	//constructor with default capacity
	public Arrlist() {

	}
	
	//constructor with initial capacity
	public Arrlist(int capacity) {
		this.capacity = capacity;
	}
	
	//element to store arrayList objects
	Object[] element = new Object[capacity];

	//get capacity
	public int getCapacity() {
		return capacity;
	}

	//return size
	public int getSize() {
		return size;
	}

	
	//adding elements to the array
	public boolean add(Object o) {
		if (size == capacity) {
			element = grow();
		}
		element[size] = o;
		size++;
		return true;
	}
	//increases size
	private Object[] grow() {
		return grow(size + 1);
	}
	
	//increases size to the new capacity
	private Object[] grow(int minCapacity) {
		
		return Arrays.copyOf(element, newCapacity(minCapacity));
	}
	
	//calculating new capacity
	private int newCapacity(int minCapacity) {
		if (minCapacity >= capacity) {
			capacity = capacity*3/2;
		}
		return capacity;
	}
	
	//getting element from array
	public Object get(int index) {
		if(index<0 || index>=size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return element[index];
	}
	
	//remove element from specified index
	public Object remove(int index) {
		if(index<0 || index>=size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Object o = element[index];
		System.arraycopy(element, index+1, element, index, size-index);
		size--;
		
		return o;
	}

}
