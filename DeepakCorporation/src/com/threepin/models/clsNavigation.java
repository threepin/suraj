package com.threepin.models;

public class clsNavigation {



	private String NavId;
	private String Name;
	private String visible;

	public clsNavigation(String NavId, String Name, String visible) {
		this.NavId=NavId;
		this.setName(Name);
		this.visible=visible;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
