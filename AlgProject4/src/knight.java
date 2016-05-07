import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 * The knight class provides a static main
 * method to read the dimensions of a board and
 * print a solution of the knight tour.
 *
 * See <a href="http://en.wikipedia.org/wiki/Knight%27s_tour">Wikipedia:
 * Knight's tour</a> for more information.
 *
 * The algorithm employed is similar to the standard backtracking
 * <a href="http://en.wikipedia.org/wiki/Eight_queens_puzzle">eight
 * queens algorithm</a>.
 *
 */

public class knight {

	static long recurCalls = 0;      // number of recursive calls to solve()
	static long recurCallsH = 0;      // number of recursive calls to solveWarnsdorff()
	static long recurCallsCF = 0;      // number of recursive calls to solveClosedFixed()
	static long recurCallsC = 0;      // number of recursive calls to solveCLosed()
	static final int[][] direction={ {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1} };
	static int M = 4;
	static int N = 4;
	static int[][] Board;
	//static final int MaxStep = N*M;
	private static BufferedReader read;
	static int iStart = 0;
	static int jStart = 0;
	static int iPrev = 0;
	static int jPrev = 0;
	static int CurrStep = 0;
	static Random randNum;

	static boolean solve(int step, int i, int j) 
	{
		// recursive backtrack search.
		recurCalls++;
		Board[i][j] = step;
		//System.out.printf("Step: %d\n",step);
		if (step == N*M) return true;  // all positions are filled
		for (int k = 0; k < 8; k++) 
		{
			int i1 = i+direction[k][0];
			int j1 = j+direction[k][1];
			if (0 <= i1 && i1 < N && 0 <= j1 && j1 < M && Board[i1][j1] == 0) 
			{
				if (solve(step+1, i1, j1)) return true;
			}
		}
		Board[i][j] = 0; // no more next position, reset on backtrack
		return false;
	}
	//Warnsdorf Heuristic Added Below
	//Method check to see if the move on the board is valid
	static boolean isValidMove(int x, int y)
	{
		return ( x < N  && x >= 0 && y < M  && y >=0  &&
				Board[x][y] == 0 );
	}
	static boolean isValidMoveEnd(int x, int y)
	{
		return ( x < N  && x >= 0 && y < M  && y >=0  &&
				Board[x][y] == 1 );
	}
	static int degree(int x, int y)
	{
		int deg = 0;
		for(int i = 0; i < 8 ; i++)
		{
			if ( isValidMove(x + direction[i][0], y + direction[i][1] ) )
			{
				deg++;
			}
		}
		return deg;
	}
	static boolean solveWarnsdorff(int step, int i, int j)
	{
		// Warnsdorf Heurisitc Approach
		recurCallsH++;
		int degree = 8;

		Board[i][j] = step;
		if (step == N*M) return true;
		for (int k = 0; k < 8; k++) 
		{
			int i1 = i+direction[k][0];
			int j1 = j+direction[k][1];
			int newDegree = degree(i1,j1);
			if (isValidMove(i1,j1) && newDegree<degree)
			{ 
				degree = newDegree;
				if (solveWarnsdorff(step+1,i1, j1))
				{
					i = i1;
					j = j1;
					return true;
				}
				else 	
				{
					Board[i1][j1] = 0;
				}
			}
		}
		return false;
	}
	static boolean solveClosed(int step, int i, int j)
	{
		// Warnsdorf Heurisitc Approach with for closed path

		recurCallsC++;
		int degree = 8;
		Board[i][j] = step;
		if (step == N*M)
		{
			for (int k = 0; k < 8; k++) 
			{
				int i1 = i+direction[k][0];
				int j1 = j+direction[k][1];
				if (isValidMoveEnd(i1,j1) )return true;
			}
			return false;
		}

		for (int k = 0; k < 8; k++) 
		{
			int i1 = i+direction[k][0];
			int j1 = j+direction[k][1];
			int newDegree = degree(i1,j1);

			if (isValidMove(i1,j1) && newDegree < degree )
			{ 
				degree = newDegree;
				if (solveClosed(step+1,i1, j1))
				{
					i = i1;
					j = j1;
					return true;
				}
				else 	
				{
					Board[i1][j1] = 0;
				}
			}
		}
		return false;
	}
	static boolean solveClosedFixed(int step, int i, int j)
	{
		recurCallsCF++;
		int degree = 8;
		//int stepReal = step;

		int iCurr = i;
		int jCurr = j;
		CurrStep = step;
		Board[i][j] = step;
		if (CurrStep == (N*M)-1)
		{
			for (int k = 0; k < 8; k++) 
			{
				int i1 = i+direction[k][0];
				int j1 = j+direction[k][1];

				if (isValidMoveEnd(i1,j1) )
					return true;
			}
			return false;
		}

		for (int k = 0; k < 8; k++) 
		{
			int i1 = i+direction[k][0];
			int j1 = j+direction[k][1];
			int newDegree = degree(i1,j1);

			if (isValidMove(i1,j1) && newDegree < degree )
			{ 
				i = i1;
				j = j1;
				if(CurrStep == 1)
				{
					iPrev = i;
					jPrev = j;
				}
				if(CurrStep == 2)
				{
					Board[jPrev][iPrev] = 25;
				}
				degree = newDegree;
				if (solveClosedFixed(step+1,i1, j1)) return true;
				else Board[i1][j1] = 0;
			}
		}
		return false;
	}

	static void printBoard(int[][] solution) 
	{
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; j++) System.out.print("------");
			System.out.println("-");
			for (int j = 0; j < M; ++j) 
				System.out.format("| %3d ", solution[i][j]);
			System.out.println("|");
		}
		for (int j = 0; j < M; j++) System.out.print("------");
		System.out.println("-");
	}

	/*
	 * read in the dimensions of Knight's tour board and try to find one.  
	 */
	public static void main (String [ ] args)
	{
		read = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("Please enter the number of rows : ");
			N = Integer.parseInt(read.readLine());

			System.out.print("Please enter the number of columns : ");
			M = Integer.parseInt(read.readLine());
		} catch(Exception ex){
			System.err.println( "Error: " + ex );
			ex.printStackTrace();
		}
		if (N>M) 
		{ int i = N; N = M;M = i; }

		// create Board and set each entry to 0
		Board = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) 
				Board[i][j] = 0;

		if (solve(1, 0, 0))
		{
			System.out.println("\nRecursive Backtracking");
			printBoard(Board);
		}
		else System.out.println("No tour was found.");

		System.out.println("Number of recursive calls = " + recurCalls);
		//reset board for fixed approach
		Board = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) 
				Board[i][j] = 0;


		if (solveWarnsdorff(1, 0, 0))
		{
			System.out.println("\nWarnsdorff's Algorithm with Recursive Backtracking");
			printBoard(Board);
		}
		else System.out.println("No tour was found.");

		System.out.println("Number of recursive calls = " + recurCallsH);
		//reset board for Closed approach
		Board = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) 
				Board[i][j] = 0;

		randNum = new Random();
		int random = randNum.nextInt(8);
		int Start = random;
		iStart = 0;
		jStart = 0;
		boolean closedPath = solveClosed(1,iStart,jStart);
		if(!closedPath)
		{
			for (int i = 0; i <N  ; i++)
			{
				for (int j = 0; j < M ; j++)
				{
					//printBoard(Board);
					//Reset Board
					//sysout
					iStart = i;
					jStart = j;	
					for (int k = 0;k < N; k++)
					{
						for (int l = 0; l < M; l++) 
						{
							Board[k][l] = 0;
						}
					}
					
					Board[i][j] = CurrStep;
					
					closedPath = solveClosed(CurrStep,iStart,jStart);
				}
			}
		}
		if (closedPath)
		{
			System.out.println("\nClosed Path");
			printBoard(Board);
		}
		else System.out.println("No tour was found.");

		System.out.println("Number of recursive calls = " + recurCallsC);
		//Closed Fixed Path
		Board = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) 
				Board[i][j] = 0;

		iStart = 0;
		jStart = 0;
		randNum = new Random();
		
		/*boolean closedPathFixed = solveClosedFixed(1,iStart,jStart);
		if(!closedPathFixed)
		{
			for (int i = 0; i <N && closedPathFixed!=true ; i++)
			{
				//if(closedPath == true) break;
				for (int j = 0; j < M && closedPathFixed!=true ; j++)
				{
					//Reset Board
					//printBoard(Board);
					for (int k = 0;k < N; k++){
						for (int l = 0; l < M; l++) {
							Board[k][l] = 0;
						}
					}
					iStart = i;
					jStart = j;
					//if(closedPath == true)break;	
					
					closedPathFixed = solveClosedFixed(1,iStart,jStart);
				}
			}
		}
		if (closedPathFixed)
		{
			System.out.println("\nClosed Fixed Path");
			printBoard(Board);
		}
		else System.out.println("No tour was found.");

		System.out.println("Number of recursive calls = " + recurCallsCF);

*/
	} 

}