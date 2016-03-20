/**
 * The Team class contains a one argument constructor and 5 public methods
 * @author Nick Kozak
 *
 */
public class Team {
	/**
	 * This method will automatically be called when ScoreboardTest is run
	 * This stores the the team name, and score for the score board
	 */
	/**
	 * Instance variable of type String for the team name
	 */
	private String tempTeamName;
	/**
	 * Instance variable of type int for the team points
	 */
	private int points;
	/**
	 *One argument constructor that passes in a string for the team name
	 */
	public Team(String team)
	{
		this.tempTeamName= team;
	}
	/**
	 * 
	 * @return points
	 * Returns the score for a team 
	 */
	public int getTeamScore()
	{
		return points;
	}
	/**
	 * 
	 * @return tempTeamName
	 * Returns a string for the team name 
	 */
	public String getTeamName()
	{
		return tempTeamName;
	}
	/**
	 * Takes in the points of a scoring method
	 * @param score
	 * Adds points to the score of the team
	 */
	public void addScore(int score) 
	{
		points+=score;
	}
	/**
	 * ets the amount of points a team has (total score)
	 * @return points
	 * Returns the amount of points a team has
	 */
	public int getPoints()
	{
		return points;
	}

}