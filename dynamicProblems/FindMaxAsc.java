package dynamicProblems;

public class FindMaxAsc {

	
	int[] rep;

	public FindMaxAsc(int[] rep) {
		this.rep = rep;
	}
	
	
	public void findAsc(){
		//1. for 2중첩
		int start = 0, end = 0, max = 0, len=0;
		
		for(int i=0; i<rep.length; i+=len){
//			System.out.println(len);
			len = 1;
			for(int j=i; j<=rep.length-1; j++){
				if(j < rep.length-1 && rep[j] <= rep[j+1] ){ 
					// 배열이 오름차순으로 정렬된 상태에서 끝날경우 이를 반영하지 못하는 상황이 발생.
					// 이를 해결하기 위해서 for문에서 j범위를 배열 끝까지로 바꾸고 if문에서 범위를 제한함
					System.out.println(i +" // " + j + " // " + rep[j] + " // " + rep[j+1] + " // " + len );
					len++;
				}
				else{
					if(len > max){
						max = len;
						start = i;
						end = j;
					}
					break;
				}
			}
		}
		System.out.println(start+" // "+ end);
		
	}
}
