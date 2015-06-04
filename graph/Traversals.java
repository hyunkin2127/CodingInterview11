package graph;

import queue.ArrayQueue;

import java.util.AbstractCollection;
import java.util.LinkedList;

public class Traversals {

	Graph g;
	boolean[] Visited;

	public Traversals(Graph g) {
		this.g = g;
		Visited = new boolean[g.point];
	}

	public void DSF(int u){ // 스택(재귀)
		Visited[u] = true; // 선택된 점을 방문했다고 기록하고
		for(int v=0; v<g.Adj[u].length; v++){ //
			if(!Visited[v] && g.Adj[u][v]){
				System.out.println( u+"에서 "+v+"로 이동함");
				DSF(v);
			}//end of if
		}//end of for v
	}//end of DSF

	public void BFS(int u){ // queue사용.  트리 level order기법과 매우 흡사함
		int v;
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.addFirst(u); //가장 처음 값을 큐에 넣고
		Visited[u] = true;
		while(!ll.isEmpty()){ // 큐가 빌때 까지
			u =ll.removeLast().intValue(); // deQ해서
			for(v = 0; v<g.Adj[u].length; v++){ // 해당점에서 이어진 좌표별로 연산을 진행한다.
				if(!Visited[v] && g.Adj[u][v]){ //만약 해당점이 방문한적이없고, 간선이 존재하면
					ll.addFirst(v); // 이어진 점을 큐에 넣고
					Visited[v] = true; // 방문했다고 기록한다
					System.out.println( u+"에서 "+v+"로 이동함");
				}// end of if
			}// end of for v
		}// end of while
	}// end of BFS

}
