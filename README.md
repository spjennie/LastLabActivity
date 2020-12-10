# LastLabActivity

For this last lab activity, I took a program that I wrote in the past and made changes to to the code in order to improve it. 

The code that I chose to revise reads sequences & prints their averages from the file numbers.text. This file consists of sequences of numbers, each sequence preceded by a header value and then followed by that many integers. When all sequences have been read in, it then prints out the number of sequences processed.

# Code Revision
## Finding the average
In my original code, I calculated the numbers in the while loop in the main class. For my revision, I made a separate method called average, outside of the main class, so I am able to call that method when needed in the main class.

original code:

//finding the average 
int sum = 0;
for(int i = 0; i < theRest.length; i++)
  sum+= theRest[i];
double average = (double) sum / header; 
      
revised code:

//method the calculate average
static double average(int[] array)
{
  sum = 0;
  for(int i = 0; i < array.length; i++)
    sum+= array[i];
    
  return (double) sum / array.length;
	}
 
 in the main class:
//find the average 
double average = average(numbers);
 
## Variable Usage
For my original code, I created an int variable that stores the header for each line. This header indicates how many numbers there are on the line, which is the length of the array. For my revised code, I took out this variable and decided to read the next integer directly for the array length, and then use the length of the array to refer to the header number. 

original code: 

//create an int variable that stores the header of each line 
int header = scanner.nextInt();

//create an array with the same length as the variable header 
int[] theRest = new int[header];
      
revised code: 

//create an array with the same length as the first number of each line
int[] numbers = new int[scanner.nextInt()];

## Variable Change
Originally, I had referred to the array as theRest because I had stored the first number of the line to another variable called header, to indicate the length of the array, and then stored "the rest" of the numbers into the array. After my revision of directly reading the next integer for the array length, I modified the name of the array to numbers. 

original code:

//put the rest of the sequence in the array 
for(int i = 0; i < header; i++)
  theRest[i] = scanner.nextInt();
  
revised code: 

//put the rest of the sequence in the array
for(int i = 0; i < numbers.length; i++)
  numbers[i] = scanner.nextInt();
  
I had to change the name of the String variable to values from numbers because I had changed the array to numbers.

original code:

//find the toString of the sequence, not including the header 
String numbers = "";
for(int i = 0; i < theRest.length; i++)
  numbers += theRest[i] + " ";
  
revised code:

//find the toString of the sequence, not including the header 
String values = "";
for(int i = 0; i < numbers.length; i++)
  values += numbers[i] + " ";
  
## Output Change
Orginally, the output followed this format: The average of the 3 integers 1 2 3 is 2.0
I saw that there was a line that only had one integer, so I revised the code so that if there was only one integer the output would follow this format:
There is only 1 integer, 17 so the average is 17.0

original code:

//output the sequence & average 
System.out.println("The average of the " + header + " integers " + numbers + 
					"is " + average);
          
revised code:

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
      
As I looked back at the code that I had originally wrote, I realized that I have learned new methods from the time that I had created the code to now. It was also helpful to look back at previous code because it felt like I was looking at my code for the first time, so I was able to pick out things to change more easily. Through the lab I realize how much I am constantly learning and that it is a good idea to look at previous code after some time to find ways to improve it.
