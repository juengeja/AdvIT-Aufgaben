package Aufgabe9;

import java.util.Arrays;

public class SumThreadLess {
	
	public static void main(String[] args) {
		int finalSum;
		int[] numberArray = new int[2097152];
		
		Arrays.fill(numberArray, 10);

		final long timeStart = System.nanoTime();
		finalSum = sum(numberArray);
		final long timeEnd = System.nanoTime();
		
		System.out.println("Summe des Arrays: " + finalSum);
		System.out.println("Benötigte Zeit zur Summenbildung: " + (timeEnd - timeStart) + "Nanosekunden.");
	}
	
	public static int sum(int[] array) {
		int summe = 0;

		for (int j : array) {
			summe += j;
		}
		return summe;
	}
}
