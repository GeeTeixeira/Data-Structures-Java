package linkedList;

import java.util.NoSuchElementException;

public class doublyLinkedList <T extends Comparable<T>> {
	node head;
	public class node {
		T data;
		node next;
		node prev;
		node(T data){
			this.data = data;
			next = null;
			prev = null;
		}
		node(T data, node next){
			this.data = data;
			this.next = next;
			prev = null;
		}
		node(T data, node next, node prev){
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		public String toString() {
			return "Data: "+ data;
		}
	}
	doublyLinkedList(){
		head = null;
	}
	doublyLinkedList(T data){
		head = new node(data);
	}
	public void insertNode(T data) {
		if(head == null) {
			head = new node(data);
			return;
		}
		node pointer = head;
		while(pointer.next != null) {
			pointer = pointer.next;
		}
		pointer.next = new node(data,null,pointer);
	}
	public boolean delete(T target) { //not working
		if(head == null) throw new NoSuchElementException("Empty list.");
		node prev = head;
		if(head.data.equals(target)) {
			head = head.next;
			head.prev = null;
			return true;
		}
		while(prev != null && !prev.data.equals(target)) {
			prev = prev.next;
		}
		if(prev.data.equals(target)) {
			prev = prev.prev;
			prev.next = prev.next.next;
			prev.next.prev = prev;
			return true;
		}
		return false;
	}
	public void printList() {
		node pointer = head;
		while(pointer != null) {
			System.out.println(pointer);
			System.out.println("Current previous: "+pointer.prev);
			System.out.println("Current next: "+pointer.next+"\n");
			pointer = pointer.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doublyLinkedList dL = new doublyLinkedList();
		dL.insertNode(3);
		dL.insertNode(5);
		dL.insertNode(9);
		dL.insertNode(10);
		dL.insertNode(2);
		dL.insertNode(1);
		dL.insertNode(7);
		System.out.println(dL.delete(10)); //delete not working
		dL.printList();

	}

}
