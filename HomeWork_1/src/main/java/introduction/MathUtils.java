package introduction;

public class MathUtils {

	/**
	 * Returns the greatest common divider of given two numbers
	 * 
	 * @param firstNumber
	 *            - positive number
	 * @param secondNumber
	 *            - positive number
	 * @return greatest common divider of two numbers
	 */
	public int getGreatestCommonDivider(int firstNumber, int secondNumber) {
		if (firstNumber == secondNumber)
			return firstNumber;
		if (firstNumber == 0)
			return secondNumber;
		if (secondNumber == 0)
			return firstNumber;

		if ((firstNumber & 1) == 0){
			if ((secondNumber & 1) == 1)
				return getGreatestCommonDivider(firstNumber >> 1, secondNumber);
			else
				return getGreatestCommonDivider(firstNumber >> 1, secondNumber >> 1) << 1;
		}
		if ((secondNumber & 1) == 0)
			return getGreatestCommonDivider(firstNumber, secondNumber >> 1);
		if (firstNumber > secondNumber)
			return getGreatestCommonDivider((firstNumber - secondNumber) >> 1, secondNumber);

		return getGreatestCommonDivider((secondNumber - firstNumber) >> 1, firstNumber);
	}

	/**
	 * Returns sum of digits of the given number
	 * 
	 * @param number
	 *            - positive number
	 * @return the sum of digits of the given number
	 */
	public int getSumOfDigits(int number) {
		int sum = 0;
		while (number > 0){
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

	/**
	 * Checks if the given number is prime or not
	 * 
	 * @param number
	 * @return true - if number is prime, if not return false
	 */
	public boolean isPrime(int number) {
		if (number % 2 == 0)
			return false;
		for(int i = 3; i * i <= number; i += 2) {
			if(number % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * Returns sum of row: 1! - 2! + 3! - 4! + 5! - ... + n!
	 * 
	 * @param n
	 *            - positive number
	 */
	public int getSumOfRow(int n) {
		if (n == 1)
			return 1;
		int sumOfRow = 1;
		int[] factorials = new int[n + 1];
		factorials[0] = factorials[1] = 1;
		for (int i = 2; i <= n; i++){
			factorials[i] = i * factorials[i - 1];
			if ((i & 1) == 0)
				sumOfRow -= factorials[i];
			else
				sumOfRow += factorials[i];
		}
		return sumOfRow;
	}

	/**
	 * Returns Fibonacci series of a specified length
	 * 
	 * @param length
	 *            - the length of the Fibonacci series
	 * @return array filled with Fibonacci series
	 */
	public int[] getFibonacciSeries(int length){
		if (length < 1)
			return new int[]{};
		int[] fibNumbers = new int[length];
		fibNumbers[0] = fibNumbers[1] = 1;
		int i = 2;
		while (i < length){
			fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
			i++;
		}
		return fibNumbers;
	}

	/**
	 * Returns array with prime numbers
	 * 
	 * @param length
	 *            - the length of prime numbers series
	 * @return array filled with prime numbers
	 */
	public int[] getPrimeSeries(int length) {
		if (length < 1)
			return new int[]{};
		int[] primeNumbers = new int[length];
		primeNumbers[0] = 2;

		for (int count = 1, number = 3; count < length; number++) {
			boolean isPrime = true;
			for (int i = 0; i < count; i++) {
				if (number % primeNumbers[i] == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primeNumbers[count] = number;
				count++;
			}
		}
		return primeNumbers;
	}
}
