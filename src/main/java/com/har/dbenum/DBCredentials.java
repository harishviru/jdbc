package com.har.dbenum;

public enum DBCredentials {

	
	URL("jdbc:mysql://localhost : 3306 /demo?rewriteBatchedStatements=true"), 
	USER_NAME("root"), 
	PASSWORD("root");
	
	private String name;

	DBCredentials(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	

}
