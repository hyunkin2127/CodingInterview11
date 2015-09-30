package sort;

/**
 * Created by Heon on 2015-06-05.
 */


/** 코딩인터뷰퀘스천 P.393_Q3
 * 배열내에 최대 빈도 요소 찾기와 같은 문제
 * 1. brute-force : n^2
 * 2. 정렬을 통해 arr[i]==a[i+1]이 최대값인 값 찾기  O(n)
 * 3. hashmap에 넣기 --> map.contains결과값이 가장 큰값  O(n)
 */
public class SortQuestions {

	public int findElection(int[] arr){
		int max = 0, maxValue = 0, counter = 0;
		for(int i=0; i<arr.length ; i++){
			counter = 1;
			for(int j=1; j<arr.length; j++){
				if(arr[j] == arr[i]) counter++;
			}
			if(counter > max){
				maxValue = arr[i];
				max = counter;
			}
		}
		return maxValue;
	}



}
