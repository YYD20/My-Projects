//22-7_RandomCircle_Easy

/**
 * @author Nick Kozak
 *The class that creates a windows for the circle and text to appear on
 */

public class RandomCircle_Easy_Test{
	/**
	 * The width of the gui window
	 */
	private static int width=400;
	/**
	 * The height of the gui window
	 */
	private static int height=400;
	/**
	 * This method will automatically be called when RandomCircel_Easy_Test is run
	 * 
	 * @param args
	 *            Command line arguments.
	 */
public static void main(String[] args) 
	{
		/**
		 * Creates an object that calls the the GUI in the RandomCircleEasy 
		 * method in RandomCircleEasy.java
		 */
		RandomCircleEasy application= new RandomCircleEasy();		
		application.setResizable(false);//Makes the window non-resizable
		application.setSize(height,width);//Sets size of the window
		application.setDefaultCloseOperation(RandomCircleEasy.EXIT_ON_CLOSE);//Closes the frame  on exit
		application.setVisible(true);//Shows the window
	}
}//end of Random Circle_Easy_Test class
