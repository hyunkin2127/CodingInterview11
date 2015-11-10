package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 최소 신장 트리 - 크루스칼 알고리즘 기반 구현
 * Created by Heon on 2015-10-14.
 */

//필요한것 : 우선순위 큐, DFS, 닫힘확인용 함수

public class MST_Kruskal {
	boolean[] Visited; // 방문 여부 체크를 위한 배열  Visited[1]==true : 1번 정점은 방문했음
	public int[][] originAdj; // 원래의 간선 정보를 담을 인접행렬
	// 사실 생성자에서 간선정보를 큐에 다 넣기 때문에 기존인접행렬은 필요가없으나
	// 새롭게 선택된 간선들로 이루어진 그래프와의 비교를 위해서 삽입함.
	public int[][] newAdj; // 새롭게 선택된 간선 정보를 담을 행렬
	int vNum, eNum; // 정점수 ,간선수(간선수는 별 필요는 없는듯?)
	PriorityQueue<Edge> pq; // 간선 가중치값 정렬을 위한 우선순위 큐

	class Edge { //  간선 정보를 담을 객체
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
			// 인접행렬 초기화
			for(int j=0; j<vNum; j++){
				originAdj[i][j] = Integer.MAX_VALUE;
				newAdj[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	public void insertEdge(int from, int to, int weight){ // 간선 삽입용 메서드
		originAdj[from][to] = weight;
		originAdj[to][from] = weight; // 탐색을 위해 양방향으로 --> 없어도 탐색 잘됨:DSF의 과정이 바뀔 뿐
		pq.add(new Edge(from, to, weight));// 간선정보를 큐에 담음
		eNum++;
	}

	private Edge closeCheckByDFS(int from){ // 그래프 닫힘 검사용 메서드
		Visited[from] = true; // from 정점을 방문했다고 표시함
		Edge temp = null; // 닫힌 그래프를 형성시키는 간선을 발견할 경우 이를 반환하기 위한 변수
		for(int to=0; to<newAdj[from].length; to++){
			if(!Visited[to] && newAdj[from][to] !=Integer.MAX_VALUE) // 방문하지 않았던 점이면서, from과 to가 이어져있다면
				temp = closeCheckByDFS(to); // to로 부터 메서드를 다시 수행
			else if(Visited[to] && newAdj[from][to] !=Integer.MAX_VALUE) // 방문했던 점이면서, from과 to가 이어져 있다면
				temp = new Edge(from, to, newAdj[from][to]);  // 그 간선은 닫힌 그래프를 형성시키는 간선이므로 해당 간선정보를 반환한다.
		}
		return temp;  // null이 반환되면 열린거, 아니면 닫힌거
	}

	private void resetVisited(){ // DSF를 위한 Visited 배열을 false로 초기화
		Arrays.fill(Visited, false);
	}

	private void showByDSF(int from, int[][] arr){ // 그래프 탐색
		Visited[from] = true; // 선택된 점을 방문했다고 기록하고
		for(int to=1; to<arr[from].length; to++){ // 
			if(!Visited[to] && arr[from][to] !=Integer.MAX_VALUE){
				System.out.println( from+"에서 "+to+"로 이동함");
				showByDSF(to, arr);
			}// end of if
		}// end of for v
	}

	public void showGraph(int u, int[][] arr){ // 그래프 확인용 출력메서드
		resetVisited();
		showByDSF(u, arr);
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
		Edge first = pq.peek(); // 큐에서 첫번째 간선정보를 빼서 담아둠(그래프탐색시 기준점으로 사용)
		while(!pq.isEmpty()){ // pq에 있는 간선이 다 떨어질때가지
			temp = pq.remove(); // 최소 가중치값을 갖는 간선을 빼서
			newAdj[temp.from][temp.to] = temp.weight; // 새로운 인접행렬에 할당하고
			resetVisited(); // closedCheckByDFS 메서드에서 Visited 배열을 사용하므로 매번 초기화
			if(closeCheckByDFS(first.from) != null){ // 최소비용간선의 시작점을 기준으로 그래프닫힘여부 확인해서 닫혀있다면
				newAdj[temp.from][temp.to] = Integer.MAX_VALUE;// 해당간선할당을 해제한다.
			} // end of if
		} // end of while
	} // end of func
}
