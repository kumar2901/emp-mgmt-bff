package com.kumar.fullstack.model;

public enum Role {
	
	REGULAR("regular"),
	ADMIN("admin");
	
	private String role;
	
	Role(String role){
		this.role=role;
	}

	public String getRole() {
		return role;
	}

}
