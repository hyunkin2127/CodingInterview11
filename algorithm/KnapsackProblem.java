package algorithm;

import java.util.ArrayList;

public class KnapsackProblem {

	ArrayList<Order> list;

	public KnapsackProblem(ArrayList<Order> list) {
		this.list = list;
	}

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
