package queues;

public class queueUsingArrays {
	private int front;
	private int rear;
	private int data[];
	private int size;
	
	public queueUsingArrays()
	{
		front = -1;
		rear = -1;
		data = new int[5];
	}
	
	public queueUsingArrays(int length)
	{
		front = -1;
		rear = -1;
		data = new int[length];
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public int size()
	{
		return size;
	}
	
//	public void enqueue (int elem) throws queueFull
//	{
//	if(size == data.length)
//	{
//		throw new queueFull();
//	}
//		if(size == 0)
//		{
//			front = 0;
//		}
//		rear++;
//		data[rear] = elem;
//		size++;
//	}
	
	public void enqueue(int elem) 
	{
		if(size == data.length)
		{
//			throw new queueFull();
			doubleCapacity();
		}
		if(size == 0)
		{
			front = 0;
		}
		rear = (rear + 1) % data.length;
		data[rear] = elem;
		size++;
	}
	
private void doubleCapacity() 
{
	int temp[] = data;
	data = new int[2 * temp.length];
	int index = 0;
	for(int i = 0; i < temp.length; i++)
	{
		data[index++] = temp[i];
	}
	for(int i = 0; i < front - 1; i++)
	{
		data[index++] = temp[i];
	}
	front = 0;
	rear = temp.length - 1;
}

//	public int dequeue() throws queueEmpty
//	{
//		if(size == 0)
//		{
//			throw new queueEmpty();
//		}
//		int temp = data[front];
//		front++;
//		size--;
//		if(size == 0)
//		{
//			front = -1;
//			rear = -1;
//		}
//		return temp;
//	}
	
	public int dequeue() throws queueEmpty
	{
		if(size == 0)
		{
			throw new queueEmpty();
		}
		int temp = data[front];
		front = (front + 1) % data.length;
		size--;
		if(size == 0)
		{
			front = -1;
			rear = -1;
		}
		return temp;
	}
	
	public int front() throws queueEmpty
	{
		if(size == 0)
		{
			throw new queueEmpty();
		}
		return data[front];
	}
	
}
