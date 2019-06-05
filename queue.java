package linkedList;

import java.util.NoSuchElementException;

public class queue <T extends Comparable<T>> {
	node head;
	public class node {
		T data;
		node next;
		node(T data){
			this.data = data;
			next = null;
		}
		public String toString() {
			return "Data: "+ data;
		}
	}
	queue(T data){
		head = new node(data);
	}
	queue(){
		head = null;
	}
	public void enqueue(T data) {
		if(head == null) {
			head = new node(data);
			return;
		}
		node pointerIter = head;
		while(pointerIter.next != null) {
			pointerIter = pointerIter.next;
		}
		pointerIter.next = new node(data);
	}
	public T dequeue() {
		if(head == null) throw new NoSuchElementException("Empty queue.");
		T data = head.data;
		if(head.next != null) head = head.next;
		else head = null;
		return data;
	}
	public void printQueue() {
		node pointerIter = head;
		while(pointerIter != null) {
			System.out.println(pointerIter);
			pointerIter = pointerIter.next;
		}
	}
	
	
	public static void main(String[] args) {
		queue myQ = new queue();
		//myQ.dequeue();
		myQ.enqueue(5);
		myQ.enqueue(9);
		myQ.enqueue(8);
		myQ.enqueue(2);
		myQ.enqueue(4);
		myQ.enqueue(3);
		myQ.printQueue();
		//myQ.dequeue();
		myQ.dequeue();
		System.out.println("-----");
		myQ.printQueue();
	}

}
