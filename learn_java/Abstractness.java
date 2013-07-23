	public static void main (String[] args) {
		System.out.println("Hello!\n");

		// init
		Apple 	_apple = new Apple();
		Banana _banana = new Banana();

		System.out.println("The color of Apple is: " + _apple._color);
		System.out.println("The color of Banana is: " + _banana._color);

		// peeling in action
		_apple.peel();
		_banana.peel();

		Fruits _fruits;
		// thought class Fruit is abstract, it still can be used a ref.
		_fruits = new Apple();
		// class Fruits referring to Apple.
		// _fruits = new Fruits();
		// does not work, because abstract can't be instantiated!

		System.out.println("\nDone.");
	} 
}

abstract class Fruits {
	String _color;
	boolean _isJuicy;
	boolean _hasSkin;

	public void peel () {

	}

	public void squish () {
		_isJuicy = false;
		System.out.println(this.getClass() + " is juiced.");
	}
}

class Apple extends Fruits {
	Apple () {
		_color = "red";
		_isJuicy = true;
		_hasSkin = true;
	}
	public void peel () {
			_hasSkin = false;
		System.out.println(this.getClass() + " is peeled.");
	
	}
}

class Banana extends Fruits {
	Banana () {
		_color = "yellow";
		_isJuicy = false;
		_hasSkin = true;
	}
	public void peel () {
			_hasSkin = false;
		System.out.println("Banana....." + this.getClass() + " is peeled.");
	
	}
}