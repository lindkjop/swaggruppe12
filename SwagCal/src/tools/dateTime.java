package tools;

import java.io.IOError;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.Interval;
import org.joda.time.JodaTimePermission;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadWritableDateTime;
import org.junit.experimental.theories.PotentialAssignment;


/*
 * SWAGCODER TIB MADE THIS SHEEiT. 
 * 
 * #YOLO_JUSTIN_IS_A_HOMO
 * 
 */
public class dateTime {
	private MutableDateTime pointInTime;
	
	//Konstruktører
	public dateTime(){
		pointInTime = new MutableDateTime();
		
	}
	
	public dateTime(MutableDateTime dt){
		this.pointInTime = dt;
	}
	
	
	public dateTime(String ssmmhhddmmyyyy){
		new dateTime(ssmmhhddmmyyyy.substring(0,6),ssmmhhddmmyyyy.substring(6));
	}
	
	public dateTime(String ssmmhh,String ddmmyyyy){
		int sec = Integer.parseInt(ssmmhh.substring(0, 2));
		int min = Integer.parseInt(ssmmhh.substring(2, 4));
		int hour = Integer.parseInt(ssmmhh.substring(4));
		int day = Integer.parseInt(ddmmyyyy.substring(0,2));
		int month = Integer.parseInt(ddmmyyyy.substring(2,4));
		int year = Integer.parseInt(ddmmyyyy.substring(4));
		pointInTime = new MutableDateTime();
		pointInTime.setSecondOfMinute(sec);
		pointInTime.setMinuteOfHour(min);
		pointInTime.setHourOfDay(hour);
		pointInTime.setDayOfMonth(day);
		pointInTime.setMonthOfYear(month);
		pointInTime.setYear(year);
		
	}

	
	//Funksjoner til endring av den underliggende objekttypen
	public MutableDateTime getDateTimeObj(){
		return pointInTime;
	}
	
	
	//Finn nåtid
	public static dateTime now(){
		return new dateTime();
	}
	
	
	//Legge sammen to tidspunkt
	public dateTime add(dateTime duration){
		dateTime result = new dateTime().now();
		result.getDateTimeObj().addSeconds(duration.getDateTimeObj().getSecondOfMinute());
		result.getDateTimeObj().addMinutes(duration.getDateTimeObj().getMinuteOfHour());
		result.getDateTimeObj().addHours(duration.getDateTimeObj().getHourOfDay());
		result.getDateTimeObj().addDays(duration.getDateTimeObj().getDayOfMonth());
		result.getDateTimeObj().addMonths(duration.getDateTimeObj().getMonthOfYear());
		result.getDateTimeObj().addYears(duration.getDateTimeObj().getYear());
		return result;
	}
	
	
	//Hente en periodelengde
	public dateTime getDuration(dateTime from, dateTime to){
		MutableDateTime result = to.getDateTimeObj();
		result.addSeconds(-this.getDateTimeObj().getSecondOfMinute());
		result.addMinutes(-this.getDateTimeObj().getMinuteOfHour());
		result.addHours(-this.getDateTimeObj().getHourOfDay());
		result.addDays(-this.getDateTimeObj().getDayOfMonth());
		result.addMonths(-this.getDateTimeObj().getMonthOfYear());
		result.addYears(-this.getDateTimeObj().getYear());
		return new dateTime(result);
	}
	
	public dateTime getDuration(dateTime to){
		return new dateTime(this.getDuration(this, to).getDateTimeObj());
	}
	
	
	//Hente/sette enkelt-ting.
	
	public void setTime(String ssmmhh){
		this.setSec(Integer.parseInt(ssmmhh.substring(0, 2)));
		this.setMin(Integer.parseInt(ssmmhh.substring(2, 4)));
		this.setHour(Integer.parseInt(ssmmhh.substring(4)));
	}
	public void setDate(String ddmmyyyy){
		this.setDay(Integer.parseInt(ddmmyyyy.substring(0, 2)));
		this.setMonth(Integer.parseInt(ddmmyyyy.substring(2, 4)));
		this.setYear(Integer.parseInt(ddmmyyyy.substring(4)));
	}
	public String getTime(){
		int sec = pointInTime.getSecondOfMinute();
		int min = pointInTime.getMinuteOfHour();
		int hour = pointInTime.getHourOfDay();
		String sSec;
		if(sec<10){
			sSec = "0"+ String.valueOf(sec);
		}else{
			sSec = String.valueOf(sec);
		}
		
		String sMin;
		if(min<10){
			sMin = "0"+ String.valueOf(min);
		}else{
			sMin = String.valueOf(min);
		}
		
		String sHour;
		if(hour<10){
			sHour = "0"+ String.valueOf(hour);
		}else{
			sHour = String.valueOf(hour);
		}
		
		
		String result = sSec;
		result += sMin;
		result += sHour;
		return result;
	}
	
	public String getDate(){
		
		int day = pointInTime.getDayOfMonth();
		int month = pointInTime.getMonthOfYear();
		int year = pointInTime.getYear();
		String sDay;
		if(day<10){
			sDay = "0"+ String.valueOf(day);
		}else{
			sDay = String.valueOf(day);
		}
		
		String sMonth;
		if(month<10){
			sMonth = "0"+ String.valueOf(month);
		}else{
			sMonth = String.valueOf(month);
		}
		
		String result = sDay;
		result += sMonth;
		result += year;
		return result;
	}
	
	public String getDateFormatedForWeekView(){
		String a = this.getDate();
		return a.substring(0,2)+"."+a.substring(2,4)+"."+a.substring(4);
		
	}
	
	
	public void setWeek(int weeknumber){
		this.getDateTimeObj().setWeekyear(weeknumber);
	}
	
	public void setWeekDay(int weekday){
		this.getDateTimeObj().setDayOfWeek(weekday);
	}
	
	public void setSec(int sec){
		this.getDateTimeObj().setSecondOfMinute(sec);
	}
	public int getSec(){
		return this.getDateTimeObj().getSecondOfMinute();
	}
	
	public void setMin(int min){
		this.getDateTimeObj().setMinuteOfHour(min);
	}
	public int getMin(){
		return this.getDateTimeObj().getMinuteOfHour();
	}
	
	public void setHour(int hour){
		this.getDateTimeObj().setHourOfDay(hour);
	}
	public int getHour(){
		return this.getDateTimeObj().getHourOfDay();
	}
	
	public void setDay(int day){
		this.getDateTimeObj().setDayOfMonth(day);
	}
	public int getDay(){
		return this.getDateTimeObj().getDayOfMonth();
	}
	
	public void setMonth(int month){
		this.getDateTimeObj().setMonthOfYear(month);
	}
	public int getMonth(){
		return this.getDateTimeObj().getMonthOfYear();
	}
	
	public void setYear(int year){
		this.getDateTimeObj().setYear(year);
	}
	public int getYear(){
		return this.getDateTimeObj().getYear();
	}

	
	//Sammenligning
	public static Interval interval(dateTime from, dateTime to){
		return new Interval(from.getDateTimeObj(),to.getDateTimeObj());
	}
	
	public static boolean intersects(Interval interval, Interval otherInterval){
		return interval.overlaps(otherInterval);
	}
	
	public boolean isSimultaneousWith(dateTime compareTo){
		return this.getDateTimeObj().equals(compareTo.getDateTimeObj());
	}
	
	public boolean isBefore(dateTime dt){
		return this.getDateTimeObj().isBefore(dt.getDateTimeObj());
	}
	public boolean isAfter(dateTime dt){
		return this.getDateTimeObj().isAfter(dt.getDateTimeObj());
	}
	public boolean hasPassed(){
		return this.getDateTimeObj().isBefore(dateTime.now().getDateTimeObj());
	}
}
