package model;

public class Repository {

	Item[] storage;
	
	public Repository(int i) {
		this.storage = new Item[i];
	}

	public Item[] getItems() {
		Item[] temp;
		int count = 0;
		if (storage[0] == null) {
			temp = new Item[0];
		} else {
			for (int i = 0; i < this.storage.length; i++) {
				if (this.storage[i] == null) {
					break;
				} else {
					count++;
				}
			}
			temp = new Item[count];
			for (int i = 0; i < this.storage.length; i++) {
				if (this.storage[i] == null) {
					break;
				} else {
					temp[i] = storage[i]; 
				}
			}
		}
		return temp;
	}

	public Item[] getItems(String[] titles) {
		Item[] temp;
		int count = 0;
		if (this.storage[0] != null) {
			for (int i = 0; i < this.storage.length; i++) {
				for (int j = 0; j < titles.length; j++) {
					if (this.storage[i] == null) {
						break;
					} else if (this.storage[i].getTitle().equals(titles[j])) {
						count++;
					}
				}
			}
			temp = new Item[count];		
			if (count > 0) {
				count = 0;
				for (int i = 0; i < this.storage.length; i++) {
					for (int j = 0; j < titles.length; j++) {
						if (this.storage[i] == null) {
							break;
						} else if (this.storage[i].getTitle().equals(titles[j])) {
							temp[count] = this.storage[i];
							count++;
						}
					}
				}
			}
		} else {
			temp = new Item[0];
		}
		return temp;
	}

	public Item[] getItemsOutsideRange(int upper, int lower) {
		Item[] temp;
		int count = 0;
		if (this.storage[0] != null) {
			for (int i = 0; i < this.storage.length; i++) {
				if (this.storage[i] == null) {
					break;
				} else if (this.storage[i].getAmount() > upper || this.storage[i].getAmount() < lower) {
					count++;
				}
			}
			temp = new Item[count];
			count = 0;
			for (int i = 0; i < this.storage.length; i++) {
				if (this.storage[i] == null) {
					break;
				} else if (this.storage[i].getAmount() > upper || this.storage[i].getAmount() < lower) {
					temp[count] = this.storage[i];
					count++;
				}
			}
		} else {
			temp = new Item[0];
		}
		return temp;
	}

	public int getAmount(String string) {
		int result = -1;
		for (int i = 0; i < this.storage.length; i++) {
			if (this.storage[i] == null) {
				break;
			} else if (this.storage[i].getTitle().equals(string)) {
				result = this.storage[i].getAmount();
			}
		}
		return result;
	}

	public void addItem(Item i1) {
		for (int i = 0; i < this.storage.length; i++) {
			if (this.storage[i] == null) {
				this.storage[i] = i1;
				break;
			} else if (this.storage[i].getTitle().equals(i1.getTitle())) {
				this.storage[i].amount += i1.amount;
				break;
			}
		}
	}

	public void decreaseAmount(String string, int i) {
		for (int j = 0; j < this.storage.length; j++) {
			if (this.storage[j] == null) {
				break;
			} else if (this.storage[j].getTitle().equals(string)) {
				this.storage[j].decreaseAmount(i);
			}
		}
	}	
}
