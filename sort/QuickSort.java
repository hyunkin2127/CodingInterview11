package sort;

/**
 * Created by Heon on 2015-06-05.
 * 퀵 정렬 : 피벗 값을 설정하고 low, high를 포인터로하여 배열을 훓으면서
 *  {a,b,d,f, ... } <  pivot < {c,e,h, .... } 형태로 정렬 시키는 방법 . 이를 피벗 앞뒤의 구간에 대해 각각 재귀적으로 수행하여 정렬을 완성한다
 */
public class QuickSort {

	int[] repository;

	public QuickSort(int[] arr){

		repository = new int [arr.length];
		for(int i=0; i<arr.length; i++){
			repository[i] = arr[i];
		}

//		repository = arr;
	}

	public void showRepository(){

		System.out.println();
		for(int i=0; i<repository.length; i++)
			System.out.print(repository[i] + " ");
	}

	public int partition(int left, int right){

		System.out.println(left+ "  "+ right);

		int low = left; // 배열 왼쪽부터 탐색해올 포인터
		int high = right; // 배열의 오른쪽부터 탐색해올 포인터
		int pivotValue = repository[left]; // pivot값
		int temp;

		while(low < high){ //포인터들이 겹치기 전까지
			System.out.println("in while : "+ low + "  "+high);
			while(pivotValue >= repository[low] && low < high ) low++; // 왼쪽에서부터 pivot보다 큰값을 만나면 정지
			while(pivotValue <= repository[high] && low < high) high--; // 오른쪽에서부터 pivot보다 작은값을 만나면 정지

			if(low<high){//포인터가 겹치지 않았으면, 위에서 각각 찾은 값을 교체 ( 왼쪽에는 pivot보다 작은값, 오른쪽에는 pivot보다 큰값을 위치시키는 과정)
				temp = repository[low];
				repository[low] = repository[high];
				repository[high] = temp;
			}
		}
		//여기선  low, high가 포인터
		temp = repository[left];  // 포인터가 겹치면 pivot을 자기 자리로 옮겨줌
		repository[left] = repository[high];
		repository[high] = temp;
		return high;
	}

	public void sort(int left, int right){
		if(left <= right){
			int pivot = partition(left, right);
			sort(left, pivot-1);
			sort(pivot+1, right);
		}
	}

}
