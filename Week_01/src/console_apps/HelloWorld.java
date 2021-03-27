package console_apps;

public class HelloWorld {

	public static void main(String[] args) {		
		String[] words = new String[0];
		System.out.println(words.length);
		words = new String[3];
		System.out.println(words.length);
	}
	
	public static int compute(int m) {
		int k = 15;
		int b = 0;
		while (b++ < m) {
			k -= 2;
		}
		return k;
	}

}
