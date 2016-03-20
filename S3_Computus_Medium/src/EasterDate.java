// Meeus/Jones/Butcher Gregorian algorithm 
// This code was obtained from wikipedia at https://en.wikipedia.org/wiki/Computus#Meeus_Julian_algorithm
/**
 * This class has a one-argument constructor and ten public methods.
 *            
 */
public class EasterDate {
	/**
	 * instance variable for the easter year
	 */
	private int year;
	/**
	 * instance variable for the easter month
	 */
	private String month;
	/**
	 * instance variable for the day
	 */
	private int day;
	/**
	 * instance variable for the month number
	 */
	private int monthnum;
	/**
	 * instance variable for the easter date (month and day)
	 */
	private String date;
	/**
	 * One Argument Constructor for the date conversion
	 * @param year
	 * 	The year of which you'd like to get the Easter Date
	 */
	public EasterDate(int year) 
	{
		/** Meeus/Jones/Butcher Gregorian algorithm 
		* This code was obtained from wikipedia at 
		* https://en.wikipedia.org/wiki/Computus#Meeus_Julian_algorithm
		*/
		int a = year % 19;
		int b = year / 100;
		int c = year % 100;
		int d = b / 4;
		int e = b % 4;
		int f = (b + 8) / 25;
		int g = (b - f + 1) / 3;
		int h = (19 * a + b - d - g + 15) % 30;
		int i = c / 4;
		int k = c % 4;
		int l = (32 + 2 * e + 2 * i - h - k) % 7;
		int m = (a + 11 * h + 22 * l) / 451;
		monthnum = (h + l - 7 * m + 114) / 31;
		day = (h + l - 7 * m + 114) % 31 + 1;
	}
	/**
	 * Method sets the date and year of Easter
	 * @param date
	 * 		Date of Easter
	 * @param year
	 * 		Year of Easter 
	 */
	public void setDate(String date, int year) {
		this.year = year;
		this.date = date;
	}
	/**
	 * Method gets the date and year of Easter
	 * @return date
	 * 	Returns the Date for Easter
	 */
	public String getDate() {
		date = getMonth() + " " + getDayString();
		return date;
	}
	/**
	 * Method sets the year of Easter
	 * @param year
	 * 		Year of Easter 
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Method gets the year of Easter
	 * @return year
	 * 		Returns the year for Easter 
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Method sets the day of Easter
	 * @param day
	 * 		Day of Easter 
	 */
	public void setDay(int day) {
		this.day = day;
	}
	/**
	 * Method gets the day of Easter
	 * @return day
	 * 		Returns the Day of Easter 
	 */
	public int getDay(){
		
		return day;
	}

	/**
	 * Method gets the day of Easter
	 * @return Day
	 * 		Returns a string of the Day of Easter 
	 */
	public String getDayString() {
		String Day=Integer.toString(day);
		return Day;
	}

	/**
	 * Method sets the month of Easter
	 * @param month
	 * 		Returns the month of Easter 
	 */
	public void setMonth(String month) {

		this.month = month;
	}

	/**
	 * Method gets the month of Easter
	 * @return month 
	 * 		Returns the month of Easter 
	 */
	public String getMonth() {
		switch (monthnum) {
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		default:
			break;
		}
		return month;
	}
	/**
	 * Method that prints the Easter date cycle over 5700000 years
	 */
	public void EasterCycle() {
		int i= 0;
		//initialize the date count arrays for the two months in the cycle
		int marchDateCtr[]=new int[32];//first element of the array is not used to store date b/c there is no 0th day
		int aprilDateCtr[]=new int[31];//first element of the array is not used to store date b/c there is no 0th day
		for (i = 0; i <= 5700000; i++)
		{
			/**
			 * Creates temporary Easter dates to fill the Date Count Array 
			 */
			EasterDate tempDate = new EasterDate(i);//Creates a new  EasterDate object
			tempDate.setYear(i);//sets the year of Easter 
			day=tempDate.getDay();//gets the day of easter by calling getDay() method
			date=tempDate.getMonth() + " "+tempDate.getDayString()+" ";//extra space allows for the date array to account for single and double digit days
			/**
			 * Parses the date string to find which date occurs and adds onto the counter for that date in the date counter array
			 */
			if(date.substring(0,5).equals("March")){
				switch (day) {
				case 22:
					marchDateCtr[day]++;
					break;
				case 23:
					marchDateCtr[day]++;
					break;
				case 24:
					marchDateCtr[day]++;
					break;
				case 25:
					marchDateCtr[day]++;
					break;
				case 26:
					marchDateCtr[day]++;
					break;
				case 27:
					marchDateCtr[day]++;
					break;
				case 28:
					marchDateCtr[day]++;
					break;
				case 29:
					marchDateCtr[day]++;
					break;
				case 30:
					marchDateCtr[day]++;
					break;
				case 31:
					marchDateCtr[day]++;
					break;
				}
			}
			else if(date.substring(0,5).equals("April")){
				switch (day) {
				case 1:
					aprilDateCtr[day]++;
					break;
				case 2:
					aprilDateCtr[day]++;
					break;
				case 3:
					aprilDateCtr[day]++;
					break;
				case 4:
					aprilDateCtr[day]++;
					break;
				case 5:
					aprilDateCtr[day]++;
					break;
				case 6:
					aprilDateCtr[day]++;
					break;
				case 7:
					aprilDateCtr[day]++;
					break;
				case 8:
					aprilDateCtr[day]++;
					break;
				case 9:
					aprilDateCtr[day]++;
					break;
				case 10:
					aprilDateCtr[day]++;
					break;
				case 11:
					aprilDateCtr[day]++;
					break;
				case 12:
					aprilDateCtr[day]++;
					break;
				case 13:
					aprilDateCtr[day]+=1;
					break;
				case 14:
					aprilDateCtr[day]+=1;
					break;
				case 15:
					aprilDateCtr[day]+=1;
					break;
				case 16:
					aprilDateCtr[day]+=1;
					break;
				case 17:
					aprilDateCtr[day]++;
					break;
				case 18:
					aprilDateCtr[day]++;
					break;
				case 19:
					aprilDateCtr[day]++;
					break;
				case 20:
					aprilDateCtr[day]++;
					break;
				case 21:
					aprilDateCtr[day]++;
					break;
				case 22:
					aprilDateCtr[day]++;
					break;
				case 23:
					aprilDateCtr[day]++;
					break;
				case 24:
					aprilDateCtr[day]++;
					break;
				case 25:
					aprilDateCtr[day]++;
					break;
				}
			}
		}
		/**
		 * Prints out the March Date Count array to the console
		 */
		for (i=22;i<=31;i++){
			System.out.printf("March %s - %s\n",i,marchDateCtr[i]);
			/**
			 * Prints out the April Date Count array to the console
			 */
		}
		for(i=1;i<=25;i++){
			System.out.printf("April %s - %s\n",i,aprilDateCtr[i]);
		}
	}
}