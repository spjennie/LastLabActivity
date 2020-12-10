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
	public static void main(String[] args) throws Exception
	{
		//create a Scanner object & pass the numbers.text as a parameter 
		Scanner scanner = new Scanner(new File("numbers.text"));

		//create an int variable named counter, in order to count the number of sequences 
		int counter = 0;

		//keep looping while number.text has a next Integer 
		while(scanner.hasNextInt())
		{
			//create an int variable that stores the header of each line 
			int header = scanner.nextInt();

			//create an array with the same length as the variable header 
			int[] theRest = new int[header];

			//put the rest of the sequence in the array 
			for(int i = 0; i < header; i++)
				theRest[i] = scanner.nextInt();

			//finding the average 
			int sum = 0;
			for(int i = 0; i < theRest.length; i++)
				sum+= theRest[i];
			double average = (double) sum / header; 

			//find the toString of the sequence, not including the header 
			String numbers = "";
			for(int i = 0; i < theRest.length; i++)
				numbers += theRest[i] + " ";

			//output the sequence & average 
			System.out.println("The average of the " + header + " integers " + numbers + 
					"is " + average);
			
			//increment counter 
			counter++;
		}
		System.out.println(counter + " sets of numbers processed");
	}
}
