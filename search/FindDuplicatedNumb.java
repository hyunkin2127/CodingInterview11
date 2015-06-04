package search;

import java.util.ArrayList;
import java.util.Collections;

public class FindDuplicatedNumb {

	int[] arr;
	
	public FindDuplicatedNumb(int[] arr) {
		this.arr = arr;
	}
	
	public int[] FindByBF(){
		int[] dupNumb = null;
		
		for(int i=0; i<arr.length; i++){
			
			for(int j=i; j<arr.length; j++){
				if(i != j && arr[i] == arr[j]){
					if(dupNumb == null) {
						dupNumb = new int[2];
						dupNumb[0] = arr[i];
					}
					else {
						dupNumb[1] = arr[i];
						return dupNumb;
					}
				}
			}
		}
		return null;
	}

	public ArrayList<Integer> FindBySort(){
		ArrayList<Integer> dupNumb = new ArrayList<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int a : arr){
			al.add(a);
		}
		Collections.sort(al);
	
		for(int i=0; i<arr.length-1; i++){
			if(al.get(i+1) == al.get(i)+1){
				dupNumb.add(al.get(i));
			}
		}
		
		if(dupNumb.size() >0 ) return dupNumb;
		else return null;
	}
	
}
