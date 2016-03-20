import java.util.Scanner;
public class DNAHard implements Buffer 
{
	public char[] characters;
	private Scanner input;
	protected final int size = getCharacters().length;
	public DNAHard()
	{}
	public void DNAHARD() throws InterruptedException
	{
		input = new Scanner(System.in);
		System.out.println("Enter a DNA Strand:\n");
		String inputText  = input.nextLine();
		System.out.println("inputText length:"+inputText.length());
		System.out.println("Input char[]:");
		characters = new char[inputText.length()];
		inputStringtoChars(inputText.toUpperCase());
		System.out.println("Length of char array"+getCharacters().length);
		System.out.print("\nLength of newChars: " +getCharacters().length+"\n");
		System.out.println("\nBefore inserting char [] to blocking put");
		blockingPut(inputStringtoChars(inputText.toUpperCase()));
		//System.out.println("Gap Finder Filter:");
		//GapFinder g = new GapFinder();
		//g.gapFinder(inputStringtoChars(inputText.toUpperCase()));
		//Prints First Filter
		//ReverseComplementor r = new ReverseComplementor();
		//System.out.println("\nReverse Complementor Filter:");
		//r.reverseComplementor(g.getGapFinder());
		//System.out.println(reverseComplementor(gapFinder));//Prints Second Filter
		//System.out.println("\nFrameBuilder:");
		//FrameBuilder f = new FrameBuilder();
		//f.frameBuilder(r.getReverseComplementor());
		//System.out.println(frameBuilder(reverseComplementor(gapFinder)));
		//System.out.println("\nTranslator:");
		//Translator t = new Translator();
		//t.translator(f.getFrame());
		//System.out.println(dnaTranslator(getFrame()));
		//ORFFinder o = new ORFFinder();
		//System.out.println("\nAmino Acids:");
		//o.orfFinder(t.getAminoAcids());
		//System.out.println(orfFinder(getAminoAcids()));
	}
	private char[] inputStringtoChars(String input)
	{
		//char[] characters = new char[input.length()];
		System.out.printf("%s",input);
		for(int i =0; i < input.length();i++)
		{
			characters[i] = input.charAt(i);

		}
		//this.chars = characters;
		return characters;
		//return characters;
	}

	public char[] getCharacters()
	{
		//System.out.println("\nGets Chars here: "+characters.toString());
		
		return this.characters;
	}
//	public int size()
//	{
//		return characters.length;
//	}
	private final char[] buffer = {'1', '1', '1'}; // shared buffer

	private int occupiedCells = 0; // count number of buffers used
	private int writeIndex = 0; // index of next element to write to
	private int readIndex = 0; // index of next element to read

	// place value into buffer
	public synchronized void blockingPut(char[] value)
			throws InterruptedException
	{
		// wait until buffer has space available, then write value;
		// while no empty locations, place thread in waiting state
		while (occupiedCells == buffer.length) 
		{
			System.out.printf("Buffer is full. Next Filter waits.%n");
			wait(); // wait until a buffer cell is free
		} 

		buffer[writeIndex] = value[writeIndex]; // set new buffer value

		// update circular write index
		writeIndex = (writeIndex + 1) % buffer.length;

		++occupiedCells; // one more buffer cell is full
		System.out.println("\nOccupied cells "+occupiedCells+"\n");
		displayState("Filter writes " + value[writeIndex]);
		notifyAll(); // notify threads waiting to read from buffer
	} 

	// return value from buffer
	public synchronized char blockingGet() throws InterruptedException
	{
		// wait until buffer has data, then read value;
		// while no data to read, place thread in waiting state
		while (occupiedCells == 0) 
		{
			System.out.printf("Buffer is empty. Next Filter waits.%n");
			wait(); // wait until a buffer cell is filled
		} 

		char readValue = buffer[readIndex]; // read value from buffer

		// update circular read index
		readIndex = (readIndex + 1) % buffer.length;

		--occupiedCells; // one fewer buffer cells are occupied
		displayState("Consumer reads " + readValue);
		notifyAll(); // notify threads waiting to write to buffer

		return readValue;
	}
	private final String[] bufferString = {"1", "1", "1"}; // shared buffer

	//	   private int occupiedCells = 0; // count number of buffers used
	//	   private int writeIndex = 0; // index of next element to write to
	//	   private int readIndex = 0; // index of next element to read
	public synchronized void blockingPut1(String[] value)
			throws InterruptedException
	{
		// wait until buffer has space available, then write value;
		// while no empty locations, place thread in waiting state
		while (occupiedCells == buffer.length) 
		{
			System.out.printf("Buffer is full. Next Filter waits.%n");
			wait(); // wait until a buffer cell is free
		} 

		bufferString[writeIndex] = value[writeIndex]; // set new buffer value

		// update circular write index
		writeIndex = (writeIndex + 1) % buffer.length;

		++occupiedCells; // one more buffer cell is full
		System.out.println("\nOccupied cells "+occupiedCells+"\n");
		displayState("Filter writes " + value[writeIndex]);
		notifyAll(); // notify threads waiting to read from buffer
	} 

	// return value from buffer
	public synchronized char blockingGet1() throws InterruptedException
	{
		// wait until buffer has data, then read value;
		// while no data to read, place thread in waiting state
		while (occupiedCells == 0) 
		{
			System.out.printf("Buffer is empty. Next Filter waits.%n");
			wait(); // wait until a buffer cell is filled
		} 

		char readValue = buffer[readIndex]; // read value from buffer

		// update circular read index
		readIndex = (readIndex + 1) % buffer.length;

		--occupiedCells; // one fewer buffer cells are occupied
		displayState("Consumer reads " + readValue);
		notifyAll(); // notify threads waiting to write to buffer

		return readValue;
	}

	// display current operation and buffer state
	public synchronized void displayState(String operation)
	{
		// output operation and number of occupied buffer cells
		System.out.printf("%s%s%d)%n%s", operation, 
				" (buffer cells occupied: ", occupiedCells, "buffer cells:  ");

		for (char value : buffer)
			System.out.printf(" %2s  ", value); // output values in buffer

		System.out.printf("%n               ");

		for (int i = 0; i < buffer.length; i++)
			System.out.print("---- ");

		System.out.printf("%n               ");

		for (int i = 0; i < buffer.length; i++)
		{
			if (i == writeIndex && i == readIndex)
				System.out.print(" WR"); // both write and read index
			else if (i == writeIndex)
				System.out.print(" W   "); // just write index
			else if (i == readIndex)
				System.out.print("  R  "); // just read index
			else
				System.out.print("     "); // neither index
		} 

		System.out.printf("%n%n");
	}
	@Override
	public void blockingPut(String value) throws InterruptedException {
		// TODO Auto-generated method stub
		//do nothing 
	}
	@Override
	public void blockingPut1(String value) throws InterruptedException 
	{
		// TODO Auto-generated method stub

	}
	@Override
	public void blockingPut1(char[] value) throws InterruptedException {
		// TODO Auto-generated method stub

	}
}
