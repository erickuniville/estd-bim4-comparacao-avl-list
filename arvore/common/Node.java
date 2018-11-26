package arvore.common;

public class Node<T>
{
	private T value;
	private Node<T> parent;
	private Node<T> left;
	private Node<T> right;
	
	public Node()
	{
		
	}
	
	public Node(T value)
	{
		this.value = value;
	}
	
	public T getValue() 
	{
		return value;
	}
	
	public void setValue(T value) 
	{
		this.value = value;
	}
	
	public Node<T> getParent() 
	{
		return parent;
	}
	
	public void setParent(Node<T> parent) 
	{
		this.parent = parent;
	}
	
	public Node<T> getLeft() 
	{
		return left;
	}
	
	public void setLeft(Node<T> left) 
	{
		this.left = left;
	}
	
	public Node<T> getRight() 
	{
		return right;
	}
	
	public void setRight(Node<T> right) 
	{
		this.right = right;
	}
}
