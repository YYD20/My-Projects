/**
 * MergeSort Class that contains 3 public methods
 * @author Nick Kozak
 *
 */
public class MergeSort 
{
	/**
	 * Sorting method for Merge Sort
	 * @param A
	 * Array that needs to be sorted
	 * @param low
	 * Lowest index of the array 
	 * @param high
	 * highest index of the array
	 */
	public void mergeSort(int[] A, int low, int high)
	{
	    if(low == high)//returns if there are no more indices to sort
	    {
	        return;
	    }
	    else
	    {
	    	int middle = (low+high)/2;//finds middle of array
	        //Recursive Sort
	        mergeSort(A, low, middle);//sorts first half of array
	        mergeSort(A, middle+1, high);//sorts second half of array
	        
	        int [] temp = new int[A.length];//temporary array for holding values
	        int range = 1+ high-low;//calculates the range
	        int i = low, j = middle+1; 
	        for (int k = 0; k < range; k++) //iterates through the array and sorts the values for the second half of the array
	            {
	                if (i <= middle && j<=high)
	                {
	                	if(A[i]<= A[j])
	                	{
	                		temp[k] = A[i++];//assigns the value to indice above the middle
	                	}
	                	else
	                	{
	                		temp[k] = A[j++];//assigns the value to the indice above the middle
	                	}
	                }
	                else //assigns the value to indice above the low(first index of the array)
	                {
	                	if(i<=middle)
	                	{
	                		temp[k] = A[i++];//assigns the value to the indice below the middle of the array
	                    }
	                	else
	                	{
	                		temp[k]= A[j++];//assigns the value to the indice above the middle of the array
	                	}
	                }
	        }    
	        for (int k = 0; k < range; k++) 
	        {
	            A[low + k] = temp[k]; //fills the temporary array for the first half
	        }
	    }
	}
	/*
	 * Void method that prints the unsorted Array
	 */
	public void printRegularArray(int [] A)
	{
	    for(int i :A)//iterates through the array and prints out the indices
	    {
	        System.out.print(i+" ");
	    }
	}
	/*
	 * Void method that prints the sorted array
	 */
	public void printMergeSort(int [] A)
	{
		mergeSort(A,0,A.length-1);//calls merge sort for array a until the array is sorted
	    for(int i :A)//iterates through the array and prints out the indices
	    {
	        System.out.print(i+" ");
	    }
	}
}
