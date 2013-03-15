package tools;

import java.io.IOError;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


/*
 * SWAGCODER TIB MADE THIS SHEEiT. 
 * 
 * #YOLO_JUSTIN_IS_A_HOMO
 * 
 */
public class dateTime {
	private Calendar pointInTime;
	private Calendar endPoint;
	private boolean isTimeDelta;
	
	
	//Konstruktører
	public dateTime(){
		this.pointInTime = dateTime.now().getCalendarObj();
		this.endPoint = dateTime.now().getCalendarObj();
	}
	
	public dateTime(Calendar c){
		this.pointInTime = c;
		this.endPoint = c;
	}
	
	public dateTime(int secOfMinute, int minOfHour, int hourOfDay ,int dayOfMonth, int monthOfYear, int year){
		this.getCalendarObj().set(Calendar.SECOND, secOfMinute);
		this.getCalendarObj().set(Calendar.MINUTE, minOfHour);
		this.getCalendarObj().set(Calendar.HOUR_OF_DAY, hourOfDay);
		this.getCalendarObj().set(Calendar.DATE, dayOfMonth);
		this.getCalendarObj().set(Calendar.MONTH, monthOfYear);
		this.getCalendarObj().set(Calendar.YEAR, year);
		this.endPoint = this.pointInTime;
		isTimeDelta = false;
	}
	
	public dateTime(dateTime start, dateTime end){
		this.endPoint = end.getCalendarObj();
		this.pointInTime = start.getCalendarObj();
		isTimeDelta = true;
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
	
	
	//Hente/sette sluttpunktet på en periode
	public void setEnd(dateTime end){
		this.endPoint = end.getCalendarObj();
	}
	
	public dateTime getEnd(){
		dateTime result = new dateTime();
		if(this.isInterval()){
			result = new dateTime(this.endPoint);
			}
		return result;
	}
	
	//Hente en periodelengde
	public dateTime getDelta(){
		dateTime result = new dateTime(this.getEnd().getCalendarObj());
		result.getCalendarObj().add(Calendar.DATE, -this.getCalendarObj().get(Calendar.DATE));
		result.getCalendarObj().add(Calendar.MONTH, -this.getCalendarObj().get(Calendar.MONTH));
		result.getCalendarObj().add(Calendar.YEAR, -this.getCalendarObj().get(Calendar.YEAR));
		result.getCalendarObj().add(Calendar.MINUTE, -this.getCalendarObj().get(Calendar.MINUTE));
		result.getCalendarObj().add(Calendar.HOUR_OF_DAY, -this.getCalendarObj().get(Calendar.HOUR_OF_DAY));
		return result;
	}
	
	
	//Hente/sette enkelt-ting.
	
	public void setTime(int ssmmhh){
		String input = String.valueOf(ssmmhh);
		this.setSec(Integer.parseInt(input.substring(0, 2)));
		this.setMin(Integer.parseInt(input.substring(2, 4)));
		this.setHour(Integer.parseInt(input.substring(4)));
	}
	public void setDate(int ddmmyyyy){
		String input = String.valueOf(ddmmyyyy);
		this.setDay(Integer.parseInt(input.substring(0, 2)));
		this.setMonth(Integer.parseInt(input.substring(2, 4)));
		this.setYear(Integer.parseInt(input.substring(4)));
	}
	
	
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
		this.getCalendarObj().set(Calendar.HOUR_OF_DAY, hour);
	}
	public int getHour(){
		return this.getCalendarObj().get(Calendar.HOUR_OF_DAY);
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
		boolean startsBefore = compareToDelta.getCalendarObj().before(this.getEnd().getCalendarObj());
		
		//Sjekker om compareTo slutter før this starter
		boolean endsAfter = compareToDelta.getEnd().getCalendarObj().after(this.getCalendarObj());
		
		return startsBefore && endsAfter;
	}
	
	public boolean isSimultaneousWith(dateTime compareTo){
		return this.getCalendarObj().equals(compareTo.getCalendarObj());
	}
	
	public boolean isBefore(dateTime dt){
		return this.getCalendarObj().before(dt.getCalendarObj());
	}
	public boolean isAfter(dateTime dt){
		return this.getCalendarObj().after(dt.getCalendarObj());
	}
	public boolean hasPassed(){
		return this.getCalendarObj().before(dateTime.now());
	}
}
