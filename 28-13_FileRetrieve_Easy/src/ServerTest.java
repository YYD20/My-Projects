import javax.swing.JFrame;
/**
 * Main driver class that tests Server
 * @author Nick Kozak
 */
public class ServerTest 
{
	/**
	 * This method will automatically be called when ScoreboardTest is run
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(String[] args){
		{
			Server application = new Server();//declare Server application
			application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			application.runServer();//Calls the run server method
		}
	}
}
