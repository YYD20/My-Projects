//S3_Computus_Medium
//By:Nick Kozak
import java.util.Scanner; // program uses class Scanner

/**
 * Main driver class that tests EasterDate.java
 * 
 * @author Nick Kozak
 */
public class EasterTest {
	/**
	 * This method will automatically be called when EasterTest is run
	 * 
	 * @param args
	 *            Command line arguments.
	 */
    public static void main(String[] args) {
        // create a Scanner object to obtain input from the command window
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Year: ");// prompt
        int year = input.nextInt(); // read a line of text that asks for year
        /**
         *Creates new object for EasterDate and passes in year to compute the Easter date for that year
         */
        EasterDate e = new EasterDate(year);
        /**
         * Sets the year to the Year the user input into the console
         */
        e.setYear(year);
        /**
         *  Display the name stored in object EasterDate in the console
         */
        System.out.printf("Easter: %s , %d", e.getDate(),e.getYear());
        System.out.printf("\nEaster Cycle:\n");//prints this line to the console
        e.EasterCycle();//Calls the EasterCycle method
        input.close();//Closes the scanner input to stop resource/memory leaks
    }
}