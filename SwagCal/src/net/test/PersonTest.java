package net.test;

import java.util.ArrayList;

public class PersonTest {

	String name;
	ArrayList<PersonTest> friends;
	
	public PersonTest(String name) {
		this.name = name;
		this.friends = new ArrayList<PersonTest>();
		
	}
	
	public void addFriend(PersonTest p) {
		friends.add(p);
	}
	
}
