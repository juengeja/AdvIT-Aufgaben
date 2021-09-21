package Aufgabe9;

import java.util.Arrays;

public class SumWithThreads extends Thread{

	private final int id;
	private final int[] array;
	private final int numberOfThreads;
	private int teilsumme;

	public static void main(String[] args) {

		int threads = 128;

		SumWithThreads[] MyThreads = new SumWithThreads[threads];
		int[] arrayForAll = new int[2097152];
		Arrays.fill(arrayForAll, 10);
		int gesamtSumme = 0;

		final long timeStart = System.nanoTime();
		for(int i = 1; i <= threads; i++) {
			MyThreads[i-1] = new SumWithThreads(i, arrayForAll, threads);
			MyThreads[i-1].start();
		}
		for (int i = 1; i <= threads; i++) {
			try {
				MyThreads[i-1].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gesamtSumme += MyThreads[i-1].getTeilsumme();
		}
		System.out.println("Benötigte Zeit: " + (System.nanoTime() - timeStart) + " Nanosekunden.");
		System.out.println("Gesamtsumme: " + gesamtSumme);
	}

	public SumWithThreads( int id, int[] array, int numberOfThreads ) {
		this.id = id;
		this.array = array;
		this.numberOfThreads = numberOfThreads;
	}

	public void run() {
		for(int i = this.id; i <= this.array.length; i += this.numberOfThreads) {
			this.teilsumme += this.array[i-1];
		}
	}

	public int getTeilsumme() {
		return this.teilsumme;
	}
}
