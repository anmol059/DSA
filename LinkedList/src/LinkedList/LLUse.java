package LinkedList;

import java.util.Scanner;

public class LLUse {
	
	public static int count(Node<Integer> head, int n)
    {
        int count = 0;
        while(head != null)
        {
            if(head.data.equals(n))
            {
                count++;
            }
            head = head.next;
        }
        return count;
    }
	
//	public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head)
//	{
//		if(head == null || head.next == null)
//		{
//			return head;
//		}
//		LinkedListNode<Integer> ans = reverse(head.next);
//		head.next.next = head;
//		head.next = null;
//		return ans;
//	}
	
	public static Node<Integer> split(Node<Integer> head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		Node<Integer> head1;
	    Node<Integer> head2;    
	    
	    Node<Integer> temp1;
	    Node<Integer> temp2;
	    
	    head1 = temp1 = head;
	    head2 = temp2 = head.next;
		
		Node<Integer> node = head.next.next;
		
		while(node != null && node.next != null)
		{
			temp1.next = node;
			temp2.next = node.next;
			
			node = node.next.next;
			
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		if(node != null)
		{
			temp1.next = node;
			temp1 = temp1.next;
		}
		temp1.next = null;
		temp2.next = null;
		
		return head1;
	}
	
	
	public static Node<Integer> clone(Node<Integer> head) {
        //Your code goes here
        Node<Integer> current = head;
        while(current != null)
        {
        	Node<Integer> next = current.next;
        	current.next = new Node<>(current.data);
        	current = current.next;
        	current.next = next;
        	current = next;
        }
        return head;
	}
	
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Node<Integer> head = takeInput();
//		head = clone(head);
//		print(head);
		
		linkedlist<Integer> list = new linkedlist<>();
        list.addLast(10);
        list.addLast(20);
        list.display();
        list.addLast(30);
        list.addFirst(9);
        list.display();
        list.addFirst(7);
        list.addLast(40);
        list.display();
        System.out.println(list.size());

        list.removeFirst();
        list.addAt(40, 2);
        list.display();

        list.removeAt(3);
        System.out.println(list.getAt(3));
        list.addLast(90);
        list.addLast(85);
        list.addLast(40);
        list.addLast(70);
        list.addLast(60);

        list.display();

        System.out.println(list.size());
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeAt(3);
        list.display();

        list.removeLast();
        list.removeLast();
        list.display();

	}
}

//10->20->null
//9->10->20->30->null
//7->9->10->20->30->40->null
//6
//9->10->40->20->30->40->null
//30
//9->10->40->30->40->90->85->40->70->60->null
//10
//30->40->90->40->70->60->null
//30->40->90->40->null

