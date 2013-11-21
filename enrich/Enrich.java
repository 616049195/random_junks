import java.io.Console;



class Account {
	private double _balance = 0;
	private String _name = "";
	private String _id = "";

	// have it take balance by option
	public Account (String name) {
		_name = name;
		// have a random hash? to produce an unique id.

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

