public class ReferenceManager {
	
	// create ObjectManager
	ObjectManager objManager = new ObjectManager();

	public void executeRead () {
		// do some tests
		
		// if allowed
		objManager.read();

	}

	public void executeWrite () {
		// do some tests for validity
		
		// if allowed
		objManager.write();
	}

	public void printWelcome () {
		System.out.println("Hello, welcome to ReferenceManager class!");
	}
}