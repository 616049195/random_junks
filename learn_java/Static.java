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
		// you may not access non-static values NOR non static methods.
		int total = infinite;
		
		return stock + infinite;
	}

	public void shout_out () {
		System.out.println("WOW!!!");
	}
}