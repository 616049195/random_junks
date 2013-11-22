import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class TestEnrich {

	// @Test
	public static void testAccountInit () {
		Account ac1 = new Account("Test Me");
		assert(ac1.get_name().equals("Test Me"));
		assert(ac1.get_balance() == 0.0);
	}

	// @Test
	public static void testDeposit (Account ac1) {
		// ac1 has $0.00
		ac1.deposit(0.25);
		assert(ac1.get_balance() == 0.25);
		ac1.deposit(.25);
		assert(ac1.get_balance() == .50);
		ac1.deposit(100);
		assert(ac1.get_balance() == 100.50);
		ac1.deposit(0.00);
		assert(ac1.get_balance() == 100.50);
		ac1.deposit(100000.50);
		assert(ac1.get_balance() == 100101.00);
	}

	// @Test
	public static void testWithdraw (Account ac1) {
		// ac1 has $0.00
		ac1.withdraw(100.00);
		assert(ac1.get_balance() == -100.00);
		ac1.withdraw(0.25);
		assert(ac1.get_balance() == -100.25);
		ac1.withdraw(1.25);
		assert(ac1.get_balance() == -101.50);
		ac1.withdraw(.50);
		assert(ac1.get_balance() == -102.00);
		ac1.withdraw(8);
		assert(ac1.get_balance() == -110.00);
		ac1.withdraw(-110);
		assert(ac1.get_balance() == 0);
	}

	// @Test
	public static void testDataFile () {
		// test Data / files
		try {
			File _test = new File("./data/Testing");

			// tests for create
			assert (_test.createNewFile());
			_test.delete();
			assert (_test.createNewFile());
			_test.delete();
			Data.createProfile("Testing");		
			assert (!_test.createNewFile());

			// tests for delete
			Data.deleteProfile("Testing");
			assert (_test.createNewFile());
			assert (!_test.createNewFile());
			_test.delete();

			// tests for read
			assert (Data.createProfile("Testing"));
			assert (!_test.createNewFile());
			assert (Data.editProfile("Testing", 2.50));	
			assert (Data.readProfile("Testing") == 2.50);	
			assert (Data.editProfile("Testing", 12.50));	
			assert (Data.readProfile("Testing") == 12.50);	
			assert (Data.editProfile("Testing", -100.00));	
			assert (Data.readProfile("Testing") == -100.00);	
			_test.delete();

			// tests for edit
			assert (!Data.editProfile("Testing", 2.50));
			assert (_test.createNewFile());
			_test.delete();

			assert (Data.createProfile("Testing"));
			assert (!_test.createNewFile());
			assert (Data.editProfile("Testing", 2.50));
			testFileOutput("2.5");

			assert (Data.createProfile("Testing"));
			assert (!_test.createNewFile());
			assert (Data.editProfile("Testing", -12.50));
			testFileOutput("-12.5");

			assert (Data.createProfile("Testing"));
			assert (!_test.createNewFile());
			assert (Data.editProfile("Testing", 0.00000000));
			testFileOutput("0.0");

		}
		catch (IOException e) {
			e.printStackTrace();
			assert(false);
		}
	}

	// @Test
	public static void testFileOutput (String expected_double) {
		try {
			File _test = new File("./data/Testing");
			Scanner sc = new Scanner(_test);

			assert ("Testing".equals(sc.nextLine()));
			assert (expected_double.equals(sc.nextLine()));	

			sc.close();
			_test.delete();
		}
		catch (IOException e) {
			e.printStackTrace();
			assert(false);
		}
	}

	public static void main (String[] args) {
		System.out.println("-----------------Test-----------------");

		testDataFile();

		testAccountInit();

		// check functions
		Account ac1 = new Account("Test Me");
		testWithdraw(ac1);
		testDeposit(ac1);


	
		// clean up
		Data.deleteProfile("Test Me");
		System.out.println("OK.");


	}
}