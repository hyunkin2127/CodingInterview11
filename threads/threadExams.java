package threads;

/**
 * Created by Heon on 2015-10-29.
 */
public class threadExams  {


	int globalV;
	byExtends Ethread;
	byInterface Ithread;

	public threadExams(){
		globalV = 0;
		Ethread = new byExtends();
		Ithread = new byInterface();
	}

	public void processThread(){
		Ethread.start();
		new Thread(Ithread).start();
	}

	private synchronized void setGlobalV( int len){
		for(int i=0; i<len; i++){
				globalV++;
		}
		System.out.println(getGlobalV());
	};

	public int getGlobalV(){
		return globalV;
	}

	class byExtends extends Thread {

		public void run(){
			setGlobalV(50000);
		}
	}

	class byInterface implements Runnable{

		@Override
		public void run() {
			setGlobalV(50000);
		}
	}



}
