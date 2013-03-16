package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tools.dateTime;

public class dateTime_Test {

	@Test
	public void test() {
		testDateTime();
	}

	private void testDateTime(){
		dateTime temp1= new dateTime(0,20,18,12,03,2013);
		dateTime temp2 = new dateTime(30,20,19,12,03,2013);
		assertFalse(temp1.isSimultaneousWith(temp2));

		dateTime point11 = new dateTime(0,20,18,12,03,2013);
		dateTime point12 = new dateTime(0,30,18,12,03,2013);

		dateTime point21 = new dateTime(0,30,18,12,03,2013);
		dateTime point22 = new dateTime(0,40,18,12,03,2013);

		dateTime point31 = new dateTime(0,25,18,12,03,2013);
		dateTime point32 = new dateTime(0,35,18,12,03,2013);


		assertFalse(point11.isAfter(point12));
		assertTrue(point11.isBefore(point12));


		dateTime interval1 = new dateTime(point11,point12);
		dateTime interval2 = new dateTime(point21,point22);
		dateTime interval3 = new dateTime(point31,point32);

		assertFalse(interval1.intersects(interval2));
		assertTrue(interval1.intersects(interval3));
		assertTrue(interval2.intersects(interval3));
	}
	
}
