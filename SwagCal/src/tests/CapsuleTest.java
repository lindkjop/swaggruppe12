package tests;

import static org.junit.Assert.*;

import model.Person;
import net.Capsule;

import org.junit.Test;

import com.google.gson.Gson;

import db.DatabaseFactory;

public class CapsuleTest {

	@Test
	public void test() {
		Person p = new Person(4, "Daniel", 842984, "danielso", "Tulling!" );
		Capsule c = new Capsule("DATABASE", "INSERT", "Person", true);
		c.setSendObject(p);
		
		Gson g = new Gson();
		String fizzle = g.toJson(c);
		
		DatabaseFactory df = new DatabaseFactory(fizzle);
		System.out.println(df);
		df.extractArgumentsFromObject();
		
		
	}

}
