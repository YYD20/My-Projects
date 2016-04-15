import java.util.*;
import java.lang.*;
/*
 * Algorithms Project 3
 * CS:3330:002
 * @author Nick Kozak
 * 	00817758
 */

public class ClosestPair {

	private static Random randomGenerator;  // for random numbers
	private static int DistCalls = 0;
	//private static int DisSimDistCalls = 0;

	public static class Point implements Comparable<Point> 
	{  

		public long x, y;

		// Constructor
		public Point(long x, long y) 
		{
			this.x = x;
			this.y = y;
		}

		public int compareTo(Point p) 
		{
			// compare this and p and there are three results: >0, ==0, or <0
			if (this.x == p.x) 
				if (this.y == p.y) return 0;
				else return (this.y > p.y)? 1 : -1;
			else return (this.x > p.x)? 1 : -1;
		}

		public String toString() 
		{
			return " ("+Long.toString(this.x)+","+Long.toString(this.y)+")";
		}

		public double distance(Point p) 
		{
			long dx = (this.x - p.x);
			long dy = (this.y - p.y);
			DistCalls++;
			return Math.sqrt(dx*dx + dy*dy);
		}
	}

	public static Point[] plane;
	public static Point[] newplane;
	public static Point[] finalplane;

	public static int N;   // number of points in the plane

	public static void main(String[] args) 
	{

		// Read in the Size of a maze
		Scanner scan = new Scanner(System.in);         
		try 
		{	     
			System.out.println("How many points in your plane? ");
			N = scan.nextInt();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		scan.close();
		/*N = 1000;
		while(N!=1000000)
		{*/
		//System.out.println("How many points in your plane? ");

		// Create plane of N points.
		plane = new Point[N];
		finalplane = new Point[N];
		//finalplane  = new Point[N];
		randomGenerator = new Random();

		for (int i = 0; i < N; ++i) 
		{ 
			long x = randomGenerator.nextInt(N<<6);
			long y = randomGenerator.nextInt(N<<6);
			plane[i] = new Point(x, y);
		}
		Arrays.sort(plane); // sort points according to compareTo.
		for (int i = 1; i < N; ++i)  // make all x's distinct.
		{
			if (plane[i-1].x >= plane[i].x) 
			{
				plane[i].x = plane[i-1].x + 1;	
			}
		}
		System.out.println("--------------------------------------------------------------");
		System.out.println(N + " points are randomly created.");		
		System.out.println("The first two points are"+plane[0]+" and"+plane[1]);
		System.out.println("The distance of the first two points is "+plane[0].distance(plane[1]));

		// Compute the minimal distance of any pair of points by exhaustive search.
		double start = System.currentTimeMillis();
		double min1 = minDisSimple();
		double finish = System.currentTimeMillis();
		double time = (finish - start);
		System.out.println("\nBruteForce");
		System.out.printf("The distance of the two closest points is %.5f\n",min1);
		System.out.printf("BruteForce Time Completion: %.2f ms\nCalls to distance: %d\n",time,DistCalls);
		// Compute the minimal distance of any pair of points by divide-and-conquer
		DistCalls = 0;
		double newstart = System.currentTimeMillis();
		double min2 = minDisDivideConquer(0, N-1);
		double newfinish = System.currentTimeMillis();
		double newtime = (newfinish - newstart);
		System.out.println("\nDivide and Conquer");
		System.out.printf("The distance of the two closest points is %.5f\n",min2);
		System.out.printf("Divide and Conquer Time Completion: %.2f ms\nCalls to distance: %d\n",newtime,DistCalls);
		System.out.println("--------------------------------------------------------------");


		//N=N+1000;
		//}
	}
	static double minDisSimple() 
	{
		// A straightforward method for computing the distance 
		// of the two closest points in plane[0..N-1].
		double min = Double.MAX_VALUE;
		for (int i = 0; i < N-1; i++) 
		{
			for (int j = i+1; j < N ; j++)
			{
				if (plane[i].distance(plane[j]) < min) 
				{
					min = plane[i].distance(plane[j]);
				}
			}
		}
		return min;
	}

	static void exchange(int i, int j) 
	{
		Point x = plane[i];
		plane[i] = plane[j];
		plane[j] = x;
	}

	static double minDisDivideConquer(int low, int high) 
	{
		// Pre: points in plane[0..N-1] are sorted by x-coordinate and high > low.
		// Post: return the minimal distance of any pair of points in plane[low..high];
		//       and make sure points in plane[low..high] are sorted by y-coordinate.
		// Hint: On the top of page 195 of the textbook, it suggests to use array Y which keeps 
		//       a copy of points sorted by y-coordinate. An alternative is to keep the points 
		//       sorted by y-coordinate using the idea of merge sort.
		/*if(high - low+1<=3)
		{
			return minDisSimple();
		}*/
		if (high == low+1 ) 
		{ // two points
			if (plane[low].y > plane[high].y)
			{
				exchange(low, high);
			}
			//DivConqDistCalls++;
			return plane[low].distance(plane[high]);
		} 
		else if (high == low+2) 
		{ // three points
			// sort these points by y-coordinate
			if (plane[low].y > plane[high].y)
			{
				exchange(low, high);
			}
			if (plane[low].y > plane[low+1].y)
			{
				exchange(low, low+1);
			}
			else if (plane[low+1].y > plane[high].y) 
			{
				exchange(low+1, high);
			}
			// compute pairwise distances
			double d1 = plane[low].distance(plane[high]);
			double d2 = plane[low].distance(plane[low+1]);
			double d3 = plane[low+1].distance(plane[high]);
			return ((d1 < d2)? ((d1 < d3)? d1 : d3) : (d2 < d3)? d2 : d3);  // return min(d1, d2, d3)
		} 
		else 
		{  // 4 or more points: Divide and conquer
			// to be completed
			int middle = (high + low)/2;
			int k = 0;
			double left = minDisDivideConquer(low,middle);
			double right = minDisDivideConquer(middle+1,high);
			double minimum = Math.min(left, right);
			//Optimized algorithm suggests we should divide N/4 to beat brute force in time complexity 
			//This could give different distances though, so a check is added to see if the distances are equal
			for(int i = 0; i<N;i++)
			{
				if(Math.abs(plane[i].x - plane[middle].x )< minimum)
				{
					finalplane[k] = plane[i];
					k = k+1;
				}//end if
			}//end for
			double finalmin = minimum;
			for(int i = 1; i< k-1; i++)
			{
				for (int j = i+1; j< Math.min(i+7, k);j++)
				{
					if(finalplane[i].distance(finalplane[j])< finalmin)
					{
						finalmin = finalplane[i].distance(finalplane[j]);
					}
				}//end for
			}//end for
			minimum = Math.min(minimum,finalmin);
			return minimum;
		}
	}
}