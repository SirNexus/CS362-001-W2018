package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
         long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
         GregorianCalendar day = new GregorianCalendar(2018, 02, 18);
         GregorianCalendar nextDay = new GregorianCalendar(2018, 03, 18);

		 
		 System.out.println("Start testing...");
		 
		try{ 
            for (int i = 0; i < NUM_TESTS; i++) {
                LinkedList<Appt> listAppts = new LinkedList<Appt>();
                Appt removeAppt = null;
                for (int iteration = 0; elapsed < NUM_TESTS; iteration++) {
                    long randomseed =System.currentTimeMillis(); //10
        //			System.out.println(" Seed:"+randomseed );
                    Random random = new Random(randomseed);
                    
                    int startHour=ValuesGenerator.RandInt(random);
                    int startMinute=ValuesGenerator.RandInt(random);
                    int startDay=ValuesGenerator.RandInt(random);;
                    int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                    int startYear=ValuesGenerator.getRandomIntBetween(random, 2017, 2019);
                    String title="Birthday Party";
                    String description="This is my birthday party.";
                    //Construct a new Appointment object with the initial data	 
                    Appt appt = new Appt(startHour,
                            startMinute ,
                            startDay ,
                            startMonth ,
                            startYear ,
                            title,
                            description);
                            
                // if(!appt.getValid())continue;
                
                listAppts.add(appt);
                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);

                if (appt.getValid()){
                    removeAppt = appt;
                }

                if((iteration%10000)==0 && iteration!=0 )
                      System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
                }
                LinkedList<CalDay> calDays = new LinkedList<CalDay>();
                TimeTable timeTable=new TimeTable();
                calDays = timeTable.getApptRange(listAppts, day, nextDay);

                listAppts = timeTable.deleteAppt(listAppts, removeAppt);
                listAppts = null;
                listAppts = timeTable.deleteAppt(listAppts, removeAppt);
            }
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }


	
}
