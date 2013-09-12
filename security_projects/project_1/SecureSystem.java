import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.*;


public class SecureSystem {
	// create ReferenceManager object
	static ReferenceManager ref_mgr = new ReferenceManager();

	public static void main(String[] args) {
		
		// create ObjectManager object
		// ObjectManager obj_mgr = new ObjectManager();
		
		// create subjects with security label
		Subjects dummy1 = new Subjects("Hal", 1);
		Subjects dummy2 = new Subjects("Lyle", 2);

			// inform to ref 
			ref_mgr.addSubj(dummy1);
			ref_mgr.addSubj(dummy2);

		// create objects with security label
		Objects test_doc1 = new Objects("Lobj", 2);
		Objects test_doc2 = new Objects("Hobj", 1);

			// inform to ref
			ref_mgr.addObj(test_doc1);
			ref_mgr.addObj(test_doc2);


		// read command line ########################################################
		System.out.println("Hello!");
		
		System.out.println(args[0]);			
			// open file (name in args[0])

		// create instruction object
		InstructionObject inst_obj = new InstructionObject();

		try {
			File aFile = new File(args[0]);
			
			Scanner sc = new Scanner(aFile);

			while (sc.hasNextLine()) {
				// case-insensitive, lower the case!
				String line = sc.nextLine().toLowerCase();
				System.out.println("From file: " + line);


				// check for illegal commands
				if (check_cmd(line)) {

					Scanner scLine = new Scanner(line);

					// parse command
					inst_obj.set_type(scLine.next());
					inst_obj.set_subj(scLine.next());
					inst_obj.set_obj(scLine.next());

					// exeception-prone (takes last cmd if there is one)
					try {
						inst_obj.set_value(scLine.next());
					}
					catch (NoSuchElementException e){
						System.out.println("\n\n\n");
						System.out.println("Error message: " + e.getMessage());
						e.printStackTrace();
						System.out.println("\n\n\n");
					}
					scLine.close();

					// feed to ReferenceManager
					ref_mgr.validate(inst_obj);

					// print state
					printState();
				}
			}
			sc.close();
		}
		catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
		// done with read command line #############################################



		// testing other classes


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

	public static boolean check_cmd (String line) {
		// must have the length of 3 or 4
		String line_test = line;
		String[] line_arr = line.split("\\s+");
		int line_length = line_arr.length;


		if (line_length < 3 || line_length > 4) {
			// it's a bad instruction!
			BadInstructionObject bad_inst = new BadInstructionObject();

			InstructionObject inst = new InstructionObject();
			inst.set_type("bad");

			// feed to ReferenceManager
		
			return false;
		}

		// must have read or write in the first command
		if ( (line_arr[0].toLowerCase().equals("read")) && (line_arr[0].toLowerCase().equals("write")) ) {
			// it's a bad instruction!
			BadInstructionObject bad_inst = new BadInstructionObject();
			InstructionObject inst = new InstructionObject();
			inst.set_type("bad");
			
			// feed to ReferenceManager

			return false;
		}
		// format = string string string int, where int is optional
		try {
				Integer.parseInt(line_arr[1]);
				// it's a bad instruction!
				BadInstructionObject bad_inst = new BadInstructionObject();
			
				InstructionObject inst = new InstructionObject();
				inst.set_type("bad");
			
				// feed to Reference Manager

				return false;
		}
		catch (Exception e) {
			// it is not an int! good! do nothing
		}

		try {
				Integer.parseInt(line_arr[2]);
				// it's a bad instruction!
				BadInstructionObject bad_inst = new BadInstructionObject();
				InstructionObject inst = new InstructionObject();
				inst.set_type("bad");
			
				// feed to Reference Manager

				return false;
		}
		catch (Exception e) {
			// it is not an int! good! do nothing
		}

		if (line_arr.length == 4)
		{
			try {
				Integer.parseInt(line_arr[3]);
				// it is an int! good! do nothing!

			}
			catch (Exception e) {
				// it's a bad instruction!
				BadInstructionObject bad_inst = new BadInstructionObject();

				InstructionObject inst = new InstructionObject();
				inst.set_type("bad");

				// feed to Reference Manager

				return false;
			}
		}
		return true;
	}

	public static void printState () {
		// iterate through objects array

		// for (Objects i : ref_mgr.obj_arr) {
		// 	i.name = "JESUS";
		// }
		for (Objects i : ref_mgr.obj_arr) {
			System.out.println(i.name + " has value: " + i.current_value);
		}

		// iterate through subjects array
		for (Subjects j : ref_mgr.subj_arr) {
			System.out.println(j.name + " has recently read: " + j.temp);
		}

	}

	public static void testing () throws Exception{
		BadInstructionObject hmm = new BadInstructionObject();
		throw hmm;
	}
}