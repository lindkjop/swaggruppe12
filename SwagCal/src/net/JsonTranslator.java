package net;

import java.lang.reflect.Type;

import net.test.PersonTest;
import net.test.PersonTestName;

import com.google.gson.Gson;

public class JsonTranslator {

	private Gson gson = new Gson();
	
	
	public String toJson(String classOfObject, Object o) {
		String json = gson.toJson(o);
		return classOfObject + ":" + json;
		
	}
	
	public Object fromJson(String json) {
		if (json.substring(0, 4).equals("PERS")) {
			return (PersonTest)gson.fromJson(json, PersonTest.class);
		}
		gson.fromJson(json.substring(4), translator((String)json.subSequence(0, 4)));
	}
	
	
	
	public Type translator(String className) {
		if (className == "PERSON") {
			return PersonTest.class;
		}
		return null;
	}
}
