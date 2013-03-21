package tools;

public class Stringify {
	
	// Et veldig enkelt verktøy som ikke gjør annet enn å returnere Streng s med ' ' rundt. Eks:  "Test" -> "'Test'" 
	
	
	public static String makeString(String s) {
		
		s = "'" + s + "'";
		
		return s;
		
	}
} 

