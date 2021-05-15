package model;

public class Zone {

	static int count = 0;
	int zoneInt;
	String zoneID;
	int movieRecords = 0;
	int movieDVDs = 0;
	MovieRecord[] records;
	
	boolean error = false;
	String errorString;
	
	public Zone(int i) {
		// TODO Auto-generated constructor stub
		this.zoneInt = i;
		this.zoneID = "Zone-" + (23 + (11 * count));
		count++;
		this.records = new MovieRecord[i];
	}

	public String getID() {
		return this.zoneID;
	}

	public int getNumberOfMovieRecords() {
		return movieRecords;
	}

	public int getNumberOfMovieDVDs() {
		return movieDVDs;
	}

	public String getStatus() {
		String result = "";
		if (this.error == true) {
			result = this.errorString;
		} else {
			if (this.records[0] == null) {
				result = this.movieRecords + " records and " + this.movieDVDs + " DVDs: {}";			
			} else {
				result = this.movieRecords + " records and " + this.movieDVDs + " DVDs: {";
				for (int i = 0; i < this.movieRecords; i++) {
					result += this.records[i].getName() + " (" + this.records[i].getNumberOfDVDs() + ")";
					if (i + 1 < this.movieRecords) {
						result += ", ";
					}
				}
				result += "}";
			}
		}
		return result;
	}

	public void addMovieRecord(MovieRecord r1) {
		boolean copy = false;
		int spot = 0;
		if (this.movieDVDs + r1.amount > this.zoneInt) {
			if (this.movieDVDs == this.zoneInt) {
				this.error = true;
				this.errorString = "Error: maximum number of movie DVDs (" + this.zoneInt +") reached";				
			} else if (this.movieDVDs < this.zoneInt) {
				this.error = true;
				this.errorString = "Error: insufficient space left in the zone (" + ((this.movieDVDs + r1.amount) - this.zoneInt) +" DVDs short)";
			}
		} else {
			for (int i = 0; i < this.movieRecords; i++) {
				if (this.records[i].getName().equals(r1.getName())) {
					copy = true;
					spot = i;
					break;
				}
			}
			if (copy == false) {
				this.records[movieRecords] = r1;
				this.movieRecords++;
				this.movieDVDs += r1.amount;				
			} else if (copy == true) {
				this.records[spot].amount += r1.amount;
				this.movieDVDs += r1.amount;
			}
		}
	}
	
}
