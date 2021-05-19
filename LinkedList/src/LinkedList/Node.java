package LinkedList;

public class Node<T> {
	public T data;
	public Node<T> next;
	public Node(T data)
	{
		this.data = data;
		this.next = null;
	}
	public Node() {
		this.data = null;
		this.next = null;
	}
	public Node(T data, Node next) {
		this.data = data;
		this.next = next;
	}
}
