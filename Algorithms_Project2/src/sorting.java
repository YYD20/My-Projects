import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Arrays;

public class sorting {

	private static int[] arr;
	private static int[] arrCopy;
	private static int[] arrCopy2;
	private static BufferedReader read;
	private static Random randomGenerator;

	private static int size;
	private static int random;
	private static int comparisonsCount;
	//Static Variables for the final average times for sorting (to look nicer when printing)
	private static double P2aMergec1 = 0; //Problem 2a Merge Case 1 (Range 1)
	private static double P2aMergec2 = 0; //Problem 2a Merge Case 2 (Range 1)
	private static double P2aMergec3 = 0; //Problem 2a Merge Case 3 (Range 1)
	private static double P2aMergec4 = 0; //Problem 2a Merge Case 1 (Range 2)
	private static double P2aMergec5 = 0; //Problem 2a Merge Case 2 (Range 2)
	private static double P2aMergec6 = 0; //Problem 2a Merge Case 3 (Range 2)
	private static double P2bMergec1 = 0; //Problem 2b Merge Case 1 
	private static double P2bMergec2 = 0; //Problem 2b Merge Case 2 
	private static double P2bMergec3 = 0; //Problem 2b Merge Case 3 
	private static double P2bMergec4 = 0; //Problem 2b Merge Case 4 
	private static double P2bMergec5 = 0; //Problem 2b Merge Case 5 
	private static double P2bMergec6 = 0; //Problem 2b Merge Case 6 
	private static double P2cMergec1 = 0; //Problem 2c Merge Case 1 
	private static double P2cMergec2 = 0; //Problem 2c Merge Case 2 
	private static double P2cMergec3 = 0; //Problem 2c Merge Case 3 
	private static double P2cMergec4 = 0; //Problem 2c Merge Case 4 
	private static double P2cMergec5 = 0; //Problem 2c Merge Case 5 
	private static double P2cMergec6 = 0; //Problem 2c Merge Case 6 
	private static double P2dMergec1 = 0; //Problem 2d Merge Case 1 
	private static double P2dMergec2 = 0; //Problem 2d Merge Case 2 
	private static double P2dMergec3 = 0; //Problem 2d Merge Case 3 
	private static double P2dMergec4 = 0; //Problem 2d Merge Case 1 
	private static double P2dMergec5 = 0; //Problem 2d Merge Case 2 
	private static double P2dMergec6 = 0; //Problem 2d Merge Case 3 
	private static double P2aQuickc1 = 0; //Problem 2a Quick Case 1 
	private static double P2aQuickc2 = 0; //Problem 2a Quick Case 2 
	private static double P2aQuickc3 = 0; //Problem 2a Quick Case 3
	private static double P2aQuickc4 = 0; //Problem 2a Quick Case 1 
	private static double P2aQuickc5 = 0; //Problem 2a Quick Case 2 
	private static double P2aQuickc6 = 0; //Problem 2a Quick Case 3
	private static double P2bQuickc1 = 0; //Problem 2b Quick Case 1 
	private static double P2bQuickc2 = 0; //Problem 2b Quick Case 2 
	private static double P2bQuickc3 = 0; //Problem 2b Quick Case 3 
	private static double P2bQuickc4 = 0; //Problem 2b Quick Case 1 
	private static double P2bQuickc5 = 0; //Problem 2b Quick Case 2 
	private static double P2bQuickc6 = 0; //Problem 2b Quick Case 3 
	private static double P2cQuickc1 = 0; //Problem 2c Quick Case 1 
	private static double P2cQuickc2 = 0; //Problem 2c Quick Case 2 
	private static double P2cQuickc3 = 0; //Problem 2c Quick Case 3 
	private static double P2cQuickc4 = 0; //Problem 2c Quick Case 1 
	private static double P2cQuickc5 = 0; //Problem 2c Quick Case 2 
	private static double P2cQuickc6 = 0; //Problem 2c Quick Case 3 
	private static double P2dQuickc1 = 0; //Problem 2d Quick Case 1 
	private static double P2dQuickc2 = 0; //Problem 2d Quick Case 2 
	private static double P2dQuickc3 = 0; //Problem 2d Quick Case 3
	private static double P2dQuickc4 = 0; //Problem 2d Quick Case 1 
	private static double P2dQuickc5 = 0; //Problem 2d Quick Case 2 
	private static double P2dQuickc6 = 0; //Problem 2d Quick Case 3 
	private static double P3Quickc1 = 0; //Problem 3 Quick Case 1 
	private static double P3Quickc2 = 0; //Problem 3 Quick Case 2 
	private static double P3Quickc3 = 0; //Problem 3 Quick Case 3
	private static double P3Quickc4 = 0; //Problem 3 Quick Case 1 
	private static double P3Quickc5 = 0; //Problem 3 Quick Case 2 
	private static double P3Quickc6 = 0; //Problem 3 Quick Case 3
	private static double P3Arraysc1 =0;
	private static double P3Arraysc2 =0;
	private static double P3Arraysc3 =0;
	private static double P3Arraysc4 =0;
	private static double P3Arraysc5 =0;
	private static double P3Arraysc6 =0;
	private static double P3Heapc1 =0;
	private static double P3Heapc2 =0;
	private static double P3Heapc3 =0;
	private static double P3Heapc4 =0;
	private static double P3Heapc5 =0;
	private static double P3Heapc6 =0;
	private static double P4Insertc1 = 0;
	private static double P4Insertc2 = 0;
	private static double P4Insertc3 = 0;
	private static double P4Quickc1 = 0;
	private static double P4Quickc2 = 0;
	private static double P4Quickc3 = 0;
	private static double P5Heapc1 = 0;
	private static double P5Heapc2 = 0;
	private static double P5Heapc3 = 0;
	private static double P5Quickc1 = 0;
	private static double P5Quickc2 = 0;
	private static double P5Quickc3 = 0;

	private static void printArray(String msg) 
	{
		System.out.print(msg + " [" + arr[0]);
		for(int i=1; i<size; i++) {
			System.out.print(", " + arr[i]);
		}
		System.out.println("]");
	}

	public static void insertSort(int left, int right) 
	{
		// insertSort the subarray arr[left, right]
		int i, j;
		//System.out.println("Inside Insert Sort\n");
		for(i=left+1; i<=right; i++) 
		{
			//System.out.printf("%d time through loop\n",i);
			int temp = arr[i];           // store a[i] in temp
			j = i;                       // start shifts at i
			// until one is smaller,
			while(j>left && arr[j-1] >= temp) 
			{
				arr[j] = arr[j-1];        // shift item to right
				--j;                      // go left one position
			}
			arr[j] = temp;              // insert stored item
		}  // end for
	}  // end insertSort()

	public static void insertionSort() 
	{
		insertSort(0, size-1);  
	} // end insertionSort()


	public static void maxheapify(int i, int n) 
	{ 
		// Pre: the left and right subtrees of node i are max heaps.
		// Post: make the tree rooted at node i as max heap of n nodes.
		int max = i;
		int left=2*i+1;
		int right=2*i+2;

		if(left < n && arr[left] > arr[max]) 
		{
			max = left;
		}
		if(right < n && arr[right] > arr[max]) 
		{
			max = right;
		}

		if (max != i) 
		{  // node i is not maximal
			exchange(i, max);
			maxheapify(max, n);
		}
	}

	public static void exchange(int i, int j)
	{
		int t=arr[i];
		arr[i]=arr[j];
		arr[j]=t; 
	}

	public static void heapsort()
	{
		// Build an in-place bottom up max heap
		for (int i=size/2; i>=0; i--) 
		{
			maxheapify(i, size);
		}

		for(int i=size-1;i>0;i--) 
		{
			exchange(0, i);       // move max from heap to position i.
			maxheapify(0, i);     // adjust heap
		}
	}

	private static void mergesort(int low, int high) 
	{
		// Check if low is smaller then high, if not then the array is sorted
		if (low < high) 
		{
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergesort(low, middle);
			// Sort the right side of the array
			mergesort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}
	private static void mergesortWithBothIdeas(int low, int high) 
	{
		// Check if array is Sorted, if not then sort the array
		if (isSorted(low,high)) 
		{
			// do nothing //return;
		}
		else if(high-low<100)
		{
			insertSort(low,high);
		}
		else
		{
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergesortWithBothIdeas(low, middle);
			// Sort the right side of the array
			mergesortWithBothIdeas(middle + 1, high);
			// Combine them both
			merge(low, middle, high);

		}
	}
	private static void mergesortWithFirstIdea(int low, int high) 
	{
		// Check if array is Sorted, if not then sort the array
		if (isSorted(low,high)) 
		{
			// do nothing //return;
		}
		else
		{
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergesortWithFirstIdea(low, middle);
			// Sort the right side of the array
			mergesortWithFirstIdea(middle + 1, high);
			// Combine them both
			merge(low, middle, high);

		}
	}
	private static void mergesortWithSecondIdea(int low, int high) 
	{
		// Check if array is Sorted, if not then sort the array
		if (high-low<100) 
		{
			insertSort(low,high);
		}
		else
		{
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergesortWithSecondIdea(low, middle);
			// Sort the right side of the array
			mergesortWithSecondIdea(middle + 1, high);
			// Combine them both
			merge(low, middle, high);

		}
	}

	private static void merge(int low, int middle, int high) 
	{

		// Copy first part into the arrCopy array
		for (int i = low; i <= middle; i++) 
		{
			arrCopy2[i] = arr[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) 
		{

			if (arrCopy2[i] <= arr[j]) 
			{
				arr[k] = arrCopy2[i];
				i++;
			} 
			else 
			{
				arr[k] = arr[j];
				j++;
			}
			k++;
			comparisonsCount++;
		}

		// Copy the rest of the left part of the array into the target array
		while (i <= middle) 
		{
			arr[k] = arrCopy2[i];
			k++;
			i++;
		}

	}
	public static void mergesortBU(int[] array) 
	{
		int[] workArray = new int[array.length];
		int chunkSize = 1;
		while (chunkSize < array.length)
		{
			int i = 0;
			while (i < array.length - chunkSize)
			{
				mergeBU(array, i, chunkSize, workArray);
				i += chunkSize * 2;
			}
			chunkSize *= 2;
		}
	}

	public static void mergeBU(int[] array, int leftPosition, int chunkSize, int[] workArray) 
	{
		int rightPosition = leftPosition + chunkSize;
		int endPosition = Math.min(leftPosition + chunkSize * 2 - 1, array.length - 1);
		int leftIndex = leftPosition;
		int rightIndex = rightPosition;

		for (int i = 0; i <= endPosition - leftPosition; i++) 
		{

			if (leftIndex < rightPosition &&
					(rightIndex > endPosition ||
							array[leftIndex] <= array[rightIndex])) 
			{
				workArray[i] = array[leftIndex++];
			} 
			else 
			{
				workArray[i] = array[rightIndex++];
			}

		}

		for (int i = leftPosition; i <= endPosition; i++) 
		{
			array[i] = workArray[i - leftPosition];
			comparisonsCount++;
		}
	}

	private static void quicksort(int low, int high) 
	{
		int i = low, j = high;

		// Get the pivot element from the middle of the list
		int pivot = arr[(high+low)/2];

		// Divide into two lists
		while (i <= j) 
		{
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (arr[i] < pivot) i++;

			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (arr[j] > pivot) j--;

			// If we have found a value in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i < j)
			{
				exchange(i, j);
				i++;
				j--;
			} 
			else if (i == j) 
			{ 
				i++; 
				j--; 
			}
		}

		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}
	private static void quicksortWithBothIdeas(int low, int high) 
	{
		int i = low, j = high;

		// Get the pivot element from the middle of the list
		int pivot = arr[(high+low)/2];

		// Divide into two lists
		while (i <= j) 
		{
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (arr[i] < pivot) i++;

			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (arr[j] > pivot) j--;

			// If we have found a value in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i < j)
			{
				exchange(i, j);
				i++;
				j--;
			} 
			else if (i == j) 
			{ 
				i++; 
				j--; 
			}
		}
		if(isSorted(low,high))
		{
			//do nothing
		}
		else if(high-low<100)
		{
			insertSort(low,high);
		}
		else
		{
			// Recursion
			if (low < j)
				quicksortWithBothIdeas(low, j);
			if (i < high)
				quicksortWithBothIdeas(i, high);
		}
	}
	private static void quicksortWithFirstIdea(int low, int high) 
	{
		int i = low, j = high;

		// Get the pivot element from the middle of the list
		int pivot = arr[(high+low)/2];

		// Divide into two lists
		while (i <= j) 
		{
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (arr[i] < pivot) i++;

			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (arr[j] > pivot) j--;

			// If we have found a value in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i < j)
			{
				exchange(i, j);
				i++;
				j--;
			} 
			else if (i == j) 
			{ 
				i++; 
				j--; 
			}
		}
		if(isSorted(low,high))
		{
			//do nothing
		}
		else
		{
			// Recursion
			if (low < j)
				quicksortWithFirstIdea(low, j);
			if (i < high)
				quicksortWithFirstIdea(i, high);
		}
	}
	private static void quicksortWithSecondIdea(int low, int high) 
	{
		int i = low, j = high;

		// Get the pivot element from the middle of the list
		int pivot = arr[(high+low)/2];

		// Divide into two lists
		while (i <= j) 
		{
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (arr[i] < pivot) i++;

			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (arr[j] > pivot) j--;

			// If we have found a value in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i < j)
			{
				exchange(i, j);
				i++;
				j--;
			} 
			else if (i == j) 
			{ 
				i++; 
				j--; 
			}
		}
		if(high-low<100)
		{
			insertSort(low,high);
		}
		else
		{
			// Recursion
			if (low < j)
				quicksortWithSecondIdea(low, j);
			if (i < high)
				quicksortWithSecondIdea(i, high);
		}
	}
	private static boolean isSorted(int low, int high)
	{
		if(low<high)
		{
			return false;
		}
		else
			return true;
	}
	public static void Problem1Merge()
	{
		/**
		 * Problem 1
		 * Merge sort
		 * Range 1		  For 1-1,000
		 * Case 1: size = 1000000 and random = 1000; 
		 * Case 2: size = 2000000 and random = 1000;
		 * Case 3: size = 4000000 and random = 1000;
		 * Range 2		  For 1-1,000,000
		 * Case 1: size = 1000000 and random = 1000000; 
		 * Case 2: size = 2000000 and random = 1000000;
		 * Case 3: size = 4000000 and random = 1000000;

		//Case 1 Range 1
		 **/
		double start = System.currentTimeMillis();
		double finish = System.currentTimeMillis();
		size = 1000000;
		random = 1000;
		double totalTime = 0;
		double averageTime = 0;
		double compareTotal=0;
		double compareAverage=0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("MergeSort\nTesting 100 instances of 1,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			comparisonsCount = 0;
			start = finish;
			mergesort(0, size-1);
			finish = System.currentTimeMillis();
			double time = (finish-start);
			totalTime= totalTime+ time;
			compareTotal= compareTotal+comparisonsCount;
		}
		averageTime = totalTime/100;
		compareAverage = compareTotal/100;
		System.out.printf("Average Sort Time: %.2f ms\nAverage Comparisons: %.2f \n",averageTime,compareAverage);
		//Case 2 Range 1
		size = 2000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		compareTotal= 0;
		compareAverage = 0;
		System.out.println("\nTesting 100 instances of 2,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			comparisonsCount = 0;
			start = finish;
			mergesort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
			compareTotal= compareTotal+comparisonsCount;
		}
		averageTime = totalTime/100;
		compareAverage = compareTotal/100;
		System.out.printf("Average Sort Time: %.2f ms\nAverage Comparisons: %.2f \n",averageTime,compareAverage);

		//Case 3 Range 1
		size = 4000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		compareTotal= 0;
		compareAverage = 0;
		System.out.println("\nTesting 100 instances of 4,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			comparisonsCount = 0;
			start = finish;
			mergesort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
			compareTotal= compareTotal+comparisonsCount;
		}
		averageTime = totalTime/100;
		compareAverage = compareTotal/100;
		System.out.printf("Average Sort Time: %.2f ms\nAverage Comparisons: %.2f \n",averageTime,compareAverage);

		//Case 1 Range 2
		size = 1000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		compareTotal= 0;
		compareAverage = 0;
		System.out.println("\nTesting 100 instances of 1,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			comparisonsCount = 0;
			start = finish;
			mergesort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
			compareTotal= compareTotal+comparisonsCount;
		}
		averageTime = totalTime/100;
		compareAverage = compareTotal/100;
		System.out.printf("Average Sort Time: %.2f ms\nAverage Comparisons: %.2f \n",averageTime,compareAverage);

		//Case 2 Range 2
		size = 2000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		compareTotal= 0;
		compareAverage = 0;
		System.out.println("\nTesting 100 instances of 2,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			comparisonsCount = 0;
			start = finish;
			mergesort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
			compareTotal= compareTotal+comparisonsCount;
		}
		averageTime = totalTime/100;
		compareAverage = compareTotal/100;
		System.out.printf("Average Sort Time: %.2f ms\nAverage Comparisons: %.2f \n",averageTime,compareAverage);
		//Case 3 Range 2
		size = 4000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		compareTotal= 0;
		compareAverage = 0;
		System.out.println("\nTesting 100 instances of 4,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			comparisonsCount = 0;
			start = finish;
			mergesort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
			compareTotal= compareTotal+comparisonsCount;
		}
		averageTime = totalTime/100;
		compareAverage = compareTotal/100;
		System.out.printf("Average Sort Time: %.2f ms\nAverage Comparisons: %.2f \n",averageTime,compareAverage);
	}
	public static void Problem1MergeBU()
	{
		/**
		 * Problem 1
		 * Bottom Up Merge sort
		 * Range 1		  For 1-1,000
		 * Case 1: size = 1000000 and random = 1000; 
		 * Case 2: size = 2000000 and random = 1000;
		 * Case 3: size = 4000000 and random = 1000;
		 * Range 2		  For 1-1,000,000
		 * Case 1: size = 1000000 and random = 1000000; 
		 * Case 2: size = 2000000 and random = 1000000;
		 * Case 3: size = 4000000 and random = 1000000;
		 **/
		//Case 1 Range 1
		double start = System.currentTimeMillis();
		double finish = System.currentTimeMillis();
		size = 1000000;
		random = 1000;
		double totalTime = 0;
		double averageTime = 0;
		double compareTotal=0;
		double compareAverage=0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("\nBottom-Up MergeSort\nTesting 100 instances of 1,000,000 integers from 1-1000");
		//Bottom up Merge sort
		for(int k= 0;k<100;k++)
		{
			comparisonsCount=0;
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortBU(arr);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
			compareTotal= compareTotal+comparisonsCount;
		}
		averageTime = totalTime/100;
		compareAverage = compareTotal/100;
		System.out.printf("Average Sort Time: %.2f ms\nAverage Comparisons: %.2f \n",averageTime,compareAverage);
		//Case 2 Range 1
		size = 2000000;
		random = 1000;
		totalTime = 0;
		averageTime = 0;
		compareTotal=0;
		compareAverage=0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("\nTesting 100 instances of 2,000,000 integers from 1-1000");
		//Bottom up Merge sort
		for(int k= 0;k<100;k++)
		{
			comparisonsCount=0;
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortBU(arr);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
			compareTotal= compareTotal+comparisonsCount;
		}
		averageTime = totalTime/100;
		compareAverage = compareTotal/100;
		System.out.printf("Average Sort Time: %.2f ms\nAverage Comparisons: %.2f \n",averageTime,compareAverage);
		//Case 3 Range 1
		size = 4000000;
		random = 1000;
		totalTime = 0;
		averageTime = 0;
		compareTotal=0;
		compareAverage=0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("\nTesting 100 instances of 4,000,000 integers from 1-1000");
		//Bottom up Merge sort
		for(int k= 0;k<100;k++)
		{
			comparisonsCount=0;
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortBU(arr);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
			compareTotal= compareTotal+comparisonsCount;
		}
		averageTime = totalTime/100;
		compareAverage = compareTotal/100;
		System.out.printf("Average Sort Time: %.2f ms\nAverage Comparisons: %.2f \n",averageTime,compareAverage);
		//Case 1 Range 2
		size = 1000000;
		random = 1000000;
		totalTime = 0;
		averageTime = 0;
		compareTotal=0;
		compareAverage=0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("\nTesting 100 instances of 1,000,000 integers from 1-1,000,000");
		//Bottom up Merge sort
		for(int k= 0;k<100;k++)
		{
			comparisonsCount=0;
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortBU(arr);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
			compareTotal= compareTotal+comparisonsCount;
		}
		averageTime = totalTime/100;
		compareAverage = compareTotal/100;
		System.out.printf("Average Sort Time: %.2f ms\nAverage Comparisons: %.2f\n",averageTime,compareAverage);
		//Case 2 Range 2
		size = 2000000;
		random = 1000000;
		totalTime = 0;
		averageTime = 0;
		compareTotal=0;
		compareAverage=0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("\nTesting 100 instances of 2,000,000 integers from 1-1,000,000");
		//Bottom up Merge sort
		for(int k= 0;k<100;k++)
		{
			comparisonsCount=0;
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortBU(arr);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
			compareTotal= compareTotal+comparisonsCount;
		}
		averageTime = totalTime/100;
		compareAverage = compareTotal/100;
		System.out.printf("Average Sort Time: %.2f ms\nAverage Comparisons: %.2f\n",averageTime,compareAverage);
		//Case 3 Range 2
		size = 4000000;
		random = 1000000;
		totalTime = 0;
		averageTime = 0;
		compareTotal=0;
		compareAverage=0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("\nTesting 100 instances of 4,000,000 integers from 1-1,000,000");
		//Bottom up Merge sort
		for(int k= 0;k<100;k++)
		{
			comparisonsCount=0;
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortBU(arr);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
			compareTotal= compareTotal+comparisonsCount;
		}
		averageTime = totalTime/100;
		compareAverage = compareTotal/100;
		System.out.printf("Average Sort Time: %.2f ms\nAverage Comparisons: %.2f \n",averageTime,compareAverage);
	}
	public static void Problem2aMerge()
	{
		/**
		 * Problem 2a
		 * Merge sort
		 * Range 1		  For 1-1,000
		 * Case 1: size = 1000000 and random = 1000; 
		 * Case 2: size = 2000000 and random = 1000;
		 * Case 3: size = 4000000 and random = 1000;
		 * Range 2		  For 1-1,000,000
		 * Case 1: size = 1000000 and random = 1000000; 
		 * Case 2: size = 2000000 and random = 1000000;
		 * Case 3: size = 4000000 and random = 1000000;

		//Case 1 Range 1
		 **/
		double start = System.currentTimeMillis();
		double finish = System.currentTimeMillis();
		size = 1000000;
		random = 1000;
		double totalTime = 0;
		double averageTime = 0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("MergeSort with isSorted and InsertSort\nTesting 100 instances of 1,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithBothIdeas(0, size-1);
			finish = System.currentTimeMillis();
			double time = (finish-start);
			totalTime= totalTime+ time;

		}
		averageTime = totalTime/100;
		P2aMergec1 = averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 2 Range 1
		size = 2000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithBothIdeas(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2aMergec2 = averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 3 Range 1
		size = 4000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithBothIdeas(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2aMergec3=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 1 Range 2
		size = 1000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 1,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithBothIdeas(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2aMergec4=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 2 Range 2
		size = 2000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithBothIdeas(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2aMergec5=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 3 Range 2
		size = 4000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithBothIdeas(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2aMergec6=averageTime;
	}
	public static void Problem2bMerge()
	{
		double start = System.currentTimeMillis();
		double finish = System.currentTimeMillis();
		size = 1000000;
		random = 1000;
		double totalTime = 0;
		double averageTime = 0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("\nMergeSort with isSorted\nTesting 100 instances of 1,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithFirstIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time = (finish-start);
			totalTime= totalTime+ time;
		}
		averageTime = totalTime/100;
		P2bMergec1=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 2 Range 1
		size = 2000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithFirstIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2bMergec2=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 3 Range 1
		size = 4000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithFirstIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2bMergec3=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 1 Range 2
		size = 1000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 1,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithFirstIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2bMergec4=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 2 Range 2
		size = 2000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithFirstIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2bMergec5=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 3 Range 2
		size = 4000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithFirstIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2bMergec6=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

	}
	public static void Problem2cMerge()
	{
		double start = System.currentTimeMillis();
		double finish = System.currentTimeMillis();
		size = 1000000;
		random = 1000;
		double totalTime = 0;
		double averageTime = 0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("\nMergesort with insertSort\nTesting 100 instances of 1,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithSecondIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time = (finish-start);
			totalTime= totalTime+ time;
		}
		averageTime = totalTime/100;
		P2cMergec1=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 2 Range 1
		size = 2000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithSecondIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2cMergec2=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 3 Range 1
		size = 4000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithSecondIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2cMergec3=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 1 Range 2
		size = 1000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 1,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithSecondIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2cMergec4=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 2 Range 2
		size = 2000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithSecondIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2cMergec5=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 3 Range 2
		size = 4000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesortWithSecondIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2cMergec6=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

	}
	public static void Problem2dMerge()
	{
		double start = System.currentTimeMillis();
		double finish = System.currentTimeMillis();
		size = 1000000;
		random = 1000;
		double totalTime = 0;
		double averageTime = 0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("\nRegular Mergesort\nTesting 100 instances of 1,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesort(0, size-1);
			finish = System.currentTimeMillis();
			double time = (finish-start);
			totalTime= totalTime+ time;
		}
		averageTime = totalTime/100;
		P2dMergec1=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 2 Range 1
		size = 2000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2dMergec2=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 3 Range 1
		size = 4000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2dMergec3=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 1 Range 2
		size = 1000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 1,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2dMergec4=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 2 Range 2
		size = 2000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2dMergec5=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 3 Range 2
		size = 4000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			mergesort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2dMergec6=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
	}
	public static void Problem2aQuick()
	{
		/**
		 * Problem 2a
		 * Quick sort
		 * Range 1		  For 1-1,000
		 * Case 1: size = 1000000 and random = 1000; 
		 * Case 2: size = 2000000 and random = 1000;
		 * Case 3: size = 4000000 and random = 1000;
		 * Range 2		  For 1-1,000,000
		 * Case 1: size = 1000000 and random = 1000000; 
		 * Case 2: size = 2000000 and random = 1000000;
		 * Case 3: size = 4000000 and random = 1000000;

		//Case 1 Range 1
		 **/
		double start = System.currentTimeMillis();
		double finish = System.currentTimeMillis();
		size = 1000000;
		random = 1000;
		double totalTime = 0;
		double averageTime = 0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("\nQuicksort with isSorted and insertSort\nTesting 100 instances of 1,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithBothIdeas(0, size-1);
			finish = System.currentTimeMillis();
			double time = (finish-start);
			totalTime= totalTime+ time;
		}
		averageTime = totalTime/100;
		P2aQuickc1=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 2 Range 1
		size = 2000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithBothIdeas(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2aQuickc2=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 3 Range 1
		size = 4000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithBothIdeas(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2aQuickc3=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 1 Range 2
		size = 1000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 1,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithBothIdeas(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2aQuickc4=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 2 Range 2
		size = 2000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithBothIdeas(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2aQuickc5=averageTime;

		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 3 Range 2
		size = 4000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithBothIdeas(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2aQuickc6=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
	}
	public static void Problem2bQuick()
	{
		/**
		 * Problem 2b
		 * Quick sort
		 * Range 1		  For 1-1,000
		 * Case 1: size = 1000000 and random = 1000; 
		 * Case 2: size = 2000000 and random = 1000;
		 * Case 3: size = 4000000 and random = 1000;
		 * Range 2		  For 1-1,000,000
		 * Case 1: size = 1000000 and random = 1000000; 
		 * Case 2: size = 2000000 and random = 1000000;
		 * Case 3: size = 4000000 and random = 1000000;

		//Case 1 Range 1
		 **/
		double start = System.currentTimeMillis();
		double finish = System.currentTimeMillis();
		size = 1000000;
		random = 1000;
		double totalTime = 0;
		double averageTime = 0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("\nQuicksort with isSorted\nTesting 100 instances of 1,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithFirstIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time = (finish-start);
			totalTime= totalTime+ time;
		}
		averageTime = totalTime/100;
		P2bQuickc1=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 2 Range 1
		size = 2000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithFirstIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2bQuickc2=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 3 Range 1
		size = 4000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithFirstIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2bQuickc3=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 1 Range 2
		size = 1000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 1,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithFirstIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2bQuickc4=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 2 Range 2
		size = 2000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithFirstIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2bQuickc5=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 3 Range 2
		size = 4000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithFirstIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2bQuickc6=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
	}
	public static void Problem2cQuick()
	{
		/**
		 * Problem 2c
		 * Quick sort with insertSort
		 * Range 1		  For 1-1,000
		 * Case 1: size = 1000000 and random = 1000; 
		 * Case 2: size = 2000000 and random = 1000;
		 * Case 3: size = 4000000 and random = 1000;
		 * Range 2		  For 1-1,000,000
		 * Case 1: size = 1000000 and random = 1000000; 
		 * Case 2: size = 2000000 and random = 1000000;
		 * Case 3: size = 4000000 and random = 1000000;

		//Case 1 Range 1
		 **/
		double start = System.currentTimeMillis();
		double finish = System.currentTimeMillis();
		size = 1000000;
		random = 1000;
		double totalTime = 0;
		double averageTime = 0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("\nQuicksort with insertSort\nTesting 100 instances of 1,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithSecondIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time = (finish-start);
			totalTime= totalTime+ time;
		}
		averageTime = totalTime/100;
		P2cQuickc1=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 2 Range 1
		size = 2000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithSecondIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2cQuickc2=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 3 Range 1
		size = 4000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithSecondIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2cQuickc3=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 1 Range 2
		size = 1000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 1,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithSecondIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2cQuickc4=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 2 Range 2
		size = 2000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithSecondIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2cQuickc5=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 3 Range 2
		size = 4000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksortWithSecondIdea(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2cQuickc6=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
	}
	public static void Problem2dQuick()
	{
		/**
		 * Problem 2d
		 * Quick sort
		 * Range 1		  For 1-1,000
		 * Case 1: size = 1000000 and random = 1000; 
		 * Case 2: size = 2000000 and random = 1000;
		 * Case 3: size = 4000000 and random = 1000;
		 * Range 2		  For 1-1,000,000
		 * Case 1: size = 1000000 and random = 1000000; 
		 * Case 2: size = 2000000 and random = 1000000;
		 * Case 3: size = 4000000 and random = 1000000;

		//Case 1 Range 1
		 **/
		double start = System.currentTimeMillis();
		double finish = System.currentTimeMillis();
		size = 1000000;
		random = 1000;
		double totalTime = 0;
		double averageTime = 0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("\nRegular Quicksort\nTesting 100 instances of 1,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksort(0, size-1);
			finish = System.currentTimeMillis();
			double time = (finish-start);
			totalTime= totalTime+ time;
		}
		averageTime = totalTime/100;
		P2dQuickc1=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 2 Range 1
		size = 2000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2dQuickc2=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 3 Range 1
		size = 4000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2dQuickc3=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 1 Range 2
		size = 1000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 1,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2dQuickc4=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 2 Range 2
		size = 2000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2dQuickc5=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 3 Range 2
		size = 4000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			quicksort(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P2dQuickc6=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
	}
	public static void Problem2Results()
	{
		System.out.println("\nProblem 2 Results:\n1,000,000 integers from 1-1000");

		System.out.printf("\nMergesort with isSorted and insertSort: %.2f ms",P2aMergec1);
		System.out.printf("\nMergesort with isSorted : %.2f ms",P2bMergec1);
		System.out.printf("\nMergesort with insertSort: %.2f ms",P2cMergec1);
		System.out.printf("\nMergesort: %.2f ms",P2dMergec1);
		System.out.printf("\nQuicksort with isSorted and insertSort: %.2f ms",P2aQuickc1);
		System.out.printf("\nQuicksort with isSorted : %.2f ms",P2bQuickc1);
		System.out.printf("\nQuicksort with insertSort: %.2f ms",P2cQuickc1);
		System.out.printf("\nQuicksort: %.2f ms\n",P2dQuickc1);


		System.out.println("\n2,000,000 integers from 1-1000");
		System.out.printf("\nMergesort with isSorted and insertSort: %.2f ms",P2aMergec2);
		System.out.printf("\nMergesort with isSorted : %.2f ms",P2bMergec2);
		System.out.printf("\nMergesort with insertSort: %.2f ms",P2cMergec2);
		System.out.printf("\nMergesort: %.2f ms",P2dMergec2);
		System.out.printf("\nQuicksort with isSorted and insertSort: %.2f ms",P2aQuickc2);
		System.out.printf("\nQuicksort with isSorted : %.2f ms",P2bQuickc2);
		System.out.printf("\nQuicksort with insertSort: %.2f ms",P2cQuickc2);
		System.out.printf("\nQuicksort: %.2f ms\n",P2dQuickc2);

		System.out.println("\n4,000,000 integers from 1-1000");
		System.out.printf("\nMergesort with isSorted and insertSort: %.2f ms",P2aMergec3);
		System.out.printf("\nMergesort with isSorted : %.2f ms",P2bMergec3);
		System.out.printf("\nMergesort with insertSort: %.2f ms",P2cMergec3);
		System.out.printf("\nMergesort: %.2f ms",P2dMergec3);
		System.out.printf("\nQuicksort with isSorted and insertSort: %.2f ms",P2aQuickc3);
		System.out.printf("\nQuicksort with isSorted : %.2f ms",P2bQuickc3);
		System.out.printf("\nQuicksort with insertSort: %.2f ms",P2cQuickc3);
		System.out.printf("\nQuicksort: %.2f ms\n",P2dQuickc3);

		System.out.println("\n1,000,000 integers from 1-1,000,000");
		System.out.printf("\nMergesort with isSorted and insertSort: %.2f ms",P2aMergec4);
		System.out.printf("\nMergesort with isSorted : %.2f ms",P2bMergec4);
		System.out.printf("\nMergesort with insertSort: %.2f ms",P2cMergec4);
		System.out.printf("\nMergesort: %.2f ms",P2dMergec4);
		System.out.printf("\nQuicksort with isSorted and insertSort: %.2f ms",P2aQuickc4);
		System.out.printf("\nQuicksort with isSorted : %.2f ms",P2bQuickc4);
		System.out.printf("\nQuicksort with insertSort: %.2f ms",P2cQuickc4);
		System.out.printf("\nQuicksort: %.2f ms\n",P2dQuickc4);

		System.out.println("\n2,000,000 integers from 1-1,000,000");
		System.out.printf("\nMergesort with isSorted and insertSort: %.2f ms",P2aMergec5);
		System.out.printf("\nMergesort with isSorted : %.2f ms",P2bMergec5);
		System.out.printf("\nMergesort with insertSort: %.2f ms",P2cMergec5);
		System.out.printf("\nMergesort: %.2f ms",P2dMergec5);
		System.out.printf("\nQuicksort with isSorted and insertSort: %.2f ms",P2aQuickc5);
		System.out.printf("\nQuicksort with isSorted : %.2f ms",P2bQuickc5);
		System.out.printf("\nQuicksort with insertSort: %.2f ms",P2cQuickc5);
		System.out.printf("\nQuicksort: %.2f ms\n",P2dQuickc5);

		System.out.println("4,000,000 integers from 1-1,000,000");
		System.out.printf("\nMergesort with isSorted and insertSort: %.2f ms",P2aMergec6);
		System.out.printf("\nMergesort with isSorted : %.2f ms",P2bMergec6);
		System.out.printf("\nMergesort with insertSort: %.2f ms",P2cMergec6);
		System.out.printf("\nMergesort: %.2f ms",P2dMergec6);
		System.out.printf("\nQuicksort with isSorted and insertSort: %.2f ms",P2aQuickc6);
		System.out.printf("\nQuicksort with isSorted : %.2f ms",P2bQuickc6);
		System.out.printf("\nQuicksort with insertSort: %.2f ms",P2cQuickc6);
		System.out.printf("\nQuicksort: %.2f ms\n",P2dQuickc6);

	}
	private static void QuicksortProblem3(int low, int high) 
	{
		int i = low, j = high;
		int middleindex = arr[(high+low)/2] ;
		int lowindex =  arr[low];
		int highindex =  arr[high];
		int pivot=0;
		if(lowindex > middleindex &&lowindex < highindex)
		{
			pivot = lowindex;
		}
		else if(lowindex < middleindex && middleindex < highindex)
		{
			pivot = middleindex;
		}
		else
		{
			pivot = highindex;
		}

		// Divide into two lists
		while (i <= j) 
		{
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (arr[i] < pivot)
			{
				i++;
			}

			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (arr[j] > pivot)
			{
				j--;
			}

			// If we have found a value in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i < j)
			{
				exchange(i, j);
				i++;
				j--;
			} 
			else if (i == j) 
			{ 
				i++; 
				j--; 
			}
		}

		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}
	public static void Problem3()
	{
		/**
		 * Problem 3
		 * Quick sort with different pivots
		 * Range 1		  For 1-1,000
		 * Case 1: size = 1000000 and random = 1000; 
		 * Case 2: size = 2000000 and random = 1000;
		 * Case 3: size = 4000000 and random = 1000;
		 * Range 2		  For 1-1,000,000
		 * Case 1: size = 1000000 and random = 1000000; 
		 * Case 2: size = 2000000 and random = 1000000;
		 * Case 3: size = 4000000 and random = 1000000;

		//Case 1 Range 1
		 **/
		double start = System.currentTimeMillis();
		double finish = System.currentTimeMillis();
		size = 1000000;
		random = 1000;
		double totalTime = 0;
		double averageTime = 0;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		System.out.println("Quicksort with different pivots\nTesting 100 instances of 1,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			QuicksortProblem3(0, size-1);
			finish = System.currentTimeMillis();
			double time = (finish-start);
			totalTime= totalTime+ time;
		}
		averageTime = totalTime/100;
		P3Quickc1=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 2 Range 1
		size = 2000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			QuicksortProblem3(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Quickc2=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 3 Range 1
		size = 4000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			QuicksortProblem3(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Quickc3=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 1 Range 2
		size = 1000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 1,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			QuicksortProblem3(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Quickc4=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);

		//Case 2 Range 2
		size = 2000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			QuicksortProblem3(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Quickc5=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Case 3 Range 2
		size = 4000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			QuicksortProblem3(0, size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Quickc6=averageTime;
		//		System.out.printf("Average Sort Time: %.2f ms\n",averageTime);
		//Arrays.sort
		//Case 1 Range 1
		size = 1000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("\nArrays.sort\nTesting 100 instances of 1,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			Arrays.sort(arr);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Arraysc1=averageTime;
		//Case 2 Range 1
		size = 2000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			Arrays.sort(arr);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Arraysc2=averageTime;
		//Case 3 Range 1
		size = 4000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			Arrays.sort(arr);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Arraysc3=averageTime;
		//Case 1 Range 2
		size = 1000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 1,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			Arrays.sort(arr);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Arraysc4=averageTime;
		//Case 2 Range 2
		size = 2000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			Arrays.sort(arr);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Arraysc5=averageTime;
		//Case 1 Range 2
		size = 4000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			Arrays.sort(arr);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Arraysc6=averageTime;
		//Heap Sort
		//Case 1 Range 1
		size = 1000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("\nHeapsort\nTesting 100 instances of 1,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			heapsort();
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Heapc1=averageTime;
		//Case 2 Range 1
		size = 2000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			heapsort();
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Heapc2=averageTime;
		//Case 3 Range 1
		size = 4000000;
		random = 1000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			heapsort();
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Heapc3=averageTime;
		//Case 1 Range 1
		size = 1000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 1,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			heapsort();
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Heapc4=averageTime;
		//Case 1 Range 1
		size = 2000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			heapsort();
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Heapc5=averageTime;
		//Case 1 Range 1
		size = 4000000;
		random = 1000000;
		// create array
		arr = new int[size];
		arrCopy = new int[size];
		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		System.out.println("Testing 100 instances of 4,000,000 integers from 1-1,000,000");
		for(int k= 0;k<100;k++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			start = finish;
			heapsort();
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}
		averageTime = totalTime/100;
		P3Heapc6=averageTime;
		Problem2dQuick();
		Problem2cMerge();
	}
	public static void Problem3Results()
	{
		System.out.println("\nProblem 3 Results:\n1,000,000 integers from 1-1000");
		System.out.printf("Quicksort: %.2f ms\n",P2dQuickc1);
		System.out.printf("Modified Quicksort: %.2f ms\n",P3Quickc1);
		System.out.printf("Arrays.sort: %.2f ms\n",P3Arraysc1);
		System.out.printf("Heapsort: %.2f ms\n",P3Heapc1);
		System.out.printf("Mergesort: %.2f ms\n",P2cMergec1);
		System.out.println("2,000,000 integers from 1-1000");
		System.out.printf("Quicksort: %.2f ms\n",P2dQuickc2);
		System.out.printf("Modified Quicksort: %.2f ms\n",P3Quickc2);
		System.out.printf("Arrays.sort: %.2f ms\n",P3Arraysc2);
		System.out.printf("Heapsort: %.2f ms\n",P3Heapc2);
		System.out.printf("Mergesort: %.2f ms\n",P2cMergec2);
		System.out.println("4,000,000 integers from 1-1000");
		System.out.printf("Quicksort: %.2f ms\n",P2dQuickc3);
		System.out.printf("Modified Quicksort: %.2f ms\n",P3Quickc3);
		System.out.printf("Arrays.sort: %.2f ms\n",P3Arraysc3);
		System.out.printf("Heapsort: %.2f ms\n",P3Heapc3);
		System.out.printf("Mergesort: %.2f ms\n",P2cMergec3);
		System.out.println("1,000,000 integers from 1-1,000,000");
		System.out.printf("Quicksort: %.2f ms\n",P2dQuickc4);
		System.out.printf("Modified Quicksort: %.2f ms\n",P3Quickc4);
		System.out.printf("Arrays.sort: %.2f ms\n",P3Arraysc4);
		System.out.printf("Heapsort: %.2f ms\n",P3Heapc4);
		System.out.printf("Mergesort: %.2f ms\n",P2cMergec4);
		System.out.println("2,000,000 integers from 1-1,000,000");
		System.out.printf("Quicksort: %.2f ms\n",P2dQuickc5);
		System.out.printf("Modified Quicksort: %.2f ms\n",P3Quickc5);
		System.out.printf("Arrays.sort: %.2f ms\n",P3Arraysc5);
		System.out.printf("Heapsort: %.2f ms\n",P3Heapc5);
		System.out.printf("Mergesort: %.2f ms\n",P2cMergec5);
		System.out.println("4,000,000 integers from 1-1,000,000");
		System.out.printf("Quicksort: %.2f ms\n",P2dQuickc6);
		System.out.printf("Modified Quicksort: %.2f ms\n",P3Quickc6);
		System.out.printf("Arrays.sort: %.2f ms\n",P3Arraysc6);
		System.out.printf("Heapsort: %.2f ms\n",P3Heapc6);
		System.out.printf("Mergesort: %.2f ms\n",P2cMergec6);
	}
	public static void Problem4()
	{

		//Case1 Range 1
		double start = System.currentTimeMillis();
		double finish = System.currentTimeMillis();
		size = 2000000;
		random = 10000;

		arrCopy2 = new int[size];
		double totalTime=0;
		double averageTime=0;
		arr = new int[size];
		arrCopy = new int[size];
		// Insert sort on nearly-sorted array 
		System.out.println("\nInsertsort\nTesting 100 instances of 2,000,000 integers from 1-10,000");
		for(int m =0; m<100;m++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			Arrays.sort(arr);
			// arr[0..size-1] is already sorted. We randomly swap 100 pairs to make it nearly-sorted.
			for (int i = 0; i < 100; i++) 
			{
				int j  = randomGenerator.nextInt(size);
				int k  = randomGenerator.nextInt(size);
				exchange(j, k);
			}
			//System.out.println("Past 1st 4loop");
			for(int i=0; i<size; i++)
			{
				arrCopy2[i] = arr[i];
			}
			start = finish;
			insertSort(0,size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}

		averageTime = totalTime/100;
		P4Insertc1=averageTime;
		//Case 1 Range 2
		start = System.currentTimeMillis();
		finish = System.currentTimeMillis();
		size = 2000000;
		random = 100000;

		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		arr = new int[size];
		arrCopy = new int[size];
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-100,000");
		// Insert sort on nearly-sorted array      
		for(int m =0; m<100;m++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			Arrays.sort(arr);
			// arr[0..size-1] is already sorted. We randomly swap 100 pairs to make it nearly-sorted.
			for (int i = 0; i < 100; i++) 
			{
				int j  = randomGenerator.nextInt(size);
				int k  = randomGenerator.nextInt(size);
				exchange(j, k);
			}
			for(int i=0; i<size; i++)
			{
				arrCopy2[i] = arr[i];
			}
			start = finish;
			insertSort(0,size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}

		averageTime = totalTime/100;
		P4Insertc2=averageTime;
		//Case 1 Range 3
		start = System.currentTimeMillis();
		finish = System.currentTimeMillis();
		size = 2000000;
		random = 1000000;

		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		arr = new int[size];
		arrCopy = new int[size];
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		// Insert sort on nearly-sorted array      
		for(int m =0; m<100;m++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			Arrays.sort(arr);
			// arr[0..size-1] is already sorted. We randomly swap 100 pairs to make it nearly-sorted.
			for (int i = 0; i < 100; i++) 
			{
				int j  = randomGenerator.nextInt(size);
				int k  = randomGenerator.nextInt(size);
				exchange(j, k);
			}
			for(int i=0; i<size; i++)
			{
				arrCopy2[i] = arr[i];
			}
			start = finish;
			insertSort(0,size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}

		averageTime = totalTime/100;
		P4Insertc3=averageTime;
		//Case 2 Range 1
		start = System.currentTimeMillis();
		finish = System.currentTimeMillis();
		size = 2000000;
		random = 10000;

		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		arr = new int[size];
		arrCopy = new int[size];
		System.out.println("\nQuicksort\nTesting 100 instances of 2,000,000 integers from 1-10,000");
		// Insert sort on nearly-sorted array      
		for(int m =0; m<100;m++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			Arrays.sort(arr);
			// arr[0..size-1] is already sorted. We randomly swap 100 pairs to make it nearly-sorted.
			for (int i = 0; i < 100; i++) 
			{
				int j  = randomGenerator.nextInt(size);
				int k  = randomGenerator.nextInt(size);
				exchange(j, k);
			}
			for(int i=0; i<size; i++)
			{
				arrCopy2[i] = arr[i];
			}
			start = finish;
			quicksort(0,size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}

		averageTime = totalTime/100;
		P4Quickc1=averageTime;
		//Case 2 Range 1
		start = System.currentTimeMillis();
		finish = System.currentTimeMillis();
		size = 2000000;
		random = 100000;

		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		arr = new int[size];
		arrCopy = new int[size];
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-100,000");
		// Insert sort on nearly-sorted array      
		for(int m =0; m<100;m++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			Arrays.sort(arr);
			// arr[0..size-1] is already sorted. We randomly swap 100 pairs to make it nearly-sorted.
			for (int i = 0; i < 100; i++) 
			{
				int j  = randomGenerator.nextInt(size);
				int k  = randomGenerator.nextInt(size);
				exchange(j, k);
			}
			for(int i=0; i<size; i++)
			{
				arrCopy2[i] = arr[i];
			}
			start = finish;
			quicksort(0,size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}

		averageTime = totalTime/100;
		P4Quickc2=averageTime;
		//Case 2 Range 3
		start = System.currentTimeMillis();
		finish = System.currentTimeMillis();
		size = 2000000;
		random = 1000000;

		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		arr = new int[size];
		arrCopy = new int[size];
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		// Insert sort on nearly-sorted array      
		for(int m =0; m<100;m++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			Arrays.sort(arr);
			// arr[0..size-1] is already sorted. We randomly swap 100 pairs to make it nearly-sorted.
			for (int i = 0; i < 100; i++) 
			{
				int j  = randomGenerator.nextInt(size);
				int k  = randomGenerator.nextInt(size);
				exchange(j, k);
			}
			for(int i=0; i<size; i++)
			{
				arrCopy2[i] = arr[i];
			}
			start = finish;
			quicksort(0,size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}

		averageTime = totalTime/100;
		P4Quickc3=averageTime;
	}
	public static void Problem4Results()
	{
		System.out.println("\nProblem 4 Results:\n2,000,000 integers from 1-10,000");
		System.out.printf("Insertsort: %.2f ms\n",P4Insertc1);
		System.out.printf("Quicksort: %.2f ms\n",P4Quickc1);
		System.out.println("2,000,000 integers from 1-100,000");
		System.out.printf("Insertsort: %.2f ms\n",P4Insertc2);
		System.out.printf("Quicksort: %.2f ms\n",P4Quickc2);
		System.out.println("2,000,000 integers from 1-1,000,000");
		System.out.printf("Insertsort: %.2f ms\n",P4Insertc3);
		System.out.printf("Quicksort: %.2f ms\n",P4Quickc3);

	}
	public static void Problem5()
	{
		//Case1 Range 1
		double start = System.currentTimeMillis();
		double finish = System.currentTimeMillis();
		size = 2000000;
		random = 10000;

		arrCopy2 = new int[size];
		double totalTime=0;
		double averageTime=0;
		arr = new int[size];
		arrCopy = new int[size];
		// Heapsort on nearly-sorted array 
		System.out.println("\nHeapsort\nTesting 100 instances of 2,000,000 integers from 1-10,000");
		for(int m =0; m<100;m++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			Arrays.sort(arr);
			for(int i=size-1; i>0; i--)
			{
				arrCopy2[i] = arr[i];
			}
			start = finish;
			heapsort();
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}

		averageTime = totalTime/100;
		P5Heapc1=averageTime;
		//Case 1 Range 2
		start = System.currentTimeMillis();
		finish = System.currentTimeMillis();
		size = 2000000;
		random = 100000;

		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		arr = new int[size];
		arrCopy = new int[size];
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-100,000");
		// Heapsort on nearly-sorted array      
		for(int m =0; m<100;m++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			Arrays.sort(arr);
			for(int i=size-1; i>0; i--)
			{
				arrCopy2[i] = arr[i];
			}
			start = finish;
			heapsort();
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}

		averageTime = totalTime/100;
		P5Heapc2=averageTime;
		//Case 1 Range 3
		start = System.currentTimeMillis();
		finish = System.currentTimeMillis();
		size = 2000000;
		random = 1000000;

		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		arr = new int[size];
		arrCopy = new int[size];
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		// Heapsort on nearly-sorted array      
		for(int m =0; m<100;m++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			Arrays.sort(arr);
			for(int i=size-1; i>0; i--)
			{
				arrCopy2[i] = arr[i];
			}
			start = finish;
			heapsort();
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}

		averageTime = totalTime/100;
		P5Heapc3=averageTime;
		//Case 2 Range 1
		start = System.currentTimeMillis();
		finish = System.currentTimeMillis();
		size = 2000000;
		random = 10000;

		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		arr = new int[size];
		arrCopy = new int[size];
		System.out.println("\nQuicksort\nTesting 100 instances of 2,000,000 integers from 1-10,000");
		// Insert sort on nearly-sorted array      
		for(int m =0; m<100;m++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			Arrays.sort(arr);

			for(int i=size-1; i>0; i--)
			{
				arrCopy2[i] = arr[i];
			}
			start = finish;
			quicksortWithFirstIdea(0,size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}

		averageTime = totalTime/100;
		P5Quickc1=averageTime;
		//Case 2 Range 1
		start = System.currentTimeMillis();
		finish = System.currentTimeMillis();
		size = 2000000;
		random = 100000;

		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		arr = new int[size];
		arrCopy = new int[size];
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-100,000");
		// Quick sort on nearly-sorted array      
		for(int m =0; m<100;m++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			Arrays.sort(arr);

			for(int i=size-1; i>0; i--)
			{
				arrCopy2[i] = arr[i];
			}
			start = finish;
			quicksortWithFirstIdea(0,size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}

		averageTime = totalTime/100;
		P5Quickc2=averageTime;
		//Case 2 Range 3
		start = System.currentTimeMillis();
		finish = System.currentTimeMillis();
		size = 2000000;
		random = 1000000;

		arrCopy2 = new int[size];
		totalTime=0;
		averageTime=0;
		arr = new int[size];
		arrCopy = new int[size];
		System.out.println("Testing 100 instances of 2,000,000 integers from 1-1,000,000");
		// Quicksort on nearly-sorted array      
		for(int m =0; m<100;m++)
		{
			for(int i=0; i<size; i++)
			{
				arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
			}
			Arrays.sort(arr);
			for(int i=size-1; i>0; i--)
			{
				arrCopy2[i] = arr[i];
			}
			start = finish;
			quicksortWithFirstIdea(0,size-1);
			finish = System.currentTimeMillis();
			double time= (finish-start);
			totalTime=totalTime+time;
		}

		averageTime = totalTime/100;
		P5Quickc3=averageTime;
	}
	public static void Problem5Results()
	{
		System.out.println("\nProblem 5 Results:\n2,000,000 integers from 1-10,000");
		System.out.printf("Heapsort: %.2f ms\n",P5Heapc1);
		System.out.printf("Quicksort: %.2f ms\n",P5Quickc1);
		System.out.println("2,000,000 integers from 1-100,000");
		System.out.printf("Heapsort: %.2f ms\n",P5Heapc2);
		System.out.printf("Quicksort: %.2f ms\n",P5Quickc2);
		System.out.println("2,000,000 integers from 1-1,000,000");
		System.out.printf("Heapsort: %.2f ms\n",P5Heapc3);
		System.out.printf("Quicksort: %.2f ms\n",P5Quickc3);
	}
	public static void main(String[] args) 
	{
		randomGenerator = new Random();
		System.out.println("Problem 1\n");
		Problem1Merge();
		Problem1MergeBU();
		System.out.println("Problem 2\n");
		Problem2aMerge();
		Problem2bMerge();
		Problem2cMerge();
		Problem2dMerge();
		Problem2aQuick();
		Problem2bQuick();
		Problem2cQuick();
		Problem2dQuick();
		Problem2Results();
		System.out.println("Problem 3\n");
		Problem3();
		Problem3Results();
		System.out.println("Problem 4\n");
		Problem4();
		Problem4Results();
		System.out.println("Problem 5\n");
		Problem5();
		Problem5Results();
	}
}