package model;

public class Store {

	Zone[] zones;
	
	public void addZones(Zone[] input) {
		if (zones == null) {
			this.zones = input;			
		} else {
			int length = this.zones.length + input.length;
			int pos = 0;
			Zone[] temp = new Zone[length];
			for (Zone element : this.zones) {  
				temp[pos] = element;  
				pos++;
			}
			for (Zone element : input) {  
				temp[pos] = element;  
				pos++;  
			} 
			this.zones = temp;
		}
	}

	public Zone[] getZones() {
		return this.zones;
	}

	public int[] getStats(String string) {
		int[] stats = new int[2];
		int zoneAmount = 0;
		int dvdAmount = 0;
		
		for (int i = 0; i < this.zones.length; i++) {
			for (int j = 0; j < this.zones[i].getNumberOfMovieRecords(); j++) {
				if (this.zones[i].records[j].getName().equals(string)) {
					zoneAmount++;
					dvdAmount += this.zones[i].records[j].amount;
				}
			}
		}
		
		stats[0] = zoneAmount;
		stats[1] = dvdAmount;
		
		return stats;
	}

	public Zone[] getZones(int i) {
		int count = 0;
		for (int j = 0; j < this.zones.length; j++) {
			if (this.zones[j].zoneInt - this.zones[j].getNumberOfMovieDVDs() <= i) {
				count++;
			}
		}
		Zone[] temp = new Zone[count];
		count = 0;
		for (int j = 0; j < this.zones.length; j++) {
			if (this.zones[j].zoneInt - this.zones[j].getNumberOfMovieDVDs() <= i) {
				temp[count] = this.zones[j];
				count++;
			}
		}
		return temp;
	}

}
