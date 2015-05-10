package ie.cit.appdev.domain;

import java.util.UUID;

public class Account {
	
	private String id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	
	public Account(){
		this.id=UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		
		return "User Account is: \nID  : "+this.id+" \nName: "+this.firstname+" "+this.lastname+" "+this.username+" "+this.password;
	}
	
	

}
