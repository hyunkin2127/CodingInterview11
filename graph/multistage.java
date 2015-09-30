package graph;

import java.util.Scanner;

public class multistage {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);

		System.out.print("정점와 간선수를 입력하시오(정점 간선수): ");
		int pointNum=sc.nextInt(); //정점 수
		int edgeNum=sc.nextInt(); // 간선 수 

		int[][] G=new int[edgeNum][3]; // 간선의 종류와 가중치를 저장 (시작점 끝점 가중치) 
		int[] preVertex=new int[pointNum+1]; // 정점에 최단거리로 도착하기 위해 거쳐가야 하는 바로 이전 정점
		int[] bcost=new int[pointNum+1]; // 시작점에서 해당 정점까지 이동하는데 드는 비용 

		for(int i=0; i<edgeNum;i++){ //간선의 가중치를 저장
			System.out.print(i+"번째 간선을 입력하시오(정점 정점 가중치):");
			G[i][0]=sc.nextInt();
			G[i][1]=sc.nextInt();
			G[i][2]=sc.nextInt();
		}

		//  Node GetBcost(int b, int g[][], int bcost[]);

		for(int j=1; j<pointNum+1 ;j++){ //초기화중
			Node cnode=new Node(); // 노드를 생성하고
			cnode=GetBcost(j, G, bcost);
			// 각 정점(j)의 정보를 getBost함수를 통해 얻어 생성한 노드에 담는다

			bcost[j]=cnode.bcost; // 그리고 그 정보를 또 따로 관리한다.
			preVertex[j]=cnode.d; // 각 정점에 

			System.out.println(" Value of Point( "+j+" )  | Cost : "+bcost[j]+" | d : "+preVertex[j]);
		}


		int Vlevel = GetVlevel(1, G, pointNum, edgeNum);    //그래프의 단계수를 구함 
		int[] Minway=new int[Vlevel+1];   // 최소경로를 담을 배열을 선언
		Minway[1]=1; //시작 단계(1단계) 설정
		Minway[Vlevel]=pointNum;  // 마지막단계 설정 

		for(int k=Vlevel; k>1;k--){                          //최소 경로를 d값을 통해 구함
			Minway[k-1]=preVertex[Minway[k]];}                     //d값 배열을 역으로 추적함

		System.out.println();
		System.out.print(" MinCostway :  ");

		for(int i=1; i<Vlevel+1;i++){                                 // 최소경로 출력부분
			if(i!=Vlevel) System.out.print(Minway[i]+"->");
			else System.out.print(Minway[i]);
		}

		System.out.println();                                // 최소경로의 Cost를 출력
		System.out.println(" Cost : "+bcost[pointNum]);
	}

	
	
	public static Node GetBcost(int b, int g[][], int bcost[])	{
		if(b==1) return new Node(0,0); // 그래프 시작점이 들어왔을때 
		int cost;
		MinHeap h=new MinHeap(g.length);  // 간선의 개수와 같은 크기의 힙을 만들고
 		// 근데 힙을 매번 만드나 ? --> b라는 점을 향하는 모든 점들을 힙에 넣어서 최소값을 추출
		// 전체노드를 정리하는데 하나의 힙을 사용하는것이 아니라
		// 각 노드마다 따로 사용함

		for(int i=0; i<g.length; i++){
			if( g[i][1]==b ){ // 목표 점(b)을 도착지로 하는 정점이 있는지를 확인 
				cost=bcost[g[i][0]] + g[i][2]; // 있으면 해당 정점까지의 비용과, b까지의 비용을 합쳐서
				h.put(new Node(cost, g[i][0])); 
				// G배열과 cost 배열을 전달받아 순환 호출 형태로 처리함    
				// 한정점으로 가는 여러 Cost값들을 최소힙에 삽입
			}
		}
		return h.getMin(); //힙에서는 bcost값이 최소인 노드를 반환함
	}


	public static int GetVlevel(int b,  int[][] g, int Point, int Edge)  // 그래프의 단계수를 구하는 함수
	{
		int Vlevel=1;
		while(b!=Point){                // 마지막 정점에 도달하기 전까지 순환  
			for(int i=0; i<Edge; i++)  //단계수 구하는 부분 
				if(g[i][0]==b) { 
					b=g[i][1];  
					Vlevel++; 
				} 
		}
		return Vlevel;
	}


}
