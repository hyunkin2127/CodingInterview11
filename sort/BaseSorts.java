package sort;

public class BaseSorts {

	private void Swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}


	public void  BubbleSort(int[] arr){
		boolean isSwapped = false;
		for(int i = arr.length-1; i >= 0&& isSwapped; i-- ){
			isSwapped = false;
			for(int j = 0; j<i ; j ++){
				if(arr[j] > arr[j+1]){
					Swap(arr, i, j);
					isSwapped = true;
				}
			}
		}
	}

	public void SelectionSort(int[] arr){
		int minIdx;
		for(int i = 0; i<arr.length ; i++){
			minIdx = i;
			for(int j = i+1; j<arr.length ; j++){
				if(arr[minIdx]>arr[j]){
					Swap(arr, minIdx, j);
				}
			}
		}
	}

	public void InsertionSort(int[] arr){
		int temp, j;
		for(int i = 1; i <arr.length; i++){
			temp = arr[i];
			j = i;
			while(arr[j-1] > temp && j >=1){ // 정렬 완료된 부분 진입
				arr[j] = arr[j-1];  // 정렬된부분 안에서 새로운 비교값이 자리자리를 찾아감. 한칸씩 뒤로 미루는 과정임
				j--;
			}
			arr[j] = temp; // 자리를 다찾았으면 거기에 원래 값을 삽입
		}
	}

	public int[] shellSort(int[] arr){
		int h = 1;
		while (h <= arr.length / 3){       // h 값을 크누스 간격순서에 참고하여 찾는다 
			h = h*3 + 1;
		}

		while (h > 0){                     // 삽입정렬 알고리즘과 동일한 방식
			for (int i = h ; i<arr.length; i++){  // 삽입정렬할 항목 선택
				int tmp = arr[i];         // 삽입정렬할 항목 저장
				int j = i;                // 삽입할 항목 위치에서부터 비교(오른쪽 -> 왼쪽)
				while( arr[j-h] >= tmp && j>h-1 ){
					// 삽입할 항목보다 작은 값의 항목을 찾을 때 까지 비교
					// 하위 배열내에서 비교 즉, 0, 4, 8

					arr[j] = arr[j-h];
					// 삽입할 항목보다 큰 값은 오른쪽으로 이동
					j -= h;
				}

				arr[j] = tmp;
				displayArray(arr);
				System.out.println();
			}
			h = (h-1) / 3;                // h 값을 줄인다. 
		}
		return arr;
	}

	public void displayArray(int[] arr){
		for (int i=0; i<arr.length; i++) System.out.print(arr[i] + " ");
	}

}
