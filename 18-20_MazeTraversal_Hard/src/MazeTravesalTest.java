/**
 * Main driver class that tests MazeTraversal
 * @author Nick Kozak
 */
public class MazeTravesalTest 
{
	/**
	 * This method will automatically be called when MazeTraversalTest is run
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(String[] args)
	{
		MazeTraversal maze = new MazeTraversal();//creates a maze traversal object
		maze.mazeTraversal();//Starts the maze traversal
		maze.printMazeSolution();//prints the solution steps for traversing the maze
	}
}
//