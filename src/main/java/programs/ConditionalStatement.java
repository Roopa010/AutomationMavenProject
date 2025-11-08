package programs;

public class ConditionalStatement {

	public static void main(String[] args) {
	
		String customerName = "John Doe";
		int creditScore = 720;
		float income = 55000.0f;
		boolean isEmployed = true;
		float debtToIncomeRatio = 35.0f;
		
		if(creditScore > 750) {
			System.out.println("The loan is Approved for the Customer " + customerName);
		} else if(creditScore > 650 && creditScore <750) {
			if(income >= 50000) {
				if(isEmployed = true) {
					if(debtToIncomeRatio < 40) {
						System.out.println("The loan is Approved for the Customer " + customerName);
					} else {
						System.out.println("The loan is Rejected");
					}
				} else {
					System.out.println("The loan is Rejected");
				}
			} else {
				System.out.println("The loan is Rejected");
			}
		} else {
			System.out.println("The loan is Rejected");
		}
	}

}
