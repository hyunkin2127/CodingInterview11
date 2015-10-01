package huffmanTree;// import utilities.ChangeArrayLength ;

public class MinHeap 
{
	// data members
	ChainNode [] heap;   // array for complete binary tree
	int size;             // number of elements in heap

	// constructors
	/** create a heap with the given initial capacity
	 * @throws IllegalArgumentException when
	 * initialCapacity < 1 */
	public MinHeap(int initialCapacity)
	{
		if (initialCapacity < 1)
			throw new IllegalArgumentException
			("initialCapacity must be >= 1");
		heap = new ChainNode [initialCapacity + 1];
		size = 0;
	}

	/** create a heap with initial capacity 10 */
	public MinHeap()
	{this(10);}

	// methods
	/** @return true iff the heap is empty */
	public boolean isEmpty()
	{return size == 0;}

	/** @return number of elements in the heap */
	public int size()
	{return size;}

	/** @return maximum element
	 * @return null if the heap is empty */
	public ChainNode getMin()
	{return (size == 0) ? null : heap[1];}

	/** put theElement into the heap */
	public void put(ChainNode theElement)
	{
		// increase array size if necessary
		if (size == heap.length - 1)
			System.out.println("Heap is full. No insertion.");
		//	         heap = (Comparable []) ChangeArrayLength.changeLength1D
		//	                                    (heap, 2 * heap.length);
		else {
			// find place for theElement
			// currentNode starts at new leaf and moves up tree
			int currentNode = ++size;
			while (currentNode != 1 && heap[currentNode / 2].frequency > theElement.frequency )
			{
				// cannot put theElement in heap[currentNode]
				heap[currentNode] = heap[currentNode / 2]; // move element down
				currentNode /= 2;                          // move to parent
			}

			heap[currentNode] = theElement;
		}
	}

	/** remove max element and return it */
	public ChainNode removeMin()
	{
		// if heap is empty return null
		if (size == 0) return null;       // heap empty

		ChainNode minElement = heap[1];  // max element

		// reheapify
		ChainNode lastElement = heap[size--];

		// find place for lastElement starting at root
		int currentNode = 1,
				child = 2;     // child of currentNode
		while (child <= size)
		{
			// heap[child] should be larger child of currentNode
			if (child < size && heap[child].frequency > heap[child + 1].frequency ) child++;

			// can we put lastElement in heap[currentNode]?
			if (lastElement.frequency <= heap[child].frequency) break;   // yes

			// no
			heap[currentNode] = heap[child]; // move child up
			currentNode = child;             // move down a level
			child *= 2;
		}
		heap[currentNode] = lastElement;
		return minElement;
	}

	public String toString()
	{
		StringBuffer s = new StringBuffer(); 
		s.append("The " + size + " elements are [");
		if (size > 0)
		{// nonempty heap
			// do first element
			s.append(heap[1]);
			// do remaining elements
			for (int i = 2; i <= size; i++)
				s.append(", " + heap[i]);
		}
		s.append("]");

		return new String(s);
	}

}
