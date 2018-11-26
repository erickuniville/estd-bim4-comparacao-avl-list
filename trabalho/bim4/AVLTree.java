package trabalho.bim4;

import arvore.common.Node;

public class AVLTree<T extends Comparable<T>>
{
	private Node<T> root;
	private int operation = 0;

	public Node<T> getRoot() 
	{
		return root;
	}

	public void setRoot(Node<T> root) 
	{
		this.root = root;
	}

	private Node<T> leftRotation(Node<T> node)
	{
		Node<T> parent = node.getParent();
		Node<T> right = node.getRight();
		
		node.setRight(right.getLeft());
		node.setParent(right);
		
		right.setLeft(node);
		right.setParent(parent);
		
		if (parent == null)
		{
			root = right;
		}
		else
		{
			if (right.getValue().compareTo(parent.getValue()) < 0)
			{
				parent.setLeft(right);
			}
			else
			{
				parent.setRight(right);
			}
		}
		
		return right;
	}

	private Node<T> rightRotation(Node<T> node)
	{
		Node<T> parent = node.getParent();
		Node<T> left = node.getLeft();
		
		node.setLeft(left.getRight());
		node.setParent(left);
		
		left.setRight(node);
		left.setParent(parent);
		
		if (parent == null)
		{
			root = left;
		}
		else
		{
			if (left.getValue().compareTo(parent.getValue()) < 0)
			{
				parent.setLeft(left);
			}
			else
			{
				parent.setRight(left);
			}
		}
		
		return left;
	}

	private Node<T> leftRightRotation(Node<T> node)
	{
		node.setLeft(leftRotation(node.getLeft()));
		return rightRotation(node);
	}

	private Node<T> rightLeftRotation(Node<T> node)
	{
		node.setRight(rightRotation(node.getRight()));
		return leftRotation(node);
	}

	private int balanceFactor(Node<T> node) {
		int left = 0, right = 0;
		
		if (node.getLeft() != null)
		{
			left = height(node.getLeft()) + 1;
		}
		
		if (node.getRight() != null)
		{
			right = height(node.getRight()) + 1;
		}
			
		return left - right;
	}

	private int height(Node<T> node) {
		int left = 0, right = 0;
		
		if (node.getLeft() != null)
		{
			left = height(node.getLeft()) + 1;
		}
		
		if (node.getRight() != null)
		{
			right = height(node.getRight()) + 1;
		}
		
		return left > right ? left : right;
	}
	
	private void verifyBalanceFactor(Node<T> node)
	{
		if (node != null)
		{
			doBalance(node);
			verifyBalanceFactor(node.getParent());
		}
	}
	
	public void doBalance(Node<T> node)
	{
		int balanceFactor = balanceFactor(node);
		
		if (balanceFactor < -1)
		{
			if (balanceFactor(node.getRight()) < 0)
			{
				leftRotation(node);
			}
			else
			{
				rightLeftRotation(node);
			}
		}
		else
		{
			if (balanceFactor > 1)
			{
				if (balanceFactor(node.getLeft()) > 0)
				{
					rightRotation(node);
				}
				else
				{
					leftRightRotation(node);
				}
			}
		}
	}
	
	public int add(T value) {
		operation = 1;

		if (root == null) {
			root = new Node<>(value);
		} else {
			add(root, value);
		}

		return operation;
	}

	private void add(Node<T> node, T value) {	
		operation++;
		if (value.compareTo(root.getValue()) == 0) {
			root = null;
		} else {
			operation++;
			if (value.compareTo(node.getValue()) > 0) {
				operation++;
				if (node.getRight() == null) {
					Node<T> rightNode = new Node<>();
					rightNode.setValue(value);
					node.setRight(rightNode);
					rightNode.setParent(node);
					verifyBalanceFactor(rightNode);
				} else {
					add(node.getRight(), value);
				}
			} else {
				operation++;
				if (node.getLeft() == null) {
					Node<T> leftNode = new Node<>();
					leftNode.setValue(value);
					node.setLeft(leftNode);
					leftNode.setParent(node);
					verifyBalanceFactor(leftNode);
				} else {
					add(node.getLeft(), value);
				}
			}
		} 
	}
	
	public int find(T value) {
		operation = 0;
		find(root, value);
		return operation;
	}
	
	private Node<T> find(Node<T> node, T value) {
		operation++;
		if (value.compareTo(node.getValue()) > 0) {
			return find(node.getRight(), value);
		} else {
			operation++;
			if (value.compareTo(node.getValue()) < 0) {
				return find(node.getLeft(), value);
			} else {
				return node;
			}
		}
	}
}
