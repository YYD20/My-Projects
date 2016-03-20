import java.util.ArrayList;
/**
 * The Game abstract class is the main driver of logic in the Scoreboard program
 * @author Nick Kozak
 *
 */
public abstract class Game
{
	/**
	 * This method will automatically be called when ScoreboardTest is run
	 */
	/**
	 * Instance variable of type ArrayLst for the scoring methods
	 */
	private ArrayList<ScoringMethod> methods;
	/**
	 * Instance variable of type String for the game leader (Who is winning)
	 */
	private String leader;
	/**
	 * Instance variable of type String for the scoring method name
	 */
	protected String methodName;
	/**
	 * Instance variable of type Team for the 1st team
	 */
	protected Team team1;
	/**
	 * Instance variable of type Team for the 2nd team
	 */
	protected Team team2;
	/**
	 * Instance variable of type String  for the game name
	 */
	private String gameName;
	/**
	 * Instance variable of type String  for the period name
	 */
	private String periodName;
	/**
	 * Instance variable of type String  for the period
	 */
	private String period;
	/**
	 * Instance variable of type int for the period number
	 */
	private int periodNumber;
	/**
	 * Instance variable of type int for the overtime period number
	 */
	private int overTimePeriod;
	/**
	 * Main Constructor for the Game Class. Passes in the to team objects
	 * @param home
	 * @param away
	 */
	public Game(Team home, Team away) 
	{
		methods = new ArrayList<ScoringMethod>();//initializes the scoring methods arrayList
		this.team1 = home;//assigns the home team to the first team
		this.team2 = away;//assigns the away team to the second team
	}
	/**
	 * Assigns the name of the game to an instance variable (needed to determine overtime scoring)
	 * @param gameName
	 * Passes in the name of the Game being played
	 */
	public void sportName(String gameName)
	{	
		this.gameName= gameName;
	}
	/**
	 * Adds the score to a team 
	 * @param methodName
	 * passes in the scoring method name needed for getting the correct points
	 * @param team
	 * passes in the team  needed for assigning the correct points
	 */
	public void addScore(ScoringMethod methodName, Team team)
	{
		team.addScore(methodName.getPoints());
	}
	/**
	 * Adds the scoring method into the scoring methods array list
	 * @param methodName
	 * scoring method to be added to the array list
	 */
	public void addScoringMethod(ScoringMethod methodName)
	{
		methods.add(methodName);
	}
	/**
	 * 
	 * @return methods
	 * Returns the array list of scoring methods
	 */
	public ArrayList<ScoringMethod> getScoringMethods()
	{	
		return methods;	
	}
	/**
	 * 
	 * @return gameName
	 * Returns the Game Name (Ie football, soccer ..etc.)
	 */
	public String getSportName()
	{	
		return gameName;
	}
	/**
	 * 
	 * @return Score
	 * Returns a formatted string of the score of the game with the team names
	 */
	public String getScore()
	{
		return String.format("\n%s-%s, %s-%s ",team2.getTeamName(),team2.getTeamScore(),team1.getTeamName(),team1.getTeamScore());	
	}
	/**
	 * 
	 * @return leader
	 * Returns who is winning the game
	 */
	public String getLeader()
	{
		if(team1.getTeamScore() > team2.getTeamScore())
			leader = team1.getTeamName();
		else if (team1.getTeamScore() < team2.getTeamScore())
			leader = team2.getTeamName();
		else
		{
			leader =null;
		}
		return leader;
	}
	/**
	 * Passes in the name of the period for a game type
	 * @param name
	 * Sets the period name to the name that is passed in
	 */
	public void setPeriodName(String name)
	{
		this.periodName = name;
	}
	/**
	 * Gets the period name
	 * @return periodName
	 * Returns the period name
	 */
	public String getPeriodName()
	{
		return periodName;
	}
	/**
	 * void method that sets the period of the game.
	 */
	public void setPeriod()
	{
		if(isGameOver()==false)
		{
			if (getSportName().equals("Football")||getSportName().equals("Basketball"))
			{
				if(isGameOver()==false&& periodNumber>=4)
				{
					overTimePeriod++;
					period = ("OT "+ overTimePeriod);
				}
				else
				{
					periodNumber++;
					period = Integer.toString(periodNumber);
				}
			}
			if (getSportName().equals("Soccer"))
			{
				if(isGameOver()==false&& periodNumber>=2)
				{
					period = ("Extended Play ");
				}
				else
				{
					periodNumber++;
					period = Integer.toString(periodNumber);
				}
			}
			if (getSportName().equals("Hockey"))
			{
				if(isGameOver()==false&& periodNumber>=3)
				{
					overTimePeriod++;
					period = ("OT "+ overTimePeriod);
				}
				else
				{
					periodNumber++;
					period = Integer.toString(periodNumber);
				}
			}
		}
	}
	/**
	 * 
	 * @return period
	 * Returns the current period of the game
	 */
	public String getPeriod()
	{
		return period;
	}
	/**
	 * Checks to see if the game is tied
	 * @return boolean
	 * Returns true or false depending on if the game is tied
	 */
	public boolean isTied()
	{
		if(team1.getTeamScore() == team2.getTeamScore())
			return true;
		else
			return false;
	}
	/**
	 * Checks to see if the game is over
	 * @return boolean
	 * Returns true or false depending on if the game is over
	 */
	public boolean isGameOver()
	{
		boolean bool = false;
		//Change what you changed in setPeriod
		if(getSportName().equals("Hockey"))
		{
			if(isTied()==false && periodNumber >= 3  )
			{
				bool= true;
			}
			else
			{	
				bool= false;
			}
		}
		if(getSportName().equals("Football")||getSportName().equals("Basketball"))
		{
			if(isTied()==false && periodNumber >= 4  )
			{
				bool = true;
			}
			else
			{	
				bool = false;
			}
		}
		if(getSportName().equals("Soccer"))
		{
			if(isTied()==false && periodNumber >= 2  )
			{
				bool= true;
			}
			else
			{	
				bool= false;
			}
		}
		return bool;
	}
}