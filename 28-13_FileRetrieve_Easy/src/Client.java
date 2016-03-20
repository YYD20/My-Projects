import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
/**
 * Main driver class for Client that contains a one argument constructor, one public method, and 5 private methods
 * @author Nick Kozak
 *
 */
public class Client extends JFrame
{
	/**
	 * Instance variable of type Socket for the client
	 */
	private Socket client;
	/**
	 * Instance variable of type JTextArea for displaying messages
	 */
	private JTextArea displayArea; 
	/**
	 * Instance variable of type String for host server for this application
	 */
	private String fileServer;
	/**
	 * Instance variable of type ObjectInputStream for the the input stream
	 */
	private ObjectInputStream input;
	/**
	 * Instance variable of type ObjectOutputStream for the the output stream
	 */
	private ObjectOutputStream output;
	/**
	 * Instance variable of type JPanel to hold components 
	 */
	private JPanel panel;
	/**
	 * Instance variable of type JLabel to prompt user  
	 */
	private JLabel label;
	/**
	 * Instance variable of type String for the message from server
	 */
	private String message = ""; 
	/**
	 * Instance variable of type JTextField for the enter field where the user types the name of the file
	 */
	private JTextField enterField;
	/**
	 * Instance variable of type String for the file name
	 */
	private String fileName;
	/**
	 * Instance variable of type JScrollPane to allow scrolling if the file is long enough
	 */
	private JScrollPane scroller;
	/**
	 * This method will automatically be called when ClientTest is run
	 * @param host
	 * IP Address of the file server
	 */
	public Client(String host)
	{
		super("Client");//Labels Client Window

		fileServer = host;//assigns the address of the host
		panel = new JPanel(); // create panel  
		label = new JLabel ( " Enter the file name to retrieve: "); 
		panel.setLayout ( new GridLayout (1, 2, 0, 0));      
		panel.add( label ); // add label to panel      
		enterField = new JTextField(); // create text field  
		enterField.addActionListener(
				new ActionListener()//Anonymous inner class for event handling
				{
					public void actionPerformed(ActionEvent event)     
					{     
						try{
							//
							fileName  = event.getActionCommand(); 
							//System.out.printf("%s \n",fileName);
							output.writeObject( fileName );
							// put file name in stream           
							output.flush(); // send to server  
						}
						catch (IOException ioException) 
						{
							ioException.printStackTrace();
						}
					} 
				}
				);
		panel.add( enterField ); // add text area to panel
		displayArea = new JTextArea();//initializes a JTextArea
		scroller = new JScrollPane( displayArea ); // add scrolling      
		setLayout( new BorderLayout() ); // set layout of JFrame      
		add( panel, BorderLayout.NORTH); // add panel  to north      
		add( scroller, BorderLayout.CENTER); // add scrolling text area to center  
		setSize(450, 300); // set window size
		setVisible(true); // show window
	}
	/**
	 * Void method to run the Client
	 * connect to server and process messages from server
	 */
	public void runClient() 
	{

		try // connect to server, get streams, process connection
		{
			connectToServer(); // create a Socket to make connection
			getStreams(); // get the input and output streams
			processConnection(); // process connection
		} 
		catch (EOFException eofException) 
		{
			displayMessage("\nClient terminated connection");
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
	 * Connect to server
	 * @throws IOException
	 * 
	 */
	private void connectToServer() throws IOException
	{      
		displayMessage("Attempting connection\n");

		// create Socket to make connection to server
		client = new Socket(InetAddress.getByName(fileServer), 25669);

		// display connection information
		displayMessage("Connected to: " + 
				client.getInetAddress().getHostName());
	}
	/**
	 * Get streams to send and receive data
	 * @throws IOException
	 * 
	 */
	private void getStreams() throws IOException
	{
		// set up output stream for objects 
		output = new ObjectOutputStream(client.getOutputStream()); // output stream to server     
		output.flush(); // flush output buffer to send header information
		// set up input stream for objects
		input = new ObjectInputStream(client.getInputStream());
		//displayMessage(input+"");
		displayMessage("\nGot I/O streams\n");
	}
	/**
	 * Processes the Connection
	 * @throws IOException
	 */
	private void processConnection() throws IOException
	{
		do // process messages sent from server
	      { 
	         try // read message and display it
	         {
	            message = ( String ) input.readObject(); // read new message
	            displayArea.setText( "\n" + message ); // display message
	            if (message.equals( "The file is:"))            
				{               
					while ( input.readObject()!=null ) // read new line                
					{   
						message = (String)input.readObject(); // read response from server                   
						displayArea.append("\n"+message); // add line to text area                
					} // end while           
				} // end if            
				enterField.setEditable( true ); // enable editing of enterfield 
	         } // end try
	         catch ( ClassNotFoundException classNotFoundException ) 
	         {
	            displayMessage( "\nUnknown object type received" );
	         } // end catch

	      } while ( message!=null );
	}
	/**
	 *  Close streams and socket
	 */
	private void closeConnection() 
	{
		displayMessage("\nClosing connection");
		try 
		{
			output.close(); // close output stream
			input.close(); // close input stream
			client.close(); // close socket
		} 
		catch (IOException ioException) 
		{
			ioException.printStackTrace();
		} 
	}
	/**
	 * Manipulates displayArea in the event-dispatch thread
	 * @param messageToDisplay
	 * The message  that will be displayed
	 */
	private void displayMessage(final String messageToDisplay)
	{
		SwingUtilities.invokeLater(
				new Runnable()//Anonymous inner class
				{
					public void run() // updates displayArea
					{
						displayArea.append(messageToDisplay);
					}
				}  
				); 
	}   
}
