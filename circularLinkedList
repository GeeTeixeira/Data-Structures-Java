package linkedList;

import java.util.NoSuchElementException;

public class circularLinkedList<T extends Comparable<T>> {
	T data;
	circularLinkedList next;
	circularLinkedList(T data){
		this.data = data;
		next = this;
	}
	public void insert(T newData, circularLinkedList front) {
		circularLinkedList tmpFront = front;
		circularLinkedList nextFront = front.next;
		tmpFront.next = new circularLinkedList(newData);
		tmpFront.next.next = nextFront;
	}
	public boolean delete(T target, circularLinkedList front) {
		circularLinkedList tmpFront = front;
		circularLinkedList prevFront = tmpFront;
		circularLinkedList nextFront = tmpFront.next;
		if(front == null) throw new NoSuchElementException("Empty list.");
		if(front.data.equals(target)) {
			while(!prevFront.next.equals(front)) {
				prevFront = prevFront.next;
			}
			prevFront.next = prevFront.next.next;
			return true;
		}
		while(!nextFront.equals(tmpFront) && !nextFront.data.equals(tmpFront.data)) {
			if(nextFront.data.equals(target)) {
				prevFront.next = nextFront.next;
				return true;
			}
			nextFront = nextFront.next;
		}
		return false;
	}
	public void printList(circularLinkedList front) {
		circularLinkedList tmpFront = front;
		circularLinkedList printer = front;
		do {
			System.out.println(printer.data);
			printer = printer.next;
		}while(!printer.equals(tmpFront));
	}
	public static void main(String[] args) {
		circularLinkedList front = new circularLinkedList(0);
		
		front.insert(1, front);
		front.insert(2, front);
		front.insert(5, front);
		front.printList(front);
		System.out.println("----");
		front.delete(0, front);
		//front.printList(front);

	}
}
