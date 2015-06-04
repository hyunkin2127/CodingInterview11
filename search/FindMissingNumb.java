package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FindMissingNumb {

	int[] arr;

	public FindMissingNumb(int[] arr) {
		this.arr = arr;

	}

	public int findNumbByBF(){//1. 전수조사
		int i=0, j=0;
		boolean exist;
		for(i=1; i<=arr.length;i++){
			exist=false;
			for(j=0; j<arr.length; j++){
				if(arr[j] == i)	exist = true;
			}
			if(!exist)	return i;
		}
		return -1;
	};

	public int findNumbBySort(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int a : arr){
			al.add(a);
		}
		Collections.sort(al);
		for(int i=0; i<arr.length-1; i++){
			if(al.get(i+1) != al.get(i)+1) return al.get(i)+1;
		}
		return -1;
	}

	public int findNumbByHash(){

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length; i++){
			map.put(arr[i], 1); // 숫자가 담긴 배열을 HashMap에 전부 넣고
		}

		for(int j=1; j<=arr.length; j++){ // 1 ~ n 까지 순차적으로 포함되어있는가를 확인
			if(!map.containsKey(j)) return j;
		}
		return -1;
	}
}

