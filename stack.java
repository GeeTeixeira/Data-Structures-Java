package linkedList;

import java.util.NoSuchElementException;

import linkedList.queue.node;

	public class stack <T extends Comparable<T>> {
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
	stack(){
		head = null;
	}
	stack(T data){
		head = new node(data);
	}
	public void push(T data) {
		if(head == null) {
			head = new node(data);
			return;
		}
		node temp = new node(data);
		temp.next = head;
		head = temp;
	}
	public T pop() {
		if(head == null) throw new NoSuchElementException("Empty stack.");
		node pointer = head;
		T data = head.data;
		head = head.next;
		return data;
		
	}
	public void printStack() {
		node pointerIter = head;
		while(pointerIter != null) {
			System.out.println(pointerIter);
			pointerIter = pointerIter.next;
		}
	}
	public static void main(String[] args) {
		stack myStack = new stack();
		myStack.push(5);
		myStack.push(9);
		myStack.push(8);
		myStack.push(2);
		myStack.push(4);
		myStack.push(3);
		myStack.printStack();
		myStack.pop();
		System.out.println("-----");
		myStack.printStack();
	}

}
