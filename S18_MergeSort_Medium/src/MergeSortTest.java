/**
 * Class to test MergeSort
 * @author Nick Kozak
 *
 */
public class MergeSortTest 
{
	/**
	 * This method will automatically be called when BucketSortTest is run
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(String[] args)
	{
		MergeSort M = new MergeSort();//Creates a MergeSort object 
		//Generates a random number between 0 and 30 for the array size
		int A[] = new int[100];
		for(int j =0;j<A.length;j++)
		{
			A[j]= (int)(1000* Math.random());//generates a random number between 0 and 30 to fill the array
		}
		System.out.printf("\nUnsorted Array A: ");
		M.printRegularArray(A);
		System.out.printf("\nMerge Sort A: ");
	    M.mergeSort(A,0,A.length-1);//uses mergesort for array a
	    M.printMergeSort(A);//prints the merge sort for array a
	}
}
