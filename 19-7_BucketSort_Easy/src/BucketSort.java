/**
 * Bucket Sort class contains 3 public methods and 4 private methods
 * @author Nick Kozak
 *
 */
public class BucketSort 
{
	/**
	 * This method will automatically be called when BucketSortTest is run
	 */
	private  final int rowSize=10;//10 individual buckets
	/**
	 * Sorting method for bucket sort
	 * @param A
	 * Array that needs to be sorted
	 */
	public void sort(int A[])
	{
		final int columnSize = A.length-1;//Size of the column defined by the book
		int totalDigitPlaces = numberOfDigitPlaces(A);//gets the number of digits in the largest number
		int bucket[][] = new int[rowSize][columnSize];
		for (int pass = 0 ; pass < totalDigitPlaces; pass++)//goes through passes to sort the buckets (1st pass is 1's, then 10's, then 100's
		{
			insertElements(A,bucket,pass);//inserts the array, bucket, and pass number so the numbers can be inserted into the bucket
			getElements(A,bucket);//gets the elements inside the bucket
			if(pass!= totalDigitPlaces)//checks to see if all the passes have been completed
			{
				clearBucket(bucket);//clears the bucket if passes aren't complete
			}
		}
	}
	/**
	 * inserts the elements into the bucket array
	 * @param a
	 * Array containing the values
	 * @param bucket
	 * 2d Array of the bucket that holds all the values that need to be sorted
	 * @param pass
	 * Passes in the variable for which pass through the bucket is being sorted
	 */
	private void insertElements(int a[],int bucket[][],int pass)
	{
		int divisor = 10;
		int bucketNum;
		int elementNum;
		for (int i = 0; i < pass ;i++)
		{
			divisor *=10;//for each pass, the divisor in multiplied by 10 (for 1's, 10's, 100's, etc)
		}
		for(int i =0;i<a.length;i++)
        {
            bucketNum = (a[i] % divisor - (a[i] % (divisor/10)) ) / (divisor/10);//computes the row number for the value to be sorted in the bucket
            elementNum = ++bucket[bucketNum][0];//column number for putting element into the  bucket row from above
            bucket[bucketNum][elementNum] = a[i];//inserts the number from the 1d array of numbers into the bucket array
        }

	}	
	/**
	 * gets the elements of the bucket and puts them into a 1d array
	 * @param a
	 * Array containing the values
	 * @param bucket
	 * 2d Array of the bucket that holds all the values that need to be sorted
	 */
	private void getElements(int a[], int bucket[][])
	{
		int elementNum = 0;
		for( int i =0; i< 10;i++)
		{
			for (int j=1; j<= bucket[i][0];j++)
			{
				a[elementNum] = bucket[i][j];//inserts the number from the bucket array into the 1d array
				elementNum++;//sets the next element number 
			}
		}
	}
	/**
	 * resets the bucket values to 0 for each pass
	 * @param bucket
	 * 2d Array of the bucket that holds all the values that need to be sorted
	 */
	private void clearBucket(int bucket[][])
	{
		for (int i = 0; i < rowSize; i++)
		{
			for (int j= 0; j< bucket.length;j++)
			{
				bucket[i][j]=0;//sets the bucket value to 0
			}
		}
	}
	/**
	 * calculates the amount of number places in the largest number
	 * @param a
	 * Array containing the values
	 * @return numOfDigits
	 * Returns the number of digits in the largest number
	 */
	private int numberOfDigitPlaces(int a[]){
        int largestNum = a[0];
        int numofDigits = 0;
        for (int i =0; i<a.length;i++)
        {
            if (a[i] > largestNum)//checks to see if the current value in the array is larger than the 1st index
                largestNum = a[i];//assigns a new largest number
        }
        while (largestNum!=0)
        {
            numofDigits++;//keeps track of the number of digits in a number
            largestNum/=10;
            
        }
        return numofDigits;
    }
	/**
	 * prints the unsorted array
	 * @param A
	 * Array containing the unsorted values
	 */
	public void printUnsortedArray(int [] A)
	{
		for(int i :A)//iterates through the array and prints out the indices
		{
			System.out.print(i+" ");
		}
	}
	/**
	 * prints the sorted array
	 * @param A
	 * Array containing the unsorted values
	 */
	public void printBucketSort(int [] A)
	{
		sort(A);//uses merge sort for array a
		for(int i :A)//iterates through the array and prints out the indices
		{
			System.out.print(i+" ");
		}
	}
}
