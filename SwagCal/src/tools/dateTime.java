package tools;

import java.io.IOError;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class dateTime {
	private Calendar pointInTime;
	private dateTime endDelta;
	private boolean timeDelta;
	
	public dateTime(int min, int hourOfDay ,int day, int month, int year){
		pointInTime.set(year, month, day, hourOfDay, min);
		timeDelta = false;
	}
	
	public dateTime(dateTime start, dateTime end){
		this.endDelta = end;
		this.pointInTime = start.getCalendarObj();
		timeDelta = true;
	}
	
	public Calendar getCalendarObj(){
		return pointInTime;
	}
	
	public dateTime now(){
		//Finn nåtid
		return now;
	}
	
	public dateTime getDeltaEnd(){
		if (timePeriod){
			return endDelta;
		}
		else return null;
	}
	
	public boolean intersects(dateTime compareToDelta){
		
	}
	
	public boolean isSimultanius(dateTime compareTo){
		
	}
}
