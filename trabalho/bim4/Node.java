package trabalho.bim4;

public class Node<T> {
	Node<T> next;
	T value;
	
	public Node (Node<T> el, T o) {
		next = el;
		value = o;
	}
}
