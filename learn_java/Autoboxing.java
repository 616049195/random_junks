import java.util.*;
public class Autoboxing {
	public static void main (String[] args) {
		System.out.println("Hello!\n");

		Integer _integer = new Integer(1);
		int 	_int     = 5;

		int _test = _integer;
		System.out.println("_test: " + _test);

		_test = _int;
		System.out.println("_test: " + _test);

		_test = 11;
		System.out.println("_test: " + _test);

		//_test takes all of Integer object and int primitive.

		ArrayList<Integer> _list = new ArrayList<Integer>();
		
		_list.add(_integer);
		System.out.println("ArrayList at index 0: " + _list.get(0));

		_list.add(_int);
		System.out.println("ArrayList at index 1: " + _list.get(1));

		_list.add(1000);
		System.out.println("ArrayList at index 2: " + _list.get(2));

		// ArrayList wraps int primitives to Integer objects when adding,
		// and unwraps them into int primitives again when getting.
		// Conversion...casting? is automized with autoboxing.


		String _s1 = "123";
		int _s1Int = Integer.parseInt(_s1);
		System.out.println("_s1Int: " + _s1Int);

		String _s2 = "123.456";
		double _s2Double = Double.parseDouble(_s2);
		System.out.println("_s2Double: " + _s2Double);
		// There are static methods called "parse..." which takes String value and return the value with its primitive type.

		String _s3 = "true";
		boolean _s3Boolean = new Boolean(_s3).booleanValue();
		System.out.println("_s3Boolean: " + _s3Boolean);
		// Boolean doesn't have pasre.
		// Its constructor has ability to take String value and covert into boolean type.

		System.out.println("\nDone.");
	}
}