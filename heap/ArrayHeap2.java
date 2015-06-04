package heap;

import javax.swing.*;

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


	public void sortHeap(){ // bottom up 방식


	}

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

