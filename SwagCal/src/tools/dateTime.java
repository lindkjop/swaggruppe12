package tools;

import java.io.IOError;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class dateTime {
	private Calendar pointInTime;
	private Calendar endPoint;
	private boolean isTimeDelta;
	
	
	//Konstrukt�rer
	public dateTime(){
		this.pointInTime = dateTime.now().getCalendarObj();
	}
	
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
	
	//Mulighet for � sette et sluttpunkt utenfor konstrukt�ren
	public void setEnd(dateTime end){
		this.endPoint = end.getCalendarObj();
	}
	
	
	//Funksjoner til endring av den underliggende objekttypen
	private Calendar getCalendarObj(){
		return pointInTime;
	}
	
	private void setCalendarObj(Calendar c){
		this.pointInTime = c;
	}
	
	
	//Finn n�tid
	public static dateTime now(){
		return new dateTime(Calendar.getInstance());
	}
	
	//Sjekke om dette er et intervall
	public boolean isInterval(){
		return isTimeDelta;
	}
	
	
	//Hente slutt punktet p� en periode
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
