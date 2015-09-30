package graph;


public class Node {
	
	int bcost; // 이 노드까지  오는데 필요한 비용
	int d; // 노드 번호
	
	Node()	{
		bcost=0;
		d=0;
	}
	
	Node(int bcost, int d)
	{
		this.bcost=bcost;
		this.d=d;
	}

}
