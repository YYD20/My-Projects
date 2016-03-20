import java.util.Scanner;

/**
 * Main driver class that tests Scoreboard
 * @author Nick Kozak
 */
public class ScoreboardTest {
	/**
	 * This method will automatically be called when ScoreboardTest is run
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(String[] args) 
	{
		boolean loop = true;//boolean variable for the menu loop
		Scanner input = new Scanner(System.in);//create a Scanner object to obtain input from the command window
		while(loop !=false)
		{
			System.out.println("Select type of game:\n1. Football\n2. Basketball\n3. Soccer\n4. Hockey\n5. End program\nEnter choice:");
			String choice = input.nextLine();//Gets user input for game choice
			//If the choice is for football
			if (choice.equals("1"))
			{
				System.out.printf("Enter Home Team: ");
				String firstTeam = input.nextLine();//Gets user input for the first team name
				Team home = new Team(firstTeam);//Creates new Team object for the home team
				System.out.printf("Enter Away Team: ");
				String secondTeam = input.nextLine();//Gets user input for the first team name
				Team away = new Team(secondTeam);//Creates new Team object for the away team
				Game hyveeCyHawk = new Football(home, away);//Creates new Game object 
				hyveeCyHawk.sportName("Football");//Assigns the Game type name
				boolean bool = true;//boolean variable for the game loop
				hyveeCyHawk.setPeriod();//Sets the game period
				while(bool != false)
				{
					System.out.println("\nMenu:");//Prints the home team part of the menu
					for(int i=0;i<hyveeCyHawk.getScoringMethods().size();i++)
					{
						System.out.printf("%d.%s %s\n",i+1,
								away.getTeamName(),hyveeCyHawk.getScoringMethods().get(i).getName());
					}
					//Prints the away team part of the menu
					for(int i=0;i<hyveeCyHawk.getScoringMethods().size();i++)
					{
						System.out.printf("%d.%s %s\n",i+6,
								home.getTeamName(),hyveeCyHawk.getScoringMethods().get(i).getName());
					} 
					System.out.printf("%d.End %s\n",hyveeCyHawk.getScoringMethods().size()*2+1,hyveeCyHawk.getPeriodName());
					System.out.printf("Enter Choice: ");
					Integer intChoice = input.nextInt();// Gets the user input for the scoring choice
					if(intChoice < 1 || intChoice >hyveeCyHawk.getScoringMethods().size()*2+1)//Checks to see if the inputted number is in the correct bounds 
					{
						System.out.println("Please Enter a Number on the Menu\n");
					}
					if (intChoice < hyveeCyHawk.getScoringMethods().size()+1)//if the input choice is from 1 to 5 - points go to the away team
					{
						away.addScore(hyveeCyHawk.getScoringMethods().get(intChoice-1).getPoints());//Adds points for a scoring method to the away score
					}
					if(intChoice < hyveeCyHawk.getScoringMethods().size()*2+1 && intChoice > hyveeCyHawk.getScoringMethods().size())//if the input choice is from 6 to 10 - points go to the away team
					{
						home.addScore(hyveeCyHawk.getScoringMethods().get(intChoice-6).getPoints());//Adds points for a scoring method to the home score
					}
					if(intChoice == hyveeCyHawk.getScoringMethods().size()*2+1 )
					{
						if (hyveeCyHawk.isGameOver()!=true)//Checks to see if the game is over
						{
							System.out.printf("\n%s %s Ended\n",hyveeCyHawk.getPeriodName(),hyveeCyHawk.getPeriod());
							hyveeCyHawk.setPeriod();//sets the next period
						}
						else
						{
							bool = false;
						}
					}
					if(bool!=false)//prints the current score and period
					{
						System.out.printf("\nCurrent Score:"+hyveeCyHawk.getScore()+"\n"+"Current %s: %s\n",hyveeCyHawk.getPeriodName(),hyveeCyHawk.getPeriod());
					}	
				}
				//Prints the final score of the game and the winner of the game
				System.out.printf("\nGame over.\nFinal Score:%s\nWinner: %s\n\n",hyveeCyHawk.getScore(),hyveeCyHawk.getLeader());

			}
			//Uses the same logic if the choice was 1 except it's a different game type
			else if (choice.equals("2"))
			{
				System.out.printf("Enter Home Team: ");
				String firstTeam = input.nextLine();
				Team home = new Team(firstTeam);
				System.out.printf("Enter Away Team: ");
				String secondTeam = input.nextLine();
				Team away = new Team(secondTeam);
				Game basketball = new Basketball(home, away);
				basketball.sportName("Basketball");
				boolean bool = true;
				basketball.setPeriod();
				while(bool != false)
				{
					System.out.println("\nMenu:");
					for(int i=0;i<basketball.getScoringMethods().size();i++)
					{
						System.out.printf("%d.%s %s\n",i+1,
								away.getTeamName(),basketball.getScoringMethods().get(i).getName());
					}
					for(int i=0;i<basketball.getScoringMethods().size();i++)
					{
						System.out.printf("%d.%s %s\n",i+4,
								home.getTeamName(),basketball.getScoringMethods().get(i).getName());
					} 
					System.out.printf("%d.End %s\n",basketball.getScoringMethods().size()*2+1,basketball.getPeriodName());
					System.out.printf("Enter Choice: ");
					Integer intChoice = input.nextInt();
					if(intChoice < 1 || intChoice >basketball.getScoringMethods().size()*2+1)//Checks to see if the inputted number is in the correct bounds 
					{
						System.out.println("Please Enter a Number on the Menu\n");
					}
					if (intChoice < basketball.getScoringMethods().size()+1)//if the input choice is from 1 to 5 - points go to the away team
					{
						away.addScore(basketball.getScoringMethods().get(intChoice-1).getPoints());//Adds points for a scoring method to the away score
					}
					if(intChoice < basketball.getScoringMethods().size()*2+1 && intChoice > basketball.getScoringMethods().size())//if the input choice is from 6 to 10 - points go to the away team
					{
						home.addScore(basketball.getScoringMethods().get(intChoice-4).getPoints());//Adds points for a scoring method to the home score
					}
					if(intChoice == basketball.getScoringMethods().size()*2+1 )
					{
						if (basketball.isGameOver()!=true)
						{
							System.out.printf("\n%s %s Ended\n",basketball.getPeriodName(),basketball.getPeriod());
							basketball.setPeriod();
						}
						else
						{
							bool = false;
						}
					}
					if(bool!=false)
					{
						System.out.printf("\nCurrent Score:"+basketball.getScore()+"\n"+"Current %s : %s\n",basketball.getPeriodName(),basketball.getPeriod());
					}	
				}
				System.out.printf("\nGame over.\nFinal Score:%s\nWinner: %s\n\n",basketball.getScore(),basketball.getLeader());
			}
			//Uses the same logic if the choice was 1 except it's a different game type
			else if (choice.equals("3"))
			{
				System.out.printf("Enter Home Team: ");
				String firstTeam = input.nextLine();
				Team home = new Team(firstTeam);
				System.out.printf("Enter Away Team: ");
				String secondTeam = input.nextLine();
				Team away = new Team(secondTeam);
				Game soccer = new Soccer(home, away);
				soccer.sportName("Soccer");
				boolean bool = true;
				soccer.setPeriod();
				while(bool != false)
				{
					System.out.println("\nMenu:");
					for(int i=0;i<soccer.getScoringMethods().size();i++)
					{
						System.out.printf("%d.%s %s\n",i+1,
								away.getTeamName(),soccer.getScoringMethods().get(i).getName());
					}
					for(int i=0;i<soccer.getScoringMethods().size();i++)
					{
						System.out.printf("%d.%s %s\n",i+2,
								home.getTeamName(),soccer.getScoringMethods().get(i).getName());
					} 
					System.out.printf("%d.End %s\n",soccer.getScoringMethods().size()*2+1,soccer.getPeriodName());
					System.out.printf("Enter Choice: ");
					Integer intChoice = input.nextInt();
					if(intChoice < 1 || intChoice >soccer.getScoringMethods().size()*2+1)//Checks to see if the inputted number is in the correct bounds 
					{
						System.out.println("Please Enter a Number on the Menu\n");
					}
					if (intChoice < soccer.getScoringMethods().size()+1)//if the input choice is from 1 to 5 - points go to the away team
					{
						away.addScore(soccer.getScoringMethods().get(intChoice-1).getPoints());//Adds points for a scoring method to the away score
					}
					if(intChoice < soccer.getScoringMethods().size()*2+1 && intChoice > soccer.getScoringMethods().size())//if the input choice is from 6 to 10 - points go to the away team
					{
						home.addScore(soccer.getScoringMethods().get(intChoice-2).getPoints());//Adds points for a scoring method to the home score
					}
					if(intChoice == soccer.getScoringMethods().size()*2+1 )
					{
						if (soccer.isGameOver()!=true)
						{
							System.out.printf("\n%s %s Ended\n",soccer.getPeriodName(),soccer.getPeriod());
							soccer.setPeriod();
						}
						else
						{
							bool = false;
						}
					}
					if(bool!=false)
					{
						System.out.printf("\nCurrent Score:"+soccer.getScore()+"\n"+"Current %s : %s\n",soccer.getPeriodName(),soccer.getPeriod());
					}	
				}
				System.out.printf("\nGame over.\nFinal Score:%s\nWinner: %s\n\n",soccer.getScore(),soccer.getLeader());
			}
			//Uses the same logic if the choice was 1 except it's a different game type
			else if (choice.equals("4"))
			{
				System.out.printf("Enter Home Team: ");
				String firstTeam = input.nextLine();
				Team home = new Team(firstTeam);
				System.out.printf("Enter Away Team: ");
				String secondTeam = input.nextLine();
				Team away = new Team(secondTeam);
				Game hockey = new Hockey(home, away);
				hockey.sportName("Hockey");
				boolean bool = true;
				hockey.setPeriod();
				while(bool != false)
				{
					System.out.println("\nMenu:");
					for(int i=0;i<hockey.getScoringMethods().size();i++)
					{
						System.out.printf("%d.%s %s\n",i+1,
								away.getTeamName(),hockey.getScoringMethods().get(i).getName());
					}
					for(int i=0;i<hockey.getScoringMethods().size();i++)
					{
						System.out.printf("%d.%s %s\n",i+2,
								home.getTeamName(),hockey.getScoringMethods().get(i).getName());
					} 
					System.out.printf("%d.End %s\n",hockey.getScoringMethods().size()*2+1,hockey.getPeriodName());
					System.out.printf("Enter Choice: ");
					Integer intChoice = input.nextInt();
					if(intChoice < 1 || intChoice >hockey.getScoringMethods().size()*2+1)//Checks to see if the inputted number is in the correct bounds 
					{
						System.out.println("Please Enter a Number on the Menu\n");
					}
					if (intChoice < hockey.getScoringMethods().size()+1)//if the input choice is from 1 to 5 - points go to the away team
					{
						away.addScore(hockey.getScoringMethods().get(intChoice-1).getPoints());//Adds points for a scoring method to the away score
					}
					if(intChoice < hockey.getScoringMethods().size()*2+1 && intChoice > hockey.getScoringMethods().size())//if the input choice is from 6 to 10 - points go to the away team
					{
						home.addScore(hockey.getScoringMethods().get(intChoice-2).getPoints());//Adds points for a scoring method to the home score
					}
					if(intChoice == hockey.getScoringMethods().size()*2+1 )
					{
						if (hockey.isGameOver()!=true)
						{
							System.out.printf("\n%s %s Ended\n",hockey.getPeriodName(),hockey.getPeriod());
							hockey.setPeriod();
						}
						else
						{
							bool = false;
						}
					}
					if(bool!=false)
					{
						System.out.printf("\nCurrent Score:"+hockey.getScore()+"\n"+"Current %s : %s\n",hockey.getPeriodName(),hockey.getPeriod());
					}	
				}
				System.out.printf("\nGame over.\nFinal Score:%s\nWinner: %s\n\n",hockey.getScore(),hockey.getLeader());
			}
			//Exits the program
			else if (choice.equals("5"))
			{
				loop =false;
				System.out.println("Thanks for using Scoreboard!");
				System.exit(0);
			}
			//Tells the user to input something on the menu
			else
			{
				System.out.println("Please input a number in the menu\n");
			}
		}
		input.close();//closes input scanner to stop memory leaks
	}

}