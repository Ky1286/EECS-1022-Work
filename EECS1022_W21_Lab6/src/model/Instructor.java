package model;

public class Instructor {

	String name;
	int phoneExtension;
	String email;
	
	public Instructor(String name, int phoneExtension, String email) {
		this.name = name;
		this.phoneExtension = phoneExtension;
		this.email = email;
	}

	public String getName() {
		String result = "";
		
		result = this.name;
		
		return result;
	}

	public int getPhoneExtension() {
		int result = 0;
		
		result = this.phoneExtension;
		
		return result;
	}

	public String getEmail() {
		String result = "";
		
		result = this.email;
		
		return result;
	}

	public String getInformation() {
		String result = "";
		
		result = "Instructor " + this.name + " has campus phone extension " + this.phoneExtension + " and contact email " + this.email;
		
		return result;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneExtension(int phoneExtension) {
		this.phoneExtension = phoneExtension;
	}

	public void setEmail(String email) {
		this.email = email;		
	}

}