package graph;


public class Node {
	
	int cost; // 이 노드까지  오는데 필요한 비용
	int nodeNum; // 노드 번호
	int prevNode;

	Node()	{
		cost =0;
		nodeNum =0;
		prevNode = 0;
	}
	
	Node(int cost, int nodeNum){
		this.cost = cost;
		this.nodeNum = nodeNum;
	}

	Node(int cost, int nodeNum, int prevNode){
		this.cost = cost;
		this.nodeNum = nodeNum;
		this.prevNode = prevNode;
	}


}
