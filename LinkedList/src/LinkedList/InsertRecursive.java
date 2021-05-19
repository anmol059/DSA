package LinkedList;

import java.util.Scanner;

public class InsertRecursive {

	public static void print(Node<Integer> head)
	{
		Node<Integer> temp = head;
		while(temp != null)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null, tail = null;
		while(data != -1)
		{
			Node<Integer> currentNode = new Node<>(data);
			if(head == null)
			{
				head = currentNode;
				tail = currentNode;
			}
			else
			{
				tail.next = currentNode;
				tail = currentNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static Node<Integer> insertRecursive(Node<Integer> head, int pos, int data)
	{
		Node<Integer> temp = head;
		if(head == null && pos > 0)  // && pos > 0 for handling -1(list) inserting at 0th position
		{
			return head;
		}
		if(pos == 0)
		{
			Node<Integer> newNode = new Node<>(data);
			newNode.next = temp;
			return newNode;
		}
		Node<Integer> newHead = insertRecursive(temp.next, pos - 1, data);
		temp.next = newHead;
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		head = insertRecursive(head, 5, 41);
		print(head);
	}

}
