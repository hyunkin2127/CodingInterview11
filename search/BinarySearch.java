package search;

public class BinarySearch {

	public int BSearchByIterate(int[] arr, int data){//검색할 배열 , 검색할 데이터
		int mid, low = 0;
		int high = arr.length-1;
		while(low <= high){
			mid = (low+high)/2;
			if(arr[mid] == data)	return mid;
			else if(arr[mid] < data) low = ++mid; 
			// 찾는 데이터가 mid값보다 크면 --> mid보다 오른쪽에 있으면 low를 mid 오른쪽으로 옮김
			else high = --mid; 
			// 찾는 데이터가 mid값보다 작으면 --> mid보다 왼쪽에있으면 high를 mid 왼쪽으로 옮김
		}
		return -1;
	}

	public int BSearchByRecur(int[] arr, int data, int low, int high){
		int mid = (low+high)/2;
		if(arr[mid] == data) return mid;

		else if(arr[mid]<data) BSearchByRecur(arr, data, mid, high);
		else BSearchByRecur(arr, data, low, mid-1);
		return -1;
	}
}
