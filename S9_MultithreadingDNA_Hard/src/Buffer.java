
public interface Buffer
{
   // place String value into Buffer
   public void blockingPut(char[] value) throws InterruptedException; 
   public void blockingPut(String value) throws InterruptedException; 
   public void blockingPut1(char[] value) throws InterruptedException; 
   public void blockingPut1(String value) throws InterruptedException; 

   // obtain string value from Buffer
   public char blockingGet() throws InterruptedException;
   public char blockingGet1() throws InterruptedException;
} // end interface Buffer
