package graph;

import java.util.LinkedList;

public class Traversals {

	Graph g;
	boolean[] Visited;

	int n, cnt; // 맵의 크기와 카운트 변수
	int M, N;
	int front, rear;
	int[][] map; // 맵을 나타내는 2차원 배열
	int[][] queue;
	int[][] visit;  // 좌표에 의한 방문 등록 배열 //

	public Traversals(Graph g) {
		this.g = g;
		Visited = new boolean[g.point];
	}

	public Traversals(){// for findWayBFS
		map = new int[21][21];
		queue = new int[2][100];
		visit = new int[21][21];

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



	public void findWayBFS(int px, int py, int pl) {   // 5,1,1 이 넘어옴 //
		int i, j;

		// queue에 첫번째 좌표 등록 //
		queue[0][rear] = px; queue[1][rear] = py;
		// 방문 등록 해야됨 // 길은 0으로 초기화 되어있고, 벽은 1로 초기화 , 나머지는 -2로 초기화 되어있음..
		visit[px][py] = 1;  // 길이를 방문한것으로 체크

		rear++;

		while (front < rear)             //
		{
			// 첫번째 큐에 있는 좌표 가져오기 //

			px = queue[0][front]; py = queue[1][front];
			front++;

			// 가져온 좌표의 전후좌우 탐색 및 큐에 등록 하기 //

			if (py + 1 < M && map[px][py + 1] == 0 && visit[px][py + 1] != 0){   //
				visit[px][py + 1] = visit[px][py] + 1;  // 이전 좌표의 길이 + 1
				queue[0][rear] = px;
				queue[1][rear] = py + 1;
				rear++;
			}

			if (px + 1 < N && map[px + 1][py] == 0 && visit[px + 1][py] != 0){       //
				visit[px + 1][py] = visit[px][py] + 1;
				queue[0][rear] = px + 1;
				queue[1][rear] = py;
				rear++;
			}

			if (py-1 >= 0 && map[px][py - 1] == 0 && visit[px][py - 1] != 0){        //
				visit[px][py - 1] = visit[px][py] + 1;
				queue[0][rear] = px;
				queue[1][rear] = py - 1;
				rear++;
			}

			if (px - 1 >= 0 && map[px - 1][py] == 0 && visit[px - 1][py] != 0){      //
				visit[px - 1][py] = visit[px][py] + 1;
				queue[0][rear] = px - 1;
				queue[1][rear] = py;
				rear++;
			}
		}
		System.out.println(visit[0][M-1]);

		for (i = 0; i < 20; i++){
			for (j = 0; j < 20; j++){
				System.out.println(visit[i][j]);
			}
		}

	}

//	int main(void)
//	{
//		int i, j;
//
//		System.in(N, M);
//
//		for (int i = 0; i < N; i++){
//			for (int j = 0; j < M; j++){
//				System.in("%1d", &map[i][j]);
//			}
//		}
//
//
//
//		BFS(N-1, 0, 1); // x:5 y:1 // 시작지점 1
//
//		return 0;
//	}



}
