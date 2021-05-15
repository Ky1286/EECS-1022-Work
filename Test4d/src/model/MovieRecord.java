package model;

public class MovieRecord {

	String name;
	int amount;
	Zone zone;
	private static int count = 1;
	int created;
	
	public MovieRecord(String string, int i, Zone z) {
		this.name = string;
		this.amount = i;
		this.zone = z;
		this.created = count;
		count++;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public int getNumberOfDVDs() {
		// TODO Auto-generated method stub
		return this.amount;
	}

	public Zone getZone() {
		// TODO Auto-generated method stub
		return this.zone;
	}

	public String getID() {
		String result =  this.zone.getID() + "-" + this.name +"-" + this.created;
		return result;
	}

}
