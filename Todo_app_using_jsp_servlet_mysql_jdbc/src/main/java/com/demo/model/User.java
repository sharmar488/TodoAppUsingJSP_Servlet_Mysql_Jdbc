package com.demo.model;

import java.io.Serializable;

public class User implements Serializable{
	public String Name;
	public String Email;
	public String Password;
	
	public void setName(String name) {
		Name = name;
	}
	public String getName() {
		return Name;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getEmail() {
		return Email;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPassword() {
		return Password;
	}
	
	
}
