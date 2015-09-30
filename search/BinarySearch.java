package search;

public class BinarySearch {

	/**
	 * 반복을 통한 이진 검색
	 * 1. arr[mid]값의 크기에 따라서 mid를 이동시키는것. ( low , high 조정을 통해서)
	 * 2. while은 배열 전체를 훓을 수 있는 조건을 생각한다.
	*/
	public int BSearchByIterate(int[] arr, int data){//검색할 배열 , 검색할 데이터
		int mid, low = 0;
		int high = arr.length-1;
		while(low <= high){
			mid = (low+high)/2;
			if(arr[mid] == data)	return mid;
			else if(arr[mid] < data) low = ++mid;
			// 찾는 데이터가 mid값보다 크면 --> mid보다 오른쪽에 있으면 low를 mid 오른쪽으로 옮김
			// ++, -- 없어도 동작함
			else high = --mid;
			// 찾는 데이터가 mid값보다 작으면 --> mid보다 왼쪽에있으면 high를 mid 왼쪽으로 옮김
		}
		return -1;
	}

 /** 재귀방식을 통한 이진 검색
	*  1. mid값을 바깥까지 전달 할 수가 없음
	*/
	public int BSearchByRecur(int[] arr, int data, int low, int high){
		int mid = (low+high)/2;
		if(arr[mid] == data) return mid;
		else if(arr[mid]<data) BSearchByRecur(arr, data, mid+1, high);
		else BSearchByRecur(arr, data, low, mid-1);

		return -1; // 검색에는 성공하지만 가장 바깥에서 수행된 함수에는 찾지 못한것으로 전달되므로 -1을 반환함
	}
}
