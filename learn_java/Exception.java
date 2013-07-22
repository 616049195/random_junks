import java.*;

public class Exception { 
	public static void main (String[] args) {
		System.out.println("Hello!\n");

		Exception exception = new Exception();

		// runtime exception - forcefully checked.
		try {
			exception.risky(1);
		}
		catch (RuntimeException e) {
			System.out.println("BAD BAD!\n");
			e.getMessage();
			e.printStackTrace();
		}
		// custom exception
		try {
			exception.risky_2(1000);
		}
		catch (HoneymoonBabyException e) {
			System.out.println("One shot, one kill!\n");
			e.getMessage();
			e.printStackTrace();
		}

		// catch multiple exceptions (catch exception #1)
		try {
			exception.risky_mult(-5);
			// exception.risky_mult(-15);
			// doesn't get here b/c the rest of try block will be skipped once Exception is thrown.
		}
		catch (RuntimeException e) {
			System.out.println("...exception #1");
			System.out.println("BAD BAD!\n");
			e.getMessage();
			e.printStackTrace();
		}
		catch (HoneymoonBabyException e) {
			System.out.println("...exception #2");
			System.out.println("One shot, one kill!\n");
			e.getMessage();
			e.printStackTrace();
		}

		// catch multiple exceptions (catch exception #2)
		try {
			exception.risky_mult(11);
			// exception.risky_mult(-15);
			// doesn't get here b/c the rest of try block will be skipped once Exception is thrown.
		}
		catch (RuntimeException e) {
			System.out.println("...exception #1");
			System.out.println("BAD BAD!\n");
			e.getMessage();
			e.printStackTrace();
		}
		catch (HoneymoonBabyException e) {
			System.out.println("...exception #2");
			System.out.println("One shot, one kill!\n");
			e.getMessage();
			e.printStackTrace();
		}

		// finally
		try {
			exception.risky(10);
		}
		catch (RuntimeException e) {
			System.out.println("BAD BAD!\n");
			e.getMessage();
			e.printStackTrace();
		}
		finally {
			System.out.println("---This will run no matter what---");
		}

		// finally(s)
		test_finally(exception);

		// exception must be caught from small to large
		// try {
		// 	exception.risky_mult_2(10);
		// }
		// catch (HoneymoonBabyException e) {
		// 	System.out.println("Caught HoneymoonBabyException!");
		// }
		// catch (UnderException e) {
		// 	System.out.println("Caught UnderException!");
		// }

		// find out if UnderException is a subclass of Throwable.
		System.out.println("\n\n");
		UnderException e = new UnderException();
		System.out.println(e.getClass());

		System.out.println(e.hashCode());
		e.getSuper();

		System.out.println("\nDone.");
	}


// ----- end of main ------

	public static void test_finally (Exception exception) {
				// finally with returns in try/catch block
		try {
			exception.risky_2(100);
			return;
		}
		catch (HoneymoonBabyException e) {
			System.out.println("One shot...One kill!");
			e.getMessage();
			e.printStackTrace();
			return;
		}
		finally {
			System.out.println("---See? This still runs...");
		}
	}

	public void risky(int prob) throws RuntimeException {
		if (prob < 99)
		{
			throw new RuntimeException();
		}
	}

	public void risky_2(int prob) throws HoneymoonBabyException {
		if (prob > 20) {
			throw new HoneymoonBabyException();
		}
	}

	public void risky_mult(int prob) throws RuntimeException, HoneymoonBabyException {
		if (prob < 0 ) {
			throw new RuntimeException();
		}

		if (prob > 0) {
			throw new HoneymoonBabyException();
		}
	}

	// public void risky_mult_2 (int prob) throws UnderException, HoneymoonBabyException {
	// 	throw new UnderException();
	// }
}

// make a new Exception class. (same level with Exception class)
class HoneymoonBabyException extends Throwable {
	String _new_message;

	HoneymoonBabyException () {
		_new_message = "You are very STRONG!"; 
	}

	public String getMessage () {
		return _new_message;
	}
}

// make a new Exception class. (under Exception class)
class UnderException extends Exception {
	String _new_message;

	UnderException () {
		_new_message = "Subclass of Exception class.";
	}

	public String getMessage() {
		return _new_message;
	}

	public void getSuper () {
		System.out.println(super.hashCode());
	}
}

/*
//
//
*/