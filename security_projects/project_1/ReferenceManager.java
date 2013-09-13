import java.util.ArrayList;

public class ReferenceManager {
	ArrayList<Subjects> subj_arr = new ArrayList<Subjects>();
	ArrayList<Objects> obj_arr = new ArrayList<Objects>();

	// create ObjectManager
	ObjectManager objManager = new ObjectManager();

	// create SecurityLevel
	// SecurityLevel seclvl = new SecurityLevel();

	// creat BadInstructionObject
	BadInstructionObject fail = new BadInstructionObject();

	public ReferenceManager () {

	}

	public ReferenceManager (ObjectManager new_objManager) {
			this.objManager = new_objManager;
	}

	public void createSubj (String subj_name, int lvl) {
		Subjects _subj = new Subjects(subj_name, lvl);
		this.subj_arr.add(_subj);
	}

	public void createObj (String obj_name, int lvl) {
		Objects _obj = new Objects(obj_name, lvl);
		this.obj_arr.add(_obj);
	}

	public void badInst (BadInstructionObject inst) {
		// don't execute...what to do?
		System.out.println(inst.getMessage());
	}

	public void validate (InstructionObject inst) throws Exception {
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
	public void executeRead (String subj, String obj) throws BadInstructionObject {
		// do some tests
		boolean subj_reg = false;
		boolean obj_reg = false;
		boolean dominates = false;

		Subjects sb = new Subjects();
		Objects ob = new Objects();

		int sb_index = -1;
		int ob_index = -1;

		// loop and find a name-match
		for (Subjects i : subj_arr) {
			++sb_index;		
			if (i.name.equals(subj)) {
				subj_reg = true;
				sb = i;
				break;
			}
		}
		for (Objects j : obj_arr) {
			++ob_index;
			if (j.name.equals(obj)) {
				obj_reg = true;
				ob = j;
				break;
			}
		}

		// test#1: do we have both names of subject and object?
		if ( (!subj_reg) || (!obj_reg) ) {
			throw fail;
		}

		// test#2: is simple security property held?
		if (SecurityLevel.simple_security(sb.level, ob.level)) {
			// simply read!
			objManager.read(sb_index, ob_index);
		}
		else {
			subj_arr.get(sb_index).temp = 0;
		}

	}

	public void executeWrite (String subj, String obj, int value) throws BadInstructionObject {
		// do some tests
		boolean subj_reg = false;
		boolean obj_reg = false;
		boolean dominates = false;

		Subjects sb = new Subjects();
		Objects ob = new Objects();

		int sb_index = -1;
		int ob_index = -1;

		// loop through and find a name-match for subject and object names
		for (Subjects i : subj_arr) {
			++sb_index;		
			if (i.name.equals(subj)) {
				subj_reg = true;
				sb = i;
				break;
			}
		}
		for (Objects j : obj_arr) {
			++ob_index;
			if (j.name.equals(obj)) {
				obj_reg = true;
				ob = j;
				break;
			}
		}

		// both name-matches found?
		if ( (!subj_reg) || (!obj_reg))
		{
			throw fail;
		}

		// *-property?
		if (SecurityLevel.star_property(sb.level, ob.level)) {
			objManager.write(sb_index, ob_index, value);
		}

	}

	class ObjectManager {

		public void read (int sb_index, int ob_index) {
			// perform read
			subj_arr.get(sb_index).temp = obj_arr.get(ob_index).current_value;
		}

		public void write(int sb_index, int ob_index, int value) {
			// perform write
			obj_arr.get(ob_index).current_value = value;
		}
	}
}