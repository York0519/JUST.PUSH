package com.example.demo.primegenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
* @ClassName: PrimeGeneratorTest
* @Description:
* @Author: York
* @Date: 2018/7/10 0010 10:01
* @Version: V1.0
*/
public class PrimeGeneratorTest {

	@Test
	public void testPrimes() {
		int[] nullArray = new PrimeGenerator().generatePrimes(0);
		assertEquals(0, nullArray.length);

		int[] minArray = new PrimeGenerator().generatePrimes(2);
		assertEquals(1, minArray.length);
		assertEquals(2, minArray[0]);

		int[] threeArray = new PrimeGenerator().generatePrimes(3);
		assertEquals(2, threeArray.length);
		assertEquals(2, threeArray[0]);
		assertEquals(3, threeArray[1]);

		int[] centArray = new PrimeGenerator().generatePrimes(100);
		assertEquals(25, centArray.length);
		assertEquals(97, centArray[24]);

	}

	@Test
	public void testExhaustive() {
		int start = 2;
		int length = 500;
		for (int i = start; i < length; i++) {
			verifyPrimeList(new PrimeGenerator().generatePrimes(i));
		}

	}

	private void verifyPrimeList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			verifyPrime(list[i]);
		}

	}

	private void verifyPrime(int n) {
		for (int factor = 2; factor < n; factor++) {
			assertTrue(n % factor != 0);
		}
	}

}
