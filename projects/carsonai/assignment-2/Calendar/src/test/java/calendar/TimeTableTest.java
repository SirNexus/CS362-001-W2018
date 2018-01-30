package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 28);
		GregorianCalendar nextMonth = new GregorianCalendar(2018, 2, 28);
		
		LinkedList<Appt> listAppts = new LinkedList<Appt>();

		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		TimeTable timeTable=new TimeTable();

		calDays = timeTable.getApptRange(listAppts, today, nextMonth);
		assertEquals("\t --- 1/28/2018 --- \n --- -------- Appointments ------------ --- \n\n", calDays.get(0).toString());

		Appt appt = new Appt(9, 30, 1, 2, 2018, "Birthday Party", "This is my birthday party.");
		int []intArr = {0,3};
		appt.setRecurrence(intArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt);
		calDays = timeTable.getApptRange(listAppts, today, nextMonth);

		assertEquals("\t --- 2/1/2018 --- \n --- -------- Appointments ------------ --- \n" +
			"\t2/1/2018 at 9:30am ,Birthday Party, This is my birthday party.\n \n", 
			calDays.get(1).toString());

	 }

	 @Test
	 public void test02()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 28);
		GregorianCalendar nextMonth = new GregorianCalendar(2018, 2, 28);
		
		LinkedList<Appt> listAppts = new LinkedList<Appt>();

		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		TimeTable timeTable=new TimeTable();

		Appt appt = new Appt(9, 30, 1, 2, 2018, "Birthday Party", "This is my birthday party.");
		int []intArr = {0,3};
		appt.setRecurrence(intArr, Appt.RECUR_BY_MONTHLY, 1, 4);
		listAppts.add(appt);
		calDays = timeTable.getApptRange(listAppts, today, nextMonth);

		assertEquals("\t --- 2/1/2018 --- \n --- -------- Appointments ------------ --- \n" +
			"\t2/1/2018 at 9:30am ,Birthday Party, This is my birthday party.\n \n", 
			calDays.get(1).toString());

	 }

	 @Test
	 public void test03()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 28);
		GregorianCalendar nextMonth = new GregorianCalendar(2018, 2, 28);
		
		LinkedList<Appt> listAppts = new LinkedList<Appt>();

		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		TimeTable timeTable=new TimeTable();

		Appt appt = new Appt(9, 30, 1, 2, 2018, "Birthday Party", "This is my birthday party.");
		int []intArr = {0,3};
		appt.setRecurrence(intArr, Appt.RECUR_BY_YEARLY, 1, 4);
		listAppts.add(appt);
		calDays = timeTable.getApptRange(listAppts, today, nextMonth);

		assertEquals("\t --- 2/1/2018 --- \n --- -------- Appointments ------------ --- \n" +
			"\t2/1/2018 at 9:30am ,Birthday Party, This is my birthday party.\n \n", 
			calDays.get(1).toString());

	 }

	 @Test
	 public void test04()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 28);
		GregorianCalendar nextMonth = new GregorianCalendar(2018, 2, 28);
		
		LinkedList<Appt> listAppts = new LinkedList<Appt>();

		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		TimeTable timeTable=new TimeTable();

		Appt appt = new Appt(25, 30, 1, 2, 2018, "Birthday Party", "This is my birthday party.");
		listAppts.add(appt);

		calDays = timeTable.getApptRange(listAppts, today, nextMonth);

		assertEquals("\t --- 1/28/2018 --- \n --- -------- Appointments ------------ --- \n\n", calDays.get(0).toString());
	 }

	 @Test
	 public void test05()  throws Throwable  {

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		TimeTable timeTable=new TimeTable();

		Appt appt = new Appt(9, 30, 1, 2, 2018, "Birthday Party", "This is my birthday party.");

		appt.setStartHour(9);
		listAppts.add(appt);
		Appt appt1 = new Appt(10, 30, 1, 2, 2018, "Birthday Party", "This is my birthday party.");
		listAppts.add(appt1);
		Appt appt2 = new Appt(11, 30, 1, 2, 2018, "Birthday Party", "This is my birthday party.");
		listAppts.add(appt2);
		listAppts = timeTable.deleteAppt(listAppts, appt1);
		assertEquals("\t2/1/2018 at 9:30am ,Birthday Party, This is my birthday party.\n", listAppts.get(0).toString());

		listAppts = null;
		listAppts = timeTable.deleteAppt(listAppts, appt);

		listAppts = new LinkedList<Appt>();
		appt.setStartHour(25);
		listAppts.add(appt);
		listAppts = timeTable.deleteAppt(listAppts, appt);
		assertEquals(null, listAppts);

		appt = null;
		listAppts = new LinkedList<Appt>();
		listAppts.add(appt);
		listAppts = timeTable.deleteAppt(listAppts, appt);
		assertEquals(null, listAppts);


	}

	@Test
	 public void test06()  throws Throwable  {
		
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		TimeTable timeTable=new TimeTable();

		Appt appt1 = new Appt(9, 30, 1, 2, 2018, "Birthday Party", "This is my birthday party.");
		listAppts.add(appt1);

		Appt appt2 = new Appt(10, 30, 1, 2, 2018, "Birthday Party", "This is my birthday party.");
		listAppts.add(appt2);

		Appt appt3 = new Appt(11, 30, 1, 2, 2018, "Birthday Party", "This is my birthday party.");
		listAppts.add(appt3);

		int[] pv = {0,1,2};
		listAppts = timeTable.permute(listAppts, pv);

		assertEquals(appt1.toString(), listAppts.get(0).toString());

	}
	 @Test(expected = DateOutOfRangeException.class)
	  public void test07()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 28);
		GregorianCalendar nextMonth = new GregorianCalendar(2018, 2, 28);
		
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		TimeTable timeTable=new TimeTable();

		Appt appt1 = new Appt(9, 30, 1, 2, 2018, "Birthday Party", "This is my birthday party.");
		listAppts.add(appt1);

		timeTable.getApptRange(listAppts, nextMonth, today);
	 }
	 @Test(expected = IllegalArgumentException.class)
	  public void test08()  throws Throwable  {

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		TimeTable timeTable=new TimeTable();

		Appt appt1 = new Appt(9, 30, 1, 2, 2018, "Birthday Party", "This is my birthday party.");
		listAppts.add(appt1);

		int[] pv = {0,1,2};
		listAppts = timeTable.permute(listAppts, pv);
	 }
//add more unit tests as you needed
}
