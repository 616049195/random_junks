public class Abstractness {
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

		System.out.println("\nDone.");
	} 
}

class Fruits {
	String _color;
	boolean _isJuicy;
	boolean _hasSkin;

	public void peel () {
		_hasSkin = false;
		System.out.println(this.getClass() + " is peeled.");
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
}

class Banana extends Fruits {
	Banana () {
		_color = "yellow";
		_isJuicy = false;
		_hasSkin = true;
	}
}