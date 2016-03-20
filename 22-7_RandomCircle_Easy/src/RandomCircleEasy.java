import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
//JFrame part for random circle
//by Nick Kozak 
/**
 * @author Nick Kozak
 * The class to add the textArea and Circle to the GUI
 *
 */
@SuppressWarnings("serial")
public  class RandomCircleEasy extends JFrame{
	/**
	 * instance variable for the textArea
	 */
	private JTextArea textArea;
	/**
	 * No Argument Constructor for the GUI part of the program
	 */
	public RandomCircleEasy()
	{
		super("Random Circle Easy");//Title of the window
		Circle circle= new Circle();//Creates a new  Circle Method which calls the code in Circle.java
		textArea =new JTextArea(5,30);//creates text area
		textArea.setEditable(false);//can't edit text area
		textArea.setText(circle.circleText());//adds the text from RandomCircleEasy() to textArea
		add(circle);//Adds circle drawing to container
		add(textArea,BorderLayout.SOUTH);//adds text area to container and positions at bottom of the window
		setVisible(true);//makes the gui visible
	}
}