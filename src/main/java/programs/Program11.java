package programs;

public class Program11 {

	public static void main(String[] args) {
		
		int[] prices = {7,1,5,3,6,4};
		//int[] prices = {7,6,4,3,1};
		
		int min = prices[0];
		int minIndex = 0;
		
		for(int i = 1; i< prices.length; i++) {
			if(prices[i] < min) {
				min = prices[i];
				minIndex = i;
			}
		}
		
		int max = min;
		
		for(int i = minIndex+1; i < prices.length; i++) {
			if(prices[i] > max) {
				max = prices[i];				
			}
		}
		
		System.out.println("Profit : " + (max - min));
	}

}
