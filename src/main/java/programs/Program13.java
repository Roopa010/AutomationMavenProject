package programs;

public class Program13 {

	public static void main(String[] args) {
		
		String paragraph = "Java is a popular programming language. Java is used for web development, mobile applications, and more.";
		
        String words[] = paragraph.replaceAll("[^a-zA-Z ]","").split(" ");
        int count = 0;
        
        for(int i = 0; i < words.length; i++) {
        	if(words[i].equalsIgnoreCase("Java")) {
        		count++;
        	}
        }
        
        System.out.println("Total number of occurrences of 'Java': " + count);
        
	}

}	
