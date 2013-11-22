import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

class Data {
	// things to do //
	// 1. must create directory when visited for the first time...
	//


	public static boolean createProfile (String name) {
		// file name should be an unique user id at some point..
		try {
			File _info = new File("./data/" + name);
			if (!_info.exists()) {
				_info.createNewFile();
			}
			FileWriter fw = new FileWriter(_info.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(name+"\n");	
			bw.write(String.valueOf(0.0));
			bw.close();

			return true;
		}	
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean editProfile (String name, double amount) {
		// file name should be an unique user id at some point..
		try {
			File _info = new File("./data/" + name);
			if (!_info.exists()) {
				return false;
			}

			FileWriter fw = new FileWriter(_info.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(name+"\n");
			bw.write(String.valueOf(amount));
			bw.close();
			return true;
		}	
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean deleteProfile (String name) {
		File _info = new File("./data/" + name);
		_info.delete();
		return true;	
	}

	public static double readProfile (String name) {
		File _info = new File("./data/" + name);
		try {
			Scanner sc = new Scanner(_info);
			sc.nextLine();
			double amount = Double.parseDouble(sc.nextLine());
			sc.close();
			return amount;
		} catch (Exception e) {
			e.printStackTrace();
			return -1.0;
		}
	}

	public static boolean printProfile (String name) {
		
		try {
			File _info = new File("./data/" + name);
			Scanner sc = new Scanner(_info);

			System.out.println("--------------------\n" + "Printing a profile for " + name);
			System.out.println("Name: " + sc.nextLine());
			System.out.println("Amount: " + sc.nextLine());
			System.out.println("------ Done. -------");
			sc.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean isNew () {
		try {
			File _dir = new File("./data");
			if (_dir.list().length == 0) {
				return true;
			}
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}


	public static void makeDir () {
		File _dir = new File("./data");
		_dir.mkdir();
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
	}

	public Account (String name, double amount) {
		_name = name;
		// have a random hash? to produce an unique id.

		assert (Data.createProfile(name));
		assert (Data.editProfile(name, amount));
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

	public void write () {
		// assert (_name.equals("Hyunchel Kim"));
		// assert (_balance == 200.00);
		assert (Data.editProfile(_name, _balance));
	}
}


public class Enrich {

	public Account new_user () {
		Console console = System.console();
		String input = console.readLine("Your name: ");
		Account ac1 = new Account(input);
		System.out.println("Your new account has been set up as " + ac1.get_name() + ".\n");
		return ac1;
	}

	public Account get_user () {
		// read from the existing file
		Console console = System.console();
		String name = console.readLine("Your name: ");

		double amount = Data.readProfile(name);
		Account ac1 = new Account(name, amount);
		System.out.println("Amount stored: " + ac1.get_balance());
		System.out.println("Your account has been loaded.\n");
		return ac1;
	}
	
	public int show_menu () {
		// show options - use enum..?
		
		// 1. See your balance
		// 2. Deposit
		// 3. Withdraw
		// 4. Exit

		System.out.println(	"Options\n"
						+	"1) See your balance\n"
						+	"2) Deposit\n"
						+	"3) Withdraw\n"
						+	"4) Exit\n");				

		Console console = System.console();
		String input = console.readLine("Choose your action: ");
		return Integer.parseInt(input);
	}

	public static void main (String[] args) {

		System.out.println("Enrich is about to make you rich.\n");

		Enrich rich = new Enrich();
		Account ac1;
		if (Data.isNew()) {
			Data.makeDir();
			ac1 = rich.new_user();
		}
		else {
			ac1 = rich.get_user();
			System.out.println(ac1.get_balance());
			// assert (ac1.get_balance() == 200.00);
		}

		int action = 0;

		action = rich.show_menu();
		Console console = System.console();
		double amount = 0;

		switch (action) {
			case 1: System.out.println(ac1.get_balance());
				break;
			case 2: amount = Double.parseDouble(console.readLine("Amount to deposit: "));
				System.out.println("HIHI");
				ac1.deposit(amount);
				break;
			case 3: amount = Double.parseDouble(console.readLine("Amount to withdraw: "));
				System.out.println("HIHI");
				ac1.withdraw(amount);
				break;
			case 4: 
				break;
			default: System.out.println("Not a valid input.");	
				break;
		}	
		ac1.write();


		amount = Double.parseDouble(console.readLine("Amount to deposit: "));
		System.out.println(ac1.get_balance());
	}
}

