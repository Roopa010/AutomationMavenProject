package programs;

public class Program10ArraysLoops {

	public static void main(String[] args) {
		
		int a[] = {12,34,11,36,87,98,93};
					
		for(int i = 0; i < a.length; i++) {
			for(int j = i; j < a.length; j++) {
				if(a[i]> a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

		for(int arr : a)
		System.out.print(arr + " ");
		
		System.out.println();		
		System.out.println("Second largest number : " + a[a.length-2]);
		System.out.println("Third largest number : " + a[a.length-3]);
		
	}

}

