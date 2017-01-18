package Scripts;

public class Problem1 {

	public static void main(String[] args)
	{
		
		int sum = 0; 
		
		sum = multipleAdder(3, 1000);
		
		sum = sum + multipleAdderWithAvoider(5, 1000, 3);

		System.out.println(sum);
	}
	
	private static int multipleAdder(int multiple, int maxNumber)
	{
		int sum = 0;
		
		for (int currentNumber = 0; currentNumber < maxNumber; currentNumber = currentNumber + multiple)
		{
			sum = sum + currentNumber;
		}
		
		return sum; 
	}
	
	private static int multipleAdderWithAvoider(int multiple, int maxNumber, int avoidii)
	{
		int sum = 0;
		
		for (int currentNumber = 0; currentNumber < maxNumber; currentNumber = currentNumber + multiple)
		{
			
			if (currentNumber%avoidii != 0)
			{
				sum = sum + currentNumber;
			}
		}
		
		return sum; 
	}
	
	
}
