import java.security.SecureRandom;
/**
 * Class for the last filter of sequencing DNA
 * 
 * @author Nick Kozak
 *
 */
public class ORFFinder implements Runnable
{
	private String finalString;
	private final Buffer inputBuffer; // reference to shared object
	private final Buffer outputBuffer; // reference to shared object
	private static final SecureRandom generator = new SecureRandom();
	/**
	 * 
	 * @param sharedlocation
	 * Passes in the buffer location
	 */
	public ORFFinder(Buffer inputBuffer,Buffer outputBuffer)
	{
		this.inputBuffer = inputBuffer;
		this.outputBuffer = outputBuffer;
	}
	/**
	 * 
	 * @param inputString
	 * input String of amino acids
	 * @return output
	 * retruns the seperated amino acids
	 */
	public String orfFinder(String inputString)
	{
		String output = "";
		int stopCounter =0;
		int start = 0;
		//System.out.printf("String length: %d\n",inputString.length());
		for(int i = 0; i< inputString.length();i++)
		{
			if(inputString.substring(i,i+1).length() > 0)
			{
				//System.out.printf("%s\n",stopCounter);
				//System.out.printf("I:%s\n",i);
				if(inputString.charAt(i) =='*' )
				{
					if(stopCounter >=1 && inputString.length() >21)
					{
						output += inputString.substring(start+1,i)+"\n";
						//System.out.println("Current output 1: \n"+output);
					}
					else
					{
						stopCounter++;
						output += inputString.substring(start,i)+"\n";
						//System.out.println("Current output 2:\n"+output);
					}
					start = i;
				}
				if(inputString.charAt(i) !='*'&& i+1 == inputString.length() )
				{
					output += inputString.substring(start+1,start+3)+"\n";
				}
			}
		}
		finalString = output;
		return "Final output: \n" + output;
	}
	public void run()                             
	  {
	      int sum = 0;

	      for (int count = 1; count <= 10; count++)
	      {
	         try // sleep 0 to 3 seconds, then place value in Buffer
	         {
	            Thread.sleep(generator.nextInt(3000)); // random sleep
	            inputBuffer.blockingGet(); // set value in buffer
	            outputBuffer.blockingPut(finalString); // set value in buffer
	            sum += count; // increment sum of values
	         } 
	         catch (InterruptedException exception) 
	         {
	            Thread.currentThread().interrupt(); 
	         } 
	      } 

	      System.out.printf("Producer done producing%nTerminating Producer%n");
	   }
}
