package linkedList;

public class LinkedList {
	private Node head;
	private int size;

	public LinkedList() {
		this.head = null;
		this.size = 0;
	};

	private boolean isEmpty(){
		if(this.head == null || this.size <= 0) return true;
		else return false;
	}

	public void insert(int data){

		Node newNode = new Node(data);
		if(isEmpty()) {
			this.head = newNode;
		}
		else {
			Node cursor = this.head;
			while(cursor.next != null){
				cursor = cursor.next;
			}
			cursor.next = newNode;
		}
		this.size++;
		return ;
	};

	public void deleteNode(int data){

		if(isEmpty()) {
			System.out.println("Empty List");
			return ;
		}
		else if(this.size == 1){
			if(this.head.data == data){
				this.head = null;
				this.size --;
				return ;
			}
		}

		Node currentNode = this.head.next;
		Node prevNode = this.head;
		while(currentNode != null ){
			if(currentNode.data == data){
				prevNode.next = currentNode.next;
				this.size--;
				return;
			}

			prevNode = currentNode;
			currentNode = currentNode.next;
		}

		System.out.println("Data isn't exist in List");
		return;
	};

	public void printList(){
		if(isEmpty()){
			System.out.println("Empty List");
			return;
		}
		Node currentNode= this.head;
		System.out.println("List size : " + this.size);
		while(currentNode != null){
			System.out.println("data : "+ currentNode.data);
			currentNode = currentNode.next;
		}
	}

	//	public Node search(int data){
	//		if(isEmpty()){
	//			System.out.println("Empty List");
	//		}
	//		Node currentNode = this.head;
	//		while(currentNode != null){
	//			if(currentNode.data == data) return currentNode;
	//		}
	//	}


}


