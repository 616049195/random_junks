public class Headfirst {
	public static void main (String[] args) {
			
		System.out.println("HELLO world!");
	
		Toaster t = new Toaster();

		System.out.println("Is the toaster on?: " + t.is_on);
		t.turnOn(10);
		System.out.println("Is the toaster on?: " + t.is_on);

		System.out.println("Done.");
	}
}

class Appliance {
	boolean is_on;

	public int turnOn() {
		is_on = true;
		return 5;
	}

	public int turnOff() {
		is_on = false;
		return 0;
	}
}

class Toaster extends Appliance {
	public int turnOn(int level) {
		is_on = true;
		return level;
	}
}