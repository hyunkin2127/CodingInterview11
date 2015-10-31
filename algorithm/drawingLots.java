package algorithm;

import java.util.Arrays;
import java.util.HashMap;

/** 문제해결능력 기르기 프린트 첫번째 문제
 *
 * Point : 탐색에서의 속도 개선이 필요하다 --> 이진탐색을 항상 생각하자 N -> logN으로 줄여준다.
 * 계산 식의 경우 계산 횟수를 줄일 방법을 생각하자 : 이전에 계산한 값을 재활용할 수 있다면??????
 *  ===> Memoization 적용하면 계산 횟수를 엄청나게 감소 시킬 수 있다.
 * 제비뽑기
 * Created by Heon on 2015-10-28.
 */
public class drawingLots {

	int[] repository;

	public drawingLots(int[] arr){
		repository = arr.clone();
	}

	// 1. Brute-force 기법 : 가능한 모든 경우를 다 찾아보자
	public boolean canWin1(int[] numbers, int k){
		for(int a=0; a<numbers.length; a++){
			for(int b=0; b<numbers.length; b++){
				for(int c=0; c<numbers.length; c++){
					for(int d=0; d<numbers.length; d++){
						if(numbers[a]+numbers[b]+numbers[c]+numbers[d] == k ) return true;
					}
				}
			}
		}
		return false;
	}

	// 2. 가지치기 적용 : 기본적으로 모든 경우에 대해 조사하지만
	// 조건적으로 살펴볼 필요가 없는 영역에 대해서는 배제한다.
	//  1)a>=b>=c>=d  2)number[a]>=k

	public boolean canWin2(int[] numbers, int k){

		for(int a=0; a<numbers.length; a++){
			if(numbers[a] >= k) continue;

			for(int b=0; b<numbers.length && a>=b; b++){
				if(numbers[a]+numbers[b] >= k) continue;

				for(int c=0; c<numbers.length && b>=c; c++){
					if(numbers[a]+numbers[b]+numbers[c] >= k) continue;

					for(int d=0; d<numbers.length && c>=d; d++){
						if(numbers[a]+numbers[b]+numbers[c]+numbers[d] == k ) return true;
					}
				}
			}
		}
		return false;
	}

	// 3. 가지치기 심화 : 해시 맵의 사용 // 마지막 numbers[d] 값을 해시맵을 통해 찾으면 더 빠르지 않을까??
	// 효과가 없는듯 시간이 더걸림 ;
	public boolean canWin3(int[] numbers, int k){

		// 해시맵에 삽입 O(n)
		HashMap<Integer, Integer> hm= new HashMap<Integer, Integer>();
		for(int i=0; i<numbers.length; i++)
			hm.put(numbers[i], numbers[i]);

		for(int a=0; a<numbers.length; a++){
			if(numbers[a] >= k) continue;

			for(int b=0; b<numbers.length && a>=b; b++){
				if(numbers[a]+numbers[b] >= k) continue;

				for(int c=0; c<numbers.length && b>=c; c++){
					if(numbers[a]+numbers[b]+numbers[c] >= k) continue;
					else{
						int temp = k - (numbers[a]+numbers[b]+numbers[c]);
						if(hm.containsKey(temp)) return true;
					}
				}
			}
		}
		return false;
	}


	// 4.이진 탐색 적용
	public boolean canWin4(int[] numbers, int k){
		//이진탐색을 위해 배열을 정렬해야 한다
		Arrays.sort(numbers);

		for(int a=0; a<numbers.length; a++){
			if(numbers[a] >= k) continue;

			for(int b=0; b<numbers.length && a>=b; b++){
				if(numbers[a]+numbers[b] >= k) continue;

				for(int c=0; c<numbers.length && b>=c; c++){
					if(numbers[a]+numbers[b]+numbers[c] >= k) continue;

					int remain = k - (numbers[a]+numbers[b]+numbers[c]);

					if( Arrays.binarySearch(numbers, remain) >= 0) return true;
				}
			}
		}
		return false;
	}

	public boolean canWin5(int[] numbers, int k){
//		Arrays.sort(numbers);
		int[] sums = new int[numbers.length*(numbers.length+1)/2];
		int idx = 0;

		for(int i=0; i<numbers.length; i++){
			for(int j=i; j<numbers.length; j++){
				sums[idx++] = numbers[i] + numbers[j];
			}
		}
		Arrays.sort(sums);

		for(int i=0; i<sums.length; i++){
			if(Arrays.binarySearch(sums, k-sums[i]) >= 0) return true;
		}
		return false;
	}

}
