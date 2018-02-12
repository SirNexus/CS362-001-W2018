package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {

		CalDay calendarDay = new CalDay();
		assertEquals(false, calendarDay.valid);

		GregorianCalendar today = new GregorianCalendar(2018, 1, 28);
		calendarDay = new CalDay(today);

		assertEquals(28, calendarDay.getDay());
		assertEquals(1, calendarDay.getMonth());
		assertEquals(2018, calendarDay.getYear());

		assertEquals(0, calendarDay.getSizeAppts());

		Appt appt = new Appt(9, 30, 28, 1, 2018, "Birthday Party", "This is my birthday party.");

		calendarDay.addAppt(appt);

		LinkedList<Appt> apptArr = new LinkedList<Appt>();
		apptArr.push(appt);

		assertEquals(apptArr, calendarDay.getAppts());

		// Can't access second if statement in setAppts!!!
	 }

	 @Test
	  public void test02()  throws Throwable  {

		GregorianCalendar today = new GregorianCalendar(2018, 1, 28);
		CalDay calendarDay = new CalDay(today);

		Appt appt1 = new Appt(25, 30, 28, 1, 2018, "Birthday Party", "This is my birthday party.");
		calendarDay.addAppt(appt1);

		assertEquals("\t --- 1/28/2018 --- \n --- -------- Appointments ------------ --- \n\n",
		calendarDay.toString());

		Appt appt2 = new Appt(9, 30, 28, 1, 2018, "Birthday Party", "This is my birthday party.");
		calendarDay.addAppt(appt2);

		assertEquals("\t --- 1/28/2018 --- \n --- -------- Appointments ------------ --- \n" + 
		"\t1/28/2018 at 9:30am ,Birthday Party, This is my birthday party.\n \n",
		calendarDay.toString());

		Appt appt3 = new Appt(21, 30, 28, 1, 2018, "Birthday Party", "This is my birthday party.");
		calendarDay.addAppt(appt3);

		assertEquals("\t --- 1/28/2018 --- \n --- -------- Appointments ------------ --- \n" + 
		"\t1/28/2018 at 9:30am ,Birthday Party, This is my birthday party.\n " +
		"\t1/28/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n \n",
		calendarDay.toString());

		Appt appt4 = new Appt(10, 30, 28, 1, 2018, "Birthday Party", "This is my birthday party.");
		calendarDay.addAppt(appt4);

		assertEquals("\t --- 1/28/2018 --- \n --- -------- Appointments ------------ --- \n" + 
		"\t1/28/2018 at 9:30am ,Birthday Party, This is my birthday party.\n " +
		"\t1/28/2018 at 10:30am ,Birthday Party, This is my birthday party.\n " +
		"\t1/28/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n \n",
		calendarDay.toString());

		assertEquals(true, calendarDay.iterator().hasNext());
	 }

	 @Test
	  public void test03()  throws Throwable  {

		CalDay calendarDay = new CalDay();
		assertEquals(null, calendarDay.iterator());

		assertEquals("", calendarDay.toString());
		
	 }
//add more unit tests as you needed	
}
