package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 최소 신장 트리 - 크루스칼 알고리즘 기반 구현
 * Created by Heon on 2015-10-14.
 */

// 필요한것
// 1. 우선순위 큐(힙)
// 2. 닫힘 확인용 메서드
// 3. 등등


public class MST_Kruskal {

	boolean[] Visited;
	public int[][] originAdj; // 원래의 간선 정보를 담을 인접행렬
	public int[][] newAdj; // 새롭게 선택된 간선 정보를 담을 행렬
	int vNum, eNum;
	PriorityQueue<Edge> pq; // 간선 오름차순 정렬용

	class Edge {
		int from, to, weight;
		public Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public void getData(){
			System.out.println("from : "+from+ " // to : "+to+" // weight : "+weight);
		}
	}

	public MST_Kruskal(int vNum){
		this.vNum = vNum;
		this.eNum = 0;
		originAdj = new int[vNum][vNum];
		newAdj = new int[vNum][vNum];
		Visited = new boolean[vNum]; // DFS용

		pq = new PriorityQueue<Edge>(vNum, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) { // 오름차순 형태로 정렬 시킨다.
				return e1.weight - e2.weight;
			}
		});

		for(int i=0;i<vNum; i++){
			//인접행렬 초기화
			for(int j=0; j<vNum; j++){
				originAdj[i][j] = Integer.MAX_VALUE;
				newAdj[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	public void insertEdge(int from, int to, int weight){
		originAdj[from][to] = weight; //그래프 탐색을 진행해야 하기 때문에 양방향으로
		originAdj[to][from] = weight;
		pq.add(new Edge(from, to, weight));//간선정보를 큐에 담음
		eNum++;
	}

	public Edge closeCheckByDFS(int u){//그래프 닫힘 검사용 메서드
		Visited[u] = true;
		Edge temp = null;
		for(int v=0; v<newAdj[u].length; v++){
			if(!Visited[v] && newAdj[u][v] !=Integer.MAX_VALUE){
				temp = closeCheckByDFS(v);
			}
			else if(Visited[v] && newAdj[u][v] !=Integer.MAX_VALUE){ // 원래 인접행렬에서
				temp = new Edge(u, v, newAdj[u][v]);
			}
		}
		return temp;  // null이 반환되면 열린거, 아니면 닫힌거
	}

	public void resetVisited(){
		Arrays.fill(Visited, false);
	}

	public void show(int u, int[][] arr){
		Visited[u] = true; // 선택된 점을 방문했다고 기록하고
		for(int v=1; v<arr[u].length; v++){ //
			if(!Visited[v] && arr[u][v] !=Integer.MAX_VALUE){
				System.out.println( u+"에서 "+v+"로 이동함");
				show(v, arr);
			}//end of if
		}//end of for v
	}

	public void showGraph(int u, int[][] arr){
		resetVisited();
		show(u, arr);
	}


	public void makeMST(){
		// 간선삽입시 간선정보를 pq에 모두 넣어 두었음.
		// 순차적으로 빼면서 newAdj에 할당 시키고, 할당할때마다 닫힘여부 체크만 하면 된다.
		// 만약 닫혀 있으면 해당 간선은 버리고 다음 간선을 추출하면 됨
		// 아 그리고 노드 전체가 연결되었는지도 확인해야되네 -->>>??????
		// --> 확인방법 :
		// 1. 간선 새로 할당할때마다 확인한다. - 이게 좋은 방법인데 복잡할것 같다.
		// 2. 할당과정이 완료된 후에 확인을 위한 메서드를 사용한다. 일단 2번으로 !!

		Edge temp; // 우선순위 큐에서 빼낸 간선들을 임시로 저장할 공간
		Edge first = pq.peek(); // 우선순위 큐에서 처음으로 빼낼 간선 정보
		first.getData();
		while(!pq.isEmpty()){ //pq에 있는 간선이 다 떨어질때가지
			temp = pq.remove(); // 최소 가중치를 갖는 간선을 빼서
			temp.getData();
			newAdj[temp.from][temp.to] = temp.weight; //새로운 인접행렬에 할당하고
			System.out.println("in While " );
			resetVisited();
			if(closeCheckByDFS(first.from) != null){//최소비용간선의 시작점을 기준으로 그래프닫힘여부 확인해서 닫혀있다면
				newAdj[temp.from][temp.to] = Integer.MAX_VALUE;// 해당간선할당을 해제한다.
			}
		}
	}
}
