package sort;


public class quick {

	public int partition(int list[],int left,int right)
	{
		int pivot, temp;
		int low,high;

		low = left;
		high = right;
		pivot = list[left]; // 피봇을 무엇으로 하는 냐에 따라 정렬 속도가 달라질 수 있지 않을까?	

		while (low < high)
		{
			// 앞에서부터 피봇보다 큰 것들이 있는 지 검사한다.
			do {
				low++;
			}while ( low <= right && list[low] < pivot );

			// 뒤에서부터 피봇보다 작은 것들이 있는 지 검사한다.	
			while ( high >=left && list[high] > pivot ) {
				high--;
			}

			// 앞에서 피봇보다 큰 것과 뒤에서 피봇보다 작은 것을 교환한다.
			if ( low < high ){
				temp = list[low];
				list[low] = list[high];
				list[high] = temp;
			}
		}

		// 앞에서부터 검사한 것과 뒤에서부터 검사하는 인덱스가 교차하는 부분에 넣어준다.
		temp = list[left];
		list[left] = list[high];
		list[high] = temp;

		return high;
	}

	public void quickSort(int list[] , int left, int right)
	{
		if ( left < right)
		{
			int q = this.partition(list, left, right);
			quickSort(list, left, q-1);
			quickSort(list, q+1, right);
		}

	}

}