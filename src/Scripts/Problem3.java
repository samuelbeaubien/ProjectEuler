package Scripts;
import java.util.ArrayList;
import java.lang.*;
import java.math.BigInteger;

public class Problem3 {

	public static void main(String[] args)
	{
		
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
	
		BigInteger x1 = new BigInteger("1");
		list.add(x1);
		BigInteger x2 = new BigInteger("2");
		list.add(x2);
		BigInteger x3 = new BigInteger("3");
		list.add(x3);
		BigInteger x4 = new BigInteger("4");
		list.add(x4);
		BigInteger x5 = new BigInteger("5");
		list.add(x5);
		BigInteger x6 = new BigInteger("6");
		list.add(x6);
		BigInteger x7 = new BigInteger("7");
		list.add(x7);
		BigInteger x8 = new BigInteger("8");
		list.add(x8);
		BigInteger x9 = new BigInteger("9");
		list.add(x9);
		BigInteger x10 = new BigInteger("100");
		list.add(x10);

		removeMultiple(list, x2);
		
		
		ArrayList<BigInteger> list2 = generatePrimes(x10);
		
		
		System.out.println(list2);
		
		//ArrayList<BigInteger> listPrimes = findPrimeFactors(x, 1);
		
		//System.out.println(listPrimes);
		
	}
	/*
	
	private static ArrayList<BigInteger> findPrimeFactors(BigInteger unFactoredNumber, int factorArray)
	{
		//Initialize list of possible primes and list known factor
		ArrayList<Integer> arrayPrimes = generatePrimes((int)Math.sqrt(unFactoredNumber) * factorArray );
		ArrayList<Integer> arrayFactors = new ArrayList<Integer>();
		
		long currentNumber = unFactoredNumber; 
		
		// currentNumber is divisible by a prime, currentNumber becomes result of division and 
		// 
		
		for (int indexArrayPrimes = 0; indexArrayPrimes < arrayPrimes.size(); indexArrayPrimes++)
		{
			if (currentNumber % arrayPrimes.get(indexArrayPrimes) == 0)
			{
				arrayFactors.add(arrayPrimes.get(indexArrayPrimes));
				currentNumber = currentNumber / arrayPrimes.get(indexArrayPrimes);
			}
		}
		
		
		// Make sure the biggest have been found
		if (currentNumber > 1)
		{
			arrayFactors = findPrimeFactors(unFactoredNumber, (factorArray + 1));
		}
		
		
		return arrayFactors;
	}
	
	
	
	*/
	
	
	

	
	
	
	
	/* Implementation of the sieve of Eratosthenes
	* 1. Creates arrayNumbers with number from 2 to maxPrime
	* 2. Start with first number in arrayNumbers (necessarily prime), put it in arrayPrimes, 
	* remove all multiple of it in arrayNumber with removeMultiple
	*/
	private static ArrayList<BigInteger> generatePrimes(BigInteger maxPrime)
	{
		// Create an array of BigInteger with the max number being the the square root maxPrime
		ArrayList<BigInteger> arrayNumbers = new ArrayList<BigInteger>();
		BigInteger upperbound = sqrt(maxPrime);
		BigInteger BigOne = new BigInteger("1");
		for (BigInteger counterNumber = new BigInteger("2"); counterNumber.compareTo(maxPrime) < 1; counterNumber = counterNumber.add(BigOne))
		{
			arrayNumbers.add(counterNumber);
		}
		
		// Remove multiple until upperbound then just put remaining numbers in arrayPrimes
		ArrayList<BigInteger> arrayPrimes = new ArrayList<BigInteger>();
		while (arrayNumbers.size() > 0)
		{
			BigInteger currentNumber = arrayNumbers.get(0);
			if (currentNumber.compareTo(upperbound) >= 0)
			{
				break;
			}
			removeMultiple(arrayNumbers, currentNumber);
			arrayPrimes.add(currentNumber);
		}
	
		// Add remaining number from arrayNumbers to arrayPrimes
		if (arrayNumbers.size() > 0)
		{
			arrayPrimes.addAll(arrayNumbers);
		}
		
		return arrayPrimes;
		
	}
	

	
	// Removes all multiple of the argument 'multiple' from array currentArray
	
	private static void removeMultiple(ArrayList<BigInteger> currentArray, BigInteger multiple)
	{
		BigInteger BigZero = new BigInteger("0");
		for (int index = 0; index < currentArray.size(); index++)
		{
			if (currentArray.get(index).mod(multiple).equals(BigZero))
			{
				currentArray.remove(index);
				index--;
			}
		}
	}
	
	
	
	// Code from stackOverFlow user EdwardFalk (May 29 2013)
	// Implements square root operation for BigIntger
	
	public static BigInteger sqrt(BigInteger x) {
	    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
	    BigInteger div2 = div;
	    // Loop until we hit the same value twice in a row, or wind
	    // up alternating.
	    for(;;) {
	        BigInteger y = div.add(x.divide(div)).shiftRight(1);
	        if (y.equals(div) || y.equals(div2))
	            return y;
	        div2 = div;
	        div = y;
	    }
	}
	
	
}
