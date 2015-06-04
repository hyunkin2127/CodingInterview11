import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class ProdNCons2 {

	BlockingQueue queue;

	Producer p;
	Consumer c;

	public ProdNCons2(BlockingQueue queue) {
			p = new Producer(queue);
			c = new Consumer(queue);
	}


	class Producer implements Runnable {

		private BlockingQueue queue;

		public Producer(BlockingQueue queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
					Date d = new Date();
					String msg = "메시지"+d.toString();
					queue.add(msg);
					System.out.println("메시지를 생성합니다. [" + queue.size() + "]");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


	class Consumer implements Runnable {

		private BlockingQueue queue;

		public Consumer(BlockingQueue queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
					String msg = (String) queue.take();
					System.out.println("메시지를 꺼냅니다. : " + msg + "[" + queue.size() + "]");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


}
