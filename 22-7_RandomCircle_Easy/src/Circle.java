
//22-7_RandomCircle_Easy
//By Nick Kozak
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;
/**
 * 
 * This class has a three-argument constructor and six public methods
 * @author Nick Kozak
 *
 */
@SuppressWarnings("serial")
public class Circle extends JPanel {
	/**
	 * instance variable for the x-coordinate in the gui window where the circle is painted
	 */
	private int x = 0;
	/**
	 * instance variable for the y-coordinate in the gui window where the circle is painted
	 */
	private int y = 0;
	/**
	 * instance variable for the circle width
	 */
	private int circleWidth;
	/**
	 * instance variable for the circle height
	 */
	private int circleHeight;
	/**
	 * instance variable for the circle radius
	 */
	private double radius;
	/**
	 * instance variable for the circle area
	 */
	private double area;
	/**
	 * instance variable for the circumference of the circle
	 */
	private double circumference;
	/**
	 * instance variable for the minimum circle radius
	 * size is 10 to make the circle easily visible
	 */
	private static int minimum = 10;
	/**
	 * instance variable for the maximum circle radius
	 * maximum circle size is 290 in the gui window, so this
	 * is set to 145 to account for the doubling of the radius.
	 * maximum circle size is 290
	 */
	private static int maximum = 145;
	/**
	 * static instance variable for creating a random number
	 */
	private static Random rand = new Random();
	
	//No Argument Constructor
	public Circle() {
		this.radius = rand.nextInt(maximum - minimum) + minimum;// Creates random number in between the minimum and maximum
		this.circleWidth=(int) (radius*2);//makes the circle width
		this.circleHeight = circleWidth;//makes the circle height
	}
	/**
	 * Paints the circle 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);// Makes the color black
		g.fillOval(x, y, circleWidth,circleHeight);// Paints black circle

	}
	/**
	 * Returns the radius of the random circle
	 *@return radius value of circle
	 */
	public double circleRadius(){
		return radius;
	}
	/**
	 * Returns the area of the random circle
	 *@return area value of circle
	 */
	public double circleArea(){
		this.area = (double) (radius*radius*Math.PI);//formula for area 
		return area;
	}
	/**
	 * Returns the diameter of the random circle
	 *@return diameter value of circle
	 */
	public double circleDiameter(){
		return radius*2;
	}
	/**
	 * Returns the circumference of the random circle
	 *@return circumference value of circle
	 */
	public double circleCircumferenece(){
		this.circumference=(double)(radius*2*Math.PI);//formula for circumference
		return circumference;
	}
	/**
	 * Returns the area, circumference,diameter, and radius of the random circle in a formatted string
	 *@return string of the circle information
	 */
	public String circleText(){
		//data for the circle
		return String.format("Radius: %.0f\nDiameter: %.0f\nCircumference: %.2f\nArea: %.2f",circleRadius(),circleDiameter(),circleCircumferenece(),circleArea());
	
	}
}

	

