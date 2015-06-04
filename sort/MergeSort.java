package sort;

public class MergeSort {

	public void MergeSort(int[] arr, int left, int right){
		int mid;
		
		if(left < right){
			mid = (left + right)/2;
			MergeSort(arr, left, mid);
			MergeSort(arr, mid+1, right);
			Merge(arr, left, mid+1, right);
		}
	}

	public void Merge(int[] arr, int left, int mid, int right){
		int[] temp = new int[arr.length];
		int leftEnd = mid-1;
		int rightStart = mid;
		int tempIdx = left;
		while(left <= leftEnd && rightStart <= right){
			if(arr[left] <= arr[rightStart]) {
//				temp[tempIdx++] = arr[left++];
				temp[tempIdx] = arr[left];
				left++;
				System.out.println("Int 1 : "+temp[tempIdx] + " // arr : " + arr[left]);
			}
			else	{
//				temp[tempIdx++] = arr[rightStart++];
				temp[tempIdx] = arr[rightStart];
				rightStart++;
				System.out.println("Int 2 : "+temp[tempIdx] + " // arr : " + arr[rightStart]);
			}
			tempIdx++;
//			System.out.println("Temp :" + tempIdx + " // left : "+ left + " // right : "+rightStart);
		}
		System.out.println("tempIdx1 : "+tempIdx);
		while(left <= leftEnd) {
			temp[tempIdx++] = arr[left++];
//			temp[tempIdx] = arr[left];
//			tempIdx++; left++;
		}
		System.out.println("tempIdx2 : "+tempIdx);
		while(rightStart <= right) {
			temp[tempIdx++] = arr[rightStart++];
//			temp[tempIdx] = arr[rightStart];
//			tempIdx++; rightStart++;
		}
		System.out.println("tempIdx3 : "+tempIdx);

		
		arr = temp;
		for(int t : arr){
			System.out.println(t);
		}
	}
}
