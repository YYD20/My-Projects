/**
 * The Basketball class contains a two argument constructor and extends the Game class
 * @author Nick Kozak
 *
 */
public class Basketball extends Game {
	/**
	 * This method will automatically be called when ScoreboardTest is run
	 * @param home
	 * Passes in the home team object
	 * @param away
	 * Passes in the away team object
	 */
	public Basketball(Team home, Team  away) 
	{
		super(home, away);//
		ScoringMethod TwoPointShot =  new ScoringMethod("Two-Point shot",2);//Creates a new scoring method for a two-point shot with the name of the scoring method and the amount of points associated 
		ScoringMethod ThreePointShot =  new ScoringMethod("Three-Point shot",3);//Creates a new scoring method for a three-point shot with the name of the scoring method and the amount of points associated 
		ScoringMethod FreeThrow =  new ScoringMethod("Free-Throw",1);//Creates a new scoring method for a free throw with the name of the scoring method and the amount of points associated 
		setPeriodName("Quarter");//Assigns the Period Name for this game type
		//Adds the scoring methods to the game class
		addScoringMethod(TwoPointShot);
		addScoringMethod(ThreePointShot);
		addScoringMethod(FreeThrow);
	}
}