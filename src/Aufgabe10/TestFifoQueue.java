package Aufgabe10;

import java.util.concurrent.Semaphore;

public class TestFifoQueue {
	
	private static Semaphore semaphore = new Semaphore(1);
	
	public static void main(String[] args) {
		
		FifoQueue myFifoQueue = new FifoQueue();
		
		myFifoQueue.put("Mein erster String");
		myFifoQueue.put("Noch ein String");
		myFifoQueue.put("Der dritte String");
		
		printQueue(myFifoQueue);
		
		FifoWorker workerOne = new FifoWorker(myFifoQueue, "firstWorker", semaphore);
		FifoWorker workerTwo = new FifoWorker(myFifoQueue, "secondWorker", semaphore);
		
		workerOne.start();
		workerTwo.start();
		FifoWorker.yield();
		try {
			workerOne.join();
			workerTwo.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		printQueue(myFifoQueue); // Ohne Semaphor: Bei mehrfachem Ausführen entstehen Fehler
		
	}
	
	private static void printQueue(FifoQueue queue) {
		String out = "null";
		while(!out.equals("Empty queue!")) {
			out = queue.get();
			System.out.println(out);
		}
	}

}
