package linkedList;

import java.util.NoSuchElementException;

public class linkedList<T extends Comparable<T>>{
	T data;
	linkedList next;
		
	linkedList(T data){
		this.data = data;
		next = null;
	}
	//Getters
	public T getData() {
		return data;
	}
	public linkedList getNext() {
		return next;
	}
	/**
	 * Insert new element at the end of list. Throws exception if list is null.
	 * @param newData
	 */
	public void insert(T newData) {
		linkedList<T> temp = this;
		if(temp == null) throw new NoSuchElementException("Empty list.");
		
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = new linkedList(newData);
	}
	/**
	 * Accepts the target and the list
	 * @param target
	 * @param front
	 * @return
	 */
	public linkedList<T> delete(T target, linkedList<T> front) {
		if (front == null) {
			throw new IllegalArgumentException("target not found");
		}
		if (front.data.equals(target)) {
			return front.next;
		}
		
		linkedList<T> prev = front;
		linkedList<T> crnt = front.next;
		while (crnt.next != null && !crnt.data.equals(target)) {
			prev = crnt;
			crnt = crnt.next;
		}
		
		if(crnt.data.equals(target)) prev.next = crnt.next;
		return front;
	}
	/**
	 * This method finds whether an element belongs to the list. Returns true or false.
	 * @param target
	 * @return
	 */
	public boolean findNode(T target) {
		linkedList<T> temp = this;
		if(temp == null) throw new NoSuchElementException("Empty list.");
		while(temp.next != null) {
			if(temp.data.equals(target)) return true;
			temp = temp.next;
		}
		return false;
	}
	public void printList() {
		linkedList<T> temp = this;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	/**
	 * This method iterates through the list and find the i-th element in the list
	 * Returns either the i-th element or null
	 * @param i
	 * @return
	 */
	public T findIthNode(int i) throws NoSuchElementException {
		linkedList<T> temp = this;
		if(temp == null) throw new NoSuchElementException("Empty list.");
		int n = 1;
		while(temp.next != null) {
			if(n == i) return temp.data;
			temp = temp.next;
			n++;
		}
			return null;
		}
	
	public static void main(String[] args) {
		//linkedList linkedListTest = new linkedList<Integer>(1);
		int a = 0;
		linkedList<Integer> test = new linkedList<Integer>(a);
		//test.insert(0);
		//test.printList();
		//System.out.println("lala ");
		//test = test.delete(5, test);
		test.insert(1);
		test.insert(2);
		test.insert(3);
		//test.printList();
		//System.out.println("lala ");
		//test = test.delete(2, test);
		//test = test.delete(2, test);
		test.printList();
		System.out.println(test.findNode(2));
	}

}
