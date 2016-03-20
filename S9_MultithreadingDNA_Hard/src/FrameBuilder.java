import java.security.SecureRandom;
/**
 * Class for the 3rd filter of sequencing DNA
 * 
 * @author Nick Kozak
 *
 */
public class FrameBuilder implements Runnable
{
	private final Buffer inputBuffer; // reference to shared object
	private final Buffer outputBuffer; // reference to shared object
	private static final SecureRandom generator = new SecureRandom();
	private String frameBuilder;
	/**
	 * 
	 * @param sharedlocation
	 * Passes in the buffer location
	 */
	public FrameBuilder(Buffer inputBuffer,Buffer outputBuffer)
	{
		this.inputBuffer = inputBuffer;
		this.outputBuffer = outputBuffer;
	}
	/**
	 * 
	 * @param inputString
	 * @return all the possible cases for the bases
	 */
	public String frameBuilder(String inputString)
	{
		String removedFirstBase ="";
		String removedFirstandSecondBase = "";
		for(int i = 1; i<inputString.length()/2+1; i++)//finds the first half of the string and accounts for the \n character
		{
			removedFirstBase+= inputString.charAt(i);
		}
		for(int i = inputString.length()/2 + 2; i<inputString.length(); i++)
		{

			removedFirstBase+= inputString.charAt(i);
		}
		for(int i = 1; i<removedFirstBase.length()/2+1; i++)
		{
			removedFirstandSecondBase+= removedFirstBase.charAt(i);
		}
		for(int i = removedFirstBase.length()/2+2; i<removedFirstBase.length(); i++)
		{
			removedFirstandSecondBase+= removedFirstBase.charAt(i);
		}
		if((inputString.length()-1) % 3 ==0)//-1 is to account for the \n character
		{
			//System.out.println("Input String OG");
			setFrame(inputString);
		}
		if((removedFirstBase.length()-1) % 3 == 0)
		{
			//System.out.println("Input String -1");
			setFrame(removedFirstBase);
		}
		if((removedFirstandSecondBase.length() -1) % 3 == 0)
		{
			//System.out.println("Input String -2");
			setFrame(removedFirstandSecondBase);
		}
		
		return inputString +"\n\n" + removedFirstBase +"\n\n" + removedFirstandSecondBase;
	}
	/**
	 * 
	 * @param frame
	 * frame of DNA
	 */
	private void setFrame(String frame)
	{
		this.frameBuilder= frame;
	}
	/**
	 * 
	 * @return framBuilder
	 * returns the frame of the DNA
	 */
	public String getFrame()
	{
		return frameBuilder;
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
	            outputBuffer.blockingPut(frameBuilder); // set value in buffer
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
