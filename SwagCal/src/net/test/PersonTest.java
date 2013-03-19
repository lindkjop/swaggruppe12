package net.test;

import java.util.ArrayList;

public class PersonTest implements randomINt {

	String name;
	ArrayList<PersonTest> friends;
	
	public PersonTest(String name) {
		this.name = name;
		this.friends = new ArrayList<PersonTest>();
		
	}
	
	public void addFriend(PersonTest p) {
		friends.add(p);
	}

	@Override
	public int getNr() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
