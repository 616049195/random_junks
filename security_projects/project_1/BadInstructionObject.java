// import java.lang.Exception;

public final class BadInstructionObject extends Exception {
	final String message = "Bad Instruction!";

	@Override
	public String getMessage () {
		return message;
	}
}