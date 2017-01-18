package Scripts;
import java.util.ArrayList;
import java.lang.*;

public class Problem3 {

	public static void main(String[] args)
	{
	
		ArrayList<Integer> listPrimes = generatePrimes(100);
		
		
		
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
