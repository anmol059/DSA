package LinkedList;

//public class DoubleNode<T> {
//	Node<T> head;
//	Node<T> tail;
//	DoubleNode()
//	{
//		
//	}
//	DoubleNode(Node<T> head, Node<T> tail)
//	{
//		this.head = head;
//		this.tail = tail;
//	}
//}

public class DoubleNode<T> {
	T data;
	Node<T> prev;
	Node<T> next;
	DoubleNode(T data)
	{
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}
