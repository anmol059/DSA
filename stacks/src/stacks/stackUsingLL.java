package stacks;

import LinkedList.Node;

public class stackUsingLL<T>{
	private Node<T> head;
	private int size;
	
	stackUsingLL()
	{
		head = null;
		size = 0;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public void push(T elem)
	{
		Node<T> newNode = new Node<>(elem);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public T peek() throws stackEmptyException
	{
		if(isEmpty())
		{
			throw new stackEmptyException();
		}
		return head.data;
	}
	
	public T pop() throws stackEmptyException
	{
		if(isEmpty())
		{
			throw new stackEmptyException();
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}
