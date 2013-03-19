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
		dateTime temp1= new dateTime("002018","12032013");
		dateTime temp2 = new dateTime("302019","12032013");
		assertFalse(temp1.isSimultaneousWith(temp2));

		dateTime point11 = new dateTime("002018","12032013");
		dateTime point12 = new dateTime("003018","12032013");

		dateTime point21 = new dateTime("003018","12032013");
		dateTime point22 = new dateTime("004018","12032013");

		dateTime point31 = new dateTime("002518","12032013");
		dateTime point32 = new dateTime("003518","12032013");

		assertFalse(point11.isAfter(point12));
		assertTrue(point11.isBefore(point12));

		assertFalse(dateTime.intersects(point11,point12,point21,point22));
		assertTrue(dateTime.intersects(point11,point12,point31,point32));
		assertTrue(dateTime.intersects(point21,point22,point31,point32));
		assertTrue(point11.getTime().equals("002018"));
		assertTrue(point11.getDate().equals("12032013"));
	}
	
}
