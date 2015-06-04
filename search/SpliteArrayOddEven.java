package search;

public class SpliteArrayOddEven {
	public int[] arr;
	
	public SpliteArrayOddEven(int[] arr) {
		this.arr = arr;
	}
	/* 1.BF : 배열을 칸마다 뒤져서 %2 연산을 통해 찾음
	 * 2.Sort : ??
	 * 3.Hash : ??
	 * + 정렬방법 : 숫자 크기에 상관없이 짝수를 앞쪽에 홀수를 뒤쪽에 배치할것.
	 * + 정렬조건 : 공간복잡도가 O(1)이어야 하는지 ??
	 * + 퀵정렬 응용해서 만들기
	 */
	
	public void spliteByBF(){
		int[] temp = new int[arr.length];
		int left = 0;
		int right = arr.length-1;

		for(int i=0; i<arr.length && left < right; i++){
			if(arr[i]%2 == 0) temp[left++]=arr[i];
			else temp[right--] = arr[i];
		}
		this.arr = temp;
	}
	
	public void spliteByQuick(){
		int left = 0, right = arr.length-1;
		int temp;
		
		while(left<right){
			while(arr[left]%2 == 0 && left<right) left++;
			while(arr[right]%2 == 1 && left<right) right--;
			if(left<right){
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++; right--;
			}
		}
	}
	
}
