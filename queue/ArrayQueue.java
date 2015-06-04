package queue;

public class ArrayQueue <T> {
	T[] repository;
	int front;
	int rear;


	public ArrayQueue(int size){
//		this.repository = new T[size];
		this.repository = (T[])new Object[size];
		this.front = 0;
		this.rear = 0;
	};

	public boolean isEmpty(){
		return (this.rear == this.front);
//		if(this.rear == 0) return true;
//		else return false;
	}

	private boolean isFull(){
		return(this.rear == this.repository.length);
//		if(this.rear == this.repository.length) return true;
//		else return false;
	}

	private void remakeQueue(){  //큐가 가득차면 배열의 길이를 2배로 늘려 재배치
//		T[] tempArray = new T[repository.length * 2];
		T[] tempArray = (T[])new Object[repository.length * 2];

		int tempFront = this.front;
		this.front = 0;
		this.rear = 0;
		
		for(int i = 0; tempFront<this.repository.length; i++, tempFront++){
			tempArray[i] = this.repository[tempFront];
			rear++;
		}
		this.repository = tempArray;
	}

	public void enQueue(T data){  // 데이터삽입
		if(isFull()) remakeQueue(); // 큐가 가득찼을경우 큐 크기를 키움
		this.repository[this.rear++] = data;
//		this.rear++;
	};

	public T deQueue(){  // 데이터추출
		if(isEmpty()) System.out.println("Empty Queue"); // 빈 큐일때 처리 부분 필요함
		return this.repository[this.front++];
	};

	public void printQueue(){ // 현재 큐 정보 출력
		for(T elem : this.repository){
			System.out.println("elem : " +elem);
		};
		System.out.println(isFull());
		System.out.println("front : "+front);
		System.out.println("rear : "+rear);
		
	};
	
}
/**
 package queue;

public  class ArrayQueue {
	int[] repository;
	int front, rear;


	public ArrayQueue(int size){
		this.repository = new int[size];
		this.front = 0;
		this.rear = 0;
	};

	public boolean isEmpty(){
		return (this.rear == 0);
//		if(this.rear == 0) return true;
//		else return false;
	}

	private boolean isFull(){
		return(this.rear == this.repository.length);
//		if(this.rear == this.repository.length) return true;
//		else return false;
	}

	private void remakeQueue(){  //큐가 가득차면 배열의 길이를 2배로 늘려 재배치
		int[] tempArray = new int[repository.length * 2];

		int tempFront = this.front;
		this.front = 0;
		this.rear = 0;

		for(int i = 0; tempFront<this.repository.length; i++, tempFront++){
			tempArray[i] = this.repository[tempFront];
			rear++;
		}
		this.repository = tempArray;
	}

	public void enQueue(int data){  // 데이터삽입
		if(isFull()) remakeQueue(); // 큐가 가득찼을경우 큐 크기를 키움
		this.repository[this.rear] = data;
		this.rear++;
	};

	public int deQueue(){  // 데이터추출
		if(isEmpty()) System.out.println("Empty Queue"); // 빈 큐일때 처리 부분 필요함
		return this.repository[this.front++];
	};

	public void printQueue(){ // 현재 큐 정보 출력
		for(int elem : this.repository){
			System.out.println("elem : " +elem);
		};
		System.out.println(isFull());
		System.out.println("front : "+front);
		System.out.println("rear : "+rear);
	};
}*/
