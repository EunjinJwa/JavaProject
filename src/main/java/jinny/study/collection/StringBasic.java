package jinny.study.collection;

public class StringBasic {

	public static void main(String[] args) {
		stringIntern();
	}

	public static void stringIntern() {
		String str1 = "Hello";
		String str2 = "Hello";
		String str3 = new String("Hello");
		String str4 = str3.intern();
		System.out.println(str1 == str2);		// true
		System.out.println(str1 == str3);		// false
		System.out.println(str1 == str4);	// true

		str1 = "Update";
		System.out.println(str1 == str2);		// true
		System.out.println(str1 == str3);		// false
		System.out.println(str1 == str4);	// true


	}


}
