package trees;

/**
 * Created by Heon on 2015-10-07.
 * AVLTree 구현
 */
public class AVL extends BST{ // 이진탐색트리를 기반으로 하기 때문에 상속해서 구현

	//1. Balancing 메서드 (rotate)
	//2. 높이차 계산하는 메서드

	private BST bst;

	public AVL(Node root) {
		super(root);
	}

	//1.높이차이 구하기
	//  1) 높이 구하는 메서드
	public int getHeight(Node root){
		int leftH;
		int rightH;

		if(root == null) return 0;
		leftH = getHeight(root.getChild("left"))+1;
		rightH = getHeight(root.getChild("right"))+1;

		return leftH > rightH ? leftH  : rightH;
	}

	// 2)높이차이가 2 이상인 노드가 있는지 확인???
	public boolean chekcHdiff(Node root){
		int leftH, rightH;
		if(root==null) return false;
 		leftH = getHeight(root.getChild("left"));
		rightH = getHeight(root.getChild("right"));
		return Math.abs(leftH - rightH) >= 2;
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

		Node temp = root.getChild("left");
		root.setChild(temp.getChild("right"), "left");
		temp.setChild(root, "right");

		return temp;
	}



}

















