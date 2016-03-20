import javax.swing.JFrame;
/**
 * Main driver class that tests Client
 * @author Nick Kozak
 */
public class ClientTest 
{
	/**
	 * This method will automatically be called when ScoreboardTest is run
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	 public static void main(String[] args)
	   {
	      Client application; // declare client application
	      // if no command line args
	      if (args.length == 0)
	         application = new Client("127.0.0.1"); // connect to localhost
	      else
	         application = new Client(args[0]); // use args to connect

	      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      application.runClient(); // run client application
	   } 
	
}
