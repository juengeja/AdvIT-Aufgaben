package Aufgabe10;

import java.util.concurrent.Semaphore;

public class FifoWorker extends Thread implements Runnable{

	private FifoQueue queue;
	private String threadName;
	private Semaphore sem;

	public FifoWorker(FifoQueue queue, String threadName, Semaphore sem) {
		this.queue = queue;
		this.threadName = threadName;
		this.sem = sem;
	}

	public void run() {
		try {
			sem.acquire();
			queue.put(threadName + "1");
			queue.put(threadName + "2");
			queue.get();
			queue.put(threadName + "3");
			sem.release();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			sem.acquire();
			queue.put(threadName + "4");
			queue.get();
			sem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
