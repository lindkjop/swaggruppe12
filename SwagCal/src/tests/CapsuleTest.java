package tests;

import static org.junit.Assert.*;

import model.Person;
import net.Capsule;

import org.junit.Test;

import tools.Stringify;

import com.google.gson.Gson;

import db.DatabaseFactory;

public class CapsuleTest {

	@Test
	public void test() {
		Person p = new Person("Fruitcake", 212394, "Andøl", "Andøl");
		Capsule c = new Capsule("DATABASE", "UPDATE", "Person", true);
		c.setCondition("PersonID = 46");
		c.setValues(p.getArguments());
		Gson g = new Gson();
		String fizzle = g.toJson(c);
		System.out.println(fizzle);
		DatabaseFactory df = new DatabaseFactory(fizzle);
		
	}

}
