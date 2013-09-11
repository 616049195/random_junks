public class Subjects {
	String name;
	int level;
	int temp;

	public Subjects (String name, int level) {
		this.name = name;
		this.level = level;
		this.temp = 0;
	}

	public void printWelcome () {
		System.out.println("Hello, welcome to Subjects class!");

	}
}