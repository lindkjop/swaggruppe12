package net.backup;

import model.Person;

import com.google.gson.Gson;

public class Processor {

	private Gson gson = new Gson();
	
	public String toQuery(Object o, QueryAction qa) {
		String query;
		if (o instanceof Person) {
			Person p = (Person)o;
			if (qa ==  QueryAction.INSERT) {
				query = String.format("INSERT INTO Person VALUES ('',%s,'%s',%s,'%s','%s')", p.getNavn(),p.getPhoneNumber(),p.getUserName(), p.getPassword());
						
		}
			else if(qa == QueryAction.UPDATE) {
				query = String.format("INSERT INTO Person VALUES ('',%s,'%s',%s,'%s','%s')", p.getNavn(),p.getPhoneNumber(),p.getUserName(), p.getPassword());
			}
		}
		
		
		String[] a = o.getClass().getName().split("\\.");
		
		String s = a[a.length-1];
		s += gson.toJson(o);
		return s;
	}
	
	
	
	public static void main (String[] args) {
		Processor pr = new Processor();
		Person p = new Person(10, "per", 12, "per", "pwer");
		Gson g = new Gson();
		System.out.println(pr.toJson(p));
		
	}
}
