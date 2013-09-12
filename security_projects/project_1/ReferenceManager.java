public class ReferenceManager {
	
	// create ObjectManager
	ObjectManager objManager = new ObjectManager();


	public void badInst (BadInstructionObject inst) {
		// don't execute...what to do?
	}

	public void set_inst (InstructionObject inst) {
		// valid instructinon.

		if (inst.get_type() == "read") {
				executeRead(inst.get_subj(), inst.get_obj());
		}
		else if (inst.get_type() == "write") {
				executeWrite(inst.get_subj(), inst.get_obj(), inst.get_value());
		}
		else {
			// bad instruction...?

		}
	}

	public void validate () {

	}

	public void executeRead (String subj, String obj) {
		// do some tests

		// if allowed
		objManager.read();

	}

	public void executeWrite (String subj, String obj, int value) {
		// do some tests for validity
		
		// if allowed
		objManager.write();
	}

	public void printWelcome () {
		System.out.println("Hello, welcome to ReferenceManager class!");
	}
}