package LinkedList;

public class linkedlist<T> {
	private Node<T> tail;
	private Node<T> head;
	private int size;

	public linkedlist() {
		this.head = this.tail = null;
		this.size = 0;
	}

	private void handleWhenSize0(T val) {
		Node<T> newNode = new Node<>(val);
		this.head = this.tail = newNode;
		this.size++;

	}

	public void addFirst(T val) {
		if (this.size == 0) {
			handleWhenSize0(val);
		} else {
			Node<T> newNode = new Node<>(val);
			newNode.next = head;
			this.head = newNode;
			size++;
		}

	}

	public void addLast(T val) {
		if (this.size == 0) {
			handleWhenSize0(val);
		} else {
			Node<T> newNode = new Node<>(val);
			tail.next = newNode;
			this.tail = newNode;
			size++;
		}
	}

	public void addAt(T val, int indx) {
		if (indx < 0 || indx >= this.size()) {
			System.out.println("Invalid index");
		} else if (indx == 0) {
			addFirst(val);
		} else if (indx == this.size - 1) {
			addLast(val);
		} else {
			Node<T> newNode = new Node<>(val);
			Node<T> temp = this.head;
			for (int i = 0; i < indx - 1; i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
			size++;
		}
	}

	public T getFirst() {
		if (this.size() == 0) {
			System.out.println("List is empty");
			return null;
		}
		return head.data;
	}

	public T getLast() {
		if (this.size() == 0) {
			System.out.println("List is empty");
			return null;
		}
		return tail.data;
	}

	public T getAt(int indx) {
		if (indx == 0) {
			System.out.println("List is empty");
			return null;
		} else if (indx >= this.size()) {
			System.out.println("Invalid arguments");
			return null;
		}
		Node<T> temp = head;
		for (int i = 0; i < indx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	public void removeFirst() {
		if (this.size() == 0) {
			System.out.println("List is empty");
			return;
		} else {
			head = head.next;
			size--;
		}
	}

	public void removeLast() {
		if (this.size() == 0) {
			System.out.println("List is empty");
			return;
		}
		if (this.size == 1) {
			removeFirst();
			return;
		}
		Node<T> temp = head;
		for (int i = 0; i < this.size - 2; i++) {
			temp = temp.next;
		}
		temp.next = null;
		this.tail = temp;
		size--;
	}

	public void removeAt(int indx) {
		if (indx < 0 || indx >= this.size()) {
			System.out.println("Invalid arguments");
		} else if (indx == 0) {
			removeFirst();
		} else if (indx == this.size() - 1) {
			removeLast();
		} else {
			Node<T> temp = head;
			for (int i = 0; i < indx - 1; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			size--;
		}
	}

	public int size() {
		return this.size;
	}

	public void display() {
		Node<T> temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println(" null");
	}
}
