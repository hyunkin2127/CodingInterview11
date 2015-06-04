package dynamicProblems;

public class FindMaxSum {
	
	//1.전수조사 : for 2중첩을 통해서 전부 비교

	int[] rep;

	public FindMaxSum(int[] a) {
		this.rep = a;
	}


	public void findSection(){
		
		int max=Integer.MIN_VALUE;
		int temp;
		int start = 0;
		int end = 0;
		
		for(int i=0 ; i<rep.length; i++){
			temp = rep[i];
			for(int j=i+1; j<rep.length; j++){
				temp+=rep[j];
				if(temp >= max) {
//					int [] a ={10,-14,5,-2,7,-5,15,-9,25};
					System.out.println("in if: "+temp+" "+i+" "+j);
					max = temp;
					start = i;
					end =j;
				}
			}
		}
		System.out.println(max+" "+start+" "+end);
	}

	public void findSection2(){
		int max = 0, temp = 0;
		for(int i=0; i<rep.length; i++){
			temp += rep[i];
			if(temp <0){// 합이 음수이면 앞에서 더한걸 버리고 새로 더하기 시작함 
				temp = 0; //문제는 만약 진짜 결과가 음수일 경우 찾을수 없다.
				continue;
			}
			if(max < temp) max =temp;
		}
		System.out.println(max);
	}

	public void findSection3(){
		int[] m = new int[rep.length];
		int maxSum =0;
		
		if(rep[0] >0) m[0] = rep[0];
		else m[0] = 0;
		for(int i=1; i<rep.length; i++){
			if(m[i-1]+rep[i]>0) m[i] = m[i-1]+rep[i];
			else m[i]=0;
		}
		
		for(int i=0; i<rep.length;i++) 
			if(m[i] > maxSum) maxSum = m[i];
		System.out.println(maxSum);
	}
	
	
	
}
