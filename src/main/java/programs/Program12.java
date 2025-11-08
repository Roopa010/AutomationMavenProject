package programs;

public class Program12 {

	public static void main(String[] args) {
		String sentence = "Java programming is fun and challenging";
		System.out.println("The total number of words in the sentence : " + sentence.length());
		
		String reverse = "";
		for(int i = sentence.length()-1; i >= 0; i--) {
			reverse = reverse + sentence.charAt(i);
		}
		System.out.println("Reversed order : " +reverse);
		
		String[] words = sentence.split(" ");
		StringBuilder resentence = new StringBuilder();
		
		for(String word : words) {
			if(word.length() > 0) {
				String UppercaseWord = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
				resentence.append(UppercaseWord).append(" ");
			}
		}
		String outcome = resentence.toString().trim();
		System.out.println("Original sentence : " + sentence);
		System.out.println("After converting the first character of each word to uppercase : " + outcome);
	}

}
