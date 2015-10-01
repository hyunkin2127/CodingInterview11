package huffmanTree;/* heap ADT??
 * 1. insert // delete // search
 * 2. heapify(min, max)
 * 3. Array, LinkedList

 */

public class ArrayHeap {

	ChainNode[] repository;
	int size;
	int last;

	public ArrayHeap(int size){
		this.size = 0;
		this.last = 0;
		this.repository = new ChainNode[size];
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
		
		System.out.println(idx +"  "+repository[idx]);
		
		
		//		 1.find max  between self, left, right
		//		 2.exchange max and self
		//		 3.do again recursively
		int left = getLeft(idx);
		int right = getRight(idx);

		int min = repository[idx].frequency;
		int minIdx = idx;
		if(left != -1 && min >= repository[left].frequency){
			min = repository[left].frequency;
			minIdx = left;
		}

		if(right != -1 && min >= repository[right].frequency){
			min = repository[right].frequency;
			minIdx = right;
		}

		if(min != repository[idx].frequency){
			ChainNode temp = repository[idx];
			repository[idx] = repository[minIdx];
			repository[minIdx] = temp;
			heapify(minIdx);  
		}
	}

	public void insert(ChainNode data){
		if(isFull()){
			System.out.println("Heap is full");
			return;
		}

		repository[last] = data;
		if(last == 0 ) return;
		int pidx = getParent(last);

		while( pidx > 0 && repository[pidx].frequency >= repository[last].frequency){
			//		if(repository[pidx] >= repository[last]){
			repository[last] = repository[pidx];
			repository[pidx] = data;
			//		}
		}
		size++;
		last++;
	}
	
	public ChainNode getMin(){
		if(size == 0) return null;
		return repository[1];
	}

	public ChainNode removeMin(){
		
		if(size == 0) return null;

		ChainNode temp = repository[1];
		repository[1] = repository[last];
		repository[last] = temp;
		
		size--;
		last--;
		
		heapify(1);
		
		return temp;
	}
}
