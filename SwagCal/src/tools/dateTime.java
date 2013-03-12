package tools;

import java.io.IOError;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


/*
 * SWAGCODER TIB MADE THIS SHIT.
 * 
 * #YOLO
 */
public class dateTime {
	private Calendar pointInTime;
	private Calendar endPoint;
	private boolean isTimeDelta;
	
	
	//Konstruktører
	public dateTime(){
		this.pointInTime = dateTime.now().getCalendarObj();
	}
	
	public dateTime(Calendar c){
		this.pointInTime = c;
	}
	
	public dateTime(int secOfMinute, int minOfHour, int hourOfDay ,int dayOfMonth, int monthOfYear, int year){
		this.getCalendarObj().set(Calendar.SECOND, secOfMinute);
		this.getCalendarObj().set(Calendar.MINUTE, minOfHour);
		this.getCalendarObj().set(Calendar.HOUR, hourOfDay);
		this.getCalendarObj().set(Calendar.DATE, dayOfMonth);
		this.getCalendarObj().set(Calendar.MONTH, monthOfYear);
		this.getCalendarObj().set(Calendar.YEAR, year);
		isTimeDelta = false;
	}
	
	public dateTime(dateTime start, dateTime end){
		this.endPoint = end.getCalendarObj();
		this.pointInTime = start.getCalendarObj();
		isTimeDelta = true;
	}
	
	//Mulighet for å sette et sluttpunkt utenfor konstruktøren
	public void setEnd(dateTime end){
		this.endPoint = end.getCalendarObj();
	}
	
	
	//Funksjoner til endring av den underliggende objekttypen
	public Calendar getCalendarObj(){
		if (pointInTime == null){
			pointInTime = Calendar.getInstance();
		}
		return pointInTime;
	}
	
	
	//Finn nåtid
	public static dateTime now(){
		return new dateTime(Calendar.getInstance());
	}
	
	//Sjekke om dette er et intervall
	public boolean isInterval(){
		return isTimeDelta;
	}
	
	
	//Hente slutt punktet på en periode
	public dateTime getDeltaEnd(){
		dateTime result = new dateTime();
		if(this.isInterval()){
			result = new dateTime(this.endPoint);
			}
		return result;
	}
	
	//Hente en periodelengde
	public dateTime getDelta(){
		dateTime result = new dateTime(this.getDeltaEnd().getCalendarObj());
		result.getCalendarObj().add(Calendar.DATE, -this.getCalendarObj().get(Calendar.DATE));
		result.getCalendarObj().add(Calendar.MONTH, -this.getCalendarObj().get(Calendar.MONTH));
		result.getCalendarObj().add(Calendar.YEAR, -this.getCalendarObj().get(Calendar.YEAR));
		result.getCalendarObj().add(Calendar.MINUTE, -this.getCalendarObj().get(Calendar.MINUTE));
		result.getCalendarObj().add(Calendar.HOUR, -this.getCalendarObj().get(Calendar.HOUR));
		return result;
	}
	
	
	//Hente/sette enkeltdata.
	
	public void setSec(int sec){
		this.getCalendarObj().set(Calendar.SECOND, sec);
	}
	public int getSec(){
		return this.getCalendarObj().get(Calendar.SECOND);
	}
	
	public void setMin(int min){
		this.getCalendarObj().set(Calendar.MINUTE, min);
	}
	public int getMin(){
		return this.getCalendarObj().get(Calendar.MINUTE);
	}
	
	public void setHour(int hour){
		this.getCalendarObj().set(Calendar.HOUR, hour);
	}
	public int getHour(){
		return this.getCalendarObj().get(Calendar.HOUR);
	}
	
	public void setDay(int day){
		this.getCalendarObj().set(Calendar.DATE, day);
	}
	public int getDay(){
		return this.getCalendarObj().get(Calendar.DATE);
	}
	
	public void setMonth(int month){
		this.getCalendarObj().set(Calendar.MONTH, month);
	}
	public int getMonth(){
		return this.getCalendarObj().get(Calendar.MONTH);
	}
	
	public void setYear(int year){
		this.getCalendarObj().set(Calendar.YEAR, year);
	}
	public int getYear(){
		return this.getCalendarObj().get(Calendar.YEAR);
	}

	
	//Sammenligning
	public boolean intersects(dateTime compareToDelta){
		//Sjekker om compareTo starter før this slutter
		int temp1 = compareToDelta.getCalendarObj().compareTo(this.getDeltaEnd().getCalendarObj());
		System.out.println(temp1);
		
		//Sjekker om compareTo slutter før this starter
		int temp2 = compareToDelta.getDeltaEnd().getCalendarObj().compareTo(this.getCalendarObj());
		System.out.println(temp2);
		
		return temp1<0 && temp2>0;
	}
	
	public boolean isSimultanius(dateTime compareTo, boolean ingnoreSeconds){
		if(ingnoreSeconds){
			dateTime temp1 = new dateTime(this.getCalendarObj());
			dateTime temp2 = new dateTime(compareTo.getCalendarObj());
			temp1.setSec(0);
			temp2.setSec(0);
			return temp1.getCalendarObj().equals(temp2.getCalendarObj());
		}
		return this.getCalendarObj().equals(compareTo.getCalendarObj());
		
	}
}
