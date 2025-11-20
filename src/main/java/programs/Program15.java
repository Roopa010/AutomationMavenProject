package programs;

public class Program15 {
	
	static boolean isPalindrome(String s) {
		String input = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		String rev = "";
		for(int i=input.length()-1; i>=0; i--) {
			rev = rev + input.charAt(i);
		}
		if(input.equals(rev)) {
			return true;
		} else {
			return false;
		}		
	}

	public static void main(String[] args) {
		
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		System.out.println(s1 + " -> " + isPalindrome(s1));
		System.out.println(s2 + " -> " + isPalindrome(s2));
		
	}

}
