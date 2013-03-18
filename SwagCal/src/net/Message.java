package net;

public class Message {

	private String className;
	private String query;
	
	public Message(String className, String query) {
		this.className = className;
		this.query = query;
	}

	public String getClassName() {
		return className;
	}

	public String getQuery() {
		return query;
	}

}
