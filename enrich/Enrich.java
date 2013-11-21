import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

class Data {
	public static boolean createProfile(String name) {
		// file name should be an unique user id at some point..
		try {
			String content = "Hello!";
			File _info = new File("./data/" + name);
			if (!_info.exists()) {
				_info.createNewFile();
			}
				FileWriter fw = new FileWriter(_info.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(content);
				bw.close();
			return true;
		}	
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean deleteProfile(String name) {
		File _info = new File("./data/" + name);
		_info.delete();
		return true;	
	}

}

class Account {
	private double _balance = 0;
	private String _name = "";
	private String _id = "";

	// have it take balance by option
	public Account (String name) {
		_name = name;
		// have a random hash? to produce an unique id.

		Data.createProfile(name);
		Data.deleteProfile(name);

	}

	public String get_name () {
		return _name;
	}

	public double get_balance () {
		return _balance;
	}

	public void deposit (double amount) {
		_balance += amount;
	}

	public void withdraw (double amount) {
		_balance -= amount;
	}
}

public class Enrich {
	public static void main (String[] args) {
		System.out.println("Enrich is about to make you rich.\n");

		Console console = System.console();
		String input = console.readLine("Your name: ");
		Account ac1 = new Account(input);
		System.out.println("Your account has been set up as " + ac1.get_name() + ".");

	}
}

