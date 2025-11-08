package programs;

import java.util.List;
import java.util.stream.Collectors;

public class AvgOfEvenNoStreams {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(10, 15, 20, 25, 30);
		List<Integer> evenNo = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("Even numbers : " + evenNo);

		double sum = evenNo.stream().collect(Collectors.summingDouble(n -> n));
		
		double sum2 = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.summingDouble(n -> n));
		// System.out.println("Sum of Even numbers : " + sum);

		double avg = sum / evenNo.size();
		System.out.println("Average of even numbers : " + avg);

		Double average = evenNo.stream().collect(Collectors.averagingDouble(n -> n));
		System.out.println("Average of even numbers : " + average);

		// long cnt = numbers.stream().collect(Collectors.counting());
		// System.out.println("Count of numbers : " + cnt);
		System.out.println("sum of numbers : " + sum2);
	}

}
