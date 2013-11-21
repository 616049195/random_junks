public class TestEnrich {
	public static void main (String[] args) {
		System.out.println("-----------------Test-----------------");

		// check attributes
		Account ac1 = new Account("Test Me");
		assert(ac1.get_name().equals("Test Me"));
		assert(ac1.get_balance() == 0.0);


		System.out.println("OK.");


	}
}