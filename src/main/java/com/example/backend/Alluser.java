package com.example.backend;

public class Alluser {
	
	String username;
	String name;
	String email;
	String password;
	String image;
	String role;
	
	public Alluser() {
		super();
	}

	
	
	public Alluser(String username, String name, String email, String password, String image,
			String role) {
		super();
		this.username = username;
		this.name = name;
		this.email = email;
		this.password = password;
		this.image = image;
		this.role = role;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
	
	
	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "Alluser [username=" + username + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", getUsername()=" + getUsername() + ", getname()="
				+ getname() + ", getemail()=" + getemail() + ", getpassword()="
				+ getpassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	
}
