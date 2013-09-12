public class InstructionObject {
	private String inst_type;
	private String subj_name;
	private String obj_name;
	private int value;

	// setters (required...for now)
	public void set_type (String s) {
		this.inst_type = s;
	}

	public void set_subj (String s) {
		this.subj_name = s;
	}

	public void set_obj (String s) {
		this.obj_name = s;
	}

	public void set_value (String s) {
		int v = Integer.parseInt(s);
		this.value = v;
	}

	// getters (yeah...lame)
	public String get_type () {
		return this.inst_type;
	}

	public String get_subj () {
		return this.subj_name;
	}

	public String get_obj () {
		return this.obj_name;
	}

	public int get_value () {
		return this.value;
	}


	public void printWelcome(){
		System.out.println("Hello, Welcome to InstructionObject class!");
		
	}
}