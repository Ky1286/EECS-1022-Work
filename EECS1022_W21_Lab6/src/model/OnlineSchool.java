package model;

public class OnlineSchool {

	Participant[] list = new Participant[0];
	
	public Participant[] getParticipants(String string) {
		Participant[] partList = new Participant[0];
		int count = 0;
		if (this.list.length != 0) {
			for (int i = 0; i < list.length; i++) {
				for (int j = 0; j < this.list[i].getRegistrations().length; j++) {
					if (this.list[i].getRegistrations()[j].getTitle().equals(string)) {
						count++;
					}
				}
			}
			partList = new Participant[count];
			count = 0;
			for (int i = 0; i < list.length; i++) {
				for (int j = 0; j < this.list[i].getRegistrations().length; j++) {
					if (this.list[i].getRegistrations()[j].getTitle().equals(string)) {
						partList[count] = this.list[i];
						count++;
					}
				}
			}	
		}
		return partList;
	}

	public void increaseParticipants() {
		Participant[] temp = new Participant[this.list.length + 1];
		for (int i = 0; i < this.list.length; i++) {
			temp[i] = this.list[i];
		}
		this.list = temp;
	}
	
	public void addParticipant(Participant name) {
		increaseParticipants();
		list[this.list.length - 1] = name;
	}

}
