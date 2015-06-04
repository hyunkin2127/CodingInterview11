package linkedList;

import java.util.ArrayList;

public class DoubleLinkedList implements Cloneable{

	enum Fruit{ 
		//상수를 대입할 필요가 없고 자체가 상수역할을 한다
		// public static final이  선언되어있는것과 같음.
		APPLE, PEACH, BANANA;
	}
	enum Company{
		GOOGLE, APPLE, ORACLE;
	}
	
	
	
	public DoubleLinkedList() {
		super();
		ArrayList<Integer> ab = new ArrayList<Integer>();
		ab.get(0);
	}

 
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	public void test(){

		try{
			
		}catch(ArrayIndexOutOfBoundsException e){
			e.getMessage();
		}catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		finally{
			
		}


	}
	
	class A <T, S>{
		public T a;
		public S b;
		
		public <T> void print(){
			
		}
		
	}
	
	A<LinkedList, Node> a = new A<LinkedList, Node>();
	
}