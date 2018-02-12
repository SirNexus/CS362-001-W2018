package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
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
	// assertions
		assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	// Test that the set methods work as expected
	 @Test
	  public void test02()  throws Throwable  {
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(21,
		    	30 ,
		        15 ,
		        01 ,
		        2018 ,
		        "Birthday Party",
		        "This is my birthday party.");
		// Setters
		appt.setStartHour(22);
		appt.setStartMinute(31);
		appt.setStartDay(16);
		appt.setStartMonth(02);
		appt.setStartYear(2019);
		appt.setTitle(null);
		assertEquals("", appt.getTitle());
		appt.setTitle("My Birthday Party");
		appt.setDescription(null);
		assertEquals("", appt.getDescription());
		appt.setDescription("This is one of my birthday parties.");
		assertEquals("This is one of my birthday parties.", appt.getDescription());

		// assertions
		assertTrue(appt.getValid());
		assertEquals(22, appt.getStartHour());
		assertEquals(31, appt.getStartMinute());
		assertEquals(16, appt.getStartDay());
		assertEquals(02, appt.getStartMonth());
		assertEquals(2019, appt.getStartYear());
		assertEquals("My Birthday Party", appt.getTitle());
		assertEquals("This is one of my birthday parties.", appt.getDescription());    
	 }

	 @Test
	  public void test03()  throws Throwable  {
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(21,
		    	30 ,
		        15 ,
		        01 ,
		        2018 ,
		        "Birthday Party",
		        "This is my birthday party.");
		
		assertEquals(true, appt.getValid());

		appt.setStartHour(24);
		assertEquals(false, appt.getValid());
		appt.setStartHour(23);
		assertEquals(true, appt.getValid());

		appt.setStartHour(-1);
		assertEquals(false, appt.getValid());
		appt.setStartHour(0);
		assertEquals(true, appt.getValid());

		appt.setStartMinute(60);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(59);
		assertEquals(true, appt.getValid());

		appt.setStartMinute(-1);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(0);
		assertEquals(true, appt.getValid());

		appt.setStartDay(0);
		assertEquals(false, appt.getValid());
		appt.setStartDay(1);
		assertEquals(true, appt.getValid());
		
		int month = CalendarUtil.NumDaysInMonth(2018, 0);
		appt.setStartDay(month + 1);
		assertEquals(false, appt.getValid());
		appt.setStartDay(month);
		assertEquals(true, appt.getValid());

		// appt.setStartMonth(13); -- can't test this because it causes exception
		appt.setStartMonth(12);
		assertEquals(true, appt.getValid());
		appt.setStartMonth(1);
		assertEquals(true, appt.getValid());

		appt.setStartYear(-1);
		assertEquals(true, appt.getValid());
	 }
	
	// Test that recurrence
	 @Test
	  public void test04()  throws Throwable  {
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(21,
		        30 ,
		        15 ,
		        01 ,
		        2018 ,
		        "Birthday Party",
				"This is my birthday party.");
		
		int []intArr = {0,3};
		appt.setRecurrence(intArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_NEVER);

		assertArrayEquals(intArr, appt.getRecurDays());
		assertEquals(false, appt.isRecurring());

		int []zeroArr = new int[0];
		appt.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);

		assertArrayEquals(zeroArr, appt.getRecurDays());

		assertEquals(Appt.RECUR_BY_WEEKLY, appt.getRecurBy());
		assertEquals(true, appt.isRecurring());
		assertEquals(1, appt.getRecurIncrement());
		assertEquals(Appt.RECUR_NUMBER_FOREVER, appt.getRecurNumber());
	 }

	// Test toString
	 @Test
	 public void test05()  throws Throwable  {
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(12,
		    	30 ,
		        15 ,
		        01 ,
		        2018 ,
		        "Birthday Party",
				"This is my birthday party.");
		
		assertEquals("\t1/15/2018 at 12:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());

		appt.setStartHour(11);
		assertEquals("\t1/15/2018 at 11:30am ,Birthday Party, This is my birthday party.\n", appt.toString());

		// Set hour out of bounds so that configuration is invalid
		appt.setStartHour(24);

		assertEquals(null, appt.toString());
	 }

	// Test toString
	@Test
	public void test06()  throws Throwable  {
	   //Construct a new Appointment object with the initial data	 
	   Appt appt = new Appt(11,
			   30 ,
			   15 ,
			   01 ,
			   2018 ,
			   "Birthday Party",
			   "This is my birthday party.");

		Appt appt1 = new Appt(12,
			   30 ,
			   15 ,
			   01 ,
			   2018 ,
			   "Birthday Party",
			   "This is my birthday party.");
		
		assertEquals(-1, appt.compareTo(appt1));

		appt.setStartHour(13);
		assertEquals(1, appt.compareTo(appt1));
		
		appt.setStartMinute(31);
		assertEquals(2, appt.compareTo(appt1));

		appt.setStartDay(16);
		assertEquals(3, appt.compareTo(appt1));

		appt.setStartMonth(02);
		assertEquals(4, appt.compareTo(appt1));

		appt.setStartYear(2019);
		assertEquals(5, appt.compareTo(appt1));

	}
	
}
