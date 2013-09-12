import java.util.ArrayList;

public class ReferenceManager {
	ArrayList<Subjects> subj_arr = new ArrayList<Subjects>();
	ArrayList<Objects> obj_arr = new ArrayList<Objects>();


	// create ObjectManager
	ObjectManager objManager = new ObjectManager();


	public void addSubj (Subjects subj) {
		this.subj_arr.add(subj);
	}

	public void addObj (Objects obj) {
		this.obj_arr.add(obj);
	}

	public void badInst (BadInstructionObject inst) {
		// don't execute...what to do?
	}

	public void validate (InstructionObject inst) {
		// valid instructinon?

		if (inst.get_type().equals("read")) {
				executeRead(inst.get_subj(), inst.get_obj());
		}
		else if (inst.get_type().equals("write")) {
				executeWrite(inst.get_subj(), inst.get_obj(), inst.get_value());
		}
		else {
			// bad instruction...?

		}
	}


	public void executeRead (String subj, String obj) {
		// do some tests
		for (Subjects i : subj_arr) {
			System.out.println(i.name);
		}
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