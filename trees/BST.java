package trees;

/**
 * Created by Heon on 2015-10-07.
 * 이진 탐색 트리 구현
 */

//삽입, 삭제, 수정
public class BST {

	protected Node root;

	public BST(Node root){
		this.root = root;
	}


	//1.검색
	public Node search(Node root, int data){
		if(root == null) return null;
		if(root.getData() < data) return search(root.getChild("right"), data);
		else if(root.getData() > data) return search(root.getChild("left"), data);
		else return root;
	}

	//2.삽입
	// 이진탐색트리의 조건을 만족시키도록 삽입시 자기자리를 찾아가게 해야함
	//  방법 - 1) 맨 마지막칸에 넣고 자기자리를 찾아가도록 한다. : 마지막칸은 어떻게 아는가.--> 그냥 leaf아무데나 가서 넣으면되나 ??
	//       - 2) 루트에서부터 자리를 찾아내려간다.
	public Node insert(Node curNode, Node parNode, int data){
		if(curNode == null){
			curNode = new Node(data);
			curNode.setParent(parNode);
			return curNode;
		}
		if(curNode.getData() < data) // 현재노드의 자식으로 오른쪽에 새로운 data를 할당한다.
			curNode.setChild(insert(curNode.getChild("right"), curNode, data), "right");
		else if(curNode.getData() > data)
			curNode.setChild(insert(curNode.getChild("left"), curNode, data), "left");
		else {
			System.out.println("aleady exist data in Tree");
			return null;
		}
		return curNode;
	}

	//3.삭제
	// 1) 삭제할 노드를 찾아 왼쪽하위트리의 최대값 or 오른쪽 하위트리의 최소값과 교체
	// 2) 교체된 노드를 삭제.
	public Node delete(Node curNode, int data){
		// 이진트리의 삭제 연산시 문제사항
		// 1. 삭제할 노드의 부모노드를 알 수 없다는것.  때문에 노드안에 부모를 가리키는 포인터가 필요하다.
		// 2. 삭제할 노드가 자신이 오른쪽노드인지 왼쪽노드인지를 모른다는 것.

		if(curNode == null) return null;

		if(curNode.getData() < data)	return delete(curNode.getChild("right"), data);
		else if(curNode.getData() > data) return delete(curNode.getChild("left"), data);

		else {
			//1. 자식노드가 둘다 존재할때
			// 오른쪽 하위노드의 최소값 or 왼쪽하위노드의 최소값을 삭제할 노드값과 교체시키고, 교체당한 노드(최대,최소)를 삭제한다.
			if(curNode.getChild("left")!=null && curNode.getChild("right") !=null){
				Node maxNode = findMax(curNode.getChild("left")); //왼쪽하위노드중 최대값을 지닌 노드를 찾고
				System.out.println("in delete ------------------------");
				System.out.println( "curNode.getData() : "+  curNode.getData() + "  //  maxNode.getData() : " +  maxNode.getData());
				curNode.setData(maxNode.getData()); // 그 값을 삭제할 노드에 할당한 다음
				if(maxNode.isLeft()) //최대값을 갖고있던 노드가 왼쪽에 위치한 노드였다면
					maxNode.getParent().setChild(null, "left"); // 최대값을 갖던노드를 삭제(최대값 노드의 부모노드에서 left값을 null로 변경)
				else // 최대값을 갖던 노드가 오른쪽에 위치한 노드였다면
					maxNode.getParent().setChild(null, "right"); // 최대값을 갖던노드를 삭제(최대값 노드의 부모노드에서 right값을 null로 변경)
			}

			else if(curNode.getChild("left") !=null || curNode.getChild("right") !=null){
				//2. 자식노드가 하나만 존재할때
				//삭제할 노드가 있던 자리에 자식노드를 할당
				String nodePos; // 삭제할 노드가 갖고 있는 노드 1개가 왼쪽인지 오른쪽인지 파악해 이를 저장하기 위한 변수
				if(curNode.getChild("left") != null) nodePos = "left"; //삭제할 노드의 왼쪽자식노드가 존재할때
				else nodePos = "right"; // 오른쪽자식노드가 있을때
				if(curNode.isLeft()) //삭제할 노드가 왼쪽 노드라면
					curNode.getParent().setChild(curNode.getChild(nodePos), "left"); //삭제할 노드의 자식노드를 삭제할 노드의 부모의 왼쪽자식으로 할당
				else // 삭제할 노드가 오른쪽 노드라면
					curNode.getParent().setChild(curNode.getChild(nodePos), "right"); //삭제할 노드의 자식노드를 삭제할 노드의 부모의 오른쪽자식으로 할당
			}

			else {
				//3. leaf노드일때
				if (curNode.isLeft()) curNode.getParent().setChild(null, "left");
				else curNode.getParent().setChild(null, "right");
			}
		}
		return curNode;
	}

	//4. 순회(전체 보여주기)
	public void traverseTree(Node root){
		if(root == null) return;
		traverseTree(root.getChild("left"));
		System.out.println(root.getData());
		traverseTree(root.getChild("right"));
	}

	//5. 트리내 최대값 노드를 찾는 메서드
	public Node findMax(Node root){
		if(root == null) return null;
		Node temp = root;
		while(temp.getChild("right") != null){
			temp = temp.getChild("right");
		}
		return temp;
	}

}






