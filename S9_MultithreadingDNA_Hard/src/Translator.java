import java.security.SecureRandom;
/**
 * Class for the 4th filter of sequencing DNA
 * 
 * @author Nick Kozak
 *
 */
public class Translator implements Runnable
{
	public String aminoAcids;
	private final Buffer sharedLocation; // reference to shared object
	private static final SecureRandom generator = new SecureRandom();
	/**
	 * 
	 * @param sharedlocation
	 * Passes in the buffer location
	 */
	public Translator(Buffer sharedlocation)
	{
		this.sharedLocation = sharedlocation;
	}
	//The code below is from the supplimental hw
	public enum Codon
	{
		//All of the different amino  acids
		UUU("Phe",'F'), UCU("Ser",'S'), UAU("Tyr",'Y'), UGU("Cys",'C'),
		UUC("Phe",'F'), UCC("Ser",'S'), UAC("Tyr",'Y'), UGC("Cys",'C'),
		UUA("Leu",'L'), UCA("Ser",'S'), UAA("Stop",'*'), UGA("Stop",'*'),
		UUG("Leu",'L'), UCG("Ser",'S'), UAG("Stop",'*'), UGG("Trp",'W'),

		CUU("Leu",'L'), CCU("Pro",'P'), CAU("His",'H'), CGU("Arg",'R'),
		CUC("Leu",'L'), CCC("Pro",'P'), CAC("His",'H'), CGC("Arg",'R'),
		CUA("Leu",'L'), CCA("Pro",'P'), CAA("Gin",'Q'), CGA("Arg",'R'),
		CUG("Leu",'L'), CCG("Pro",'P'), CAG("Gin",'Q'), CGG("Arg",'R'),

		AUU("Ile",'I'), ACU("Thr",'T'), AAU("Asn",'N'), AGU("Ser",'S'),
		AUC("Ile",'I'), ACC("Thr",'T'), AAC("Asn",'N'), AGC("Ser",'S'),
		AUA("Ile",'I'), ACA("Thr",'T'), AAA("Lys",'K'), AGA("Arg",'R'),
		AUG("Met",'M'), ACG("Thr",'T'), AAG("Lys",'K'), AGG("Arg",'R'),

		GUU("Val",'V'), GCU("Ala",'A'), GAU("Asp",'D'), GGU("Gly",'G'),
		GUC("Val",'V'), GCC("Ala",'A'), GAC("Asp",'D'), GGC("Gly",'G'),
		GUA("Val",'V'), GCA("Ala",'A'), GAA("Glu",'E'), GGA("Gly",'G'),
		GUG("Val",'V'), GCG("Ala",'A'), GAG("Glu",'E'), GGG("Gly",'G');

		private String threeLetterCode;
		private char oneLetterCode;
		/**
		 * 
		 * @param threeLetter
		 * Three letter parameter of the Amino Acid
		 * @param oneLetter
		 * One letter parameter of the Amino Acid
		 * 
		 */
		private Codon(String threeLetter, char oneLetter)
		{
			threeLetterCode = threeLetter;
			oneLetterCode = oneLetter;
		}
		/**
		 * 
		 * @return threeLetterCode
		 * returns the 3letter code of the codon /amino acid
		 */
		public String getThreeLetterCode()
		{
			return threeLetterCode;
		}
		/**
		 * 
		 * @return oneLetterCode
		 * returns the one letter code for the Codon /amino acid
		 */
		public char getOneLetterCode()
		{
			return oneLetterCode;
		}
		//from slides they gave us
		public static Codon getCodon(String codon)
		{
			codon = codon.toUpperCase();
			codon = codon.replace('T', 'U');//replaces the old character 't' with a new character'u' 
			return valueOf(codon);
		}
	}
	/**
	 * 
	 * @param inputSequence
	 * inputString
	 * @return
	 * Returns the inputSequence in amino acid form
	 */
	public String translator(String inputSequence)
	{
		String translate = "";
		String output = "";
		System.out.println("Input String: \n"+ inputSequence);
		for(int i = 0; i< inputSequence.length();i+=3)
		{
			if(inputSequence.substring(i,i+3).length() >=3)
			{
				if(inputSequence.charAt(i) == '\n')
				{
					i++;
					translate = inputSequence.substring(i,i+3);
					//System.out.println("Sequence: "+translate);
					//System.out.printf("i: %s\n",i);
				}
				else
				{
					translate =  inputSequence.substring(i,i+3);
					//System.out.println("Sequence: "+translate);
					//System.out.printf("i: %s\n",i);
				}
				Codon c = Codon.getCodon(translate);
				output += c.getOneLetterCode();
				//start=i;
			}
		}
		setAminoAcids(output);
		//add output String to output buffer
		return "Output:\n" + output;
	}
	/**
	 * 
	 * @param amino
	 * Amino acid string 
	 */
	private void setAminoAcids(String amino)
	{
		this.aminoAcids = amino;
	}
	/**
	 * 
	 * @return aminoAcids
	 * returns the string of amino acids
	 */
	public String getAminoAcids()
	{
		return aminoAcids;
	}
	public void run()                             
	  {
	      int sum = 0;

	      for (int count = 1; count <= 10; count++)
	      {
	         try // sleep 0 to 3 seconds, then place value in Buffer
	         {
	            Thread.sleep(generator.nextInt(3000)); // random sleep
	            sharedLocation.blockingPut(aminoAcids); // set value in buffer
	            sum += count; // increment sum of values
	         } 
	         catch (InterruptedException exception) 
	         {
	            Thread.currentThread().interrupt(); 
	         } 
	      } 

	      System.out.printf("Translator done translating%nTerminating Translator%n");
	   }
}
