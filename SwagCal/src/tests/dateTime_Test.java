package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.joda.time.Interval;
import org.junit.Test;

import tools.dateTime;

public class dateTime_Test {

	@Test
	public void test() {
		testDateTime();
	}

	private void testDateTime(){
		dateTime temp1= new dateTime("002018","12032013");
		dateTime temp2 = new dateTime("302019","12032013");
		assertFalse(temp1.isSimultaneousWith(temp2));

		dateTime point11 = new dateTime("002018","12032013");
		dateTime point12 = new dateTime("002918","12032013");

		dateTime point21 = new dateTime("003018","12032013");
		dateTime point22 = new dateTime("004018","12032013");

		dateTime point31 = new dateTime("002518","12032013");
		dateTime point32 = new dateTime("003518","12032013");

		assertFalse(point11.isAfter(point12));
		assertTrue(point11.isBefore(point12));

		Interval intrv1 = dateTime.interval(point11,point12);
		Interval intrv2 = dateTime.interval(point21,point22);
		Interval intrv3 = dateTime.interval(point31,point32);

		assertFalse(dateTime.intersects(intrv1,intrv2));
		assertTrue(dateTime.intersects(intrv2,intrv3));
		assertTrue(dateTime.intersects(intrv2,intrv3));
		
		assertEquals(point11.getTime(),"002018");
		assertEquals(point11.getDate(),"12032013");
	}
	
}
