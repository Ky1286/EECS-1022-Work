package model;

public class Participant {

	String name;
	Registration[] registrations = new Registration[0];
	
	public Participant(String string) {
		this.name = string;
	}

	public Registration[] getRegistrations() {
		// TODO Auto-generated method stub
		return registrations;
	}

	public void increaseRegistrations() {
		Registration[] temp = new Registration[this.registrations.length + 1];
		for (int i = 0; i < this.registrations.length; i++) {
			temp[i] = this.registrations[i];
		}
		this.registrations = temp;
	}
	
	public String getGPAReport() {
		String result = "";
		String temp = "{";
		double num = 0;
		if (this.registrations.length == 0) {
			result = "No GPA available yet for " + this.name;			
		} else if (registrations[0] != null) {
			for (int i = 0; i < this.registrations.length; i++) {
				if (registrations[i].getGradeReport()[0].equals("F")) {
					temp += "0 (F)";
					num += 0;
				} else if (registrations[i].getGradeReport()[0].equals("D")) {
					temp += "5 (D)";
					num += 5;
				} else if (registrations[i].getGradeReport()[0].equals("C")) {
					temp += "6 (C)";
					num += 6;
				} else if (registrations[i].getGradeReport()[0].equals("B")) {
					temp += "7 (B)";
					num += 7;
				} else if (registrations[i].getGradeReport()[0].equals("A")) {
					temp += "8 (A)";
					num += 8;
				} else if (registrations[i].getGradeReport()[0].equals("A+")) {
					temp += "9 (A+)";
					num += 9;
				}
				if (i < this.registrations.length - 1) {
					temp += ", ";
				}
			}
			temp += "}";
			result = this.name + "'s GPA of " + temp + ": " + String.format("%.1f", (num/this.registrations.length));
		}

		return result;
	}

	public int marksOf(String string) {
		int result = -1;
		for (int i = 0; i < this.registrations.length; i++) {
			if (registrations[i].getTitle().equals(string)) {
				result = registrations[i].getMarks();
				break;
			}			
		}
		return result;
	}

	public void addRegistration(Registration r) {
		if (this.registrations.length != 5) {
			increaseRegistrations();
			registrations[registrations.length - 1] = r;			
		}
	}

	public void addRegistration(String name) {
		Registration r = new Registration(name);
		if (this.registrations.length != 5) {
			increaseRegistrations();
			registrations[registrations.length - 1] = r;
		}
	}

	public void updateMarks(String name, int i) {
		for (int j = 0; j < this.registrations.length; j++) {
			if (registrations[j].getTitle().equals(name)) {
				registrations[j].setMarks(i);
				break;
			}
		}
	}

	public void clearRegistrations() {
		Registration[] temp = new Registration[0];
		this.registrations = temp;
	}

}
