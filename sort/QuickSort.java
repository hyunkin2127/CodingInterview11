package sort;

public class QuickSort {

	public void QuickSort(int[] arr, int low, int high){
		int pivot;
		if(high > low){
			pivot =  Partition(arr, low, high);
			QuickSort(arr, low, pivot-1);
			QuickSort(arr, pivot+1, high);
		}
	}

	public int Partition(int[] arr, int low, int high){
		System.out.println(arr);
		int temp, left, right, pivotValue = arr[low];
		left = low;
		right = high;
		
		while(left < right){
			while(arr[left] < pivotValue){
				left++;
			}
			while(arr[right] > pivotValue){
				right--;
			}
			
			if(left < right){
				temp = left;
				left = right;
				right = temp;
			}
		}
		
		arr[low] = arr[right];
		arr[right] = pivotValue;
		return right;
		
	}

}
