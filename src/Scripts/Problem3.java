package Scripts;
import java.util.ArrayList;
import java.lang.*;

public class Problem3 {

	public static void main(String[] args)
	{
	
		ArrayList<Integer> listPrimes = findPrimeFactors(13195, 1);
		
	}
	
	
	private static ArrayList<Integer> findPrimeFactors(int unFactoredNumber, int factorArray)
	{
		//Initialize list possible primes and list prime factor
		ArrayList<Integer> arrayPrimes = generatePrimes((int)Math.sqrt(unFactoredNumber) * factorArray );
		ArrayList<Integer> arrayPrimeFactors = new ArrayList<Integer>();
		
		int currentNumber = unFactoredNumber; 
		
		// currentNumber is divisible by a prime, currentNumber becomes result of division and 
		// 
		
		for (int indexArrayPrimes = 0; indexArrayPrimes < arrayPrimes.size(); indexArrayPrimes++)
		{
			if (currentNumber % arrayPrimes.get(indexArrayPrimes) == 0)
			{
				arrayPrimeFactors.add(arrayPrimes.get(indexArrayPrimes));
				currentNumber = currentNumber / arrayPrimes.get(indexArrayPrimes);
			}
		}
		
		
		// Make sure the biggest have been found
		if (currentNumber > 1)
		{
			arrayPrimeFactors = findPrimeFactors(unFactoredNumber, (factorArray + 1));
		}
		
		
		return arrayPrimeFactors;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// Implementation of the sieve of Eratosthenes
	
	private static ArrayList<Integer> generatePrimes(int maxPrime)
	{
		
		// Create an array of number with the max number being the maxPrime
		
		ArrayList<Integer> arrayNumbers = new ArrayList<Integer>();
		
		int upperbound = (int) Math.sqrt(maxPrime);
		
		for (int counterNumber = 2; counterNumber <= maxPrime; counterNumber++)
		{
			arrayNumbers.add(counterNumber);
		}
		
		ArrayList<Integer> arrayPrimes = new ArrayList<Integer>();
		arrayPrimes.add(0);
		arrayPrimes.add(1);
		
		while (arrayNumbers.size() > 0)
		{
			int currentNumber = arrayNumbers.get(0);
			removeMultiple(arrayNumbers, currentNumber);
			arrayPrimes.add(currentNumber);
		}
		
		return arrayPrimes;
		
	}
	
	
	private static ArrayList<Integer> removeMultiple(ArrayList<Integer> currentArray, int multiple)
	{
		
		for (int index = 0; index < currentArray.size(); index++)
		{
			if (currentArray.get(index) % multiple == 0)
			{
				currentArray.remove(index);
			}
		}
		
		return currentArray;
	}
	
	
}
