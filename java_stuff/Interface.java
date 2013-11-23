import java.util.*;

public class Interface {
	public static void main (String[] args) {
		System.out.println("Hello!\n");

		Bag 	_bag = new Bag();
		Backpack _bp = new Backpack();
		Purse _purse = new Purse();

		// inheritance
		System.out.println("Desc. of Backpack (length, width, depth, color): " + _bp._length + " " + _bp._width + " " + _bp._depth + " " + _bp._color);
		System.out.println("Desc. of Purse (length, width, depth, color): " + _purse._length + " " + _purse._width + " " + _purse._depth + " " + _purse._color);

		// interface (only backpack is implemented)
		_bp.enlarge();
		_bp.re_color("Yellow");
		_bp.resize(11);
		_bp.empty_out();

		ArrayList<Crafted> _aList = new ArrayList<Crafted>();
		_aList.add(_bp);
		Crafted _bp2 = _aList.get(0);

		_bp2.resize(1);
		_bp2.re_color("Red");
		// _bp2 knows about methods in Interface Crafted

		// _bp2.put();
		// does not compie. doesn't know about Backpack's methods.

		Backpack _bp3 = (Backpack)_bp2;
		_bp3.put();
		// casting _bp2 back to Backpack works. NOW it knows about Backpack stuffs.


		System.out.println("\nDone.");
	}
}

class Bag {
	boolean _isEmpty;
	int _length;
	int _width;
	int _depth;
	String _color;

	public void put () {
		_isEmpty = false;
		System.out.println("Bag is full.");
	}

	public void take_out () {
		_isEmpty = true;
		System.out.println("Bag is empty.");
	}
}

class Backpack extends Bag implements Crafted, Emptied {
	Backpack () {
		_isEmpty = true;
		_length = 10;
		_width = 5;
		_depth = 15;
		_color = "Black";	
	}

	public void put () {
		_isEmpty = false;
		System.out.println("Backpack is full.");
	}

	public void take_out () {
		_isEmpty = true;
		System.out.println("Backpack is empty.");
	}

	public void enlarge () {
		_depth = 20;
		System.out.println("Backpack is deeper!.");
	}

	public void re_color (String new_color) {
		_color = new_color;
		System.out.println("Backpack is colored as " + new_color);
	}

	public void resize(int new_size) {
		_depth = new_size;
		System.out.println("Backpack has been resized to " + new_size);
	}

	public void empty_out() {
		_isEmpty = true;
		System.out.println("All things in this backpack has been dumpted out.");
	}
}

class Purse extends Bag {
	Purse () {
		_isEmpty = true;
		_length = 3;
		_width = 4;
		_depth = 3;
		_color = "White";
	}
	
	public void put () {
		_isEmpty = false;
		System.out.println("Purse is full.");
	}	

	public void take_out () {
		_isEmpty = true;
		System.out.println("Purse is empty.");
	}
}

interface Crafted {
	public abstract void enlarge ();
	void re_color (String color);
	void resize (int size);
}

interface Emptied {
	void empty_out ();
}


/* 
*	Interface methods must be implemented AS IT IS. -> this includes level of privilege, number of arguments, type, name, etc.
*	Methods in an interface are all public and abstract. Set in stone.
*	Use of "public abstract" during declaration is NOT required. -> NOT recommended either.
* 	Multiple interace is implementable.
*/