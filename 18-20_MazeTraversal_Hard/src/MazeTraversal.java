import java.util.ArrayList;
/**
 * This class contains 6 public methods
 * @author Nick Kozak
 *
 */
public class MazeTraversal 
{
	/**
	 * Instance variable of type int for the Original X Starting Point for Maze
	 */
	private static final int X_Origin = 2;
	/**
	 * Instance variable of type int for the Original Y Starting Point for Maze
	 */
	private static final int Y_Origin = 0;
	/**
	 * Instance variable of type int for the number of Moves Performed to traverse maze
	 */
	private static int move =0;
	/**
	 * Instance variable of type char [][] for the maze array
	 */
	private static char maze[][]=  {{'#','#','#','#','#','#','#','#','#','#','#','#'},
			{'#','.','.','.','#','.','.','.','.','.','.','#'},
			{'.','.','#','.','#','.', '#', '#','#', '#', '.', '#'},
			{'#','#','#','.','#','.','.', '.', '.', '#', '.', '#'},
			{'#','.','.','.','.','#','#','#','.','#','.','.'},
			{'#','#','#','#','.','#','.','#', '.', '#', '.','#'},
			{'#','.','.','#','.','#' ,'.' ,'#' ,'.' ,'#' ,'.' ,'#'},
			{'#','#','.','#','.','#' ,'.' ,'#' ,'.' ,'#' ,'.' ,'#'},
			{'#','.','.','.','.','.' ,'.' ,'.' ,'.' ,'#' ,'.' ,'#'},
			{'#','#','#','#','#','#' ,'.' ,'#' ,'#' ,'#' ,'.' ,'#'},
			{'#','.','.','.','.','.' ,'.' ,'#' ,'.' ,'.' ,'.' ,'#'},
			{'#','#','#','#','#','#','#','#','#','#','#','#'}};
	/**
	 * Instance variable of type ArrayLst for the maze answers
	 */
	private ArrayList<String> answer;//array list for the moves in the maze
	/**
	 * Void method to initialize the answer array and start the maze traversal
	 */
	public void mazeTraversal()
	{
		answer = new ArrayList<String>();//intializes the maze answer array
		traverseMaze(maze,X_Origin,Y_Origin);//traverses the maze from the start point
	
	}
	/**
	 * Method for traversing the maze
	 * @param maze
	 * Passes in the 2d maze array
	 * @param x
	 * Passes in the x location of the maze
	 * @param y
	 * Passes in the y location of the maze
	 * @return
	 * Returns if the maze has been successfully exited
	 */
	public boolean traverseMaze(char maze[][],int x, int y)
	{
		maze[x][y] = 'x';//Marker for the current spot in the maze
		move++; //adds onto the moves made
		printMaze(); //prints the maze
		if( x==X_Origin && y==Y_Origin && move>1)//checks to see if x has returned to the starting position
		{
			System.out.println("Returned to starting location");
			return false;
		}
		else if(isTraverseOver(x,y) == true && move>1)//checks to see if the maze has been fully traversed
		{
			System.out.println("Maze Exited");
			return true;
		}
		else
		{
			//Traverses the maze and tries to move into different directions
			for(int i = 0; i < 4; i++)
			{
				switch(i)
				{
				case 0:
					//down case
					if(isValidMove(x+1,y))//checks if the down move is valid
					{
						if(traverseMaze(maze,x+1,y))//tries to move down
						{
							answer.add("Down");//adds Down to the answer array
							return true;
						}
					}
					break;
				case 1:
					//right case
					if(isValidMove(x,y+1))//checks if the right move is valid
					{
						if(traverseMaze(maze,x,y+1))//tries to move right
						{
							answer.add("Right");//adds right to the answer array
							return true;
						}
					}
					break;
				case 2:
					//up case
					if(isValidMove(x-1,y))//checks if the up move is valid
					{
						if(traverseMaze(maze,x-1,y))//tries to move up
						{
							answer.add("Up");//adds up to the answer array
							return true;
						}
					}
					break;
				case 3:
					//left case
					if(isValidMove(x,y-1))//checks if the left move is valid
					{
						if(traverseMaze(maze,x,y-1))//tries to move left
						{
							answer.add("Left"); //adds left to the answer array
							return true;
						}
					}
					break;
				}
			}
			maze[x][y] ='0';//marks the last moved spot to '0' (used or invalid path moves) if the space has a '0', it will be written over since it isn't an efficient path
			return false;
		}
	}
	/**
	 * Checks to see if the move going to be attempted is Valid
	 * @param row
	 * Passes in the row number of the maze array
	 * @param column
	 * Passes in the column number of the maze array
	 * @return bool
	 * Returns true or false if the move is valid or not
	 */
	public boolean isValidMove(int row, int column)
	{
		boolean bool = false;
		if(row >= 0 && row <= 11
				&& column >= 0 && column <= 11
				&& maze[row][column] =='.'&& maze[row][column]!='#'
				)//checks to see if the move is valid
		{
			bool = true;
		}
		return bool;
	}
	/**
	 * Checks to see if the maze traversal is done
	 * @param row
	 * Passes in the row number of the maze array
	 * @param column
	 * Passes in the column number of the maze array
	 * @return bool 
	 * Returns true or false if the traverse is over or not
	 */
	public boolean isTraverseOver(int row, int column)
	{
		boolean bool = false;
		if((row == 0 || row ==11 || column==0 || column ==11))//checks to see if the maze has been traversed
		{
			bool = true;
		}
		return bool;
	}
	/**
	 * Void method to print the Maze array
	 */
	public void printMaze()
	{
		//prints the maze
		for (int row = 0; row< maze.length;row++)
		{
			for (int column = 0; column < maze.length; column++)
			{
				if (maze[row][column] =='0')
					System.out.print(" .");//writes over the bad moves with periods to look like the original maze array
				else
					System.out.print(" " + maze[row][column]);//prints a space in between indices of the maze array
			}
			System.out.println();
		}
		System.out.println();
	}
	/**
	 * Void method to print the best solution for the maze traversal
	 */
	public void printMazeSolution()
	{
		System.out.println("Maze Solution:\n");
		int moveNumber=1;
		//prints the best soultion to traversing the maze
		for(int i = answer.size(); i > 0 ;i--)//decrements because the array list adds onto itself, so the first instead element is last when the maze is over
		{
			System.out.printf("%s. "+answer.get(i-1)+"\n",moveNumber);
			moveNumber++;
		}
	}
}
