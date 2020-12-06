package org.lba.util;

import java.util.Random;

public class GenerateRandomNumbers {

	private GenerateRandomNumbers() {}

	public static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random randomGenerator = new Random();
		return randomGenerator.nextInt((max - min) + 1) + min;
	}
}
