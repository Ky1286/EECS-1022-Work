package console_apps;

public class HelloWorld {

	public static void main(String[] args) {		
		System.out.println(3 < 4 - 1 && !(3 != 4));
	}
	
	public static int compute(int m) {
		int k = 3;
		int b = 0;
		while (b++ < m) {
			k += 3;
		}
		return k;
	}

}
