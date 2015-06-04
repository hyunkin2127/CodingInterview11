package graph;

public class Graph {
	
	public int point;
	int edge;
	boolean[][] Adj;
	
	public Graph(boolean[][] arr) {
		point = 0;
		edge = 0;
		Adj = arr;
	}
	
	public void insertEdge(int i, int j){
		Adj[i][j] = true;
		Adj[j][i] = true;
		edge++;
		return;
	}
}
