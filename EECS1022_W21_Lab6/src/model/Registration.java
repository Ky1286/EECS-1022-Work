package model;

public class Registration {

	String title;
	int marks = 0;
	Instructor prof;
	String[] report = {"F", "Failing"};
	String info;
	
	public Registration(String string) {
		this.title = string;
	}

	public Registration(String string, Instructor instructor) {
		this.title = string;
		this.prof = instructor;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	public int getMarks() {
		// TODO Auto-generated method stub
		return marks;
	}

	public Instructor getInstructor() {
		// TODO Auto-generated method stub
		return prof;
	}

	public String[] getGradeReport() {
		// TODO Auto-generated method stub
		return report;
	}

	public String getInformation() {
		// TODO Set up if statements to change the info variable accordingly
		if (prof != null) {
			this.info = this.title + ", taught by " 
					+ this.prof.getName() + ", is completed with raw marks " 
					+ this.marks + " (" + this.report[0] + " ; " + this.report[1] + ")";
		} else {
			this.info = this.title + " has not yet been assigned an instructor";			
		}

		return info;
	}

	public void setInstructor(Instructor prof) {
		this.prof = prof;
	}

	public void setMarks(int i) {
		this.marks = i;
		if (i < 50) {
			this.report[0] = "F";
			this.report[1] = "Failing";
		} else if (i < 60 && i > 49) {
			this.report[0] = "D";
			this.report[1] = "Passing";
		} else if (i < 70 && i > 59) {
			this.report[0] = "C";
			this.report[1] = "Competent";
		} else if (i < 80 && i > 69) {
			this.report[0] = "B";
			this.report[1] = "Good";		
		} else if (i < 90 && i > 79) {
			this.report[0] = "A";
			this.report[1] = "Excellent";
		} else if (i > 89) {
			this.report[0] = "A+";
			this.report[1] = "Exceptional";
		}
	}

}
