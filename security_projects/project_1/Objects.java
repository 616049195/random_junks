public class Objects {
	String name;
	int level;
	int current_value;

	public Objects () {
		this.name = "";
		this.level = -1;
		this.current_value = 0;
	}

	public Objects (String name, int level) {
		this.name = name.toLowerCase();
		this.level = level;
		this.current_value = 0;
	}

	public void printWelcome () {
		System.out.println("Hello, welcome to Objects class!");
	}
}