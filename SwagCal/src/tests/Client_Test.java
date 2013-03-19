package tests;

import model.Model;
import model.Person;

import org.junit.Test;

import controller.Client;

public class Client_Test {
	Model model;
	
	@Test
	public void test() {
		Person dude = new Person(99, "Tibor", 9999999, "tibor", "kul");
		model = new Model();
		model.addPerson(dude);
		new Client(model);
		new Client(model);
		
	}

}
