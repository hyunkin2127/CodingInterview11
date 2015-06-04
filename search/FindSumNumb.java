package search;

import java.util.HashMap;

public class FindSumNumb {

	int[] arr;

	public FindSumNumb(int[] arr) {
		this.arr=arr;
	}

	public boolean FindByBF(int k){
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				if(arr[i]+arr[j] == k){
					return true;
				}
			}
		}
		return false;
	}

	public boolean FindByHash(int k){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<arr.length; i++){
			map.put(arr[i], 1);
		}
		
		for(int i=0; i<arr.length; i++){
			if(map.containsKey(k-arr[i])){
				return true;
			}
		}
		return false;
	}
}