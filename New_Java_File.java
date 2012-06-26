import java.util.*;
//Rahul Mehan, HW# 2, CSE 373 
//This program finds the first non-zero index of a value in a array 
//It runs on O(Log N) speed

public class FirstNonSmaller {

	public static void main(String[] args) {
		int[] array = createRandomSortedArray(1500);
		System.out.println(Arrays.toString(array));
		long start = System.nanoTime();
		 firstNonSmallerIndex(array, 3);
		 long estimate = System.nanoTime() - start;
		 System.out.println("Time:" + estimate);
		firstNonSmallerIndex(array, 7);
		firstNonSmallerIndex(array, 1);
		firstNonSmallerIndex(array, 2);
		firstNonSmallerIndex(array, 4);
	}
	
	//This method prints out the first non - smaller index of a number stored in a array.
	//Two parameters: one is array and other one is the number which needs to be found in that array
	public static void firstNonSmallerIndex(int[] array, int digit){
		System.out.println(binarySearch(array, digit));
	}

	//This is a generic binarySearch which looks for the first non-smaller index of the passed number
	//Two parameters: one is array and other one is the number which needs to be found in that array
	//returns -1 if number is greater than the last value, 0 if the number is lower than the first value
	public static int binarySearch(int[] array, int digit){
		if (digit > array[array.length -1]) {
			return -1;
		}
		else if (digit < array[0] ){
			return 0;
		} else {
			return binarySearch(array, digit, 0, array.length -1);
		}
	}

	//This is a helper method for the Generic binarySearch 
	//Four Paramnerts: Array, number to be found in the array, minimum index and maximum index 
	//returns the the index if number is found and does recursion once if the number is not in mid. 
	

	//Creates a random Array to test the program 
	public static int[] createRandomSortedArray(int size) {
		Random rand = new Random();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			// pick random numbers (subtract a bit so that some 
			// are negative)
			array[i] = rand.nextInt(size * 3) - size / 4;
		}
		Arrays.sort(array);
		return array;
	}

}
