package PracticeCode;

public class reverseString {

	public static void main(String[] args) {
		method_1();
		//method_2();
	}

	public static void method_1() {
		String s = "sese";
		String rev = "";
		int len = s.length();
		for (int i = len - 1; i >= 0; i--) {
			rev = rev + s.charAt(i);
		}
		System.out.println(rev);
		
		if(rev.equals(s))
		{
			System.out.println("The Word Is Palendrome");
		}
		else {
			System.out.println("The Word is not a Palendrome");
		}
	}
	public static void method_2() {
		String s = "Selenium";
		StringBuffer sf =new StringBuffer(s);
		System.out.println(sf.reverse());
	}
	
}
