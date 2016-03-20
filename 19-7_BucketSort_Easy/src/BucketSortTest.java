/**
 * Class to test BucketSort
 * @author Nick Kozak
 *
 */
public class BucketSortTest 
{
	/**
	 * This method will automatically be called when BucketSortTest is run
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(String[] args)
	{
		int A[] = new int[100];//Creates an array of 100 integers 
		for(int i =0;i<A.length;i++)
		{
			A[i]= (int)(100* Math.random());//generates a random number between 0 and 99 to fill the array
		}
		BucketSort bs = new BucketSort();//creates a bucket sort object
		System.out.printf("\nUnsorted Array A: \n");
		bs.printUnsortedArray(A);//calls the method to print the unsorted array
		bs.sort(A);//sorts the array using bucketSort
		System.out.printf("\nBucket Sort A: \n");
		bs.printBucketSort(A);//prints the sorted array
	}
}
