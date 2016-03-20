/**
 * The Football class contains a two argument constructor and extends the Game class
 * @author Nick Kozak
 *
 */
public class Football extends Game 
{
	/**
	 * This method will automatically be called when ScoreboardTest is run
	 * @param home
	 * Passes in the home team object
	 * @param away
	 * Passes in the away team object
	 */
	public Football(Team hawk, Team  dirt) 
	{
		super(hawk, dirt);//
		//Creates a new scoring method object with the name of the scoring method and the amount of points associated 
		ScoringMethod TouchDown =  new ScoringMethod("TouchDown",6);
		ScoringMethod fieldgoal =  new ScoringMethod("Fieldgoal",3);
		ScoringMethod safety =  new ScoringMethod("Safety",2);
		ScoringMethod extrapoint1 =  new ScoringMethod("Extra-Point",1);
		ScoringMethod twopointconversion =  new ScoringMethod("2-point-conversion",2);
		setPeriodName("Quarter");//Assigns the Period Name for this game type
		//Adds the scoring methods to the game class
		addScoringMethod(TouchDown);
		addScoringMethod(fieldgoal);
		addScoringMethod(safety);
		addScoringMethod(extrapoint1);
		addScoringMethod(twopointconversion);
	}
}