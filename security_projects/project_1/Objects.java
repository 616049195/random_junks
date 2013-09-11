public class Objects {
	String name;
	int level;
	int current_value;

	public Objects (String name, int level) {
		this.name = name;
		this.level = level;
		this.current_value = 0;
	}

	public void printWelcome () {
		System.out.println("Hello, welcome to Objects class!");
	}
}