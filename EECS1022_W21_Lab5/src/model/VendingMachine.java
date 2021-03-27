package model;

public class VendingMachine {

	int[] stockcount = {0, 0, 0, 0}; // [0] is "Coke" | [1] is "Orange Juice" | [2] is "KittyKat"
									// [3] is "Lay's 
	
	String statusquo = "Empty VM Started"; //Default Status for VM
	
	public String checkStatus() {
		return statusquo;
	}	
	
	public String checkStock() {
		String result = "";
		
		result = "Stock: Coke (" + stockcount[0] + "),"
				+ " Orange Juice (" + stockcount[1] + "),"
						+ " Kitkat Chunky Bar (" + stockcount[2] + "),"
								+ " Lay's Classic Chips (" + stockcount[3] + ")";
		
		return result;
	}
	
	public String checkStock(String product) {
		String result = "";
		int i = 0;
		
		if (product.equals("Coke")) {
			i = stockcount[0];
			result = "Coke (" + i  + ")";
		} else if (product.equals("Orange Juice")) {
			i = stockcount[1];
			result = "Orange Juice (" + i  + ")";
		} else if (product.equals("Kitkat Chunky Bar")) {
			i = stockcount[2];
			result = "Kitkat Chunky Bar (" + i  + ")";
		} else if (product.equals("Lay's Classic Chips")) {
			i = stockcount[3];
			result = "Lay's Classic Chips (" + i  + ")";
		} else {
			result = "Invalid product: " + product;
		}
		return result;
	}

	public void add(String string, int i) {
		if (string.equals("Coke")) {
			stockcount[0] += i;
			statusquo = "Product added: Coke (" + i + ")";
		} else if (string.equals("Orange Juice")) {
			stockcount[1] += i;
			statusquo = "Product added: Orange Juice (" + i + ")";
		} else if (string.equals("Kitkat Chunky Bar")) {
			stockcount[2] += i;
			statusquo = "Product added: Kitkat Chunky Bar (" + i + ")";
		} else if (string.equals("Lay's Classic Chips")) {
			stockcount[3] += i;
			statusquo = "Product added: Lay's Classic Chips (" + i + ")";
		} else {
			statusquo = "Invalid product: " + string;
		}
	}

	public void dispense(String string, int i) {
		if (string.equals("Coke")) {
			stockcount[0] -= i;
			statusquo = "Product removed: Coke (" + i + ")";
		} else if (string.equals("Orange Juice")) {
			stockcount[1] -= i;
			statusquo = "Product removed: Orange Juice (" + i + ")";
		} else if (string.equals("Kitkat Chunky Bar")) {
			stockcount[2] -= i;
			statusquo = "Product removed: Kitkat Chunky Bar (" + i + ")";
		} else if (string.equals("Lay's Classic Chips")) {
			stockcount[3] -= i;
			statusquo = "Product removed: Lay's Classic Chips (" + i + ")";
		} else {
			statusquo = "Invalid product: " + string;
		}
	}

}
