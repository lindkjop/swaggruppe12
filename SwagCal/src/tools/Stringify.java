package tools;

public class Stringify {
	
	// Et veldig enkelt verkt�y som ikke gj�r annet enn � returnere Streng s med ' ' rundt. Eks:  "Test" -> "'Test'" 
	
	
	public static String makeString(String s) {
		
		s = "'" + s + "'";
		
		return s;
		
	}
} 

