package stacks;

public class stackUsingArrays {
	
	private int data[];
	private int topIndex = -1;
	
	stackUsingArrays()
	{
		data = new int[10];
	}
	
	public void push(int elem)
	{
		if(topIndex == data.length - 1)
		{
			doubleCapacity();
		}
		topIndex++;
		data[topIndex] = elem;
	}
	
	private void doubleCapacity() {
		int temp[] = data;
		data = new int[2 * temp.length];
		for(int i = 0; i < temp.length; i++)
		{
			data[i] = temp[i];
		}
	}	

	public int pop() throws stackEmptyException
	{
		if(isEmpty())
		{
			throw new stackEmptyException();
		}
		int temp = data[topIndex];
		topIndex--;
		return temp;
	}
	
	public int top() throws stackEmptyException
	{
		if(isEmpty())
		{
			throw new stackEmptyException();
		}
		return data[topIndex];
		
	}

	public int size()
	{
		return topIndex + 1;
	}
	
	public boolean isEmpty()
	{
		return topIndex == -1;
	}
	
	public void display() {
		System.out.print("[");
		int i = 0;
		for(; i < size() - 1; i++) {
			System.out.print(data[i] + ", ");
		}
		System.out.print(data[i]);
		if(i >= 0) {
			System.out.println("]");
		}
	}
}
