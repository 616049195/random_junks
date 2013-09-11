import java.util.Scanner;
import java.io.*;


public class SecureSystem {
	public static void main(String[] args) {
		// create subjects with security label

		// create objects with security label

		// read command line
		System.out.println("Hello!");
		
		System.out.println(args[0]);			
			// open file (name in args[0])

		try {
			File aFile = new File(args[0]);
			
			Scanner sc = new Scanner(aFile);

			while (sc.hasNextLine()) {
				// case-insensitive, lower the case!
				String line = sc.nextLine().toLowerCase();
				System.out.println("From file: " + line);

				Scanner scLine = new Scanner(line);
				while (scLine.hasNext()) {
					System.out.println("From file: " + scLine.next());
				}
				scLine.close();
				
			}
		}
		catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}


		// testing other classes

		InstructionObject test = new InstructionObject();
		test.printWelcome();

		Subjects herbert = new Subjects("Herbert", 5);
		herbert.printWelcome();

		Objects secretObj = new Objects("SecretObj", 5);
		secretObj.printWelcome();

		ReferenceManager test3 = new ReferenceManager();
		test3.printWelcome();

		ObjectManager test4 = new ObjectManager();
		test4.printWelcome();

		BadInstructionObject test5 = new BadInstructionObject();
		test5.printWelcome();

		try {
			testing();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}


		System.out.println("Done!.");
		// execute commands

		// print states 
	}

	public static void testing () throws Exception{
		BadInstructionObject hmm = new BadInstructionObject();
		throw hmm;
	}
}