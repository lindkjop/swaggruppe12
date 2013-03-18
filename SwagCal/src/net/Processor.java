package net;

import model.Person;

import com.google.gson.Gson;

public class Processor {

	private Gson gson = new Gson();
	
	public String toJson(Object o) {
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
