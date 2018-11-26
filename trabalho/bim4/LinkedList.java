package trabalho.bim4;

public class LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int operation = 0;

	public int add(T o) {
		operation = 0;
		
		Node<T> newNode = new Node<>(null, o);
		
		operation++;
		if (this.isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		
		tail = newNode;
		
		return operation;
	}

	public boolean isEmpty() {
		return tail == null;
	}
	
	public int find(T value) {
		boolean isFirstTime = true;
		Node<T> aux = head;
		operation = 1;
		
		while (aux != null) {
			if (isFirstTime) {
				operation++;
				isFirstTime = false;
			} else {
				operation += 2;	
			}
			
			if (aux.value.equals(value)) {
				break;
			}
			
			aux = aux.next;
		}
		 
		 return operation;
	}
}
