package trees;

/**
 * Created by Heon on 2015-10-07.
 * 이진 탐색 트리용 노드
 */
public class Node {

	private int data;
	private Node left;
	private Node right;
	private Node parent;
	private boolean isLeft;

	public Node(int data){
		this.data = data;
		left = null;
		right = null;
		parent = null;
	}

	public int getData(){
		return data;
	}

	public void setData(int data){
		this.data = data;
	}

	public Node getChild(String isLeft) {
		if(isLeft.equals("left")) return left;
		else return right;
	}

	public void setChild(Node child, String isLeft){
		if(isLeft.equals("left")) {
			left = child;
			if(child != null) left.isLeft = true;
		}
		else {
			right = child;
			if(child != null) right.isLeft = false;
		};
	}

	public Node getParent(){
		return parent;
	}

	public void setParent(Node parent){
		this.parent = parent;
	}

	public boolean isLeft(){
		return isLeft;
	}

}
