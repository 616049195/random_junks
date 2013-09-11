// import java.lang.Exception;

public final class BadInstructionObject extends Exception {
	final String message = "BadInstructionObject";

	@Override
	public String getMessage () {
		return message;
	}

	public void printWelcome () {
		System.out.println("Hello, welcome to BadInstructionObject final class!");
	}
}