import java.util.Iterator;

public class CircularLinkedList<E> implements Iterable<E> {

	
	
	// Your variables
	Node<E> head; // This is the reference to the first element
	Node<E> tail; // This is a reference to the last element
	int size;  // BE SURE TO KEEP TRACK OF THE SIZE

	
	// implement this constructor
	
	public CircularLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}

	public int size(){
		return size;
	}


	// I highly recommend using this helper method
	// Return Node<E> found at the specified index
	// be sure to handle out of bounds cases
	private Node<E> getNode(int index) {
		Node <E> current = head;
		if(index < 0 || index >= size){
			return null;
		}
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
	}


	// attach a node to the end of the list
	public boolean add(E item) {
		//System.out.println(size);
		this.add(size,item);
		return false;

	}

	
	// Cases to handle
	// out of bounds
	// adding to empty list
	// adding to front
	// adding to "end"
	// adding anywhere else
	// REMEMBER TO INCREMENT THE SIZE
	public void add(int index, E item){
		if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        Node <E> adding = new Node(item);
        if(size == 0){
            head = adding; // The new node is the new head
            tail = adding; // The new node is the new tail
			tail.next = head;
		} else if(index == 0){
			adding.next = head; // New node points to old head
			head = adding; // The new node becomes the head
			tail.next = head; // The tail points to the new head;
		} else if(index == size){
			tail.next = adding; // Old Tail points to adding
			adding.next = head; // Adding node now points to head
			tail = adding; // the tail is now adding
		} else{
			Node <E>  before = getNode(index-1); // Before points to the node
			// before the index we want to add at
			Node<E> after = before.next; // after points to the node where before pointed to
			before.next = adding; // Before now points to the new node
			adding.next = after; // the new node now points to the node after it
		}
		size++;
	}

	

	
	
	// remove must handle the following cases
	// out of bounds
	// removing the only thing in the list
	// removing the first thing in the list (need to adjust the last thing in the list to point to the beginning)
	// removing the last thing 
	// removing any other node
	// REMEMBER TO DECREMENT THE SIZE
	public E remove(int index) {
		E toReturn = null;
		if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
		if(size == 1){
			toReturn = head.item;
			head = null;
			tail = null;
		} else if(index == 0){
			toReturn = head.item;
			head = head.next;
			tail.next = head;
		} else if(index == size){
			Node <E>  before = getNode(index-1); // Before points to the node
			toReturn = before.next.item;
			// before the index we want to remove at
			tail = before; // tail now becomes that node before
			head = tail.next; // the node before now points
			// to the head skipping the tail
		} else {
			Node <E>  before = getNode(index-1);
			toReturn = before.next.item;
			before.next = before.next.next; // the index we want to remove 
			// is no longer pointed to
		}
		size--;
		System.out.println(toReturn);
		return toReturn;
	}
	
	
	
	
	// Turns your list into a string
	// Useful for debugging
	public String toString(){
		Node<E> current =  head;
		StringBuilder result = new StringBuilder();
		if(size == 0){
			return "";
		}
		if(size == 1) {
			return head.item.toString();
			
		}
		else{
			do{
				result.append(current.item);
				result.append(" ==> ");
				current = current.next;
			} while(current != head);
		}
		return result.toString();
	}
	
	
	public Iterator<E> iterator() {
		return new ListIterator<E>();
	}
	
	// provided code for different assignment
	// you should not have to change this
	// change at your own risk!
	// this class is not static because it needs the class it's inside of to survive!
	private class ListIterator<E> implements Iterator<E>{
		
		Node<E> nextItem;
		Node<E> prev;
		int index;
		
		@SuppressWarnings("unchecked")
		//Creates a new iterator that starts at the head of the list
		public ListIterator(){
			nextItem = (Node<E>) head;
			index = 0;
		}

		// returns true if there is a next node
		// this is always should return true if the list has something in it
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return size != 0;
		}
		
		// advances the iterator to the next item
		// handles wrapping around back to the head automatically for you
		public E next() {
			// TODO Auto-generated method stub
			prev =  nextItem;
			nextItem = nextItem.next;
			index =  (index + 1) % size;
			return prev.item;
	
		}
		
		// removed the last node was visted by the .next() call 
		// for example if we had just created a iterator
		// the following calls would remove the item at index 1 (the second person in the ring)
		// next() next() remove()
		public void remove() {
			int target;
			if(nextItem == head) {
				target = size - 1;
			} else{ 
				target = index - 1;
				index--;
			}
			CircularLinkedList.this.remove(target); //calls the above class
		}
		
	}
	
	// It's easiest if you keep it a singly linked list
	// SO DON'T CHANGE IT UNLESS YOU WANT TO MAKE IT HARDER
	private static class Node<E>{
		E item;
		Node<E> next;
		
		public Node(E item) {
			this.item = item;
		}
		
	}
	
	public static void main(String[] args){
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		int n = 13; // This is people
		int k = 2; // This is the "count"
		for(int i = 1; i <= n; i++){
			list.add(i);
		}
		System.out.println(list);
		Iterator <Integer> iter = list.iterator();
		while(list.size() > 1){
			for(int i = 0; i < k; i++){
				iter.next();
			}

				iter.remove();
				System.out.println(list);
		}
	}
}
