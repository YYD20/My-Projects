//Calculator Hard Class
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
/**
 * This class has a no-argument constructor and three public methods.
 *            
 */
public class Calculator_Hard extends JFrame {
	/**
	 * Final instance variable for the number buttons 
	 */
	private final JButton[] numButtons;
	/**
	 * Final instance variable for the operator buttons 
	 */
	private final JButton[] opButtons;
	/**
	 * Final string array of the numbers for the numButtons 
	 */
	private static final String[] numbers={"7","8","9","4","5","6",
			"1","2","3","0","."};
	/**
	 * Final string array of the operators for the opButtons 
	 */
	private static final String[] operators={"/","*","-","+"};
	/**
	 * Final instance variable of type JButton for the equals button 
	 */
	private final JButton equalButton;
	/**
	 * Final instance variable of type Gridlayout  for the numButtons 
	 */
	private final GridLayout gridLayoutNum;
	/**
	 * Final instance variable of type Gridlayout  for the opButtons 
	 */
	private final GridLayout gridLayoutOp;
	/**
	 * Final instance variable of type GridBaglayout  for the grid of buttons 
	 */
	private final GridBagLayout gridBagLayout;
	/**
	 * Instance variable of type JTextField for the display output of calculator
	 */
	private JTextField textArea;
	/**
	 * Instance variable of type JPanel for the numberButtons of calculator
	 */
	private JPanel numberPanel;
	/**
	 * Instance variable of type JPanel for the opButtons of calculator
	 */
	private JPanel operatorPanel;
	/**
	 * Instance variable of type JPanel for the calculator
	 */
	private JPanel calculatorPanel;
	/**
	 * Instance variable of type String for the numberHandler
	 */
	private String numberPressed;
	/**
	 * Instance variable of type String for the opHandler
	 */
	private String opPressed;
	/**
	 * Instance variable of type String for the previous number
	 */
	private String previousNumber;
	/**
	 * Instance variable of type Double for the total after operations
	 */
	private double total;
	/**
	 * Instance variable of type String for the lastCommand 
	 * Crucial for last step after pressing the equals button as it performs
	 * extra arithmetic  
	 */
	private String lastCommand="";
	/**
	 * Instance variable of type double for the temporary number that is input
	 *  into the text area of the calculator
	 */
	private double tempNumber=0;
	/**
	 * Instance variable of type double for the temporary total of the operations
	 * Needed so calculator performs multiple logic correctly
	 */
	private double tempTotal=0;
	/**
	 * Instance variable of type int for the Command Counter so the first number
	 *  entered is set to the total, then other numbers can build off of it.
	 */
	private int commandCounter=0;
	
	//no argument constructor
	public Calculator_Hard()
	{
		super("Calculator");//Names the window
		/**
		 * Creates a 4 by 3 grid with no gaps
		 */
		gridLayoutNum= new GridLayout(4,3);
		/**
		 * Creates a 4 by 1 grid with no gaps
		 */
		gridLayoutOp=new GridLayout(4,1);
		/**
		 * Creates a new object for the  GridBagLayout
		 */
		gridBagLayout=new GridBagLayout();
		/**
		 * Creates an object c for GridBagLayout Constraints. 
		 * The buttons fill the GUI nicely
		 */
		GridBagConstraints c= new GridBagConstraints();
		//Implements the GridBag constraints on the buttons in the GUI
		if(true)
		{
			c.fill=GridBagConstraints.HORIZONTAL;
			c.fill=GridBagConstraints.VERTICAL;
			c.weightx=GridBagConstraints.HORIZONTAL;
			c.weighty=GridBagConstraints.VERTICAL;
			c.ipadx=15;
			c.ipady=15;
		}
		
		textArea=new JTextField();//creates a new textField object
		textArea.setEditable(false);//can't edit the text area
		numberPanel= new JPanel();//creates a new JPanel object for the number buttons
		operatorPanel= new JPanel();//creates a new JPanel object for the operator buttons
		calculatorPanel=new JPanel();//creates a new JPanel object for the calculator
		numButtons = new JButton[numbers.length];//Creates x buttons where x represents the numbers array length
		opButtons=new JButton[operators.length];//Creates x buttons where x represents the operators array length
		equalButton=new JButton("=");//Creates an equals button 
		numberPanel.setLayout(gridLayoutNum);//sets the numberButton Panel Layout
		numberHandler numHandler = new numberHandler();//creates numHandler object which calls the private class numberHandler
		operationHandler opHandler = new operationHandler();//creates opHandler object which calls the private class operationHandler
		equalHandler eqHandler = new equalHandler();//creates eqHandler object which calls the private class equalHandler
		for(int ctr=0;ctr<numbers.length;ctr++)
		{
			numButtons[ctr]=new JButton(numbers[ctr]);
			numButtons[ctr].addActionListener(numHandler);//register number listener
			numberPanel.add(numButtons[ctr],BorderLayout.WEST);//add the number buttons to the numberPanel
		}
		equalButton.addActionListener(eqHandler);//register equals listener
		numberPanel.add(equalButton);//Adds the equals button to the number panel
		operatorPanel.setLayout(gridLayoutOp);//sets the opButton Panel Layout
		for(int ctr=0;ctr<operators.length;ctr++)
		{
			opButtons[ctr]=new JButton(operators[ctr]);
			opButtons[ctr].addActionListener(opHandler);//register operation listener
			operatorPanel.add(opButtons[ctr],BorderLayout.EAST);//add the operator buttons to the numberPanel
		}
		calculatorPanel.setLayout(gridBagLayout);//sets the calculator panel layout
		calculatorPanel.add(numberPanel,c);//adds the number Buttons panel to the calculator panel
		calculatorPanel.add(operatorPanel,c);//adds the operator Buttons panel to the calculator panel
		add(textArea,BorderLayout.NORTH);//adds the text area to the top of GUI
		add(calculatorPanel,BorderLayout.CENTER);//adds the calculator Panel to the center of GUI
	}
	/**
	 * This class has a one-argument constructor and one public method.
	 * It also implements ActionListener to handle button presses           
	 */
	private class numberHandler implements ActionListener 
	{
		// process number button events
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			/*
			 * assigns the string numberPressed to the event that occurred 
			 * i.e numberPressed=2 is the "2" button was pressed
			 */
			numberPressed = e.getActionCommand();
			/*
			 * checks for the divide by 0 and reset the text Area is a divide by 0 happened
			 */
			if(textArea.getText().equals("NAN"))
        	{
				textArea.setText("");
				commandCounter=0;
        	}
			textArea.setText(textArea.getText() + numberPressed);//sets the textField to the numbers being pressed
			previousNumber = textArea.getText();//sets the previous number to the text that was entered in the textField
			tempNumber=Double.parseDouble(previousNumber);//Parses the previous number for the numeric value
			if(commandCounter==0)//Assigns the first number that is input to be equal to the total
			{
				total=tempNumber;
				tempTotal=total;
				commandCounter++;
			}	
		}
	} // end private inner class numberHandler
	
	/**
	 * This class has a one-argument constructor and one public method.
	 * It also implements ActionListener to handle button presses          
	 */
	private class operationHandler implements ActionListener 
	{
		// process operation button events
		@Override
		public void actionPerformed(ActionEvent e)
		{
			opPressed=e.getActionCommand();
			if(opPressed==e.getActionCommand())
			{
				textArea.setText("");//sets the textField to blank
				commandCounter++;
				/**
				 * addition rules if the "+" is pushed
				 */
				if (opPressed.equals("+")&&commandCounter<0) 
				{
					tempTotal+=tempNumber;
					total+=tempTotal;
					commandCounter++;
					textArea.setText("");
				}
				/**
				 * subtraction rules if the "-" is pushed
				 */
				else if (opPressed.equals("-")&&commandCounter<0)
				{
					tempTotal+=-tempNumber;
					total+=tempTotal;
					commandCounter++;
					textArea.setText("");
				}
				/**
				 * multiplication rules if the "*" is pushed
				 */
				else if (opPressed.equals("*")&&commandCounter<0)
				{
					tempTotal+=tempNumber;
					total*=tempTotal;
					commandCounter++;
					textArea.setText("");
				}
				/**
				 * division rules if the "/" is pushed
				 * also checks to see if the user tried to divide by 0
				 * if they did, it will set the textField to NAN, not a number, 
				 * instead of the default infinity
				 */
				else if (opPressed.equals("/")&&commandCounter<0)
				{
					if(tempNumber==0)
       			 	{
       				 	textArea.setText("NAN");
       				 	total=0;
       			 	}
					else
					{
						tempTotal+=tempNumber;
						total/=tempTotal;
						commandCounter++;
						textArea.setText("");
					}
				}
				/*
				 * assigns the string lastCommand to the operation that occurred last 
				 * i.e lastCommand= "+" is the "+" button was pressed
				 */
				lastCommand=e.getActionCommand();
			}	
		}
	}
	/**
	 * This class has a one-argument constructor and one public method.
	 * It also implements ActionListener to handle button presses            
	 */
	private class equalHandler implements ActionListener 
	{
		// process equals button events
		@Override
		public void actionPerformed(ActionEvent e)
		{	
			/**
			 * addition rules for after the equals button is pushed and lastCommand is  "+" 
			 */
			if(lastCommand.equals("+")&&e.getActionCommand().equals("="))
				{
					total+=tempNumber;
					textArea.setText(""+total);
				}
			/**
			 * subtraction rules for after the equals button is pushed and lastCommand is  "-" 
			 */
			else if(lastCommand.equals("-")&&e.getActionCommand().equals("="))
				{
					total+=-tempNumber;
					textArea.setText(""+total);
				}
			/**
			 * multiplication rules for after the equals button is pushed and lastCommand is  "*" 
			 */
			else if(lastCommand.equals("*")&&e.getActionCommand().equals("="))
				{
					total*=tempNumber;
					commandCounter++;
					textArea.setText(""+total);
				}
			/**
			 * division rules for after the equals button is pushed and lastCommand is  "/"
			 * also checks to see if the user tried to divide by 0
			 * if they did, it will set the textField to NAN, not a number, 
			 * instead of the default infinity
			 */
			else if(lastCommand.equals("/")&&e.getActionCommand().equals("="))
			{
				if(tempNumber==0)
   			 	{
   				 	textArea.setText("NAN");
   				 	total=0;
   			 	}
				else
				{
					total/=tempNumber;
					commandCounter++;
					textArea.setText(""+total);
				}
			}
		}
	}
}