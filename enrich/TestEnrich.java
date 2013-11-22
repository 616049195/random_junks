import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class TestEnrich {

	public static String[] checkFiles() {
		File _test = new File("./data/test.txt");
		// try {
		// 	_test.createNewFile();
		// }
		// catch (IOException e) {
		// 	e.printStackTrace();
		// }
		return _test.list();
	}

	public static void main (String[] args) {
		System.out.println("-----------------Test-----------------");

		// check attributes
		Account ac1 = new Account("Test Me");
		assert(ac1.get_name().equals("Test Me"));
		assert(ac1.get_balance() == 0.0);

		ac1.withdraw(10.50);
		assert(ac1.get_balance() == -10.50);
		ac1.deposit(100.25);

		assert(ac1.get_balance() == 89.75);
		ac1.withdraw(0.25);
		assert(ac1.get_balance() == 89.50);
		ac1.withdraw(.25);
		assert(ac1.get_balance() == 89.25);
		ac1.withdraw(1.25);
		assert(ac1.get_balance() == 88.00);
		ac1.withdraw(88);
		assert(ac1.get_balance() == 0);

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



		// test Data / files
		try {
			File _test = new File("./data/Testing");
			assert (_test.createNewFile());
			_test.delete();
			assert (_test.createNewFile());
			_test.delete();

			Data.createProfile("Testing");		
			assert (!_test.createNewFile());

			Data.deleteProfile("Testing");
			assert (_test.createNewFile());
			assert (!_test.createNewFile());

			_test.delete();

			assert (!Data.editProfile("Testing", 2.50));
			assert (_test.createNewFile());
			_test.delete();

			assert (Data.createProfile("Testing"));
			assert (!_test.createNewFile());
			assert (Data.editProfile("Testing", 2.50));
			
			assert (print the file....)
		}
		catch (IOException e) {
			e.printStackTrace();
			assert(false);
		}



		System.out.println("OK.");


	}
}