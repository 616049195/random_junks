public class Constructors {
	public static void main (String[] args) {
		System.out.println("Hello!\n");



		Bluetooth_Keyboard _kb = new Bluetooth_Keyboard(100);
		System.out.println("Is it available? " + _kb._available);
		System.out.println("How many are there? " + _kb._stock);

		_kb.sell();
		_kb.sell();		

		System.out.println(_kb._logo);
		// System.out.println("Sales review: " + _kb._sales);
		// _sales is private, so it is NOT accessible by its children.

		_kb.get_sales();

		Cute_Mouse _mouse = new Cute_Mouse(50);
		_mouse.sell();
		_mouse.sell();
		_mouse.get_sales();

		System.out.println("Apple's sale total: ");
		_mouse.get_sales();

		Pretty_Monitor _pm = new Pretty_Monitor();
		// goes to default constructor, but runs real constructor, THEN finshes the default.

		Pretty_Monitor _pm1 = new Pretty_Monitor(1000);
		// goes to real and runs real constructor.

		System.out.println("\nDone.");
	}
}

class Apple {
	String _logo = "Apple";
	boolean _isEaten = false;
	String _ceo = "Steve Jobs";
	boolean _available;
	
	private static int _sales;

	public void get_sales () {
		System.out.println("Sales review: " + _sales);
	}

	public void abandon_jobs () {
		_ceo = "Not Steve Jobs";
		System.out.println("Apple's stock price is dropping low!");
	}

	public void sell () {
		_sales += 1;
		System.out.print("Sold! ");		
	}

}

class Bluetooth_Keyboard extends Apple {
	int _stock;

	public Bluetooth_Keyboard (int stock) {
		_stock = stock;
		_available = true;
	}

	public void sell () {
		super.sell();
		// get the Apple's sell run first.
		_stock -= 1;
		System.out.println(_stock + " keyboards in stock.");
	}
}

class Cute_Mouse extends Apple {
	int _stock;

	public Cute_Mouse (int stock) {
		_stock = stock;
		_available = true;
	}

	public void sell () {
		super.sell();
		_stock -= 1;
		System.out.println(_stock + "mouse are in stock.");
	}
}

class Pretty_Monitor extends Apple {
	int _stock;

	public Pretty_Monitor () {
		this(0);
		System.out.println("----------running default constructor of Pretty_Monitor.");
	}

	public Pretty_Monitor (int stock) {
		_stock = stock;
		_available = true;
		System.out.println("----------running real constructor of Pretty_Monitor.");
	}
}

/*
*	Java provides a default contructor only if you don't make a constructor(s) of your own
*	Constructors can be overloaded.
*	Once you have provided a constructor of your own, your default constructor is gone.
*	Argument order and number matters, name does not.
* 	All of superclass (parent's) constructors are called when creating an object of the inherited class. 
*	Constructor are called when you create an object (typing "new").
*	Even abstract classes have constructors. Though it can't be instantiated alone, its constructors run when its CONCRETE subclass object is created.
*	Unlike C++, Java has no default arguments when passing arguments to method/constructor.
*/