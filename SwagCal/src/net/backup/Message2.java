package net.backup;


public class Message2 {

	String className;
	int id;
	Object object;
	QueryAction queryAction;
	
	public Message2(String className, int id, Object object, QueryAction queryAction) {
		this.className = className;
		this.id = id;
		this.object = object;
		this.queryAction = queryAction;
	}

	public String getClassName() {
		return className;
	}


	public int getId() {
		return id;
	}



	public Object getObject() {
		return object;
	}

	public QueryAction getQueryAction() {
		return queryAction;
	}
		
}
