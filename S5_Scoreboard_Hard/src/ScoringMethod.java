/**
 * The ScoringMethod class contains a two argument constructor and 2 public methods
 * @author Nick Kozak
 *
 */
public class ScoringMethod {
	/**
	 * This method will automatically be called when ScoreboardTest is run
	 * This stores the the scoring method name, and points for the scoring method 
	 */
	/**
	 * Instance variable of type String for the scoring method name
	 */
	private String name;
	/**
	 * Instance variable of type int for the scoring method points
	 */
	private int points;
	/**
	 * Two arugment constructor 
	 * @param methodName
	 * Passes in a string for the scoring method name
	 * @param score
	 * Passes in an in for the scoring method points
	 */
	public ScoringMethod (String methodName, int score)
	{
		name = methodName;
		points = score;
	}
	/**
	 * Gets the name of a Scoring method
	 * @return name
	 * Returns the name of the scoring method
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Gets the points of a Scoring method
	 * @return points
	 * Returns the points in a scoring method
	 */
	public int getPoints()
	{
		return points;
	}
} 