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
	//
    // String format below will add leading zeros (the %0 syntax) 
    // to the number above. The length of the formatted string will 
    // be 7 characters.
    //
    String formatted; 
	
	
	//Konstruktører
	public dateTime(){
		this.pointInTime = dateTime.now().getCalendarObj();
		
	}
	
	public dateTime(Calendar c){
		this.pointInTime = c;
	}

	public dateTime(String ssmmhhddmmyyyy){
		new dateTime(ssmmhhddmmyyyy.substring(0,6),ssmmhhddmmyyyy.substring(6));
	}
	
	public dateTime(String ssmmhh,String ddmmyyyy){
		this.pointInTime = new dateTime().getCalendarObj();
		this.pointInTime.set(Calendar.SECOND, Integer.parseInt(ssmmhh.substring(0, 2)));
		this.pointInTime.set(Calendar.MINUTE, Integer.parseInt(ssmmhh.substring(2, 4)));
		this.pointInTime.set(Calendar.HOUR_OF_DAY,  Integer.parseInt(ssmmhh.substring(4)));
		this.pointInTime.set(Calendar.DATE, Integer.parseInt(ddmmyyyy.substring(0,2)));
		this.pointInTime.set(Calendar.MONTH, Integer.parseInt(ddmmyyyy.substring(2,4)));
		this.pointInTime.set(Calendar.YEAR, Integer.parseInt(ddmmyyyy.substring(4)));
		
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
	
	//Legge sammen to tidspunkt
	public dateTime add(dateTime duration){
		dateTime result = new dateTime(duration.getCalendarObj());
		result.getCalendarObj().add(Calendar.DATE, this.getCalendarObj().get(Calendar.DATE));
		result.getCalendarObj().add(Calendar.MONTH, this.getCalendarObj().get(Calendar.MONTH));
		result.getCalendarObj().add(Calendar.YEAR, this.getCalendarObj().get(Calendar.YEAR));
		result.getCalendarObj().add(Calendar.SECOND, this.getCalendarObj().get(Calendar.SECOND));
		result.getCalendarObj().add(Calendar.MINUTE, this.getCalendarObj().get(Calendar.MINUTE));
		result.getCalendarObj().add(Calendar.HOUR_OF_DAY, this.getCalendarObj().get(Calendar.HOUR_OF_DAY));
		return result;
	}
	
	
	//Hente en periodelengde
	public dateTime getDuration(dateTime til){
		dateTime result = new dateTime(til.getCalendarObj());
		result.getCalendarObj().add(Calendar.DATE, -this.getCalendarObj().get(Calendar.DATE));
		result.getCalendarObj().add(Calendar.MONTH, -this.getCalendarObj().get(Calendar.MONTH));
		result.getCalendarObj().add(Calendar.YEAR, -this.getCalendarObj().get(Calendar.YEAR));
		result.getCalendarObj().add(Calendar.SECOND, -this.getCalendarObj().get(Calendar.SECOND));
		result.getCalendarObj().add(Calendar.MINUTE, -this.getCalendarObj().get(Calendar.MINUTE));
		result.getCalendarObj().add(Calendar.HOUR_OF_DAY, -this.getCalendarObj().get(Calendar.HOUR_OF_DAY));
		return result;
	}
	public static dateTime getDuration(dateTime from, dateTime to){
		return from.getDuration(to);
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
		int sec = pointInTime.get(Calendar.SECOND);
		int min = pointInTime.get(Calendar.MINUTE);
		int hour = pointInTime.get(Calendar.HOUR_OF_DAY);
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
		
		int day = pointInTime.get(Calendar.DATE);
		int month = pointInTime.get(Calendar.MONTH);
		int year = pointInTime.get(Calendar.YEAR);
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
	public boolean intersects(dateTime duration, dateTime compareToStart, dateTime compareToDuration){
		//Sjekker om compareTo starter før this slutter
		boolean startsBefore = compareToStart.getCalendarObj().before(this.add(duration).getCalendarObj());
		
		//Sjekker om compareTo slutter før this starter
		boolean endsAfter = compareToStart.add(compareToDuration).getCalendarObj().after(this.getCalendarObj());
		
		return startsBefore && endsAfter;
	}
	
	public static boolean intersects(dateTime from, dateTime to, dateTime compareFrom, dateTime compareTo){
		return from.intersects(from.getDuration(to), compareFrom, compareTo);
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
