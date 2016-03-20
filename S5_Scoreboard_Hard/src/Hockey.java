/**
 * The Hockey class contains a two argument constructor and extends the Game class
 * @author Nick Kozak
 *
 */
public class Hockey extends Game {
	/**
	 * This method will automatically be called when ScoreboardTest is run
	 * @param home
	 * Passes in the home team object
	 * @param away
	 * Passes in the away team object
	 */
	public Hockey(Team home, Team  away) 
	{
		super(home, away);//
		ScoringMethod Goal =  new ScoringMethod("Goal",1);//Creates a new scoring method for a goal with the name of the scoring method and the amount of points associated 
		setPeriodName("Period");//Assigns the Period Name for this game type
		addScoringMethod(Goal);//Adds the scoring method to the game class
	}
}