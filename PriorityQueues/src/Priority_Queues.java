import java.util.*;

public class Priority_Queues<T> {
	private ArrayList<Element<T>> heap;
	
	// basic constructor for class Priority_Queues in which we can initialize our arrayList
	public Priority_Queues()
	{
		heap = new ArrayList<>();
	}
	
	public void insert(T value, int priority)
	{
		Element<T> e = new Element<>(value, priority);
		heap.add(e);
		
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1)/2;
		
		while(childIndex > 0)
		{
			if(heap.get(childIndex).priority < heap.get(parentIndex).priority)
			{
				Element<T> temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1)/2;
			}
			else
			{
				return;
			}
		}
	}
	
	public T getMin() throws PriorityQueueException
	{
		if(heap.isEmpty())
		{
			throw new PriorityQueueException();
		}
		return heap.get(0).value;
	}
	
	public T removeMin() throws PriorityQueueException
	{
		if(heap.isEmpty())
		{
			throw new PriorityQueueException();
		}
		
		Element<T> min = heap.get(0);
		T ans = min.value;
		int parentIndex = 0;
		
		Element<T> last = heap.get(heap.size() - 1);
		heap.set(parentIndex, last);
		heap.remove(heap.size() - 1);
		
		int childIndex1 = (2 * parentIndex) + 1;
		int childIndex2 = (2 * parentIndex) + 2;
		
		while(childIndex1 < heap.size())
		{
			int minIndex = parentIndex;
			if(heap.get(childIndex1).priority < heap.get(parentIndex).priority)
			{
				minIndex = childIndex1;
			}
			
			if(childIndex2 < heap.size() && heap.get(childIndex2).priority < heap.get(minIndex).priority)
			{
				minIndex = childIndex2;
			}
			
			if(parentIndex == minIndex)
			{
				break;
			}
			
			Element<T> temp = heap.get(minIndex);
			heap.set(minIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
			parentIndex = minIndex;
			childIndex1 = (2 * parentIndex) + 1;
			childIndex2 = (2 * parentIndex) + 2;
		}
		return ans;
	}
	
	public int size()
	{
		return heap.size();
	}
	
	public boolean isEmpty()
	{
		return heap.size() == 0;
	}
}
