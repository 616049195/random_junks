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

	public static boolean deleteProfile (String name) {
		File _info = new File("./data/" + name);
		_info.delete();
		return true;	
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

	public static double readProfile (String name) {
		File _info = new File("./data/" + name);
		try {
			Scanner sc = new Scanner(_info);
			System.out.println(sc.nextLine());
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

		Data.createProfile(name);
		Data.editProfile(name, amount);
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

	public Account new_user () {
		Console console = System.console();
		String input = console.readLine("Your name: ");
		Account ac1 = new Account(input);
		System.out.println("Your account has been set up as " + ac1.get_name() + ".");
		return ac1;
	}

	public static Account get_user () {
		// read from the existing file
		Console console = System.console();
		String name = console.readLine("Your name: ");

		double amount = Data.readProfile(name);
		Account ac1 = new Account(name, amount);
		return ac1;
	}
	

	public static void main (String[] args) {

		System.out.println("Enrich is about to make you rich.\n");

		Enrich p1 = new Enrich();
		Account ac1;
		if (Data.isNew()) {
			Data.makeDir();
			ac1 = p1.new_user();
		}
		else {
			ac1 = get_user();
		}

	}
}

