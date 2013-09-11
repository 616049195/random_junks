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
				String line = sc.nextLine();
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

		InstructionObject test = new InstructionObject();
		test.printWelcome();

		Subjects test1 = new Subjects();
		test1.printWelcome();

		Objects test2 = new Objects();
		test2.printWelcome();

		ReferenceManager test3 = new ReferenceManager();
		test3.printWelcome();

		ObjectManager test4 = new ObjectManager();
		test4.printWelcome();

		BadInstructionObject test5 = new BadInstructionObject();
		test5.printWelcome();



		System.out.println("Done!.");
		// execute commands

		// print states 
	}
}