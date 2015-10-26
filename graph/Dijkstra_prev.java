package graph;

import java.util.Scanner;

/**
 * Created by Heon on 2015-10-01.
 * 망함 - 버리고 다시
 */

public class Dijkstra_prev {

	public static void main(String[] args){

		Scanner sc=new Scanner(System.in);
		System.out.print("정점와 간선수를 입력하시오(정점 간선수): ");
		int pointNum=sc.nextInt(); //정점 수
		int edgeNum=sc.nextInt(); // 간선 수

		int v, w;
		int[] distance = new int[pointNum]; // 정점 별 최소 비용 저장
		int[][] weight = new int[edgeNum][3]; //간선 가중치를 저장
		int[] path = new int[pointNum]; // 경로 저장
		MinHeap_Multisage h = new MinHeap_Multisage(pointNum); // 각 정점까지의 거리를 정리하고 최소값을 얻어올 최소힙

		for(int i=0; i<edgeNum;i++){ //간선과 그 가중치를 초기화
			System.out.print(i+"번째 간선을 입력하시오(정점 정점 가중치):");
			weight[i][0]=sc.nextInt();
			weight[i][1]=sc.nextInt();
			weight[i][2]=sc.nextInt();
		}

		for(int i=0; i<distance.length; i++){ // 정점 별 최소 비용 저장배열 초기화
			distance[i] = -1;
		}

		h.put(new Node(0, 0));

		while(!h.isEmpty()){

			Node temp = h.getMin();
			// 점을 탐색해가면서 만난 간선들의 정보를 최소힙에 넣고
			// 정점에서 새로 탐색을 시작할때 마다 heap.getMin()를 통해 삽입 된 간선들 중 비용이 최소인 간선을 선택한다.
			for(int i=0; i<weight.length; i++){
				if(weight[i][0] == temp.nodeNum){
					if(distance[weight[i][1]] == -1) { //방문하지 않았던 점이라면
						distance[weight[i][1]] = temp.cost + weight[i][2]; // 해당정점에 이르는 비용을 저장
						h.put(new Node(temp.cost +weight[i][2], weight[i][1]));
						// 해당정점의 이전까지의 비용(temp.cost) + 그 점에서 자신으로의 비용( weight[i][2]), 정점 자신의번호
						path[weight[i][1]] = weight[i][0]; // 해당 정점에 이르는 경로 path[목표정점] = 이전 정점
					}
					else{ //방문 했던 점이라면 비용을 비교해서 변경
						if( distance[weight[i][1]] < temp.cost) distance[weight[i][1]] = temp.cost;

					}
					h.put(new Node(temp.cost +weight[i][2], weight[i][1]));
					// 해당정점의 이전까지의 비용(temp.cost) + 그 점에서 자신으로의 비용( weight[i][2]), 자기 정점번호
				}
			}

		}

	}
}