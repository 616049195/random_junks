import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.*;


public class SecureSystem {
	// create ReferenceManager object
	static ReferenceManager ref_mgr = new ReferenceManager();

	// create instruction object
	static InstructionObject inst_obj = new InstructionObject();

	static String subject_name;
	static String object_name;
	static String main_cmd;
	static int    cmd_value;
	static int    cmd_length;

	public static void main(String[] args) {
		
		// create ObjectManager object
		// ObjectManager obj_mgr = new ObjectManager();
		
		// create subjects with security label
		Subjects dummy1 = new Subjects("Lyle", 2);

		Subjects dummy2 = new Subjects("Hal", 1);

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
		
		// System.out.println(args[0]);			
			// open file (name in args[0])


		try {
			File aFile = new File(args[0]);
			
			Scanner sc = new Scanner(aFile);

			System.out.println("Reading from file: " + args[0] + "\n");


			while (sc.hasNextLine()) {
				// case-insensitive, lower the case!
				String line = sc.nextLine().toLowerCase();


				// check for illegal commands
				if (check_cmd(line)) {

					// System.out.println("-------insde legal cmd!");

					if (cmd_length == 3) {
						System.out.println(subject_name + " " + main_cmd + " " + object_name);
					}
					else {
						System.out.println(subject_name + " " + main_cmd + " value " + cmd_value + " to " + object_name);
					}
					// System.out.println(line);


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
						// System.out.println("Error message: " + e.getMessage());
						// e.printStackTrace();
					}
					scLine.close();

					// feed to ReferenceManager
					try {
						ref_mgr.validate(inst_obj);
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
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


		// execute commands

		// print states 
	}

	public static boolean check_cmd (String line) {
		// must have the length of 3 or 4
		String line_test = line;
		String[] line_arr = line.split("\\s+");
		int line_length = line_arr.length;


		if (line_length != 3 && line_length != 4) {
			// System.out.println("-------------inside test# 1");

			// it's a bad instruction!
			BadInstructionObject bad_inst = new BadInstructionObject();
			
			// set InstructionObject as "bad"
			inst_obj.set_type("bad");

			// feed to BadInstrution to ReferenceManager
			ref_mgr.badInst(bad_inst);


			// System.out.println(Thread.currentThread().getStackTrace().getFileName());
			// System.out.println(Thread.currentThread().getStackTrace().getMethodName());

			// print state
			printState();


			return false;
		}

		// System.out.println("PASSED TEST#1");


		// must have read or write in the first command
		if ( (!line_arr[0].toLowerCase().equals("read")) && (!line_arr[0].toLowerCase().equals("write")) ) {
			
			// System.out.println("-------------inside test# 2");

			// it's a bad instruction!
			BadInstructionObject bad_inst = new BadInstructionObject();			inst_obj.set_type("bad");
			
			// feed to ReferenceManager
			ref_mgr.badInst(bad_inst);

			// print state
			printState();

			return false;
		}

		// System.out.println("PASSED TEST#2");

		// format = string string string int, where int is optional
		try {
	
				// System.out.println("-----------inside try block #1");
				
				Integer.parseInt(line_arr[1]);
				// it's a bad instruction!
				BadInstructionObject bad_inst = new BadInstructionObject();
			
				inst_obj.set_type("bad");
			
				// feed to Reference Manager
				ref_mgr.badInst(bad_inst);
			
				// print state
				printState();

				return false;
		}
		catch (Exception e) {
			// it is not an int! good! do nothing
		}

		// System.out.println("PASSED TEST#3");


		try {
				// System.out.println("-----------inside try block #2");

				Integer.parseInt(line_arr[2]);

				// it's a bad instruction!
				BadInstructionObject bad_inst = new BadInstructionObject();
				inst_obj.set_type("bad");
			
				// feed to Reference Manager
			ref_mgr.badInst(bad_inst);
		
			// print state
			printState();

				return false;
		}
		catch (Exception e) {
			// it is not an int! good! do nothing
		}

		// System.out.println("PASSED TEST#4");


		if (line_arr.length == 4)
		{
			// System.out.println("--------inside the last if (length == 4)");

			if (!line_arr[0].toLowerCase().equals("write")) {

				// System.out.println("-----------inside last if's if.........");

				// it's a "read" command with 4 length. INVALID!
				// it's a bad instruction!
				BadInstructionObject bad_inst = new BadInstructionObject();

				inst_obj.set_type("bad");

				// feed to Reference Manager
				ref_mgr.badInst(bad_inst);
				
				// print state
				printState();

				return false;
			}

			try {
				cmd_value = Integer.parseInt(line_arr[3]);
				// it is an int! good! do nothing!
				// save!
				main_cmd = line_arr[0] + "s";
			}
			catch (Exception e) {
				// last command is  NOT int
				// it's a bad instruction!
				BadInstructionObject bad_inst = new BadInstructionObject();

				inst_obj.set_type("bad");

				
				// feed to Reference Manager
				ref_mgr.badInst(bad_inst);
				
				// print state
				printState();

				return false;
			}
		}
		else {
			if (!line_arr[0].toLowerCase().equals("read")) {

				// System.out.println("-----------inside the ELSE");

				// it's a "read" command with 4 length. INVALID!
				// it's a bad instruction!
				BadInstructionObject bad_inst = new BadInstructionObject();

				inst_obj.set_type("bad");

				// feed to Reference Manager
				ref_mgr.badInst(bad_inst);
				
				// print state
				printState();

				return false;
			}
			main_cmd = line_arr[0] + "s";	
		}
		// System.out.println("++++++++++++++++PASSED ALL TESTS+++++++++++++++++++");

		subject_name = line_arr[1];
		object_name = line_arr[2];
		cmd_length = line_arr.length;

		return true;
	}

	public static void printState () {
		// iterate through objects array

		// for (Objects i : ref_mgr.obj_arr) {
		// 	i.name = "JESUS";
		// }
		System.out.println("The current state is: ");
		for (Objects i : ref_mgr.obj_arr) {
			System.out.println("	" + i.name + " has value: " + i.current_value);
		}

		// iterate through subjects array
		for (Subjects j : ref_mgr.subj_arr) {
			System.out.println("	" + j.name + " has recently read: " + j.temp);
		}
		System.out.println();

	}
}