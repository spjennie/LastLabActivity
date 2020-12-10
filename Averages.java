package calculatingAverages;
import java.io.File;
import java.util.Scanner;

/**
 * <p>Title: The Averages Class</p>
 * 
 * <p>Description: The Averages Class reads sequences & prints their averages from the file numbers.text. 
 * This file consists of sequences of numbers, each sequence preceded by a header value and then followed by that many integers.
 * When all sequences have been read in, it then prints out the number of sequences processed.</p>
 * 
 * @author Jennie Kang // Id: 23412538
 */
public class Averages 
{
	static int sum;
	
	//method to calculate average
	static double average(int[] array)
	{
		sum = 0;
		for(int i = 0; i < array.length; i++)
			sum+= array[i];
		
		return (double) sum / array.length;
	}
	
	public static void main(String[] args) throws Exception
	{
		//create a Scanner object & pass the numbers.text as a parameter 
		Scanner scanner = new Scanner(new File("numbers.text"));

		//create an int variable named counter, in order to count the number of sequences 
		int counter = 0;

		//keep looping while number.text has a next Integer 
		while(scanner.hasNextInt())
		{
			//create an array with the same length as the first number of each line
			int[] numbers = new int[scanner.nextInt()];

			//put the rest of the sequence in the array 
			for(int i = 0; i < numbers.length; i++)
				numbers[i] = scanner.nextInt();

			//find the average 
			double average = average(numbers);

			//find the toString of the sequence, not including the header 
			String values = "";
			for(int i = 0; i < numbers.length; i++)
				values += numbers[i] + " ";

			//output the sequence & average 
			if(numbers.length > 1)
			{
				System.out.println("The average of the " + numbers.length + " integers " + values + 
						"is " + average);
			}
			else
			{
				System.out.println("There is only " + numbers.length + " integer, " + values + "so the average"
						+ " is " + average);
			}
			
			//increment counter 
			counter++;
		}
		System.out.println(counter + " sets of numbers processed");
	}
}
