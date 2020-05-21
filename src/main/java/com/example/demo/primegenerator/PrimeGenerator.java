package com.example.demo.primegenerator;

/**
 * Refactorings:
 * 
 * Extract Fields.
 * Extract Methods: initArrayOfIntegers, crossOutMultiples, putUncrossedIntegerIntoResult
 * Inline s with f.start
 * Rename f to isCrossed
 * Ensure for loop starts from 2
 * Extract Methods: crossOutMultipleOf, numberOfUncrossedIntegers, notCrossed
 * Rename methods to: uncrossIntegersUpTo
 * @author jacky
 * 
 */

public class PrimeGenerator {
	public int[] generatePrimes(int limit) {
		//Ensure for loop starts from 2
		int start = 2;
		if(limit < start) {
			return new int[0];
		}
		
		// declarations
		int size = limit + 1;
		boolean[] isCrossed = new boolean[size];

		initToTrue(size, isCrossed);

		// get rid of known non-primes
		isCrossed[0] = isCrossed[1] = false;

		notCrossed(size, isCrossed);

		int count = primesCount(size, isCrossed);

		int[] primes = new int[count];

		convertPrimes(size, isCrossed, primes);

		return primes;
	}

	private void convertPrimes(int size, boolean[] isCrossed, int[] primes) {
		for (int i = 0, j = 0; i < size; i++) {
			if (isCrossed[i]) {
				primes[j++] = i;
			}
		}
	}

	private int primesCount(int size, boolean[] isCrossed) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (isCrossed[i]) {
				count++;
			}
		}
		return count;
	}

	private void notCrossed(int size, boolean[] isCrossed) {
		int start = 2;
		for (int i = start; i < Math.sqrt(size) + 1; i++) {
			for (int j = start * i; j < size; j += i) {
				isCrossed[j] = false;
			}
		}
	}

	private void initToTrue(int size, boolean[] isCrossed) {
		for (int i = 0; i < size; i++) {
			isCrossed[i] = true;
		}
	}
}
