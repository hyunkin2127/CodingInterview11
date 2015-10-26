package graph;

import java.util.Comparator;
import java.util.PriorityQueue;

/** Dijstra ShortestPath Algorithm
 *   - 우선순위 큐를 이용한 구현
 *   - 이전의 구현(Dijkstra_prev.java, ShortestPathFinder.java)에서 실패한 이유는 연결여부를 확인하지 않았고,
 *     간선정보를 정점에 담아 표현하려 했기 때문.
 * Created by Heon on 2015-10-26.
 */
public class Dijkstra_complete {

	int vNum; // 정점 갯수
	int[][] edges; // 간선 정보 : edges[1][3] = 2  --> 1,3번 정점은 연결되어 있으며 가중치는 2 (MAX_VALUE == 연결없음)
	int[] dist; // 정점 도착에 필요한 비용 : dist[2] == 5 -->  2번 정점에 도달하는데 필요한 총 비용은 5
	int[] path; // 최단 경로 역추적용 배열 : path[3] == 2 --> 3번 정점은 2번을 거쳐서 간다.
	boolean[] foundPathVertex; // 최단경로를 발견한 정점집합. : foundPathVertex[3] = true --> 3번 정점의 경로가 결정됨
	PriorityQueue<Edge> pq; // 간선 가중치값 정렬을 위한 우선순위 큐

	class Edge { //  간선 정보를 담을 객체 --> 우선순위 큐를 이용하기 위함 사실 굳이 클래스로 안만들어도 될거같은데 잘 모르겠다.
		int from, to, weight;
		public Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public void showData(){ //내장 데이터 확인용
			System.out.println("from : "+from+ " //  to : "+to+" //  weight : "+weight);
		}
	}

	public Dijkstra_complete(int vNum){

		edges = new int[vNum][vNum]; // 정점 수대로 간선 잇고
		dist = new int[vNum]; // 정점의 수대로 배열 만들고
		path = new int[vNum]; // 정점 수대로 간선 정보
		foundPathVertex = new boolean[vNum]; // 경로 발견한 간선 저장할곳

		pq = new PriorityQueue<Edge>(vNum, new Comparator<Edge>() { // 우선순위 큐의 Comparator 정의
			@Override
			public int compare(Edge e1, Edge e2) { // 간선 가중치값 오름차순 정렬시킴
				return e1.weight - e2.weight;
			}
		});

		for(int i=0; i<edges.length; i++){ // 인접행렬 초기화
			for(int j=0; j<edges.length; j++){
				if(i==j) edges[i][j] = 0;
				else edges[i][j] = Integer.MAX_VALUE;
			}// 인접 행렬 초기화 하고
			dist[i] = Integer.MAX_VALUE;
			path[i] = Integer.MAX_VALUE;
			foundPathVertex[i] = false;
		}
	}

	public void insertEdges(int from, int to, int weight){ // 간선 삽입 메서드
		edges[from][to] = weight;
//		edges[to][from] = weight; // 없어도 잘됨
	}

	public void findWay(int start){

		dist[start] = 0; // 시작정점에 이르는 비용 == 0
		path[start] = 0; // 시작지점 이전의 경로는 없는것으로 설정
		foundPathVertex[start] = true; // 시작지점을 최단경로노드로 설정

		for(int i=1; i<edges.length; i++){
			if(edges[start][i] != Integer.MAX_VALUE) // 시작정점(start)에서 이어진 간선을 찾음
				pq.add(new Edge(start, i, edges[start][i])); // 찾아서 간선 정보를 큐에 넣고
		}

		while(!foundPathVertex[edges.length - 1]){ //마지막 정점까지 경로가 정해지지 않았다면 반복
			Edge temp = pq.remove(); // 우선순위 큐에서 최소 가중치 간선을 하나 빼서

			if(foundPathVertex[temp.from] && dist[temp.to] > temp.weight + dist[temp.from]){
				// 그 간선이 경로가 결정된 정점으로부터 이어진 간선이면서, 새롭게 찾은 연결 비용이 이전 경로에 필요한 비용보다 적다면
				foundPathVertex[temp.to] = true; // 이어진 정점(to)을 최단경로로 설정해주고
				dist[temp.to] = temp.weight + dist[temp.from]; // 비용 교체
				path[temp.to] = temp.from; // 최단 경로 정점으로 할당
			}
			for(int j=0; j<edges.length ; j++){
				if(temp.to !=j && edges[temp.to][j] != Integer.MAX_VALUE) // to로 부터 이어진 정점들을 조사하기 위해서
					pq.add(new Edge(temp.to, j, edges[temp.to][j]));// to로부터 출발하는 간선들을 큐에 다시 넣자.
			}
		}
	}

	public void showWay(){ // 경로 출력용 함수
		int i=path.length-1;
		while(i != 0){
			if(path[i] != Integer.MAX_VALUE);
			System.out.println(i);
			i=path[i];
		}
	}
}
