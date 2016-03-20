import java.security.SecureRandom;
/**
 * Class for the 1st filter of sequencing DNA
 * 
 * @author Nick Kozak
 *
 */
public class GapFinder extends DNAHard implements Runnable
{
	private final Buffer inputBuffer; // reference to shared object
	private final Buffer outputBuffer; // reference to shared object
	private static final SecureRandom generator = new SecureRandom();
	private char[] gapFinder;
	//int size = getCharacters().length;
	/**
	 * 
	 * @param sharedlocation
	 * Passes in the buffer location
	 */
	public GapFinder(Buffer inputBuffer,Buffer outputBuffer)
	{
		this.inputBuffer = inputBuffer;
		this.outputBuffer = outputBuffer;
		//gapFinder = new char[getChars().length];
		//gapFinder();
	}

	public void gapFinder()
	{

//		try // sleep 0 to 3 seconds, then place value in Buffer
//		{
//			Thread.sleep(generator.nextInt(3000)); // random sleep
//			sharedLocation.blockingGet(); // get string in buffer
//			System.out.println("Inside buffer"+sharedLocation.blockingGet());
//			//start += i; // increment sum of values
//			System.out.println("Gap Finder: "+gapFinder.toString());
//		} 
//		catch (InterruptedException exception) 
//		{
//			Thread.currentThread().interrupt(); 
//		} 

	}
	public void run()                             
	{
		int start = 0;
		//String newString = "";
//		this.gapFinder = getChars();
//		System.out.printf("GapFinder length:"+gapFinder.length);
//		for (int i =0; i <gapFinder.length;i++)
//		{   
//			System.out.printf("%s",gapFinder[i]);
//		}
		//System.out.println(getChars());
		//printChars();
		//int i = 0;
		//System.out.printf("i: %s\n",i);
		//System.out.println(getChars().length);
		for(int i = 0; i<size;i++)
		{
			if(getCharacters()[i]=='N'||getCharacters()[i]=='n')
			{

				System.out.printf("start: %s\n",start);
				if(getCharacters().length > 0)
				{
					try // sleep 0 to 3 seconds, then place value in Buffer
					{
						Thread.sleep(generator.nextInt(3000)); // random sleep
						inputBuffer.blockingGet();
						outputBuffer.blockingPut(gapFinder); // set chars in buffer
						System.out.println("Put "+gapFinder.toString()+"into buffer\n");
						start += i; // increment sum of values
					} 
					catch (InterruptedException exception) 
					{
						Thread.currentThread().interrupt(); 
					} 
				}
			}
			if(getCharacters()[i]== ' ')
			{
				//do nothing 
			}
			if(getCharacters()[i]=='A'||getCharacters()[i]=='C'||getCharacters()[i]=='G'||getCharacters()[i]=='T')
			{

				gapFinder[i]=getCharacters()[i];
				//System.out.printf("\nString :%s\n", newString);
			} 
			i++;
			System.out.printf(
					"GapFinder done feeding %nTerminating GapFinder%n");
		}
	} 
	public char[] getGapFinder()
	{
		return gapFinder;
	}
}
