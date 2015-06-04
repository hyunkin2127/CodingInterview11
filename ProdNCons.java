import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class ProdNCons {

	protected LinkedList list = new LinkedList();
	protected int MAX = 10; // Queue 크기
	protected boolean done = false;


	//생산자
	class Producer extends Thread {
		public void run(){
			while(true){
				synchronized (list) {
					while(list.size() == MAX){
							try {
								System.out.println("Producer is Waiting");
								list.wait();
							} catch (InterruptedException e) {
								System.out.println("Producer is Interrupted");
								e.printStackTrace();
							}
							list.addFirst(new Date().toString());
							System.out.println("Produced 1; List size is " + list.size());
							list.notifyAll();
//							System.out.println("Produced 1; List size is " + list.size());
							
					}
				}//end of synchronized
			}// end of while(true)
		}//end of run
	} // end of producer

	//소비자
	class Consumer extends Thread {
		public void run(){
			while(true){
				Object obj = null;
				synchronized (list) {
					while(list.size() == 0){
						try {
							System.out.println("Consumer is Waiting");
							list.wait();
						} catch (InterruptedException e) {
							System.out.println("Consumer is interrupted");
							e.printStackTrace();
						}
						
						System.out.println(123123 +" "+ list.size());
						obj = list.removeLast();
						System.out.println(obj);
						list.notifyAll();
						System.out.println("List size is " + list.size());
					} // end of while(true)
				} //end of synchronized
			} // end of while(true) 
		} // end of run
	} // end of thread

	public ProdNCons(int nP, int nC) {
		for(int i=0; i<nP; i++){
			new Producer().start();
			System.out.println("Producer is Started : "+i +"  //  "+ list.size());
		}
		for(int j=0; j<nC; j++){
			new Consumer().start();
			System.out.println("Consumer is Started : "+j);

		}
	}
}
