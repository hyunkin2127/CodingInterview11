package heap;

/* heap ADT??
 * 1. insert // delete // search
 * 2. heapify(min, max)
 * 3. Array, LinkedList
*/

public class ArrayHeap {

	int[] repository;
	int size;
	int last;
	boolean isMax;

	public ArrayHeap(int size, boolean isMax){
		this.size = size;
		this.isMax = isMax;
		this.last = 0;
		this.repository = new int[size];
	}

	private int getLeft(int idx){
		idx = idx * 2 + 1;
		if(idx > this.repository.length) return -1;
		else return idx;
	}

	private int getRight(int idx){
		idx = idx * 2  + 2;
		if(idx > this.repository.length) return -1;
		else return idx;
	}

	private int getParent(int idx){
		return (idx - 1) / 2 ;
	}

	private boolean isFull(){
		return (this.size == this.repository.length);
//		if(this.size == this.repository.length) return true;
//		else return false;
	}

	private void heapify(int idx){
//		 1.find max  between self, left, right
//		 2.exchange max and self
//		 3.do again recursively
		int temp;
		int left = getLeft(idx);
		int right = getRight(idx);

		int min = repository[idx];
		if(left != -1 && min >= repository[left]){
			min = left;
		}

		if(right != -1 && min >= repository[right]){
			min = right;
		}

		if(min != repository[idx]){
			temp = repository[idx];
			repository[idx] = repository[min];
			repository[min] = temp;
			heapify(min);
		}
	}

	public void insert(int data){
		if(isFull()){
			System.out.println("Heap is full");
			return;
		}
		repository[last] = data;
		if(last == 0 ) return;
		int pidx = getParent(last);

		while( pidx >= 0 && repository[pidx] >= repository[last]){
//		if(repository[pidx] >= repository[last]){
			repository[last] = repository[pidx];
			repository[pidx] = data;
//		}
		}
	}
}
