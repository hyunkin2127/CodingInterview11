//package trees;
//
//import java.util.NoSuchElementException;
//
//public class BinarySearchTree {
//
//	public Node root ;
//
//	public BinarySearchTree(Node root) {
//		this.root = root;
//	}
//
//	public boolean isEmpty(){
//		return root == null;
//	}
//Q
//	public Node searchDataByRecur(Node root, int data){
//		if(isEmpty())
//			throw new NullPointerException("Tree is Empty");
//		if(root == null ) {
//			return null;
//		}
//		if(root.data == data){
//			return root;
//		}
//		else if(root.data < data){
//			return searchDataByRecur(root.right,data);
//		}
//		else {
//			return searchDataByRecur(root.left,data);
//		}
//	}
//
//	public void inOrder(Node root){
//		if(root == null) return;
//		inOrder(root.left);
//		System.out.println(root.data);
//		inOrder(root.right);
//	}
//
//	public Node findMax(Node root){
//
//		if(root == null) 	return null;
//		while(root.right !=null) root = root.right;
//		return root;
//	}
//
//	public Node findMin(Node root){
//
//		if(root == null) 	return null;
//		while(root.left !=null) root = root.left;
//		return root;
//	}
//
//
//	public Node searchDataByLevel(Node root, int data){
//		return root;
//	}
//
//	public Node insertData(Node root, int data){
//		if(root == null){
//			root = new Node(data);
//		}
//		else {
//			if(data < root.data)	root.left = insertData(root.left, data);
//			else if(data > root.data) root.right = insertData(root.right, data);
//		}
//		return root;
//	}
//
//	/**
//	 * 이진탐색트리의 삭제 기능 구현시 고려사항
//	 * 1. 삭제할 노드가 루트노드일때
//	 * 2. 삭제할 노드의 자식노드가 1개 일때
//	 * 3. 삭제할 노드의 자식노드가 2개 이거나, 자식노드가 트리를 가질때
//	 */
//	public Node deleteData(Node root, int data){
//
//		if(root == null) throw new NoSuchElementException(data+" doesn't exist in Tree");
//
//		if(data < root.data)	root.left = deleteData(root.left, data);
//		else if(data > root.data)	root.right = deleteData(root.right, data);
//		else{
//
//			Node temp;
//
//			if(root.left !=null && root.right !=null){
//				temp = findMax(root.left);
//				root.data = temp.data;
//				root.left = deleteData(root.left, data);
//			}
//			else if( root.left  != null || root.right !=null){
//				if(root.left != null){
//						temp = findMax(root.left);
//						root.data = temp.data;
//				}
//			}
//
//		}
//		return root;
//	}
//
//	//해당 트리가 BST인지를 확인하기 위한 메서드
//
//	public boolean isBST(Node root){
//		if(root == null) return false;
//		if(root.left != null && root.left.data >= root.data) return false;
//		if(root.right != null && root.data  >= root.right.data) return false;
//		if(!isBST(root.left) || !isBST(root.right)) return false;
//		return true;
//	}
//
//	public boolean isBST2(Node root){
//		if(root == null) return false;
//		if(root.left != null && findMax(root.left).data >= root.data) return false;
//		if(root.right != null && findMin(root.right).data <= root.data) return false;
//		if(!isBST2(root.left) || !isBST2(root.right)) return false;
//		return true;
//	}
//
//	public void printInRange(Node root, int a, int b){
//		if(root == null) return;
//
//		printInRange(root.left, a, b);
//		if(a <= root.data && root.data <= b) System.out.println(root.data);
//		printInRange(root.right, a, b);
//	}
//
//}
