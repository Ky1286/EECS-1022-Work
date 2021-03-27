package model;

public class Item {

	String name;
	int amount = 0;
	String info;
	
	public Item(String string) {
		this.name = string;
	}

	public String getTitle() {
		return this.name;
	}

	public int getAmount() {
		return this.amount;
	}

	public Object getInfo() {
		if (info == null) {
			this.info = "Item: " + name +" (" + amount + ")";
		}
		return this.info;
	}

	public void increaseAmount(int i) {
		if (i <= 0) {
			this.info = "Error: non-positive amount " + i;
		} else {
			this.amount += i;
			this.info = "Item: " + this.name +" (" + this.amount + ")";
		}
	}

	public void decreaseAmount(int i) {
		if (i <= 0) {
			this.info = "Error: non-positive amount " + i;
		} else if (this.amount - i < 0) {
			this.info = "Error: amount is short of " + ((this.amount - i) * -1);
		} else {
			this.amount -= i;
			this.info = "Item: " + this.name +" (" + this.amount + ")";
		}
	}

}
