package trees;

/**
 * Created by Heon on 2015-10-07.
 * AVLTree 구현
 */
public class AVL extends BST{ // 이진탐색트리를 기반으로 하기 때문에 상속해서 구현

	//1. Balancing 메서드 (rotate)
	//2. 높이차 계산하는 메서드

	public AVL(Node root) {
		super(root);
	}

	//1.높이차이 구하기
	//  1) 높이 구하는 메서드
	public int getHeight(Node root){
		int leftH;
		int rightH;

		if(root == null) return 0;
//		leftH = getHeight(root.getChild("left"))+1;
//		rightH = getHeight(root.getChild("right"))+1;
//		return leftH > rightH ? leftH  : rightH;

		leftH = getHeight(root.getChild("left"));
		rightH = getHeight(root.getChild("right"));

		if(leftH > rightH) return leftH +1;
		else return rightH +1;


	}

	// 2)높이차이가 2 이상인 노드가 있는지 확인???
	public int getHdiff(Node root){
		int leftH, rightH;
		if(root==null) return 0;
		leftH = getHeight(root.getChild("left"));
		rightH = getHeight(root.getChild("right"));
//		System.out.println("root data : " + root.getData());
//		System.out.println("left : "+ leftH + " // right : "+ rightH );
		return leftH - rightH;  // --> 양수 : 왼쪽이 더 높음 , 음수 : 오른쪽이 더 높음
//		return Math.abs(leftH - rightH) >= 2;
	}


	//2. Rotate 메서드(균형 조정)
	// 어떻게 높이차이가 발생하는 노드를 찾아내는가 만약 그 노드만 알 수 있다면 나머지 구현은 쉬움
	// 찾아내는 방법을 생각해보면
	// 1)순회하면서 checkHdiff 메서드 수행
	//  -?? : 모든 노드에서 높이차이를 다 구한다면 rebalancing을 처음 시작하는곳은 ?
	//  -?? : 모든 노드에서 전부다 rebalancing을 수행하나 ?

	// rotate메서드는 순수하게 회전기능만 담고 있으면 되나???

	//  1) LL rotate
	public Node LLrotate(Node root){
		if(root==null) return null;
		// root : 회전 중심에 있는 노드의 부모노드, temp : 회전 중심 노드
		Node temp = root.getChild("left");
		root.setChild(temp.getChild("right"), "left");
		temp.setChild(root, "right");
		//자식노드 설정 마치고

		// 부모노드 설정
		temp.setParent(root.getParent());
		root.setParent(temp);

		System.out.println ("LL");
		System.out.println("tempData : " +temp.getData() + " // rootData : " + root.getData());
		System.out.println("tempData : " +temp.getChild("right").equals(root) + " // rootData : " + root.getData());

		return temp;
	}

	// 2) RR rotate
	public Node RRrotate(Node root){
		if(root==null) return null;
		System.out.println ("RR");
		Node temp = root.getChild("right");
		root.setChild(temp.getChild("left"), "right");
		temp.setChild(root, "left");
		temp.setParent(root.getParent());
		root.setParent(temp);
		return temp;
	}

	// 3) LR rotate : 부분적 RR 회전 --> 전체 LL 회전
	public Node LRrotate(Node root){
		System.out.println ("LR");
		Node temp = root.getChild("left");
		root.setChild(RRrotate(temp), "left");
		return LLrotate(root);
	}

	public Node RLrotate(Node root){
		System.out.println ("RL");
		Node temp = root.getChild("right");
		root.setChild(LLrotate(temp), "right");
		return RRrotate(root);
	}

	public Node rebalance(Node root){
		int Hdiff = getHdiff(root);

		if(Hdiff >=2){ //균형인수가 2이상이면 LL or LR 상태
			System.out.println("in hdiff >= 2");
			if(getHdiff(root.getChild("left")) > 0) root = LLrotate(root);
			else root = LRrotate(root);
		}

		if(Hdiff <= -2){
			System.out.println("in hdiff <= -2");
			if(getHdiff(root.getChild("right")) < 0) root = RRrotate(root);
			else root = RLrotate(root);
		}
//		System.out.println("!!!!!!!!!!!!!!!!!!!Root data : " + root.getData());
		return root;
	}

	public Node insert(Node root, int data){
		super.insert(root, null, data);
		root = rebalance(root);
		// 여기서 rebalace 된 root 노드가 메서드 밖으로 전달이 안됨 --> C는 포인터를 써서 제대로 전달이 가능한데
		//자바는 안되네 ??? 노드의 주소값이 매개변수 root에 전달되어 오니까 그 주소값 공간에 rebalance 값을 넣으면 될줄 알았는데
		// --> root에 전달되는것은 해당 reference의 주소값이 오지만  root에 새로운 값을 할당하면 그 주소값에 할당되는것이 아니라
		// root 자체에 할당함. 즉, 매개변수 root의 값이 갱신되는 것임 (root가 담고 있던 주소에 위치한 값에는 영향이 없다)

		// 1.return 에 root를 반환하는 방법 : 트리가 커지면 root노드가 계속 바뀌면서 데이터가 이상하게 저장됨
		// 2.내부에서 set메서드를 이용하는 방법(아래) : 서로 연결되는 상황이 발생
		// 3.???

//		Node temp = rebalance(root);
//		root.setChild(temp.getChild("left"), "left");
//		root.setChild(temp.getChild("right"), "right");
//		root.setData(temp.getData());
		//이 방식의 문제점은  rebalace된 노드중 root를 자식으로 하는 노드가 존재하기 때문에(회전 중심이 되는노드)
		//트리가 아니라 닫힌 그래프 형태가 된다. 즉  48 <-> 49 <- 50으로  48, 49가 서로를 가리키고 있는상황
		//그래서 순회나 삽입연산 수행시 문제가 발생;

		// root.set~~ 등을 통해 root를 변경하는 작업은 외부의 root에 영향을 줌
		// 그러나 root = 을 통해 root에 값을 다시 할당하면 외부에 영향을 주지 않음

		return root; // return 방법이 있지만 함수가 지저분해진다
	}

	public Node delete(Node root, int data){
		Node temp = super.delete(root, data);
		root = rebalance(root);
		return temp;
	}



}

















