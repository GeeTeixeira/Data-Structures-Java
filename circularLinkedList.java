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
	public circularLinkedList delete(T target, circularLinkedList front) {
		circularLinkedList tmpPrev = front;
		circularLinkedList frontMark = front;
		
		if(tmpPrev == null) throw new NoSuchElementException("Empty list.");
		circularLinkedList tmpFront = front.next;
		while(tmpFront.data != target && tmpFront != frontMark) {
			tmpPrev = tmpFront;
			tmpFront = tmpFront.next;
		}
		if(tmpFront.data == target) {
			tmpPrev.next = tmpFront.next;
			return tmpPrev;
		}
		return front;
	}
	public static void printList(circularLinkedList front) {
		circularLinkedList tmpFront = front;
		circularLinkedList printer = front;
		if(tmpFront == null) throw new NoSuchElementException("Empty list.");
		do {
			System.out.println("Printer: "+printer.data);
			//System.out.println("Front: "+front.data+"\n");
			printer = printer.next;
		}while(!printer.data.equals(front.data));
	}
	/*public static void main(String[] args) {
		circularLinkedList front = new circularLinkedList(0);

		front.insert(1, front);
		front.insert(2, front);
		front.insert(5, front);
		front.printList(front);
		System.out.println("----");
		front = front.delete(0, front);
		front.printList(front);

	}*/
}
