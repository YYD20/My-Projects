import java.security.SecureRandom;
/**
 * Class for the 2nd filter of sequencing DNA
 * 
 * @author Nick Kozak
 *
 */
public class ReverseComplementor implements Runnable
{
	private final Buffer inputBuffer; // reference to shared object
	private final Buffer outputBuffer; // reference to shared object
	private static final SecureRandom generator = new SecureRandom();
	private String gapFinder;
	private String reverseComplement;
	/**
	 * 
	 * @param sharedlocation
	 * Passes in the buffer location
	 */
	public ReverseComplementor(Buffer inputBuffer,Buffer outputBuffer)
	{
		this.inputBuffer = inputBuffer;
		this.outputBuffer = outputBuffer;
	}
	/**
	 * 
	 * @param input
	 * Input String
	 */
	public void reverseComplementor(String input)
	{
		String reverse = "";
		for(int i = input.length()-1; i >=0;i--)
		{
			reverse+= input.charAt(i);
		}
		String complement = "";
		for(int i = 0; i < reverse.length();i++)
		{
			if(reverse.charAt(i) == 'A')
			{
				complement+='T';
			}
			if(reverse.charAt(i) == 'T')
			{
				complement+='A';
			}
			if(reverse.charAt(i) == 'C')
			{
				complement+='G';
			}
			if(reverse.charAt(i) == 'G')
			{
				complement+='C';
			}

		}
		String reverseComplement = gapFinder + "\n" + complement;
		this.reverseComplement = reverseComplement;
		//return reverseComplement;
	}
	/**
	 * 
	 * @return reverseComplement
	 * Retunrs the reverse complement of the original string
	 */
	public String getReverseComplementor()
	{
		return reverseComplement;
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
	            outputBuffer.blockingPut(reverseComplement);
	            sum += count; // increment sum of values
	         } 
	         catch (InterruptedException exception) 
	         {
	            Thread.currentThread().interrupt(); 
	         } 
	      } 

	      System.out.printf("Complementor done feeding g%nTerminating Complementor%n");
	   }
	         
}
