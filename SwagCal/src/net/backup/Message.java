package net.backup;

public class Message {

	private String className;
	private String query;
	boolean isUpdateMessage;
	
	public Message(String className, String query, boolean isUpdateMessage) {
		this.className = className;
		this.query = query;
		this.isUpdateMessage = isUpdateMessage;
	}

	public String getClassName() {
		return className;
	}

	public String getQuery() {
		return query;
	}
	
	public boolean isUpdateMessage() {
		return isUpdateMessage;
	}

}
