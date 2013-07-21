public class Static {
	public static void main (String[] args) {
		System.out.println("Hello!\n");

		System.out.println("Give 3 breads! How many came out? : " + Miracle.give_magic(3));
		// Miracle's static method is available to use without instantiation.

		Miracle _wow = new Miracle();
		_wow.shout_out();

		System.out.println("Number of breads: " + _wow.breads);
		System.out.println("Number of fish: " + _wow.fish);

		System.out.println("Done.\n");
	}
}

class Full {
	String s = "I am full!";

	public void say_out_loud () {
		System.out.println(s);
	}
}

class Miracle {
	int breads;
	int fish;
	static int infinite;

	{
		breads 	= 10;
		fish	= 5;
		// infinite = 10;
		// this compiles, but "infinite" won't set to 10.
	}
	// initializing block

	static {
		infinite = 5000;
		// fish  = 11;
		// won't compile b/c "fish" is NOT static value
	}
	// static initializaing block


	public static int give_magic (int stock) {
		// int total = breads+fish;
		// shout_out();
		// you may not access non-static values NOR non static methods without defining it.
		int total = infinite;

		Full _say = new Full();
		_say.say_out_loud();
		// you may create new object of classes.

		return stock + infinite;
	}

	public void shout_out () {
		System.out.println("WOW!!!");
	}
}

/*
*	Static method cannot use instance variables
*	Marking constructors as private will let you use static methods and keep you away from making a object(ex. Math class)
*	Static variable = ONE variable for class (ONE for ALL instances)
* 	Static variables must be assigned in declaration or in static initializer
*	Final class are NOT allowed to be extended.
* 	Final methods are NOT allowed to be overridden.
* 	Final variable are NOT allowed to be modified.
* 	Final vairable must be assigned at its declaration or during constructor.
*/