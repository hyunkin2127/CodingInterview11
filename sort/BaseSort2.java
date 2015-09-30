package sort;

public class BaseSort2 {

	int[] repository;

	public BaseSort2(int[] arr){
		repository = arr;
	}

	// 1. 버블정렬 : 인접한 두개의 데이터를 비교해가면서 정렬을 행하는 방법
	// 정렬된 데이터는 정렬 범위에서 제외시킨다.
	public void bubbleSort(){ // 오름차순으로
		int temp = 0;
		boolean swapped = true;
		for(int i=0; i<repository.length-1 && swapped; i++){ // j+1 까지 검사하므로 최대 범위에서 -1
//		for(int i=repository.length -1 ; i>=0 && swapped; i--){ // 내림차순 정렬시 뒤에서 부터 앞으로 값을 가져오도록
			swapped = false;
			for(int j=0; j<repository.length-i-1; j++){ // 오름차순 정렬이므로 정렬된 값이 배열의 뒷부분에 저장됨
				if(repository[j] > repository[j+1]) //
//			for(int j=i; j<repository.length-1; j++){ // 내림차순 정렬이므로 정렬된 값이 배열의 앞부분에 저장됨
//			if(repository[j] < repository[j+1]) //
					temp = repository[j];
				repository[j] = repository[j+1];
				repository[j+1] = temp;
				swapped = true;
			}
		}
	}

	// 2. 선택정렬 : 정렬시킬 값을 선택한뒤 배열을 탐색하여 선택값의 위치에
	// 적합한 값을 찾고, 두값의 위치를 교체시키는 방법. 이를 반복하여 정렬시킴
	public void selectionSort(){ // 오름차순
		int data = -1;
		int minIdx = 0;
		int temp;

		for(int i=0; i<repository.length; i++){
//			data = repository[i]; // 정렬할 값을 선택
			data = i; // 정렬할 값을 선택
			for(int j=i+1; j<repository.length; j++){ //
//				if( data > repository[j]) minIdx = j;
				if( repository[data] > repository[j]) data = j;
			}

//			repository[i] = repository[minIdx];
//			repository[minIdx] = data;
			temp = repository[i];
			repository[i] = repository[data];
			repository[data] = temp;
		}
	}

	// 3. 삽입정렬 : 값을 밀어 내면서 정렬시키는 방법
	// 정렬시킬 값을 저장해둔채로, 자기자리를 찾아가도록함. 이때 값을 밀어내면서 자기자리를 찾는다.

	public void insertionSort(){
		int data, j; // j를 밖으로 빼놔야한다. 자바스크립트랑 스코프가 다름을 기억 할 것.
		for(int i=1; i<repository.length; i++){
			data = repository[i]; // 정렬시킬 데이터를 보관하고
			for(j=i-1; j>=0; j--){ // 정렬시킬 데이터의 앞칸에서부터 정렬위치를 찾을때까지 앞쪽으로(오름차순이므로) 배열을 탐색해감
				if(repository[j] > data) repository[j+1] = repository[j]; // 정렬할 값보다 배열값이 크다면(오름차순이므로) 뒤로 한칸씩 밀어냄
				else break; // 자기 자리 찾으면 탈출
			}
			repository[j+1] = data; // 찾은 위치에 정렬대상을 삽입
		}
	}

	public void shellSort(){
		int h = 1;
		while(h <= repository.length / 3) h = h*3+1;

		int data;
		int j;

		while(h>0){
			for(int i = h; i< repository.length; i++){
				data = repository[i];
				for(j = i-1; j>=0; j-=h){
					if(repository[j] > data) repository[j+h] = repository[j];
					else break;
				}
				repository[j] = data;
			}
			h = h/3;
		}
	}
}
