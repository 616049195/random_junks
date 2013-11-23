import java.util.*;

public class FormatSimple {
	public static void main (String[] arg) {
		System.out.println("Hello!\n");

		String s = String.format("%, d", 1000000);
		System.out.println(s);

		s = String.format("I have %,.2f dollars in my bank account.", 100000.00);
		System.out.println(s);

		s = String.format("I work %d, hours per week.", 57);
		System.out.println(s);
		// ,(comma) is shown as a part of String on this one.
		// general format is:
		// % = begin
		// d(or f, etc) for end.

		s = String.format("I get paid for %,d dollars for my %,d hours of work.", 100000, 20);
		System.out.println(s);

		// s = String.format("I get paid for %,d dollars for my %,d hours of work.", 100000);
		// runtime error b/c it only has ONE argument passed...?

		s = String.format("%,6.2f", 10000.000);
		System.out.println(s);

		s = String.format("%d", 10);
		System.out.println(s);

		s = String.format("%.4f", 123.456789);
		System.out.println(s);

		s = String.format("%x", 42);
		System.out.println(s);

		s = String.format("%c", 42);
		System.out.println(s);

		System.out.println("\nMoving on to Dates:");
		
		s = String.format("%tc", new Date());
		System.out.println(s);

		s = String.format("%tr", new Date());
		System.out.println(s);

		Date time = new Date();
		s = String.format("%tA, %tB %td", time, time, time);
		System.out.println(s);

		s = String.format("%tA, %<tB %<td", time);
		System.out.println(s);
		// < means use the previous argument.



		System.out.println("\nDone.");
	}
}

/*
*	General format is :
*	%[argument number][flag][width][.precision]type
*	- everything inside the bracket[] is optional
*/