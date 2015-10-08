//package trees;
//import queue.ArrayQueue;
//
//public class Tree {
//
//	public Node root;
//	Node lastLeaf;
//
//	public Tree(Node root){
//		this.root = root;
//		this.lastLeaf = root;
//	}
//
//	public boolean isEmpty(){
//		return root == null;
//	}
//
//
//	public void levelOrder(){ // 레벨 순서 순회
//		if(isEmpty()) return;
//		ArrayQueue aq = new ArrayQueue(10);
//		aq.enQueue(root);
//		Node temp;
//		while(!aq.isEmpty()){
//			temp = (Node)aq.deQueue();
//			System.out.println(temp.data);
//			if(temp.left != null) aq.enQueue(temp.left);
//			if(temp.right != null) aq.enQueue(temp.right);
//		}
//	}
//
//	public void inOrder(Node root){
//		if(root == null) return;
//
//		inOrder(root.left);
//		System.out.println(root.data);
//		inOrder(root.right);
//	}
//
//
//	public void addByLevel(int data){ // 레벨 순회 기반 add
//		if(isEmpty()) {
//			System.out.println(12341234);
//			this.root = new Node(data);
//			return;
//		}
//
//		ArrayQueue aq = new ArrayQueue(10);
//		aq.enQueue(root);
//		Node temp;
//		while(!aq.isEmpty()){
//			temp = (Node) aq.deQueue();
//			if(temp.left == null) {
//				temp.left = new Node(data, temp);
//				return;
//			}
//			else if(temp.right == null) {
//				temp.right = new Node(data, temp);
//				return;
//			}
//			else {
//				aq.enQueue(temp.left);
//				aq.enQueue(temp.right);
//			}
//		}
//	}
//
//	public Node add(Node root, int data){  // 어떻게 하면 삭제작업시 필요한 parent를 전달할 것인가.
//		if(root == null) {
//			root = new Node(data, null);
//			lastLeaf = this.root;
//		}
//		else{
//			if(root.left != null) root.left = add(root.left, data);
//			if(root.right != null) root.right = add(root.right, data);
//		}
//		return root;
//	}
//
//	public Node search(Node root, int data){ //전위 순회를 통한 노드 탐색
//		if(root == null) return null;
//		else{
//			if(root.data == data){
//				System.out.println("Exist!");
//				return root;
//			}
//			search(root.left, data);
//			search(root.right, data);
//			return null;
//		}
//	}
//
//	public void remove(Node root,int data){ //후위 순회를 통한 노드 삭제
//		if(root == null) return;
//		remove(root.left, data);
//		remove(root.right, data);
//		if(root.data == data){ //해당 노드를 찾으면
//			//만약 해당 노드가 자식이 있을경우 이를 매꿔 주어야한다.
//			//이때 매꾸는 기준이 필요한데 여기서는 해당 노드의 자식노드중
//			//leafNode면서 가장 오른쪽에 있는 노드를 선택한다.
//			ArrayQueue aq = new ArrayQueue(10);
//			aq.enQueue(root);
//			Node temp;
//			while(!aq.isEmpty()){
//				temp = (Node) aq.deQueue();
//				if(temp.left != null) aq.enQueue(temp.left);
//				if(temp.right != null) aq.enQueue(temp.right);
//				if(aq.isEmpty()){// 좌, 우자식노드를 확인해서 enQueue했는데도 queue가 비어있다면 temp가 lastNode이다. --> 삭제할 노드의 자식중에서 last임
//					//따라서 lastNode의 데이터를 삭제할 노드에 옮겨 담고, last노드의 할당을 해제하면 삭제가 마무리된다. --> 진짜 lastnode를 찾는쪽으로 바꾸는것이 바람직
//					root.data = temp.data;
//					if(temp.parent.left == root ) temp.parent.left = null; // lastnode의 할당을 해제
//					else temp.parent.right = null;
//				}
//			}
//		}
//	}
//
//	public int findHeight(Node root){ // 트리 높이
//		int leftHeight, rightHeight;
//		if(root == null) return 0;
//		leftHeight = findHeight(root.left);
//		rightHeight = findHeight(root.right);
//
//		if(leftHeight > rightHeight) return leftHeight+1;
//		else return rightHeight+1;
//	}
//
//	public int findDiameter(Node root, int diameter){ // 가장 먼 노드간의 간격
//		if(root == null) return 0;
//		int left, right;
//		left = findDiameter(root.left, diameter);
//		right = findDiameter(root.right, diameter);
//		if(left + right > diameter) diameter = left + right;
//		return Math.max(left, right)+1;
//	}
//
//	public int findSizeByRecur(Node root){ // 트리 전체 크기
//		if(root == null) return 0;
//		return (findSizeByRecur(root.left) + 1 + findSizeByRecur(root.right));
//	}
//
//	public int findSizeByRepeat(Node root){
//		if(root == null) return 0;
//		int count = 1;
//		Node temp;
//		ArrayQueue aq = new ArrayQueue(10);
//		aq.enQueue(root);
//
//		while(!aq.isEmpty()){
//			temp = (Node) aq.deQueue();
//			System.out.println(123123+ " // " +temp.data+ " // " + count);
//			if(temp.left != null){
//				count++;
//				aq.enQueue(temp.left);
//			}
//			if(root.right != null){
//				count++;
//				aq.enQueue(temp.right);
//			}
//		}
//		return count;
//	}
//}
