package tools;

import java.io.IOError;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class dateTime {
	private Calendar pointInTime;
	private Calendar endPoint;
	private boolean isTimeDelta;
	
	
	//Konstruktører
	public dateTime(Calendar c){
		this.pointInTime = c;
	}
	
	public dateTime(int minOfHour, int hourOfDay ,int dayOfMonth, int monthOfYear, int year){
		pointInTime.set(year, monthOfYear, dayOfMonth, hourOfDay, minOfHour);
		isTimeDelta = false;
	}
	
	public dateTime(dateTime start, dateTime end){
		this.endPoint = end.getCalendarObj();
		this.pointInTime = start.getCalendarObj();
		isTimeDelta = true;
	}
	
	
	//Funksjoner til endring av den underliggende objekttypen
	private Calendar getCalendarObj(){
		return pointInTime;
	}
	
	private void setCalendarObj(Calendar c){
		this.pointInTime = c;
	}
	
	
	//Finn nåtid
	public dateTime now(){
		return new dateTime(Calendar.getInstance());
	}
	
	//Sjekke om dette er et intervall
	public boolean isInterval(){
		return isTimeDelta;
	}
	
	
	//Hente slutt punktet på en periode
	public dateTime getDeltaEnd(){
		dateTime result = new dateTime(this.pointInTime);
		if(this.isInterval()){
			result = new dateTime(this.endPoint);
			}
		return result;
	}
	
	
	//Data til kjente variabeltyper.
	public int getSec(){
		return pointInTime.get(Calendar.SECOND);
	}
	public int getMin(){
		return pointInTime.get(Calendar.MINUTE);
	}
	public int getHour(){
		return pointInTime.get(Calendar.HOUR);
	}
	public int getDay(){
		return pointInTime.get(Calendar.DATE);
	}
	public int getMonth(){
		return pointInTime.get(Calendar.MONTH);
	}
	public int getYear(){
		return pointInTime.get(Calendar.YEAR);
	}
	
	
//	//Sammenligning
//	public boolean intersects(dateTime compareToDelta){
//		if(compareToDelta.isInterval()){
//			int result = this.getDeltaEnd().getCalendarObj().compareTo(compareToDelta.getCalendarObj());
//			if(result == 0 && result)
//		}
//		else if(this.isInterval()){
//			
//		}
//		else return false;
//	}
//	
//	public boolean isSimultanius(dateTime compareTo){
//		
//	}
}
