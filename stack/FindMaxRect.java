package stack;

public class FindMaxRect{

	int[] rectArr;

	public FindMaxRect(int[] rectArr) {
		this.rectArr = rectArr;
	}

	// 배열을 한칸씩 이동할때 마다
	// 1.앞의 높이보다 높거나 같을경우 : 해당칸의 넓이, 누적넓이 + 해당칸 넓이(이전 높이로 계산한)를 비교하여 더 큰 값을 찾는다.
	// 2.앞의 높이보다 낮을경우 : 누적넓이를 저장해두고 이 칸을 기점으로 새로운 넓이를 누적시켜간다.
	public void calRect(){

		int maxArea = rectArr[0]; // 최대 넓이를 저장해 두기 위한 변수
		int maxHeight = rectArr[0];  // 1.앞의 높이보다 높거나 같을경우 에서 사용하기위한 이전 높이를 저장해둘 변수
		int maxLen = 1; // 밑변의 길이를 담기위한 변수
		int maxStart = 0; // 밑변 시작점

		int tempArea = rectArr[0]; // 임시 최대 넓이를 저장해 두기 위한 변수
		int tempHeight = rectArr[0];  // 1.앞의 높이보다 높거나 같을경우 에서 사용하기위한 이전 높이를 저장해둘 변수
		int tempLen = 1; // 밑변의 길이를 담기위한 변수
		int tempStart = 0; // 밑변 시작점

		for(int i=0; i<rectArr.length-1; i++){
			if(rectArr[i] <= rectArr[i + 1]){ // 높이비교 : 다음칸의 높이가 더 높다면
				if(tempArea + rectArr[i] <= rectArr[i+1]){ // 누적넓이 + 다음칸을 이전높이로 계산한 넓이 < 다음칸의 넓이 일때
					tempArea = rectArr[i+1]; // 임시로 다음칸의 넓이를 저장해두고
					tempHeight = rectArr[i+1];
					tempStart = i+1;
					tempLen = 1;
				}
				else{ // 만약 누적넓이가 더 크다면 임시로 저장된 넓이에 다음칸을 이전높이로 계산한 넓이를 더한다.
					tempArea += rectArr[i];
					tempLen++;
				}
				if(maxArea <= tempArea){ // 그리고 임시로 저장해둔 넓이가 최대 넓이보다 크다면 최대넓이 변수에 임시 넓이값을 저장한다.
					maxArea = tempArea;
					tempArea = 0; // 그리고 임시 넓이를 0으로 초기화
					maxHeight = tempHeight;
					maxLen = tempLen;
					maxStart = tempStart;
				}
			}// end of if(rectArr[i] <= rectArr[i + 1]){
			else{ // 만약 다음칸의 높이가 이전칸보다 낮다면
				tempArea = rectArr[i+1]; // 임시넓이에 다음칸 넓이를 담고 : 새롭게 넓이를 측정해야하기 때문에
				tempHeight = rectArr[i+1];
				tempStart = i+1;
				tempLen = 1;
			}
		}


		System.out.println("Area : " + maxArea);
		System.out.println("Height : " + maxHeight);
		System.out.println("Len : " + maxLen);
		System.out.println("Start : "+ maxStart);

	} //end of void calRect();
}// end of class
