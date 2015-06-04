package algorithm;

import java.util.ArrayList;

public class KnapsackProblem {

	ArrayList<Order> list;

	public KnapsackProblem(ArrayList<Order> list) {
		this.list = list;
	}

	/**
	 *  문제는
	 *  1. 박스에 담았을때 부피나 무게가 큰 물품이 쪼개지는 상황의 발생 가능성
	 *  2. 박스에 어느걸 얼만큼 넣을지를 결정하는것
	 *
	 *	1) 무게당 비용*부피당 비용 계산해서  가장 작은값의 박스를 많이 사용하는 방식으로 
	 *		---> 그러면 어느박스에 어떤 상품이 몇개씩 들어가는가는 어떻게 결정할 것인가 
	 *    ---> 무게의 총합을 구해서 박스를 추가할때마다 총 무게에서 빼는 방식
	 *
	 *	2) 우선 부피 무시하고 무게당 비용으로만 계산해서 한번 보자
	 *	3) 무게와 부피를 둘다 고려하여 둘중에 더 많은 박스를 요구하는것을 선택(무게우선, 부피우선)하여 박스 수를 결정하고
	 *		 가성비가 좋은 박스를 많이 사용하는쪽으로 해야할것 같은데....
	 *			--> 문제는 작은 박스가 가성비가 좋을 경우 해당박스보다 큰상품은 담을 수 없게 되는 상황이 발생 가능
	 *
	 * 2. 문제점
	 * 	1) 무게의 총합을 구해서 박스를 추가할때마다 총 무게에서 빼는 방식을 사용하면 
	 *		 무게가 큰 물품의 경우 쪼개어 넣어야 하는 상황이 발생할 가능성이 있음.
	 *		 --> 물품으로 나누는것이 아니라 무게를 임의로 나누기때문에. 부피의 경우도 마찬가지. 
	 */

	//부피 무시하고 무게만 
	public void findCost(){
		Box small = new Box(7, 15, 1000);
		Box middle = new Box(13, 25, 2500);
		Box large = new Box(23, 50, 4500);

		float[] boxRatio = new float[3];

		boxRatio[0] = small.cost / small.weight;
		boxRatio[1] = middle.cost / middle.weight;
		boxRatio[2] = large.cost / large.weight;

		int[] weightSum = new int[list.size()+1];

		for(int i=0; i<list.size(); i++){
			weightSum[i] = list.get(i).type.weight * list.get(i).count;
			weightSum[weightSum.length] += weightSum[i];
		}
	}
}
