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
	public MinHeap(int initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException("initialCapacity must be >= 1");
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
	public void put(ChainNode theElement) {
		// increase array size if necessary
		if (size == heap.length - 1) System.out.println("Heap is full. No insertion.");
		else {
			int currentNode = ++size; // 기존에 저장되있던 마지막 노드 다음 자리를 새로 삽입될 노드의 자리로 할당함
			while (currentNode != 1 && heap[currentNode / 2].frequency > theElement.frequency ) {
				// 새롭게 할당된 노드와 그자리의 부모노드를 비교하여 만약 부모노드의 값이 더 크다면
				heap[currentNode] = heap[currentNode / 2]; // 부모노드의 값을 아래로 내리고
				currentNode /= 2;                          // 기존 부모노드의 부모노드를 찾아가기 위해 pointer 조정
			}
			heap[currentNode] = theElement; // 비교가 끝나고 나면(자리를 찾고나면) 해당 노드를 할당.
		}
	}

	/** remove max element and return it */
	public ChainNode removeMin() {
		if (size == 0) return null;       // heap empty

		ChainNode minElement = heap[1];  // 최소값. 힙의 헤드
		ChainNode lastElement = heap[size--]; // 힙의 마지막 노드

		// find place for lastElement starting at root
		int currentNode = 1, // 부모노드를 가리킬 포인터
							child = 2; // 자식노드를 가리킬 포인터
		while (child <= size) {
			if (child < size && heap[child].frequency > heap[child + 1].frequency ) child++;
			// 방문중인 노드에 대해 왼쪽자식과 오른쪽 자식중 어느게 더 작은 값인지 찾음.
			// 만약 왼쪽자식이 더 크면 오른쪽 자식을 비교 대상으로 설정(child++)

			if (lastElement.frequency <= heap[child].frequency) break;   // yes
			// 마지막 요소와 현재 방문중인 노드의 자식과 비교해서
			// 마지막 노드 값이 더 작으면 작업 중단

			//만약 마지막 노드값이 더 크면. 아래로 계속 비교를 해나가야 한단 뜻이므로
			heap[currentNode] = heap[child]; // 현재 방문중인 부모노드에 자식노드의 값을 할당하고
			currentNode = child;             // 부모노드를 가리키던 포인터에 자식노드 값을 넣어 기존의 자식노드를 부모노드로 변경
			child *= 2; // 자식노드를 가리키던 포인터는 기존 자식노드의 자식을 가리키도록 변경
		}
		heap[currentNode] = lastElement;
		return minElement;
	}

	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("The " + size + " elements are [");
		if (size > 0) {// nonempty heap
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
