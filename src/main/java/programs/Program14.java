package programs;

public class Program14 {

	public static void main(String[] args) {
		int rows = 5;
		
		//rows
		for(int i = 1; i <= rows; i++) {
			for(int space = rows-i; space >0; space--) {
				System.out.print(" ");
			}
			for(int stars = 1; stars <= i; stars++) {
				System.out.print("*");
			}
			System.out.println();
		} 

	}

}
