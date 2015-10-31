package sort;

/**
 * Created by Heon on 2015-06-05.
 * 병합정렬 : 분할정복을 통한 정렬방법 배열을 가능한한 작게 분할하여 이를 병합하며 병합대상간의 대소비교를 통해 정렬한다.
 * 최악의 경우 nlogn 최선의 경우도 nlogn. 보조공간 필요 (n)
 */

public class MergeSort {

	int[] repository;

	public MergeSort(int[] arr){
		
		repository = new int[arr.length];
		
		for(int i=0; i<arr.length; i++){
			repository[i] = arr[i];
		}
//		repository = arr; // 얕은 복사로 인해 기존 배열 a 에도 영향을 미친다
	}

	public void showRepository(){
		System.out.println();
		for(int i=0; i<repository.length; i++)
			System.out.print(repository[i] + " ");
	}

	/**
	 * 1. 배열을 2개로 분할하고 각 분할된 배열의 첫번째 값부터 서로 비교해가며 임시배열로 옮기며 정렬시킨다.
	 * 2. 다 옮겨지지 못한 값들을 임시배열로 옮긴다.
	 * 3. 기존의 배열로 임시배열값을 옮긴다.
	*/

	public void Merge(int left, int mid, int right){ // 재귀
		int[] tempArr = new int[right+1]; // 정렬을 위한 임시저장소
		int tempIdx = left; // 임시저장소 idx  --> 저장은 left에 맞춰서하는데 시작을 항상 0에서 하면 읽어올 값이 없음
		int leftStart = left; // 왼쪽값 가리킬 포인터
		int leftEnd = mid; // 왼쪽배열 끝을 가리킬 포인터
		int rightStart = mid+1;; // 오른쪽값을 가리킬 포인터
		int rightEnd = right; // 왼쪽배열 끝을 가리킬  포인터

		while(leftStart <= leftEnd && rightStart <= rightEnd){
			if(repository[leftStart] <= repository[rightStart]) tempArr[tempIdx] = repository[leftStart++];
			else tempArr[tempIdx] = repository[rightStart++];
			tempIdx++;
		}

		if(leftStart > mid)
			for(int i=rightStart; i<=rightEnd; i++, tempIdx++) tempArr[tempIdx] = repository[i];
		else
			for(int i=leftStart; i<=leftEnd; i++, tempIdx++) tempArr[tempIdx] = repository[i];

		for(int i=left; i<=right; i++){
			repository[i] = tempArr[i];
		}
	}

	public void sort(int left, int right){
		if(left < right){
			int mid = (left+right)/2;
			sort(left, mid);
			sort(mid+1, right);
			Merge(left, mid, right);
		}
	}
}
