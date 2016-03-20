import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *  Main driver class for Server that contains a no argument constructor, one public method, and 3 private methods
 * @author Nick Kozak
 *
 */
public class Server extends JFrame
{
	/**
	 * Instance variable of type ServerSocket for the server
	 */
	private ServerSocket server;
	/**
	 * Instance variable of type Socket for the server
	 */
	private Socket connection;
	/**
	 * Instance variable of type ObjectOutputStream for the the output stream
	 */
	private ObjectInputStream input;
	/**
	 * Instance variable of type JPanel to hold components 
	 */
	private ObjectOutputStream output;
	/**
	 * This method will automatically be called when ServerTest is run
	 */
	public Server()
	{
		//Set up Server
		try 
		{
			server = new ServerSocket(25669,10);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(0);//Exits the program
		}
	}
	/**
	 * Void method to run the Client
	 * accept client connection and process messages from client
	 */
	public void runServer()
	{
		try // get streams, process connection
		{
			connection = server.accept();
			getStreams(); // get the input and output streams
			processConnection(); // process connection
		} 
		catch (IOException ioException) 
		{
			ioException.printStackTrace();
		} 
		finally 
		{
			closeConnection(); // close connection
		}
	}
	/**
	 * Get streams to send and receive data
	 * @throws IOException
	 */
	private void getStreams() throws IOException
	{
		// set up output stream for objects 
		output = new ObjectOutputStream(connection.getOutputStream()); // output stream to server    
		output.flush(); // flush output buffer to send header information
		// set up input stream for objects
		input = new ObjectInputStream(connection.getInputStream());
	}
	/**
	 * Processes the Connection
	 */
	private void processConnection() 
	{

		try{
			String message = "Connection successful\n";
			output.writeObject(message);
			output.flush();
			String fileName = (String)input.readObject();
			//System.out.printf("%s \n",fileName);
			//String current = new java.io.File( "." ).getCanonicalPath();
			//System.out.printf("CurrentFolder Path:\n%s\n",current);
			//System.out.printf("CurrentFolder Path+file:\n%s/%s\n",current, fileName);
			File file = new File(fileName);	
			String result = "";
			// send file to client
			if ( file.exists() ) 
			{
				result+="The file contains:\n";
				Scanner fileInput = new Scanner( file );
				// read first line of file
				while (fileInput.hasNextLine()) 
				{
					result += fileInput.nextLine()+"\n";
					
				}//end while loop
				output.writeObject(result);
				output.flush();
				fileInput.close();
			}
			// file does not exist
			else 
			{
				result = file.getName() + " does not exist\n";
				output.writeObject(result);
				output.flush();
			}
		}
		catch (IOException | ClassNotFoundException ioException) 
		{
			ioException.printStackTrace();
		}
	}
	/**
	 * 
	 */
	private void closeConnection() 
	{
		try 
		{

			output.close(); // close output stream
			input.close(); // close input stream
			connection.close(); // close socket
		} 
		catch (IOException ioException) 
		{
			ioException.printStackTrace();
		}
	}

} // end class Server


