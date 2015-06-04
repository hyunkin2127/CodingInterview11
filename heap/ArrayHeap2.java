package heap;

import javax.swing.*;

/**
 * Created by Heon on 2015-06-04.
 * Heap은 배열기반으로 구현하는 것이 일반적
 *   --> 연결 리스트로 구현할 경우 새로운 노드를 마지막에 추가하는것이 쉽지 않음.
 *       힙와 같이 새로운 노드를 추가한 이후에도 완전이진트리를 유지해야하는 경우에는 배열로 구현하는 것이 일반적이다.
 *
 *  최대힙이라 가정할때 배열의 앞쪽 인덱스가 최대값인가
 *
 *  Heap의 ADT
 *   1. insert
 *   2. removeTop
 *   3. getTop
 */
public class ArrayHeap2  {
	int[] repository;
	int size;

	public ArrayHeap2(int size){
		repository =  new int[size];
		this.size = 0;
	}



	public boolean isEmpty() {
		return (size <= 0);
	}

	public boolean isFull(){
		return (repository.length <= size);
	}

	public int getTop(){
		if(isEmpty()) return -1;
		else return repository[1];
	}

	public void printHeap(){

		int idx;

		for(int i=0; i<size+1; i++){
			System.out.println(i + " // "+repository[i]);
		}
		System.out.println("================================================");

	}


	/** 힙을 최대(최소)상태를 유지하도록 힙을 정렬시킨다.
	 *  1. 루트노드부터 자식노드와 비교해 내려가면서 대소 비교를 통해 자리를 교환한다.
	 *  2. 마지막 leaf노드부터(방금추가된 노드) bottom-up방식으로 자기자리를 찾아간다.
	 */
	public void sortHeap(){ // bottom up 방식


	}

	/** 삽입과정
	 *   1. 데이터를 마지막노드(배열내 데이터가 데이터가 없는 첫번째칸)에 추가하고
	 *   2. 힙을 정렬시킨다.(해당 데이터가 위로 올라가면서 자기자리를 찾아간다.)
	 */
	public void insert(int data){

		if(isFull()) return;

		int temp;
		int idx = ++size;
		repository[idx] = data;

		while(idx>1 && repository[idx] > repository[idx/2] ){ //추가된 노드의 값이 부모노드보다 크다면
				temp = repository[idx];
				repository[idx] = repository[idx/2];
				repository[idx/2] = temp;
				idx /= 2;
			}
	}

	/** 삭제과정
	 *  1. 삭제할 노드를 마지막 leaf 노드와 교체한후, 삭제시킨다.
	 *  2. 이후 교체된 노드가 아래로 내려가면서 자기자리를 찾아간다.
	*/
	public int removeTop(){
		if(isEmpty()) return -1;

		int idx, temp, maxIdx, returnValue;
		returnValue = repository[1];

		//마지막 노드 값과 root 노드값 교체
		temp = repository[1];
		repository[1] = repository[size];
		repository[size] = temp;

		maxIdx = 1;
		idx = 1;
		size--;

		System.out.println("size : " + size + " // " + repository[1]);
		while(idx <= size){
			if(repository[idx]<repository[idx*2]){// 왼쪽 자식노드와 비교
				maxIdx = idx*2;
			}
			if(repository[maxIdx] < repository[idx*2+1]){// 오른쪽 자식노드와 비교
				maxIdx = idx*2+1;
			}
			System.out.println( "idx : " + idx +" // idxValue : "+  repository[idx] + " || maxidx : " + maxIdx + " // maxValue : " +repository[maxIdx]);
			if(idx != maxIdx){// 부모노드의 값이 최대값이 아니라면 최대값을 가진노드와 부모노드 값을 교체
				temp = repository[idx];
				repository[idx] = repository[maxIdx];
				repository[maxIdx] = temp;
				System.out.println("int if : "+repository[idx]);
				idx =	maxIdx; // 교체된 노드에서부터 다시 반복
			}
			else break; // 만약 부모노드가 최대값이면 그대로 정지
//			System.out.println( "idx : " + idx +" // idxValue : "+  repository[idx] + " || maxidx : " + maxIdx + " // maxValue : " +repository[maxIdx]);
		}
		return returnValue;
	}
}

