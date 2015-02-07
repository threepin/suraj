package com.threepin.models;

public class clsNavigation {



	private String Name;
	public clsNavigation(String NavId, String Name, String visible) {
		this.setName(Name);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
