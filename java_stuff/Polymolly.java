import java.util.ArrayList;

public class Polymolly {
	public static void main(String[] args) {
		System.out.println("Hello!\n");

		Futball _fb = new Futball();
		TennisBall _tb = new TennisBall();

		System.out.println("Color of futball: " + _fb._color);
		System.out.println("Color of TennisBall: " + _tb._color);

		System.out.println("\nWith Ball type:");
		ArrayList<Ball> _list = new ArrayList<Ball>();
		_list.add(_fb);
		_list.add(_tb);

		System.out.println("List at 0: " + _list.get(0));
		System.out.println("List at 1: " + _list.get(1));
		System.out.println("Get size and color at index 0: " + _list.get(0)._size + " " + _list.get(0)._color);
		System.out.println("Get class at index 1: " + _list.get(1).getClass());
		System.out.println("Get hashcode at index 0: " + _list.get(0).hashCode());

		// TennisBall _tb_ = _list.get(1);
		// this lines does not work b/c ArrayList has Ball type.
		// only Ball or higher type(class) is capable to store this object.
		Ball _tb_ = _list.get(1);
		Object _new_tb_ = _list.get(1);
		
		// _tb_._size;
		// Ball class is not instantiated... so NO remote control? (no NEW) 
		// _new_tb_._size;
		// same here?

		System.out.println("\nWith Object type:");
		ArrayList<Object> _list1 = new ArrayList<Object>();
		_list1.add(_fb);
		_list1.add(_tb);

		System.out.println("List at 0: " + _list1.get(0));
		System.out.println("List at 1: " + _list1.get(1));

		// System.out.println("Get size and color at index 0: " + _list1.get(0)._size + " " + _list1.get(0)._color);
		// Above line does not complie because ArrayList returns Object for its return-type. Object does not know what _size and _color variables are.
		
		System.out.println("Get class at index 1: " + _list1.get(1).getClass());
		// but it knows what is inside ArrayList.
		System.out.println("Get hashcode at index 0: " + _list1.get(0).hashCode());
		// hashCode is universal.

		// Futball _fb_ = _list1.get(0);
		// this shouldn't work b/c _list1 has type Object, and it will return Object type.
		// INCOMPATIBLE TYPE
		Object _ob_ = _list1.get(0);

		// with cast, however, it may go back
		Futball _fb_ = (Futball)_list1.get(0);
		System.out.println(_fb_.getClass());

		// if unsure of it's sublcass, then use instance of
		if (_fb_ instanceof Futball)
			System.out.println("YES!");


		System.out.println("\nDone.");
	}
}

class Ball {
	char _shape = 'r';
	char _size;
	String _color;
}

class Futball extends Ball {
	Futball () {
		_color = "black"; 
		_size = 'm';
	}
}

class TennisBall extends Ball {
	TennisBall () {
		_color = "yellow";
		_size = 's';
	}
}
