package chapter02.item05;

public class SlowBoxedPrimitives
{

	public static void sumOfAllIntegers()
	{
		Long sum = 0L;
		
		long startTime = System.nanoTime();
		
		for (int i = 0; i < Integer.MAX_VALUE; i++)
		{
			sum += i;
		}
		
		long endTime = System.nanoTime();
		
		System.out.println(sum + " in :" + printTimeElapsed(startTime, endTime));
	}

	public static void sumOfAllInts()
	{
		long sum = 0L;

		long startTime = System.nanoTime();

		for (int i = 0; i < Integer.MAX_VALUE; i++)
		{
			sum += i;
		}
		
		long endTime = System.nanoTime();

		System.out.println(sum + " in :" + printTimeElapsed(startTime, endTime));
	}

	public static String printTimeElapsed(long startTime, long endTime)
	{
		long elapsedTime = endTime - startTime;
		double seconds = elapsedTime / 1.0E09;
		return seconds + " seconds";
	}

	
	
	public static void main(String[] args)
	{
		sumOfAllIntegers();
		sumOfAllInts();
		
		/*RESULTS:
		 * 
		 *	2305843005992468481 in :7.25514 seconds
		 *	2305843005992468481 in :0.852349 seconds
		 *
		 *
		 *	--------
		 *	CPU: Intel i5 2.4 Ghz / 8GB 1600 Mhz DDR3 
		 *	OS:  OS X 10.9.4 (13E28) 
		 *	JV:  jdk.1.7.0_60 
		 *
		 */
	}

}
