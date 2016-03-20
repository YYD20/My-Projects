import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DNAHardTest extends DNAHard
{
	public static void main(String[] args) throws InterruptedException
	{
		DNAHard dna = new DNAHard();
		dna.DNAHARD();
		 // create new thread pool with two threads
	      ExecutorService executorService = Executors.newCachedThreadPool();

	      // create CircularBuffer to store Strings
	      DNAHard inputBuffer = new DNAHard();
	      DNAHard outputBuffer = new DNAHard();

	      // display the initial state of the CircularBuffer
	      inputBuffer.displayState("Initial State");

	      // execute the Producer and Consumer tasks
	      executorService.execute(new GapFinder(inputBuffer,outputBuffer));
	      executorService.execute(new ReverseComplementor(inputBuffer,outputBuffer));
//	      executorService.execute(new FrameBuilder(sharedLocation));
//	      executorService.execute(new Translator(sharedLocation));
//	      executorService.execute(new ORFFinder(sharedLocation));
//	      

	      executorService.shutdown();
	      executorService.awaitTermination(1, TimeUnit.MINUTES); 
	}
}
