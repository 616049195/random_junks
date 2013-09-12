import java.util.ArrayList;

public class ReferenceManager {
	ArrayList<Subjects> subj_arr = new ArrayList<Subjects>();
	ArrayList<Objects> obj_arr = new ArrayList<Objects>();

	// create ObjectManager
	ObjectManager objManager = new ObjectManager();


	public ReferenceManager () {

	}

	public ReferenceManager (ObjectManager new_objManager) {
			this.objManager = new_objManager;
	}

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
		boolean subj_reg = false;
		boolean obj_reg = false;
		boolean dominates = false;

		Subjects sb = new Subjects();
		Objects ob = new Objects();

		int sb_index = -1;
		int ob_index = -1;

		// test#1 is subject/object registered?
		for (Subjects i : subj_arr) {
			if (i.name.equals(subj)) {
				subj_reg = true;
				sb = i;
			}
			++sb_index;		
		}
		for (Objects j : obj_arr) {
			if (j.name.equals(obj)) {
				obj_reg = true;
				ob = j;
			}
			++ob_index;
		}
		// test#2 subject >= object ?
		if (sb.level <= ob.level) {
			dominates = true;
		}

		// if allowed
		if (subj_reg && obj_reg && dominates) {

			objManager.read(sb_index, ob_index);
		}

	}

	public void executeWrite (String subj, String obj, int value) {
		// do some tests
		boolean subj_reg = false;
		boolean obj_reg = false;
		boolean dominates = false;

		Subjects sb = new Subjects();
		Objects ob = new Objects();

		int sb_index = -1;
		int ob_index = -1;

		// test#1 is subject/object registered?
		for (Subjects i : subj_arr) {
			if (i.name.equals(subj)) {
				subj_reg = true;
				sb = i;
			}
			++sb_index;		
		}
		for (Objects j : obj_arr) {
			if (j.name.equals(obj)) {
				obj_reg = true;
				ob = j;
			}
			++ob_index;
		}
		// test#2 subject >= object?
		if (sb.level >= ob.level) {
			dominates = true;
		}

		// if allowed
		System.out.println("---------------in write, checking for booleans: " + subj_reg + " " + obj_reg + " " + dominates);
// need to fix if statement...
		if (subj_reg && obj_reg && dominates) {
			System.out.println("-----------------------------pass the if statement!");
			objManager.write(sb_index, ob_index, value);
		}

	}

	public void printWelcome () {
		System.out.println("Hello, welcome to ReferenceManager class!");
		System.out.println("Printing objman:");
	}

	class ObjectManager {

		public void read (int sb_index, int ob_index) {
			// perform read
			System.out.println("+++++" + subj_arr.get(sb_index).name + " PERFORMING READ!");
			subj_arr.get(sb_index).temp = obj_arr.get(ob_index).current_value;
		}

		public void write(int sb_index, int ob_index, int value) {
			// perform write
			System.out.println("+++++" + subj_arr.get(sb_index).name + " PERFORMING WRITE!");
			System.out.println("++++++++check the given value: " + value);
			obj_arr.get(ob_index).current_value = value;
			System.out.println("--------value after store: " + obj_arr.get(ob_index).current_value);
		}

		public void printWelcome () {
			System.out.println("Hello, welcome to ObjectManager class!");
		}
	}
}