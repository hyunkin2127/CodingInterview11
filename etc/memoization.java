package etc;

import java.util.Arrays;

/**
 * Created by Heon on 2015-06-24.
 */
public class memoization {

	final	int NOT_VALID = -1;
	int[] arr;
	public int cnt1 = 0;
	public int cnt2 = 0;

	public memoization(int len){
		arr = new int[len];
		Arrays.fill(arr, NOT_VALID);
		arr[0] = 0;
		arr[1] = 1;
	}

	public int memoziedFib(int n){
		cnt1++;
		if(arr[n] != NOT_VALID) return arr[n];
		else arr[n] = memoziedFib(n - 1) + memoziedFib(n - 2);
		return arr[n];
	}

	public int normalFib(int n){
		cnt2++;
		return n<2 ? n: normalFib(n - 1) + normalFib(n - 2);
	}



}