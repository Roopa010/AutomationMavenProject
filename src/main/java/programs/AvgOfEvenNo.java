package programs;

public class AvgOfEvenNo {

	public static void main(String[] args) {
		
		int[] input = {10, 15, 20, 25, 30};
		
		int sum = 0;
		int count = 0;
		float avg = 0;

		System.out.println("Even numbers : ");
		for(int i = 0; i< input.length; i++) {
			if( input[i] % 2 == 0) {
				System.out.print(input[i] + " ");
				sum += input[i];
				count++;
			}
		}
		System.out.println();
		//System.out.println("Sum of even numbers : " + sum);
		//System.out.println("Count : " + count);
		
		if(count > 0) {
			avg = sum / count;
			System.out.println("Average of even numbers : " + avg);
		} else {
			System.out.println("No even numbers found");
		}
	}

}
