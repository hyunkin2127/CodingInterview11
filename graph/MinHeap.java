package graph;

public class MinHeap
{
	Node [] heap;   // array for complete binary tree
	int size;          // number of elements in heap

	public MinHeap(int initialCapacity)
	{    if (initialCapacity < 1)
		throw new IllegalArgumentException("initialCapacity must be >= 1");
		heap = new Node [initialCapacity + 1];
		size = 0;
	}

	public boolean isEmpty()
	{return size == 0;}

	public int size()
	{return size;}

	public Node getMin()
	{return (size == 0) ? null : heap[1];}

	public void put(Node node)
	{   if (size == heap.length - 1)
		System.out.println("Heap is full. No insertion.");
	else {
		int currentNode = ++size;
		while (currentNode != 1 && heap[currentNode / 2].bcost > node.bcost)
		{
			heap[currentNode] = heap[currentNode / 2];
			currentNode /= 2;
		}
		heap[currentNode] = node;
	}
	}

	public Node removeMin()
	{
		// if heap is empty return null
		if (size == 0) return null ;      // heap empty

		Node minNode = heap[1];  // min node
		Node lastNode = heap[size--];

		// find place for lastElement starting at root
		int currentNode = 1,
						child = 2;     // child of currentNode
		while (child <= size)
		{
			// heap[child] should be larger child of currentNode
			if (child < size && heap[child].bcost > heap[child+1].bcost) child++;

			// can we put lastElement in heap[currentNode]?
			if (lastNode.bcost <= heap[child].bcost)
				break;


			heap[currentNode] = heap[child]; // move child up
			currentNode = child;             // move down a level
			child *= 2;
		}
		heap[currentNode] = lastNode;
		return minNode;
	}

	/* public String toString(){
			StringBuffer s = new StringBuffer();
			s.append("The " + size + " elements are \n");
			if (size > 0)
			{  // nonempty heap
				// do first element
					 s.append(heap[1].alpha +" : "+heap[1].frequency+"\n");
				// do remaining elements
			for (int i = 2; i <= size i++)
				 s.append(heap[i].alpha +" : "+heap[i].frequency+"\n");
			}

			return new String(s);
		}*/

}
