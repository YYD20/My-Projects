//Calculator Hard Test
/**
 * Main driver class that tests Calculator_Hard.java
 * 
 */
public class Calculator_HardTest 
{
	/**
	 * This method will automatically be called when Calculator_HardTest is run
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(String[] args) 
	{
		Calculator_Hard calculator = new Calculator_Hard();
		/**
		*Creates a new Calculator object that calls the GUI in the Calculator_Hard method
		*/
		calculator.setDefaultCloseOperation(Calculator_Hard.EXIT_ON_CLOSE);//Closes the frame  on exit
		calculator.setSize(250,250);//Sets size of the window
		calculator.setResizable(false);//Sets the window to not be re-sizable
		calculator.setVisible(true);//Shows the window
	}
}